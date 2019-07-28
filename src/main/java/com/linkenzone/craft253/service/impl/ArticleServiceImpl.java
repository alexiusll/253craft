package com.linkenzone.craft253.service.impl;

import com.linkenzone.craft253.entities.Article;
import com.linkenzone.craft253.mapper.ArticleMapper;
import com.linkenzone.craft253.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Article record) {
        return articleMapper.insert(record);
    }

    @Override
    public Article selectByPrimaryKey(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Article record) {
        return articleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Article> selectByPage(String column, String value, int currentPage, int pageSize) {
        return articleMapper.selectByPage(column,value,currentPage,pageSize);
    }

    @Override
    public int selectTotalCountByColumn(String column, String value) {
        return articleMapper.selectTotalCountByColumn(column,value);
    }

    @Override
    public List<Article> selectByVisitRank(String column, String value, int count) {
        return articleMapper.selectByVisitRank(column,value,count);
    }

    @Override
    public int addVisit(Integer id) {
        return articleMapper.addVisit(id);
    }

    @Override
    public int addComment(Integer id) {
        return articleMapper.addComment(id);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Article record) {
        return articleMapper.updateByPrimaryKeyWithBLOBs(record);
    }
}
