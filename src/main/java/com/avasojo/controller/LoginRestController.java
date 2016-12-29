package com.avasojo.controller;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avasojo.interfaces.ServicesRespository;
import com.avasojo.entity.Services;

@RestController
public class LoginRestController {
	
	@RequestMapping("/login")
	Collection<Services> services() {
		
		return this.loginRespository.findAll();
	}
	@RequestMapping("/login/add")
	Collection<Services> buildSite() {
		
		return this.loginRespository.findAll();
	}
	@RequestMapping("/login/delete")
	Collection<Services> destroySite() {
		
		return this.loginRespository.findAll();
	}

	@Autowired ServicesRespository loginRespository ;

}
