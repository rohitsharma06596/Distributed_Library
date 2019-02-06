package remoteInterface;
import java.rmi.server.UnicastRemoteObject;

import serverInterface.Interface_server;


public class ImplementRemoteInterface extends UnicastRemoteObject implements Interface_server {

    public ImplementRemoteInterface() throws Exception {
        super();
    }

    public void addItem(String managerID, String itemID, String itemName, int quantity) {
    }

    public void removeItem(String managerID, String itemID, int quantity) {

    }

    public void listItemAvailability(String managerID){
    }

    public void borrowItem(String userID, String itemID, int numberOfDays){

    }

    public void findItem(String userID, String itemName) {

    }
    public void returnItem(String userID, String itemID) {

    }
    public String verify(String ID) {
        return null;
    }


}
