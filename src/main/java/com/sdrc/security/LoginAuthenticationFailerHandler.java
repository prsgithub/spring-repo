/**
 * Copyright © NIC. All rights reserved.

 *
 * This software is the confidential and proprietary information 
 * of NIC.You shall not disclose such Confidential Information and 
 * shall use it only in accordance with the terms and conditions 
 * entered into with NIC.
 *
 * Id: LoginAuthenticationFailerHandler.java,v 1.1
 *
 * Date Author Changes
 * Jul 29, 2017, 11:26:17 PM  prakash Created
 */
package com.sdrc.security;
import java.io.IOException;





import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sdrc.repository.LoginRepository;

@Component("authenticationFailerHandler")
public class LoginAuthenticationFailerHandler  extends  SimpleUrlAuthenticationFailureHandler  
{
    protected Log logger = LogFactory.getLog(this.getClass());
    
    public void onAuthenticationFailure(HttpServletRequest request,HttpServletResponse response, AuthenticationException exception)throws IOException, ServletException 
    {
    	super.onAuthenticationFailure(request, response, exception);
    	exception.printStackTrace();
    }
}