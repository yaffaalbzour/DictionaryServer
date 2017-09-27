package DictionaryServer;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException 
    {
        try ( 
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        ) {
        
            String word, meaning;
            
            // Initiate conversation with client
            Dictionary result = new Dictionary();
            meaning = result.processInput(null);
            out.println(meaning);

            while ((word = in.readLine()) != null) {
                meaning = result.processInput(word);
                out.println(meaning);
                if (meaning.equals("Bye."))
                    break;
            }
        } catch (IOException e) {
            System.out.println("Error in connection attempt.");
            System.out.println(e.getMessage());
        }
    }
}