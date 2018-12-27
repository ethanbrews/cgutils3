package uk.co.conclipse.cgutils.vote.server;

import net.minecraft.command.ICommandSender;
import uk.co.conclipse.cgutils.CGUtils;
import uk.co.conclipse.cgutils.vote.server.votes.AbstractVote;
import uk.co.conclipse.cgutils.vote.server.votes.TestVote;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class VoteManager {

    private static Map<String, Class<? extends AbstractVote>> votes = new HashMap<String, Class<? extends AbstractVote>>();

    public static void load() {
        votes.put("test", TestVote.class);
    }

    public static AbstractVote instantiateVote(String name, ICommandSender sender) {
        Class<? extends AbstractVote> cls = votes.get(name);
        if (cls == null) {
            return null;
        }

        try {
            return cls.getConstructor(ICommandSender.class).newInstance(sender);
        } catch (NoSuchMethodException e) {
            CGUtils.logger.error(String.format("[VOTE] Invalid Constructor for %s. Should be: (ICommandSender)", name));
        } catch (IllegalAccessException e) {
            CGUtils.logger.error(String.format("[VOTE] Invalid Access for %s", name));
        } catch (InvocationTargetException e) {
            CGUtils.logger.error(String.format("[VOTE] InvocationTargetException for %s", name));
        } catch (InstantiationException e) {
            CGUtils.logger.error(String.format("[VOTE] InstantiationException for %s", name));
        }
        return null;
    }

}
