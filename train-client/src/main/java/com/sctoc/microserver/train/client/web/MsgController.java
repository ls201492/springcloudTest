package com.sctoc.microserver.train.client.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sctoc.microserver.train.client.service.MsgService;

@RestController
@RequestMapping("/client")
public class MsgController {

  @Autowired
  MsgService msgService;

  @RequestMapping(value = "/transAcct", method = RequestMethod.GET)
  String transAcct(@RequestParam("amt") String amt) {
    return msgService.transAcct(amt);
  }

  @RequestMapping(value = "/queryBal", method = RequestMethod.GET)
  String queryBal() {
    return msgService.queryBal();
  }
}
