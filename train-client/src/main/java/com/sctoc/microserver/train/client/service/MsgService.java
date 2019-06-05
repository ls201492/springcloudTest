package com.sctoc.microserver.train.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sctoc.microserver.train.client.service.feign.IFeignMessageService;


@Service
public class MsgService {

  @Autowired
  private IFeignMessageService messageService;

  public String transAcct(String amt) {
    return messageService.transAcct(amt);
  }

  public String queryBal() {
    return messageService.queryBal();
  }
}
