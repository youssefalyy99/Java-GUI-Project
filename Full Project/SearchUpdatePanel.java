package BackEnd;

import javax.swing.*;
import java.awt.*;

public class SearchUpdatePanel extends JPanel{
    SearchUpdatePanel(CardLayout cl,JPanel CardPanel){
        JLabel title = new JLabel("Hello Wrld");
        JButton back = new JButton("Back <-");
        
        back.addActionListener(e->{
            cl.show(CardPanel,"Dashboard");
        });
        
        setBackground(Color.BLACK);
        add(title);
        add(back);
    }
}
