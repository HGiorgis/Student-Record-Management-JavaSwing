package studentRecordManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Database extends JFrame{
    File file = new File("Database");
    String Username, Password;
    boolean n=false;
    int Lines;
    public void CreateFile(){
        try{
            FileReader fileRead = new FileReader(file + "\\login.txt");
            System.out.println("File Exists");
        } catch(FileNotFoundException ex){
            try {
                FileWriter fileWrite = new FileWriter(file + "\\login.txt");
                System.out.println("File Created");
            } catch (IOException ex1) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
        
    }

    public void checkData(String username,String password){
        try {
            RandomAccessFile access = new RandomAccessFile(file + "\\login.txt", "rw");
            String line = access.readLine();
            Username = line.substring(10);
            Password = access.readLine().substring(10);
            
            if(username.equals(Username) & password.equals(Password)){
                JOptionPane.showMessageDialog(null, "Valid Login");
                n=true;
            }
            else if (username.equals("") & password.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill User Name and password!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Wrong input");
            }      
        
        } catch(FileNotFoundException ex){
            System.out.println("FileNotFound");
        }
        catch (IOException ex) {
           System.out.println("IO Error");
        }
        
        
    }
     public void logic(String username,String password){
        try {
            
            RandomAccessFile access = new RandomAccessFile(file + "\\login.txt", "rw");
            for(int i=0;i<Lines;i+=4){
            String Uname = access.readLine().substring(10);
            String Pword = access.readLine().substring(10);
            
            if(username.equals(Uname) & password.equals(Pword)){
                JOptionPane.showConfirmDialog(null, "Seccessful!", "Verification", JOptionPane.CLOSED_OPTION);
                n=true;
                break;
            }
            if(username.equals("") | password.equals("")){
                JOptionPane.showConfirmDialog(null, "Please fill the information", "Seggetion", JOptionPane.CLOSED_OPTION);
                break;
            }
            else if (!(username.equals(Uname)) | !(password.equals(Pword))){
                JOptionPane.showMessageDialog(null, "Incorrect UserName and password pleace try again!", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            }
            else if (i==(Lines-3)) {
                JOptionPane.showMessageDialog(null, "Incorrect UserName and password pleace try again!");
                break;
            }
            
            for(int k=1;k<=2;k++){
                access.readLine();
            }
            }
            
                  
        
        } catch(FileNotFoundException ex){
            System.out.println("FileNotFound");
        }
        catch (IOException ex) {
           System.out.println("IO Error");
        }
        
        
    }
    
    public void CountLines(){
        Lines = 1;
        try {
            RandomAccessFile access = new RandomAccessFile(file + "\\login.txt", "rw");
            for(int i=0;access.readLine() !=null; i++){
                    Lines++;
            }
        } catch(FileNotFoundException ex){
            System.out.println("FileNotFound");
        }
        catch (IOException ex) {
           System.out.println("IO Error");
        }
        
        
    }
    
    
}
