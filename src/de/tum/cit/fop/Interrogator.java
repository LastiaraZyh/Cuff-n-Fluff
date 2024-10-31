package de.tum.cit.fop;

public class Interrogator {
    private String name;
    private String tactic; // Tactics can be "NONE", "O", or "T"

    // Constructor
    public Interrogator(String name) {
        this.name = name;
        this.tactic = "NONE"; // Initial tactic is NONE
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getTactic() {
        return tactic;
    }

    public void setTactic(String tactic) {
        this.tactic = tactic;
    }
}

