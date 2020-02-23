package com.nepous.web;

import com.nepous.TpcFeignClientApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TpcFeignClientImpl implements TpcFeignClientApi {
    @Override
    public String getTpcTest() {
        return "GetTpcTest";
    }
}
