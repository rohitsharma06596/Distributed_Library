package server;

import serverInterface.Interface_server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
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
    private DatagramSocket ds;
    private DatagramPacket dp;

    public HashMap<String, ArrayList<String>> getUserUpdateMessages() {
        return this.userUpdateMessages;
    }

    public void setUserUpdateMessages(HashMap<String, ArrayList<String>> userUpdateMessages) {
        this.userUpdateMessages = userUpdateMessages;
    }

    public String getUserMessageStr(String userID) {
        HashMap<String, ArrayList<String>> msgHolder = getUserUpdateMessages();
        ArrayList<String> valueHolder = msgHolder.get(userID);
        int i = 0;
        String returnString = "";
        System.out.println("I am in here");
        while (i < valueHolder.size()) {
            System.out.println("I am stuck in the loop");
            returnString = returnString + valueHolder.get(i) + "\n";
            i++;
        }
        msgHolder.remove(userID);
        System.out.println(returnString);
        return returnString;

    }

    public Server_Base(String name) throws RemoteException {
        this.servername = name;
        this.syncHeap = new HashMap<String, String>();
        this.userUpdateMessages = new HashMap<String, ArrayList<String>>();
    }


    public HashMap getLibBooksRec() {
        return this.libBooksRec;
    }

    public void setLibBooksRec(HashMap libBooksRec) {
        this.libBooksRec = libBooksRec;
    }

    public HashMap getLibLendingRec() {
        return this.libLendingRec;
    }

    public void setLibLendingRec(HashMap libLendingRec) {
        this.libLendingRec = libLendingRec;
    }


    public HashMap getWaitlistRec() {
        return this.waitlistRec;
    }

    public void setWaitlistRec(HashMap waitlistRec) {
        this.waitlistRec = waitlistRec;
    }

    public String getServername() {
        return this.servername;
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
            tempStore.put("MCG1000", new ArrayList<String>(Arrays.asList("Fifty Shades", "MCGU4141", "MCGU4142", "MCGU4143", "MCGU4144", "MCGU4145")));
            tempStore.put("MCG1001", new ArrayList<String>(Arrays.asList("The Dark Knight", "MCGU5151", "MCGU5152", "MCGU5153", "MCGU5154")));
            tempStore.put("MCG7000", new ArrayList<String>(Arrays.asList("Shuttle Island", "MCGU6161", "MCGU6162")));
            tempStore.put("MCG9001", new ArrayList<String>(Arrays.asList("Narnia", "MCGU6161", "MCGU6165")));
            tempStore.put("MCG9003", new ArrayList<String>(Arrays.asList("Obliviate", "MCGU6167", "MCGU6168")));


            HashMap<String, ArrayList<String>> tempHash1 = new HashMap<String, ArrayList<String>>();
            tempHash1.put("MCG1000", new ArrayList<String>(Arrays.asList("Fifty Shades", "1")));
            tempHash1.put("MCG1001", new ArrayList<String>(Arrays.asList("The Dark Knight", "20")));
            tempHash1.put("MCG7000", new ArrayList<String>(Arrays.asList("Shuttle Island", "10")));
            tempHash1.put("MCG8000", new ArrayList<String>(Arrays.asList("Angels and Demons", "5")));
            tempHash1.put("MCG9003", new ArrayList<String>(Arrays.asList("Obliviate", "0")));
            tempHash1.put("MCG9001", new ArrayList<String>(Arrays.asList("Narnia", "0")));
            tempHash1.put("MCG9002", new ArrayList<String>(Arrays.asList("The Light Runner", "10")));


            HashMap<String, ArrayList<String>> tempHash2 = new HashMap<String, ArrayList<String>>();

            tempHash2.put("MCG9001", new ArrayList<String>(Arrays.asList("MCGU5100", "MCGU6100")));
            tempHash2.put("MCG9003", new ArrayList<String>(Arrays.asList("MCGU7100", "MCGU8100")));

            xLib.setLibLendingRec(tempStore);
            xLib.setLibBooksRec(tempHash1);
            xLib.setWaitlistRec(tempHash2);

        } else if (xLib.getServername().equals("MONTREALU")) {
            HashMap<String, ArrayList<String>> tempStore = new HashMap<String, ArrayList<String>>();
            tempStore.put("MON1000", new ArrayList<String>(Arrays.asList("Pedigree", "MONU4241", "MONU4242", "MONU4243", "MONU4244", "MONU4245")));
            tempStore.put("MON1001", new ArrayList<String>(Arrays.asList("Castaway", "MONU5251", "MONU5252", "MONU5253", "MONU5254")));
            tempStore.put("MON7000", new ArrayList<String>(Arrays.asList("Forrest", "MONU6261", "MONU6262")));
            tempStore.put("MON9001", new ArrayList<String>(Arrays.asList("Expecto Patronum", "CONU6261", "MONU6265")));
            tempStore.put("MON9002", new ArrayList<String>(Arrays.asList("Sectumsempra", "MONU6267", "MONU6268")));


            HashMap<String, ArrayList<String>> tempHash1 = new HashMap<String, ArrayList<String>>();
            tempHash1.put("MON1000", new ArrayList<String>(Arrays.asList("Pedigree", "10")));
            tempHash1.put("MON1001", new ArrayList<String>(Arrays.asList("Castaway", "20")));
            tempHash1.put("MON7000", new ArrayList<String>(Arrays.asList("Forrest", "10")));
            tempHash1.put("MON9001", new ArrayList<String>(Arrays.asList("Expecto Patronum", "0")));
            tempHash1.put("MON9002", new ArrayList<String>(Arrays.asList("Sectumsempra", "12")));
            tempHash1.put("MON9100", new ArrayList<String>(Arrays.asList("Narnia", "0")));
            tempHash1.put("MON9102", new ArrayList<String>(Arrays.asList("Sectumsempra", "10")));


            HashMap<String, ArrayList<String>> tempHash2 = new HashMap<String, ArrayList<String>>();

            tempHash2.put("MON9001", new ArrayList<String>(Arrays.asList("MONU5200", "MONU6200")));
            tempHash2.put("MON9100", new ArrayList<String>(Arrays.asList("MONU7200", "MONU8200")));

            xLib.setLibLendingRec(tempStore);
            xLib.setLibBooksRec(tempHash1);
            xLib.setWaitlistRec(tempHash2);

        } else {
            System.out.println("Server is invalid");
            return null;
        }
        return xLib;
    }

    public String addItem(String managerID, String itemID, String itemName, int quantity) {

        String finalString = "";
        if (managerID.substring(3, 4).equals("M")) {

            if (getLibBooksRec().containsKey(itemID)) {
                System.out.println(getLibBooksRec().get(itemID));
                ArrayList<String> value = (ArrayList<String>) getLibBooksRec().get(itemID);
                if (quantity > 0) {
                        this.syncHeap.put(itemID, managerID);
                        if (!(getWaitlistRec().containsKey(itemID))) {
                            getLibBooksRec().remove(itemID);
                            System.out.println(value.get(0) + " " + value.get(1));
                            getLibBooksRec().put(itemID, new ArrayList<String>(Arrays.asList((value.get(0)), Integer.toString(Integer.parseInt(value.get(1)) + quantity))));
                            this.syncHeap.remove(itemID);
                            return ("This item "+itemID+" is already listed in the "+getServername()+ " library and the quantity is increased by "+ Integer.toString(quantity));
                        } else {
                            int least = 0;
                            ArrayList<String> waitHolder = (ArrayList<String>) getWaitlistRec().get(itemID);
                            ArrayList<String> lendHolder = (ArrayList<String>) getLibLendingRec().get(itemID);
                            getLibLendingRec().remove(itemID);
                            getWaitlistRec().remove(itemID);
                            if (quantity < waitHolder.size())
                                least = quantity;
                            else
                                least = waitHolder.size();
                            int iter = 0;
                            do {
                                System.out.println(waitHolder.get(0));
                                this.updateMessageHash("Your waitlist for the item " + itemID + " is clear the item is being issued to ", waitHolder.get(0));
                                System.out.println("Item " + itemID + " is automatically used to clear the waitlist, the item has been issued to " + waitHolder.get(0));
                                finalString = finalString + ("Item " + itemID + " is automatically used to clear the waitlist, the item has been issued to " + waitHolder.get(0) + "\n");
                                lendHolder.add(waitHolder.get(0));
                                waitHolder.remove(waitHolder.get(0));
                                iter = iter + 1;
                                System.out.println(iter);
                                System.out.println(least);
                                System.out.println(waitHolder);
                            } while (iter < least);
                            if (quantity != iter) {
                                getLibBooksRec().remove(itemID);
                                System.out.println(value.get(0) + " " + value.get(1));
                                getLibBooksRec().put(itemID, new ArrayList<String>(Arrays.asList((value.get(0)), Integer.toString(Integer.parseInt(value.get(1)) + (quantity - iter)))));
                                finalString = finalString + ("After clearing the waitlist  for the item the remaining " + Integer.toString(quantity - least) + " copies of the item were added to the library. \n");
                            }
                            getWaitlistRec().put(itemID, waitHolder);
                            getLibLendingRec().put(itemID, lendHolder);
                        }
                        this.syncHeap.remove(itemID);
                    }
            else {
                if (quantity < 0) {
                    this.syncHeap.put(itemID, managerID);
                    ArrayList<String> lendHolder = (ArrayList<String>) getLibLendingRec().get(itemID);
                    ArrayList<String> waitHolder = (ArrayList<String>) getWaitlistRec().get(itemID);
                    getLibLendingRec().remove(itemID);
                    getWaitlistRec().remove(itemID);

                    for (int iter = 0; iter < waitHolder.size(); iter++) {
                        this.updateMessageHash("The manager of the item has removed the item: " + itemID + ". Hence you have been removed from the waiting list", waitHolder.get(iter));
                        System.out.println("The manager of the item has removed the item: " + itemID + ". Hence you have been removed from the waiting list");
                        finalString = finalString + ("The manager of the item has removed the item: " + itemID + ". Hence you have been removed from the waiting list\n");
                        waitHolder.remove(waitHolder.get(iter));
                    }
                    for (int iter2 = 1; iter2 < lendHolder.size(); iter2++) {
                        this.updateMessageHash("The manager of the item has removed the item: " + itemID + ". Hence you have been removed from the borrower's list", lendHolder.get(iter2));
                        System.out.println("The manager of the item has removed the item: " + itemID + ". Hence you have been removed from the borrowers' list");
                        finalString = finalString + ("The manager of the item has removed the item: " + itemID + ". Hence you have been removed from the borrower's list\n");
                        lendHolder.remove(lendHolder.get(iter2));
                    }
                    this.syncHeap.remove(itemID);

                } else {
                    return ("The  value entered is invalid");
                }


            }

        } else if (syncHeap.containsKey(itemID)) {
                System.out.println("The record for this item is currently being used by another user please try after sometime\n");
            return ("The record for this item is currently being used by another user please try after sometime\n");
        } else {
            getLibBooksRec().put(itemID, new ArrayList<String>(Arrays.asList(itemID, Integer.toString(quantity))));
                System.out.println("This item was not listed in the library a new entry has been made for this with the provided quantity\n");
            return ("This item was not listed in the library a new entry has been made for this with the provided quantity\n");
        }
    } else{
        System.out.println("The user is not authorized for this action");
        return ("The user is not authorized for this action");
    }

        return finalString;
}


    public String removeItem(String managerID, String itemID, int quantity, boolean completeRemove) {
        String finalString = "";
        if (managerID.substring(3, 4).equals("M")) {

            if (!getLibBooksRec().containsKey(itemID)) {
                if (syncHeap.containsKey(itemID)) {
                    System.out.println("The record for this item is currently being used by another user please try after sometime\n");
                    return ("The record for this item is currently being used by another user please try after sometime\n");
                } else {
                    System.out.println("The item does not exist in the library.\n");
                    return ("The item has not been listed in the library.\n");
                }
            } else if (completeRemove == true) {
                String msg = "";
                syncHeap.put(itemID, managerID);
                getLibBooksRec().remove(itemID);
                ArrayList<String> tempUsers = getLendingDetail(itemID);
                getLibLendingRec().remove(itemID);
                for (int i = 1; i < tempUsers.size(); i++) {
                    msg = "The item " + itemID + " has been completely removed from the library. All the copies are being recalled, please return back the item.\n";
                    updateMessageHash(msg, tempUsers.get(i));
                    msg = "";
                }
                ArrayList<String> waitHolder = (ArrayList<String>) getWaitlistRec().get(itemID);
                for (int iter = 0; iter < waitHolder.size(); iter++) {
                    this.updateMessageHash("The manager of the item has removed the item: " + itemID + ". Hence you have been removed from the waiting list", waitHolder.get(iter));
                    System.out.println("The manager of the item has removed the item: " + itemID + ". Hence you have been removed from the waiting list");
                    finalString = finalString + ("Notified the user" + waitHolder.get(iter)+"\n");
                    waitHolder.remove(waitHolder.get(iter));
                }
                syncHeap.remove(itemID);
                System.out.println("Notified all the borrowers to return back");
                System.out.println("The item has been completely removed from the library.\n");
                return ("The item has been removed from the library availability list.\nAll the borrowers are notified to return back.\n");
            } else {
                if (quantity < 0) {
                    this.syncHeap.put(itemID, managerID);
                    ArrayList<String> lendHolder = (ArrayList<String>) getLibLendingRec().get(itemID);
                    ArrayList<String> waitHolder = (ArrayList<String>) getWaitlistRec().get(itemID);
                    getLibLendingRec().remove(itemID);
                    getWaitlistRec().remove(itemID);

                    for (int iter = 0; iter < waitHolder.size(); iter++) {
                        this.updateMessageHash("The manager of the item has removed the item: " + itemID + ". Hence you have been removed from the waiting list", waitHolder.get(iter));
                        System.out.println("The manager of the item has removed the item: " + itemID + ". Hence you have been removed from the waiting list");
                        finalString = finalString + ("The manager of the item has removed the item: " + itemID + ". Hence you have been removed from the waiting list\n");
                        waitHolder.remove(waitHolder.get(iter));
                    }
                    for (int iter2 = 1; iter2 < lendHolder.size(); iter2++) {
                        this.updateMessageHash("The manager of the item has removed the item: " + itemID + ". Hence you have been removed from the waiting list", lendHolder.get(iter2));
                        System.out.println("The manager of the item has removed the item: " + itemID + ". Hence you have been removed from the waiting list");
                        finalString = finalString + ("The manager of the item has removed the item: " + itemID + ". Hence you have been removed from the waiting list\n");
                        lendHolder.remove(lendHolder.get(iter2));
                    }
                    this.syncHeap.remove(itemID);

                } else {
                    ArrayList<String> bRecHolder = (ArrayList<String>) getLibBooksRec().get(itemID);
                    if(quantity <= Integer.parseInt(bRecHolder.get(1))) {
                        System.out.println(getLibBooksRec().get(itemID));
                        ArrayList<String> value = (ArrayList<String>) getLibBooksRec().get(itemID);
                        syncHeap.put(itemID, managerID);
                        getLibBooksRec().remove(itemID);
                        System.out.println(value.get(0) + " " + value.get(1));
                        if (Integer.parseInt(value.get(1)) > quantity) {
                            getLibBooksRec().put(itemID, new ArrayList<String>(Arrays.asList((value.get(0)), Integer.toString(Integer.parseInt(value.get(1)) - quantity))));

                            System.out.println("The appropriate amount of item have been removed from the unborrowed section");
                            return "The appropriate amount of item have been removed from the unborrowed section";
                        } else {
                            getLibBooksRec().put(itemID, new ArrayList<String>(Arrays.asList((value.get(0)), "0")));
                            syncHeap.remove(itemID, managerID);
                            System.out.println("The item has been removed from the unborrowed section, nothing is left");
                            return "The item has been removed from the unborrowed section, nothing is left";
                        }
                    }
                    else{
                        return ("The entered value is more than the availablity, cannot remove.");
                    }
                }
            }
        }else {
            System.out.println("The User is not authorized for this action");
            return ("The User is not authorized for this action");
        }
        return finalString;
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

    public String borrowItem(String userID, String itemID, int numberOfDays){
        String finalString = "";
        if (userID.substring(3, 4).equals("U")) {
            if (itemID.substring(0, 3).equals(getServername().substring(0, 3))) {
                if(getLibBooksRec().containsKey(itemID)) {
                    ArrayList<String> bRecHolder = (ArrayList<String>) getLibBooksRec().get(itemID);
                    getLibBooksRec().remove(itemID);
                    System.out.println(getSyncHeap());
                    System.out.println(itemID);
                    System.out.println(userID);
                    this.syncHeap.put(itemID,userID);
                    if (getLibLendingRec().containsKey(itemID)) {
                        System.out.println("I am inside the lending condition");
                        ArrayList<String> lendHolder = (ArrayList<String>) getLendingDetail(itemID);
                        getLibLendingRec().remove(itemID);
                        if (bRecHolder.get(1) != "0") {
                            if (lendHolder.contains(userID)) {
                                getLibLendingRec().put(itemID, lendHolder);
                                getLibBooksRec().put(itemID, bRecHolder);
                                getSyncHeap().remove(itemID);
                                return "You already have a copy of this item";
                            } else {
                                lendHolder.add(userID);
                                getLibLendingRec().put(itemID, lendHolder);
                                System.out.println("Lending history has been updated");
                                finalString = finalString + "Lending history has been updated you have successfully borrowed. \n";
                                bRecHolder.set(1, Integer.toString(Integer.parseInt(bRecHolder.get(1)) - 1));
                                getLibBooksRec().put(itemID, bRecHolder);
                                System.out.println("The book record has been updated");
                                finalString = finalString + "The book record has been updated. \n";
                                getSyncHeap().remove(itemID, userID);
                            }
                        } else {
                            if (bRecHolder.get(1) == "0") {
                                getLibLendingRec().put(itemID, lendHolder);
                                getLibBooksRec().put(itemID, bRecHolder);
                                getSyncHeap().remove(itemID, userID);
                                finalString = finalString + ("The item is currently not available\n");
                                finalString = finalString + ("Would you like to be added to the waitlist? Enter Y for Yes and N for No.\n");
                                finalString = finalString + ("Enter Y for Yes and N for No");
                                return finalString;
                            } else {
                                getLibLendingRec().put(itemID, lendHolder);
                                getLibBooksRec().put(itemID, bRecHolder);
                                getSyncHeap().remove(itemID, userID);
                                return ("Internal data error!");
                            }
                        }
                    }
                    else
                    {
                        if (bRecHolder.get(1) != "0") {
                            ArrayList<String> lendHolder = new ArrayList<String>();
                            System.out.println(bRecHolder);
                            lendHolder.add(bRecHolder.get(0));
                            lendHolder.add(userID);
                            getLibLendingRec().put(itemID, lendHolder);
                            System.out.println("Lending history has been updated");
                            finalString = finalString + "Lending history has been updated. \n";
                            bRecHolder.set(1, Integer.toString(Integer.parseInt(bRecHolder.get(1)) - 1));
                            getLibBooksRec().put(itemID, bRecHolder);
                            System.out.println("The book record has been updated");
                            finalString = finalString + "The book record is updated. The item has been successfully borrowed by you.\n";
                            getSyncHeap().remove(itemID, userID);
                        }
                        else
                        {
                            getLibBooksRec().put(itemID, bRecHolder);
                            getSyncHeap().remove(itemID, userID);
                            if (bRecHolder.get(1) == "0") {
                                finalString = finalString + ("The item is currently not available\n");
                                finalString = finalString + ("Would you like to be added to the waitlist?");
                                finalString = finalString + ("Enter Y for Yes and N for No");
                                return finalString;
                            } else {
                                return ("Internal data error!");
                            }

                        }
                }
            }
                else{
                    if (getSyncHeap().containsKey(itemID)) {
                        return "The record for this item is currently being used by another user\n";
                    }
                    else {
                        System.out.println("The item does not exist in the library " + getServername());
                        finalString = finalString + "The item does not exist in the library " + getServername() + "\n";
                    }
            }

        } else {
            System.out.println("UDP for calling the correct server on the client's behalf");
            finalString = finalString + "This item does not exist in " + getServername() + ".\n";
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
        if (userID.substring(3, 4).equals("U")) {
            if (itemID.substring(0, 3).equals(getServername().substring(0, 3))) {
                if (getLibBooksRec().containsKey(itemID)) {
                    ArrayList<String> bRecHolder = (ArrayList<String>) getLibBooksRec().get(itemID);
                    getLibBooksRec().remove(itemID);
                    getSyncHeap().put(itemID, userID);
                    System.out.println(getLibLendingRec().get(itemID));
                    if (getLibLendingRec().containsKey(itemID)) {
                        ArrayList<String> lendHolder = (ArrayList<String>) getLibLendingRec().get(itemID);
                        getLibLendingRec().remove(itemID);
                        if (!(lendHolder.contains(userID))) {
                            getLibLendingRec().put(itemID, lendHolder);
                            getLibBooksRec().put(itemID, bRecHolder);
                            getSyncHeap().remove(itemID);
                            System.out.println("I am inside the lendholder check");
                            finalString = finalString + "Officially, you don't have a copy of this item. So you cannot return. Please contact your manager";
                        } else {
                            System.out.println("I am after the lendholder check");
                            if (getWaitlistRec().containsKey(itemID)) {
                                ArrayList<String> waitHolder = (ArrayList<String>) getWaitlistRec().get(itemID);
                                getWaitlistRec().remove(itemID);
                                lendHolder.remove(userID);
                                lendHolder.add(waitHolder.get(0));
                                updateMessageHash("Your waitlist for the item " + itemID + " is clear + the item has been issued to you", waitHolder.get(0));
                                System.out.println("The book has been issued to the first waitlisted person.");
                                waitHolder.remove(waitHolder.get(0));
                                finalString = finalString + "The book has been successfully returned\n";
                                getLibLendingRec().put(itemID, lendHolder);
                                getLibBooksRec().put(itemID, bRecHolder);
                                getWaitlistRec().put(itemID, waitHolder);
                                getSyncHeap().remove(itemID);
                            } else {
                                bRecHolder.set(1, Integer.toString(Integer.parseInt(bRecHolder.get(1)) + 1));
                                lendHolder.remove(userID);
                                getLibBooksRec().put(itemID, bRecHolder);
                                getLibLendingRec().put(itemID, lendHolder);
                                getSyncHeap().remove(itemID);
                                finalString = finalString + "The item has been added to the library.\n";
                            }
                        }

                    } else {
                        getLibBooksRec().put(itemID, bRecHolder);
                        getSyncHeap().remove(itemID);
                        System.out.println("I am outside the lend holder check");
                        finalString = finalString + "Officially, you don't have a copy of this item. So you cannot return. Please contact your manager";
                    }
                } else {
                    if (getSyncHeap().containsKey(itemID)) {
                            return "The record for this item is currently being used by another user\n";
                    } else {
                        return "This book ID does not exist in the library " + getServername();
                    }
                }
            } else {
                System.out.println("Make a appropriate UDP call for the inter server item list update");
            }
        }
        else {
                finalString = finalString + "The User is not authorized for this action\n";
        }
        System.out.println("I am in the end");
        System.out.println(finalString);
        return finalString;

    }

    public String verify(String ID) {
        String finalString = "";
        System.out.println("*************************************************************************");
        System.out.println("Verifying the connection at "+getServername()+" Library.");
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
                System.out.println("I am inside here");
                finalString = finalString + " You have new messages from the server.\n" + this.getUserMessageStr((ID)) + "\n";
                System.out.println("I am after the call to the message method");
            } else {
                finalString = finalString + "The ID has vaild user type.\n";
                finalString = finalString + "No new Messages for you. \n";
            }
        } catch (NullPointerException e) {
            finalString = finalString + "No new Messages for you. \n";
            System.out.println("No new messages for you");
        }
        if (ID.substring(3, 4).equals("M")) {
            System.out.println("I am inside here in the options panel");
            finalString = finalString + "Your options are: \n1. Press 1 for adding an item to the library.\n";
            finalString = finalString + "2. Press 2 for removing an item from the library.\n";
            finalString = finalString + "3. Press 3 for checking the available list of items.\n";
            finalString = finalString + "0. Press 0 for exit.\n";

        }
        if (ID.substring(3, 4).equals("U")) {
            finalString = finalString + "Your options are: \n1. Press 1 for borrowing an item.\n";
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
        return this.syncHeap;
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

    public String addToWait(String parm, String itemID, String userID)
    {
        if(parm.equals("Y"))
        {
            if(getWaitlistRec().containsKey(itemID))
            {
                ArrayList<String> waitHolder = (ArrayList<String>) getWaitlistRec().get(itemID);
                if(waitHolder.contains(userID))
                {
                    return ("You are already in the waitlist for this item");
                }
                else
                {
                    getWaitlistRec().remove(itemID);
                    waitHolder.add(userID);
                    getWaitlistRec().put(itemID,waitHolder);
                    return ("You have been sucessfully waitlisted for the item "+ itemID);
                }
            }
            else
            {
                ArrayList<String> waitHolder = new ArrayList<String> ();
                ArrayList<String> bRecHolder = (ArrayList<String>) getLibBooksRec().get(itemID);
                waitHolder.add(userID);
                getWaitlistRec().put(bRecHolder.get(0),waitHolder);
                return ("You have been sucessfully waitlisted for the item "+ itemID);

            }
        }
        else{
            return ("Invalid response");
        }
    }

    public void interServerInteractor() throws SocketException {
        this.ds = new DatagramSocket();


    }


}
