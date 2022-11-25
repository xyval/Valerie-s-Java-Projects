import java.awt.*;
import javax.swing.*;
public class Monster0 extends JFrame{
    public static void main (String[]args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                draw(0);
            }
        });
    }

    public static void draw(int round)
    {
        JFrame f = new JFrame("Round "+ round);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new monster0());
        f.pack();
        f.setVisible(true);
    }
}

class monster0 extends JPanel {
    public monster0() {
        setBorder(BorderFactory.createLineBorder(Color.black));

    }
    public Dimension getPreferredSize() {
        return new Dimension(400,400);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        Graphics2D g2 = (Graphics2D) g;
        //main body
        g.setColor(new Color(133,96,24));
        g.fillOval(90, 100, 200, 200);
        g.setColor(new Color(199,197,195));
        g.fillOval(220, 180, 10, 20);
        g.fillOval(140, 160, 50, 50);
        g2.setStroke(new BasicStroke(6));
        g2.drawLine(135, 250, 180, 230);
        g2.drawLine(180, 230, 200,250);
        g2.drawLine(200,250,240,230);
        g.setColor(Color.black);
        g.fillOval(100,290,70,21);
        g.fillOval(210,290,70,21);
    }
}