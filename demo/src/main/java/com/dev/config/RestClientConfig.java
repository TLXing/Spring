package com.dev.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestClientConfig {

    @Value("${elasticsearch.ip}")
    private String ip;
    @Value("${elasticsearch.port}")
    private int port;

    @Bean
    public RestHighLevelClient restHighLevelClient(){
        RestClientBuilder restClient =  RestClient.builder(new HttpHost(ip,port,"http"));
        return new RestHighLevelClient(restClient);
    }


}
