package com.ecom.homedecorfrontend.service;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.webflow.execution.RequestContext;

import com.ecom.homedecorfrontend.dao.CardDetailDAO;
import com.ecom.homedecorfrontend.models.CardDetails;

@Service
public class CardDetailService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
    private CardDetailDAO cardDetailDao;

    public String addCardDetail (CardDetails cardDetail,RequestContext context) {
    	System.out.println("card"+cardDetailDao);
    	
    	HttpServletRequest request = (HttpServletRequest )context.getExternalContext().getNativeRequest();  
    	
    	cardDetailDao.addCardDetail(cardDetail, request.getUserPrincipal());
    	
    	return "success";
    }


}
