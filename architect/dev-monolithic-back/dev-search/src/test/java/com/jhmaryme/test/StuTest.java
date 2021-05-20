package com.jhmaryme.test;

import com.jhmaryme.SearchApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author JiaHao Wang
 * @date 2021/5/20 16:26
 */
@SpringBootTest(classes = SearchApplication.class)
class StuTest {

    @Autowired
    private ElasticsearchRestTemplate restTemplate;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;


    @Test
    @DisplayName("插入数据, 自动映射")
    public void whenCreateIndexStuSuccess() {
//        Stu stu = new Stu();
//        stu.setAge(19);
//        stu.setName("spider Man");
//        stu.setStuId(1004L);
//        stu.setMoney(18.8f);
//        stu.setSign("i am spider man");
//        stu.setDesc("i am save man");
//        stu.setBirthday(LocalDateTime.now());
//            restTemplate.save(stu);
//
//        IndexQuery build = new IndexQueryBuilder()
//                .withId(stu.getStuId().toString())
//                .withObject(stu)
//                .build();
        final IndexOperations indexOperations = elasticsearchOperations.indexOps(Stu.class);
        if (!indexOperations.exists()) {
            indexOperations.create();
            Document mapping = indexOperations.createMapping(Stu.class);
            indexOperations.putMapping(mapping);
        }
    }
}