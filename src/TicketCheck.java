/*
┌────────────────────────────────────────────────────┐
│                   Kurs: WWI2019A                   │
│────────────────────────────────────────────────────│
│              Student: Marc Kustermann              │
└────────────────────────────────────────────────────┘
*/

import java.io.*;
public class TicketCheck {

  public static Ticket[] liesTicketsAus (String dateiname) { //.dat readout
    try {
      FileInputStream datEin = new FileInputStream(dateiname);
      ObjectInputStream oEin = new ObjectInputStream(datEin);
      // Tickets aus der Datei lesen und in Array speichern 
      int anzahl = oEin.readInt();
      Ticket[] ga = new Ticket[anzahl];
      for (int i=0; i<anzahl; i++) {
        ga[i] = (Ticket) oEin.readObject(); 
      }
      oEin.close();
      return ga;
    }
    catch (Exception e) {
      System.out.println("Fehler beim Lesen: " + e);
      return new Ticket[0];
    }
  }

  public static void main (String[] args) {
    String dateiname = "Tickets.dat";

    // Tickets aus der Datei lesen und deren Datensatzfelder 
    // zur Kontrolle auf den Bildschirm ausgeben

    Ticket[] gut = liesTicketsAus(dateiname);

    System.out.println("Die Datei " + dateiname + " enthaelt " + 
                        gut.length + " Tickets");
    for (Ticket ticket : gut) {
      System.out.println(ticket);
    }
  }
}
