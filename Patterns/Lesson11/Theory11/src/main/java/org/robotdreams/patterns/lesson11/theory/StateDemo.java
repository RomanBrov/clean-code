package org.robotdreams.patterns.lesson11.theory;

public class StateDemo {
    public void start() {
        System.out.println("↓↓↓↓");
        System.out.println("Starting State pattern Demo");

        ConnectionWithoutState withoutState = new ConnectionWithoutState();
        withoutState.open();
        withoutState.open();
        withoutState.close();
        withoutState.close();
        System.out.println();

        ConnectionWithState withState = new ConnectionWithState();
        withState.open();
        withState.open();
        withState.close();
        withState.close();

        System.out.println("↑↑↑↑");
        System.out.println();
    }
}

class ConnectionWithoutState {
    private ConnectionStatus status;

    public ConnectionWithoutState() {
        status = ConnectionStatus.CLOSED;
        System.out.println("Connection Without State initialized");
    }

    public void open() {
        if (status == ConnectionStatus.CLOSED) {
            openInternal();
        } else if (status == ConnectionStatus.OPENED) {
            System.out.println("The connection is already opened");
        }
    }

    public void close() {
        if (status == ConnectionStatus.CLOSED) {
            System.out.println("The connection is already closed");
        } else if (status == ConnectionStatus.OPENED) {
                closeInternal();
        }
    }

    private void openInternal() {
        System.out.println("Opening connection");
        status = ConnectionStatus.OPENED;
        // TODO: add delay to imitate long operation
        System.out.println("Connected");
    }

    private static void connectingInternal() {
        System.out.println("Connection is in progress");
    }

    private void closeInternal() {
        System.out.println("Closing connection");
        status = ConnectionStatus.CLOSED;
        // TODO: add delay to imitate long operation
        System.out.println("Closed");
    }

    enum ConnectionStatus {
        CLOSED,
        OPENED
    }
}

class ConnectionWithState {
    protected ConnectionState connectionState;

    public ConnectionWithState() {
        connectionState = new ClosedState(this);

        System.out.println("Connection With State initialized");
    }

    public void open() {
        connectionState.open();
    }

    public void close() {
        connectionState.close();
    }

    abstract class ConnectionState {
        protected final ConnectionWithState connection;

        protected ConnectionState(ConnectionWithState connection) {
            this.connection = connection;
        }

        abstract void open();

        abstract void close();
    }

    class ClosedState extends ConnectionState {
        protected ClosedState(ConnectionWithState connection) {
            super(connection);
        }

        @Override
        void open() {
            System.out.println("Opening connection");
            ConnectionState newState = new OpenedState(connection);
            connection.connectionState = newState;
            System.out.println("Connected");
        }

        @Override
        void close() {
            System.out.println("The connection is already closed");
        }
    }

    class OpenedState extends ConnectionState {
        protected OpenedState(ConnectionWithState connection) {
            super(connection);
        }

        @Override
        void open() {
            System.out.println("The connection is already opened");
        }

        @Override
        void close() {
            System.out.println("Closing connection");
            ConnectionState newState = new ClosedState(connection);
            connection.connectionState = newState;
            System.out.println("Closed");
        }
    }
}




