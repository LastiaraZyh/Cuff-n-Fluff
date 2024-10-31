package de.tum.cit.fop;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        // Initialize penguins
        Penguin alice = new Penguin("Alice");
        Penguin bob = new Penguin("Bob");

        // Interrogator
        Interrogator interrogator = new Interrogator("Sherlock Holmes");
        InterrogationRoom room = new InterrogationRoom(interrogator);

        // Welcome message
        System.out.println("Welcome to the Cuff 'n' Fluff");

        // Alice makes her choice
        System.out.print("Do you want to betray (B) Bob or be silent (S)? ");
        String choiceAlice = scanner.nextLine().trim().toUpperCase();
        while (!choiceAlice.equals("B") && !choiceAlice.equals("S")) {
            System.out.print("Invalid choice. Please choose (B) or (S): ");
            choiceAlice = scanner.nextLine().trim().toUpperCase();
        }
        alice.setChoice(choiceAlice);
        System.out.println("Alice chose to " + (choiceAlice.equals("B") ? "betray" : "be silent") + ": " + choiceAlice);

        // Bob makes a random choice
        String choiceBob = random.nextBoolean() ? "B" : "S";
        bob.setChoice(choiceBob);
        System.out.println("Bob chose to " + (choiceBob.equals("B") ? "betray" : "be silent") + ": " + choiceBob);

        // Interrogate the penguins
        room.interrogate(alice, bob);

        // Display results
        System.out.println("Alice gets " + alice.getPrisonTime() + " years, and Bob gets " + bob.getPrisonTime() + " years in prison.");

        // Interrogator decides tactics
        System.out.println("The interrogator was not so happy with the result and decides to use tactics.");
        interrogator.setTactic(random.nextBoolean() ? "O" : "T");
        System.out.println("Interrogator " + interrogator.getName() + " employs " + (interrogator.getTactic().equals("O") ? "Offer Deal" : "Threaten") + " tactic.");

        // Apply tactics
        room.interrogatorUsesTactics(alice, bob);

        // Display final results
        System.out.println("After the interrogation with tactics, Alice gets " + alice.getPrisonTime() + " years, and Bob gets " + bob.getPrisonTime() + " years in prison.");
    }
}
