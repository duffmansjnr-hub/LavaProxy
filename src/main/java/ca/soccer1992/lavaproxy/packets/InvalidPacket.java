package ca.soccer1992.lavaproxy.packets;
import ca.soccer1992.lavaproxy.packets.ConnectionTypes;
import ca.soccer1992.lavaproxy.packets.HandshakeIntent;
import ca.soccer1992.lavaproxy.packets.Packet;
import io.netty.buffer.ByteBuf;

import java.math.BigInteger;
import java.util.UUID;

import static ca.soccer1992.lavaproxy.PacketHelpers.*;

public class InvalidPacket extends Packet {
    public ByteBuf dta;

    public ConnectionTypes getType() { return ConnectionTypes.LOGIN; }
    public String name = "LoginStart";


    public void decode (ByteBuf buf){
        this.dta = buf;
    }
    public void encode(ByteBuf buf){
        buf.writeBytes(buf);

    }

}
