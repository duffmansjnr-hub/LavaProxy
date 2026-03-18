package ca.soccer1992.lavaproxy;

import ca.soccer1992.lavaproxy.packets.HandshakeIntent;
import ca.soccer1992.lavaproxy.packets.server.*;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.UUID;

public class ServerConnection {
    public void connect(Connection con, HandshakeIntent intent, String host, int port) throws InterruptedException {

        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast(new SimpleChannelInboundHandler<ByteBuf>() {

                                @Override
                                public void channelActive(ChannelHandlerContext ctx) {
                                    //
                                    Connection c = new Connection(ctx.channel());
                                    ctx.channel().attr(Main.READER).set(c);
                                    HandshakePacket p = new HandshakePacket();
                                    p.setIntent(intent);
                                    p.setProtocol(con.protocol);
                                    p.setHost(con.connectAddr.getHostString());
                                    p.setPort(con.connectAddr.getPort());
                                    c.writePacketServer(p);
                                    if (intent.getId()>1) {
                                        LoginStart login = new LoginStart();
                                        login.setName(con.plr.name);
                                        login.setUUID(con.plr.uuid);
                                        c.writePacketServer(login);
                                    }
                                }

                                @Override
                                protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) {
                                    byte[] bytes = new byte[msg.readableBytes()];
                                    msg.readBytes(bytes);

                                }

                                @Override
                                public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
                                    cause.printStackTrace();
                                    ctx.close();
                                }
                            });
                        }
                    });

            ChannelFuture future = bootstrap.connect(host, port).sync();
            future.channel().closeFuture().sync();

        } finally {
            group.shutdownGracefully();
        }
    }
}
