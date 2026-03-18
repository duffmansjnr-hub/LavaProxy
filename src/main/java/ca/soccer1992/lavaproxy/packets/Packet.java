package ca.soccer1992.lavaproxy.packets;

import io.netty.buffer.ByteBuf;

public abstract class Packet {
    public byte getID() { return 0; }
    public String toString() { return name; }
    public ConnectionTypes getType() { return null; }

    public String name = "";
    public void decode(ByteBuf buf) { return; }
    public void encode(ByteBuf buf) { return; }

}
