package com.ecom.homedecorfrontend.service;

import java.io.Serializable;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.webflow.execution.RequestContext;

import com.ecom.homedecorfrontend.dao.ShippingDAO;
import com.ecom.homedecorfrontend.models.ShippingAddress;




@Service
public class ShippingServices implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ShippingDAO shipDAO;
	public String addShippingAddress(ShippingAddress add, RequestContext context)
	{
		System.out.println("display"+add);
		
		HttpServletRequest request = (HttpServletRequest )context.getExternalContext().getNativeRequest();  
		shipDAO.addShippingAddress(add, request.getUserPrincipal());
		System.out.println(request.getUserPrincipal());
		return "success";
		
	}
}
