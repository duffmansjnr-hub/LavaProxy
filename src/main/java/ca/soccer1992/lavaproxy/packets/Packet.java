package ca.soccer1992.lavaproxy.packets;

import ca.soccer1992.lavaproxy.MinecraftVersions;
import io.netty.buffer.ByteBuf;

public abstract class Packet {
    public String toString() { return name; }
    public ConnectionTypes getType() { return null; }

    public String name = "";
    public void decode(ByteBuf buf, MinecraftVersions proto) { }
    public void encode(ByteBuf buf, MinecraftVersions proto) { }

}
