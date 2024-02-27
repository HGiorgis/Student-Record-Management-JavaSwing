package studentRecordManagement;


import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class MainPage extends JFrame {
    
    MainPage(){
        ImageIcon logo = new ImageIcon("D:\\Picture\\astu.png");
        JPanel studentTab = student.StudentPage(this);
        JPanel courseTab = Course.coursePage(this); 
        JPanel scoreTab = Score.scorePage(this);
        //JPanel gradeTab = Grade.gradePage();
        JPanel score = new JPanel();
        JPanel mark = new JPanel();
        JTabbedPane navBar = new JTabbedPane();
        navBar.addTab("Student", studentTab );
        navBar.addTab("Course", courseTab);
        navBar.addTab("Score", scoreTab );
        navBar.setBackground(Color.red);
        navBar.setBackground(new Color(64,138,175));
        navBar.setForeground(Color.white);
        navBar.setFocusable(false);
        //navBar.addTab("Grade", gradeTab);
        navBar.setBounds(0, 30, 990, 590);
        studentTab.setBounds(0, 30, 990, 590);
        courseTab.setBounds(0, 30, 990, 590);
        courseTab.setBounds(0, 30, 990, 590);
        navBar.setBackground(new Color(64,138,175));
        navBar.setForeground(Color.white);
        studentTab.setLayout(null);
        courseTab.setLayout(null);
        scoreTab.setLayout(null);
        navBar.setFocusable(false);

        this.add(navBar);
        
        this.setLayout(null);
        this.setLocation(250, 150);
        this.setIconImage(logo.getImage());
        this.setResizable(false);
        this.setSize(1000, 600);
        this.setVisible( false);   
        this.setTitle("Student");
    }
    
}
