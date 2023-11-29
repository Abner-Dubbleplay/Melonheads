package com.project;

import java.util.Scanner;

public class project{

    /*This is where I will create a quiz about Jose Ramirez's contract. I will ask the user to provide some information about
     *a player of their choosing, and will test to see if their contract was as big of a bargain as J-Ram's second contract
     *was for the Cleveland Indians/Guardians (5 yr, $25M + 2 tm options, stretching to 7 yr, $49M),
     *from the cheapness of the contract relative to the expected market value of the player,
     *to the value the player provided to the team while under contract, whether through WAR or awards such as Silver Slugger Awards,
     *All-Star appearances, and MVP finishes. */

    public static void main(String[] args){
        final int JOSE_PER_YEAR_SALARY = 5;
        final int JOSE_TOP_10_MVP_FINISHES = 4;

        //For these WAR numbers for Jose, I'm using Fangraphs WAR model.
        //Why Fangraphs over Baseball Reference or Baseball Prospectus?
        //Because J-Ram's fWAR is greater than the others.
        //This is shameless love, and I will put Jose in the best light I can.
        final double JOSE_TOTAL_WAR = 28.1;
        final double JOSE_AVG_WAR = 5.62;

        //For the expected salary, I chose to use the
        //5-year average of the millions of dollars per actual or projected WAR for 2+ WAR players given out in free agency from 2018-2022,
        //provided in this article: https://blogs.fangraphs.com/what-are-teams-paying-per-war-in-free-agency/
        final double MILLIONS_PER_YEARLY_WAR = 8.12;
        final double SCRUB_MILLIONS_PER_YEARLY_WAR = 6.52;
        final double JOSE_EXPECTED_SALARY = 45.63;
        final double JOSE_SHAFTED_RATIO = JOSE_EXPECTED_SALARY / JOSE_PER_YEAR_SALARY;

        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------------");
        System.out.println("Welcome to the Jose Ramirez Quiz");
        System.out.println("--------------------------------");
        System.out.println();

        System.out.println("Which recent hitter would you like to compare to J-Ram? And please, only second contracts. " +
                "We all know rookie deals are criminal. What this is about is later contracts that the player and agent intentionally agreed to.");

        String comparePlayer = scanner.nextLine();

        System.out.println();

        System.out.println("For how many years was that player's contract?");
        int comparePlayerSalaryYears = Integer.parseInt(scanner.nextLine());

        System.out.println("And how many millions of dollars was he paid in that time?");
        double comparePlayerSalaryTotal = Double.parseDouble(scanner.nextLine());
        double comparePlayerSalaryAvg = (comparePlayerSalaryTotal / comparePlayerSalaryYears);

        System.out.println();
        System.out.println("So " + comparePlayer + " got paid $" + comparePlayerSalaryTotal + " million for " + comparePlayerSalaryYears + " years, averaging $" + comparePlayerSalaryAvg + " mil per year.");
        System.out.println();

        int comparePlayerMvpFinishes = 0;

        System.out.println("Did your player finish a season in the top 10 in MVP voting in that time? Y/N");
        if (scanner.nextLine().contains("Y") || scanner.nextLine().contains("y")) {
            System.out.println("Good for him! How many times did he finish in the top 10?");
            comparePlayerMvpFinishes = Integer.parseInt(scanner.nextLine());
        }
        else {
            System.out.println("Awww, that's too bad.");
        }

        System.out.println();
        System.out.println("Finally, how much Fangraphs WAR did " + comparePlayer + " accumulate over the life of the contract?");

        double comparePlayerWarTotal = Double.parseDouble(scanner.nextLine());

        double comparePlayerWarAvg = (comparePlayerWarTotal / comparePlayerSalaryYears);
        double comparePlayerExpectedSalary;

        if(comparePlayerWarAvg >= 2.0) {
            comparePlayerExpectedSalary = comparePlayerWarAvg * MILLIONS_PER_YEARLY_WAR;
        }
        else {
            comparePlayerExpectedSalary = comparePlayerWarAvg * SCRUB_MILLIONS_PER_YEARLY_WAR;
        }
        double comparePlayerShaftRatio = comparePlayerExpectedSalary / comparePlayerSalaryAvg;


        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("--------- Your Results ---------");
        System.out.println("--------------------------------");
        System.out.println();

        if (comparePlayerMvpFinishes >= JOSE_TOP_10_MVP_FINISHES && comparePlayerWarTotal >= JOSE_TOTAL_WAR) {
            System.out.println("Wow! " + comparePlayer + " was somehow even better than Jose!");
            if (comparePlayerShaftRatio > JOSE_SHAFTED_RATIO) {
                System.out.println("And he got shafted out of even more money than Jose did!");
                System.out.println("What was that agent thinking?!");
            }
            else if (comparePlayerShaftRatio > (JOSE_SHAFTED_RATIO - 1)) {
                System.out.println("And he got shafted just as much as Jose did!");
                System.out.println("What was that agent thinking?!");
            }
            else {
                System.out.println("But he didn't get shafted quite as much as Jose did.");
            }
        }
        else if (comparePlayerMvpFinishes >= JOSE_TOP_10_MVP_FINISHES || comparePlayerWarTotal >= JOSE_TOTAL_WAR || comparePlayerWarAvg >= JOSE_AVG_WAR) {
            System.out.println("Wow, " + comparePlayer + " was just as good as Jose!");
            if (comparePlayerShaftRatio > JOSE_SHAFTED_RATIO) {
                System.out.println("And he got shafted out of even more money than Jose did!");
                System.out.println("What was that agent thinking?!");
            }
            else if (comparePlayerShaftRatio > (JOSE_SHAFTED_RATIO - 1)) {
                System.out.println("And he got shafted just as much as Jose did!");
                System.out.println("What was that agent thinking?");
            }
            else {
                System.out.println("But he didn't get shafted quite as much as Jose did.");
            }
        }
        else {
            System.out.println("Unfortunately, " + comparePlayer + " just wasn't as good as Jose,");
            if (comparePlayerShaftRatio > JOSE_SHAFTED_RATIO) {
                System.out.println("but he got shafted out of even more money than Jose did!");
                System.out.println("What was that agent thinking?");
            }
            else if (comparePlayerShaftRatio > (JOSE_SHAFTED_RATIO - 1)) {
                System.out.println("but he got shafted just as much as Jose did.");
                System.out.println("What was that agent thinking?");
            }
            else {
                System.out.println("and he didn't get shafted quite as much as Jose did.");
            }
        }
    }
}
