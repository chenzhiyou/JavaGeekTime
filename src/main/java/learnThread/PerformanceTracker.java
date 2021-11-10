//package learnThread;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PerformanceTracker {
//    private static class Phase{
//
//        private String name;
//        private long duration;
//
//        public Phase(String name, long duration){
//            this.name = name;
//            this.duration = duration;
//        }
//
//        @Override
//        public String toString(){
//            return "Phase{" +
//                    "bane='" + name +'\''+
//                    ", duration=" + duration +
//                    "}\n";
//        }
//    }
//
//    /***
//     * ThreadLocal一般都是static的
//     * 这样使用ThreadLocal，这些数据不用在应用程序之间传递，而且还可以为每个线程保留自己的一份数据
//     */
//
//    private static final ThreadLocal<List<Phase>> PHASE = new ThreadLocal<>();
//    private static final ThreadLocal<Long> PHASE_START_TIME = new ThreadLocal<>();
//
//    public static void startPhase() {
//        PHASE_START_TIME.set(
//                System.currentTimeMillis()
//        );
//    }
//
//    public static void endPhase(String phaseName, String inputGen) {
//        long start = PHASE_START_TIME.get();
//        PHASE.get().add(new Phase(phaseName, System.currentTimeMillis()-start));
//    }
//
//    public static void finish() {
//        List<Phase> phases = PHASE.get();
//        PHASE_START_TIME.set(null);
//
//        StringBuilder out = new StringBuilder("-------Thread Excution Phase Duration-------");
//        phases.forEach(out::append);
//        out.append("==================\n");
//        System.out.println(out.toString());
//    }
//
//    public static void reset() {
//        PHASE.set(new ArrayList<>());
//        PHASE_START_TIME.set(-1L);
//    }
//}
