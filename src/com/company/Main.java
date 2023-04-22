package com.company;

import models.Match;
import models.Team;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

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
        final String menu = "De que competicion quieres hacer la prueba?\n\t1.- VCT\n\t2.-e-laLiga\n\t3.-Salir";
        Scanner input = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println(menu);
            boolean isInt = input.hasNextInt();

            if (isInt) {
                option = input.nextInt();
            } else {
                option = 0;
            }
            
            switch (option) {
                case 0:
                    System.out.println("Opcion no valida");
                    break;
                case 1:
                    getVCT();
                    break;
                case 2:
                    getELaLiga();
                    break;
            }
        } while (option != 3);


    }

    public static void getELaLiga() {
        System.out.println("We are working on it");
    }

    public static void getVCT() {
        ArrayList<Team> teams = new ArrayList<>();
        ArrayList<String> pendingMatches = new ArrayList<>();
        ArrayList<Match> pendingMatchesList = new ArrayList<>();
        Team fnatic = new Team("FNATIC", 4, 0);
        Team futEsports = new Team("FUT Esports", 3, 1);
        Team teamVitality = new Team("Team Vitality", 3, 1);
        Team navi = new Team("NAVI", 3, 1);
        Team teamLiquid = new Team("Team Liquid", 2, 2);
        Team giants = new Team("Giants", 2, 2);
        Team teamHeretics = new Team("Team Heretics", 1, 3);
        Team koi = new Team("KOI", 1, 3);
        Team karmineCorp = new Team("Karmine Corp", 1, 3);
        Team bblEsports = new Team("BBL Esports", 0, 4);

        teams.add(fnatic);
        teams.add(futEsports);
        teams.add(teamVitality);
        teams.add(navi);
        teams.add(teamLiquid);
        teams.add(giants);
        teams.add(teamHeretics);
        teams.add(koi);
        teams.add(karmineCorp);
        teams.add(bblEsports);

        // pendingMatches.add("TEAM LIQUID - TEAM HERETICS");
        pendingMatches.add("KOI - FNATIC");
        // pendingMatches.add("GIANTS - FUT ESPORTS");
        // pendingMatches.add("NAVI - KARMINE CORP");
        // pendingMatches.add("TEAM VITALITY - BBL ESPORTS");
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

        pendingMatchesList.add(new Match(teamLiquid, teamHeretics, 1));
        pendingMatchesList.add(new Match(koi, fnatic));
        pendingMatchesList.add(new Match(giants, futEsports, 1));
        pendingMatchesList.add(new Match(navi, karmineCorp, 1));
        pendingMatchesList.add(new Match(teamVitality, bblEsports, 2));
        pendingMatchesList.add(new Match(teamLiquid, giants));
        pendingMatchesList.add(new Match(teamHeretics, bblEsports));
        pendingMatchesList.add(new Match(koi, karmineCorp));
        pendingMatchesList.add(new Match(futEsports, fnatic));
        pendingMatchesList.add(new Match(teamVitality, navi));
        pendingMatchesList.add(new Match(teamVitality, fnatic));
        pendingMatchesList.add(new Match(karmineCorp, futEsports));
        pendingMatchesList.add(new Match(bblEsports, koi));
        pendingMatchesList.add(new Match(teamLiquid, navi));
        pendingMatchesList.add(new Match(teamHeretics, giants));
        pendingMatchesList.add(new Match(teamVitality, giants));
        pendingMatchesList.add(new Match(navi, futEsports));
        pendingMatchesList.add(new Match(karmineCorp, fnatic));
        pendingMatchesList.add(new Match(teamLiquid, bblEsports));
        pendingMatchesList.add(new Match(teamHeretics, koi));
        pendingMatchesList.add(new Match(navi, fnatic));
        pendingMatchesList.add(new Match(teamVitality, teamHeretics));
        pendingMatchesList.add(new Match(karmineCorp, giants));
        pendingMatchesList.add(new Match(teamLiquid, koi));
        pendingMatchesList.add(new Match(futEsports, bblEsports));

        System.out.println(bblEsports.wins());
        simulateMatches(teams, pendingMatches ,0);
        for (int i = 0; i < teams.size(); i++) {
            final DecimalFormat df = new DecimalFormat("00.00");
            System.out.println(teams.get(i).name() + ": " + df.format(((double) teams.get(i).GetTop() / total) * 100) + "%");
            System.out.println(teams.get(i));
        }
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
        System.out.println((double) total / Math.pow(2, matches.size()) * 100 + "%");
        System.out.println(total + "/" + Math.pow(2, matches.size()));
        System.out.println("Standings:");
        for (int i = 0; i < 6; i++) {
            Team team = teams.get(i);
            System.out.println((i + 1) + ". " + team.name() + " - " + team.wins() + "V-" + team.losses() + "D");
            for (int j = 0; j < teams.size(); j++) {
                if (teams.get(j).name().equalsIgnoreCase(team.name()) && i == 0){
                    teams.get(j).addTop1();
                }

                if (teams.get(j).name().equalsIgnoreCase(team.name()) && i == 1){
                    teams.get(j).addTop2();
                }

                if (teams.get(j).name().equalsIgnoreCase(team.name()) && i == 2){
                    teams.get(j).addTop3();
                }

                if (teams.get(j).name().equalsIgnoreCase(team.name()) && i == 3){
                    teams.get(j).addTop4();
                }

                if (teams.get(j).name().equalsIgnoreCase(team.name()) && i == 4){
                    teams.get(j).addTop5();
                }

                if (teams.get(j).name().equalsIgnoreCase(team.name()) && i == 5){
                    teams.get(j).addTop6();
                }
            }
        }
        total ++;
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
