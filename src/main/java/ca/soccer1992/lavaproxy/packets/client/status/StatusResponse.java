package ca.soccer1992.lavaproxy.packets.client.status;

import ca.soccer1992.lavaproxy.packets.ConnectionTypes;
import ca.soccer1992.lavaproxy.packets.Packet;
import io.netty.buffer.ByteBuf;

import static ca.soccer1992.lavaproxy.PacketHelpers.*;

public class StatusResponse extends Packet {
    public String json= "";
    public ConnectionTypes getType() { return ConnectionTypes.STATUS; }
    public String name = "StatusResponse";
    public StatusResponse(){
    }

    public void setJSON(String json){
        this.json = json;
    }
    public void decode(ByteBuf buf){
        json = readString(buf);
    }
    public void encode(ByteBuf buf){
        writeString(json,buf);
    }
}
