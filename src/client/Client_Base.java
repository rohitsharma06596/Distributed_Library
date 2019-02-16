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

    /**getter for ID prefix
     * @return
     */
    public String getID_Prefix() {
        return ID_Prefix;
    }

    public void setID_Prefix(String ID_Prefix) {
        this.ID_Prefix = ID_Prefix;
    }

    /**getter for if type
     * @return
     */
    public String getID_Type() {
        return ID_Type;
    }

    public void setID_Type(String ID_Type) {
        this.ID_Type = ID_Type;
    }

    /**getter for ID number
     *
     * @return
     */
    public String getID_Number() {
        return ID_Number;
    }

    public void setID_Number(String ID_Number) {
        this.ID_Number = ID_Number;
    }

    /**method for ID prefix check
     * @return
     */
    public String prefixCheck() {
        if (this.ID_Prefix.equals("CON"))
            return "CONCORDIA";
        if (this.ID_Prefix.equals("MCG"))
            return "MCGILL";
        if (this.ID_Prefix.equals("MON"))
            return "MONTREALU";
        else
            return "Invalid ID";
    }

    /**Method for user type check
     * @return
     */
    public String typeCheck() {
        if (this.ID_Type.equals("U"))
            return "User";
        if (this.ID_Type.equals("M"))
            return "Manager";
        return "Invalid ID";
    }

    /**check for valid ID number
     * @return
     */
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

    /**Overall ID check method
     * @return
     */
    public String allCheck()
    {
        if(!(this.prefixCheck().equals("Invalid ID")) &&(!(this.typeCheck().equals("Invalid ID")))&&(!(this.idNumbercheck().equals("Invalid ID"))))
        {
            System.out.println("The ID is valid");
            return "Okay";
        }
        else
        {
            System.out.println("The ID is invalid");
            return "Invalid ID";
        }
    }

    /**Getter for total ID
     * @return
     */
    public String getTotalID() {
        return getID_Prefix()+getID_Type()+getID_Number();
    }

}
