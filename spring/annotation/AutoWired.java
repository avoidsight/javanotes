package spring.annotation;

import java.lang.annotation.*;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-05-19 22:37
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
@Documented
public @interface AutoWired {
}
