package com.sdrc.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdrc.model.UserDetails;


@Controller
public class UserController 
{
	
	@RequestMapping("/tilesPage")
	String home() {
		return "app.homepage";
	}
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String loadLoginPage() 
    {
        return "app.loginpage";
    }
	
	@RequestMapping(value = { "/403error" }, method = RequestMethod.GET)
    public String accessDeniedPage() 
    {
        return "app.403errorpage";
    }
	
	@RequestMapping(value = { "loginSuccess" }, method = RequestMethod.GET)
    public String loadLoginSuccessPage(Model model) 
    {
		model.addAttribute("users",userDetailsList);
        return "app.userpage";
    }
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String loadIndexPage()
	{
		return "app.loginpage";//"redirect:/login";
	}
	
	
	
	
	public List<UserDetails> userDetailsList = new ArrayList<UserDetails>();
    
    //public LoginUser loginDetails=new LoginUser();
    
    public UserController()
    {
        userDetailsList.add(new UserDetails("User1", "Mechanical"));
        userDetailsList.add(new UserDetails("User2", "Electrical"));
        //loginDetails.setId("prs");
        //loginDetails.setPassword("prs");
    }
    @RequestMapping(value="/userdetails",method=RequestMethod.GET,produces="application/json")
    public List<UserDetails> GetUserdetails()
    {
        return userDetailsList;
    }
    
    @RequestMapping(value="user",consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public @ResponseBody List<UserDetails> ProcessUser(@RequestBody UserDetails userDetails)
    {
    	System.out.println("ProcessUser    userDetails= "+userDetails);
        boolean nameExist = false;
        
        for(UserDetails ud : userDetailsList)
        {
            if(ud.getName().equals(userDetails.getName()))
            {
                nameExist = true;
                ud.setDepartment(userDetails.getDepartment());
                break;
            }
        }
        if(!nameExist)
        {
            userDetailsList.add(userDetails);
        }
        System.out.println("ProcessUser    userDetailsList= "+userDetailsList);
        return userDetailsList;
    }
    
    @RequestMapping(value="/deleteuser",consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity DeleteUser(@RequestBody UserDetails userDetails)
    {
        Iterator<UserDetails> it = userDetailsList.iterator();
        while(it.hasNext())
        {
            UserDetails ud = (UserDetails) it.next();
            if(ud.getName().equals(userDetails.getName()))
                it.remove();
        }
        return new ResponseEntity(HttpStatus.OK);
    }

}
