package de.tum.cit.fop;

import java.util.Random;
import java.util.Scanner;

public class Penguin {
    private String name;
    private int prisonTime;
    private String choice;


    public Penguin(String name) {
        this.name = name;
        this.prisonTime = 0;
        this.choice = "NONE";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {  // 添加 setName 方法
        this.name = name;
    }

    public int getPrisonTime() {
        return prisonTime;
    }

    public void setPrisonTime(int prisonTime) {
        this.prisonTime = prisonTime;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
}

class Interrogator {
    private String name;
    private String tactic;

    public static final String OFFER_DEAL = "O";
    public static final String THREATEN = "T";


    public Interrogator(String name) {
        this.name = name;
        this.tactic = "NONE";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {  // 添加 setName 方法
        this.name = name;
    }

    public String getTactic() {
        return tactic;
    }

    public void setTactic(String tactic) {
        this.tactic = tactic;
    }
}

class InterrogationRoom {
    private final Interrogator interrogator;
    private static final Random random = new Random();

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
        if (alice.getPrisonTime() >= 1 || bob.getPrisonTime() >= 1) {
            return;
        }
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Penguin alice = new Penguin("Alice");
        Penguin bob = new Penguin("Bob");

        System.out.println("Welcome to the Cuff 'n' Fluff");


        String choiceAlice;
        do {
            System.out.println("Do you want to betray (B) Bob or be silent (S)?");
            choiceAlice = scanner.nextLine();
        } while (!choiceAlice.equals("B") && !choiceAlice.equals("S"));

        alice.setChoice(choiceAlice);
        System.out.println("Alice chose to " + turnChoiceIntoSentence(choiceAlice) + ": " + choiceAlice);

        bob.setChoice(generateRandomChoice());
        System.out.println("Bob chose to " + turnChoiceIntoSentence(bob.getChoice()) + ": " + bob.getChoice());

        Interrogator interrogator = new Interrogator("Sherlock Holmes");
        interrogator.setTactic(generateRandomInterrogationStyle());
        InterrogationRoom interrogationRoom = new InterrogationRoom(interrogator);
        interrogationRoom.interrogate(alice, bob);

        System.out.println("Alice gets " + alice.getPrisonTime() + " years and Bob gets " + bob.getPrisonTime() + " years in prison.");


        if (!(alice.getChoice().equals("B") && bob.getChoice().equals("B"))) {
            System.out.println("Interrogator was not happy with the result and decides to use tactics.");

            String changeChoice;
            do {
                System.out.println("Would you like to change your choice? (Y/N)");
                changeChoice = scanner.nextLine();
            } while (!changeChoice.equals("Y") && !changeChoice.equals("N"));

            if (changeChoice.equals("Y")) {
                alice.setChoice(changeChoiceIfYes(choiceAlice));
            }

            bob.setChoice(generateRandomChoice());
            interrogationRoom.interrogate(alice, bob);
            interrogationRoom.interrogatorUsesTactics(alice, bob);

            System.out.println("After the interrogation with tactics, Alice gets " + alice.getPrisonTime() + " years and Bob gets " + bob.getPrisonTime() + " years in prison.");
            System.out.println("Interrogator " + interrogator.getName() + " employs " + (interrogator.getTactic().equals(Interrogator.OFFER_DEAL) ? "offer deal" : "threaten") + " tactic.");
        } else {
            System.out.println("Interrogator is happy with the result and decides not to use tactics.");
        }
    }

    private static String turnChoiceIntoSentence(String choice) {
        return choice.equals("B") ? "betray" : "be silent";
    }

    private static String changeChoiceIfYes(String choiceAlice) {
        return choiceAlice.equals("B") ? "S" : "B";
    }

    private static String generateRandomChoice() {
        return random.nextInt(2) == 0 ? "B" : "S";
    }

    private static String generateRandomInterrogationStyle() {
        String[] interrogationStyles = {Interrogator.OFFER_DEAL, Interrogator.THREATEN};
        return interrogationStyles[random.nextInt(2)];
    }
}

