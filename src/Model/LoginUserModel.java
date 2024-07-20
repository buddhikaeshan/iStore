package Model;
    
public class LoginUserModel {
    private String userName;
    private char[] password;

    public LoginUserModel(){}

    public LoginUserModel(String userName, char[] password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public char[] getPassword() {
        return password;
    }

}
