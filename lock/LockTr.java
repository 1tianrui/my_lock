import java.util.concurrent.locks.Lock;

public class LockTr implements Lock{

}import sun.misc.Unsafe;

        import java.lang.reflect.Field;
        import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jnkmhbl on 16/8/16.
 */
public class LockTr<T> {
    private volatile  T t;
    private AtomicInteger  complete = new AtomicInteger(1) ;



    public boolean setValue(T t ){
        if(complete.compareAndSet(1,0)) {
            this.t = t;
            System.out.println(t);
        }
        else
            return false;

        if(!complete.compareAndSet(0,1)) {
            System.out.println("error");
            return false;
        }
        return true;
    }

    public T  getValue(){
        return t ;
    }

}
