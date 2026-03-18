package ca.soccer1992.lavaproxy.packets.handlers;

import ca.soccer1992.lavaproxy.Connection;
import ca.soccer1992.lavaproxy.packets.Packet;

public abstract class Handler {
    public boolean handle(Packet p, Connection c){
        return false; // not handled
    }
}
