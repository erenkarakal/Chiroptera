package me.eren.chiroptera.core;

import me.eren.chiroptera.core.packets.CustomPacket;

import java.io.*;
import java.util.Arrays;

public abstract class Packet implements Serializable {
    private byte id;
    private final Serializable[] data;

    public Packet(byte id, Serializable[] data) {
        this.id = id;
        this.data = data;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public byte getId() {
        return this.id;
    }

    public Serializable[] getData() {
        return this.data;
    }

    /**
     * @return The serialized packet, or an empty byte array if it fails to serialize.
     */
    public byte[] serialize() {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {

            oos.writeObject(this);
            return bos.toByteArray();

        } catch (IOException e) {
            return new byte[]{};
        }
    }

    /**
     * @param byteArray Raw packet data
     * @return The deserialized packet, or an empty packet with ID -1 if it fails to deserialize.
     */
    public static Packet deserialize(byte[] byteArray) {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
             ObjectInputStream ois = new ObjectInputStream(bis)) {

            return (Packet) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            return new CustomPacket((byte) -1, null);
        }
    }

    @Override
    public String toString() {
        return "Packet{id=" + this.id + " data=" + Arrays.toString(this.data) + "}";
    }

}