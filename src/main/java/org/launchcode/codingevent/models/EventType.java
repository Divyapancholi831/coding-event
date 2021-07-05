package org.launchcode.codingevent.models;

public enum EventType {
    CONFERENCE("Conference"),
    MEETUP("Meetup"),
    SOCIAL("Social"),
    WORKSHOP("workshop");

    private final String displayName;

    EventType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
