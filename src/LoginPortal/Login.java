package LoginPortal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Login extends JFrame implements ActionListener {

    JLabel label00, label01, label02;
    JTextField textField01; // ID field
    JPasswordField passField; // Password field
    JButton loginBtn, clearBtn; // Login and clear buttons
    JPanel panel01; // Panel
    File file = new File("C:\\Files"); // File path
    int lines;

    // Constructor
    Login() {

        // Panels
        panel01 = new JPanel();
        panel01.setSize(510, 780);
        panel01.setLayout(null);
        panel01.setBackground(Color.blue);
        //add(panel01);

        // Labels
        label00 = new JLabel("Login to Cinetix");
        label00.setFont(new Font("Sans Serif", Font.BOLD, 24));
        label01 = new JLabel("Enter Email:");
        label01.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        label02 = new JLabel("Enter Password:");
        label02.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        add(label00);
        add(label01);
        add(label02);
        label00.setBounds(160, 50, 200, 30);
        label01.setBounds(50, 150, 100, 20);
        label02.setBounds(50, 230, 100, 20);

        // Text Fields
        textField01 = new JTextField();
        passField = new JPasswordField();
        add(textField01);
        add(passField);
        textField01.setBounds(160, 150, 250, 35);
        passField.setBounds(160, 230, 250, 35);

        // Buttons
        loginBtn = new JButton("Login");
        clearBtn = new JButton("Clear");
        loginBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        add(loginBtn);
        add(clearBtn);
        loginBtn.setBounds(275, 310, 130, 35);
        clearBtn.setBounds(130, 310, 130, 35);
        add(panel01);
        
        //Frame Properties
        this.setTitle("Login");
        this.setSize(520, 520);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    
    }

    // Create a folder
    void createFolder() {
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    // Read text file
    void readFile() {
        try {
            FileReader fileReader = new FileReader(file + "\\logins.txt");
            System.out.println("File exists!");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fileWriter = new FileWriter(file + "\\logins.txt");
                System.out.println("File was created");
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }

    // Login logic
    void logic(String user, String pass) throws IOException{
        try{
            RandomAccessFile raf = new RandomAccessFile(file+"\\logins.txt", "rw");
            for(int i = 0; i < lines; i+=5){
                System.out.println("Count: "+i);
                String lineUser = raf.readLine();
                String linePass = raf.readLine();
                
                if(lineUser != null && linePass != null){
                    String forUser = lineUser.substring(9);
                    String forPass = linePass.substring(9);
                   
//                   String forUser = lineUser;
//                   String forPass = linePass;
                    System.out.println("User: "+forUser+"Pass: "+forPass);
                    
                    if(user.equals(forUser) && pass.equals(forPass)){
                        JOptionPane.showMessageDialog(null, "Login Successfully!!"); 
                        break;
                    }else if(i == (lines - 5)){
                        //Adjusting index to lines count
                        JOptionPane.showMessageDialog(null, "Incorrect username/password"); 
                        break;
                    }else{
                        System.out.println("Skipped invalid line with insufficient length or null:"+lineUser+", "+linePass);
                    }
                    //Skip next lines
                    for (int k = 1; k <= 5; k++) { if (raf.readLine() == null) { break;
                }
            }
        }
    }
        }catch (FileNotFoundException ex) { ex.printStackTrace();
    }
    }


    // Count the number of lines in the file
    void countLines() {
        try {
            lines = 0;
            RandomAccessFile raf = new RandomAccessFile(file + "\\logins.txt", "rw");
            while (raf.readLine() != null) {
                lines++;
            }
            System.out.println("Number of lines: " + lines);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Action performed
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            String str1 = textField01.getText();
            char[] p = passField.getPassword();
            String str2 = new String(p);

            try {
                createFolder();
                readFile();
                countLines();
                logic(str1, str2);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else {
            textField01.setText("");
            passField.setText("");
        }
    }
    
    void listDirectoryContents() {
    File dir = new File("C:\\Files");
    if (dir.exists() && dir.isDirectory()) {
        String[] files = dir.list();
        if (files != null) {
            for (String fileName : files) {
                System.out.println("Found file: " + fileName);
            }
        } else {
            System.out.println("Directory is empty.");
        }
    } else {
        System.out.println("Directory does not exist.");
    }
}


    public static void main(String arr[]) {
        Login login = new Login();
        login.listDirectoryContents();
    }
}
