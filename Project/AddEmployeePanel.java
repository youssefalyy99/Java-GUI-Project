package BackEnd;

import javax.swing.*;
import java.awt.*;

public class AddEmployeePanel extends JPanel{
    AddEmployeePanel(CardLayout cl,JPanel CardPanel){
        JLabel title = new JLabel("Hello Wrld");
        JButton back = new JButton("Back <-");
        
        back.addActionListener(e->{
            cl.show(CardPanel,"Dashboard");
        });
        
        setBackground(Color.BLUE);
        add(title);
        add(back);
    }
}
