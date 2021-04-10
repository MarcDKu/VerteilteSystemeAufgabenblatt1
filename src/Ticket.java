import java.io.*;
import java.util.*;
public class Ticket implements Serializable {
  private static final long serialVersionUID = 9876543210L;
  private long   nr;         // Nummer des Tickets
  private String kdName;     // Name des Ticket-Besitzers
  private int    kdNr;       // Kundennummer des Ticket-Besitzers
  private String event;      // Bezeichnung des Events
  private double preis;      // Preis des Tickets in EUR
  public Ticket (long n, String kNa, int kNu, String ev, double p) {
    nr = n;
    kdName = kNa;
    kdNr = kNu;
    event = ev;
    preis = p;
  }
  public long getKdNr () {
    return kdNr;
  }
  public String toString() {
    return "Ticket fuer " + kdName + " (Kd-Nr. " + kdNr +")\n"
           + "\tfuer das Event << " + event + " >> "
           + "zum Preis von " + preis + " EUR";
  }
}
