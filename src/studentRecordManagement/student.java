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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class student extends MainPage{
    
    public static JButton addNew;
    public static JButton clear;
    public static JTextField NameField;
    public static JTextField IDField;
    public static JTextField EmailField;
    public static JTextField ContactField;
    public static JTable table;
    public static DefaultTableModel tableModel; 
    public static student studInfo = new student();
    public static Course courseInfo = new Course();
    public static Score scoreInfo = new Score();
    public static MainPage mainPage = new MainPage();
    
    public static JPanel StudentPage(JFrame frame){
        
        JPanel Page_One = new JPanel();
        JButton logout = new JButton("Logout");
        JButton search = new JButton("Search");
        clear = new JButton("Clear");
        addNew = new JButton("Add New");
        JButton delete = new JButton("Delete");
        JLabel Name = new JLabel("Student Name ");
        JLabel ID = new JLabel("Student ID ");
        JLabel Email = new JLabel("Email Address ");
        JLabel Contact = new JLabel("Phone Number ");
        JTextField searchField = new JTextField();
        NameField = new JTextField();
        IDField = new JTextField();
        EmailField = new JTextField();
        ContactField = new JTextField();
        table = new JTable();
        JPanel LeftBoard = new JPanel();
        JPanel RightBoard = new JPanel();
        JPanel TopBoard = new JPanel();
        JPanel BottomBoard = new JPanel();
        //Table info
        
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Name", "ID", "Email", "Phone Number"}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
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
        EmailField.setBounds(125, 230, 230, 30);
        ContactField.setBounds(125, 330, 230, 30);
        
        RightBoard.add(table);
        RightBoard.setLayout(null);
        Name.setBounds(25, 25, 100, 52);
        Name.setForeground(Color.white);
        ID.setForeground(Color.white);
        Email.setForeground(Color.white);
        Contact.setForeground(Color.white);
        ID.setBounds(25, 120, 100, 52);
        Email.setBounds(25, 220, 100, 52);
        Contact.setBounds(25, 320, 100, 52);
        
        NameField.getText();
        IDField.getText();
        EmailField.getText();
        ContactField.getText();
        
        logout.setBounds(850, 440, 100, 35);
        logout.setBackground(new Color(64,138,175));
        logout.setForeground(Color.white);
        logout.setFocusable(false);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == logout) {
                    int i = JOptionPane.showConfirmDialog(null, "Leaving...", "Registeration", JOptionPane.YES_NO_CANCEL_OPTION);
                    
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
        
        addNew.setBounds(430, 440, 100, 35);
        addNew.setBackground(new Color(64,138,175));
        addNew.setForeground(Color.white);
        addNew.setFocusable(false);
        
        addNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addNew) {
                    if (NameField.getText().equals("")&& IDField.getText().equals("")&&EmailField.getText().equals("") && ContactField.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Please Fill the given space", "Message", JOptionPane.ERROR_MESSAGE);
                    }
                     else if (NameField.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Enter Name");
                    }
                    else if (IDField.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Enter ID");
                    }
                    else if (EmailField.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Enter Email");
                    }
                    else if (ContactField.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Enter Phone Number");
                    }
                    else{
                        
                        addData(NameField.getText(),IDField.getText(),EmailField.getText(),ContactField.getText());
                        logic();
                        courseInfo.logic();
                        courseInfo.logic2();
                }
                    
                    
               }
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == clear) {
               ClearData();
                }
               }
        });
        delete.setBounds(570, 440, 100, 35);
        delete.setBackground(new Color(64,138,175));
        delete.setForeground(Color.white);
        delete.setFocusable(false);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRowCount()==1){
                    int i = JOptionPane.showConfirmDialog(null, "Student Registered", "Registeration", JOptionPane.YES_NO_CANCEL_OPTION);
                    
                    if (i==0){
                        tableModel.removeRow(table.getSelectedRow());
                    }
                }
                else{
                    if(table.getSelectedRowCount()==0){
                        JOptionPane.showMessageDialog(null, "Table is Empty");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Please select Single row for delete!");
                    }
                }
               }
        });
         
        Page_One.add(Name);
        Page_One.add(NameField);
        Page_One.add(ID);
        Page_One.add(IDField);
        Page_One.add(Email);
        Page_One.add(EmailField);
        Page_One.add(Contact);
        Page_One.add(ContactField);
        Page_One.add(search);
        Page_One.add(searchField);
        Page_One.add(logout);
        Page_One.add(clear);
        Page_One.add(delete);
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
        NameField.setText(null);
        IDField.setText(null);
        EmailField.setText(null);
        ContactField.setText(null);
    }
    public static boolean  check;
public static void addData(String Studname,String id,String mail,String phoneNum){
        check = true;
        try {
            BufferedWriter access = new BufferedWriter(
        new FileWriter( "Database\\Student.txt",true));
            BufferedWriter ID = new BufferedWriter(
        new FileWriter( "Database\\id.txt",true));
            
            
            
           BufferedReader reader = new BufferedReader(
        new FileReader( "Database\\id.txt"));
            String line;
      while ((line = reader.readLine()) != null) {
          if (("UGR/"+id+"/14").equals(line)){
              JOptionPane.showMessageDialog(null, "ID already exists!");
              check=false;
              break;
          }
      }
      if (check){
          access.write(Studname+"," +"UGR/"+id+"/14"+","+mail+"@gmail.com"+","+phoneNum);
            access.write("\r\n");
           access.close();
          ID.write("UGR/"+id+"/14");
            ID.write("\r\n");
            ID.close();
            ClearData(); 
            JOptionPane.showConfirmDialog(null, "Student Registered", "Registeration", JOptionPane.CLOSED_OPTION);
      }
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
        NameField.setToolTipText("Example: Jhon");
        IDField.setToolTipText(null);
        EmailField.setToolTipText("Jhon@gmail.com");
        ContactField.setToolTipText("+2519123---");
        try {
             BufferedReader access = new BufferedReader(
        new FileReader( "Database\\Student.txt"));
            String line;
      while ((line = access.readLine()) != null) {
        String[] data = line.split(",");
        tableModel.addRow(data);
      }
        } catch(FileNotFoundException ex){
            System.out.println("FileNotFound");
        }
        catch (IOException ex) {
           System.out.println("IO Error");
        }
    }    

}


