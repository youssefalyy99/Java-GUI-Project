package BackEnd;

import java.awt.*;
import javax.swing.*;


public class DashboardPanel extends JPanel {
    DashboardPanel( CardLayout cl , JPanel CardPanel , JFrame mf){
        JLabel title = new JLabel("Employee Management System");

        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 20, 20));
        JButton addEmployee = new JButton("Add Employee");
        JButton viewEmployees = new JButton("View Employees");
        JButton departments = new JButton("Manage Departments");
        JButton search = new JButton("Search / Update Employee");
        JButton logoutbtn = new JButton("Log Out <-");
        logoutbtn.setBackground(Color.RED);
        
        Dimension buttonSize = new Dimension(220, 50);
        addEmployee.setPreferredSize(buttonSize);
        viewEmployees.setPreferredSize(buttonSize);
        departments.setPreferredSize(buttonSize);
        search.setPreferredSize(buttonSize);
        logoutbtn.setPreferredSize(buttonSize);

        buttonPanel.add(addEmployee);
        buttonPanel.add(viewEmployees);
        buttonPanel.add(departments);
        buttonPanel.add(search);
        buttonPanel.add(logoutbtn);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(150, 100, 30, 100));

        departments.addActionListener(e->{cl.show(CardPanel,"Manage Departments");});
        addEmployee.addActionListener(e->{cl.show(CardPanel,"Add Employee");});
        viewEmployees.addActionListener(e->{cl.show(CardPanel,"View All Employees");});
        search.addActionListener(e->{cl.show(CardPanel,"Search / Update Employee");});
        logoutbtn.addActionListener(e->{
                LoginFrame login = new LoginFrame();
                mf.dispose();
            }
        );
        add(buttonPanel, BorderLayout.CENTER);
    }
}
