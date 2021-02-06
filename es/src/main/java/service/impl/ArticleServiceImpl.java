package service.impl;

import dao.ArticleRepository;
import demain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    public void save(Article article) {
        articleRepository.save(article);
    }
}
