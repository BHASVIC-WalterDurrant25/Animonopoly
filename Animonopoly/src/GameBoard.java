import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;


public class GameBoard extends JFrame{

    ArrayList<JPanel> BoardSquares = new ArrayList<>();

    GameBoard(){
        this.setSize(1100,790);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLayout(null);

        for (int i = 0; i < 26; i++) {
            BoardSquares.add(new JPanel());
        }
        SetBoard();
        this.setVisible(true);

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

            JLabel label = new JLabel(Integer.toString(counter));
            label.setForeground(Color.BLACK);
            square.add(label);

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


}
