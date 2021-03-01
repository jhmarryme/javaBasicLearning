package reading.json.gson;

import base.entity.json.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * description:
 *      `@SerializedName(value="字段名", alternate="别名")`
 *      推荐使用 private 修饰字段。
 *      不需要使用任何的注解来表明哪些字段需要序列化，哪些字段不需要序列化。默认情况下，包括所有的字段，以及从父类继承过来的字段。
 *      如果一个字段被 transient 关键字修饰的话，它将不参与序列化。
 *      如果一个字段的值为 null，它不会在序列化后的结果中显示。
 *      JSON 中缺少的字段将在反序列化后设置为默认值，引用数据类型的默认值为 null，数字类型的默认值为 0，布尔值默认为 false。
 *
 *      https://www.baeldung.com/tag/gson/
 * @author: JiaHao Wang
 * @date: 2021/1/5 12:48
 * @modified By:
 */
public class DeserializedTest {

    @Test
    @DisplayName("对象的反序列化, 可选保留空值")
    public void whenObjectDeserializedSuccess() {
        Gson gson = new GsonBuilder().create();
        Weather weather = gson.fromJson("{\n"
                + "  \"location\": \"London\",\n"
                + "  \"temp\": 15,\n"
                + "  \"weather\": \"Cloudy\"\n"
                + "}", Weather.class);

        assertEquals("London", weather.getLocation());
        assertEquals("Cloudy", weather.getOutlook());
        assertEquals(15, weather.getTemp());

        // 使用别名也可以反序列化成功
        weather = gson.fromJson("{\n"
                + "  \"place\": \"Lisbon\",\n"
                + "  \"temperature\": 35,\n"
                + "  \"outlook\": \"Sunny\"\n"
                + "}", Weather.class);

        assertEquals("Lisbon", weather.getLocation());
        assertEquals("Sunny", weather.getOutlook());
        assertEquals(35, weather.getTemp());
    }

    @Test
    @DisplayName("包含List的对象反序列化, 并忽略特定字段")
    public void whenJiejiariDeserializedIgnoreFieldSuccess() {
        Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                //过滤指定的字段名
                return f.getName().contains("vacation") || f.getName().contains("remark");
            }
            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        }).create();

        JsonObject jsonObject = JsonParser.parseString(getJiejiariResult()).getAsJsonObject();
        JsonArray jsonArray = jsonObject.get("newslist").getAsJsonArray();
        List<News> newsList = gson.fromJson(jsonArray.toString(), new TypeToken<List<News>>() {}.getType());

        assertNotNull(newsList);
    }


    @Test
    @DisplayName("排除Modifier为指定类型的字段")
    public void whenExcludeFieldsWithModifiersSuccess() {
        // 排除protected 字段
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithModifiers(Modifier.PROTECTED)
                    .create();
    }

    @Test
    @DisplayName("使用@Expose注解 排除字段")
    public void whenExcludeFieldsWithoutExposeAnnotationSuccess() {
        // 在需要序列化和反序列化的字段上加上 @Expose 注解，如果没加的话，该字段将会被 忽略
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }

    @Test
    @DisplayName("List对象反序列化")
    public void whenListDeserializedSuccess() {
        Gson gson = new Gson();

        String inputString = "[{\"id\":1,\"name\":\"name1\"},{\"id\":2,\"name\":\"name2\"}]";
        List<Person> inputList = Arrays.asList(new Person(1, "name1"), new Person(2, "name2"));

        // Gson的TypeToken来确定要反序列化的正确类型
        Type listOfMyClassObject = new TypeToken<ArrayList<Person>>() {}.getType();

        List<Person> outputList = gson.fromJson(inputString, listOfMyClassObject);

        assertEquals(inputList, outputList);
    }

    @Test
    @DisplayName("简单的序列化集合 反序列化")
    public void whenSimpleListDeserializedSuccess() {
        Gson gson = new Gson();
        List<String> list =new ArrayList<>();
        list.add("好好学习");
        list.add("天天向上");
        String json = gson.toJson(list);
        String[] anotherStr = gson.fromJson("[\"沉默\",\"王二\"]", String[].class);
        List<String> listResult = gson.fromJson(json,List.class);

        assertNotNull(anotherStr);
        assertNotNull(listResult);
    }

    @Test
    @DisplayName("List对象反序列化-失败")
    public void whenListDeserializedFailed() {
        String inputString = "[{\"id\":1,\"name\":\"name1\"},{\"id\":2,\"name\":\"name2\"}]";

        Gson gson = new Gson();

        assertThrows(
                ClassCastException.class,
                () -> {
                    List<Person> outputList = gson.fromJson(inputString, ArrayList.class);
                    assertEquals(1, outputList.get(0).getId());
                },
                ""
        );
    }
    
    @Test
    @DisplayName("多态对象List反序列化")
    public void whenPolyMorphicObjectListDeserializedSuccess() {
        // TODO https://www.baeldung.com/gson-list
    }

    public String getJiejiariResult() {
        return "{\n" +
                "  \"code\": 200,\n" +
                "  \"msg\": \"success\",\n" +
                "  \"newslist\": [\n" +
                "    {\n" +
                "      \"date\": \"2021-01-01\",\n" +
                "      \"daycode\": 1,\n" +
                "      \"weekday\": 5,\n" +
                "      \"cnweekday\": \"星期五\",\n" +
                "      \"lunaryear\": \"庚子\",\n" +
                "      \"lunarmonth\": \"冬月\",\n" +
                "      \"lunarday\": \"十八\",\n" +
                "      \"info\": \"节假日\",\n" +
                "      \"start\": 0,\n" +
                "      \"end\": 2,\n" +
                "      \"holiday\": \"1月1号\",\n" +
                "      \"name\": \"元旦节\",\n" +
                "      \"enname\": \"New Year's Day\",\n" +
                "      \"isnotwork\": 1,\n" +
                "      \"vacation\": \"\",\n" +
                "      \"remark\": \"\",\n" +
                "      \"tip\": \"1月1日放假，共3天。\",\n" +
                "      \"rest\": \"2020年12月28日至2020年12月31日请假四天，与周末连休可拼七天长假。\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"2021-01-02\",\n" +
                "      \"daycode\": 1,\n" +
                "      \"weekday\": 6,\n" +
                "      \"cnweekday\": \"星期六\",\n" +
                "      \"lunaryear\": \"庚子\",\n" +
                "      \"lunarmonth\": \"冬月\",\n" +
                "      \"lunarday\": \"十九\",\n" +
                "      \"info\": \"节假日\",\n" +
                "      \"start\": 0,\n" +
                "      \"end\": 2,\n" +
                "      \"holiday\": \"1月1号\",\n" +
                "      \"name\": \"元旦节\",\n" +
                "      \"enname\": \"\",\n" +
                "      \"isnotwork\": 1,\n" +
                "      \"vacation\": [\n" +
                "        \"2021-01-01\",\n" +
                "        \"2021-01-02\",\n" +
                "        \"2021-01-03\"\n" +
                "      ],\n" +
                "      \"remark\": \"\",\n" +
                "      \"tip\": \"1月1日放假，共3天。\",\n" +
                "      \"rest\": \"2020年12月28日至2020年12月31日请假四天，与周末连休可拼七天长假。\"\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";
    }

}
