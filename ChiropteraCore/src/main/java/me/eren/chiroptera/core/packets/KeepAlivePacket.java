package me.eren.chiroptera.core.packets;

import me.eren.chiroptera.core.Packet;

import java.io.Serializable;
import java.util.Map;

/**
 * Sent by the server every 20 seconds. The client must respond with the same packet within 5 seconds, or they will be timed out.
 */
public class KeepAlivePacket extends Packet {

    private final byte random;

    public KeepAlivePacket(byte random) {
        super((byte) -3, new Serializable[]{ random });
        this.random = random;
    }

    public byte getRandom() {
        return this.random;
    }

}
