/*
┌────────────────────────────────────────────────────┐
│                   Kurs: WWI2019A                   │
│────────────────────────────────────────────────────│
│              Student: Marc Kustermann              │
└────────────────────────────────────────────────────┘
*/

import java.rmi.*;
import java.rmi.registry.LocateRegistry;


public class RemoteServer implements Remote {
    public static void main(String[] args) {
        try {
            RemoteTicketObject ticketObject= new RemoteTicketObject(); //initialize Ticket Object with functions
            LocateRegistry.createRegistry(1099); //create new
                Naming.rebind("rmi://localhost:1099/tickets", ticketObject); //wirte into rmi, that the Object exists
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

