package de.tum.cit.fop;

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
