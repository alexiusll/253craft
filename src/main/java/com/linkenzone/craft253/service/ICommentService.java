package com.linkenzone.craft253.service;

import com.linkenzone.craft253.entities.Comment;

import java.util.List;

public interface ICommentService {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    //int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    //int updateByPrimaryKeySelective(Comment record);

    //int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> selectByArticleId(Integer articleId);
}
