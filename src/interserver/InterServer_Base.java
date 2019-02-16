package interserver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.*;

public class InterServer_Base extends Thread {

    private static DatagramSocket socket;
    private boolean running;
    private byte[] buf = new byte[256];
    private DatagramPacket dps;

    public InterServer_Base() throws SocketException {
        socket = new DatagramSocket(9999);
    }

    public static void main(String[] args) throws SocketException {
        InterServer_Base temp = new InterServer_Base();
        temp.running = true;

        while (temp.running) {
            DatagramPacket packet = null;
            packet
                    = new DatagramPacket(temp.buf, temp.buf.length);

            String received = null;
            DatagramSocket tempSock = new DatagramSocket();

            try {
                socket.close();
                socket = new DatagramSocket(9999);
                System.out.println("I am waiting to receive a packet");
                socket.receive(packet);


            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("I received the packet from: "+packet.getPort());
            InetAddress address = null;
            try {
                address = InetAddress.getLocalHost();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            int port = packet.getPort();
            packet = new DatagramPacket(temp.buf, temp.buf.length, address, port);
            System.out.println(address);
            System.out.println(port);
            received
                    = new String(packet.getData(), 0, packet.getLength());
            received = received.trim();
            if (received.startsWith("F")) {
                String temp1 = received.substring(2, received.indexOf('@'));
                //int rece1 = Integer.parseInt(temp1);
                //rece1 = rece1 * rece1;
                String rece = received.substring(0, 2) + temp1 + received.substring(received.indexOf("@"));
                byte[] b = (rece + "").getBytes();
                InetAddress ia = null;
                try {
                    ia = InetAddress.getLocalHost();
                    //  temp.dps = new DatagramPacket(b, b.length, ia, 9999);
                    System.out.println(received);
                    packet = new DatagramPacket(b, b.length, address, Integer.parseInt(received.substring(received.indexOf('|') + 1, received.indexOf('|') + 5)));
                    System.out.println("I am sending the packet");
                    tempSock.send(packet);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(received.startsWith("B"))
            {
                String temp1 = received.substring(2, received.indexOf('@'));
                //int rece1 = Integer.parseInt(temp1);
                //rece1 = rece1 * rece1;
                String rece = received.substring(0, 2) + temp1 + received.substring(received.indexOf("@"));
                byte[] b = (rece + "").getBytes();
                InetAddress ia = null;
                try {
                    ia = InetAddress.getLocalHost();
                    //  temp.dps = new DatagramPacket(b, b.length, ia, 9999);
                    packet = new DatagramPacket(b, b.length, address, Integer.parseInt(received.substring(received.indexOf('@')+1, received.indexOf('@')+5)));
                    System.out.println("I am sending the packet");
                    tempSock.send(packet);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            else if(received.startsWith("X")||received.startsWith("Y")||received.startsWith("Z")){
                System.out.println("I am inside the right condition");
                String temp1 = received.substring(2, received.indexOf('@'));
                //int rece1 = Integer.parseInt(temp1);
                //rece1 = rece1 * rece1;
                String rece = received.substring(0, 2) + temp1 + received.substring(received.indexOf("@"));
                byte[] b = (rece + "").getBytes();
                InetAddress ia = null;
                try {
                    ia = InetAddress.getLocalHost();
                    //  temp.dps = new DatagramPacket(b, b.length, ia, 9999);
                    System.out.println(received);
                    received = received.substring(0,received.indexOf("|")+5);
                    System.out.println(received);
                    System.out.println("Sending this packet to" + Integer.parseInt(received.substring(received.indexOf('|') + 1, received.indexOf('|') + 5)));
                    DatagramPacket packet2 = new DatagramPacket(b, b.length, address, Integer.parseInt(received.substring(received.indexOf('|') + 1, received.indexOf('|') + 5)));
                    System.out.println("I am sending the packet");
                    socket.send(packet2);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if(received.startsWith("P")||received.startsWith("Q")||received.startsWith("R"))
            {
                String temp1 = received.substring(2, received.indexOf('@'));
                //int rece1 = Integer.parseInt(temp1);
                //rece1 = rece1 * rece1;
                String rece = received.substring(0, 2) + temp1 + received.substring(received.indexOf("@"));
                System.out.println(rece);
                byte[] b = (rece + "").getBytes();
                InetAddress ia = null;
                try {
                    ia = InetAddress.getLocalHost();
                    //  temp.dps = new DatagramPacket(b, b.length, ia, 9999);
                    DatagramPacket packet3 = new DatagramPacket(b, b.length, address, Integer.parseInt(received.substring(received.indexOf('@')+1, received.indexOf('@')+5)));
                    System.out.println("I am sending the packet");
                    socket.send(packet3);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("I am going for another iteration");
        }
        socket.close();
    }
    public static void appendStrToFile(String str)
    {
        try {
            FileWriter fw = new FileWriter("./InterServerLog.txt", true);
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