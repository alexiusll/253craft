package com.linkenzone.craft253.service;

import com.linkenzone.craft253.entities.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IArticleService {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    //int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    //int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> selectByPage(String column, String value, int currentPage, int pageSize);

    int selectTotalCountByColumn(String column,String value);

    List<Article> selectByVisitRank(String column, String value, int count);

    int addVisit(Integer id);

    int addComment(Integer id);
}
