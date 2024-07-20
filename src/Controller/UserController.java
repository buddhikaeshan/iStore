package Controller;

import java.sql.*;
import Model.UserModel;
import DB.DataBase;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UserController {

    DataBase DB = new DataBase();

    public void addAcc(UserModel model) {
        try {
            PreparedStatement pts = DB.getCon().prepareStatement("insert into user values (?,?,?,?)");
            pts.setInt(1, 0);
            pts.setString(2, model.getUserName());
            pts.setString(3, model.getPassword());
            pts.setString(4, model.getType());
            int row = pts.executeUpdate();
            JOptionPane.showMessageDialog(null, "Account Added !!!");
            DB.getCon().close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void editProduct(UserModel model) {
        try {
            
            PreparedStatement pts = DB.getCon().prepareStatement("UPDATE `istore`.`user` SET `username`='"+model.getUserName()+"',`Password`='"+model.getPassword()+"',`userType`='"+model.getType()+"' where (`username`='"+model.getUserName()+"')");
            int row = pts.executeUpdate();
            JOptionPane.showMessageDialog(null, "Account Update !!!");
            DB.getCon().close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void deleteProduct(UserModel model){
        try {
            PreparedStatement pts = DB.getCon().prepareStatement("DELETE FROM `istore`.`user` WHERE (`username` = '" + model.getUserName() + "')");
            int row = pts.executeUpdate();
            JOptionPane.showConfirmDialog(null, "Do you want to delete this Account?", "Deleting!",
                    JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            DB.getCon().close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet search(UserModel model) {   
        try {
            PreparedStatement pst = DB.getCon().prepareStatement("SELECT * FROM user WHERE username LIKE ? OR userType LIKE ?");
            pst.setString(1, "%" + model.getSearch() + "%");
            pst.setString(2, "%" + model.getSearch() + "%");

            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
