import javax.swing.JButton;
import java.awt.Color;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class Dice implements ActionListener {

    private int total = 0;
    private GameBoard Frame;

    JButton button = new JButton();
    JPanel dicePanel = new JPanel();
    JLabel label = new JLabel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();

    Dice(GameBoard frame){

        this.Frame = frame;

        dicePanel.setBackground(Color.black);
        dicePanel.setLayout(null);
        dicePanel.setBounds(500,150,200,450);
        frame.add(dicePanel);

        label.setBounds(60,10,100,20);
        label.setText("Total:");
        label.setFont(new Font("Regular",Font.PLAIN, 20));
        label.setForeground(Color.WHITE);
        dicePanel.add(label);

        button.addActionListener(this);
        button.setBackground(Color.WHITE);
        button.setBounds(45,400,110,40);
        button.setText("Roll Dice");
        button.setFocusable(false);
        button.setVisible(true);
        dicePanel.add(button);

        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            this.rollDice();
        }
    }

    public void displayDice(int dice1, int dice2){

        panel1.setBounds(50,100,100,100);
        panel2.setBounds(50,220,100,100);

        fillDice(dice1, panel1, label1);
        fillDice(dice2, panel2, label2);

        Frame.revalidate();
        Frame.repaint();

    }

    public void fillDice(int number, JPanel panel, JLabel Label){
        panel.setLayout(null);
        Label.setFont(new Font("Regular", Font.BOLD, 50));
        Label.setBounds(35,25,50,50);

        panel.setBackground(Color.WHITE);

        if (number == 1){
            Label.setText("1");
        }
        else if (number == 2){
            Label.setText("2");
        }
        else if (number == 3){
            Label.setText("3");
        }
        else if (number == 4){
            Label.setText("4");
        }
        else if (number == 5){
            Label.setText("5");
        }
        else {
            Label.setText("6");
        }

        panel.add(Label);
        dicePanel.add(panel);
    }


    public void rollDice(){
        total = 0;
        Random random = new Random();
        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;

        displayDice(dice1, dice2);

        total = dice1 + dice2;
        System.out.println(dice1 +" "+ dice2);
        label.setText("Total: " + total);
        //System.out.println(total);
    }
}
