import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.util.*;
import java.text.*;

public class Clock {

    public static void main(String[] args) {

        new Clock().go();
    }

    void go() {
        JFrame clock = new JFrame();
        Field card = new Field();
        clock.setTitle("clock");
        clock.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        clock.setBounds(300, 300, 405, 430);
        clock.setVisible(true);
        clock.setResizable(false);
        clock.add(card);

        while (true) {
            card.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class Field extends JPanel {
        SimpleDateFormat sec = new SimpleDateFormat("ss");
        SimpleDateFormat min = new SimpleDateFormat("mm");
        SimpleDateFormat hours = new SimpleDateFormat("HH");

        Field() {
            this.setBackground(Color.white);
        }

        @Override
        public void paint(Graphics gr) {
            super.paint(gr);
            Graphics2D g = (Graphics2D) gr;
            AffineTransform old = g.getTransform();
            try {
                BufferedImage clockFace = ImageIO.read(new File("clock-face.jpg"));
                g.drawImage(clockFace, 0, 0, 400, 400, null);
            } catch(IOException e)
            {
                e.printStackTrace();
            }

            //seconds
            Calendar cal = Calendar.getInstance();
            double second = Double.parseDouble(sec.format(cal.getTime()));
            g.rotate((Math.toRadians(6 * second)), 200, 200);
            g.draw(new Line2D.Float(200, 200, 200, 20));
            g.setTransform(old);

            //minutes
            double minute = Double.parseDouble(min.format(cal.getTime()));
            g.rotate((Math.toRadians(6 * minute + second/10)), 200, 200);
            g.draw(new Line2D.Float(199, 200, 200, 70));
            g.draw(new Line2D.Float(201, 200, 200, 70));
            g.setTransform(old);

            //hours
            double hour = Double.parseDouble(hours.format(cal.getTime()));
            g.rotate((Math.toRadians(30 * hour + minute/2)), 200, 200);
            g.draw(new Line2D.Float(198, 200, 200, 100));
            g.draw(new Line2D.Float(202, 200, 200, 100));
            g.draw(new Line2D.Float(200, 200, 200, 100));
            g.setTransform(old);

        }
    }
}