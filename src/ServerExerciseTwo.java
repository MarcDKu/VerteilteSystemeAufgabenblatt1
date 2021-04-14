/*
┌────────────────────────────────────────────────────┐
│                   Kurs: WWI2019A                   │
│────────────────────────────────────────────────────│
│              Student: Marc Kustermann              │
└────────────────────────────────────────────────────┘
*/

import java.io.IOException;
import java.net.ServerSocket;


public class ServerExerciseTwo {
    public static void main(String[] args) {
        try {
            ServerSocket Server = new ServerSocket(9898);
            do {
                new ThreadForServer(Server.accept()).start(); //create a New Thread on the Server, with the Socket as 9898
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

