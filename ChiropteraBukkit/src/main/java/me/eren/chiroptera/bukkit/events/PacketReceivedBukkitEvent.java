package me.eren.chiroptera.bukkit.events;

import me.eren.chiroptera.core.Packet;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PacketReceivedBukkitEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();
    private final Packet packet;
    private final String clientIdentifier;

    public PacketReceivedBukkitEvent(Packet packet, String clientIdentifier) {
        this.packet = packet;
        this.clientIdentifier = clientIdentifier;
    }

    public Packet getPacket() {
        return this.packet;
    }

    public String getClientIdentifier() {
        return this.clientIdentifier;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }
}
