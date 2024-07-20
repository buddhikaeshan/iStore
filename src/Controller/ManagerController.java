
package Controller;

import java.sql.*;
import DB.DataBase;
import Model.ManagerModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ManagerController {

    DataBase DB = new DataBase();
    ResultSet rs = null;

    public void addProducts(ManagerModel model) {
        try {
            PreparedStatement pts = DB.getCon().prepareStatement("INSERT INTO product (ID,Name,Category,Price,Quantity) VALUES (?,?,?,?,?)");
            pts.setString(1, model.getPdID());
            pts.setString(2, model.getPdName());
            pts.setString(3, model.getPdcagetory());
            pts.setInt(4, model.getPdprice());
            pts.setInt(5, model.getQty());
            int row = pts.executeUpdate();
            JOptionPane.showMessageDialog(null, "item added !!!");
            DB.getCon().close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void editProduct(ManagerModel model) {
        try {
            PreparedStatement pts = DB.getCon().prepareStatement("UPDATE `istore`.`product` SET `ID`='" + model.getPdID() + "',`Name`='" + model.getPdName() + "',`Category`='" + model.getPdcagetory() + "',`Price`='" + model.getPdprice() + "',`Quantity`= '" + model.getQty() + "' WHERE (`ID` = '" + model.getPdID() + "')");
            int row = pts.executeUpdate();
            JOptionPane.showMessageDialog(null, "item Update !!!");
            DB.getCon().close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void deleteProduct(ManagerModel model) {
        try {
            PreparedStatement pts = DB.getCon().prepareStatement("DELETE FROM `istore`.`product` WHERE (`ID` = '" + model.getPdID() + "')");
            int row = pts.executeUpdate();
            JOptionPane.showConfirmDialog(null, "Do you want to delete this product?", "Deleting!",
                    JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            DB.getCon().close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ResultSet Search(ManagerModel model) {
        try {
            PreparedStatement pst = DB.getCon().prepareStatement("select * from product where Name like ? or ID LIKE ?");
            pst.setString(1, "%" + model.getSearch() + "%");
            pst.setString(2, "%" + model.getSearch() + "%");
            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (Exception ex) {
            Logger.getLogger(ManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
