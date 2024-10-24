package de.tum.cit.fop;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {

    private static final Random random = new Random();

    public static void main(String[] args) {
        // TODO PART 1 WITHOUT INTERROGATOR TACTICS
//        Scanner scanner = new Scanner(in);
//        Penguin alice = new Penguin("Alice");
//        Penguin bob = new Penguin("Bob");
//
//        // Print a welcome message
//        out.println("Welcome to the Cuff 'n' Fluff");
//
//        // Ask Alice
//        out.println("Do you want to betray (B) Bob or be silent (S)?");
//        String choiceAlice = scanner.nextLine();
//        while (!choiceAlice.equals("B") && !choiceAlice.equals("S")) {
//            choiceAlice = scanner.nextLine();
//        }
//        alice.setChoice(choiceAlice);
//
//        out.println("Alice chose to " + turnChoiceIntoSentence(choiceAlice) + ": " + choiceAlice);
//
//        // Bob answers: 0 = Betray, 1 = Silent
//        bob.setChoice(generateRandomChoice());
//        out.println("Bob chose to " + turnChoiceIntoSentence(bob.getChoice()) + ": " + bob.getChoice());
//
//        // Interrogator interrogates Alice and Bob
//        Interrogator interrogator = new Interrogator("Sherlock Holmes");
//        interrogator.setTactic(generateRandomInterrogationStyle());
//        InterrogationRoom interrogationRoom = new InterrogationRoom(interrogator);
//        interrogationRoom.interrogate(alice, bob);
//
//        out.println("Alice gets " + alice.getPrisonTime() + " years and Bob gets " + bob.getPrisonTime() + " years in prison.");
//
//        // TODO: PART 2 WITH INTERROGATOR TACTICS
//        // Interrogator decides to employ tactics during the interrogation
//        if (alice.getChoice().equals("B") && bob.getChoice().equals("B")) {
//            out.println("Interrogator is happy with the result and decides not to use tactics.");
//            return;
//        } else {
//            out.println("Interrogator was not so happy with the result and decides to use tactics.");
//        }
//
//        out.println("Would you like to change your choice? (Y/N)");
//        String changeChoice = scanner.nextLine();
//        while (!changeChoice.equals("Y") && !changeChoice.equals("N")) {
//            changeChoice = scanner.nextLine();
//        }
//
//        if (changeChoice.equals("Y")) {
//            alice.setChoice(changeChoiceIfYes(choiceAlice));
//        }
//
//        bob.setChoice(generateRandomChoice());
//
//        // Interrogator uses tactics to change the prison time
//        interrogationRoom.interrogate(alice, bob);
//        interrogationRoom.interrogatorUsesTactics(alice, bob);
//
//        // Alice chooses again
//        out.println("Alice chose to " + turnChoiceIntoSentence(alice.getChoice()) + ": " + alice.getChoice());
//
//        // Bob chooses again
//        out.println("Bob chose to " + turnChoiceIntoSentence(bob.getChoice()) + ": " + bob.getChoice());
//
//        out.println("Interrogator " + interrogator.getName() + " employs " + (interrogator.getTactic().equals("O") ? "offer deal" : "threaten") + " tactic.");
//
//        out.println("After the interrogation with tactics, Alice gets " + alice.getPrisonTime() + " years and Bob gets " + bob.getPrisonTime() + " years in prison.");
   }

    private static String turnChoiceIntoSentence(String choice) {
        return choice.equals("B") ? "betray" : "be silent";
    }

    public static String changeChoiceIfYes(String choiceAlice) {
        return choiceAlice.equals("B") ? "S" : "B";
    }

    public static String generateRandomChoice() {
        return random.nextInt(2) == 0 ? "B" : "S";
    }

    public static String generateRandomInterrogationStyle() {
        int randomResult = random.nextInt(2);
        String[] interrogationStyles = {"O", "T"};
        return interrogationStyles[randomResult];
    }
}
