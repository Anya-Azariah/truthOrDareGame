package com.example.gumball;

import java.util.ArrayList;
import java.util.List;

public class TruthOrDareDepartment {

    enum GumballType { //enums
        TRUTH,
        DARE
    }

    List<String> listOfTruths;

    List<String> listOfDares;

    List<String> secondTruthList;

    List<String> secondDareList;

    //Basically a list of truths and dares which a function picks from and then generates it to you based on which button you press.
    public TruthOrDareDepartment() {
        listOfTruths = new ArrayList<>();
        listOfTruths.add("When is the last time you lied?");
        listOfTruths.add("What is your favorite food?");
        listOfTruths.add("Are you a scaredy cat?");
        listOfTruths.add("If you could have only one friend, who would it be?");//MEEEEEEEEE
        listOfTruths.add("Have you ever unfriended anyone online, without telling them?");//YES YOUUUUUU HAHAHAHAH
        listOfTruths.add("Have you done something wrong and blamed someone else?");
        listOfTruths.add("HAVE YOU PRETENDED TO BE SICK TO STAY HOME FROM SCHOOL? TELL THE TRUTH OR ELSE I WILL TELL YOUR MOM.");
        listOfTruths.add("Have you ever told someone's secret to someone else?");
        listOfTruths.add("DO YOU BITE YOUR NAILS? if so, call 25-15-21'-18-5  9-14  20-18-15-21-2-12-5");// numerical for YOU'RE IN TROUBLE
        listOfTruths.add("Have you ever cheated on a test in school?");
        secondTruthList = new ArrayList<>();
        //System.out.println(listOfTruths);
        listOfDares = new ArrayList<>();
        listOfDares.add("BITE A LEMON. RIGHT NOW.");
        listOfDares.add("RUN A MILE.NO EXCEPTIONS.");
        listOfDares.add("Rap about armadillos.");
        listOfDares.add("Do an impression of your mom."); //If you do this, goodbye, hope you live.
        listOfDares.add("Spell December, backwards."); //remb AGGGGHHHHH
        listOfDares.add("Put ice in your socks.");
        listOfDares.add("Eat bread.");// only bread
        listOfDares.add("Spin ten times and then walk in a straight circle.");
        listOfDares.add("Speak in a Australian accent until it is your next turn.");
        listOfDares.add("Don't move for 2 minutes.");
        secondDareList = new ArrayList<>();

    }

    public String pickRandom(GumballType type) {
        List<String> firstList = listOfTruths;
        List<String> secondList = secondTruthList;
        if (type == GumballType.DARE) {
            firstList = listOfDares; //The first list is full, but the second list is empty at the beginning.The second one gets filled up with the dares/truths which have been used. They have the same dares/truths.
            // We made this function to make sure one dare/truth
            secondList = secondDareList; // doesn't pop up too many times.

        }
        int randLength = firstList.size();
        if (randLength == 0) {
            List<String> temp = firstList;
            firstList = secondList;
            secondList = temp;
        }
        int randDex = (int) (Math.random() * randLength);
        String rand = firstList.remove(randDex);
        secondList.add(rand);
        return rand;
    }

    public boolean isTruth(String phrase) {
        return listOfTruths.contains(phrase) || secondTruthList.contains(phrase);
    }

    public boolean isDare(String phrase) {
        return listOfDares.contains(phrase) || secondDareList.contains(phrase);
    }

}