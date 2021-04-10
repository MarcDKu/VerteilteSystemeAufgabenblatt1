import java.net.*;
import java.io.*;


public class ServerExerciseTwo {
    public static void main(String[] args) {
        try{
ServerSocket Server= new ServerSocket(9898);
do {
    Socket socket= Server.accept();
    new ThreadForServer(socket).start();
}while (true);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

