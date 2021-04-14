/*
┌────────────────────────────────────────────────────┐
│                   Kurs: WWI2019A                   │
│────────────────────────────────────────────────────│
│              Student: Marc Kustermann              │
└────────────────────────────────────────────────────┘
*/

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ThreadForServer extends Thread {
    int clientNumber = 0;
    Socket socket;
    DataInputStream Input;
    ObjectOutputStream Output;

    public ThreadForServer(Socket socket) {
        try {
            this.socket = socket; //try's whether or not the element is a Socket, if yes it increases the current client Number
            clientNumber++;

            Input = new DataInputStream(socket.getInputStream());
            Output = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void run() {
        try {
            do {
                long customerNumber = Input.readLong();  //get the current Input

                    Ticket[] loadedTickets = TicketCheck.liesTicketsAus("Tickets.dat"); //load all Tickets within the Array
                    ArrayList<Ticket> tobeSent = new ArrayList<>(); //creates new Array List
                    for (Ticket ticket : loadedTickets) {
                        if (ticket.getKdNr() == customerNumber) {
                            tobeSent.add(ticket); //add ticket to the Array List
                        }
                    }
                    Output.writeObject(tobeSent);

            } while (true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
