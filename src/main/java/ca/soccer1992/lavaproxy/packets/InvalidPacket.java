package ca.soccer1992.lavaproxy.packets;
import io.netty.buffer.ByteBuf;

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
