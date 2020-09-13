package NettyTest;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import main.generalLogger.LOGGER;

public class ResponseDataEncoder
        extends MessageToByteEncoder<ResponseData> {

    @Override
    protected void encode(ChannelHandlerContext ctx,
                          ResponseData msg, ByteBuf out) throws Exception {

        LOGGER.general("ResEn", System.nanoTime());
        out.writeInt(msg.getIntValue());
    }
}
