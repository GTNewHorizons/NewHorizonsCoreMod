package com.dreammaster.network.msg;

import com.dreammaster.scripts.ScriptZZClientOnly;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

public class ZZClientOnlySyncMessage implements IMessage {

    boolean enabled;

    @SuppressWarnings("unused")
    public ZZClientOnlySyncMessage() {}

    public ZZClientOnlySyncMessage(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        enabled = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(enabled);
    }

    public static class ZZClientOnlySyncMessageHandler implements IMessageHandler<ZZClientOnlySyncMessage, IMessage> {

        @Override
        public IMessage onMessage(ZZClientOnlySyncMessage message, MessageContext ctx) {
            ScriptZZClientOnly.instance.handleServerMessage(message.enabled);
            return null;
        }
    }
}
