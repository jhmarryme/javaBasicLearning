package reading.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.ParserConfig;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author JiaHao Wang
 * @date 2022/5/27 下午2:30
 */
public class FastJsonUpdateTest {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class User {
        @JSONField(name = "teng_yun_user_id")
        private String tengyunID;

        /** 腾云账号，为手机号/邮箱 */
        @JSONField(name = "user_name")
        private String tengyunUser;

        /** 是否启用。启用为1；停用为0 */
        private int enabled;

        /** 邮箱 */
        private String email = "";

        /** 密码 */
        private String password;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class MyUser {
        @JSONField(name = "tengYunUserId")
        private String userAgent;

        /** 腾云账号，为手机号/邮箱 */
        @JsonProperty("user_name" )
        private String myName;

        // private String registerTime;
    }



    @Test
    @DisplayName("")
    public void whenSuccess() {
        String jsonStr = "{    \"teng_yun_user_id\": \"A5063387D57F6139E0534095DD0A1A25\",    \"userName\": " +
                "\"15202847997\"}";
        MyUser myUser2 = JSON.parseObject(jsonStr, MyUser.class);
        System.out.println("myUser2 = " + myUser2);

    }
}
