package learncollection;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class IterateListLambdaAppMain {
    public static void main(String[] args) {
        List<String> myList = addElementsToList(new ArrayList<String>());
        String outside = "outside string";

        // 匿名内部类版
        myList.forEach(new Consumer<String>() {

            @Override
            public void accept(String s){
                processString(outside + s);
            }
        });

        /**
         * lambda 的表达式必须能够符合接口中定义的抽象方法，从参数，到返回值，到异常，必须匹配
         * lambda 完整版（参数）->{代码块}
         * lambda可以有返回值，使用return语句就可以，当然我们这个接口没有，我们的lambda表达式也不能有
         * lambda可以使用外部数据，怎么看都和匿名内部类是一样的
         */
        myList.forEach((s)->{
            processString(outside +s);
        });

        // lambda单参数，代码单行，简化版
        myList.forEach(s->processString(outside+s));

        // lambda如果不需要外部变量，还有方法引用终极简化版
        myList.forEach(IterateListLambdaAppMain::processString);

        // lambda方法引用终极简化版：不需要静态方法，用引用也可以
        IterateListLambdaAppMain inst = new IterateListLambdaAppMain();
        myList.forEach(inst::processStringInsr);

        // lambda也允许指定一个参数类型里的一个方法作为方法的阴影
        myList.forEach(String::toUpperCase);
    }

    public static List<String> addElementsToList(List<String> list){
        for (int i = 0; i<22; i++){
            list.add("str" + i);
        }
        return list;
    }

    private static void processString(String str){
        System.out.println(str);
    }

    private void processStringInsr(String str){
        System.out.println(str);
    }
}
