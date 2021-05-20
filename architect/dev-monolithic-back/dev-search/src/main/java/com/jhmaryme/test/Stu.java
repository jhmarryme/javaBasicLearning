package com.jhmaryme.test;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 *
 * @author JiaHao Wang
 * @date 2021/5/20 16:19
 */
@Document(indexName = "stu")
@Data
public class Stu {
    /**
     *  id：作用在成员变量，标记一个字段为id主键；一般id字段或是域不需要存储也不需要分词；
     */
    @Id
    private Long stuId;
    /**
     其实不管我们将store值设置为true或false，elasticsearch都会将该字段存储到Field域中；但是他们的区别是什么？
     store = false时，默认设置；那么给字段只存储在"_source"的Field域中；
     store = true时，该字段的value会存储在一个跟_source平级的独立Field域中；同时也会存储在_source中，所以有两份拷贝。
     那么我们在什么样的业务场景下使用store field功能？
     */
    @Field(store = true)
    private String name;
    @Field(store = true)
    private Integer age;
    @Field(store = true)
    private String desc;
    @Field(store = true,type = FieldType.Keyword)
    private String sign;
    @Field(store = true)
    private Float money;
}
