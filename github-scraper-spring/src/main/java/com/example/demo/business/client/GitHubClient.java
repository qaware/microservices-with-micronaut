package com.example.demo.business.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("github")
public interface GitHubClient {
    @GetMapping(value = "/search/repositories?q=stars:%3E0&sort=stars&per_page=10", consumes = MediaType.APPLICATION_JSON_VALUE, headers = "User-Agent: Micronaut Spring Demo 0.0.1")
    ResultsDto fetchProjectsWithStars();
}
