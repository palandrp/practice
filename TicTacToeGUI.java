/**
 * created by Naatsms 20.09.2016
 */

import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.text.*;

public class TicTacToeGUI extends JFrame {

    final String GAME_NAME = "TicTacToe";
    // final int FIELD_SIZE = 150;
    final int START_LOCATION = 200;
    final int WINDOW_SIZE = 400;
    int FIELD_DIMENSION = 3;
    Field[][] field;
    final char PLAYER_DOT = 'x';
    final char PLAYER2_DOT = 'o';
    final char EMPTY_DOT = '.';
    final int WIN_COND = 4;
    final boolean IS_PVP = false; // для PVP true;
    boolean player_Turn = true; // true = первый игрок, false = второй игрок;
    Random rand = new Random();
    JLabel youWin;
    JPanel card;
    JPanel menu;
    JPanel option;
    JPanel gameField;

    TicTacToeGUI() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION, WINDOW_SIZE, WINDOW_SIZE + 70);
        setResizable(false);

        // игровое меню
        card = new JPanel(new CardLayout());
        
        // стартовая панель
        menu = new JPanel(new GridLayout());
        JButton bStartGame = new JButton("Start Game");
        bStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout) card.getLayout()).show(card, "option");
            }
        });
        menu.add(bStartGame);
        JButton bExit = new JButton("Exit game");
        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(bExit);
        card.add(menu, "menu");
        
        // панель выбора поля
        option = new JPanel(new GridLayout());
        JLabel sized = new JLabel("Field size ");
        JSlider jsize = new JSlider(3, 10, 3);
        jsize.setSnapToTicks(true);
        jsize.setMajorTickSpacing(1);
        jsize.setPaintTicks(true);
        jsize.setPaintLabels(true);
        jsize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            FIELD_DIMENSION = jsize.getValue();
            sized.setText("Field size " + jsize.getValue());
            }
        });
        option.add(jsize);
         
        option.add(sized);
        JButton bNewGame = new JButton("New game");
        bNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initField();
            }
        });
        option.add(bNewGame);
        card.add(option, "option");

        setLayout(new BorderLayout());
        add(card, BorderLayout.SOUTH);
        gameField = new JPanel(new GridLayout(FIELD_DIMENSION, FIELD_DIMENSION, 5, 5));
        add(gameField, BorderLayout.CENTER);

        youWin = new JLabel("...");
        add(youWin, BorderLayout.NORTH);

        setVisible(true);
    }
    
    public static void main(String[] args) {
        
        TicTacToeGUI game = new TicTacToeGUI();
    }

    public boolean checkWin(char dot){
        int count = 0;

        for (int i = 0; i < FIELD_DIMENSION; i++) {     // Проверяем горизонтали.
            for (int j = 0; j < FIELD_DIMENSION; j++) {
                if (field[i][j].dot == dot) count++;
                else count = 0;
                if (count == WIN_COND) {
                    //for (int k = 0; k < WIN_COND; k++) field[i][j-k].setBackground(Color.GREEN);
                    return true;
                }
            }
            count = 0;
        }

        for (int j = 0; j < FIELD_DIMENSION; j++) {     // Проверяем вертикали.
            for (int i = 0; i < FIELD_DIMENSION; i++) {
                if (field[i][j].dot == dot) count++;
                else count = 0;
                if (count == WIN_COND) return true;
            }
            count = 0;
        }

        for (int i = 0; i < FIELD_DIMENSION; i++) {    // Проверяем диагонали '\'
            for (int j = 0; j < FIELD_DIMENSION; j++) {
                for (int k = i, l = j; k < FIELD_DIMENSION && l < FIELD_DIMENSION; k++, l++) {
                    if (field[k][l].dot == dot) count++;
                    else count = 0;
                    if (count == WIN_COND) return true;
                }
                count = 0;
            }
        }

        for (int i = 0; i < FIELD_DIMENSION; i++) {   // Проверяем диагонали '/'
            for (int j = 0; j < FIELD_DIMENSION; j++) {
                for (int k = i, l = j; k < FIELD_DIMENSION && l >= 0; k++, l--) {
                    if (field[k][l].dot == dot) count++;
                    else count = 0;
                    if (count == WIN_COND) return true;
                }
                count = 0;
            }
        }
        return false;
    }

    void initField(){
        gameField.removeAll();
        gameField.repaint();
        field = new Field[FIELD_DIMENSION][FIELD_DIMENSION];
        gameField.setLayout(new GridLayout(FIELD_DIMENSION, FIELD_DIMENSION, 5, 5));
        gameField.revalidate();
        
        for(int i = 0; i < FIELD_DIMENSION; i++) {
            for(int j = 0; j < FIELD_DIMENSION; j++) {
                field[i][j] = new Field();
                gameField.add(field[i][j]);
            }
        }
        gameField.revalidate();
        player_Turn = true;
    }

    boolean isFieldFull() {
        for (int i = 0; i < FIELD_DIMENSION; i++) {
            for(int j = 0; j < FIELD_DIMENSION; j++) {
                if (field[i][j].dot == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    void ai_turn(){
        for (int i = 0; i < FIELD_DIMENSION; i++) {
            for(int j = 0; j < FIELD_DIMENSION; j++) {
                if (field[i][j].dot == EMPTY_DOT) {
                    field[i][j].dot = PLAYER_DOT;  // делаем подстановку во все ячейки массива.
                    if (checkWin(PLAYER_DOT)) { // проверяем, победит ли игрок.
                        field[i][j].dot = PLAYER2_DOT;
                        field[i][j].repaint(); // если победит, ставим ноль туда.
                        return;
                    } else {
                        field[i][j].dot = EMPTY_DOT;
                    }
                } else continue;
            }
        }
        int x, y;
        do {
            x = rand.nextInt(FIELD_DIMENSION);
            y = rand.nextInt(FIELD_DIMENSION);
        } while (field[x][y].dot != EMPTY_DOT);
        field[x][y].dot = PLAYER2_DOT;
        repaint();
    }

    public void winDeclare(char dot) {
        String winner = null;
        switch (dot) {
            case PLAYER_DOT:
                winner = "Player 1";
                break;
            case PLAYER2_DOT:
                winner = "Player 2";
                break;
        }
        youWin.setText(winner + " win!");
    }

    class Field extends JPanel {
        char dot = EMPTY_DOT;

        Field(){
            this.setBackground(Color.white);
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);

                    if (player_Turn && dot == EMPTY_DOT) {
                        dot = PLAYER_DOT;
                        if (checkWin(PLAYER_DOT)) winDeclare(PLAYER_DOT);
                        if (IS_PVP) player_Turn = false;

                        else if (!isFieldFull()) {
                            player_Turn = false;
                            ai_turn();
                            player_Turn = true;
                            if (checkWin(PLAYER2_DOT)) winDeclare(PLAYER2_DOT);
                        }

                    } else if (dot == EMPTY_DOT) {
                        dot = PLAYER2_DOT;
                        player_Turn = true;
                        if (checkWin(PLAYER2_DOT)) winDeclare(PLAYER2_DOT);
                    }
                    repaint();

                }
            });
        }

        @Override
        public void paint(Graphics gr) {
            super.paint(gr);
            Graphics2D g = (Graphics2D) gr;
            g.setStroke(new BasicStroke(3));
            int size = this.getHeight();
            if (dot == PLAYER_DOT) {
                g.setColor(Color.BLUE);
                g.drawLine(size/4, size/4, size - size/4, size - size/4);
                g.drawLine(size/4, size - size/4, size - size/4, size/4);
            }
            if (dot == PLAYER2_DOT) {
                g.setColor(Color.RED);
                g.drawOval(size/4, size/4, size/2, size/2);
            }
        }
    }
}