package BackEnd;

import javax.swing.*;
import java.awt.*;

public class ViewEmployeesPanel extends JPanel{
    ViewEmployeesPanel(CardLayout cl,JPanel CardPanel){
        JLabel title = new JLabel("Hello Wrld");
        JButton back = new JButton("Back <-");
        
        back.addActionListener(e->{
            cl.show(CardPanel,"Dashboard");
        });
        
        setBackground(Color.PINK);
        add(title);
        add(back);
    }
}
