package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import server.*;
import serverInterface.Interface_server;

public class Driver {

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to the library Management System");
        System.out.println("Please enter your ID: ");
        Scanner sc = new Scanner(System.in);
        String ID = sc.nextLine();
        Client_Handler handler = new Client_Handler(ID);
        Registry registry = LocateRegistry.getRegistry(2964);
        Interface_server objCo = (Interface_server) registry.lookup("CONCORDIA");
        String init_resp = objCo.verify(ID);
        if (init_resp.matches(".*incorrect*.")) {
            System.out.println(init_resp);
            System.out.println("You are not a registered user please contact your manager");
        } else {
            System.out.println(init_resp);
        }
        System.out.println(objCo.findItem("CONU1234", "light"));
        System.out.println(objCo.borrowItem("CONU1234","CON6000", 3));

    }

}
