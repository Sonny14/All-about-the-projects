/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginPortal;

/**
 *
 * @author hp
 */
public class UserNode {
    int employeeId;
    String firstName, lastName, email, pass;
    UserNode next;
    
    public UserNode(int employeeId, String firstName, String lastName, String email, String pass){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pass = pass;
        this.next = null;
    }
}
