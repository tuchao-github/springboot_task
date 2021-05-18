package com.lagou.springboot04_thymeleaf;

import com.lagou.pojo.Article;
import com.lagou.repository.ArticleRepository;
import com.lagou.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class Springboot04ThymeleafApplicationTests {

    @Autowired
    private ArticleRepository articleRepository;

    /**测试jpa*/
    @Test
    public void repositoryTest() throws Exception {
        List<Article> all = articleRepository.findAll();
        for (Article article : all) {
            System.out.println(article);
        }
    }



    @Autowired
    private ArticleService articleService;

    /**测试service*/
    @Test
    public void serviceTest() throws Exception {
        List<Article> all = articleService.findAll();
        for (Article article : all) {
            System.out.println(article);
        }
    }

    /**测试分页*/
    @Test
    public void servicePageTest() throws Exception {
        int pageNum = 0;
        int pageSize = 3;
        Sort.Order order=new Sort.Order(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(order));
        Page<Article> articlePage = articleRepository.findAll(pageable);
        for (Article article : articlePage) {
            System.out.println(article);
        }
    }

}
