package de.tum.cit.fop;

public class Penguin {
    private String name;
    private String choice; // Choices can be "B" or "S"
    private int prisonTime; // Prison time in years

    // Constructor
    public Penguin(String name) {
        this.name = name;
        this.choice = "NONE"; // Initial choice is NONE
        this.prisonTime = 0;   // Initial prison time is 0
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public int getPrisonTime() {
        return prisonTime;
    }

    public void setPrisonTime(int prisonTime) {
        this.prisonTime = prisonTime;
    }
}
