package ca.soccer1992.lavaproxy.packets.client;
import ca.soccer1992.lavaproxy.packets.ConnectionTypes;
import ca.soccer1992.lavaproxy.packets.HandshakeIntent;
import ca.soccer1992.lavaproxy.packets.Packet;
import io.netty.buffer.ByteBuf;

import java.util.UUID;

import static ca.soccer1992.lavaproxy.PacketHelpers.*;

public class LoginKick extends Packet {
    public HandshakeIntent intent;
    public String reason;

    public ConnectionTypes getType() { return ConnectionTypes.LOGIN; }
    public String name = "LoginKick";

    public void setReason(String reason){this.reason = reason;}

    public void decode (ByteBuf buf){
        setReason(readString(buf));
    }
    public void encode(ByteBuf buf){
        writeString(reason,buf);
    }

}
