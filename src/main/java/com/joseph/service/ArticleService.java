package com.joseph.service;

import com.joseph.entity.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getArticles();

    public Article getArticleById(int id);
    public void editArticle(Article editedArticle);

    void deleteArticle(int articleId);

    void addArticle(Article article);
}
