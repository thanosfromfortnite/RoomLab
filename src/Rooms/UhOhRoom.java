package Rooms;

import Game.Runner;
import People.Person;
import java.util.Scanner;

public class UhOhRoom extends Room{
    public UhOhRoom(int x, int y) {
        super(x, y);
    }

    public void enterRoom(Person x) {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        if (battle()) {
            leaveRoom(x);
        }
        else {
            System.out.println("You die.");
            Runner.gameOff();
        }
    }

    public boolean battle() {
        boolean conclude = false; boolean result = false;
        System.out.println("You are pulled into a random battle!");
        String monster = getRandomMonster();
        System.out.println("You encounter a " + monster + "!");
        while (!conclude) {
            System.out.println("What will you do? (Fight/Items/Run)");
            Scanner in = new Scanner(System.in);
            String choice = in.nextLine();
            choice = choice.toLowerCase().trim();

            switch (choice) {
                case "fight": {
                    System.out.println("You slap the " + monster + " with all your might, and defeat it.");
                    result = true;
                }
                case "items": {
                    System.out.println("You pull out your bag... you don't have a bag! Out of sheer panic, you die to the " + monster + "!");
                    result = false;
                }
                case "run": {
                    System.out.println("You flee from the " + monster + " successfully.");
                    result = true;
                }
                default: {
                    System.out.println("Out of sheer indecisiveness, you fall to the " + monster + " in battle.");
                    result = false;
                }
            }
            conclude = true;
        }
        return result;
    }
    private String getRandomMonster() {
        String[] monsters = {"Pig", "Cow", "Chicken", "Sheep", "Corn"};
        return monsters[(int)(Math.random() * monsters.length)];
    }
}
