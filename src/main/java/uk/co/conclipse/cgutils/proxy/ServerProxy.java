package uk.co.conclipse.cgutils.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import uk.co.conclipse.cgutils.CGUtils;
import uk.co.conclipse.cgutils.vote.VoteMessage;
import uk.co.conclipse.cgutils.vote.server.VoteCommand;
import uk.co.conclipse.cgutils.vote.server.VoteManager;

public class ServerProxy implements IProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        CGUtils.logger.info("Starting in SERVER");
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
    }

    @Override
    public void serverStarting(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new VoteCommand());
        VoteManager.load();
    }

    @Override
    public EntityPlayer getPlayerEntityFromContext(MessageContext ctx)
    {
        return ctx.getServerHandler().player;
    }
}