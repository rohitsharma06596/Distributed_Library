package client;
public class Client_Handler {
    Client_Base client;

    public Client_Handler(String Parm_ID) {
        client = new Client_Base(Parm_ID);
        this.client = new Client_Base(Parm_ID);
        String server = client.prefixCheck();
        String type = client.typeCheck();

    }

    public Client_Base getClient() {
        return this.client;
    }

}
