//package learnThread;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
//
//public class AtomicNumberAppMain {
//
//    private volatile long longVar =0;
//    private AtomicLong atomicLong = new AtomicLong(0);
//
//    public static void main(String[] args) throws InterruptedException {
//        AtomicNumberAppMain atomicNumberAppMain = new AtomicNumberAppMain();
//        int loop = Integer.MAX_VALUE/ 10;
//
//        //并发使用线程给AtomicLong对象加一
//        int parallel =10;
//        List<Thread> atomicThreads = new ArrayList<>();
//        for (int p =0; p<parallel; p++){
//            int loopCount = loop / parallel;
//            if (p==parallel-1){
//                loopCount = loop-(loop/parallel)*(parallel-1);
//            }
//            int finalLoopCount = loopCount;
//            Thread atomic = new Thread(()->{
//                long star = System.currentTimeMillis();
//                for (int i=0; i<finalLoopCount; i++){
//                    atomicNumberAppMain.atomicLong.incrementAndGet();
//                }
//                System.out.println("Atomic taks "+ (System.currentTimeMillis()- star));
//            });
//            atomic.start();;
//            atomicThreads.add(atomic);
//        }
//
//        Thread primary = new Thread(()->{
//            long start = System.currentTimeMillis();
//            for (int i=0; i<loop; i++){
//                atomicNumberAppMain.longVar++;
//            }
//            System.out.println("Primary var takes" + (System.currentTimeMillis()-start));
//        });
//        primary.start();
//
//        for (Thread atomicThread: atomicThreads){
//            atomicThread.join();
//        }
//        primary.join();
//        System.out.println(atomicNumberAppMain.toString());
//    }
//}
