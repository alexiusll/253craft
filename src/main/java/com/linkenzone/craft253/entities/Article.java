package com.linkenzone.craft253.entities;

import com.linkenzone.craft253.util.DateUtils;

import java.util.Date;

public class Article {
    private Integer id;

    private String title;

    private String author;

    private String sort;

    private Date time;

    private Integer visit;

    private Integer comment;

    private String content;

    public Article(Integer id, String title, String author, String sort, Date time, Integer visit, Integer comment, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.sort = sort;
        this.time = time;
        this.visit = visit;
        this.comment = comment;
        this.content = content;
    }

    public Article(String title, String author, String sort, Date time, Integer visit, Integer comment, String content) {
        this.title = title;
        this.author = author;
        this.sort = sort;
        this.time = time;
        this.visit = visit;
        this.comment = comment;
        this.content = content;
    }

    public Article(String title, String author, String sort, String time, Integer visit, Integer comment, String content) {
        this.title = title;
        this.author = author;
        this.sort = sort;
        this.time = DateUtils.getDate(time);
        this.visit = visit;
        this.comment = comment;
        this.content = content;
    }


    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", sort='" + sort + '\'' +
                ", time=" + time +
                ", visit=" + visit +
                ", comment=" + comment +
                ", content='" + content + '\'' +
                '}';
    }

    public Article() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public Date getTime() {
        return time;
    }

    public String getTimeString() {
        return DateUtils.getFormatDate(time);
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getVisit() {
        return visit;
    }

    public void setVisit(Integer visit) {
        this.visit = visit;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}