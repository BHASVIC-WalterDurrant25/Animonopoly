import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class GameBoard extends JFrame implements ActionListener {

    ArrayList<JPanel> BoardSquares = new ArrayList<>();
    ArrayList<Player> Players = new ArrayList<>();
    private int NumberOfPlayers;

    JButton button1 = new JButton("Two Players");
    JButton button2 = new JButton("Three Players");
    JButton button3 = new JButton("Four Players");
    JPanel panel = new JPanel();
    JLabel label = new JLabel();

    GameBoard(){
        this.setSize(1100,790);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLayout(null);

        for (int i = 0; i < 26; i++) {
            BoardSquares.add(new JPanel());
        }

        this.checkNumberOfPlayers();

        while (NumberOfPlayers == 0){
            this.setVisible(true);
        }

        for (int i = 0; i < NumberOfPlayers; i++){
            Players.add(new Player());
        }

        SetBoard();
        this.revalidate();
        this.repaint();

    }

    public void SetBoard(){
        int counter = 0;
        for (JPanel square : BoardSquares){
            if (counter % 2 == 0) {
                square.setBackground(new Color(220,70,50));
            }
            else{
                square.setBackground(new Color(230,180,30));
            }

            if (counter == 0){
                JLabel label = new JLabel("Start");
                label.setForeground(Color.BLACK);
                square.add(label);
            }
            else if (counter == 13){
                JLabel label = new JLabel("Miss a Turn");
                label.setForeground(Color.BLACK);
                square.add(label);
            }
            else {
                JLabel label = new JLabel(Integer.toString(counter));
                label.setForeground(Color.BLACK);
                square.add(label);
            }

            if (counter < 8){
                square.setBounds(20+(counter*101),20,100,100);
            }
            else if(counter < 14){
                square.setBounds(727,20+((counter-7)*101),100,100);
            }
            else if (counter < 21){
                square.setBounds(727-((counter-13)*101),626,100,100);
            }
            else{
                square.setBounds(20,626-((counter-20)*101),100,100);
            }

            this.add(square);
            counter++;
        }

    }

    public void checkNumberOfPlayers(){
        label.setBounds(270,150,800,100);
        label.setText("Select the number of players:");
        label.setFont(new Font("Regular", Font.BOLD, 40));
        label.setForeground(Color.WHITE);
        panel.add(label);


        panel.setLayout(null);
        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        panel.setBackground(Color.BLACK);
        this.add(panel);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        button1.setBounds(350-30,380,150,80);
        button2.setBounds(470+10,380,150,80);
        button3.setBounds(590+50,380,150,80);

        button1.setBackground(Color.WHITE);
        button2.setBackground(Color.WHITE);
        button3.setBackground(Color.WHITE);

        button1.setFocusable(false);
        button2.setFocusable(false);
        button3.setFocusable(false);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button1){
            NumberOfPlayers = 2;
            System.out.println("2");
            this.remove(panel);
            this.revalidate();
            this.repaint();
        }
        else if(e.getSource()==button2){
            NumberOfPlayers = 3;
            System.out.println("3");
            this.remove(panel);
            this.revalidate();
            this.repaint();

        }
        else if(e.getSource()==button3){
            NumberOfPlayers = 4;
            System.out.println("4");
            this.remove(panel);
            this.revalidate();
            this.repaint();
        }
    }

    public int getNumberOfPlayers(){
        return NumberOfPlayers;
    }

}
