package client;

public class Client_Base {
    String ID_Prefix;
    String ID_Type;
    String ID_Number;

    public Client_Base(String parm_ID) {
        this.ID_Prefix = parm_ID.substring(0, 3);
        this.ID_Type = parm_ID.substring(3, 4);
        this.ID_Number = parm_ID.substring(4);
    }

    public String getID_Prefix() {
        return ID_Prefix;
    }

    public void setID_Prefix(String ID_Prefix) {
        this.ID_Prefix = ID_Prefix;
    }

    public String getID_Type() {
        return ID_Type;
    }

    public void setID_Type(String ID_Type) {
        this.ID_Type = ID_Type;
    }

    public String getID_Number() {
        return ID_Number;
    }

    public void setID_Number(String ID_Number) {
        this.ID_Number = ID_Number;
    }

    public String prefixCheck() {
        if (this.ID_Prefix == "CON")
            return "CONCORDIA";
        if (this.ID_Prefix == "MCG")
            return "MCGILL";
        if (this.ID_Prefix == "MON")
            return "MONTREALU";
        else
            return "Invalid ID";
    }

    public String typeCheck() {
        if (this.ID_Type == "U")
            return "User";
        if (this.ID_Type == "M")
            return "Manager";
        return "Invalid ID";
    }

    public String idNumbercheck(){
        if(Integer.parseInt(this.getID_Number()) < 9999)
        {
            return "Okay";
        }
        else
        {
            return "Invalid ID";
        }
    }

    public String getTotalID() {
        return getID_Prefix()+getID_Type()+getID_Number();
    }

}
