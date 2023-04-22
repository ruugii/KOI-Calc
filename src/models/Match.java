package models;

public class Match {
    private Team team1;
    private Team team2;
    private Team winner;

    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public Match(Team team1, Team team2, int winner) {
        this.team1 = team1;
        this.team2 = team2;
        setWinner(winner);
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
}
