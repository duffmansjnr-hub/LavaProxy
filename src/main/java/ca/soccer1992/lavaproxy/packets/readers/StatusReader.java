package ca.soccer1992.lavaproxy.packets.readers;

import ca.soccer1992.lavaproxy.MinecraftVersions;
import ca.soccer1992.lavaproxy.packets.DefinitionPair;
import ca.soccer1992.lavaproxy.packets.Packet;
import ca.soccer1992.lavaproxy.packets.client.status.*;
import ca.soccer1992.lavaproxy.packets.server.status.*;

import java.util.List;
import java.util.Map;

public class StatusReader extends Reader {
    public Map<Class<? extends Packet>, List<DefinitionPair>> serverDefinitions = Map.of(
            PingRequest.class, List.of(
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_8, 0x01)
            )
    );
    public Map<Class<? extends Packet>, List<DefinitionPair>> clientDefinitions = Map.of(
            StatusResponse.class, List.of(
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_8, 0x00)
            ),
            PongResponse.class, List.of(
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_8, 0x01)
            )
    );
    @Override
    protected Map<Class<? extends Packet>, List<DefinitionPair>> serverDefinitions(){
        return serverDefinitions;

    }
    @Override
    protected Map<Class<? extends Packet>, List<DefinitionPair>> clientDefinitions(){
        return clientDefinitions;

    }

}