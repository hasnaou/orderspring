package com.joseph.web;

import com.joseph.entity.Article;
import com.joseph.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    public String showArticleList(Model theModel) {
        List<Article> articles = articleService.getArticles();
        theModel.addAttribute("articles", articles);
        return "article-form";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("article", new Article());
        return "article-add";
    }

    @PostMapping("/add")
    public String addArticle(@RequestParam("libelle") String libelle, @RequestParam("quantity") int quantity) {
        Article article = new Article(libelle, quantity);
        articleService.addArticle(article);
        return "redirect:/article/list"; // Redirect to the article list page
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") int articleId, Model model) {
        Article article = articleService.getArticleById(articleId);
        model.addAttribute("article", article);
        return "article-edit";
    }

    @PostMapping("/edit")
    public String editArticle(@ModelAttribute("article") Article editedArticle) {
        articleService.editArticle(editedArticle);
        return "redirect:/article/list";  // Redirect to the article list page
    }

    @GetMapping("/delete")
    public String deleteArticle(@RequestParam("id") int articleId) {
        articleService.deleteArticle(articleId);
        return "redirect:/article/list";
    }
}
