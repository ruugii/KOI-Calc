package com.company;

import models.Team;

import java.util.ArrayList;

public class Main {

    static int countKOI = 0;
    static int countKOI1 = 0;
    static int countKOI2 = 0;
    static int countKOI3 = 0;
    static int countKOI4 = 0;
    static int countKOI5 = 0;
    static int countKOI6 = 0;
    
    static int total = 0;

    public static void main(String[] args) {
        ArrayList<Team> teams = new ArrayList<>();
        ArrayList<String> pendingMatches = new ArrayList<>();
        teams.add(new Team("FNATIC", 4, 0));
        teams.add(new Team("FUT Esports", 3, 1));
        teams.add(new Team("Team Vitality", 3, 1));
        teams.add(new Team("NAVI", 3, 1));
        teams.add(new Team("Team Liquid", 2, 2));
        teams.add(new Team("Giants", 2, 2));
        teams.add(new Team("Team Heretics", 1, 3));
        teams.add(new Team("KOI", 1, 3));
        teams.add(new Team("Karmine Corp", 1, 3));
        teams.add(new Team("BBL Esports", 0, 4));

        pendingMatches.add("TEAM LIQUID - TEAM HERETICS");
        pendingMatches.add("KOI - FNATIC");
        pendingMatches.add("GIANTS - FUT ESPORTS");
        pendingMatches.add("NAVI - KARMINE CORP");
        pendingMatches.add("TEAM VITALITY - BBL ESPORTS");
        pendingMatches.add("TEAM LIQUID - GIANTS");
        pendingMatches.add("TEAM HERETICS - BBL ESPORTS");
        pendingMatches.add("KOI - KARMINE CORP");
        pendingMatches.add("FUT ESPORTS - FNATIC");
        pendingMatches.add("TEAM VITALITY - NAVI");
        pendingMatches.add("TEAM VITALITY - FNATIC");
        pendingMatches.add("KARMINE CORP - FUT ESPORTS");
        pendingMatches.add("BBL ESPORTS - KOI");
        pendingMatches.add("TEAM LIQUID - NAVI");
        pendingMatches.add("TEAM HERETICS - GIANTS");
        pendingMatches.add("TEAM VITALITY - GIANTS");
        pendingMatches.add("NAVI - FUT ESPORTS");
        pendingMatches.add("KARMINE CORP - FNATIC");
        pendingMatches.add("TEAM LIQUID - BBL ESPORTS");
        pendingMatches.add("TEAM HERETICS - KOI");
        pendingMatches.add("NAVI - FNATIC");
        pendingMatches.add("TEAM VITALITY - TEAM HERETICS");
        pendingMatches.add("KARMINE CORP - GIANTS");
        pendingMatches.add("TEAM LIQUID - KOI");
        pendingMatches.add("FUT ESPORTS - BBL ESPORTS");

        simulateMatches(teams, pendingMatches ,0);

        System.out.println("KOI PASA EN UN " + ((double) countKOI / total) * 100 + "%");
        System.out.println("Como primero en un " + ((double) countKOI1 / countKOI) * 100 + "%");
        System.out.println("Como segundo en un " + ((double) countKOI2 / countKOI) * 100 + "%");
        System.out.println("Como tercero en un " + ((double) countKOI3 / countKOI) * 100 + "%");
        System.out.println("Como cuarto en un " + ((double) countKOI4 / countKOI) * 100 + "%");
        System.out.println("Como quinto en un " + ((double) countKOI5 / countKOI) * 100 + "%");
        System.out.println("Como sexto en un " + ((double) countKOI6 / countKOI) * 100 + "%");
    }
    private static void simulateMatches(ArrayList<Team> teams, ArrayList<String> pendingMatches, int currentMatch) {
        if (currentMatch == pendingMatches.size()) {
            printResults(teams, pendingMatches);
            return;
        }

        String match = pendingMatches.get(currentMatch);
        String[] teamNames = match.split(" - ");
        Team team1 = findTeam(teams, teamNames[0]);
        Team team2 = findTeam(teams, teamNames[1]);

        // Simulate team1 wins
        team1.addWin();
        team2.addloss();
        simulateMatches(teams, pendingMatches, currentMatch + 1);

        // Revert the result
        team1.rmWin();
        team2.rmLoss();

        // Simulate team2 wins
        team1.addloss();
        team2.addWin();
        simulateMatches(teams, pendingMatches, currentMatch + 1);

        // Revert the result
        team1.rmLoss();
        team2.rmWin();
    }

    private static void printResults(ArrayList<Team> teams, ArrayList<String> matches) {
        teams.sort((t1, t2) -> {
            if (t1.wins() != t2.wins()) {
                return t2.wins() - t1.wins();
            } else {
                return t1.losses() - t2.losses();
            }
        });
        System.out.println(total + "/" + Math.pow(2, matches.size()));
        System.out.println("Standings:");
        boolean is_KOI = false;
        for (int i = 0; i < 6; i++) {
            Team team = teams.get(i);
            System.out.println((i + 1) + ". " + team.name() + " - " + team.wins() + "V-" + team.losses() + "D");
            if (team.name().equalsIgnoreCase("KOI") && i == 0){
                countKOI1 ++;
                countKOI ++;
                is_KOI = true;
            }
            if (team.name().equalsIgnoreCase("KOI") && i == 1){
                countKOI2 ++;
                countKOI ++;
                is_KOI = true;
            }
            if (team.name().equalsIgnoreCase("KOI") && i == 2){
                countKOI3 ++;
                countKOI ++;
                is_KOI = true;
            }
            if (team.name().equalsIgnoreCase("KOI") && i == 3){
                countKOI4 ++;
                countKOI ++;
                is_KOI = true;
            }
            if (team.name().equalsIgnoreCase("KOI") && i == 4){
                countKOI5 ++;
                countKOI ++;
                is_KOI = true;
            }
            if (team.name().equalsIgnoreCase("KOI") && i == 5){
                countKOI6 ++;
                countKOI ++;
                is_KOI = true;
            }
        }
        total ++;
        System.out.println("KOI it's qualifyed in a " + ((double) countKOI / total) * 100 + "%");
        System.out.println();
    }

    private static Team findTeam(ArrayList<Team> teams, String name) {
        for (Team team : teams) {
            if (team.name().equalsIgnoreCase(name)) {
                return team;
            }
        }
        return null;
    }

}
