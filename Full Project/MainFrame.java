package BackEnd;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame {
    private ArrayList<Employee> el = new ArrayList<>();
    private ArrayList<Department> dl = new ArrayList<>();
    private FileHandler fh = new FileHandler();
    private DepartmentManager dm = new DepartmentManager(dl, fh);
    private EmployeeManager em = new EmployeeManager(el, fh, dm);

    MainFrame() {
        JFrame mainF = new JFrame();
        CardLayout CardLay = new CardLayout();
        JPanel CardPanel = new JPanel(CardLay);

        DashboardPanel dp = new DashboardPanel(CardLay,CardPanel,mainF);
        DepartmentPanel depP = new DepartmentPanel(CardLay,CardPanel);
        AddEmployeePanel addEmpPa = new AddEmployeePanel(CardLay,CardPanel);
        SearchUpdatePanel searchUp = new SearchUpdatePanel(CardLay, CardPanel);
        ViewEmployeesPanel ViewEmp = new ViewEmployeesPanel(CardLay, CardPanel);

        CardPanel.add(dp,"Dashboard");
        CardPanel.add(depP,"Manage Departments");
        CardPanel.add(addEmpPa,"Add Employee");
        CardPanel.add(searchUp,"Search / Update Employee");
        CardPanel.add(ViewEmp,"View All Employees");
        CardLay.show(CardPanel,"Dashboard");

        mainF.add(CardPanel);
        mainF.setTitle("Managment System");
        mainF.setSize(700,700);
        mainF.setResizable(false);
        mainF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainF.setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame x = new MainFrame();
    }
}
