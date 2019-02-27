package com.dreammaster.command;

import cpw.mods.fml.common.registry.GameRegistry;
import eu.usrv.yamcore.auxiliary.PlayerChatHelper;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;

import java.util.ArrayList;
import java.util.List;

public class ItemInHandInfoCommand implements ICommand
{
    private List aliases;

    public ItemInHandInfoCommand()
    {
        aliases = new ArrayList();
        aliases.add("iih");
    }

    @Override
    public int compareTo(Object arg0)
    {
        return 0;
    }

    @Override
    public String getCommandName()
    {
        return "iteminhand";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_)
    {
        return "/iih";
    }

    @Override
    public List getCommandAliases()
    {
        return aliases;
    }


    @Override
    public void processCommand(ICommandSender pCmdSender, String[] pArgs)
    {
        try
        {
            if (!InGame(pCmdSender))
            {
                MainRegistry.Logger.error("Command can only be executed ingame");
                return;
            }
            
            EntityPlayer tEp = (EntityPlayer) pCmdSender;
            ItemStack inHand = null;
            if (tEp != null)
            {
                inHand = tEp.getCurrentEquippedItem();
                if (inHand == null)
                {
                    PlayerChatHelper.SendPlain(pCmdSender, "Pickup an item first");
                    return;
                }
            }
    
            GameRegistry.UniqueIdentifier UID = GameRegistry.findUniqueIdentifierFor(inHand.getItem());
            
            PlayerChatHelper.SendPlain(pCmdSender, "== Item info");
            PlayerChatHelper.SendPlain(pCmdSender, String.format("Unloc.Name:  [%s]", inHand.getUnlocalizedName()));
            PlayerChatHelper.SendPlain(pCmdSender, String.format("ItemName:  [%s]", UID.toString()));
            PlayerChatHelper.SendPlain(pCmdSender, String.format("ItemMeta:  [%s]", inHand.getItemDamage()));
            PlayerChatHelper.SendPlain(pCmdSender, String.format("FluidContainer:  [%s]", getFluidContainerContents(inHand)));
            PlayerChatHelper.SendPlain(pCmdSender, String.format("ClassName:  [%s]", inHand.getItem().getClass().toString()));
            PlayerChatHelper.SendPlain(pCmdSender, String.format("ItemNBT:  [%s]", inHand.stackTagCompound));
            
        } catch (Exception e)
        {
            e.printStackTrace();
            PlayerChatHelper.SendError(pCmdSender, "Unknown error occoured");
        }
    }

    private String getFluidContainerContents(ItemStack pItemInQuestion)
    {
        String tResult = "No fluid container";
        
        if (pItemInQuestion.getItem() instanceof IFluidContainerItem)
        {
            IFluidContainerItem tFluidContainer = IFluidContainerItem.class.cast(pItemInQuestion.getItem());
            FluidStack tContents = tFluidContainer.getFluid(pItemInQuestion);
            if (tContents != null)
            {
                tResult = String.format("FluidID: [%d], UnlocName: [%s], Name: [%s]", tContents.getFluid().getID(), tContents.getFluid().getUnlocalizedName(), tContents.getFluid().getName()); 
            }
        }
        
        return tResult;
    }
    
  private boolean InGame( ICommandSender pCmdSender )
  {
    if (pCmdSender == null){
      return false;
    }
    return pCmdSender instanceof EntityPlayer;
}

    private void SendHelpToPlayer(ICommandSender pCmdSender)
    {
        if (pCmdSender == null){
            MainRegistry.Logger.error("Command can only be executed ingame");
            return;
        }
        if (!InGame(pCmdSender))
        {
            PlayerChatHelper.SendPlain(pCmdSender, "Command can only be executed ingame");            
        }
        else
        {
            PlayerChatHelper.SendInfo(pCmdSender, "/iih");            
        }
    }

    /*
     * As it is a clientside thing, everyone should be allowed to do this
     */
    @Override
    public boolean canCommandSenderUseCommand(ICommandSender pCommandSender)
    {
        return true;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_)
    {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_)
    {
        return false;
    }
}
