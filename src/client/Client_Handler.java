package client;

import serverInterface.Interface_server;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client_Handler {
    Client_Base client;
    private  Interface_server objCo;
    private  Registry registry;
    private String messageBoard;

    public Client_Handler () throws Exception
    {
        trigger();
    }

    public void trigger() throws Exception
    {
        boolean iterParm = false;
        do{
            iterParm = intialize();
            System.out.println(getMessageBoard());
        }while(iterParm);
        appInteractor();

    }

    public void clientStartup(String Parm_ID) {
        client = new Client_Base(Parm_ID);
        this.client = new Client_Base(Parm_ID);
        String server = client.prefixCheck();
        String type = client.typeCheck();

    }

    public String getMessageBoard() {
        return messageBoard;
    }

    public void setMessageBoard(String messageBoard) {
        this.messageBoard = messageBoard;
    }

    public Client_Base getClient() {
        return this.client;
    }
    public  boolean intialize() throws Exception
    {
        System.out.println("Welcome to the library Management System");
        System.out.println("Please enter your ID: ");
        Scanner sc = new Scanner(System.in);
        String ID = sc.nextLine();
        Client_Base client = new Client_Base(ID);
        String serverSelect =  client.prefixCheck();
        if(serverSelect.equals("CONCORDIA"))
        {
            registry = LocateRegistry.getRegistry(2964);
            objCo = (Interface_server) registry.lookup("CONCORDIA");
            clientStartup(ID);
            return true;

        }
        else if(serverSelect.equals("MCGILL"))
        {
            registry = LocateRegistry.getRegistry(2965);
            objCo = (Interface_server) registry.lookup("MONTREALU");
            clientStartup(ID);
            return true;
        }
        else if(serverSelect.equals("MONTREALU"))
        {

            registry = LocateRegistry.getRegistry(2966);
            objCo = (Interface_server) registry.lookup("MONTREALU");
            clientStartup(ID);
            return true;
        }
        else
        {
            System.out.println("The ID is not related to any available server please try again;");
            setMessageBoard("The ID is not related to any available server please try again");
            return false;
        }
    }
    public void appInteractor() throws RemoteException
    {
        boolean continu = true;
        while(continu)
        {
            String interacString = objCo.verify(client.getTotalID());
            System.out.println(interacString);
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            if(client.getID_Type().equals("Manager"))
            {
                if (input == 1)
                {
                    System.out.println("Please enter the item ID: ");
                    String itemID = sc.nextLine();
                    System.out.println(("Please enter the item name: "));
                    String itemName = sc.nextLine();
                    System.out.println("Please enter the quantity of this item you want to add to our resources: ");
                    int quantity = sc.nextInt();
                    System.out.println("The call is being made to the server...");
                    interacString = objCo.addItem(client.getTotalID(), itemID, itemName, quantity);
                    if(interacString.equalsIgnoreCase("The record for this item is currently being used by another user"))
                    {
                        System.out.println("We will try to connect the  server again in a few seconds, please wait...");

                        do{
                            interacString = objCo.addItem(client.getTotalID(), itemID, itemName, quantity);
                            System.out.println("The record for this item is still being used by another user");
                            System.out.println("We will try to connect the  server again in a few seconds, please wait...");

                        }while(interacString != "The record for this item is currently being used by another user");
                        System.out.println(interacString);
                    }
                    else
                    {
                        System.out.println(interacString);
                    }
                }
                else if(input == 2)
                {
                    System.out.println("Please enter the item ID: ");
                    String itemID = sc.nextLine();
                    System.out.println("Please enter the quantity you want to reduce or enter 0 for complete removal: ");
                    int quantity = sc.nextInt();
                    System.out.println("The call is being made to the server...");
                    if(quantity == 0)
                    {
                        interacString = objCo.removeItem(client.getTotalID(),itemID,quantity,true);
                        System.out.println(interacString);
                    }
                    else
                    {
                        interacString = objCo.removeItem(client.getTotalID(),itemID,quantity,false);
                        System.out.println(interacString);
                    }
                    if(interacString.equalsIgnoreCase("The record for this item is currently being used by another user"))
                    {
                        System.out.println("We will try to connect the  server again in a few seconds, please wait...");

                        do{
                            if(quantity == 0)
                            {
                                interacString = objCo.removeItem(client.getTotalID(),itemID,quantity,true);
                                System.out.println(interacString);
                            }
                            else
                            {
                                interacString = objCo.removeItem(client.getTotalID(),itemID,quantity,false);
                                System.out.println(interacString);
                            }
                            System.out.println("The record for this item is still being used by another user");
                            System.out.println("We will try to connect the  server again in a few seconds, please wait...");

                        }while(interacString != "The record for this item is currently being used by another user");
                        System.out.println(interacString);
                    }
                    else
                    {
                        System.out.println(interacString);
                    }


                }
                else if(input == 3)
                {
                    interacString = objCo.listItemAvailability(client.getTotalID());
                    System.out.println(interacString);
                }
                else if(input == 0)
                {
                    System.out.println("Thank-you for using our services. :)");
                    return;
                }
            }
            else if(client.getID_Type() == "User")
            {
                if (input == 1)
                {
                    System.out.println("Please enter the item ID you want to borrow: ");
                    String itemID = sc.nextLine();
                    System.out.println("Please enter the number of days you want to borrow this for: ");
                    int days = sc.nextInt();
                    System.out.println("The call is being made to the server...");
                    interacString = objCo.borrowItem(client.getTotalID(), itemID, days);
                    if(interacString.equalsIgnoreCase("The record for this item is currently being used by another user\n"))
                    {
                        System.out.println("We will try to connect the  server again in a few seconds, please wait...\n");

                        do{
                            interacString = objCo.borrowItem(client.getTotalID(),itemID,days);
                            System.out.println(interacString);
                            System.out.println("The record for this item is still being used by another user\n");
                            System.out.println("We will try to connect the  server again in a few seconds, please wait...\n");

                        }while(interacString != "The record for this item is currently being used by another user\n");
                        System.out.println("The previous user's actions a re completed, your action will be performed next.\n");
                    }
                    else
                    {
                        if(interacString.contains("Would you like to be added to the waitlist? Enter Y for Yes and N for No"))
                        {
                            String resp = sc.nextLine();
                            if(resp == "Y")
                            {
                                System.out.println("CAll the waitlist methood in the server");
                            }

                        }
                        else
                        {
                            System.out.println(interacString);
                        }
                    }
                }else if(input == 2)
                {
                    System.out.println("Please enter the item name you want to search for in the library: ");
                    String itemName = sc.nextLine();
                    interacString = objCo.findItem(client.getTotalID(),itemName);
                    System.out.println(interacString);
                }
                else if(input == 3)
                {
                    System.out.println("Please enter the item ID you want want to return");
                    String itemID = sc.nextLine();
                    interacString = objCo.returnItem(client.getTotalID(),itemID);
                    System.out.println(interacString);
                    System.out.println("The call is being made to the server...");
                    interacString = objCo.borrowItem(client.getTotalID(), itemID, days);
                    if(interacString.equalsIgnoreCase("The record for this item is currently being used by another user\n"))
                    {
                        System.out.println("We will try to connect the  server again in a few seconds, please wait...\n");

                        do{
                            interacString = objCo.borrowItem(client.getTotalID(),itemID,days);
                            System.out.println(interacString);
                            System.out.println("The record for this item is still being used by another user\n");
                            System.out.println("We will try to connect the  server again in a few seconds, please wait...\n");

                        }while(interacString != "The record for this item is currently being used by another user\n");
                        System.out.println("The previous user's actions a re completed, your action will be performed next.\n");
                    }
                    else
                    {
                        if(interacString.contains("Would you like to be added to the waitlist? Enter Y for Yes and N for No"))
                        {
                            String resp = sc.nextLine();
                            if(resp == "Y")
                            {
                                System.out.println("CAll the waitlist methood in the server");
                            }

                        }
                        else
                        {
                            System.out.println(interacString);
                        }
                    }

                }

                else if(input == 0)
                {
                    System.out.println("Thank-you for using our services. :)");
                    return;
                }
            }
            System.out.println("Enter \"Yes\" for continue doing more operations and \"No\" to quit.\n");
            String check = sc.nextLine();
            boolean exitParm = false;
            do {
                if (check.equalsIgnoreCase("Yes")) {
                    exitParm = true;
                    continu = true;
                } else if (check.equalsIgnoreCase("No")) {
                    exitParm = true;
                    continu = false;
                    System.out.println("Thanks for using our services. :)");

                } else {
                    System.out.println("Your choice was invalid please enter a valid exit code.\n");
                    System.out.println("Enter Yes for continue doing more operations and No to quit.\n");
                }
            }while(exitParm);
        }

    }
}