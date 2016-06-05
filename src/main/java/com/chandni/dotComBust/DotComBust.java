package com.chandni.dotComBust;

import java.util.ArrayList;

public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<>();
    private int numOfGuesses = 0;

    public void setUpGame() {
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Pets.com, eToys.com, and Go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses");

        for (DotCom dot: dotComList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dot.setLocationCells(newLocation);
        }
    }

    public void startPlaying() {
        while (!dotComList.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserInput(userGuess);

        }
        finishGame();

    }

    private void checkUserInput(String userGuess) {
        numOfGuesses++;
        String result = "miss";

        for (int x = 0; x < dotComList.size(); x++) {
            result = dotComList.get(x).checkYourself(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                dotComList.remove(x);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("All Dot Coms are dead!  Your stock is now worthless.");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println(" You got out before your options sank.");
        } else {
            System.out.println("Took you long enough " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options.");
        }
    }
}
