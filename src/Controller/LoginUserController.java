package Controller;

import java.sql.*;
import DB.DataBase;
import Model.LoginUserModel;
import View.Cashier;
import View.Manager;
import View.Login;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginUserController {

    DataBase DB = new DataBase();

    public void Login(LoginUserModel loginModel) {
        try {
            PreparedStatement pst = DB.getCon().prepareStatement("SELECT * FROM user WHERE username=? AND password=?");

            pst.setString(1, loginModel.getUserName());
            pst.setString(2, new String(loginModel.getPassword()));
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    String type = rs.getString("userType");
                    JOptionPane.showMessageDialog(null, "Login as a " + rs.getString("userType"));

                    if (type.equals("Manager")) {
                        new Manager().setVisible(true);
                        new Login().setVisible(false);
                    } else if (type.equals("Cashier")) {
                        new Cashier().setVisible(true);
                        new Login().setVisible(false);

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

}
