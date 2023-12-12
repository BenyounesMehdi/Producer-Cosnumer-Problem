
package producerconsumer;


import java.util.Random;

    public class Usine implements Runnable  {
        public int marchandiseId ;
        private final Random random = new Random();
        
        Entrepot entrepot = new Entrepot() ; 

       public boolean isWorking = true ;

        public Usine(Entrepot entrepot) {
            this.entrepot = entrepot ;
        }

        @Override
        public void run () {
            while(isWorking) {
                // entrepot.empty.acquire();
                // entrepot.mutex.acquire();
                
                entrepot.empty.p();
                entrepot.mutex.p() ;
                if( entrepot.stock.size() >= entrepot.max ) {
                    System.out.println("Stock atteint le niveau maximum, arrêt de la production\n");
                    
                    // entrepot.mutex.release();
                    // entrepot.full.release();
                    
                }
                
                else {
                    marchandiseId = random.nextInt(1000)+1;
                    entrepot.stock.add(marchandiseId) ;
                    System.out.println("Produit Le Marchandise N°: "+ marchandiseId);
                    System.out.println("Sotcker : " + marchandiseId + " dans le Stock");
                    
                    entrepot.showStockSize();
                    System.out.println(" ");
                    
                    //entrepot.mutex.release();
                    //entrepot.full.release();
                }
                entrepot.mutex.v();
                entrepot.full.v();

            }

        }

    }
