package BackEnd;

import java.awt.*;
import javax.swing.*;


public class DepartmentPanel extends JPanel{
    DepartmentPanel(CardLayout cl , JPanel CardPanel){
        JLabel title = new JLabel("Hello Wrld");
        JButton back = new JButton("Back <-");
        
        back.addActionListener(e->{
            cl.show(CardPanel,"Dashboard");
        });
        
        setBackground(Color.green);
        add(title);
        add(back);
    }
}
