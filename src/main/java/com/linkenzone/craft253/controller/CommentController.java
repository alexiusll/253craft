package com.linkenzone.craft253.controller;

import com.linkenzone.craft253.entities.Comment;
import com.linkenzone.craft253.mapper.CommentMapper;
import com.linkenzone.craft253.service.IArticleService;
import com.linkenzone.craft253.service.ICommentService;
import com.linkenzone.craft253.service.impl.ArticleServiceImpl;
import com.linkenzone.craft253.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class CommentController {

    @Autowired
    ICommentService commentService = new CommentServiceImpl();

    @Autowired
    IArticleService articleService = new ArticleServiceImpl();

    @PostMapping(value = "/addComment")
    public String addComment(@RequestParam("articleId") Integer articleId ,
                             @RequestParam("nickname") String nickname,
                             @RequestParam("content") String content,
                             HttpServletResponse response,
                             HttpServletRequest request){
        String cookie_name = "comment_cookie" + articleId;
        String info = null; // 返回的信息
        boolean isRpeat = false;         // 判断是否恶意提交

        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie c : cookies){
                if (c.getName().equals(cookie_name)) {
                    isRpeat = true;
                    break;
                }
            }
        }
        if(!isRpeat){
            //获取当前的时间
            Date date = new Date();
            Comment comment = new Comment(articleId,nickname,date,content);
            if(commentService.insert(comment) != 0){
                info = "success";
                articleService.addComment(articleId);
                // 发送新的cookie
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
                Cookie c = new Cookie(cookie_name,df.format(new Date()));
                c.setPath("/253craft");
                response.addCookie(c);
            }else {
                info = "failed";
            }
        }else {
            info = "repeat";
        }
        return "redirect:/art/" + articleId + "?info=" + info;
    }
}
