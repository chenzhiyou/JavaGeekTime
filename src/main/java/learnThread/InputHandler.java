//package learnThread;
//
//public class InputHandler {
//    public String getInput() {
//        PerformanceTracker.startPhase();
//        return produceString();
//    }
//
//    private static String produceString(){
//        PerformanceTracker.startPhase();
//        StringBuilder ret = new StringBuilder();
//        for (int i =0; i<128; i++){
//            int rand = ((int)(Math.random()*1000))%26;
//            char ch = (char)(rand +'a');
//            ret.append(ch);
//        }
//        PerformanceTracker.endPhase("InputGen", "10");
//        return ret.toString();
//    }
//}
