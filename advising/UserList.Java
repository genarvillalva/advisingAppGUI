package advising;

import java.util.ArrayList;

public class UserList {
    private UserList userList;
    private ArrayList<UserLoginInfo> userAccounts;

    private UserList() {

    }

    public UserList getInstance() {

    }

    public void createAccount(String username, String password) {

    }

    public boolean isUsernameValid(String username) {

        return true;
    }

    public boolean isPasswordValid(String password) {

        return true;
    }

    public String enterUsername() {

        return "";
    }

    public String enterPassword() {

        return "";
    }

    public boolean verifyLoginStudent(String username, String Password) {

    }
    public boolean verifyLoginAdmin(String username, String Password) {
        
    }
    public boolean verifyLoginAdvisor(String username, String Password) {
        
    }

}