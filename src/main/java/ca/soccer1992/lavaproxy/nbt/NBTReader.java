package ca.soccer1992.lavaproxy.nbt;

import java.io.*;
import java.util.zip.GZIPInputStream;

public class NBTReader {
    public static CompoundTag read(InputStream is, boolean gzip) throws IOException {
        InputStream in = gzip ? new GZIPInputStream(is) : is;
        DataInputStream data = new DataInputStream(in);
        TagType rootType = TagType.fromId(data.readByte());
        if (rootType != TagType.COMPOUND) throw new IOException("Root tag must be a compound");
        String rootName = data.readUTF();
        return (CompoundTag) rootType.read(rootName, data);
    }
}