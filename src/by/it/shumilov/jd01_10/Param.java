package by.it.shumilov.jd01_10;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)

@interface Param {
    int a();
    int b();
}
