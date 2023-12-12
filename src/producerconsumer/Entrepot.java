
package producerconsumer;

import java.util.LinkedList;
//import java.util.concurrent.Semaphore;

public class Entrepot {
    int max = 50 ;
    int min = 10;
   /* Semaphore mutex = new Semaphore(1) ;
    Semaphore empty = new Semaphore(max+1) ;
    Semaphore full = new Semaphore(0) ; */
    
    LeSemaphore mutex = new LeSemaphore(1) ;
    LeSemaphore empty = new LeSemaphore(max+1) ;
    LeSemaphore full = new LeSemaphore(0) ;
    
    LinkedList stock = new LinkedList() ;
    
    public void showStockSize() {
        System.out.println("Le Nombre de Produits dans Le Stock est : " + stock.size());
    }
}
