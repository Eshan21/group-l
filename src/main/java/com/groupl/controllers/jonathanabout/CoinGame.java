package com.groupl.controllers.jonathanabout;

public class CoinGame {
    private int startingCoins; // starting number of coins
    private int maxRounds; // maximum number of rounds played

    public CoinGame(int s, int r) {
        startingCoins = s;
        maxRounds = r;
    }

    // Returns the number of coins (1, 2, or 3) that player 1 will spend.
    public int getPlayer1Move() {
        return 2;
    }

    // Returns the number of coins (1, 2, or 3) that player 2 will spend, as described in part (a).
    public int getPlayer2Move(int round) {
        int result;

        if (round % 3 == 0) {
            result = 3;
        } else if (round % 2 == 0) {
            result = 2;
        } else {
            result = 1;
        }
        
        return result;
    }

    // Plays a simulated game between two players, as described in part (b).
    public String playGame() {
    /* to be implemented in part (b) */
        int p1 = startingCoins;
        int p2 = startingCoins;
        
        for (int i = 0; i < maxRounds; i++) {
            p1 -= getPlayer1Move();
            p2 -= getPlayer2Move(i);
        }

        if (p1 == p2) {
            return "tie game";
        } else if (p1 > p2) {
            return "player 1 wins";
        } else {
            return "player 2 wins";
        }
    }

}
