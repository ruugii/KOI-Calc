package models;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Competition {
    String name;
    ArrayList<Team> teams;
    ArrayList<Match> matches;
    ArrayList<Match> pendingMatches;


    public Competition(String name, ArrayList<Team> teams, ArrayList<Match> matches) {
        this.name = name;
        this.teams = teams;
        this.matches = matches;
        this.pendingMatches = getPendingMatches();
    }

    public void seeMatches() {
        System.out.println("Matches:");
        System.out.println("--------");
        System.out.println(this.matches.size() - this.pendingMatches.size() + " matches played");
        System.out.println(this.pendingMatches.size() + " matches pending");
        System.out.println("--------");
        System.out.println("Match List:");
        for (int i = 0; i < this.matches.size(); i++) {
            System.out.println(this.matches.get(i).toString());
        }
    }

    public void seePendingMatches() {
        System.out.println("Pending Matches:");
        System.out.println("----------------");
        System.out.println(this.pendingMatches.size() + " matches pending");
        System.out.println("--------");
        System.out.println("Match List:");
        for (int i = 0; i < this.pendingMatches.size(); i++) {
            System.out.println(this.pendingMatches.get(i).toString());
        }
    }

    public void seeResults() {
        System.out.println("Results:");
        System.out.println("--------");
        System.out.println(this.matches.size() - this.pendingMatches.size() + " matches played");
        System.out.println("--------");
        System.out.println("Match List:");
        for (int i = 0; i < this.matches.size(); i++) {
            if (!this.matches.get(i).isPending()) {
                System.out.println(this.matches.get(i).toString());
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }

    public ArrayList<Match> getPendingMatches() {
        ArrayList<Match> pendingMatches = new ArrayList<Match>();
        for (Match match : this.matches) {
            if (match.isPending()) {
                pendingMatches.add(match);
            }
        }
        return pendingMatches;
    }

    public ArrayList<String> getPendingMatchesToString() {
        ArrayList<String> pendingMatches = new ArrayList<String>();
        for (int i = 0; i < this.pendingMatches.size(); i++) {
            pendingMatches.add(this.pendingMatches.get(i).team1().name() + " - " + this.pendingMatches.get(i).team2().name());
        }
        return pendingMatches;
    }

    public void classification() {
        System.out.println("Classification:");
        System.out.println("---------------");
        this.teams.sort((team1, team2) -> {
            int team1Diference = team1.wins() - team1.losses();
            int team2Diference = team2.wins() - team2.losses();
            if (team1Diference == team2Diference) {
                return desempate(team1, team2);
            }
            return team2Diference - team1Diference;
        });
        for (int i = 0; i < this.teams.size(); i++) {
            System.out.println((i + 1) + ".- " + this.teams.get(i).name() + " | " + this.teams.get(i).wins() + " wins - " + this.teams.get(i).losses() + " losses");
        }
    }

    public int desempate(Team team1, Team team2) {
        for (int i = 0; i < this.matches.size(); i++) {
            if (this.matches.get(i).compareTeams(team1, team2)) {
                if (this.matches.get(i).getWinner() == team1) {
                    int team1Diference = team1.wins() - team1.losses();
                    int team2Diference = team2.wins() - team2.losses();
                    return team2Diference - (team1Diference + 1);
                } else if (this.matches.get(i).getWinner() == team2) {
                    int team1Diference = team1.wins() - team1.losses();
                    int team2Diference = team2.wins() - team2.losses();
                    return (team2Diference + 1) - team1Diference;
                }
            }
        }
        return 0;
    }

    public void simulateMatches() {
        ArrayList<Team> teams = this.teams;
        ArrayList<String> pendingMatches = getPendingMatchesToString();
        int currentMatch = 0;
        simulateMatchesRecursive(pendingMatches, teams, currentMatch);
    }

    private void simulateMatchesRecursive(ArrayList<String> pendingMatches, ArrayList<Team> teams, int currentMatch) {
        if (currentMatch < pendingMatches.size()) {
            String match = pendingMatches.get(currentMatch);
            System.out.println("Simulating match: " + match);
            String[] teamsNames = match.split(" - ");
            Team team1 = findTeam(teamsNames[0]);
            Team team2 = findTeam(teamsNames[1]);

            // Simulate team1 wins
            team1.addWin();
            team2.addloss();
            simulateMatchesRecursive(pendingMatches, teams, currentMatch + 1);
            // Revert the result
            team1.rmWin();
            team2.rmLoss();

            // Simulate team2 wins
            team1.addloss();
            team2.addWin();
            simulateMatchesRecursive(pendingMatches, teams, currentMatch + 1);
            // Revert the result
            team1.rmLoss();
            team2.rmWin();
        } else {
            printResults();
        }
    }

    private void printResults() {
        int total = 0;
        this.teams.sort((t1, t2) -> {
            if (t1.wins() != t2.wins()) {
                return t2.wins() - t1.wins();
            } else {
                return t1.losses() - t2.losses();
            }
        });
        final DecimalFormat df = new DecimalFormat("00.00");
        System.out.println(df.format((double) total / Math.pow (2, this.pendingMatches.size()) * 100) + "%");
        System.out.println(total + "/" + Math.pow (2, this.pendingMatches.size()));
        System.out.println("Standings:");
        int maxPosition = 0;
        if (this.name.equalsIgnoreCase("LEC")) {
            maxPosition = 8;
        } else if (this.name.equalsIgnoreCase("SUPERLIGA")) {
            maxPosition = 6;
        } else if (this.name.equalsIgnoreCase("VCT")) {
            maxPosition = 6;
        } else {
            maxPosition = 10;
        }

        for (int i = 0; i < maxPosition; i++) {
            Team team = this.teams.get(i);
            System.out.println((i + 1) + ".- " + team.name() + " | " + team.wins() + " wins - " + team.losses() + " losses");
            for (int j = 0; j < this.teams.size(); j++) {
                if (this.teams.get(j).name().equalsIgnoreCase(team.name()) && i == 0) {
                    teams.get(j).addTop1();
                }

                if (this.teams.get(j).name().equalsIgnoreCase(team.name()) && i == 1) {
                    teams.get(j).addTop2();
                }

                if (this.teams.get(j).name().equalsIgnoreCase(team.name()) && i == 2) {
                    teams.get(j).addTop3();
                }

                if (this.teams.get(j).name().equalsIgnoreCase(team.name()) && i == 3) {
                    teams.get(j).addTop4();
                }

                if (this.teams.get(j).name().equalsIgnoreCase(team.name()) && i == 4) {
                    teams.get(j).addTop5();
                }

                if (this.teams.get(j).name().equalsIgnoreCase(team.name()) && i == 5) {
                    teams.get(j).addTop6();
                }

                if (this.teams.get(j).name().equalsIgnoreCase(team.name()) && i == 6) {
                    teams.get(j).addTop7();
                }

                if (this.teams.get(j).name().equalsIgnoreCase(team.name()) && i == 7) {
                    teams.get(j).addTop8();
                }

                if (this.teams.get(j).name().equalsIgnoreCase(team.name()) && i == 8) {
                    teams.get(j).addTop9();
                }

                if (this.teams.get(j).name().equalsIgnoreCase(team.name()) && i == 9) {
                    teams.get(j).addTop10();
                }
            }
        }
        total ++;

        System.out.println("--------");
        for (int i = 0; i < this.teams.size(); i++) {
            System.out.println(this.teams.get(i).name() + ": " + df.format(((double) this.teams.get(i).GetTop() / total) * 100) + "%");
            System.out.println(this.teams.get(i));
        }
    }

    private Team findTeam(String name) {
        for (Team team : this.teams) {
            if (team.name().equalsIgnoreCase(name)) {
                return team;
            }
        }
        return null;
    }
}