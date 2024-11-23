/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginPortal;

import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class UserLinkedList {

    UserNode head;

    public UserLinkedList() {
        head = null;
    }

    //Method to add the user
    public void addUser(int employeeId, String firstName, String lastName, String email, String pass) {
        UserNode newNode = new UserNode(employeeId, firstName, lastName, email, pass);

        if (head == null) {
            head = newNode;
        } else {
            UserNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("User was added successfully");
    }

    //Method to display the users
    public void displayUsers() {
        UserNode current = head;
        while (current != null) {
            System.out.println("\nEmployee ID: " + current.employeeId + "\nFirst Name: " + current.firstName + "\nLast Name: " + current.lastName + "\nEmail address: " + current.email + "\nPassword: " + current.pass);
            current = current.next;
        }
    }

    //Method to edit the details of the users
    public void edit(int employeeId, String newFirstName, String newLastName, String newEmail, String newPass) {
        UserNode current = head;
        while (current != null) {
            if (current.employeeId == employeeId) {
                current.firstName = newFirstName;
                current.lastName = newLastName;
                current.email = newEmail;
                current.pass = newPass;
                
                System.out.println("\nUpdated details of employee "+current.employeeId+":\nFirst Name: " + current.firstName + "\nLast Name: " + current.lastName + "\nEmail address: " + current.email + "\nPassword: " + current.pass);
                return;
            }
            current = current.next;
        }
        System.out.println("Element not found");
    }
    
    //Method for user validdation
    public boolean validateUser(int employeeId, String pass){
        UserNode current = head;
        while(current != null){
            if(current.employeeId == employeeId && current.pass.equals(pass)){
                System.out.println("\nRecords matches");
                return true;
            }
            current = current.next;
        }
        JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println("\nNo records found");
        return false;
    }
}
