/*
┌────────────────────────────────────────────────────┐
│                   Kurs: WWI2019A                   │
│────────────────────────────────────────────────────│
│              Student: Marc Kustermann              │
└────────────────────────────────────────────────────┘
*/

import java.rmi.*;
import java.util.ArrayList;

public interface RemoteService extends Remote { //create Interface, which contains getActiveTickets
    ArrayList<Ticket> getActiveTickets(long customerNumber) throws RemoteException ;

    }
