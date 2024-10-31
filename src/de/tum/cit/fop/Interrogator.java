package de.tum.cit.fop;

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
