package studentRecordManagement;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginPage extends JFrame implements ActionListener{
    
    JButton btnLog;
    JPasswordField input2;
    JTextField input;
    Database Db = new Database();
    MainPage mainPage = new MainPage();
    public static student studInfo = new student();
    public static Course courseInfo = new Course();
    public static Score scoreInfo = new Score();
    LoginPage(){
        btnLog = new JButton("Login");
        JLabel bodyLogo = new JLabel(); 
        JLabel userName = new JLabel("User Name");
        JLabel password = new JLabel("Password");
        input = new JTextField();
        input2 = new JPasswordField();
        ImageIcon logo = new ImageIcon("pngegg.png");
            //Button Configration
        btnLog.setBounds(150, 280, 100, 52);
        btnLog.setBackground(new Color(64,138,175));
        btnLog.setForeground(Color.white);
        btnLog.setFocusable(false);
        btnLog.addActionListener(this);
        input.getText();
        input2.getText();
            //Label Configration
        userName.setBounds(50, 90, 100, 52);
        password.setBounds(50, 140, 100, 52);
        bodyLogo.setBounds(0, 0, 100, 52);
        
            //TextField Configration
        input.setBounds(150, 100, 200, 30);
        input2.setBounds(150, 150, 200, 30);
            //Add into the Frame login Page.
        this.add(btnLog);
        this.add(userName);
        this.add(password);
        this.add(input);
        this.add(input2);
        this.add(bodyLogo);
            //Frame Configration 
        this.setLayout(null);
        this.setLocation(550, 300);
        this.setIconImage(logo.getImage());
        this.setResizable(false);
        this.setSize(390, 400);
        this.setVisible(true);   
        this.setTitle("Student");
    }
    
    
 
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnLog) {
            Db.CreateFile();
            Db.CountLines();
            Db.logic(input.getText(),input2.getText());
            if (Db.n){
                this.setVisible(false);
                mainPage.setVisible(true);
                studInfo.logic();
                courseInfo.logic();
                courseInfo.logic2();
                scoreInfo.logic();
                scoreInfo.logic2();
                
            }  
        }
        
    }
  
}
