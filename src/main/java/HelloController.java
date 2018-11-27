import java.util.List;

@RestController

public class HelloController {

    @RequestMapping
    public String sayHi(){
        return "Hi";

    }
package com.concretepage.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.concretepage.dao.IArticleDAO;
import com.concretepage.entity.Article;
    @Service
    public class ArticleService implements IArticleService {
        @Autowired
        private IArticleDAO articleDAO;
        @Override
        public article.Article getArticleById(int articleId) {
            article.Article obj = articleDAO.getArticleById(articleId);
            return obj;
        }
        @Override
        public List<article.Article> getAllArticles(){
            return articleDAO.getAllArticles();
        }
        @Override
        public synchronized boolean createArticle(Article article){
            if (articleDAO.articleExists(article.getTitle(), article.getCategory())) {
                return false;
            } else {
                articleDAO.createArticle(article);
                return true;
            }
        }
        @Override
        public void updateArticle(Article article) {
            articleDAO.updateArticle(article);
        }
        @Override
        public void deleteArticle(int articleId) {
            articleDAO.deleteArticle(articleId);
        }
    }
}
