package com.niit.collaborationbackend.controller;



import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.collaborationbackend.model.Message;
import com.niit.collaborationbackend.model.OutputMessage;



@Controller
public class MessageController {

		  @MessageMapping("/chat")
	      @SendTo("/topic/message")
	      
	      public OutputMessage sendMessage(Message message)//,Principal principal)
	      {
	    //	  System.out.println(principal.getName());
	    	  return new OutputMessage(message,new Date());//,principal.getName());
	      }
	
	}

