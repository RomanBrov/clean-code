package org.robotdreams.patterns.lesson12.theory;

import java.util.*;

public class ObserverDemo {
    public void start() {
        System.out.println("Starting Observer Demo");

        ProductRepositoryWithNotification repositoryWithNotification = new ProductRepositoryWithNotification();

        repositoryWithNotification.getEventManager().subscribe("add", new ConsoleEventListener());
        repositoryWithNotification.getEventManager().subscribe("add", new AuditEventListener());
        repositoryWithNotification.getEventManager().unsubscribe("add", new AuditEventListener());

        repositoryWithNotification.add(new Product(1, "Red", "Apple", 2.5));
        repositoryWithNotification.add(new Product(2, "Yellow", "Apple", 2.8));
        repositoryWithNotification.add(new Product(3, "Green", "Apple", 2.2));

        // CartRepository cartRepository = CartRepository();
        // TODO: imitate cascade updates

        System.out.println();
    }
}

class EventManager {
    private final Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, String message) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, message);
        }
    }
}

interface EventListener {
    void update(String eventType, String message);
}


class ProductRepositoryWithNotification {

    private final EventManager eventManager = new EventManager("add", "delete", "update");

    private final List<Product> products = new ArrayList<>();

    public void add(Product product) {
        products.add(product);
        eventManager.notify("add", "Product %s %s added".formatted(product.getType(), product.getColor()));
    }

    public EventManager getEventManager() {
        return eventManager;
    }
}

class ConsoleEventListener implements EventListener {

    @Override
    public void update(String eventType, String message) {
        System.out.printf("Notifying Console about %s for event %s %n", message, eventType);
    }
}

class AuditEventListener implements EventListener {
    @Override
    public void update(String eventType, String message) {
        System.out.printf("Notifying Audit about %s for event %s %n", message, eventType);
    }
}