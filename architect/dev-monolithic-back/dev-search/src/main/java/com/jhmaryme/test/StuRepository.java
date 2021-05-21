package com.jhmaryme.test;


import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.annotations.Highlight;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.annotations.HighlightParameters;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 *
 * @author JiaHao Wang
 * @date 2021/5/21 16:56
 */
public interface StuRepository extends ElasticsearchRepository<Stu, Long> {
    @Highlight(
            fields = {
                    @HighlightField(name = "name"),
                    @HighlightField(name = "age")
            },
            parameters = @HighlightParameters(
                    preTags = "<strong><font style='color:red'>",
                    postTags = "</font></strong>"
            )

    )
    List<SearchHit<Stu>> findByNameOrAge(String name, int age);


}
