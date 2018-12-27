package uk.co.conclipse.cgutils;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import uk.co.conclipse.cgutils.proxy.IProxy;

@Mod(modid = CGUtils.MODID, name = CGUtils.NAME, version = CGUtils.VERSION)
public class CGUtils {
    public static final String MODID = "cgutils";
    public static final String NAME = "CGUtils";
    public static final String VERSION = "1.0";

    public static Logger logger;



    @SidedProxy(
            clientSide="uk.co.conclipse.cgutils.proxy.ClientProxy",
            serverSide="uk.co.conclipse.cgutils.proxy.ServerProxy"
    )
    public static IProxy proxy;



    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }
}
