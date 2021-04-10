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
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
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
                    scanner.next();
                    input = 1L;
                    System.out.println("┌────────────────────────────────────────────────────┐");
                    System.out.println("│        Das ist keine valide Kundennummer!          │");
                    System.out.println("└────────────────────────────────────────────────────┘");
                }
                outputStream.writeLong(input);
                if (input != -1) {
                    ArrayList<Ticket> ticketArrayList = (ArrayList<Ticket>) inputStream.readObject();
                    if (ticketArrayList.isEmpty()) {
                        System.out.println("┌────────────────────────────────────────────────────┐");
                        System.out.println("│       Leider wurde kein Ergebnis gefunden.         │");
                        System.out.println("└────────────────────────────────────────────────────┘");
                    } else {
                        System.out.println("┌────────────────────────────────────────────────────┐");
                        System.out.println("│   Folgende Tickets hat die Kundennummer "+ input + ":   │");
                        System.out.println("└────────────────────────────────────────────────────┘");
                        for (Ticket ticket : ticketArrayList) {
                            System.out.println(ticket.toString());
                        }
                    }
                } else break;

            }
            scanner.close();
            inputStream.close();
            outputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
