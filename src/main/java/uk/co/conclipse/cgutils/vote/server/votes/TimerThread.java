package uk.co.conclipse.cgutils.vote.server.votes;

public class TimerThread extends Thread {

    private int timeout;
    private AbstractVote vote;

    public TimerThread(AbstractVote vote, int timeout) {
        super();
        this.timeout = timeout;
        this.vote = vote;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timeout*1000);
            if (vote.voteHasPassed()) {
                vote.execute();
            } else {
                vote.fail();
            }
        } catch (InterruptedException e) { }
    }
}
