package models;

public class Team {
    private String name;
    private int win;
    private int losses;

    public Team(String name, int win, int losses) {
        this.name = name;
        this.win = win;
        this.losses = losses;
    }

    public void addWin () {
        this.win ++;
    }

    public void addloss(){
        this.losses ++;
    }

    public void rmWin () {
        this.win --;
    }

    public void rmLoss () {
        this.losses -- ;
    }

    public int wins () {
        return this.win;
    }

    public int losses () {
        return this.losses;
    }

    public String name () {
        return this.name;
    }
}
