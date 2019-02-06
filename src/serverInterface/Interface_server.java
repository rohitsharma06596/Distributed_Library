package serverInterface;
import java.rmi.*;

public interface Interface_server extends Remote{

    public void addItem (String managerID, String itemID, String itemName, int quantity) throws RemoteException;
    public void removeItem (String managerID, String itemID, int quantity) throws RemoteException;
    public void listItemAvailability (String managerID) throws RemoteException;
    public void borrowItem (String userID, String itemID, int numberOfDays) throws RemoteException;
    public void findItem (String userID, String itemName) throws RemoteException;
    public void returnItem (String userID, String itemID) throws RemoteException;
    public String verify(String ID)throws RemoteException;
}
