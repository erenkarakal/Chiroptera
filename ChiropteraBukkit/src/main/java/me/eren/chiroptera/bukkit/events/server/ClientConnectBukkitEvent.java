package me.eren.chiroptera.bukkit.events.server;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ClientConnectBukkitEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();
    private final String identifier;

    public ClientConnectBukkitEvent(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }
}
