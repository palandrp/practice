package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    Tile[][] gameTiles;
    int score;
    int maxTile;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    private void saveState(Tile[][] tile) {
        Tile[][] forSave = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++){
            for (int j = 0; j < FIELD_WIDTH; j++) {
                forSave[i][j] = new Tile(gameTiles[i][j].value);
            }
        }
        previousStates.push(forSave);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousScores.isEmpty() && !previousStates.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public Model() {
        score = 0;
        maxTile = 2;
        resetGameTiles();
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> tiles = new LinkedList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == 0) tiles.add(gameTiles[i][j]);
            }
        }
        return tiles;
    }

    public void randomMove() {
        int move = (int)((Math.random() * 100) % 4);
        switch (move) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> que = new PriorityQueue<>(4, Collections.reverseOrder());
        que.add(getMoveEfficiency(this::left));
        que.add(getMoveEfficiency(this::right));
        que.add(getMoveEfficiency(this::up));
        que.add(getMoveEfficiency(this::down));
        que.peek().getMove().move();
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency result;
        move.move();
        if (!hasBoardChanged()) result = new MoveEfficiency(-1, 0, move);
        else result = new MoveEfficiency(getEmptyTiles().size(), score, move);
        rollback();
        return result;
    }

    boolean hasBoardChanged() {
        return getTilesWeight(gameTiles) != getTilesWeight(previousStates.peek());
    }

    private int getTilesWeight(Tile[][] tile) {
        int result = 0;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                result += tile[i][j].value;
            }
        }
        return result;
    }


    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean flag = false;
        for (Tile[] tiles : gameTiles) {
            if (compressTiles(tiles)) flag = true;
            if (mergeTiles(tiles)) flag = true;
        }
        if (flag) {
            addTile();
        }
        isSaveNeeded = true;
    }

    public void right() {
        saveState(gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    public void up() {
        saveState(gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    public void down() {
        saveState(gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    void rotate() {
        Tile[][] newField = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                newField[i][j] = gameTiles[FIELD_WIDTH - 1 - j][i];
            }
        }
        gameTiles = newField;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                try {
                    if (gameTiles[i][j].value == 0 || gameTiles[i][j].value == gameTiles[i + 1][j].value || gameTiles[i][j].value == gameTiles[i][j + 1].value)
                        return true;
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }
        return false;
    }

    private void addTile() {
        List<Tile> empty = getEmptyTiles();
        if (empty.size() == 0) return;
        int random = (int)(Math.random() * empty.size());
        empty.get(random).value = Math.random() < 0.9 ? 2 : 4;
    }

    void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++){
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        };
        addTile();
        addTile();
        score = 0;
        maxTile = 2;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean flag = false;
        int empty = -1;
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].value == 0 && empty < 0) empty = i;
            if (tiles[i].value > 0 && empty > -1) {
                swap(tiles[empty], tiles[i]);
                flag = true;
                i = empty;
                empty = -1;
            }
        }
        return flag;
    }

    private void swap(Tile a, Tile b) {
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean flag = false;
        ArrayList<Tile> list = new ArrayList<>();

        for (int i = 0; i < tiles.length; i++) {
            if (i == tiles.length - 1) {
                list.add(tiles[i]);
                break;
            }
            if (tiles[i].value != 0 && tiles[i].value == tiles[i+1].value) {
                int newValue = tiles[i].value * 2;
                score += newValue;
                if (newValue > maxTile) maxTile = newValue;
                list.add(new Tile(newValue));
                flag = true;
                i++;
            }
            else {
                list.add(tiles[i]);
            }
        }

        while (list.size() < tiles.length) {
            list.add(new Tile());
        }

        tiles = list.toArray(tiles);
        return flag;
    }
}
