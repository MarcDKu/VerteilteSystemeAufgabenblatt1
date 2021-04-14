/*
┌────────────────────────────────────────────────────┐
│                   Kurs: WWI2019A                   │
│────────────────────────────────────────────────────│
│              Student: Marc Kustermann              │
└────────────────────────────────────────────────────┘
*/

import java.io.*;
public class TicketEdit {
  public static void main (String[] summand) { //save ticket objects in .dat
    try {

      File file = new File("C:\\Users\\Marc\\CodingPlace\\verteilteSysteme\\Aufgabenblatt1\\src\\testdaten.txt");
      BufferedReader ein = new BufferedReader(
                                  new FileReader(file));
      String dateiname = "Tickets.dat";
      FileOutputStream datAus = new FileOutputStream(dateiname);
      ObjectOutputStream oAus = new ObjectOutputStream(datAus);
      System.out.print("Anzahl der zu erzeugenden Tickets: ");
      int anzahl = Integer.parseInt(ein.readLine());
      oAus.writeInt(anzahl);   // Anzahl der Datensaetze
      Ticket a;
      long nummer = 20210200000000L;
      for (int i=1; i<=anzahl; i++) {
        nummer++;
        System.out.println("Daten fuer Ticket-Nummer " + nummer);
        System.out.print("Name des Ticket-Besitzers: ");
        String name = ein.readLine();
        System.out.print("Kundennummer des Ticket-Besitzers: ");
        int kdnr = Integer.parseInt(ein.readLine());
        System.out.print("Event: ");
        String event = ein.readLine();
        System.out.print("Preis des Tickets in EUR: ");
        double preis = Double.parseDouble(ein.readLine());
        a = new Ticket (nummer, name, kdnr, event, preis);
        oAus.writeObject(a); 
      }
      oAus.close();
      System.out.println();
      System.out.println(anzahl + " Tickets in die Datei " + 
                         dateiname + " geschrieben");
    }
    catch (Exception e) {
      System.out.println("I/O-Error!");
      e.printStackTrace();
    }
  }
}
