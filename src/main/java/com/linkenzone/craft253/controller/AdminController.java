package com.linkenzone.craft253.controller;

import com.linkenzone.craft253.entities.Article;
import com.linkenzone.craft253.service.IArticleService;
import com.linkenzone.craft253.service.impl.ArticleServiceImpl;
import com.linkenzone.craft253.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private IArticleService articleService = new ArticleServiceImpl();

    //每页显示的文章总数
    int pageSize = 5;

    @GetMapping("/admin")
    public String AdminPage(@RequestParam("currentPage") Integer currentPage,
                            @RequestParam("sort") String sort,
                            Model model){
        List<Article> articles = articleService.selectByPage("sort",sort,currentPage,pageSize);
        int totalCount = articleService.selectTotalCountByColumn("sort",sort);
        int totalPageCount = totalCount/pageSize + 1;
        model.addAttribute("arts",articles);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPageCount",totalPageCount);
        model.addAttribute("sort",sort);
        return "admin/main";
    }

    /**
     * 来到增加文章页面
     *
     * @param model
     * @return
     */
    @GetMapping("/admin/newArticle")
    public String newArticle(Model model){
        Date date = new Date();
        model.addAttribute("time",date);
        return "admin/addArticle";
    }

    @GetMapping("/admin/updateArticle/{id}")
    public String updateArticle(@PathVariable("id") Integer id, Model model){
        Article article = articleService.selectByPrimaryKey(id);
        model.addAttribute("art",article);
        return "admin/updateArticle";
    }

    /**
     * 增加新的文章
     * @param title
     * @param time
     * @param author
     * @param content
     * @param sort
     * @return
     */
    @PostMapping("/admin/art")
    public String addArticle(@RequestParam("title") String title,
                             @RequestParam("time") String time,
                             @RequestParam("author") String author,
                             @RequestParam("mdView-markdown-doc") String content,
                             @RequestParam("sort") String sort){
        Article article = new Article(title,author,sort,time,0,0,content);
        articleService.insert(article);
        return "redirect:/admin?currentPage=1&sort=article";
    }

    /**
     * 修改文章
     *
     * @param id
     * @param title
     * @param time
     * @param author
     * @param visit
     * @param comment
     * @param content
     * @param sort
     * @return
     */
    @PutMapping("/admin/art")
    public String updateArticle(@RequestParam("id") Integer id,
                                @RequestParam("title") String title,
                                @RequestParam("time") String time,
                                @RequestParam("author") String author,
                                @RequestParam("visit") Integer visit,
                                @RequestParam("comment") Integer comment,
                                @RequestParam("mdView-markdown-doc") String content,
                                @RequestParam("sort") String sort){
        Date date = DateUtils.getDate(time);
        Article article = new Article(id,title,author,sort,date,visit,comment,content);
        articleService.updateByPrimaryKeyWithBLOBs(article);
        return "redirect:/admin?currentPage=1&sort=article";
    }

    @DeleteMapping("/admin/art/{id}")
    public String deleteArticle(@PathVariable("id") Integer id){
        articleService.deleteByPrimaryKey(id);
        return "redirect:/admin?currentPage=1&sort=article";
    }

}
