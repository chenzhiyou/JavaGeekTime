package learnThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapAppMain {
    public static void main(String[] args) {
        /***
         * ConcurrentHashMap本身对线程并发做了优化，将Map切分为16个segment，相当于一个map有16把锁，各管不同的segment
         */
        Map<String, List<Integer>> map = new ConcurrentHashMap<>();
        String k1 = "k1";

        map.put(k1, new ArrayList<>());
        System.out.println("put:" +map.get(k1));
        /***
         * ConcurrentHashMap的key和value都不允许为null
         * 对线程并发环境下，key的值为null和key对应的值没有模棱两可的，所以干脆不支持
         * putIfAbsent是在key没有的情况下，才会放入这个key-value对
         */
        List<Integer> newList = new ArrayList<>();
        newList.add(999);
        map.putIfAbsent(k1, newList);
        System.out.println("putIfAbsent:" + map.get(k1));

        map.compute(k1, (k,v)->{
            v.add(1);
            return v;
        });
        System.out.println("compute:" + map.get(k1));

        /***
         * 如果key对应的值存在，则执行lambda
         */
        map.computeIfPresent(k1, (k, v)->{
            v.add(999);
            return v;
        });
        System.out.println("computeIfPresent:" + map.get(k1));

        /***
         * 和putIfAbsent不一样，lambda里的代码只有在key缺失的情况下才会执行
         * 所以虽然是尝试创建一个超出这个程序允许的内存大小的对象，但是因为已经有了这个key了，所以lambda不会执行
         */
        map.computeIfAbsent(k1, (k)->new ArrayList<>(Integer.MAX_VALUE));

    }
}
