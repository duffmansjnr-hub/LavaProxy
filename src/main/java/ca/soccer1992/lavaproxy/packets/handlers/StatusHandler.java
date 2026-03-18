package ca.soccer1992.lavaproxy.packets.handlers;

import ca.soccer1992.lavaproxy.Connection;
import ca.soccer1992.lavaproxy.packets.Packet;
import ca.soccer1992.lavaproxy.packets.server.status.PingRequest;

public class StatusHandler extends Handler{
    public boolean handle(Packet p, Connection c){
        if (p instanceof PingRequest packet){
            c.writePacketServer(packet);

        }
        return false;
    }
}
