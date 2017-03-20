package com.javarush.task.task35.task3513;

/**
 * Created by Naatsms on 18.02.2017.
 */
public class MoveEfficiency implements Comparable<MoveEfficiency>{
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency o) {
        if (numberOfEmptyTiles != o.numberOfEmptyTiles) return Integer.compare(numberOfEmptyTiles, o.numberOfEmptyTiles);
        else if (score != o.score) return Integer.compare(score, o.score);
        else return 0;
    }
}
