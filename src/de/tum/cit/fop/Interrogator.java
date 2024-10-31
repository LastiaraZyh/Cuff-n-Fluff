package de.tum.cit.fop;

public class Interrogator {
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
