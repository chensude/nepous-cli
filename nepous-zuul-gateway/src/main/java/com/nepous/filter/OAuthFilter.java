package com.nepous.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

/**
 * 认证
 */
@Slf4j
//@Component
public class OAuthFilter extends ZuulFilter {

    private RestTemplate restTemplate= new RestTemplate();
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("oauth start");

        RequestContext requestContext = RequestContext.getCurrentContext();

        HttpServletRequest request = requestContext.getRequest();
        if(StringUtils.startsWith(request.getRequestURI(),"/oauth")) {
            return null;
        }

        String authorization = request.getHeader("Authorization");

        if(StringUtils.isBlank(authorization)) {
            return null;
        }

        if(!StringUtils.startsWithIgnoreCase(authorization,"bearer ")){
            return null;
        }

        try {
            TokenInfo info =getTokenInfo(authorization);
            request.setAttribute("tokenInfo",info);
        }catch (Exception e){
            log.error("get token info fail",e);
        }
        return null;
    }

    private TokenInfo getTokenInfo(String authorization) {

        String token = StringUtils.substringAfter(authorization,"bearer ");
        String oauthServiceUrl = "";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth("nepous-gateway","nepousGateway");
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("token",token);
        HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<>(params,headers);

        ResponseEntity<TokenInfo> responseEntity = restTemplate.exchange(oauthServiceUrl, HttpMethod.POST,entity,TokenInfo.class);

        log.info("token info:"+ responseEntity.getBody().toString());
        return responseEntity.getBody();
    }
}
