package com.zq.filter;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.mall.common.exception.ApiException;
import com.mall.common.exception.EnumCode;
import com.zq.config.IgnoreUrlsConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Component
@Slf4j
public class AuthGlobalFilter implements GlobalFilter, Ordered {
    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;

    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        //防止 OPTIONS 请求直接放行
        if (request.getMethod().equals(HttpMethod.OPTIONS)) {
            return chain.filter(exchange);
        }
        //白名单请求直接放行
        PathMatcher pathMatcher = new AntPathMatcher();
        for (String path : ignoreUrlsConfig.getUrls()) {
            if (pathMatcher.match("/**" + path, request.getPath().toString())) {
                return chain.filter(exchange);
            }
        }
        // token 验证
        String token = request.getHeaders().getFirst("tokenHeader");
        if (StringUtils.isBlank(token)){
            log.info("token = {}",token);
            try {
                throw new ApiException(EnumCode.PARAM_ERROR.getCode(),EnumCode.PARAM_ERROR.getMsg());
            } catch (ApiException e) {
                throw new RuntimeException(e);
            }
        }
//        String username = jwtTokenUtil.getUserNameFromToken(token);
        // 待抽离
//        String key = REDIS_DATABASE + ":" + REDIS_KEY_TOKEN + ":" + username;
//        String resultToken = stringRedisTemplate.opsForValue().get(key);
        if (StringUtils.isBlank(token)) {
            log.error("resultToken = {}",token);
            try {
                throw new ApiException(EnumCode.PARAM_ERROR.getCode(),EnumCode.PARAM_ERROR.getMsg());
            } catch (ApiException e) {
                throw new RuntimeException(e);
            }

        }
        log.error("resultToken = {}",token);
        return chain.filter(exchange);
    }

    public int getOrder() {
        return -1;
    }
}
