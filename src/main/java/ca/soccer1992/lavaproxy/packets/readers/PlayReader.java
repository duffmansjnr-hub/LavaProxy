package ca.soccer1992.lavaproxy.packets.readers;

import ca.soccer1992.lavaproxy.MinecraftVersions;
import ca.soccer1992.lavaproxy.packets.DefinitionPair;
import ca.soccer1992.lavaproxy.packets.Packet;
import ca.soccer1992.lavaproxy.packets.client.NBTKick;
import ca.soccer1992.lavaproxy.packets.server.ClientInfo;

import java.util.List;
import java.util.Map;

public class PlayReader extends Reader {
    public Map<Class<? extends Packet>, List<DefinitionPair>> serverDefinitions = Map.of(
    );
    public Map<Class<? extends Packet>, List<DefinitionPair>> clientDefinitions = Map.of(
            NBTKick.class, List.of(
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_8, 0x40),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_9, 0x1a),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_13, 0x1b),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_14, 0x1a),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_15, 0x1b),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_16, 0x1a),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_16_2, 0x19),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_17, 0x1a),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_19, 0x17),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_19_1, 0x19),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_19_3, 0x17),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_19_4, 0x1a),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_20_2, 0x1b),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_20_5, 0x1d),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_21_5, 0x1c),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_21_9, 0x20)

            ),
            ClientInfo.class, List.of(
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_7_2, 0x15),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_9, 0x4),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_12, 0x5),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_12_1, 0x7),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_14, 0x8),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_19, 0x7),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_19_1, 0x8),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_19_3, 0x9),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_19_4, 0xA),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_20_2, 0xC),
                    new DefinitionPair(MinecraftVersions.MINECRAFT_1_20_5, 0xD)

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