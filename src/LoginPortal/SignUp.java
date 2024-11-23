
/*
 * Click nbfs
://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package LoginPortal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class SignUp extends JFrame implements ActionListener {

    //Declaration of variables
    JLabel titleLabel, firstNameLabel, lastNameLabel, idLabel, emailLabel, passLabel, confirmLabel;
    JTextField firstNameField, lastNameField, idField, emailField;
    JButton submitBtn, clearBtn;
    JPanel panel01;
    JPasswordField passwordField, confirmField;
    
    //Linked list object
    static UserLinkedList list = new UserLinkedList();
    
    //Constructor
    SignUp() {

        //Frame properties
        this.setVisible(true);
        this.setSize(1020, 780);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Sign-up Cinetix");
        this.setLayout(null);

        //Panels
        panel01 = new JPanel();
        panel01.setSize(510, 780);
        panel01.setLayout(null);
        panel01.setBackground(Color.blue);
        add(panel01);

        //Labels
        titleLabel = new JLabel("Add Employee");
        titleLabel.setFont(new Font("Sans Serif", Font.BOLD, 24));
        firstNameLabel = new JLabel("First Name");
        firstNameLabel.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        idLabel = new JLabel("Employee ID");
        idLabel.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        passLabel = new JLabel("Password");
        passLabel.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        confirmLabel = new JLabel("Confirm password");
        confirmLabel.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        add(titleLabel);
        add(firstNameLabel);
        add(lastNameLabel);
        add(idLabel);
        add(emailLabel);
        //add(passLabel);
        add(passLabel);
        add(confirmLabel);
        titleLabel.setBounds(680, 90, 200, 30);
        firstNameLabel.setBounds(580, 150, 100, 20);
        lastNameLabel.setBounds(790, 150, 100, 20);
        idLabel.setBounds(580, 230, 100, 20);
        emailLabel.setBounds(580, 310, 100, 20);
        passLabel.setBounds(580, 390, 150, 20);
        confirmLabel.setBounds(580, 470, 150, 20);

        //Text Fields
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        idField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        confirmField = new JPasswordField();

        add(firstNameField);
        add(lastNameField);
        add(idField);
        add(emailField);
        add(passwordField);
        add(confirmField);
        firstNameField.setBounds(580, 170, 150, 35);
        lastNameField.setBounds(790, 170, 150, 35);
        idField.setBounds(580, 250, 250, 35);
        emailField.setBounds(580, 330, 250, 35);
        passwordField.setBounds(580, 410, 250, 35);
        confirmField.setBounds(580, 490, 250, 35);

        //Buttons
        submitBtn = new JButton("Submit");
        clearBtn = new JButton("Clear");
        submitBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        add(submitBtn);
        add(clearBtn);
        submitBtn.setBounds(785, 570, 130, 35);
        clearBtn.setBounds(610, 570, 130, 35);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            try {
                String s1 = idField.getText();
                char[] s2 = passwordField.getPassword();
                char[] s3 = confirmField.getPassword();

                int employeeId = Integer.parseInt(s1);
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String email = emailField.getText();
                String pass = new String(s2);
                String confPass = new String(s3);

                if (pass.isEmpty()) {
                    System.out.println("Password is null");
                    JOptionPane.showMessageDialog(this, "Password is empty!", "Warning!", JOptionPane.ERROR_MESSAGE);
                } else if (confPass.isEmpty()) {
                    System.out.println("Confirm password is null");
                    JOptionPane.showMessageDialog(this, "Please confirm your password", "Warning!", JOptionPane.ERROR_MESSAGE);
                } else if (firstName.isEmpty()) {
                    System.out.println("First name is null");
                    JOptionPane.showMessageDialog(this, "Firstname and Lastname is empty", "Warning!", JOptionPane.ERROR_MESSAGE);
                } else if (lastName.isEmpty()) {
                    System.out.println("Last name is null");
                    JOptionPane.showMessageDialog(this, "Firstname and Lastname is empty", "Warning!", JOptionPane.ERROR_MESSAGE);
                } else if (s1.isEmpty()) {
                    System.out.println("Employee id is null");
                    JOptionPane.showMessageDialog(this, "Employee Id is empty", "Warning!", JOptionPane.ERROR_MESSAGE);
                } else if (email.isEmpty()) {
                    System.out.println("Email is null");
                    JOptionPane.showMessageDialog(this, "Email is empty", "Warning!", JOptionPane.ERROR_MESSAGE);
                } else if (confPass.equals(pass)) {
                    try {
                        
                        //Sign-up logic here
                        list.addUser(employeeId, firstName, lastName, email, pass);
                        list.displayUsers();
                        this.dispose();
                        new Login();
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Password do not match");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Entered an invalid character in employee id, must be an integer!");
                JOptionPane.showMessageDialog(this, "Employee ID is invalid", "Warning!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            firstNameField.setText("");
            lastNameField.setText("");
            idField.setText("");
            emailField.setText("");
            passwordField.setText("");
            confirmField.setText("");
        }
    }

    public static void main(String[] args) {
        SignUp signUp = new SignUp();
        signUp.setVisible(true);
    }

}
