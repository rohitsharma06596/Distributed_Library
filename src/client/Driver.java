package client;
public class Driver {


    /**User end trigger method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{

        try {
            Client_Handler newHandler = new Client_Handler();
        } catch (Exception e) {
            System.out.println("The application has crashed. I am sorry for the inconvenience.");
        }

    }

}
