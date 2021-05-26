package com.jhmaryme.test;

import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author JiaHao Wang
 * @date 2021/5/26 10:12
 */
public class SearchHitSupport {

    public static <T> List<T> unwrapSearchHits(SearchHits<T> searchHits) {
        return searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
    }
}
