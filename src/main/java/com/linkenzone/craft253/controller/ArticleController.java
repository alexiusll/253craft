package com.linkenzone.craft253.controller;

import com.linkenzone.craft253.entities.Article;
import com.linkenzone.craft253.entities.Comment;
import com.linkenzone.craft253.service.IArticleService;
import com.linkenzone.craft253.service.ICommentService;
import com.linkenzone.craft253.service.impl.ArticleServiceImpl;
import com.linkenzone.craft253.service.impl.CommentServiceImpl;
import com.linkenzone.craft253.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private IArticleService articleService = new ArticleServiceImpl();

    @Autowired
    private ICommentService commentService = new CommentServiceImpl();

    //每页显示的文章总数
    int pageSize = 5;

    @GetMapping("/arts/{currentPage}")
    public String getArticlesByPage(@PathVariable("currentPage") int currentPage, Model model){
        List<Article> articles = articleService.selectByPage("sort","article",currentPage,pageSize);
        int totalCount = articleService.selectTotalCountByColumn("sort","article");
        List<Article> articlesRank = articleService.selectByVisitRank("sort","article",5);
        int totalPageCount = totalCount/pageSize + 1;
        model.addAttribute("arts",articles);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPageCount",totalPageCount);
        model.addAttribute("articlesRank",articlesRank);
        return "articleList";
    }

    @GetMapping("/art/{id}")
    public String getArticleById(@PathVariable("id") Integer id, Model model){
        //增加观看数
        articleService.addVisit(id);
        Article article = articleService.selectByPrimaryKey(id);
        List<Comment> comments = commentService.selectByArticleId(id);
        model.addAttribute("article",article);
        model.addAttribute("comments",comments);
        return "article";
    }

}
