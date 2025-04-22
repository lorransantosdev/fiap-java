package org.example.model;

import java.util.Date;

public class Attendance {
    private final Date date;
    private final String description;

    public Attendance(String description) {
        this.date = new Date();
        this.description = description;
    }

    public Date getDate() { return date; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return String.format("%s - %s", date.toString(), description);
    }
}