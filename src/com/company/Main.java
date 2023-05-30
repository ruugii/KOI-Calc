package com.company;

import models.Match;
import models.Team;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int total = 0;

    public static void main(String[] args) {
        final String menu = "De que competicion quieres hacer la prueba?\n\t1.- VCT\n\t2.- Superliga\n\t3.- LEC\n\t4.- Salir";
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
                case 1:
                    getVCT();
                    break;
                case 2:
                    getSL();
                    System.out.println("saliendo...");
                    break;
                case 3:
                    getLEC();
                    System.out.println("saliendo...");
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (option != 4);


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

        pendingMatchesList.add(new Match(teamLiquid, teamHeretics, 1));
        pendingMatchesList.add(new Match(giants, futEsports, 1));
        pendingMatchesList.add(new Match(navi, karmineCorp, 1));
        pendingMatchesList.add(new Match(teamVitality, bblEsports, 2));
        pendingMatchesList.add(new Match(teamLiquid, giants, 1));
        pendingMatchesList.add(new Match(teamHeretics, bblEsports, 2));
        pendingMatchesList.add(new Match(koi, karmineCorp, 2));
        pendingMatchesList.add(new Match(futEsports, fnatic, 2));
        pendingMatchesList.add(new Match(teamVitality, navi,2));
        pendingMatchesList.add(new Match(teamVitality, fnatic,2));
        pendingMatchesList.add(new Match(karmineCorp, futEsports, 2));
        pendingMatchesList.add(new Match(bblEsports, koi, 1));
        pendingMatchesList.add(new Match(teamLiquid, navi, 2));
        pendingMatchesList.add(new Match(teamHeretics, giants, 1));
        pendingMatchesList.add(new Match(koi, fnatic, 2));
        pendingMatchesList.add(new Match(teamVitality, giants, 2));
        pendingMatchesList.add(new Match(navi, futEsports, 1));
        pendingMatchesList.add(new Match(karmineCorp, fnatic, 2));
        pendingMatchesList.add(new Match(teamLiquid, bblEsports, 1));
        pendingMatchesList.add(new Match(teamHeretics, koi, 2));
        pendingMatchesList.add(new Match(navi, fnatic, 2));
        pendingMatchesList.add(new Match(teamVitality, teamHeretics, 1));
        pendingMatchesList.add(new Match(karmineCorp, giants, 2));
        pendingMatchesList.add(new Match(teamLiquid, koi, 1));
        pendingMatchesList.add(new Match(futEsports, bblEsports, 1));

        simulateMatches(teams, pendingMatches ,0, "VCT");
        for (int i = 0; i < teams.size(); i++) {
            final DecimalFormat df = new DecimalFormat("00.00");
            System.out.println(teams.get(i).name() + ": " + df.format(((double) teams.get(i).GetTop() / total) * 100) + "%");
            System.out.println(teams.get(i));
        }
    }

    private static void simulateMatches(ArrayList<Team> teams, ArrayList<String> pendingMatches, int currentMatch, String comp) {
        if (currentMatch == pendingMatches.size()) {
            printResults(teams, pendingMatches, comp);
            return;
        }

        String match = pendingMatches.get(currentMatch);
        System.out.println(match);
        String[] teamNames = match.split(" - ");
        System.out.println(teamNames[0]);
        System.out.println(teamNames[1]);
        System.out.println(findTeam(teams, teamNames[1]));
        Team team1 = findTeam(teams, teamNames[0]);
        Team team2 = findTeam(teams, teamNames[1]);

        System.out.println(team1);
        System.out.println(team2);

        // Simulate team1 wins
        team1.addWin();
        team2.addloss();
        simulateMatches(teams, pendingMatches, currentMatch + 1, comp);

        // Revert the result
        team1.rmWin();
        team2.rmLoss();

        // Simulate team2 wins
        team1.addloss();
        team2.addWin();
        simulateMatches(teams, pendingMatches, currentMatch + 1, comp);

        // Revert the result
        team1.rmLoss();
        team2.rmWin();
    }

    private static void printResults(ArrayList<Team> teams, ArrayList<String> matches, String competition) {
        teams.sort((t1, t2) -> {
            if (t1.wins() != t2.wins()) {
                return t2.wins() - t1.wins();
            } else {
                return t1.losses() - t2.losses();
            }
        });
        final DecimalFormat df = new DecimalFormat("00.00");
        System.out.println(df.format((double) total / Math.pow(2, matches.size()) * 100) + "%");
        System.out.println(total + "/" + Math.pow(2, matches.size()));
        System.out.println("Standings:");
        int maxPosition = 0;
        if (competition.equalsIgnoreCase("LEC")) {
            maxPosition = 8;
        } else if (competition.equalsIgnoreCase("SUPERLIGA")) {
            maxPosition = 6;
        } else if (competition.equalsIgnoreCase("VCT")) {
            maxPosition = 6;
        }
        for (int i = 0; i < maxPosition; i++) {
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

                if (teams.get(j).name().equalsIgnoreCase(team.name()) && i == 6){
                    teams.get(j).addTop7();
                }

                if (teams.get(j).name().equalsIgnoreCase(team.name()) && i == 7){
                    teams.get(j).addTop8();
                }

                if (teams.get(j).name().equalsIgnoreCase(team.name()) && i == 8){
                    teams.get(j).addTop9();
                }

                if (teams.get(j).name().equalsIgnoreCase(team.name()) && i == 9){
                    teams.get(j).addTop10();
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

    public static void getSL() {
        ArrayList<Team> teams = new ArrayList<>();
        ArrayList<String> pendingMatches = new ArrayList<>();
        ArrayList<Match> pendingMatchesList = new ArrayList<>();
        Team Bisons = new Team("Bisons", 0, 0);
        Team KOI = new Team("KOI", 0, 0);
        Team Guasones = new Team("Guasones", 0, 0);
        Team FCB = new Team("FCB", 0, 0);
        Team Rebels = new Team("Rebels", 0, 0);
        Team UCAM = new Team("UCAM", 0, 0);
        Team Heretics = new Team("Heretics", 0, 0);
        Team Giants = new Team("Giants", 0, 0);
        Team Riders = new Team("Riders", 0, 0);
        Team Fnatic = new Team("Fnatic", 0, 0);
        
        teams.add(Giants);
        teams.add(Riders);
        teams.add(UCAM);
        teams.add(FCB);
        teams.add(Fnatic);
        teams.add(Heretics);
        teams.add(KOI);
        teams.add(Bisons);
        teams.add(Guasones);
        teams.add(Rebels);
        
        // FINISHED MATCHES
        // JORNADA 1
        pendingMatchesList.add(new Match(KOI, Bisons, 1));
        pendingMatchesList.add(new Match(Guasones, FCB, 2));
        pendingMatchesList.add(new Match(Rebels, UCAM, 1));
        pendingMatchesList.add(new Match(Heretics, Riders, 1));
        pendingMatchesList.add(new Match(Giants, Fnatic, 1));
        
        // JORNADA 2
        pendingMatchesList.add(new Match(KOI, Guasones, 1));
        pendingMatchesList.add(new Match(Bisons, Rebels, 1));
        pendingMatchesList.add(new Match(UCAM, Giants, 2));
        
        // ON GOING MATCHES
        pendingMatchesList.add(new Match(FCB, Heretics));
        
        // KOI matches
        pendingMatchesList.add(new Match(KOI, FCB));
        pendingMatches.add("KOI - FCB");
        pendingMatchesList.add(new Match(KOI, Rebels));
        pendingMatches.add("KOI - Rebels");
        pendingMatchesList.add(new Match(KOI, UCAM));
        pendingMatches.add("KOI - UCAM");
        pendingMatchesList.add(new Match(KOI, Heretics));
        pendingMatches.add("KOI - Heretics");
        pendingMatchesList.add(new Match(KOI, Giants));
        pendingMatches.add("KOI - Giants");
        pendingMatchesList.add(new Match(KOI, Riders));
        pendingMatches.add("KOI - Riders");
        pendingMatchesList.add(new Match(KOI, Fnatic));
        pendingMatches.add("KOI - Fnatic");
        pendingMatchesList.add(new Match(KOI, Bisons));
        pendingMatches.add("KOI - Bisons");
        pendingMatchesList.add(new Match(KOI, Guasones));
        pendingMatches.add("KOI - Guasones");
        pendingMatchesList.add(new Match(KOI, FCB));
        pendingMatches.add("KOI - FCB");
        pendingMatchesList.add(new Match(KOI, Rebels));
        pendingMatches.add("KOI - Rebels");
        pendingMatchesList.add(new Match(KOI, UCAM));
        pendingMatches.add("KOI - UCAM");
        pendingMatchesList.add(new Match(KOI, Heretics));
        pendingMatches.add("KOI - Heretics");
        pendingMatchesList.add(new Match(KOI, Giants));
        pendingMatches.add("KOI - Giants");
        pendingMatchesList.add(new Match(KOI, Riders));
        pendingMatches.add("KOI - Riders");
        pendingMatchesList.add(new Match(KOI, Fnatic));
        pendingMatches.add("KOI - Fnatic");

        // Bisons matches
        pendingMatchesList.add(new Match(Bisons, Guasones));
        pendingMatches.add("Bisons - Guasones");
        pendingMatchesList.add(new Match(Bisons, FCB));
        pendingMatches.add("Bisons - FCB");
        pendingMatchesList.add(new Match(Bisons, UCAM));
        pendingMatches.add("Bisons - UCAM");
        pendingMatchesList.add(new Match(Bisons, Heretics));
        pendingMatches.add("Bisons - Heretics");
        pendingMatchesList.add(new Match(Bisons, Giants));
        pendingMatches.add("Bisons - Giants");
        pendingMatchesList.add(new Match(Bisons, Riders));
        pendingMatches.add("Bisons - Riders");
        pendingMatchesList.add(new Match(Bisons, Fnatic));
        pendingMatches.add("Bisons - Fnatic");
        pendingMatchesList.add(new Match(Bisons, Guasones));
        pendingMatches.add("Bisons - Guasones");
        pendingMatchesList.add(new Match(Bisons, FCB));
        pendingMatches.add("Bisons - FCB");
        pendingMatchesList.add(new Match(Bisons, Rebels));
        pendingMatches.add("Bisons - Rebels");
        pendingMatchesList.add(new Match(Bisons, UCAM));
        pendingMatches.add("Bisons - UCAM");
        pendingMatchesList.add(new Match(Bisons, Heretics));
        pendingMatches.add("Bisons - Heretics");
        pendingMatchesList.add(new Match(Bisons, Giants));
        pendingMatches.add("Bisons - Giants");
        pendingMatchesList.add(new Match(Bisons, Riders));
        pendingMatches.add("Bisons - Riders");
        pendingMatchesList.add(new Match(Bisons, Fnatic));
        pendingMatches.add("Bisons - Fnatic");

        // Guasones matches
        pendingMatchesList.add(new Match(Guasones, Rebels));
        pendingMatches.add("Guasones - Rebels");
        pendingMatchesList.add(new Match(Guasones, UCAM));
        pendingMatches.add("Guasones - UCAM");
        pendingMatchesList.add(new Match(Guasones, Heretics));
        pendingMatches.add("Guasones - Heretics");
        pendingMatchesList.add(new Match(Guasones, Giants));
        pendingMatches.add("Guasones - Giants");
        pendingMatchesList.add(new Match(Guasones, Riders));
        pendingMatches.add("Guasones - Riders");
        pendingMatchesList.add(new Match(Guasones, Fnatic));
        pendingMatches.add("Guasones - Fnatic");
        pendingMatchesList.add(new Match(Guasones, FCB));
        pendingMatches.add("Guasones - FCB");
        pendingMatchesList.add(new Match(Guasones, Rebels));
        pendingMatches.add("Guasones - Rebels");
        pendingMatchesList.add(new Match(Guasones, UCAM));
        pendingMatches.add("Guasones - UCAM");
        pendingMatchesList.add(new Match(Guasones, Heretics));
        pendingMatches.add("Guasones - Heretics");
        pendingMatchesList.add(new Match(Guasones, Giants));
        pendingMatches.add("Guasones - Giants");
        pendingMatchesList.add(new Match(Guasones, Riders));
        pendingMatches.add("Guasones - Riders");
        pendingMatchesList.add(new Match(Guasones, Fnatic));
        pendingMatches.add("Guasones - Fnatic");

        // FCB matches
        pendingMatchesList.add(new Match(FCB, Rebels));
        pendingMatches.add("FCB - Rebels");
        pendingMatchesList.add(new Match(FCB, UCAM));
        pendingMatches.add("FCB - UCAM");
        pendingMatchesList.add(new Match(FCB, Giants));
        pendingMatches.add("FCB - Giants");
        pendingMatchesList.add(new Match(FCB, Riders));
        pendingMatches.add("FCB - Riders");
        pendingMatchesList.add(new Match(FCB, Fnatic));
        pendingMatches.add("FCB - Fnatic");
        pendingMatchesList.add(new Match(FCB, Rebels));
        pendingMatches.add("FCB - Rebels");
        pendingMatchesList.add(new Match(FCB, UCAM));
        pendingMatches.add("FCB - UCAM");
        pendingMatchesList.add(new Match(FCB, Heretics));
        pendingMatches.add("FCB - Heretics");
        pendingMatchesList.add(new Match(FCB, Giants));
        pendingMatches.add("FCB - Giants");
        pendingMatchesList.add(new Match(FCB, Riders));
        pendingMatches.add("FCB - Riders");
        pendingMatchesList.add(new Match(FCB, Fnatic));
        pendingMatches.add("FCB - Fnatic");
        
        // Rebels matches
        pendingMatchesList.add(new Match(Rebels, Heretics));
        pendingMatches.add("Rebels - Heretics");
        pendingMatchesList.add(new Match(Rebels, Giants));
        pendingMatches.add("Rebels - Giants");
        pendingMatchesList.add(new Match(Rebels, Riders));
        pendingMatches.add("Rebels - Riders");
        pendingMatchesList.add(new Match(Rebels, Fnatic));
        pendingMatches.add("Rebels - Fnatic");
        pendingMatchesList.add(new Match(Rebels, UCAM));
        pendingMatches.add("Rebels - UCAM");
        pendingMatchesList.add(new Match(Rebels, Heretics));
        pendingMatches.add("Rebels - Heretics");
        pendingMatchesList.add(new Match(Rebels, Giants));
        pendingMatches.add("Rebels - Giants");
        pendingMatchesList.add(new Match(Rebels, Riders));
        pendingMatches.add("Rebels - Riders");
        pendingMatchesList.add(new Match(Rebels, Fnatic));

        // UCAM matches
        pendingMatchesList.add(new Match(UCAM, Heretics));
        pendingMatches.add("UCAM - Heretics");
        pendingMatchesList.add(new Match(UCAM, Riders));
        pendingMatches.add("UCAM - Riders");
        pendingMatchesList.add(new Match(UCAM, Fnatic));
        pendingMatches.add("UCAM - Fnatic");
        pendingMatchesList.add(new Match(UCAM, Heretics));
        pendingMatches.add("UCAM - Heretics");
        pendingMatchesList.add(new Match(UCAM, Giants));
        pendingMatches.add("UCAM - Giants");
        pendingMatchesList.add(new Match(UCAM, Riders));
        pendingMatches.add("UCAM - Riders");
        pendingMatchesList.add(new Match(UCAM, Fnatic));
        pendingMatches.add("UCAM - Fnatic");

        // Heretics matches
        pendingMatchesList.add(new Match(Heretics, Giants));
        pendingMatches.add("Heretics - Giants");
        pendingMatchesList.add(new Match(Heretics, Fnatic));
        pendingMatches.add("Heretics - Fnatic");
        pendingMatchesList.add(new Match(Heretics, Giants));
        pendingMatches.add("Heretics - Giants");
        pendingMatchesList.add(new Match(Heretics, Riders));
        pendingMatches.add("Heretics - Riders");
        pendingMatchesList.add(new Match(Heretics, Fnatic));
        pendingMatches.add("Heretics - Fnatic");

        // Giants matches
        pendingMatchesList.add(new Match(Giants, Riders));
        pendingMatches.add("Giants - Riders");
        pendingMatchesList.add(new Match(Giants, Riders));
        pendingMatches.add("Giants - Riders");
        pendingMatchesList.add(new Match(Giants, Fnatic));
        pendingMatches.add("Giants - Fnatic");

        // Riders matches
        pendingMatchesList.add(new Match(Riders, Fnatic));
        pendingMatches.add("Riders - Fnatic");
        pendingMatchesList.add(new Match(Riders, Fnatic));
        pendingMatches.add("Riders - Fnatic");

        simulateMatches(teams, pendingMatches ,0, "SUPERLIGA");
        for (int i = 0; i < teams.size(); i++) {
            final DecimalFormat df = new DecimalFormat("00.00");
            System.out.println(teams.get(i).name() + ": " + df.format(((double) teams.get(i).GetTop() / total) * 100) + "%");
            System.out.println(teams.get(i));
        }
    }

    public static void getLEC() {
        ArrayList <Team> teams = new ArrayList<>();
        ArrayList <String> pendingMatches = new ArrayList<>();
        ArrayList <Match> pendingMatchesList = new ArrayList<>();
        Team MAD = new Team("MAD Lions", 0, 0);
        Team VIT = new Team("Vitality", 0, 0);
        Team HER = new Team("Heretics", 0, 0);
        Team SK = new Team("SK Gaming", 0, 0);
        Team KOI = new Team("KOI", 0, 0);
        Team EXC = new Team("Excel", 0, 0);
        Team G2 = new Team("G2 Esports", 0, 0);
        Team BDS = new Team("BDS", 0, 0);
        Team FNC = new Team("Fnatic", 0, 0);
        Team AST = new Team("Astralis", 0, 0);

        teams.add(MAD);
        teams.add(VIT);
        teams.add(HER);
        teams.add(SK);
        teams.add(KOI);
        teams.add(EXC);
        teams.add(G2);
        teams.add(BDS);
        teams.add(FNC);
        teams.add(AST);

        // PARTIDOS KOI
        pendingMatchesList.add(new Match(KOI, EXC));
        pendingMatches.add("KOI - Excel");
        pendingMatchesList.add(new Match(KOI, BDS));
        pendingMatches.add("KOI - BDS");
        pendingMatchesList.add(new Match(MAD, KOI));
        pendingMatches.add("MAD Lions - KOI");
        pendingMatchesList.add(new Match(KOI, FNC));
        pendingMatches.add("KOI - Fnatic");
        pendingMatchesList.add(new Match(KOI, AST));
        pendingMatches.add("KOI - Astralis");
        pendingMatchesList.add(new Match(KOI, VIT));
        pendingMatches.add("KOI - Vitality");
        pendingMatchesList.add(new Match(KOI, HER));
        pendingMatches.add("KOI - Heretics");
        pendingMatchesList.add(new Match(KOI, SK));
        pendingMatches.add("KOI - SK Gaming");
        pendingMatchesList.add(new Match(KOI, G2));
        pendingMatches.add("KOI - G2 Esports");

        // PARTIDOS MAD
        pendingMatchesList.add(new Match(MAD, EXC));
        pendingMatches.add("MAD Lions - Excel");
        pendingMatchesList.add(new Match(MAD, BDS));
        pendingMatches.add("MAD Lions - BDS");
        pendingMatchesList.add(new Match(MAD, FNC));
        pendingMatches.add("MAD Lions - Fnatic");
        pendingMatchesList.add(new Match(MAD, AST));
        pendingMatches.add("MAD Lions - Astralis");
        pendingMatchesList.add(new Match(MAD, VIT));
        pendingMatches.add("MAD Lions - Vitality");
        pendingMatchesList.add(new Match(MAD, HER));
        pendingMatches.add("MAD Lions - Heretics");
        pendingMatchesList.add(new Match(MAD, SK));
        pendingMatches.add("MAD Lions - SK Gaming");
        pendingMatchesList.add(new Match(MAD, G2));
        pendingMatches.add("MAD Lions - G2 Esports");

        // PARTIDOS EXC
        pendingMatchesList.add(new Match(EXC, BDS));
        pendingMatches.add("Excel - BDS");
        pendingMatchesList.add(new Match(EXC, FNC));
        pendingMatches.add("Excel - Fnatic");
        pendingMatchesList.add(new Match(EXC, AST));
        pendingMatches.add("Excel - Astralis");
        pendingMatchesList.add(new Match(EXC, VIT));
        pendingMatches.add("Excel - Vitality");
        pendingMatchesList.add(new Match(EXC, HER));
        pendingMatches.add("Excel - Heretics");
        pendingMatchesList.add(new Match(EXC, SK));
        pendingMatches.add("Excel - SK Gaming");
        pendingMatchesList.add(new Match(EXC, G2));
        pendingMatches.add("Excel - G2 Esports");

        // PARTIDOS BDS
        pendingMatchesList.add(new Match(BDS, FNC));
        pendingMatches.add("BDS - Fnatic");
        pendingMatchesList.add(new Match(BDS, AST));
        pendingMatches.add("BDS - Astralis");
        pendingMatchesList.add(new Match(BDS, VIT));
        pendingMatches.add("BDS - Vitality");
        pendingMatchesList.add(new Match(BDS, HER));
        pendingMatches.add("BDS - Heretics");
        pendingMatchesList.add(new Match(BDS, SK));
        pendingMatches.add("BDS - SK Gaming");
        pendingMatchesList.add(new Match(BDS, G2));
        pendingMatches.add("BDS - G2 Esports");

        // PARTIDOS FNC
        pendingMatchesList.add(new Match(FNC, AST));
        pendingMatches.add("Fnatic - Astralis");
        pendingMatchesList.add(new Match(FNC, VIT));
        pendingMatches.add("Fnatic - Vitality");
        pendingMatchesList.add(new Match(FNC, HER));
        pendingMatches.add("Fnatic - Heretics");
        pendingMatchesList.add(new Match(FNC, SK));
        pendingMatches.add("Fnatic - SK Gaming");
        pendingMatchesList.add(new Match(FNC, G2));
        pendingMatches.add("Fnatic - G2 Esports");

        // PARTIDOS AST
        pendingMatchesList.add(new Match(AST, VIT));
        pendingMatches.add("Astralis - Vitality");
        pendingMatchesList.add(new Match(AST, HER));
        pendingMatches.add("Astralis - Heretics");
        pendingMatchesList.add(new Match(AST, SK));
        pendingMatches.add("Astralis - SK Gaming");
        pendingMatchesList.add(new Match(AST, G2));
        pendingMatches.add("Astralis - G2 Esports");

        // PARTIDOS VIT
        pendingMatchesList.add(new Match(VIT, HER));
        pendingMatches.add("Vitality - Heretics");
        pendingMatchesList.add(new Match(VIT, SK));
        pendingMatches.add("Vitality - SK Gaming");
        pendingMatchesList.add(new Match(VIT, G2));
        pendingMatches.add("Vitality - G2 Esports");

        // PARTIDOS HER
        pendingMatchesList.add(new Match(HER, SK));
        pendingMatches.add("Heretics - SK Gaming");
        pendingMatchesList.add(new Match(HER, G2));
        pendingMatches.add("Heretics - G2 Esports");

        // PARTIDOS SK
        pendingMatchesList.add(new Match(SK, G2));
        pendingMatches.add("SK Gaming - G2 Esports");

        simulateMatches(teams, pendingMatches ,0, "LEC");
        for (int i = 0; i < teams.size(); i++) {
            final DecimalFormat df = new DecimalFormat("00.00");
            System.out.println(teams.get(i).name() + ": " + df.format(((double) teams.get(i).GetTop() / total) * 100) + "%");
            System.out.println(teams.get(i));
        }
    }
}
