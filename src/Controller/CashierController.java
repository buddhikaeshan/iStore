package Controller;

import DB.DataBase;
import Model.CashierModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CashierController {

    DataBase DB = new DataBase();

    public ResultSet Search(CashierModel model) {
        try {
            PreparedStatement pst = DB.getCon().prepareStatement("SELECT * FROM product WHERE Name LIKE ? OR ID LIKE ? OR Category LIKE ?");
            pst.setString(1, "%" + model.getSearch() + "%");
            pst.setString(2, "%" + model.getSearch() + "%");
            pst.setString(3, "%" + model.getSearch() + "%");

            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (Exception ex) {
            Logger.getLogger(CashierController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
