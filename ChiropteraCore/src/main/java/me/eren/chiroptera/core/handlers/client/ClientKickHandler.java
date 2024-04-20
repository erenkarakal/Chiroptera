package me.eren.chiroptera.core.handlers.client;

import com.google.common.eventbus.Subscribe;
import me.eren.chiroptera.core.Chiroptera;
import me.eren.chiroptera.core.ChiropteraClient;
import me.eren.chiroptera.core.events.PacketReceivedEvent;
import me.eren.chiroptera.core.packets.KickPacket;

public class ClientKickHandler {
    @Subscribe
    public void handleKickPacket(PacketReceivedEvent e) {
        if (e.packet() instanceof KickPacket kickPacket) {
            ChiropteraClient.disconnect();
            Chiroptera.getLogger().warning("Got kicked by the server. Reason: " + kickPacket.getReason());
        }
    }
}
