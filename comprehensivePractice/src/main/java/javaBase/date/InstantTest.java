package javaBase.date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.*;

/**
 * 时间戳的转换
 * @author JiaHao Wang
 * @date 2021/6/18 16:03
 */
public class InstantTest {

    @Test
    @DisplayName("时间戳的转换")
    public void whenConvertSuccess() {
        // 1. LocalDateTime -> Instant
        // 1.1 atZone()
        Instant instant1 = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant();
        // 1.2 toInstant()
        Instant instant2 = LocalDateTime.now().toInstant(ZoneOffset.ofHours(8));

        // 2. Instant -> zonedDateTime
        ZonedDateTime zonedDateTime = instant1.atZone(ZoneId.systemDefault());

        // 3. 通过Instant获取 毫秒数
        long epochMilli = instant1.toEpochMilli();
        System.out.println("epochMilli = " + epochMilli);
        // 4. 通过Instant获取 秒数
        long epochSecond = instant1.getEpochSecond();
        System.out.println("epochSecond = " + epochSecond);
        // 5. 通过毫秒数创建Instant
        Instant instant = Instant.ofEpochMilli(epochMilli);

    }
}
