package uk.co.conclipse.cgutils.proxy;


import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MouseHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import uk.co.conclipse.cgutils.CGUtils;

public class ClientProxy implements IProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        CGUtils.logger.info("Starting in CLIENT");

        //RenderFactories.registerEntityRenderers();
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        // DEBUG
        System.out.println("on Client side");


        // register key bindings
        //ModKeyBindings.registerKeyBindings();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {

    }

    @Override
    public EntityPlayer getPlayerEntityFromContext(MessageContext ctx)
    {
        return (ctx.side.isClient() ? Minecraft.getMinecraft().player : CGUtils.proxy.getPlayerEntityFromContext(ctx));
    }

    @Override
    public void serverStarting(FMLServerStartingEvent event)
    {
        // This will never get called on client side
    }
}

