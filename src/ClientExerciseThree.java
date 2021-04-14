/*
┌────────────────────────────────────────────────────┐
│                   Kurs: WWI2019A                   │
│────────────────────────────────────────────────────│
│              Student: Marc Kustermann              │
└────────────────────────────────────────────────────┘
*/

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientExerciseThree {

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Socket socket = new Socket("localhost", 9898);
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            System.out.println("┌────────────────────────────────────────────────────┐");
            System.out.println("│     Bitte geben Sie eine Kundennummer ein!         │");
            System.out.println("│────────────────────────────────────────────────────│");
            System.out.println("│          Drücken Sie zum Abbrechen -1              │");
            System.out.println("└────────────────────────────────────────────────────┘");

            while (true) {
                Long input;

                try {
                    input = scanner.nextLong();

                } catch (Exception e) {
                    input = null;
                    scanner.next();
                    System.out.println("┌────────────────────────────────────────────────────┐");
                    System.out.println("│        Das ist keine valide Kundennummer!          │");
                    System.out.println("└────────────────────────────────────────────────────┘");
                }
                outputStream.writeLong(input);
                if (input != -1) {
                    ArrayList<Ticket> foundTickets = (ArrayList<Ticket>) inputStream.readObject();
                    if (foundTickets.isEmpty()) {
                        System.out.println("┌────────────────────────────────────────────────────┐");
                        System.out.println("│       Leider wurde kein Ergebnis gefunden.         │");
                        System.out.println("└────────────────────────────────────────────────────┘");
                    } else {
                        System.out.println("┌────────────────────────────────────────────────────┐");
                        System.out.println("│  Folgende Tickets haben die Kundennummer "+ input + ":  │");
                        System.out.println("└────────────────────────────────────────────────────┘");
                        for (Ticket singleTicket : foundTickets) {
                            System.out.println(singleTicket.toString());
                        }
                    }
                } else break;

            }
            socket.close();
            inputStream.close();
            scanner.close();
            outputStream.close();

        } catch (IOException e) {
            System.out.println("┌────────────────────────────────────────────────────┐");
            System.out.println("│           Es ist ein Fehler aufgetreten!           │");
            System.out.println("└────────────────────────────────────────────────────┘");
            e.printStackTrace();
        }
    }
}
