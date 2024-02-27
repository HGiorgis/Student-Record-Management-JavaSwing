package studentRecordManagement;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Course extends JFrame{
    
    public static JButton addNew;
    public static JTextField NameField;
    public static JComboBox IDField;
    public static JComboBox courseList1;
    public static JComboBox courseList2;
    public static JComboBox semisterList;
    public static JTable table;
    public static DefaultTableModel tableModel; 
    public static student studInfo = new student();
    public static Course courseInfo = new Course();
    public static Score scoreInfo = new Score();
    public static String Id = "";
    
    public static JPanel coursePage(JFrame frame){ 
        courseList1 = new JComboBox();
        courseList2 = new JComboBox();
        semisterList = new JComboBox();
        courseList1.setModel(new DefaultComboBoxModel(new String[] { "Java", "Fundamental of Software Engineering", 
            "Database"}));
        courseList2.setModel(new DefaultComboBoxModel(new String[] { "Digital Logic Design", "Java","CyberSecurity" }));
        
        semisterList.setModel(new DefaultComboBoxModel(new String[] {"Economics", "Computer Architecture", "Data Science"}));
        JPanel Page_One = new JPanel();
        JButton logout = new JButton("Logout");
        JButton search = new JButton("Search");
        addNew = new JButton("Add");
        JLabel Name = new JLabel("ID");
        JLabel ID = new JLabel("Student ID ");
        JLabel Lcourse1 = new JLabel("Course 1");
        JLabel Lcourse2 = new JLabel("Course 2");
        JLabel semister = new JLabel("Semister");
        JTextField searchField = new JTextField();
        NameField = new JTextField();
        IDField = new JComboBox();
        table = new JTable();
        JPanel LeftBoard = new JPanel();
        JPanel RightBoard = new JPanel();
        JPanel TopBoard = new JPanel();
        JPanel BottomBoard = new JPanel();
        //Table info
        
        table.setModel(new DefaultTableModel(
            new Object [][] {
                {"Course ID", "Student ID", "Course 1", "Course 2","Course 3"}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4","Title 5"
            }
        ));
        LeftBoard.setBounds(10, 10, 380, 480);
        LeftBoard.setBackground(new Color(0,152,153));
        RightBoard.setBounds(410, 70, 560, 350);
        RightBoard.setBackground(new Color(0,152,153));
        TopBoard.setBounds(410, 10, 560, 50);
        TopBoard.setBackground(new Color(0,152,153));
        BottomBoard.setBounds(410, 430, 560, 60);
        BottomBoard.setBackground(new Color(0,152,153));
        table.setBounds(10, 10, 540, 330);
             //TextField Configration
        searchField.setBounds(420, 20,380, 30);
        NameField.setBounds(125, 35, 230, 30);
        IDField.setBounds(125, 130, 230, 30);
        courseList1.setBounds(125, 230, 230, 30);
        courseList2.setBounds(125, 330, 230, 30);
        semisterList.setBounds(125, 430, 230, 30);
        
        RightBoard.add(table);
        RightBoard.setLayout(null);
        Name.setBounds(25, 25, 100, 52);
        Name.setForeground(Color.white);
        ID.setForeground(Color.white);
        Lcourse1.setForeground(Color.white);
        Lcourse2.setForeground(Color.white);
        semister.setForeground(Color.white);
        ID.setBounds(25, 120, 100, 52);
        Lcourse1.setBounds(25, 220, 100, 52);
        Lcourse2.setBounds(25, 320, 100, 52);
        semister.setBounds(25, 420, 100, 52);
        
        NameField.getText(); 
        IDField.getSelectedItem();
        NameField.setEnabled(false);
        courseList1.getSelectedItem();
        courseList2.getSelectedItem();
        semisterList.getSelectedItem();
        logout.setBounds(850, 440, 100, 35);
        logout.setBackground(new Color(64,138,175));
        logout.setForeground(Color.white);
        logout.setFocusable(false);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == logout) {
                    int i = JOptionPane.showConfirmDialog(null, "Leaving...", 
                            "Exit", JOptionPane.YES_NO_CANCEL_OPTION);
                    
                    if (i==0){
                        frame.setVisible(false);
                    }
                }
               }
        });
        
        search.setBounds(850, 20, 100, 35);
        search.setBackground(new Color(64,138,175));
        search.setForeground(Color.white);
        search.setFocusable(false);
        
        addNew.setBounds(430, 440, 100, 35);
        addNew.setBackground(new Color(64,138,175));
        addNew.setForeground(Color.white);
        addNew.setFocusable(false);
        
        addNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addNew) {
                        addData(NameField.getText(),(String)IDField.getSelectedItem(),(String) courseList1.getSelectedItem(), (String) courseList2.getSelectedItem(),(String) semisterList.getSelectedItem());
                        logic();
                        logic2();
                        JOptionPane.showConfirmDialog(null, "Course added Successfully", "Course Add", JOptionPane.CLOSED_OPTION);
                        ClearData(); 
                        scoreInfo.logic();
                        scoreInfo.logic2();
               }
            }
        });
        
         
        Page_One.add(Name);
        Page_One.add(NameField);
        Page_One.add(ID);
        Page_One.add(IDField);
        Page_One.add(Lcourse1);
        Page_One.add(courseList1);
        Page_One.add(courseList2);
        Page_One.add(semisterList);
        Page_One.add(Lcourse2);
        Page_One.add(semister);
        Page_One.add(search);
        Page_One.add(searchField);
        Page_One.add(logout);
        Page_One.add(addNew);
        Page_One.add(LeftBoard);
        Page_One.add(RightBoard);
        Page_One.add(TopBoard);
        Page_One.add(BottomBoard);
         
         Page_One.setBackground(new Color(102,102,102));
         Page_One.setBounds(10, 10, 1000, 500);
        return Page_One;
    }

    
    public static void ClearData(){
        NameField.setText(Id);
    }
public static void addData(String CourseID,String StudID,String course1,String course2,String course3){
        
        try {
            BufferedWriter access = new BufferedWriter(
        new FileWriter( "Database\\Course.txt",true));
            access.write(CourseID+"," +StudID+","+course1+","+course2+","+course3);
            access.write("\r\n");
           access.close();
        } catch(FileNotFoundException ex){
            System.out.println("FileNotFound");
        }
        catch (IOException ex) {
           System.out.println("IO Error");
        }
        
        
    }
     public static void logic(){
        tableModel = (DefaultTableModel)table.getModel();
        tableModel.setRowCount(1);
        int id=0;
        try {
             BufferedReader access = new BufferedReader(
        new FileReader( "Database\\Course.txt"));
            
            String line;
      while ((line = access.readLine()) != null) {
        String[] data = line.split(",");
        tableModel.addRow(data);
        id++;
      }
      Id = Integer.toString(id);
        } catch(FileNotFoundException ex){
            System.out.println("FileNotFound");
        }
        catch (IOException ex) {
           System.out.println("IO Error");
        }
        
        
      
    }    
    public static void logic2(){
        IDField.setModel(new DefaultComboBoxModel());
        NameField.setText(Id);
        try {
       BufferedReader id = new BufferedReader(
        new FileReader( "Database\\id.txt"));
      String list;
      while ((list = id.readLine()) != null) {
        String[] data = list.split(",");
        IDField.addItem(data[0]);
       }
        } catch(FileNotFoundException ex){
            System.out.println("FileNotFound");
        }
        catch (IOException ex) {
           System.out.println("IO Error");
        }
        
    }    
   
    }


