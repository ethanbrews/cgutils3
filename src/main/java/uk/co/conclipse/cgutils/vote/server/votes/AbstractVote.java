package uk.co.conclipse.cgutils.vote.server.votes;

import net.minecraft.command.ICommandSender;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.server.FMLServerHandler;

public abstract class AbstractVote {
    private ICommandSender sender;
    private int votecount;
    private float threshold;
    private int timelimit;
    private Thread timerThread;

    public AbstractVote(ICommandSender sender, float threshold, int timelimit) {
        this.sender = sender;
        this.threshold = threshold;
        this.votecount = 0;
        this.timelimit = timelimit;
    }

    public void endVote() {

    }

    public boolean canRunVote() {
        //Check it's enabled and the player can call votes
        return true;
    }


    public boolean voteHasPassed() {
        return (votecount / FMLServerHandler.instance().getServer().getOnlinePlayerNames().length) > threshold;
    }

    public void playerDidVote() {
        votecount++;
        if (voteHasPassed()) {
            execute();
        }
    }

    public void execute() {
        endVote();
        FMLServerHandler.instance().getServer().getPlayerList().sendMessage(new TextComponentTranslation("cgutils.vote.pass"));
    }

    public void fail() {
        endVote();
        FMLServerHandler.instance().getServer().getPlayerList().sendMessage(new TextComponentTranslation("cgutils.vote.fail"));
    }
}
