
package producerconsumer;
 
public class LeSemaphore {
    int counter ;
    
    public LeSemaphore (int counter) {
        this.counter = counter ;
    }
    
    public synchronized void p() {
        this.counter--;
        if( this.counter < 0 ) {
            try {
                wait();
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(LeSemaphore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }
    
    public synchronized void v() {
        this.counter++ ;
        if( this.counter <= 0 ) {
            notify() ;
        }
    }
}