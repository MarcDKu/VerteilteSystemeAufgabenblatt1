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
            this.socket = socket;
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
                long customerNumber = Input.readLong();
                if (customerNumber != -1) {
                    Ticket[] loadedTickets = TicketCheck.liesTicketsAus("Tickets.dat");
                    ArrayList<Ticket> tobeSent = new ArrayList<>();
                    for (Ticket ticket : loadedTickets) {
                        if (ticket.getKdNr() == customerNumber) {
                            tobeSent.add(ticket);
                        }
                    }
                    Output.writeObject(tobeSent);
                } else {
                    break;
                }
            } while (true);
            Input.close();
            Output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
