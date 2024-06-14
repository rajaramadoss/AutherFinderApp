package com.stackroute.apigateway.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Routeconfig {
    @Bean
    public RouteLocator customLocator(RouteLocatorBuilder builder)
    {
        return builder.routes()

                .route("userprofile-service", r -> r.path("/api/v1.0/userProfile/**")
                        .uri("http://localhost:9193"))
                .route("authentication-service", r -> r.path("/api/**")
                        .uri("http://localhost:9197"))
                .route("auther-service", r -> r.path("/api/v1.0/autherservice/**")
                        .uri("http://localhost:9194"))
                .route("wishlist-service", r -> r.path("/api/v1.0/wishList/**")
                        .uri("http://localhost:9195")).build();
    }

}
