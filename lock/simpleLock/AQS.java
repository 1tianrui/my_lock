package simpleLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tianrui03 on 16/8/16.
 */
public class AQS {
    List<Node> list = new ArrayList<Node>();
    AtomicInteger lockStatus = new AtomicInteger(0);
    Thread currentThread ;
    public boolean  acquire(){
        if(currentThread == Thread.currentThread()){
          return false ;
        }else if(currentThread != null){
            return false ;
        }else{
            if(lockStatus.compareAndSet(0,1)){
                currentThread = Thread.currentThread();
                Node node = getByThread(Thread.currentThread());
                node.status = 1;
            }else{
                return false ;
            }
        }
        return true ;
    }

    public boolean release(){
        if(currentThread != Thread.currentThread()){
            return false ;
        }
        currentThread = null ;
        Node node = getByThread(Thread.currentThread());
        node.status = 0;
        lockStatus.set(0);
        return true;
    }
    private Node getByThread(Thread thread){
        return null ;
    }
    class Node {
        private Thread thread;
        private int status ; // -1表示阻塞  0 表示等待  1表示持有锁
    }
}
