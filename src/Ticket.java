import java.io.*;
import java.util.*;
public class Ticket implements Serializable {
  private static final long serialVersionUID = 9876543210L;
  private long   nr;         // Nummer des Tickets
  private String kdName;     // Name des Ticket-Besitzers
  private int    kdNr;       // Kundennummer des Ticket-Besitzers
  private String event;      // Bezeichnung des Events
  private double preis;      // Preis des Tickets in EUR
  public Ticket (long n, String kNa, int kNu, String ev, double p) { // initialise Ticket Object
    nr = n;
    kdName = kNa;
    kdNr = kNu;
    event = ev;
    preis = p;
  }
  public long getKdNr () {//einer öffentlichen Zugriffsmethode, mit der die Kundennummer eines Ticket-Objekts ausgelesen werden kann
    return kdNr;
  }
  public String toString() { //convert Ticket to String
    return "Ticket fuer " + kdName + " (Kd-Nr. " + kdNr +")\n"
           + "\tfuer das Event << " + event + " >> "
           + "zum Preis von " + preis + " EUR";
  }
}
