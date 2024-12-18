package com.om.tennis;

public class Main {
    public static void main(String[] args) {
        var playerA = new Player('A');
        var playerB = new Player('B');

        var match = new Match(playerA, playerB);

        if (args.length > 0) {
            // Example: ABABAA
            match.play(args[0]);
        } else {
            System.out.println("You need to specify an input like ABABAA");
        }


    }
}