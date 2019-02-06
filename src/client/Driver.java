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
        Interface_server obj = (Interface_server) registry.lookup("Concordia");
        String init_resp = obj.verify(ID);
        if (init_resp == "False") {
            System.out.println("You are not a registered user please contact your manager");
        } else {

        }

    }

}
