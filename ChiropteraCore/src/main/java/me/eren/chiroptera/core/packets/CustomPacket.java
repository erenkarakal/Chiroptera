package me.eren.chiroptera.core.packets;

import me.eren.chiroptera.core.Packet;

import java.io.Serializable;

/**
 * A custom packet with no set ID or data.
 */
public class CustomPacket extends Packet {

    public CustomPacket(byte id, Serializable[] data) {
        super(id, data);
    }

}
