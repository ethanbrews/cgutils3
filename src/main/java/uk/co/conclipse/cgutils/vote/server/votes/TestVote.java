package uk.co.conclipse.cgutils.vote.server.votes;

import net.minecraft.command.ICommandSender;

public class TestVote extends AbstractVote {

    public TestVote(ICommandSender sender) {
        super(sender, 0.5f, 8);
    }

    @Override
    public void execute() {
        super.execute();
    }
}
