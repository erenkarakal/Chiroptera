package me.eren.chiroptera.core.packets;

import me.eren.chiroptera.core.Packet;

import java.io.Serializable;
import java.util.Map;

/**
 * Sent by the client so that the server can forward a packet to a specific client.
 */
public class ForwardPacket extends Packet {

    private final String clientToSend;
    private final Packet packetToSend;

    public ForwardPacket(String clientToSend, Packet packetToSend) {
        super((byte) -6, new Serializable[]{ clientToSend, packetToSend });
        this.clientToSend = clientToSend;
        this.packetToSend = packetToSend;
    }

    public String getClientToSend() {
        return this.clientToSend;
    }

    public Packet getPacketToSend() {
        return this.packetToSend;
    }

}
