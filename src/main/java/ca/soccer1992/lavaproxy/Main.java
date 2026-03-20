package ca.soccer1992.lavaproxy;
import io.netty.util.AttributeKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static final AttributeKey<Connection> READER =
            AttributeKey.valueOf("connection");
    public static boolean logErrors = true;
    public static boolean logPings = true;
    public static int CON_AMOUNT = 0;

    public static void main(String[] args) throws Exception {
        //System.out.println(root.value.values());
        //root = new CompoundTag("root");
        //root.put(new StringTag("name","hello"));
        //System.out.println(root.);
        //NBTWriter.write(root, new FileOutputStream("world.dat"), false, true); // true = gzip

        new NettyServer(25577).start();

    }
}