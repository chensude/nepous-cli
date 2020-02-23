package com.nepous.hystrix;

import com.nepous.TpcFeignClientApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TpcFeignClientApiHystrix implements TpcFeignClientApi{


    @Override
    public String getTpcTest() {
        return "稍后重试";
    }
}
