package ca.soccer1992.lavaproxy.packets.client;

import ca.soccer1992.lavaproxy.MinecraftVersions;
import ca.soccer1992.lavaproxy.nbt.*;
import ca.soccer1992.lavaproxy.packets.*;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;

import java.io.IOException;
import java.io.OutputStream;



public class NBTKick extends Packet {
    public CompoundTag reason;

    public ConnectionTypes getType() { return ConnectionTypes.CONFIG; }
    public String name = "NBTKick";

    public void setReason(CompoundTag reason){this.reason = reason;}

    public void decode (ByteBuf buf, MinecraftVersions proto){
        try {
            setReason(NBTReader.read(buf));
        } catch (Exception ignored){
        }
    }
    public void encode(ByteBuf buf, MinecraftVersions proto){
        try (OutputStream stream = new ByteBufOutputStream(buf)) {
            NBTWriter.write(reason, stream, false, proto.getProtocol()>=MinecraftVersions.MINECRAFT_1_20_2.getProtocol());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
