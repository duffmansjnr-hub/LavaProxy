package ca.soccer1992.lavaproxy.packets.handlers;

import ca.soccer1992.lavaproxy.Connection;
import ca.soccer1992.lavaproxy.MinecraftVersions;
import ca.soccer1992.lavaproxy.packets.ConnectionTypes;
import ca.soccer1992.lavaproxy.packets.Packet;
import ca.soccer1992.lavaproxy.packets.client.login.LoginSuccess;
import ca.soccer1992.lavaproxy.packets.readers.ConfigReader;
import ca.soccer1992.lavaproxy.packets.server.LoginAck;
import ca.soccer1992.lavaproxy.packets.server.LoginStart;
import ca.soccer1992.lavaproxy.utils.ComponentUtils;


public class LoginHandler extends Handler{
    public boolean handle(Packet p, Connection c){

        if (p instanceof LoginStart packet){
            if (!packet.playerName.matches("[a-zA-Z0-9\\p{Punct}]+")){
                c.noLogDisconnect("\"Invalid player name\"");
                return true;
            }
            c.plr.setName(packet.playerName);
            c.plr.setUUID(packet.uuid);
            System.out.printf("Player %s (%s) has started login%n",c.plr, c.addr.getHostString());
            LoginSuccess success = new LoginSuccess();
            success.setName(c.plr.name);
            success.setUUID(c.plr.uuid);
            c.writePacket(success);
            if (c.protocol.getProtocol()< MinecraftVersions.MINECRAFT_1_20_2.getProtocol()){
                // instantly change it xd
                c.conType = ConnectionTypes.PLAY;

            } else {
                c.conType = ConnectionTypes.POST_SUCCESS;
            }

            //c.disconnect(ComponentUtils.parser.deserialize("<rainbow>Testing</rainbow>"),false);
            return true;

        } else if (p instanceof LoginAck){
            if (c.conType != ConnectionTypes.POST_SUCCESS){
                c.disconnect("LoginAck sent before LoginSuccess", true);
                return true;
            }

            c.conType = ConnectionTypes.CONFIG;
            c.setReader(new ConfigReader());
            c.disconnect(ComponentUtils.parser.deserialize("<rainbow>Testing</rainbow>"),false);

            return true;
        }


        return false;
    }
}
