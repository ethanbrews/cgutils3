package uk.co.conclipse.cgutils.vote.server;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class VoteCommand extends CommandBase {

    public String getName() {
        return "vote";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        if (isOpped(sender)) {
            return "vote <list|help|enable|disable> [args]";
        } else {
            return "vote <list|help> [args]";
        }
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args[0].equals("list")) {
            for (String name : VoteManager.getAllNames()) {
                sender.sendMessage(new TextComponentString(String.format("- %s", name)));
            }

        }
    }

    private boolean isOpped(ICommandSender sender) {
        return ((sender instanceof EntityPlayerMP) && ( FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getOppedPlayers().getEntry( ((EntityPlayerMP)sender).getGameProfile() ) != null ));
    }
}
