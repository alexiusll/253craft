package com.linkenzone.craft253.mapper;

import com.linkenzone.craft253.entities.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> selectByPage(@Param("column")String column, @Param("value") String value, @Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

    int selectTotalCountByColumn(@Param("column")String column, @Param("value") String value);

    int addVisit(Integer id);

    int addComment(Integer id);

    List<Article> selectByVisitRank(@Param("column")String column,@Param("value") String value,@Param("count") int count);
}