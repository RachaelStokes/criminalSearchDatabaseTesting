import java.util.ArrayList;
import java.util.*;

public class RegisteredUsers {
  public static RegisteredUsers registeredUsers = null;
  private static ArrayList<RegisteredUser> registeredUserList = new ArrayList<RegisteredUser>();

  private RegisteredUsers() {
    registeredUserList = DataReader.readUser();
  }

  public static RegisteredUsers getInstance() {
    if (registeredUsers == null) {
      registeredUsers = new RegisteredUsers();
    }
    return registeredUsers;
  }

  public ArrayList<RegisteredUser> getRegisteredUsers() {
    return registeredUserList;
  }

  // get person based on id

  public static void addRegisteredUser(UUID userId, String firstName, String lastName, String username, String password,
      boolean isLoggedIn) {
    registeredUserList.add(new RegisteredUser(userId, firstName, lastName, username, password, isLoggedIn));
    DataWriter.saveUsers();
  }
}