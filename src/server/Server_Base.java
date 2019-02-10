package server;

import serverInterface.Interface_server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Server_Base extends UnicastRemoteObject implements Interface_server {

    private String servername;
    private HashMap<String, ArrayList<String>> userUpdateMessages;
    private HashMap<String, HashMap> libLendingRec;
    private HashMap waitlistRec;
    private HashMap libBooksRec;
    private HashMap<String, String> syncHeap;

    public HashMap<String, ArrayList<String>> getUserUpdateMessages() {
        return userUpdateMessages;
    }

    public void setUserUpdateMessages(HashMap<String, ArrayList<String>> userUpdateMessages) {
        this.userUpdateMessages = userUpdateMessages;
    }

    public String getUserMessageStr(String userID){
        HashMap<String, ArrayList<String>> msgHolder = new HashMap<String, ArrayList<String>>();
        ArrayList<String> valueHolder = msgHolder.get(userID);
        int i =0;
        String returnString = "";
        while(i< valueHolder.size())
        {
            returnString = returnString + valueHolder.get(i) + "\n";
        }
        return returnString;

    }

    public Server_Base(String name) throws RemoteException {
        this.servername = name;
    }


    public HashMap getLibBooksRec() {
        return libBooksRec;
    }

    public void setLibBooksRec(HashMap libBooksRec) {
        this.libBooksRec = libBooksRec;
    }

    public HashMap getLibLendingRec() {
        return libLendingRec;
    }

    public void setLibLendingRec(HashMap libLendingRec) {
        this.libLendingRec = libLendingRec;
    }


    public HashMap getWaitlistRec() {
        return waitlistRec;
    }

    public void setWaitlistRec(HashMap waitlistRec) {
        this.waitlistRec = waitlistRec;
    }

    public String getServername() {
        return servername;
    }

    public void setServername(String servername) {
        this.servername = servername;
    }

    public Server_Base loadServerRec(Server_Base xLib) {
        if (xLib.getServername().equals("CONCORDIA")) {

            HashMap<String, ArrayList<String>> tempStore = new HashMap<String, ArrayList<String>>();
            tempStore.put("CON1000", new ArrayList<String>(Arrays.asList("Star Wars", "CONU4041", "CONU4042", "CONU4043", "CONU4044", "CONU4045")));
            tempStore.put("CON1001", new ArrayList<String>(Arrays.asList("Tombstone", "CONU5051", "CONU5052", "CONU5053", "CONU5054")));
            tempStore.put("CON7000", new ArrayList<String>(Arrays.asList("The Doomsday", "CONU6061", "CONU6062")));
            tempStore.put("CON9001", new ArrayList<String>(Arrays.asList("Avada Kedavra", "CONU6061", "CONU6065")));
            tempStore.put("CON9002", new ArrayList<String>(Arrays.asList("Sectumsempra", "CONU6067", "CONU6068")));


            HashMap<String, ArrayList<String>> tempHash1 = new HashMap<String, ArrayList<String>>();
            tempHash1.put("CON5000", new ArrayList<String>(Arrays.asList("Twilight", "10")));
            tempHash1.put("CON6000", new ArrayList<String>(Arrays.asList("Alchemist", "20")));
            tempHash1.put("CON7000", new ArrayList<String>(Arrays.asList("The Doomsday", "10")));
            tempHash1.put("CON8000", new ArrayList<String>(Arrays.asList("Angels and Demons", "5")));
            tempHash1.put("CON9000", new ArrayList<String>(Arrays.asList("Da Vinci Code", "2")));
            tempHash1.put("CON9001", new ArrayList<String>(Arrays.asList("Avada Kedavra", "0")));
            tempHash1.put("CON9002", new ArrayList<String>(Arrays.asList("Sectumsempra", "0")));


            HashMap<String, ArrayList<String>> tempHash2 = new HashMap<String, ArrayList<String>>();

            tempHash2.put("CON9001", new ArrayList<String>(Arrays.asList("CONU5000", "CONU6000")));
            tempHash2.put("CON9002", new ArrayList<String>(Arrays.asList("CONU7000", "CONU8000")));

            xLib.setLibLendingRec(tempStore);
            xLib.setLibBooksRec(tempHash1);
            xLib.setWaitlistRec(tempHash2);

        } else if (xLib.getServername().equals("MCGILL")) {
            HashMap<String, ArrayList<String>> tempStore = new HashMap<String, ArrayList<String>>();
            tempStore.put("MCG1000", new ArrayList<String>(Arrays.asList("Fifty Shades", "MCGU4041", "MCGU4042", "MCGU4043", "MCGU4044", "CONU4045")));
            tempStore.put("MCG1001", new ArrayList<String>(Arrays.asList("The Dark Knight", "MCGU5051", "MCGU5052", "MCGU5053", "MCGU5054")));
            tempStore.put("MCG7000", new ArrayList<String>(Arrays.asList("Shuttle Island", "MCGU6061", "MCGU6062")));
            tempStore.put("MCG9001", new ArrayList<String>(Arrays.asList("Narnia", "MCGU6061", "MCGU6065")));
            tempStore.put("MCG9002", new ArrayList<String>(Arrays.asList("Sectumsempra", "MCGU6067", "MCGU6068")));


            HashMap<String, ArrayList<String>> tempHash1 = new HashMap<String, ArrayList<String>>();
            tempHash1.put("CON5000", new ArrayList<String>(Arrays.asList("Twilight", "10")));
            tempHash1.put("CON6000", new ArrayList<String>(Arrays.asList("Alchemist", "20")));
            tempHash1.put("CON7000", new ArrayList<String>(Arrays.asList("Shuttle Island", "10")));
            tempHash1.put("CON8000", new ArrayList<String>(Arrays.asList("Angels and Demons", "5")));
            tempHash1.put("CON9000", new ArrayList<String>(Arrays.asList("Da Vinci Code", "2")));
            tempHash1.put("CON9001", new ArrayList<String>(Arrays.asList("Narnia", "0")));
            tempHash1.put("CON9002", new ArrayList<String>(Arrays.asList("Sectumsempra", "10")));


            HashMap<String, ArrayList<String>> tempHash2 = new HashMap<String, ArrayList<String>>();

            tempHash2.put("CON9001", new ArrayList<String>(Arrays.asList("CONU5000", "CONU6000")));
            tempHash2.put("CON9002", new ArrayList<String>(Arrays.asList("CONU7000", "CONU8000")));

            xLib.setLibLendingRec(tempStore);
            xLib.setLibBooksRec(tempHash1);
            xLib.setWaitlistRec(tempHash2);

        } else if (xLib.getServername().equals("MONTREALU")) {
            HashMap<String, ArrayList<String>> tempStore = new HashMap<String, ArrayList<String>>();
            tempStore.put("CON1000", new ArrayList<String>(Arrays.asList("Star Wars", "CONU4041", "CONU4042", "CONU4043", "CONU4044", "CONU4045")));
            tempStore.put("CON1001", new ArrayList<String>(Arrays.asList("Tombstone", "CONU5051", "CONU5052", "CONU5053", "CONU5054")));
            tempStore.put("CON7000", new ArrayList<String>(Arrays.asList("The Doomsday", "CONU6061", "CONU6062")));
            tempStore.put("CON9001", new ArrayList<String>(Arrays.asList("Avada Kedavra", "CONU6061", "CONU6065")));
            tempStore.put("CON9002", new ArrayList<String>(Arrays.asList("Sectumsempra", "CONU6067", "CONU6068")));


            HashMap<String, ArrayList<String>> tempHash1 = new HashMap<String, ArrayList<String>>();
            tempHash1.put("CON5000", new ArrayList<String>(Arrays.asList("Twilight", "10")));
            tempHash1.put("CON6000", new ArrayList<String>(Arrays.asList("Alchemist", "20")));
            tempHash1.put("CON7000", new ArrayList<String>(Arrays.asList("The Doomsday", "10")));
            tempHash1.put("CON8000", new ArrayList<String>(Arrays.asList("Angels and Demons", "5")));
            tempHash1.put("CON9000", new ArrayList<String>(Arrays.asList("Da Vinci Code", "2")));
            tempHash1.put("CON9001", new ArrayList<String>(Arrays.asList("Avada Kedavra", "0")));
            tempHash1.put("CON9002", new ArrayList<String>(Arrays.asList("Sectumsempra", "0")));


            HashMap<String, ArrayList<String>> tempHash2 = new HashMap<String, ArrayList<String>>();

            tempHash2.put("CON9001", new ArrayList<String>(Arrays.asList("CONU5000", "CONU6000")));
            tempHash2.put("CON9002", new ArrayList<String>(Arrays.asList("CONU7000", "CONU8000")));

            xLib.setLibLendingRec(tempStore);
            xLib.setLibBooksRec(tempHash1);
            xLib.setWaitlistRec(tempHash2);

        } else {
            System.out.println("Server is invalid");
        }
        return xLib;
    }

    public String addItem(String managerID, String itemID, String itemName, int quantity) {


        if (managerID.substring(3, 4).equals("M")) {

            if (getLibBooksRec().containsKey(itemID)) {
                System.out.println(getLibBooksRec().get(itemID));
                ArrayList<String> value = (ArrayList<String>) getLibBooksRec().get(itemID);
                getLibBooksRec().remove(itemID);
                System.out.println(value.get(0) + " " + value.get(1));
                getLibBooksRec().put(itemID, new ArrayList<String>(Arrays.asList((value.get(0)), Integer.toString(Integer.parseInt(value.get(1)) + quantity))));
                return ("This item is already listed in the library the quantity has been updated");


            } else {
                getLibBooksRec().put(itemID, new ArrayList<String>(Arrays.asList(itemID, Integer.toString(quantity))));
                return ("This item was not listed in the library a new entry has been made for this with the provided quantity");
            }
        } else {
            System.out.println("The User is not authorized for this action");
            return ("The User is not authorized for this action");
        }

    }

    public String removeItem(String managerID, String itemID, int quantity, boolean completeRemove) {
        if (managerID.substring(3, 4).equals("M")) {

            if (getLibBooksRec().get(itemID) == null) {
                System.out.println("The item does not exist in the library");
                return ("The item has not been listed in the library");
            } else if (completeRemove == true) {
                String msg = "";
                getLibBooksRec().remove(itemID);
                System.out.println("Remove from the library borrow records");
                getLibLendingRec().remove(itemID);
                ArrayList<String> tempUsers = getLendingDetail(itemID);
                for (int i = 0; i < tempUsers.size(); i++){
                    msg = "The item "+ itemID +" has been completely removed from the library. All the copies are being recalled + please retunn back.\n";
                    updateMessageHash(msg, tempUsers.get(i));
                    msg = "";

                }
                    System.out.println("Notify all the borrowers to return back");
                System.out.println("The item has been completely removed from the library.");
                return ("The item has been removed from the library availability list.\nAll the borrowers are notified to return back.\n");
            } else {
                System.out.println(getLibBooksRec().get(itemID));
                ArrayList<String> value = (ArrayList<String>) getLibBooksRec().get(itemID);
                getLibBooksRec().remove(itemID);
                System.out.println(value.get(0) + " " + value.get(1));
                if (Integer.parseInt(value.get(1)) > quantity) {
                    getLibBooksRec().put(itemID, new ArrayList<String>(Arrays.asList((value.get(0)), Integer.toString(Integer.parseInt(value.get(1)) - quantity))));

                    System.out.println("The appropriate amount of item have been removed from the unborrowed section");
                    return "The appropriate amount of item have been removed from the unborrowed section";
                } else {
                    getLibBooksRec().remove(itemID);
                    System.out.println("The item has been removed from the unborrowed section, nothing is left");
                    return "The item has been removed from the unborrowed section, nothing is left";
                }
            }
        } else {
            System.out.println("The User is not authorized for this action");
            return ("The User is not authorized for this action");
        }

    }

    public String listItemAvailability(String managerID) {
        String prepString = "";
        if (managerID.substring(3, 4).equals("M")) {
            Set<Map.Entry<String, ArrayList<String>>> tempSet = getLibBooksRec().entrySet();
            for (Map.Entry<String, ArrayList<String>> entry : tempSet) {

                //System.out.print(entry.getKey());
                ArrayList<String> temp_holder = (ArrayList<String>) entry.getValue();
                //System.out.println(": Name: "+temp_holder[0]+", "+"Availability: "+temp_holder[1]+"\n");
                prepString = prepString + entry.getKey() + ": Name: " + temp_holder.get(0) + ", " + "Availability: " + temp_holder.get(1) + "\n";
            }
            System.out.println(prepString);
            return prepString;
        } else {
            System.out.println("The User is not authorized for this action");
            return ("The User is not authorized for this action");
        }

    }

    public String borrowItem(String userID, String itemID, int numberOfDays) {
        String finalString = "";
        if (userID.substring(3, 4).equals("U")) {
            if (itemID.substring(0, 3).equals(getServername().substring(0, 3))) {
                ArrayList<String> lendHolder = (ArrayList<String>) getLendingDetail(itemID);
                ArrayList<String> bRecHolder = (ArrayList<String>) getLibBooksRec().get(itemID);
                if ((bRecHolder.get(0) != "null") && (bRecHolder.get(1) != "0")) {

                    if (lendHolder.get(0) != "null") {
                        if (lendHolder.contains(userID)) {
                            return "You aleady have a copy of this item";
                        } else {
                            getLibLendingRec().remove(itemID);
                            lendHolder.add(userID);
                            getLibLendingRec().put(itemID, lendHolder);
                            System.out.println("Lending history has been updated");
                            finalString = finalString + "Lending history has been updated. \n";
                            getLibBooksRec().remove(itemID);
                            bRecHolder.set(1, Integer.toString(Integer.parseInt(bRecHolder.get(1)) - 1));
                            getLibBooksRec().put(itemID, bRecHolder);
                            System.out.println("The book record has been updated");
                            finalString = finalString + "The book record has been updated. \n";
                        }
                    } else {
                        System.out.println(lendHolder);
                        System.out.println(bRecHolder);
                        lendHolder.set(0, bRecHolder.get(0));
                        lendHolder.add(userID);
                        getLibLendingRec().put(itemID, lendHolder);
                        System.out.println("Lending history has been updated");
                        finalString = finalString + "Lending history has been updated. \n";
                        getLibBooksRec().remove(itemID);
                        bRecHolder.set(1, Integer.toString(Integer.parseInt(bRecHolder.get(1)) - 1));
                        getLibBooksRec().put(itemID, bRecHolder);
                        System.out.println("The book record has been updated");
                        finalString = finalString + "The book record has been updated. \n";
                    }
                } else if (bRecHolder.get(0) == "null") {
                    System.out.println("The item does not exist in the library " + getServername());
                    finalString = finalString + "The item does not exist in the library " + getServername() + "\n";
                } else if (bRecHolder.get(1) == "0") {
                    System.out.println(" call the client to check if he wants to be added to waitlist");
                    finalString = finalString + "Would you like to add yourself to the waitlist?" + "\n";
                    if (getWaitdetail(itemID).get(0) == "null") {
                        System.out.println("This item is just listed on " + getServername() + "has never been borrowed");
                        finalString = finalString + "This item is just listed on " + getServername() + "has never been borrowed. \n";
                        finalString = finalString + "You cannot be added to the waitlist.\n";
                    } else {
                        getWaitlistRec().put(itemID, userID);
                        finalString = finalString + "A new waiting list has been created for the item for you";
                        finalString = finalString + "The item is currently unavailable" + "\n";
                    }
                }

            } else {
                System.out.println("UDP for calling the correct server on the client's behalf");
                finalString = finalString + "This item does not exist at " + getServername() + ".\n";
            }
        } else {
            System.out.println("The User is not authorized for this action");
            return ("The User is not authorized for this action");
        }

        return finalString;

    }

    public String findItem(String userID, String itemName) {
        String finalString = "Items matching your entry at " + getServername() + " are:\n";
        if (userID.substring(3, 4).equals("U")) {
            Set<Map.Entry<String, ArrayList<String>>> tempSet = getLibBooksRec().entrySet();
            for (Map.Entry<String, ArrayList<String>> entry : tempSet) {
                ArrayList<String> valueHolder = entry.getValue();
                if (valueHolder.get(0).matches(".*" + itemName + "*.") && (valueHolder.get(1) != "0")) {
                    finalString = finalString + "Code: " + entry.getKey() + ", Name: " + valueHolder.get(0) + ", Availability: " + valueHolder.get(1) + "\n";
                }
            }
            System.out.println("Send a UDP call to other servers for this and list down their items");
        } else {
            System.out.println("The User is not authorized for this action");
            return ("The User is not authorized for this action");

        }
        return finalString;

    }

    public String returnItem(String userID, String itemID) {
        String finalString = "";
        ArrayList<String> parmHolder = getBookDetail(itemID);
        ArrayList<String> lendHolder = getLendingDetail(itemID);
        ArrayList<String> waitHolder = getWaitdetail(itemID);
        if ((userID.substring(3, 4).equals("U")) && itemID.substring(0, 3).equals(getServername().substring(0, 3))) {
            if (getLibBooksRec().containsKey(itemID)) {

                if ((parmHolder.get(1) != "0") && (lendHolder.contains(userID))) {
                    getLibBooksRec().remove(itemID);
                    parmHolder.set(1, Integer.toString(Integer.parseInt(parmHolder.get(1)) + 1));
                    getLibLendingRec().remove(itemID);
                    lendHolder.remove(userID);
                    getLibLendingRec().put(itemID, lendHolder);
                    finalString = finalString + "The item has been added to the library bank.\n";
                } else if (!(lendHolder.contains(userID))) {
                    return "You dont owe this item to the library" + getServername();
                } else if (parmHolder.get(1) == "0") {
                    if (waitHolder.get(0) == "null") {
                        getLibBooksRec().remove(itemID);
                        parmHolder.set(1, Integer.toString(Integer.parseInt(parmHolder.get(1)) + 1));
                        getLibLendingRec().remove(itemID);
                        lendHolder.remove(userID);
                        getLibLendingRec().put(itemID, lendHolder);
                        finalString = finalString + "The item has been added to the library bank.\n";
                    } else {
                        finalString = finalString + borrowItem(waitHolder.get(0), itemID, 3);
                        finalString = finalString + "The book has been issued to the first waitlisted person";
                    }

                }
            }
        } else {
            if (!(userID.substring(3, 4).equals("U"))) {
                finalString = finalString + "The User is not authorized for this action\n";
            } else if ((lendHolder.contains(userID))) {
                System.out.println("Set UDP call for returning to other libraries");
            }
        }

        return finalString;

    }

    public String verify(String ID) {
        String finalString = "";
        if (getServername().substring(0, 3).equals(ID.substring(0, 3))) {
            System.out.println("The ID is connected to right server");
            finalString = finalString + "The ID is connected to right server.\n";
        } else {
            System.out.println("The ID is not present on this server");
            finalString = finalString + "The ID has vaild user type.\n";
            return ("The ID is incorrect on this server");
        }
        if (ID.substring(3, 4).equals("M") || ID.substring(3, 4).equals("U")) {
            System.out.println("The ID has correct user type");
            finalString = finalString + "The ID has vaild user type.\n";
        } else {
            System.out.println("The user type is incorrect");
            return ("The user type is incorrect");
        }
        try {
            if (userUpdateMessages.containsKey(ID)) {
                finalString = finalString + " You have one message from the server.\n" + getUserMessageStr((ID)) + "\n";
            } else {
                finalString = finalString + "The ID has vaild user type.\n";
            }
        } catch (NullPointerException e) {
            finalString = finalString + "No new Messages for you. \n";
            System.out.println("No new messages for you");
        }
        if (ID.substring(3, 4).equals("M")) {
            finalString = finalString + "Your options are: \n1. Press 1 for adding an item to the library.\n";
            finalString = finalString + "2. Press 2 for removing an item from the library.\n";
            finalString = finalString + "3. Press 3 for checking the available list of items.\n";
            finalString = finalString + "0. Press 0 for exit.\n";

        }
        if (ID.substring(3, 4).equals("U")) {
            finalString = finalString + "Your options are: \n+ 1. Press 1 for borrowing an item.\n";
            finalString = finalString + "2. Press 2 for finding an item.\n";
            finalString = finalString + "3. Press 3 for returning an item\n";
            finalString = finalString + "0. Press 0 for exit.\n";
            finalString = finalString + "Note: Only select the borrow and remove options if you know the correct item ID.\n";
            finalString = finalString + "Else you can lookup using our find item feature.\n";
        }


        return finalString;
    }

    public boolean load_server(String server_name) {
        return false;
    }

    public ArrayList<String> getBookDetail(String ID) {
        try {
            if (getLibBooksRec().containsKey(ID)) {
                return (ArrayList<String>) getLibBooksRec().get(ID);
            } else {
                System.out.println("The ID is incorrect, it does not exist in the library " + getServername());
                return null;
            }

        } catch (NullPointerException E) {
            return null;
        }
    }

    public ArrayList<String> getLendingDetail(String ID) {
        try {
            if (getLibLendingRec().containsKey(ID)) {
                return (ArrayList<String>) getLibLendingRec().get(ID);
            } else {
                System.out.println("The action is incorrect, item has never been borrowed yet at " + getServername());
                ArrayList<String> returnParm = new ArrayList<String>();
                returnParm.add("null");
                return returnParm;
            }

        } catch (NullPointerException E) {
            System.out.println("The action is incorrect, item has never been borrowed yet at " + getServername());
            ArrayList<String> returnParm = new ArrayList<String>();
            returnParm.add("null");
            return returnParm;
        }

    }

    public HashMap<String, String> getSyncHeap() {
        return syncHeap;
    }

    public void setSyncHeap(HashMap<String, String> syncHeap) {
        this.syncHeap = syncHeap;
    }

    public ArrayList<String> getWaitdetail(String ID) {
        try {
            if (getWaitlistRec().containsKey(ID)) {
                return (ArrayList<String>) getWaitlistRec().get(ID);
            } else {
                System.out.println("The action is incorrect, item does not have a waitlist at " + getServername());
                ArrayList<String> returnParm = new ArrayList<String>();
                returnParm.add("null");
                return returnParm;
            }

        } catch (NullPointerException E) {
            System.out.println("The action is incorrect, item does not have a waitlist at " + getServername());
            ArrayList<String> returnParm = new ArrayList<String>();
            returnParm.add("null");
            return returnParm;
        }

    }

    public void updateMessageHash(String msg, String userID) {
        HashMap<String, ArrayList<String>> localMsgCopy = (HashMap<String, ArrayList<String>>) getUserUpdateMessages();
        ArrayList<String> tempStore = new ArrayList<String>();

        if (getUserUpdateMessages().containsKey(userID)) {
            tempStore = localMsgCopy.get(userID);
            getUserUpdateMessages().remove(userID);
            tempStore.add(msg);
            getUserUpdateMessages().put(userID, tempStore);
            System.out.println("Message has been added to the profile of " + userID + "\n");
        } else {
            tempStore.add(msg);
            getUserUpdateMessages().put(userID, tempStore);
            System.out.println("Message has been added to the profile of " + userID + "\n");
        }
    }


}
