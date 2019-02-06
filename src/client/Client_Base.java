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

    public String prefixCheck() {
        if (this.ID_Prefix == "CON")
            return "Concordia";
        if (this.ID_Prefix == "MCG")
            return "Mcgill";
        if (this.ID_Prefix == "MON")
            return "UMontreal";
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

    public String getIDNumber() {
        return ID_Number;
    }

}
