package me.eren.chiroptera.core.events.server;

public record ClientDisconnectEvent(String identifier, boolean isTimedOut) {
}
