package me.eren.chiroptera.core.handlers.server;

import com.google.common.eventbus.Subscribe;
import me.eren.chiroptera.core.Chiroptera;
import me.eren.chiroptera.core.ChiropteraServer;
import me.eren.chiroptera.core.packets.DisconnectPacket;
import me.eren.chiroptera.core.events.PacketReceivedEvent;
import me.eren.chiroptera.core.events.server.ClientDisconnectEvent;

import java.io.IOException;

public class ServerDisconnectHandler {
    @Subscribe
    public void handleClientDisconnect(PacketReceivedEvent e) {
        if (e.packet() instanceof DisconnectPacket) {
            try {
                ChiropteraServer.authenticatedClients.get(e.clientIdentifier()).close();
                ChiropteraServer.authenticatedClients.remove(e.clientIdentifier());
                Chiroptera.getLogger().info("Client " + e.clientIdentifier() + " disconnected.");

                ClientDisconnectEvent event = new ClientDisconnectEvent(e.clientIdentifier(), false);
                Chiroptera.getEventBus().post(event);
            } catch (IOException ignored) {}
        }
    }
}
