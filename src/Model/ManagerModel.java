package Model;

public class ManagerModel {

    private String pdID;
    private String pdName, pdcagetory;
    private int pdprice;
    private int pdQty;
    private String search;

    public ManagerModel() {
    }

    public ManagerModel(String pdID, String pdName, String pdcagetory, int pdprice, int pdQty) {
        this.pdID = pdID;
        this.pdName = pdName;
        this.pdcagetory = pdcagetory;
        this.pdprice = pdprice;
        this.pdQty = pdQty;
    }

    public ManagerModel(String search) {
        this.search = search;
    }

    public String getPdID() {
        return pdID;
    }
    
    public String getPdName() {
        return pdName;
    }

    public String getPdcagetory() {
        return pdcagetory;
    }

    public int getPdprice() {
        return pdprice;
    }

    public int getQty() {
        return pdQty;
    }

    public String getSearch() {
        return search;
    }

}
