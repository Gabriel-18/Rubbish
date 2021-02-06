package dao;

import demain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, Integer> {

}