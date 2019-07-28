package com.linkenzone.craft253.controller;

import com.linkenzone.craft253.entities.Article;
import com.linkenzone.craft253.service.IArticleService;
import com.linkenzone.craft253.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class newsController {
    @Autowired
    private IArticleService articleService = new ArticleServiceImpl();

    //每页显示的新闻总数
    int pageSize = 5;

    @GetMapping("/news/{currentPage}")
    public String getArticlesByPage(@PathVariable("currentPage") int currentPage, Model model){
        List<Article> articles = articleService.selectByPage("sort","news",currentPage,pageSize);
        int totalCount = articleService.selectTotalCountByColumn("sort","news");
        List<Article> articlesRank = articleService.selectByVisitRank("sort","news",5);
        int totalPageCount = totalCount/pageSize + 1;
        model.addAttribute("arts",articles);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPageCount",totalPageCount);
        model.addAttribute("articlesRank",articlesRank);
        return "newsList";
    }
}
