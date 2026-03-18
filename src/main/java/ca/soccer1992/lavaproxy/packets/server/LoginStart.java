package ca.soccer1992.lavaproxy.packets.server;
import ca.soccer1992.lavaproxy.packets.ConnectionTypes;
import ca.soccer1992.lavaproxy.packets.HandshakeIntent;
import ca.soccer1992.lavaproxy.packets.Packet;
import io.netty.buffer.ByteBuf;

import java.math.BigInteger;
import java.util.UUID;

import static ca.soccer1992.lavaproxy.PacketHelpers.*;

public class LoginStart extends Packet {
    public UUID uuid;
    public String playerName;

    public ConnectionTypes getType() { return ConnectionTypes.LOGIN; }
    public String name = "LoginStart";

    public void setUUID(UUID uuid){this.uuid = uuid;}
    public void setName(String name){this.playerName = name;}

    public void decode (ByteBuf buf){

        setName(readString(buf));
        setUUID(readUUID(buf));
    }
    public void encode(ByteBuf buf){
        writeString(playerName,buf);
        writeUUID(uuid,buf);
    }

}
