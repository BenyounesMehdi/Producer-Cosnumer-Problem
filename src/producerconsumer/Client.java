
package producerconsumer;


public class Client implements Runnable{
    Entrepot entrepot = new Entrepot() ;
    int produit ;
    
    boolean isConssuming = true ;
    
    public Client (Entrepot entrepot) {
        this.entrepot = entrepot ;
    }
    
    @Override
    public void run () {
        while(isConssuming) {
            //entrepot.full.acquire();
            //entrepot.mutex.acquire();
            
            entrepot.full.p();
            entrepot.mutex.p();
            if( entrepot.stock.isEmpty() ) {
                System.out.println("\n ---- Les Clients sont en cas d'attente ---- \n ");
                
                //entrepot.mutex.release();
                //entrepot.empty.release();
            }
            else {
                if (entrepot.stock.size() <= entrepot.min) {
                    System.out.println( "("+Thread.currentThread().getName()+") Stock en dessous du niveau minimum, reprise de la production");
                    System.out.println(" ");
                }
                produit = (int) entrepot.stock.removeLast();
                System.out.println("Client N°: ("+ Thread.currentThread().getName() +") Retire Marchandise N°: " + produit);
                entrepot.showStockSize();
                System.out.println(" "); 
                
                //entrepot.mutex.release();
                //entrepot.empty.release();
            } 
            
            entrepot.mutex.v();
            entrepot.empty.v();
        }        
    }
}
