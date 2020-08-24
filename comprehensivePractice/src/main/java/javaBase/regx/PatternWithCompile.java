package javaBase.regx;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * description:
 *
 * @Author: Wjh
 * @Date: 2020/8/21 9:24
 * @Modified By:
 */
public class PatternWithCompile {
    @Test
    public void useSimpleRegx() {
        String request = "astwt=dasd&&asd&twt=asd&asd&&&%$#twt=@$@twt=asd1122&&&&@^123";

        // 替换子串
        String regex = "twt=[A-Za-z0-9]*[&]";
        String s = request.replaceAll(regex, "Hello?");
        System.out.println("s = " + s);

        // Java 9 以前寻找满足条件的所有子串
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(request);
        while (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }

        // Java 9 以后寻找子串
        /*List<String> collect = Pattern.compile(regex)
                .matcher(request)
                .results()
                .map(MatchResult::group)
                .collect(Collectors.toList());
        collect.forEach( s1 ->
            System.out.println("s1 = " + s1)
        );*/

    }
}
