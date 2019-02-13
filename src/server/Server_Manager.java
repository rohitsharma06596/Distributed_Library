package server;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server_Manager {
    public static void main(String[] args) throws Exception {
        Server_Base concordiaLib = new Server_Base("CONCORDIA");
        Registry registry = LocateRegistry.createRegistry(2964);
        registry.bind("CONCORDIA", concordiaLib);
        concordiaLib = concordiaLib.loadServerRec(concordiaLib);
        System.out.println("Concordia Library has Started");

    }



}
