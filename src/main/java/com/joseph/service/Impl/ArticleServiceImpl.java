package com.joseph.service.Impl;

import com.joseph.entity.Article;
import com.joseph.repository.ArticleRepository;
import com.joseph.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }



    @Override
    public Article getArticleById(int id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        return optionalArticle.orElse(null);
    }

    @Override
    public void editArticle(Article editedArticle) {
        if (editedArticle.getId() > 0) {
            // Check if the article with the given ID exists in the repository
            Optional<Article> existingArticle = articleRepository.findById(editedArticle.getId());

            if (existingArticle.isPresent()) {
                // Article exists, update its details
                Article foundArticle = existingArticle.get();
                foundArticle.setLibelle(editedArticle.getLibelle());
                foundArticle.setQuantity(editedArticle.getQuantity());

                // Save the updated article
                articleRepository.save(foundArticle);
            }
        }
    }

    @Override
    public void addArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void deleteArticle(int articleId) {
        articleRepository.deleteById(articleId);
    }
}
