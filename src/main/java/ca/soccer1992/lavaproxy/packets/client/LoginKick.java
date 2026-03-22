package ca.soccer1992.lavaproxy.packets.client;
import ca.soccer1992.lavaproxy.MinecraftVersions;
import ca.soccer1992.lavaproxy.packets.ConnectionTypes;
import ca.soccer1992.lavaproxy.packets.Packet;
import io.netty.buffer.ByteBuf;
import static ca.soccer1992.lavaproxy.utils.PacketHelpers.*;

public class LoginKick extends Packet {
    public String reason;

    public ConnectionTypes getType() { return ConnectionTypes.LOGIN; }
    public String name = "LoginKick";

    public void setReason(String reason){this.reason = reason;}

    public void decode (ByteBuf buf, MinecraftVersions proto){
        setReason(readString(buf));
    }
    public void encode(ByteBuf buf, MinecraftVersions proto){
        writeString(reason,buf);
    }

}
