package org.robotdreams.patterns.lesson11.theory;

import java.util.ArrayList;

public class MediatorDemo {
    public void start() {
        System.out.println("↓↓↓↓");
        System.out.println("Starting Mediator pattern Demo");

        Person person1 = new Person("Rick");
        Person person2 = new Person("Morty");

        person1.sendMessage("Hello, Morty", person2);
        person1.sendMessage("Hello, Rick", person1);
        person1.deleteMessage(123, 555);

        Kingdom kindgom1 = new Kingdom("dreamers");
        kindgom1.addPerson(person1);
        kindgom1.addPerson(person2);
        kindgom1.sendToAll("Hello, dear dwellers! Welcome to the kingdom");

        System.out.println("↑↑↑↑");
        System.out.println();
    }
}

interface MessageEndpoint {
    void receiveMessage(MessageEndpoint from, String message);

    void receiveFile(MessageEndpoint from, String url);

    String getSenderName();
}

class Person implements MessageEndpoint {
    private final String nickName;
    private final Mediator mediator;

    public Person(String nickName) {
        this.nickName = nickName;
        this.mediator = new Mediator(this);

        System.out.println("Person " + nickName + " initialized");
    }

    public void sendMessage(String message, Person to) {
        mediator.sendMessage(message, to);
    }

    public void sendFile(String url, Person to) {
        mediator.sendFile(url, to);
    }

    public void deleteMessage(int messageId, int chatId) {
        System.out.println("message deletion is not implemented");
    }

    @Override
    public void receiveMessage(MessageEndpoint from, String message) {
        System.out.println(ConsoleColors.YELLOW + message + " from " + from.getSenderName() + ConsoleColors.RESET);
    }

    @Override
    public void receiveFile(MessageEndpoint from, String url) {
        System.out.println(url + " from " + from.getSenderName());
    }

    @Override
    public String getSenderName() {
        return nickName;
    }
}

class Kingdom implements MessageEndpoint {

    private final String kingdomName;
    private final Mediator mediator;
    private ArrayList<Person> allPersons = new ArrayList<>();

    public Kingdom(String kingdomName) {
        this.kingdomName = kingdomName;
        this.mediator = new Mediator(this);

        System.out.println("Kingdom " + kingdomName + " initialized");
    }

    public void addPerson(Person person) {
        allPersons.add(person);
    }

    public void sendToAll(String message) {
        for (Person person: allPersons             ) {
            mediator.sendMessage(message, person);
        }
    }

    @Override
    public void receiveMessage(MessageEndpoint from, String message) {
        System.out.println("receiving messages is not implemented");
    }

    @Override
    public void receiveFile(MessageEndpoint from, String url) {
        System.out.println("receiving files is not implemented");
    }

    @Override
    public String getSenderName() {
        return kingdomName;
    }
}

class Mediator {
    private MessageEndpoint messageEndpoint;

    public Mediator(MessageEndpoint messageEndpoint) {
        this.messageEndpoint = messageEndpoint;
    }

    public void sendMessage(String message, Person to) {
        System.out.println(ConsoleColors.WHITE + "Sending message from " + messageEndpoint.getSenderName() + " to " + to.getSenderName());

        System.out.println("Checking rate limit...");
        // rateLimiter.check();
        System.out.println("Rate limit check passed...");

        // loggerService.log();
        System.out.println("Logging request...");

        // tracingService.trace("messageSent", message.length(), person.getIdentifier());
        System.out.println("Saving trace data...");

        // if(checkService.isBanned(to)) return;
        System.out.println("Checking target is banned...");

        // message = obsceneService.escapeWords(message);
        System.out.println("Escaping obscene words...");

        // retry logic
        // db.saveNewMessage(message, person, to);
        System.out.println("Saving message to the database...");

        // if failed
        // // notify to the sender
        // else
        // // pushservice.Notify(to, message);
        System.out.println("Notifying target about new message..." + ConsoleColors.RESET);

        to.receiveMessage(messageEndpoint, message); // this line imitates message sending without a queue
    }

    public void sendFile(String url, Person to) {
    }
}

