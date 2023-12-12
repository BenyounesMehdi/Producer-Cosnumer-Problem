
package producerconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {
         Scanner sc = new Scanner(System.in);
        
        System.out.print("Veuillez saisir le nombre des Clients: ");
        int numberOfClients = sc.nextInt() ;
        System.out.println("");
        
        Entrepot entrepot = new Entrepot() ;
        Usine usine = new Usine(entrepot) ;
        Thread usineThread = new Thread(usine) ;
        
        List<Thread> threads = new ArrayList<>();
        
        usineThread.start() ;
        
        
        for (int i = 0; i < numberOfClients; i++) {
            Client client = new Client(entrepot);
            Thread clientThread = new Thread(client);
            clientThread.setName("" + (i+1)); // Set a Number for each Client
            clientThread.start(); // Statrt The Client Thread
        }
        
            usineThread.join();
        for (Thread thread : threads) {
                thread.join();
        }
    }
    
}
