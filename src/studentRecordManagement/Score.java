package studentRecordManagement;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

public class Score extends MainPage{
    
    public static JButton addNew;
    public static JButton View;
    public static JButton clear;
    public static JTextField NameField;
    public static JComboBox IDField;
    public static JComboBox courseList1;
    public static JComboBox courseList2;
    public static JComboBox semisterList;
    public static JTextField Lcourse1;
    public static JTextField Lcourse2;
    public static JTextField semister;
    public static JLabel cal;
    public static JTable table;
    public static DefaultTableModel tableModel; 
    public static student studInfo = new student();
    public static Course courseInfo = new Course();
    public static Score scoreInfo = new Score();
    public static MainPage mainPage = new MainPage();
    public static String Id = "";
    
    public static JPanel scorePage(JFrame frame){
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
        clear = new JButton("Calculate");
        clear.setEnabled(false);
        addNew = new JButton("Submit");
        View = new JButton("View");
        JLabel Name = new JLabel("ID");
        cal = new JLabel("0.0");
        JLabel gpa = new JLabel("GPA: ");
        JLabel ID = new JLabel("Student ID ");
        Lcourse1 = new JTextField();
        Lcourse2 = new JTextField();
        semister = new JTextField();
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
                {"Student ID", "Course 1", "Course 2","Course 3","GPA"}
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
        courseList1.setBounds(25, 230, 230, 30);
        courseList2.setBounds(25, 310, 230, 30);
        semisterList.setBounds(25, 390, 230, 30);
        
        RightBoard.add(table);
        RightBoard.setLayout(null);
        Name.setBounds(25, 25, 100, 52);
        gpa.setBounds(150, 420, 100, 52);
        cal.setBounds(200, 420, 100, 52);
        Name.setForeground(Color.white);
        gpa.setForeground(Color.white);
        cal.setForeground(Color.white);
        ID.setForeground(Color.white);
        Lcourse1.setForeground(Color.blue);
        Lcourse2.setForeground(Color.blue); 
        semister.setForeground(Color.blue);
        ID.setBounds(25, 120, 100, 52);
        Lcourse1.setBounds(270, 230, 55, 35);
        Lcourse2.setBounds(270, 310, 55, 35);
        semister.setBounds(270, 390, 55, 35);
        
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
                            "Registeration", JOptionPane.YES_NO_CANCEL_OPTION);
                    
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
        
        clear.setBounds(710, 440, 100, 35);
        clear.setBackground(new Color(64,138,175));
        clear.setForeground(Color.white);
        clear.setFocusable(false);
        
        View.setBounds(570, 440, 100, 35);
        View.setBackground(new Color(64,138,175));
        View.setForeground(Color.white);
        View.setFocusable(false);
        
        addNew.setBounds(430, 440, 100, 35);
        addNew.setBackground(new Color(64,138,175));
        addNew.setForeground(Color.white);
        addNew.setFocusable(false);
        addNew.setEnabled(false);
        
        addNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addNew) {
                        addData((String) IDField.getSelectedItem(),c1,c2,c3,Estim);
                        logic();
                        logic2();
                        clear.setEnabled(false);
                        JOptionPane.showConfirmDialog(null, "Submitted", "Score", JOptionPane.CLOSED_OPTION);
                        ClearData();
               }
            }
        });
        Lcourse1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())&&e.getKeyChar()!='.'){
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }
            @Override
            public void keyReleased(KeyEvent e) {
                
            }
            
        });
        semister.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())&&e.getKeyChar()!='.'){
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }
            @Override
            public void keyReleased(KeyEvent e) {
                
            }
            
        });
        Lcourse2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())&&e.getKeyChar()!='.'){
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }
            @Override
            public void keyReleased(KeyEvent e) {
                
            }
            
        });
        View.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == View) {
                    grade();
                    clear.setEnabled(true);
               }
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == clear) {
               Calculate();
                }
               }
        });
        
         
        Page_One.add(Name);
        Page_One.add(cal);
        Page_One.add(gpa);
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
        Page_One.add(clear);
        Page_One.add(addNew);
        Page_One.add(View);
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
        Lcourse1.setText(null);
        Lcourse2.setText(null);
        semister.setText(null);
        courseList1.setSelectedItem(null);
        semisterList.setSelectedItem(null);
        courseList2.setSelectedItem(null);
    }
    
public static void addData(String StudID,String course1,String course2,String course3,String gpa){
        addNew.setEnabled(false);
        Lcourse1.setEnabled(true);
        Lcourse2.setEnabled(true);
        semister.setEnabled(true);
        try {
            BufferedWriter access = new BufferedWriter(
        new FileWriter( "Database\\GPA.txt",true));
            access.write(StudID+","+course1+","+course2+","+course3+","+gpa);
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
        new FileReader( "Database\\GPA.txt"));
            
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
    public static String c1;
    public static String c2;
    public static String c3;
    public static String Estim;
   public static void grade(){
        try {
           
           BufferedReader access = new BufferedReader(
        new FileReader( "Database\\Course.txt"));
            String line;
    while ((line = access.readLine()) != null) {
        String[] data = line.split(",");
        //tableModel.addRow(data);
        if ((data[1]).equals(IDField.getSelectedItem())){
            courseList1.setSelectedItem(data[2]);
            courseList2.setSelectedItem(data[3]);
            semisterList.setSelectedItem(data[4]);
            c1 = data[2];
            c2 = data[3];
            c3 = data[4];
            courseList1.setEnabled(false);
            courseList2.setEnabled(false);
            semisterList.setEnabled(false);
            
            JOptionPane.showMessageDialog(null, "Insert Student grade for each course \n to calculate the GPA");
            break;
        }
      }
        } catch(FileNotFoundException ex){
            System.out.println("FileNotFound");
        }
        catch (IOException ex) {
           System.out.println("IO Error");
        }
        
        
    }
    public static void Calculate(){
        
        try {
            BufferedWriter ID = new BufferedWriter(
        new FileWriter( "Database\\id.txt",true));
        double c1 = Double.parseDouble(Lcourse1.getText());
        double c2 = Double.parseDouble(Lcourse2.getText());
        double c3 = Double.parseDouble(semister.getText());
        double total;
        if (Lcourse1.getText().equals("")||Lcourse2.getText().equals("")||semister.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Fill the give space");
            
        }
        
        else if (c1 <0 ||c1>4){
            JOptionPane.showMessageDialog(null, "Please put 0 to 4");
        }
        else if (c2 <0 ||c2>4){
            JOptionPane.showMessageDialog(null, "Please put 0 to 4");
        }
        else if (c3 <0 ||c3>4){
            JOptionPane.showMessageDialog(null, "Please put 0 to 4");
        }
        else{
            total = (c1+c2+c3)/3;
            Estim = String.format("%.2f",total);
            System.out.println(Estim);
            JOptionPane.showMessageDialog(null, "Calculated");
            cal.setText(Estim);
            addNew.setEnabled(true);
            Lcourse1.setEnabled(false);
            Lcourse2.setEnabled(false);
            semister.setEnabled(false);
        }
        } catch(FileNotFoundException ex){
            System.out.println("FileNotFound");
        }
        catch (IOException ex) {
           System.out.println("IO Error");
        }
        
        
    }
    }


