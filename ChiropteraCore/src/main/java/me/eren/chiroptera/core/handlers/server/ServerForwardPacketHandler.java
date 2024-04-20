package me.eren.chiroptera.core.handlers.server;

import com.google.common.eventbus.Subscribe;
import me.eren.chiroptera.core.ChiropteraServer;
import me.eren.chiroptera.core.events.PacketReceivedEvent;
import me.eren.chiroptera.core.packets.ForwardPacket;

public class ServerForwardPacketHandler {
    @Subscribe
    public void handleForwardPacket(PacketReceivedEvent e) {
        if (e.packet() instanceof ForwardPacket packet) {
            ChiropteraServer.sendPacket(packet.getClientToSend(), packet.getPacketToSend());
        }
    }
}
