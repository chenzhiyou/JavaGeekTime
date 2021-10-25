package learnThread;

import java.util.concurrent.LinkedBlockingDeque;

public class CollectionAppMain {
    public static void main(String[] args) {
        //默认是Interget.MAX_VALUE这么大
        //元素不允许为null
        LinkedBlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<>(128);
        // 获取队列最前面，但是不出列，偷瞄一眼
        linkedBlockingDeque.peek();
        /***
         * 将元素放入队列，返回是否放入成功，一般在限制队列大小的情况下才会失败，毕竟达到Interget.MAX_VALUE程序可能就因为没有内存挂了
         * 这个方法也有超时版本
         */
        boolean added = linkedBlockingDeque.offer("");
        /***
         * 队列里有就拿出来，没有就返回空，还有超时重载版本
         */
        linkedBlockingDeque.poll();
        /***
         * offer和poll是一对，都随缘，能行就行不行就算了
         */
        try {
            /***
             * 将元素加入队列，如果队列满了，就等着
             */
            linkedBlockingDeque.put("");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        try {
            linkedBlockingDeque.take();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        /***
         * put和take可以方便的实现生产者消费者模式
         */
    }
}
