/**
*   Convay's Game of Life
*   Created by Naatsms
*/
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Conway {
    
    final String NAME_OF_GAME = "Convay's Game of Life";
    final int START_LOCATION = 200;
    final int LIFE_SIZE = 50;
    final int POINT_RADIUS = 10;
    final int FIELD_SIZE = (LIFE_SIZE + 1) * POINT_RADIUS - 3;
    final int BTN_PANEL_HEIGHT = 58;
    boolean[][] lifeGeneration = new boolean[LIFE_SIZE][LIFE_SIZE];
    boolean[][] nextGeneration = new boolean[LIFE_SIZE][LIFE_SIZE];
    JFrame frame;
    Canvas canvasPanel;
    Random random = new Random();
    
    public static void main(String[] args) {
        new Conway().go();    
    }
    
    void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FIELD_SIZE, FIELD_SIZE + BTN_PANEL_HEIGHT);
        frame.setLocation(START_LOCATION, START_LOCATION);
        frame.setResizable(false);
        
        canvasPanel = new Canvas();
        canvasPanel.setBackground(Color.white);
        //
        
        JButton fillButton = new JButton("Fill");
        fillButton.addActionListener(new FillButtonListener());
        
        JButton stepButton = new JButton("Next Step");
        stepButton.addActionListener(new StepButtonListener());
        
        JPanel btnPanel = new JPanel();
        btnPanel.add(fillButton);
        btnPanel.add(stepButton);
        //
        
        frame.add(canvasPanel, BorderLayout.CENTER);
        frame.add(btnPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    
    public int getNeigbors(int x, int y) {
        int count = 0;
        if (x > 0 && lifeGeneration[x-1][y]) count++;
        if (x > 0 && y > 0 && lifeGeneration[x-1][y-1]) count++;
        if (x > 0 && y < (LIFE_SIZE - 1) && lifeGeneration[x-1][y+1]) count++;
        if (x < (LIFE_SIZE - 1) && lifeGeneration[x+1][y]) count++;
        if (x < (LIFE_SIZE - 1) && y > 0 && lifeGeneration[x+1][y-1]) count++;
        if (x < (LIFE_SIZE - 1) && y < (LIFE_SIZE - 1) && lifeGeneration[x+1][y+1]) count++;
        if (y > 0 && lifeGeneration[x][y-1]) count++;
        if (y < (LIFE_SIZE - 1) && lifeGeneration[x][y+1]) count++;
        return count;
    }
    
    public class FillButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            // countGeneration = 1;
            for (int x = 0; x < LIFE_SIZE; x++) {
                for (int y = 0; y < LIFE_SIZE; y++) {
                    lifeGeneration[x][y] = random.nextBoolean();
                }
            }
            canvasPanel.repaint();
        }
    }
    
    public class StepButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            
            for (int x = 0; x < LIFE_SIZE; x++) {
                for (int y = 0; y < LIFE_SIZE; y++) {
                    nextGeneration[x][y] = lifeGeneration[x][y]; 
                    int count = getNeigbors(x, y);
                    if (!lifeGeneration[x][y] && count == 3) nextGeneration[x][y] = true;
                    if (lifeGeneration[x][y] && (count < 2 || count > 3)) nextGeneration[x][y] = false;
                }
            }
            for (int x = 0; x < LIFE_SIZE; x++) {
                for (int y = 0; y < LIFE_SIZE; y++) {
                    lifeGeneration[x][y] = nextGeneration[x][y]; 
                }
            }
            canvasPanel.repaint();
        }
    }
    
    public class Canvas extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            for (int x = 0; x < LIFE_SIZE; x++) {
                for (int y = 0; y < LIFE_SIZE; y++) {
                    if (lifeGeneration[x][y]) {
                        g.fillOval(x*POINT_RADIUS, y*POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
                    }
                }
            }
        }
    }
}    