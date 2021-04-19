/*
┌────────────────────────────────────────────────────┐
│                   Kurs: WWI2019A                   │
│────────────────────────────────────────────────────│
│              Student: Marc Kustermann              │
└────────────────────────────────────────────────────┘
*/

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteTicketObject extends UnicastRemoteObject implements RemoteService {

    public RemoteTicketObject() throws RemoteException { //Needs to stand here, so that the Remote Object functions
        super();
    }

    public ArrayList<Ticket> getActiveTickets(long customerNumber) throws RemoteException {
        try {
            do {

                Ticket[] loadedTickets = TicketCheck.liesTicketsAus("Tickets.dat"); //load all Tickets within the Array
                ArrayList<Ticket> tobeSent = new ArrayList<>(); //creates new Array List
                for (Ticket ticket : loadedTickets) {
                    if (ticket.getKdNr() == customerNumber) {
                        tobeSent.add(ticket); //add ticket to the Array List
                    }
                }
                return tobeSent;
            } while (true);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
