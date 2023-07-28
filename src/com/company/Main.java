package com.company;

import models.Competition;
import models.Match;
import models.Team;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int total = 0;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        final String menu = "De que competicion quieres hacer la prueba?\n\t1.- VCT\n\t2.- Superliga\n\t3.- LEC\n\t4.- Salir";
        int option = 0;
        do {
            option = readInt(menu, 1, 4);
            
            switch (option) {
                case 1:
                    getVCT();
                    break;
                case 2:
                    getSL();
                    break;
                case 3:
                    getLEC();
                    break;
                case 4:
                    System.out.println("saliendo...");
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (option != 4);
    }

    private static void getVCT() {
        final String menu = "De que split quieres ver la informacion?\n\t1.- 2023\n\t2.- 2024\n\t3.- Salir";
        int option = 0;
        do {
            option = readInt(menu, 1, 3);

            switch (option) {
                case 1:
                    getVCT2023();
                    break;
                case 2:
                    getVCT2024();
                    break;
                case 3:
                    System.out.println("saliendo...");
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (option != 3);
    }

    private static void getVCT2023() {
        ArrayList<Team> teams = new ArrayList<>();
        Team fnatic = new Team("FNATIC", 9, 0);
        Team navi = new Team("NAVI", 7,2);
        Team teamLiquid = new Team("Team Liquid", 6,3);
        Team giants = new Team("Giants", 5,4);
        Team futEsports = new Team("FUT Esports", 5,4);
        Team teamVitality = new Team("Team Vitality", 4,5);
        Team bblEsports = new Team("BBL Esports", 3,6);
        Team teamHeretics = new Team("Team Heretics", 2,7);
        Team koi = new Team("KOI", 2,7);
        Team karmineCorp = new Team("Karmine Corp", 2,7);
        
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
        
        ArrayList<Match> pendingMatchesList = new ArrayList<>();
        System.out.println("VCT SPLIT 1");
        Competition VCT = new Competition("VCT SPLIT 1", teams, pendingMatchesList);
        VCT.classification();
    }

    private static void getVCT2024() {
        ArrayList<Team> teams = new ArrayList<>();
        Team fnatic = new Team("FNATIC", 0, 0);
        Team navi = new Team("NAVI", 0,0);
        Team teamLiquid = new Team("Team Liquid", 0,0);
        Team giants = new Team("Giants", 0,0);
        Team futEsports = new Team("FUT Esports", 0,0);
        Team teamVitality = new Team("Team Vitality", 0,0);
        Team bblEsports = new Team("BBL Esports", 0,0);
        Team teamHeretics = new Team("Team Heretics", 0,0);
        Team koi = new Team("KOI", 0,0);
        Team karmineCorp = new Team("Karmine Corp", 0,0);
        Team M8 = new Team("Gentle Mates", 0,0);
        
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
        teams.add(M8);
        
        ArrayList<Match> pendingMatchesList = new ArrayList<>();
        // KOI matches
        pendingMatchesList.add(new Match(koi, M8));
        pendingMatchesList.add(new Match(koi, bblEsports));
        pendingMatchesList.add(new Match(koi, karmineCorp));
        pendingMatchesList.add(new Match(koi, teamHeretics));
        pendingMatchesList.add(new Match(koi, teamVitality));
        pendingMatchesList.add(new Match(koi, futEsports));
        pendingMatchesList.add(new Match(koi, giants));
        pendingMatchesList.add(new Match(koi, teamLiquid));
        pendingMatchesList.add(new Match(koi, navi));
        pendingMatchesList.add(new Match(koi, fnatic));

        // ASC matches
        pendingMatchesList.add(new Match(M8, bblEsports));
        pendingMatchesList.add(new Match(M8, karmineCorp));
        pendingMatchesList.add(new Match(M8, teamHeretics));
        pendingMatchesList.add(new Match(M8, teamVitality));
        pendingMatchesList.add(new Match(M8, futEsports));
        pendingMatchesList.add(new Match(M8, giants));
        pendingMatchesList.add(new Match(M8, teamLiquid));
        pendingMatchesList.add(new Match(M8, navi));
        pendingMatchesList.add(new Match(M8, fnatic));

        // BBL matches
        pendingMatchesList.add(new Match(bblEsports, karmineCorp));
        pendingMatchesList.add(new Match(bblEsports, teamHeretics));
        pendingMatchesList.add(new Match(bblEsports, teamVitality));
        pendingMatchesList.add(new Match(bblEsports, futEsports));
        pendingMatchesList.add(new Match(bblEsports, giants));
        pendingMatchesList.add(new Match(bblEsports, teamLiquid));
        pendingMatchesList.add(new Match(bblEsports, navi));
        pendingMatchesList.add(new Match(bblEsports, fnatic));

        // KAR matches
        pendingMatchesList.add(new Match(karmineCorp, teamHeretics));
        pendingMatchesList.add(new Match(karmineCorp, teamVitality));
        pendingMatchesList.add(new Match(karmineCorp, futEsports));
        pendingMatchesList.add(new Match(karmineCorp, giants));
        pendingMatchesList.add(new Match(karmineCorp, teamLiquid));
        pendingMatchesList.add(new Match(karmineCorp, navi));
        pendingMatchesList.add(new Match(karmineCorp, fnatic));

        // HER matches
        pendingMatchesList.add(new Match(teamHeretics, teamVitality));
        pendingMatchesList.add(new Match(teamHeretics, futEsports));
        pendingMatchesList.add(new Match(teamHeretics, giants));
        pendingMatchesList.add(new Match(teamHeretics, teamLiquid));
        pendingMatchesList.add(new Match(teamHeretics, navi));
        pendingMatchesList.add(new Match(teamHeretics, fnatic));

        // VIT matches
        pendingMatchesList.add(new Match(teamVitality, futEsports));
        pendingMatchesList.add(new Match(teamVitality, giants));
        pendingMatchesList.add(new Match(teamVitality, teamLiquid));
        pendingMatchesList.add(new Match(teamVitality, navi));
        pendingMatchesList.add(new Match(teamVitality, fnatic));

        // FUT matches
        pendingMatchesList.add(new Match(futEsports, giants));
        pendingMatchesList.add(new Match(futEsports, teamLiquid));
        pendingMatchesList.add(new Match(futEsports, navi));
        pendingMatchesList.add(new Match(futEsports, fnatic));

        // GIA matches
        pendingMatchesList.add(new Match(giants, teamLiquid));
        pendingMatchesList.add(new Match(giants, navi));
        pendingMatchesList.add(new Match(giants, fnatic));

        // TL matches
        pendingMatchesList.add(new Match(teamLiquid, navi));
        pendingMatchesList.add(new Match(teamLiquid, fnatic));

        // NAVI matches
        pendingMatchesList.add(new Match(navi, fnatic));

        System.out.println("VCT SPLIT 2");
        Competition VCT = new Competition("VCT", teams, pendingMatchesList);

        int option = 0;
        do {
            final String menu = "Que quieres hacer?\n\t1.- Simular partidos\n\t2.- Ver todos los partidos\n\t3.- Ver partidos pendientes\n\t4.- Ver Resultados\n\t5.- Ver clasificacion\n\t6.- Salir";
            option = readInt(menu, 1, 6);

            switch (option) {
                case 1:
                    simulateMatches(VCT.getTeams(), VCT.getPendingMatchesToString(), 0, VCT.getName());
                    for (int i = 0; i < teams.size(); i++) {
                        final DecimalFormat df = new DecimalFormat("00.00");
                        System.out.println(teams.get(i).name() + ": " + df.format(((double) teams.get(i).GetTop() / total) * 100) + "%");
                        System.out.println(teams.get(i));
                    }
                    break;
                case 2:
                    VCT.seeMatches();
                    break;
                case 3:
                    VCT.seePendingMatches();
                    break;
                case 4:
                    VCT.seeResults();
                    break;
                case 5:
                    VCT.classification();
                    break;
                case 6:
                    System.out.println("saliendo...");
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (option != 6);
    }

    private static void getSL() {
        final String menu = "De que split quieres ver la informacion?\n\t1.- 2023 Summer\n\t2.- Salir";
        int option = 0;
        do {
            option = readInt(menu, 1, 2);

            switch (option) {
                case 1:
                    getSL2023Summer();
                    break;
                case 2:
                    System.out.println("saliendo...");
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (option != 2);
    }

    private static void getSL2023Summer() {
        ArrayList<Team> teams = new ArrayList<>();
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
        {
            pendingMatchesList.add(new Match(KOI, Bisons, 1));
            pendingMatchesList.add(new Match(Guasones, FCB, 2));
            pendingMatchesList.add(new Match(Rebels, UCAM, 1));
            pendingMatchesList.add(new Match(Heretics, Riders, 1));
            pendingMatchesList.add(new Match(Giants, Fnatic, 1));
        }
        
        
        // JORNADA 2
        {
            pendingMatchesList.add(new Match(KOI, Guasones, 1));
            pendingMatchesList.add(new Match(Bisons, Rebels, 1));
            pendingMatchesList.add(new Match(UCAM, Giants, 2));
            pendingMatchesList.add(new Match(FCB, Heretics, 2));
            pendingMatchesList.add(new Match(Riders, Fnatic, 1));
        }
        
        // JORNADA 3
        {
            pendingMatchesList.add(new Match(Guasones, Heretics, 1));
            pendingMatchesList.add(new Match(FCB, Fnatic, 1));
            pendingMatchesList.add(new Match(UCAM, Riders, 2));
            pendingMatchesList.add(new Match(Bisons, Giants, 1));
            pendingMatchesList.add(new Match(KOI, Rebels, 1));
        }

        // JORNADA 4
        {
            pendingMatchesList.add(new Match(FCB, UCAM, 1));
            pendingMatchesList.add(new Match(Guasones, Fnatic, 2));
            pendingMatchesList.add(new Match(Rebels, Giants, 1));
            pendingMatchesList.add(new Match(KOI, Heretics, 2));
            pendingMatchesList.add(new Match(Bisons, Riders, 1));
        }

        // JORNADA 5
        {
            pendingMatchesList.add(new Match(Heretics, Fnatic, 1));
            pendingMatchesList.add(new Match(Guasones, UCAM, 2));
            pendingMatchesList.add(new Match(Rebels, Riders, 2));
            pendingMatchesList.add(new Match(KOI, Giants, 2));
            pendingMatchesList.add(new Match(Bisons, FCB, 1));
        }

        // JORNADA 6
        {
            pendingMatchesList.add(new Match(UCAM, Heretics, 1));
            pendingMatchesList.add(new Match(Bisons, Guasones, 1));
            pendingMatchesList.add(new Match(KOI, Fnatic, 1));
            pendingMatchesList.add(new Match(Giants, Riders, 2));
            pendingMatchesList.add(new Match(FCB, Rebels, 2));
        }

        // JORNADA 7
        {
            pendingMatchesList.add(new Match(UCAM, Fnatic, 1));
            pendingMatchesList.add(new Match(Guasones, Rebels,2));
            pendingMatchesList.add(new Match(Bisons, Heretics, 1));
            pendingMatchesList.add(new Match(FCB, Giants, 2));
            pendingMatchesList.add(new Match(KOI, Riders, 2));
        }

        // JORNADA 8
        {
            pendingMatchesList.add(new Match(Bisons, Fnatic, 1));
            pendingMatchesList.add(new Match(Guasones, Giants, 1));
            pendingMatchesList.add(new Match(KOI, UCAM, 1));
            pendingMatchesList.add(new Match(Rebels, Heretics, 2));
            pendingMatchesList.add(new Match(FCB, Riders, 1));
        }

        // JORNADA 9
        {
            pendingMatchesList.add(new Match(Bisons, UCAM, "22/06/2023", "18:00", 1));
            pendingMatchesList.add(new Match(Rebels, Fnatic, "22/06/2023", "19:00", 1));
            pendingMatchesList.add(new Match(Guasones, Riders, "22/06/2023", "20:00", 2));
            pendingMatchesList.add(new Match(KOI, FCB, "22/06/2023", "21:00", 1));
            pendingMatchesList.add(new Match(Heretics, Giants, "22/06/2023", "22:00", 1));
        }

        // JORNADA 10
        {
            pendingMatchesList.add(new Match(Rebels, UCAM, "27/06/2023", "18:00", 2));
            pendingMatchesList.add(new Match(Giants, Fnatic, "27/06/2023", "19:00", 1));
            pendingMatchesList.add(new Match(Guasones, FCB, "27/06/2023", "20:00", 2));
            pendingMatchesList.add(new Match(KOI, Bisons, "27/06/2023", "21:00", 2));
            pendingMatchesList.add(new Match(Heretics, Riders, "27/06/2023", "22:00", 2));
        }

        // JORNADA 11
        {
            pendingMatchesList.add(new Match(Riders, Fnatic, "29/06/2023", "18:00", 2));
            pendingMatchesList.add(new Match(KOI, Guasones, "29/06/2023", "19:00", 1));
            pendingMatchesList.add(new Match(UCAM, Giants, "29/06/2023", "20:00", 2));
            pendingMatchesList.add(new Match(Bisons, Rebels, "29/06/2023", "21:00", 1));
            pendingMatchesList.add(new Match(FCB, Heretics, "29/06/2023", "22:00", 2));
        }

        // JORNADA 12
        {
            pendingMatchesList.add(new Match(FCB, Fnatic, "04/07/2023", "18:00", 1));
            pendingMatchesList.add(new Match(Guasones, Heretics, "04/07/2023", "19:00", 2));
            pendingMatchesList.add(new Match(KOI, Rebels, "04/07/2023", "20:00", 1));
            pendingMatchesList.add(new Match(Bisons, Giants, "04/07/2023", "21:00", 2));
            pendingMatchesList.add(new Match(UCAM, Riders, "04/07/2023", "22:00", 1));
        }

        // JORNADA 13
        {
            pendingMatchesList.add(new Match(Guasones, Fnatic, "08/07/2023", "18:00", 1));
            pendingMatchesList.add(new Match(FCB, UCAM, "08/07/2023", "19:00", 1));
            pendingMatchesList.add(new Match(Rebels, Giants, "08/07/2023", "20:00", 2));
            pendingMatchesList.add(new Match(KOI, Heretics, "08/07/2023", "21:00", 2));
            pendingMatchesList.add(new Match(Bisons, Riders, "08/07/2023", "22:00", 1));
        }

        // JORNADA 14
        {
            pendingMatchesList.add(new Match(Guasones, UCAM, "09/07/2023", "18:00", 1));
            pendingMatchesList.add(new Match(Bisons, FCB, "09/07/2023", "19:00", 2));
            pendingMatchesList.add(new Match(Rebels, Riders, "09/07/2023", "20:00", 2));
            pendingMatchesList.add(new Match(KOI, Giants, "09/07/2023", "21:00", 2));
            pendingMatchesList.add(new Match(Heretics, Fnatic, "09/07/2023", "22:00", 1));
        }

        // JORNADA 15
        {
            pendingMatchesList.add(new Match(UCAM, Heretics, "11/07/2023", "18:00", 2));
            pendingMatchesList.add(new Match(FCB, Rebels, "11/07/2023", "19:00", 1));
            pendingMatchesList.add(new Match(Bisons, Guasones, "11/07/2023", "20:00", 1));
            pendingMatchesList.add(new Match(Giants, Riders, "11/07/2023", "21:00", 2));
            pendingMatchesList.add(new Match(KOI, Fnatic, "11/07/2023", "22:00", 2));
        }

        // JORNADA 16
        {
            pendingMatchesList.add(new Match(UCAM, Fnatic, "13/07/2023", "18:00", 2));
            pendingMatchesList.add(new Match(Guasones, Rebels, "13/07/2023", "19:00", 2));
            pendingMatchesList.add(new Match(Bisons, Heretics, "13/07/2023", "20:00", 1));
            pendingMatchesList.add(new Match(KOI, Riders, "13/07/2023", "21:00", 2));
            pendingMatchesList.add(new Match(FCB, Giants, "13/07/2023", "22:00", 1));
        }

        // JORNADA 17
        {
            pendingMatchesList.add(new Match(Bisons, Fnatic, "18/07/2023", "18:00", 2));
            pendingMatchesList.add(new Match(KOI, UCAM, "18/07/2023", "19:00", 2));
            pendingMatchesList.add(new Match(Rebels, Heretics, "18/07/2023", "20:00", 1));
            pendingMatchesList.add(new Match(FCB, Riders, "18/07/2023", "21:00", 2));
            pendingMatchesList.add(new Match(Guasones, Giants, "18/07/2023", "22:00", 2));
        }

        // JORNADA 18
        {
            pendingMatchesList.add(new Match(Rebels, Fnatic, "20/07/2023", "18:00", 1));
            pendingMatchesList.add(new Match(Bisons, UCAM, "20/07/2023", "19:00", 2));
            pendingMatchesList.add(new Match(KOI, FCB, "20/07/2023", "20:00", 2));
            pendingMatchesList.add(new Match(Guasones, Riders, "20/07/2023", "21:00", 2));
            pendingMatchesList.add(new Match(Heretics, Giants, "20/07/2023", "22:00", 1));
        }

        Competition SL = new Competition("SUPERLIGA", teams, pendingMatchesList);
        int option = 0;
        do {
            option = 1;
            switch (option) {
                case 1:
                option = 6;
                    simulateMatches(SL.getTeams(), SL.getPendingMatchesToString(), 0, SL.getName());
                    for (int i = 0; i < teams.size(); i++) {
                        final DecimalFormat df = new DecimalFormat("00.00");
                        System.out.println(teams.get(i).name() + ": " + df.format(((double) teams.get(i).GetTop() / total) * 100) + "%");
                        System.out.println(teams.get(i));
                    }
                    break;
                case 2:
                    SL.seeMatches();
                    break;
                case 3:
                    SL.seePendingMatches();
                    break;
                case 4:
                    SL.seeResults();
                    break;
                case 5:
                    SL.classification();
                    break;
                case 6:
                    System.out.println("saliendo...");
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (option != 6);
    }

    private static void getLEC() {
        final String menu = "De que split quieres ver la informacion?\n\t1.- 2023 Summer\n\t2.- Salir";
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
                    getLEC2023Summer();
                    break;
                case 2:
                    System.out.println("saliendo...");
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (option != 2);
    }

    private static void getLEC2023Summer() {
        ArrayList <Team> teams = new ArrayList<>();
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
        // PLAYED MATCHES
        // JORNADA 1
        pendingMatchesList.add(new Match(MAD, VIT, "17/06/2023", "18:00", 1));
        pendingMatchesList.add(new Match(HER, SK, "17/06/2023", "19:00", 1));
        pendingMatchesList.add(new Match(KOI, EXC, "17/06/2023", "20:00", 1));
        pendingMatchesList.add(new Match(G2, BDS, "17/06/2023", "21:00", 1));
        pendingMatchesList.add(new Match(FNC, AST, "17/06/2023", "22:00", 1));

        // JORNADA 2
        pendingMatchesList.add(new Match(VIT, SK, "18/06/2023", "18:00", 1));
        pendingMatchesList.add(new Match(EXC, FNC, "18/06/2023", "19:00", 2));
        pendingMatchesList.add(new Match(MAD, G2, "18/06/2023", "20:00", 1));
        pendingMatchesList.add(new Match(KOI, BDS, "18/06/2023", "21:00", 2));
        pendingMatchesList.add(new Match(AST, HER, "18/06/2023", "22:00", 2));

        // JORNADA 3
        pendingMatchesList.add(new Match(EXC, SK, "19/06/2023", "18:00", 2));
        pendingMatchesList.add(new Match(BDS, AST, "19/06/2023", "19:00", 2));
        pendingMatchesList.add(new Match(MAD, KOI, "19/06/2023", "20:00", 1));
        pendingMatchesList.add(new Match(FNC, G2, "19/06/2023", "21:00", 2));
        pendingMatchesList.add(new Match(VIT, HER, "19/06/2023", "22:00", 2));

        // JORNADA 4
        pendingMatchesList.add(new Match(BDS, SK, "24/06/2023", "18:00", 1));
        pendingMatchesList.add(new Match(EXC, HER, "24/06/2023", "19:00", 1));
        pendingMatchesList.add(new Match(KOI, FNC, "24/06/2023", "20:00", 2));
        pendingMatchesList.add(new Match(VIT, G2, "24/06/2023", "21:00", 2));
        pendingMatchesList.add(new Match(MAD, AST, "24/06/2023", "22:00", 1));

        // JORNADA 5
        pendingMatchesList.add(new Match(EXC, BDS, "25/06/2023", "18:00", 1));
        pendingMatchesList.add(new Match(AST, VIT, "25/06/2023", "19:00", 1));
        pendingMatchesList.add(new Match(KOI, HER, "25/06/2023", "20:00", 1));
        pendingMatchesList.add(new Match(SK, G2, "25/06/2023", "21:00", 2));
        pendingMatchesList.add(new Match(MAD, FNC, "25/06/2023", "22:00", 2));

        // JORNADA 6
        pendingMatchesList.add(new Match(BDS, HER, "26/06/2023", "18:00", 2));
        pendingMatchesList.add(new Match(MAD, EXC, "26/06/2023", "19:00", 2));
        pendingMatchesList.add(new Match(AST, G2, "26/06/2023", "20:00", 2));
        pendingMatchesList.add(new Match(KOI, SK, "26/06/2023", "21:00", 2));
        pendingMatchesList.add(new Match(FNC, VIT, "26/06/2023", "22:00", 1));

        // JORNADA 7
        pendingMatchesList.add(new Match(AST, SK, "01/07/2023", "18:00", 1));
        pendingMatchesList.add(new Match(KOI, VIT, "01/07/2023", "19:00", 1));
        pendingMatchesList.add(new Match(EXC, G2, "01/07/2023", "20:00", 2));
        pendingMatchesList.add(new Match(BDS, FNC, "01/07/2023", "21:00", 2));
        pendingMatchesList.add(new Match(MAD, HER, "01/07/2023", "22:00", 2));

        // JORNADA 8
        pendingMatchesList.add(new Match(EXC, AST, "02/07/2023", "18:00", 1));
        pendingMatchesList.add(new Match(KOI, G2, "02/07/2023", "19:00", 2));
        pendingMatchesList.add(new Match(FNC, HER, "02/07/2023", "20:00", 1));
        pendingMatchesList.add(new Match(BDS, VIT, "02/07/2023", "21:00", 1));
        pendingMatchesList.add(new Match(MAD, SK, "02/07/2023", "22:00", 2));

        // JORNADA 9
        pendingMatchesList.add(new Match(EXC, VIT, "03/07/2023", "18:00", 1));
        pendingMatchesList.add(new Match(BDS, MAD, "03/07/2023", "19:00", 1));
        pendingMatchesList.add(new Match(KOI, AST, "03/07/2023", "20:00", 1));
        pendingMatchesList.add(new Match(HER, G2, "03/07/2023", "21:00", 2));
        pendingMatchesList.add(new Match(FNC, SK, "03/07/2023", "22:00", 2));

        Competition LEC = new Competition("LEC", teams, pendingMatchesList);
        
        LEC.classification();
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
        Team team1 = findTeam(teams, teamNames[0]);
        Team team2 = findTeam(teams, teamNames[1]);

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
        System.out.println(total/ Math.pow(2, matches.size()) * 100 + "%");
        System.out.println(total + "/" + Math.pow(2, matches.size()));
        System.out.println("Standings:");
        int maxPosition = 0;
        if (competition.equalsIgnoreCase("LEC")) {
            maxPosition = 8;
        } else if (competition.equalsIgnoreCase("SUPERLIGA")) {
            maxPosition = 6;
        } else if (competition.equalsIgnoreCase("VCT")) {
            maxPosition = 6;
        } else {
            maxPosition = 10;
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

    private static int readInt (String menu, int minNum, int maxNum) {
        int option = 0;
        boolean isInt = false;
        do {
            System.out.println(menu);
            isInt = input.hasNextInt();
            if (isInt) {
                option = input.nextInt();
                if (option < minNum || option > maxNum) {
                    System.out.println("Opcion no valida, el numero debe estar entre " + minNum + " y " + maxNum + "");
                    isInt = false;
                }
            } else {
                System.out.println("Opcion no valida");
                input.nextLine();
            }
        } while (!isInt);
        input.nextLine();
        return option;
    }
}
