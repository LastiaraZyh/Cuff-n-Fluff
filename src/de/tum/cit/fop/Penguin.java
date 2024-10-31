package de.tum.cit.fop;
import java.util.Random;
import java.util.Scanner;

public class Penguin {
    private String name;
    private int prisonTime;
    private String choice;

    // 构造器，只接受 name 参数
    public Penguin(String name) {
        this.name = name;
        this.prisonTime = 0;
        this.choice = "NONE";
    }

    // Getter 和 Setter 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
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

public class Interrogator {
    private String name;
    private String tactic;

    public static final String OFFER_DEAL = "O";
    public static final String THREATEN = "T";

    // 构造器，只接受 name 参数
    public Interrogator(String name) {
        this.name = name;
        this.tactic = "NONE";
    }

    // Getter 和 Setter 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTactic() {
        return tactic;
    }

    public void setTactic(String tactic) {
        this.tactic = tactic;
    }
}

public class InterrogationRoom {
    private final Interrogator interrogator;
    private static final Random random = new Random();

    // 构造器，接受 Interrogator 对象作为参数
    public InterrogationRoom(Interrogator interrogator) {
        this.interrogator = interrogator;
    }

    // Getter 方法
    public Interrogator getInterrogator() {
        return interrogator;
    }

    // Interrogate 方法
    public void interrogate(Penguin alice, Penguin bob) {
        String aliceChoice = alice.getChoice();
        String bobChoice = bob.getChoice();

        // 根据 Alice 和 Bob 的选择设置监禁时间
        if (aliceChoice.equals("B") && bobChoice.equals("B")) {
            alice.setPrisonTime(5);
            bob.setPrisonTime(5);
        } else if (aliceChoice.equals("B") && bobChoice.equals("S")) {
            alice.setPrisonTime(0);
            bob.setPrisonTime(10);
        } else if (aliceChoice.equals("S") && bobChoice.equals("B")) {
            alice.setPrisonTime(10);
            bob.setPrisonTime(0);
        } else {
            alice.setPrisonTime(1);
            bob.setPrisonTime(1);
        }
    }

    // Interrogator uses tactics to potentially change the prison time
    public void interrogatorUsesTactics(Penguin alice, Penguin bob) {
        if (interrogator.getTactic().equals(Interrogator.OFFER_DEAL)) {
            // Both confess (B) reduce their prison time by 1
            if (alice.getChoice().equals("B")) {
                alice.setPrisonTime(Math.max(0, alice.getPrisonTime() - 1)); // Reduce by 1
            }
            if (bob.getChoice().equals("B")) {
                bob.setPrisonTime(Math.max(0, bob.getPrisonTime() - 1)); // Reduce by 1
            }
        } else if (interrogator.getTactic().equals(Interrogator.THREATEN)) {
            // Both remain silent (S) add 1 year to their prison time
            if (alice.getChoice().equals("S")) {
                alice.setPrisonTime(alice.getPrisonTime() + 1); // Add 1
            }
            if (bob.getChoice().equals("S")) {
                bob.setPrisonTime(bob.getPrisonTime() + 1); // Add 1
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Penguin alice = new Penguin("Alice");
        Penguin bob = new Penguin("Bob");

        System.out.println("Welcome to the Cuff 'n' Fluff");

        // Ask Alice's choice
        String choiceAlice;
        do {
            System.out.println("Do you want to betray (B) Bob or be silent (S)?");
            choiceAlice = scanner.nextLine();
        } while (!choiceAlice.equals("B") && !choiceAlice.equals("S"));

        alice.setChoice(choiceAlice);
        System.out.println("Alice chose to " + turnChoiceIntoSentence(choiceAlice) + ": " + choiceAlice);

        // Bob makes a random choice
        bob.setChoice(generateRandomChoice());
        System.out.println("Bob chose to " + turnChoiceIntoSentence(bob.getChoice()) + ": " + bob.getChoice());

        // Interrogator interrogates Alice and Bob
        Interrogator interrogator = new Interrogator("Sherlock Holmes");
        interrogator.setTactic(generateRandomInterrogationStyle());
        InterrogationRoom interrogationRoom = new InterrogationRoom(interrogator);
        interrogationRoom.interrogate(alice, bob);

        System.out.println("Alice gets " + alice.getPrisonTime() + " years and Bob gets " + bob.getPrisonTime() + " years in prison.");

        // Interrogator decides to employ tactics if needed
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
