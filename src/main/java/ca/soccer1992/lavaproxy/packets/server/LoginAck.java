package ca.soccer1992.lavaproxy.packets.server;

import ca.soccer1992.lavaproxy.packets.ConnectionTypes;
import ca.soccer1992.lavaproxy.packets.Packet;

public class LoginAck extends Packet {
    public ConnectionTypes getType() { return ConnectionTypes.POST_SUCCESS; }
    public String name = "LoginAck";
}
