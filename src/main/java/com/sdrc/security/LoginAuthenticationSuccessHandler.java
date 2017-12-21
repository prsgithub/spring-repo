/**
 * Copyright © NIC. All rights reserved.

 *
 * This software is the confidential and proprietary information 
 * of NIC.You shall not disclose such Confidential Information and 
 * shall use it only in accordance with the terms and conditions 
 * entered into with NIC.
 *
 * Id: LoginAuthenticationSuccessHandler.java,v 1.1
 *
 * Date Author Changes
 * Jul 29, 2017, 11:26:26 PM  prakash Created
 */
package com.sdrc.security;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Component("authenticationSuccessHandler")
public class LoginAuthenticationSuccessHandler  implements AuthenticationSuccessHandler 
{
    protected Log logger = LogFactory.getLog(this.getClass());
    
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
 
    public void onAuthenticationSuccess(HttpServletRequest request,HttpServletResponse response, Authentication authentication)throws IOException 
    {
    	System.out.println("authentication.getDetails()= "+authentication.getDetails());
    	System.out.println("authentication.getPrincipal()= "+authentication.getPrincipal());
    	System.out.println("authentication.getAuthorities()= "+authentication.getAuthorities());
    	
    	redirectStrategy.sendRedirect(request, response, "/loginSuccess");
    }
 
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}