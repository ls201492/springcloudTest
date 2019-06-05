package com.sctoc.microserver.train.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * 服务端接收消息
* <p>Title: MsgProcessor</p>  
* <p>Description: </p>  
* @author ruan_mh  
* @date 2018年8月17日
 */
@Service
@EnableBinding(Processor.class)
public class MsgProcessor {
	
	private static Logger log = LoggerFactory.getLogger(MsgProcessor.class);
	
	@Autowired MessageChannel output;
	
	@StreamListener(target = Processor.INPUT)
    public void receiveClient(Message<String> msg){
    	try {
    		log.info("工行到农行转账成功，金额为：{}", msg.getPayload());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("工行到农行转账异常", e);
		}
    }
	
	public void send(String msg) {
		output.send(MessageBuilder.withPayload(msg).build());  
	}
	
}
