package simpleLock;

/**
 * Created by jnkmhbl on 16/8/16.
 */
public class Lock  {
    AQS aqs = new AQS();
    public void lock(){
        aqs.acquire();
    }
    public void release(){
        aqs.release();
    }
}
