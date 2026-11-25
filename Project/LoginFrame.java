package BackEnd;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame {

    LoginFrame(){
        JFrame login = new JFrame("Login Page");
        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();
        JButton logb = new JButton("Start Your Journey!");
        JButton Exitb = new JButton("Exit Program :(");
        Exitb.setBackground(Color.RED);

        Image scaled = new ImageIcon(getClass().getResource("loginpage.png"))
        .getImage()
        .getScaledInstance(700, 500, Image.SCALE_SMOOTH);
        ImageIcon img = new ImageIcon(scaled);
        JLabel bg = new JLabel(img);
        username.setBounds(260,200,150,20);
        password.setBounds(260,270,150,20);
        password.setEchoChar('●');
        logb.setBounds(270,320,150,20);
        Exitb.setBounds(270,350,150,20);
        bg.setLayout(null);
        AuthService auth = new AuthService();

        logb.addActionListener(e->{
            if(auth.login(username.getText(), password.getText())){
                MainFrame f = new MainFrame();
                login.dispose();
            }else{
                JOptionPane.showMessageDialog(login, "Wrong username or password.",
                "Login Failed", JOptionPane.ERROR_MESSAGE);
                username.setText("");
                password.setText("");
                username.requestFocus();
            }
        });

        Exitb.addActionListener(e->{
            int choice = JOptionPane.showConfirmDialog(login,
            "Are you sure you want to close the app?",
            "Exit",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                login.dispose();
            }
        });

        login.setLayout(null);
        login.setContentPane(bg);
        login.add(username);
        login.add(password);
        login.add(logb);
        login.add(Exitb);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setSize(700, 500);
        login.setResizable(false);
        login.setVisible(true);
    }

    public static void main(String[] args) {
        LoginFrame l = new LoginFrame();
    }
}
