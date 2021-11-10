//package learnThread;
//
//
///***
// * ThreadLocal 一般用在跨类，跨方法的传递一些值
// * 在一些框架。底层的类中可能会用到，可以避免上层引用代码为了框架当数据的二传手
// */
//public class UseThreadLocalAppMain {
//    public static void main(String[] args) {
//        for (int i =0; i < 3; i++){
//            Thread workingThread = new Thread(()->{
//                System.out.println("开始处理");
//                PerformanceTracker.reset();
//                /***
//                 *下面的三个处理步骤，但是否是用一个线程执行
//                 * 使用ThreadLocal可以不用传递统计数据
//                 */
//
//                InputHandler inputHandler = new InputHandler();
//                String content = inputHandler.getInput();
//
//                DBQuery query = new DBQuery();
//                query.query();
//
//                ContProcess contProcess = new ContProcess();
//                contProcess.process(content);
//
//                PerformanceTracker.finish();
//                System.out.println("处理结束");
//
//            }, "Worker-"+i);
//            workingThread.start();
//        }
//    }
//}
