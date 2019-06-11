package com.sctoc.microserver.train.client.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sctoc.microserver.train.client.service.MsgService;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
public class MsgController {

  @Autowired
  MsgService msgService;

  //请求熔断注解，当服务出现问题时候会执行fallbackMetho属性的名为helloFallBack的方法  参数类型需要一致
  @HystrixCommand(fallbackMethod = "helloFallback")
  @RequestMapping(value = "/transAcct", method = RequestMethod.GET)
  String transAcct(@RequestParam("amt") String amt) {
    return msgService.transAcct(amt);
  }

  String helloFallback(@RequestParam("amt") String amt) {
    return msgService.queryBal();
  }
}
