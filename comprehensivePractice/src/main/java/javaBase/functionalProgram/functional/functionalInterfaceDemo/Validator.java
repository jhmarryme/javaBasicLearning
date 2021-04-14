package javaBase.functionalProgram.functional.functionalInterfaceDemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.UserService;

import java.util.function.Predicate;

/**
 * 使用predicate的简单校验器
 * @author Jiahao Wang
 * @date 2021/4/14 12:25
 */
public class Validator<T> {
    /**
     * 初始化为 true  true &&其它布尔值时由其它布尔值决定真假
     */
    private Predicate<T> predicate = t -> true;

    /**
     * 添加一个校验策略，可以无限续杯😀
     *
     * @param predicate the predicate
     * @return the validator
     */
    public Validator<T> with(Predicate<T> predicate) {
        this.predicate = this.predicate.and(predicate);
        return this;
    }

    /**
     * 执行校验
     *
     * @param t the t
     * @return the boolean
     */
    public boolean validate(T t) {
        return predicate.test(t);
    }

    @Test
    @DisplayName("使用predicate的简单校验器")
    public void whenValidateSuccess() {
        UserService userService = new UserService();

        // 也可以使用 类中的方法进行校验
        boolean validated = new Validator<String>()
                .with(s -> s.length() > 5)
                .with(s -> s.startsWith("jh"))
                .with(userService::checkUserByName)
                .validate("jhmarryme");

        Assertions.assertFalse(validated);
    }
}