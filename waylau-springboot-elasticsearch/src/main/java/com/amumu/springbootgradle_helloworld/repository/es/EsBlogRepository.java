package com.amumu.springbootgradle_helloworld.repository.es;

import com.amumu.springbootgradle_helloworld.domain.User;
import com.amumu.springbootgradle_helloworld.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * EsBlog Repository 接口
 *
 * @Author: amumu
 * @Date: 2019/4/21 0021 上午 12:14
 * @Version 1.0
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {
    //根据关键字搜索，title summary content 都会被搜索
    //不用写SQL

    /**
     * 分页查询博客(去重)
     *
     * @param title    标题
     * @param summary  摘要
     * @param content  内容
     * @param pageable 分页对象
     * @return
     */
    Page<EsBlog> findDistinctByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);
    //Distinct就是去重的意思
}
