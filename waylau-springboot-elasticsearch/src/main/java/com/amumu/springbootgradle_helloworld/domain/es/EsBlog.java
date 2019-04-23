package com.amumu.springbootgradle_helloworld.domain.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @Author: amumu
 * @Date: 2019/4/21 0021 上午 12:06
 * @Version 1.0
 */

// @Document 标识这是文档
// 此处 indexName 为索引, type 为 类型
@Document(indexName = "blog", type = "blog")
public class EsBlog implements Serializable {
    @Id //主键
    private String id;      //ID
    private String title;   //标题
    private String summary; //摘要
    private String content; //内容

    protected EsBlog() { //JPA的要求，防止直接使用
    }

    public EsBlog(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    //get set

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "EsBlog{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
