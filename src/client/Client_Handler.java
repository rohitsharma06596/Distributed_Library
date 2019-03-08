package client;

import serverInterface.Interface_server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLOutput;
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

    /**This method initatates the clien trigger
     * @throws Exception
     */
    public void trigger() throws Exception
    {
        boolean iterParm = false;
        do{
            iterParm = intialize();
        }while(iterParm);
        appInteractor();

    }

    /**clien intance setup
     * @param Parm_ID
     */
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

    /**Initalize and load a client
     * @return
     * @throws Exception
     */
    public  boolean intialize() throws Exception
    {
        System.out.println("Welcome to the library Management System");
        appendStrToFile("Welcome to the library Management System");
        String ID = "";
        String serverSelect;
        do {
            System.out.println("Please enter your ID: ");
            appendStrToFile("Please enter your ID: ");
            Scanner sc = new Scanner(System.in);
            ID = sc.nextLine();
            clientStartup(ID);
            serverSelect = this.client.prefixCheck();
        }while(!(client.allCheck().equals("Okay")));
        if(serverSelect.equals("CONCORDIA"))
        {
            registry = LocateRegistry.getRegistry(2964);
            objCo = (Interface_server) registry.lookup("CONCORDIA");
            clientStartup(ID);
            System.out.println("******WELCOME TO CONCORDIA UNIVERSITY LIBRARY******");
            appendStrToFile("******WELCOME TO CONCORDIA UNIVERSITY LIBRARY******");
            return false;

        }
        else if(serverSelect.equals("MCGILL"))
        {
            registry = LocateRegistry.getRegistry(2964);
            objCo = (Interface_server) registry.lookup("MCGILL");
            clientStartup(ID);
            System.out.println("******WELCOME TO MCGILL UNIVERSITY LIBRARY******");
            appendStrToFile("******WELCOME TO MCGILL UNIVERSITY LIBRARY******");
            return false;
        }
        else if(serverSelect.equals("MONTREALU"))
        {

            registry = LocateRegistry.getRegistry(2964);
            objCo = (Interface_server) registry.lookup("MONTREALU");
            clientStartup(ID);
            System.out.println("******WELCOME TO UNIVERSITY OF MONTREAL LIBRARY******");
            appendStrToFile("******WELCOME TO UNIVERSITY OF MONTREAL LIBRARY******");
            return false;
        }
        else
        {
            System.out.println("The ID is not related to any available server please try again;");
            appendStrToFile("The ID is not related to any available server please try again;");
            setMessageBoard("The ID is not related to any available server please try again");
            return true;
        }
    }

    /**This method handeles all the user interaction directly with the server
     * @throws RemoteException
     * @throws InterruptedException
     * @throws UnknownHostException
     */
    public void appInteractor() throws RemoteException, InterruptedException, UnknownHostException {
        boolean continu = true;
        while(continu)
        {
            String interacString = "";
            interacString = objCo.verify(client.getTotalID());
            System.out.println(interacString);
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if(client.typeCheck().equals("Manager"))
            {

                if (input.equals("1"))
                {
                    System.out.println("Please enter the item ID: ");
                    appendStrToFile("Please enter the item ID: ");
                    String itemID = sc.nextLine();
                    System.out.println(("Please enter the item name: "));
                    appendStrToFile(("Please enter the item name: "));
                    String itemName = sc.nextLine();
                    System.out.println("Please enter the quantity of this item you want to add to our resources: ");
                    appendStrToFile("Please enter the quantity of this item you want to add to our resources: ");
                    int quantity = sc.nextInt();
                    System.out.println("The call is being made to the server...");
                    appendStrToFile("The call is being made to the server...");
                    interacString = objCo.addItem(client.getTotalID(), itemID, itemName, quantity);
                    if(interacString.equalsIgnoreCase("The record for this item is currently being used by another user"))
                    {
                        System.out.println("We will try to connect the  server again in a few seconds, please wait...");
                        appendStrToFile("We will try to connect the  server again in a few seconds, please wait...");

                        do{
                            interacString = objCo.addItem(client.getTotalID(), itemID, itemName, quantity);
                            System.out.println("The record for this item is still being used by another user");
                            appendStrToFile("The record for this item is still being used by another user");
                            System.out.println("We will try to connect the  server again in a few seconds, please wait...");
                            appendStrToFile("We will try to connect the  server again in a few seconds, please wait...");
                            wait(10000000);
                        }while(interacString != "The record for this item is currently being used by another user");
                        System.out.println("The previous user's actions are completed, your action will be performed next.\n");
                        appendStrToFile("The previous user's actions are completed, your action will be performed next.\n");
                        System.out.println(interacString);
                        appendStrToFile(interacString);
                    }
                    else
                    {
                        System.out.println(interacString);
                        appendStrToFile(interacString);
                    }
                }
                else if(input.equals("2"))
                {
                    System.out.println("Please enter the item ID: ");
                    appendStrToFile("Please enter the item ID: ");
                    String itemID = sc.nextLine();
                    System.out.println("Please enter the quantity you want to reduce or enter 0 or any negative number for complete removal: ");
                    appendStrToFile("Please enter the quantity you want to reduce or enter 0 or any negative number for complete removal: ");
                    int quantity = sc.nextInt();
                    System.out.println("The call is being made to the server...");
                    appendStrToFile("The call is being made to the server...");
                    if(quantity <= 0)
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
                        appendStrToFile("We will try to connect the  server again in a few seconds, please wait...");

                        do{
                            if(quantity <= 0)
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
                            appendStrToFile("The record for this item is still being used by another user");
                            System.out.println("We will try to connect the  server again in a few seconds, please wait...");
                            appendStrToFile("We will try to connect the  server again in a few seconds, please wait...");
                            wait(10000000);
                        }while(interacString != "The record for this item is currently being used by another user");
                        System.out.println("The previous user's actions are completed, your action will be performed next.\n");
                        appendStrToFile("The previous user's actions are completed, your action will be performed next.\n");
                        System.out.println(interacString);
                        appendStrToFile(interacString);
                    }
                    else
                    {

                        appendStrToFile(interacString);
                        System.out.println(interacString);
                    }


                }
                else if(input.equals("3"))
                {
                    interacString = objCo.listItemAvailability(client.getTotalID());

                    System.out.println(interacString);
                    appendStrToFile(interacString);
                }
                else if(input.equals("0"))
                {
                    System.out.println("Thank-you for using our services. :)");
                    appendStrToFile("Thank-you for using our services. :)");
                    return;
                }
            }
            else if(client.typeCheck().equals("User"))
            {
                if (input.equals("1"))
                {
                    System.out.println("Please enter the item ID you want to borrow: ");
                    appendStrToFile("Please enter the item ID you want to borrow: ");
                    String itemID = sc.nextLine();
                    System.out.println("Please enter the number of days you want to borrow this for: ");
                    appendStrToFile("Please enter the number of days you want to borrow this for: ");
                    int days = sc.nextInt();
                    System.out.println("The call is being made to the server...");
                    appendStrToFile("The call is being made to the server...");
                    interacString = objCo.borrowItem(client.getTotalID(), itemID, days);
                    if(interacString.equalsIgnoreCase("The record for this item is currently being used by another user\n"))
                    {
                        System.out.println("We will try to connect the  server again in a few seconds, please wait...\n");
                        appendStrToFile("We will try to connect the  server again in a few seconds, please wait...\n");

                        do{
                            interacString = objCo.borrowItem(client.getTotalID(),itemID,days);
                            System.out.println(interacString);
                            appendStrToFile(interacString);
                            System.out.println("The record for this item is still being used by another user\n");
                            appendStrToFile("The record for this item is still being used by another user\n");
                            System.out.println("We will try to connect the  server again in a few seconds, please wait...\n");
                            appendStrToFile("We will try to connect the  server again in a few seconds, please wait...\n");
                            wait(1000000000);

                        }while(interacString != "The record for this item is currently being used by another user\n");
                        System.out.println("The previous user's actions a re completed, your action will be performed next.\n");
                        appendStrToFile("The previous user's actions a re completed, your action will be performed next.\n");
                        System.out.println(interacString);
                        appendStrToFile(interacString);
                    }
                    else {
                        System.out.println(interacString);
                    }
                    if(interacString.contains("waitlist?"))
                        {
                            System.out.print("You are in the waitlist section: ");
                            appendStrToFile("You are in the waitlist section: ");
                            sc.nextLine();
                            String resp = sc.nextLine();
                            if(resp.equals("Y"))
                            {
                                System.out.println("Calling the waitlist procedure in the server");
                                appendStrToFile("Calling the waitlist procedure in the server");
                                interacString = objCo.addToWait(resp, itemID, client.getTotalID());
                                System.out.println(interacString);
                                appendStrToFile(interacString);
;
                            }
                            else
                            {
                                if(resp.equals("N"))
                                {
                                    System.out.println("Coming out of the waitlist section");
                                    appendStrToFile("Coming out of the waitlist section");
                                }
                                else
                                {
                                    System.out.println("It was a invalid option, coming out of the waitlist section");
                                    appendStrToFile("It was a invalid option, coming out of the waitlist section");
                                }
                            }

                        }
                    else {
                            System.out.println(interacString);
                    }
                }
                else if((input.equals("2")))
                {
                    System.out.println("Please enter the item name you want to search for in the library: ");
                    appendStrToFile("Please enter the item name you want to search for in the library: ");
                    String itemName = sc.nextLine();
                    interacString = objCo.findItem(client.getTotalID(),itemName);
                    System.out.println(interacString);
                }
                else if(input.equals("3"))
                {
                    System.out.println("Please enter the item ID you want want to return");
                    appendStrToFile("Please enter the item ID you want want to return");
                    String itemID = sc.nextLine();
                    System.out.println("The call is being made to the server...");
                    appendStrToFile("The call is being made to the server...");
                    interacString = objCo.returnItem(client.getTotalID(),itemID);
                    System.out.println(interacString);
                    appendStrToFile(interacString);
                    if(interacString.equalsIgnoreCase("The record for this item is currently being used by another user\n"))
                    {
                        System.out.println("We will try to connect the  server again in a few seconds, please wait...\n");
                        appendStrToFile("We will try to connect the  server again in a few seconds, please wait...\n");

                        do{
                            interacString = objCo.returnItem(client.getTotalID(),itemID);
                            System.out.println(interacString);
                            appendStrToFile(interacString);
                            System.out.println("The record for this item is still being used by another user\n");
                            appendStrToFile("The record for this item is still being used by another user\n");
                            System.out.println("We will try to connect the  server again in a few seconds, please wait...\n");
                            appendStrToFile("We will try to connect the  server again in a few seconds, please wait...\n");
                            wait(1000000000);
                        }while(interacString != "The record for this item is currently being used by another user\n");
                        System.out.println("The previous user's actions are completed, your action will be performed next.\n");
                        appendStrToFile("The previous user's actions are completed, your action will be performed next.\n");
                        System.out.println(interacString);
                        appendStrToFile(interacString);
                    }
                    else
                    {
                            System.out.println(interacString);
                            appendStrToFile(interacString);
                    }

                }
                else if(input.equals("4"))
                {
                    System.out.println("Please enter the item ID you want want to return in the exchange");
                    String returnItemID = sc.nextLine();
                    System.out.println("Please enter the item ID you want want to borrow in the exchange");
                    String borrowItemID = sc.nextLine();
                    System.out.println("Please enter the number of days you want to borrow this item for");
                    String numberofDays = sc.nextLine();
                    System.out.println("The call is being made to the server...");
                    appendStrToFile("The call is being made to the server...");
                    interacString = objCo.exchangeItem(client.getTotalID(), borrowItemID, returnItemID);
                    System.out.println(interacString);
                    appendStrToFile(interacString);
                }

                else if(input.equals("0"))
                {
                    System.out.println("Thank-you for using our services. :)");
                    appendStrToFile("Thank-you for using our services. :)");
                    return;
                }
            }
            System.out.print("Enter \"Yes\" to continue doing more operations and \"No\" to quit.: ");
            appendStrToFile("Enter \"Yes\" to continue doing more operations and \"No\" to quit.: ");
            String check = sc.nextLine();
            System.out.println(check);
            appendStrToFile(check);
            boolean exitParm = false;
            do {
                System.out.println("I am in the loop.");
                appendStrToFile("I am in the loop.");
                if (check.equalsIgnoreCase("Yes")) {
                    System.out.println("I am in the loop.");
                    appendStrToFile("I am in the loop.");
                    exitParm = true;
                    continu = true;
                } else if (check.equalsIgnoreCase("No")) {
                    exitParm = true;
                    continu = false;
                    System.out.println("Thanks for using our services. :)");
                    appendStrToFile("Thanks for using our services. :)");

                } else {
                    System.out.println("Your choice was invalid please enter a valid exit code.\n");
                    appendStrToFile("Your choice was invalid please enter a valid exit code.\n");
                    System.out.println("Enter Yes for continue doing more operations and No to quit.\n");
                    appendStrToFile("Enter Yes for continue doing more operations and No to quit.\n");
                    check = sc.nextLine();
                    System.out.println(check);
                    appendStrToFile(check);
                }
            }while(!exitParm);
        }

    }

    /**Write the optputs to file to create a log
     * @param str
     */
    public static void appendStrToFile(String str)
    {
        try {
            FileWriter fw = new FileWriter("./Client_HandlerLog.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(str);
            System.out.println("Write was successful");
            bw.newLine();
            bw.close();

        }
        catch (IOException e) {
            System.out.println("exception occoured" + e);
        }
    }
}