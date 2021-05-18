package com.lagou.service;

import com.lagou.pojo.Article;
import com.lagou.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ArticleService.java
 * @Description TODO
 * @createTime 2021年05月19日 01:54:00
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> findAll(){
        return articleRepository.findAll();
    }

    public Page<Article> findAll(int pageNum, int pageSize){
        Sort.Order order=new Sort.Order(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(order));
        return articleRepository.findAll(pageable);
    }
}
