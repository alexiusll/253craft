package com.linkenzone.craft253.service.impl;

import com.linkenzone.craft253.entities.Comment;
import com.linkenzone.craft253.mapper.CommentMapper;
import com.linkenzone.craft253.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Comment record) {
        return commentMapper.insert(record);
    }

    @Override
    public Comment selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKey(Comment record) {
        return 0;
    }

    @Override
    public List<Comment> selectByArticleId(Integer articleId) {
        return commentMapper.selectByArticleId(articleId);
    }
}
