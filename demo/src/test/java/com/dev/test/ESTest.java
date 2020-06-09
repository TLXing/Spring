package com.dev.test;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;

@SpringBootTest
public class ESTest {

    @Resource
    RestHighLevelClient restHighLevelClient;

    @Test
    void Test01(){
        IndexRequest request = new IndexRequest("posts","doc","1");
        String jsonString = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        request.source(jsonString, XContentType.JSON);
        try {
            IndexResponse response = restHighLevelClient.index(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
