package Model;

public class UserModel {
    private String userName, password,type;
    private String search;
    
    public UserModel() {
    }
    public UserModel(String search) {
        this.search = search;
    }

    public UserModel(String userName, String password, String type) {
        this.userName = userName;
        this.password = password;
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public String getSearch() {
        return search;
    }

}
