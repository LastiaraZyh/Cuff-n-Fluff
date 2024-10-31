package de.tum.cit.fop;

public class InterrogationRoom {

    private final Interrogator interrogator;

    public InterrogationRoom(Interrogator interrogator) {
        this.interrogator = interrogator;
    }

    public Interrogator getInterrogator() {
        return interrogator;
    }

    public void interrogate(Penguin alice, Penguin bob) {
        String aliceChoice = alice.getChoice();
        String bobChoice = bob.getChoice();
        if (aliceChoice.equals("B")) {
            if (bobChoice.equals("B")) {
                alice.setPrisonTime(2);
                bob.setPrisonTime(2);
            } else if (bobChoice.equals("S")) {
                alice.setPrisonTime(0);
                bob.setPrisonTime(3);
            }
        } else if (aliceChoice.equals("S")) {
            if (bobChoice.equals("B")) {
                alice.setPrisonTime(3);
                bob.setPrisonTime(0);
            } else if (bobChoice.equals("S")) {
                alice.setPrisonTime(1);
                bob.setPrisonTime(1);
            }
        }
    }


    public void interrogatorUsesTactics(Penguin alice, Penguin bob) {
        String aliceChoice = alice.getChoice();
        String bobChoice = bob.getChoice();
        if (interrogator.getTactic().equals(Interrogator.OFFER_DEAL)) {
            if (aliceChoice.equals("B")) {
                alice.setPrisonTime(alice.getPrisonTime() - 1);
            }
            if (bobChoice.equals("B")) {
                bob.setPrisonTime(bob.getPrisonTime() - 1);
            }
        } else if (interrogator.getTactic().equals(Interrogator.THREATEN)) {
            if (aliceChoice.equals("S")) {
                alice.setPrisonTime(alice.getPrisonTime() + 1);
            }
            if (bobChoice.equals("S")) {
                bob.setPrisonTime(bob.getPrisonTime() + 1);
            }
        }
    }
}