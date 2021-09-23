package learncollection;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Target注解可以被用到哪个/哪些元素上
 * Retention注解会被留存到哪个阶段
 * 以上两个元素是每个注解都必须要有的
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PrimaryProperty {
    String defaultValue() default "N/A";

    Class targetClass();

    int abc();

    String[] defaultValues();

    // 注解类型的缺省值
    Override is() default  @Override;


}
