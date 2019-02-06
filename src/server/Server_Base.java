package server;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import remoteInterface.ImplementRemoteInterface;

public class Server_Base {
    public static void main(String args[]) throws Exception {

        ImplementRemoteInterface obj = new ImplementRemoteInterface();
        Registry registry = LocateRegistry.createRegistry(2964);
        registry.bind("Concordia", obj);
        System.out.println("Concordia Library has Started");
    }
}
