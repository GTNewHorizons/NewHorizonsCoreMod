package com.dreammaster.network.msg;

import net.minecraft.entity.player.EntityPlayer;

import com.dreammaster.scripts.ScriptZZClientOnly;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import eu.usrv.yamcore.network.client.AbstractClientMessageHandler;
import io.netty.buffer.ByteBuf;

public class ZZClientOnlySyncMessage implements IMessage {

    boolean enabled;

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

    public static class ZZClientOnlySyncMessageHandler extends AbstractClientMessageHandler<ZZClientOnlySyncMessage> {

        @Override
        public IMessage handleClientMessage(EntityPlayer player, ZZClientOnlySyncMessage message, MessageContext ctx) {
            ScriptZZClientOnly.instance.handleServerMessage(message.enabled);
            return null;
        }
    }
}
