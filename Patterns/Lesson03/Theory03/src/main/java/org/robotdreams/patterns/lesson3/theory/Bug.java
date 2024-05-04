package org.robotdreams.patterns.lesson3.theory;

// TODO: Extract interface
// TODO: Create subclass
// TODO: Replace inheritance with delegation
public class Bug  {
    private long id; // TODO: rename "id" to "identifier" including methods
    private String description;
    private int severity;

    public Bug(long id, String description, int severity) {
        this.id = id;
        this.description = description;
        this.severity = severity;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getSeverity() {
        return severity;
    }
}
