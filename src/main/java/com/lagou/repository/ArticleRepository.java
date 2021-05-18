package com.lagou.repository;

import com.lagou.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author admin
 * @version 1.0.0
 * @ClassName CommentRepository.java
 * @Description TODO
 * @createTime 2021年05月18日 10:33:00
 */
public interface ArticleRepository extends JpaRepository<Article,Integer> {
}
