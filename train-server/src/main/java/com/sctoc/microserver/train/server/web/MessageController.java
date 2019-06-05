package com.sctoc.microserver.train.server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sctoc.microserver.train.server.service.MsgProcessor;

@RestController
@RequestMapping("/server")
public class MessageController{

	@Autowired MsgProcessor msgProcessor;
	
	@RequestMapping(value="/transAcct",method = RequestMethod.GET)
	public String transAcct(@RequestParam("amt") String amt){
		msgProcessor.send(amt);
		StringBuilder result = new StringBuilder();
		result.append("工行到农行跨行转账成功，金额为：");
		result.append(amt);
		return result.toString();
	}
	
	@RequestMapping(value="/queryBal",method = RequestMethod.GET)
	String queryBal() {
		StringBuilder result = new StringBuilder();
		result.append("在工行ATM机上查询农行账号余额：1000元。");
		return result.toString();
	}
}
