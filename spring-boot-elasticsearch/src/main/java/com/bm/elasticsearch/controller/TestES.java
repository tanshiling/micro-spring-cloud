package com.bm.elasticsearch.controller;

import com.bm.elasticsearch.entity.User;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version V1.0
 * @Title: TestES
 * @Package com.bm.elasticsearch.controller
 * @Description: TODO()
 * @author: 北明软件
 * @date: 2018/10/14 17:24
 */
@RestController
@RequestMapping("/es")
public class TestES {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @RequestMapping("/testEs")
    public String useEs(){

        //构造搜索条件
        QueryBuilder queryBuilder = QueryBuilders.existsQuery("name");

        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();

        List<User> list = elasticsearchTemplate.queryForList(searchQuery, User.class);

        for (User user:list) {
            System.out.println(user);
        }
        return "ok";
    }
}
