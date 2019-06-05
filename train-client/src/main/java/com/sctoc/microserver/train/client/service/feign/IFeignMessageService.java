package com.sctoc.microserver.train.client.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("TRAIN-SERVER")
public interface IFeignMessageService {
	
	@RequestMapping(value="/server/transAcct",method = RequestMethod.GET)
	String transAcct(@RequestParam("amt") String amt);
	
	@RequestMapping(value="/server/queryBal",method = RequestMethod.GET)
	String queryBal();
}
