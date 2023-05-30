package models;

import java.text.DecimalFormat;

public class Team {
    private String name;
    private int win;
    private int losses;
    private int top, top1, top2, top3, top4, top5, top6, top7, top8, top9, top10 = 0;

    public Team(String name, int win, int losses) {
        this.name = name;
        this.win = win;
        this.losses = losses;
        this.top = 0;
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

    public int GetTop () {
        return this.top;
    }

    public void top() {
        this.top ++;
    }

    public void addTop1() {
        this.top1 ++;
        top();
    }

    public void addTop2() {
        this.top2 ++;
        top();
    }

    public void addTop3() {
        this.top3 ++;
        top();
    }

    public void addTop4() {
        this.top4 ++;
        top();
    }

    public void addTop5() {
        this.top5 ++;
        top();
    }

    public void addTop6() {
        this.top6 ++;
        top();
    }

    public void addTop7() {
        this.top7 ++;
        top();
    }

    public void addTop8() {
        this.top8 ++;
        top();
    }

    public void addTop9() {
        this.top9 ++;
        top();
    }

    public void addTop10() {
        this.top10 ++;
        top();
    }

    @Override
    public String toString() {
        final DecimalFormat df = new DecimalFormat("00.00");
        String top1 = (df.format(((double) this.top1 / this.top) * 100));
        String top2 = (df.format(((double) this.top2 / this.top) * 100));
        String top3 = (df.format(((double) this.top3 / this.top) * 100));
        String top4 = (df.format(((double) this.top4 / this.top) * 100));
        String top5 = (df.format(((double) this.top5 / this.top) * 100));
        String top6 = (df.format(((double) this.top6 / this.top) * 100));
        String top7 = (df.format(((double) this.top7 / this.top) * 100));
        String top8 = (df.format(((double) this.top8 / this.top) * 100));
        String top9 = (df.format(((double) this.top9 / this.top) * 100));
        String top10 = (df.format(((double) this.top10 / this.top) * 100));

        return "\t" +
                "Top 1: " + top1 +"%\n\t" +
                "Top 2: " + top2 +"%\n\t" +
                "Top 3: " + top3 +"%\n\t" +
                "Top 4: " + top4 +"%\n\t" +
                "Top 5: " + top5 +"%\n\t" +
                "Top 6: " + top6 +"%\n\t" +
                "Top 7: " + top7 +"%\n\t" +
                "Top 8: " + top8 +"%\n\t" +
                "Top 9: " + top9 +"%\n\t" +
                "Top 10: " + top10 +"%\n\t";
    }
}
