package ca.soccer1992.lavaproxy.packets.handlers.client;

import ca.soccer1992.lavaproxy.Connection;
import ca.soccer1992.lavaproxy.packets.Packet;
import ca.soccer1992.lavaproxy.packets.client.login.CompressionPacket;
import ca.soccer1992.lavaproxy.packets.client.login.LoginSuccess;
import ca.soccer1992.lavaproxy.packets.handlers.Handler;
import ca.soccer1992.lavaproxy.packets.server.LoginAck;

public class LoginHandler extends Handler {
    public boolean handle(Packet p, Connection c){

        if (p instanceof final CompressionPacket packet) {
            c.setCompression(packet.threshold);
            return true;
        }

        if (p instanceof LoginSuccess){
            c.writePacket(new LoginAck());
            return true;
        }

        return false;
    }
}
