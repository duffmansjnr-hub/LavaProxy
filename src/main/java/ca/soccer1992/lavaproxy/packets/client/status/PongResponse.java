package ca.soccer1992.lavaproxy.packets.client.status;

import ca.soccer1992.lavaproxy.packets.ConnectionTypes;
import ca.soccer1992.lavaproxy.packets.Packet;
import io.netty.buffer.ByteBuf;

public class PongResponse extends Packet {
    public long timestamp;
    public ConnectionTypes getType() { return ConnectionTypes.STATUS; }
    public String name = "PongResponse";
    public PongResponse(){
    }
    public void decode(ByteBuf buf){
        timestamp = buf.readLong();
    }
    public void encode(ByteBuf buf){
        buf.writeLong(timestamp);
    }
}
