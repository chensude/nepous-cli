package com.nepous;

import com.nepous.hystrix.TpcFeignClientApiHystrix;
import com.nepous.security.fegin.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "nepous-provider-tpc",configuration = OAuth2FeignAutoConfiguration.class,fallback = TpcFeignClientApiHystrix.class)
public interface TpcFeignClientApi {

    @GetMapping("/test")
    String getTpcTest();
}
