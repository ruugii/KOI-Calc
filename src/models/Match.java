package models;

public class Match {
    private Team team1;
    private Team team2;
    private Team winner;
    private String time;
    private String date;

    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public Match(Team team1, Team team2, int winner) {
        this.team1 = team1;
        this.team2 = team2;
        setWinner(winner);
    }

    public Match(Team team1, Team team2, String date, String time) {
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.time = time;
    }

    public Match(Team team1, Team team2, String time, int winner) {
        this.team1 = team1;
        this.team2 = team2;
        this.time = time;
        setWinner(winner);
    }

    public Match(Team team1, Team team2, String date, String time, int winner) {
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.time = time;
        setWinner(winner);
    }

    public boolean isPending() {
        return this.winner == null;
    }

    private void setWinner(int winner) {
        switch (winner) {
            case 1:
                team1Win();
                this.winner = this.team1;
                break;
            case 2:
                team2Win();
                this.winner = this.team2;
                break;
        }
    }

    public Team team1() {
        return this.team1;
    }

    public Team team2() {
        return this.team2;
    }

    public void team1Win() {
        this.team1.addWin();
        this.team2.addloss();
    }

    public void team2Win() {
        this.team2.addWin();
        this.team1.addloss();
    }

    public Team getWinner() {
        return this.winner;
    }

    public boolean compareTeams(Team team1, Team team2){
        if (this.team1 == team1 && this.team2 == team2) {
            return true;
        } else if (this.team1 == team2 && this.team2 == team1) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        boolean haveWinner = this.winner != null;
        boolean haveTime = this.time != null;
        if (haveWinner) {
            if (haveTime) {
                return "" + this.team1.name() + " vs " + this.team2.name() + " - " + this.date + " | " + this.date + " - " + this.winner.name() + " won";
            } else {
                return "" + this.team1.name() + " vs " + this.team2.name() + " - " + this.winner.name() + " won";
            }
        } else {
            if (haveTime) {
                return "" + this.team1.name() + " vs " + this.team2.name() + " - " + this.date + " | " + this.time + " - Pending";
            } else {
                return "" + this.team1.name() + " vs " + this.team2.name() + " - Pending";
            }
        }
    }
}
