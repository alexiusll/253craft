package com.linkenzone.craft253.entities;

import com.linkenzone.craft253.util.DateUtils;

import java.util.Date;

public class Comment {
    private Integer id;

    private Integer articleId;

    private String nickname;

    private Date time;

    private String content;

    public Comment(Integer id, Integer articleId, String nickname, Date time, String content) {
        this.id = id;
        this.articleId = articleId;
        this.nickname = nickname;
        this.time = time;
        this.content = content;
    }

    public Comment(Integer articleId, String nickname, Date time, String content) {
        this.articleId = articleId;
        this.nickname = nickname;
        this.time = time;
        this.content = content;
    }

    public Comment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}