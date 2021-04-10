//package criminalSearchDatabase;
import java.util.*;
import java.util.Scanner;

public class RegisteredUser {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private UUID userId;
    private boolean isLoggedIn = true;

    public RegisteredUser(UUID userId, String firstName, String lastName, String username, String password, boolean isLoggedIn) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName; 
        this.username = username;
        this.password = password; 
        this.isLoggedIn = isLoggedIn;
        
    }

    public void createNewPassword(String newPass) {
        Scanner s = new Scanner(System.in);
        System.out.println("Create a password: ");
        newPass = s.nextLine();
        newPass = password;
        s.close();
    }

    public void CreateNewUserName(String userName) {
        Scanner s = new Scanner(System.in);
        System.out.println("Create a username: ");
        userName = s.nextLine();
        userName = username;
        s.close();
    }

    public RegisteredUser addUser() {
        return null;
    }

    public boolean getLoggedIn() {
        return isLoggedIn;
    }

    public UUID getId() {
        return this.userId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String toString() {
        return "first name: "+firstName+", last name: "+lastName+".";
    }

}
