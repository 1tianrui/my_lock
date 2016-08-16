import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by jnkmhbl on 16/8/16.
 */
public class DataContainerLock<T> {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private volatile  T t;
    private void write(T target){
        lock.writeLock().lock();
        t= target;
        lock.writeLock().unlock();
    }

    public T read(){
        lock.readLock().lock();
        final T t = this.t;
        lock.readLock().unlock();
        return t;
    }

}
