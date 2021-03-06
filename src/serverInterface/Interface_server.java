package serverInterface;
import java.net.UnknownHostException;
import java.rmi.*;

public interface Interface_server extends Remote{

    public String addItem (String managerID, String itemID, String itemName, int quantity) throws RemoteException;
    public String removeItem (String managerID, String itemID, int quantity, boolean completeRemove) throws RemoteException;
    public String listItemAvailability (String managerID) throws RemoteException;
    public String borrowItem (String userID, String itemID, int numberOfDays) throws RemoteException, UnknownHostException;
    public String findItem (String userID, String itemName) throws RemoteException, UnknownHostException;
    public String returnItem (String userID, String itemID) throws RemoteException;
    public String verify(String ID)throws RemoteException;
    public boolean load_server(String server_name) throws RemoteException;
    public String addToWait(String parm, String itemID, String userID) throws RemoteException;
    public String exchangeItem(String userID, String newItemID, String oldItemID) throws RemoteException;
}
