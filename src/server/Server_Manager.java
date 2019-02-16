package server;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server_Manager {
    /**
     * This is the main trigger method which creates multiple instances of the Base Server class,
     * and checks the validation.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Server_Base concordiaLib = new Server_Base("CONCORDIA");
        Registry cregistry = LocateRegistry.createRegistry(2964);
        cregistry.bind("CONCORDIA", concordiaLib);
        concordiaLib = concordiaLib.loadServerRec(concordiaLib);
        System.out.println("*************************************************************************");
        System.out.println("Concordia Library has Started\n");

        Server_Base mcgillLib = new Server_Base("MCGILL");
        cregistry.bind("MCGILL", mcgillLib);
        mcgillLib = mcgillLib.loadServerRec(mcgillLib);
        System.out.println("*************************************************************************");
        System.out.println("Mcgill Library has Started\n");

        Server_Base montrealuLib = new Server_Base("MONTREALU");
        cregistry.bind("MONTREALU", montrealuLib);
        montrealuLib = montrealuLib.loadServerRec(montrealuLib);
        System.out.println("*************************************************************************");
        System.out.println("Montreal University Library has Started\n");

    }



}
