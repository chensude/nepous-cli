package com.nepous.provider.web;



import com.nepous.TpcFeignClientApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UacTestController   {


    @Autowired
    private TpcFeignClientApi tpcFeignClient;
    @GetMapping("/test")
    public String getTest(){
        return tpcFeignClient.getTpcTest();
    }
}

