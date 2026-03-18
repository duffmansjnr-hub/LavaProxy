package ca.soccer1992.lavaproxy.packets.server;

import ca.soccer1992.lavaproxy.packets.ConnectionTypes;
import ca.soccer1992.lavaproxy.packets.Packet;
import io.netty.buffer.ByteBuf;

public class StatusPing extends Packet {
    public long timestamp;

    public ConnectionTypes getType() { return ConnectionTypes.STATUS; }
    public String name = "StatusPing";
    public byte getID() { return 0x01; }
    public StatusPing(ByteBuf buf){
        this.timestamp = buf.readLong();

    }
}
