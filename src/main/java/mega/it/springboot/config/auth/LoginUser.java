package mega.it.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //파라미터에만 붙는다.
@Retention(RetentionPolicy.RUNTIME) //런타임 시 동작
public @interface LoginUser {

}