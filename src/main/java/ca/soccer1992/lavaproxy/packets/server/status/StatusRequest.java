package ca.soccer1992.lavaproxy.packets.server.status;

import ca.soccer1992.lavaproxy.MinecraftVersions;
import ca.soccer1992.lavaproxy.packets.ConnectionTypes;
import ca.soccer1992.lavaproxy.packets.Packet;
import io.netty.buffer.ByteBuf;

public class StatusRequest extends Packet {

    public ConnectionTypes getType() { return ConnectionTypes.PRE_STATUS; }
    public String name = "StatusRequest";
    public StatusRequest(){
    }
    public void decode(ByteBuf buf, MinecraftVersions proto){
        // yea theres.. nothing to do bro
    }
    public void encode(ByteBuf buf, MinecraftVersions proto){
        // yea theres.. nothing to do bro
    }
}
