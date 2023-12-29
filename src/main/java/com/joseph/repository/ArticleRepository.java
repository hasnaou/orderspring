package com.joseph.repository;

import com.joseph.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("articleRepository")
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Optional<Article> findByLibelle(String libelle);
}
