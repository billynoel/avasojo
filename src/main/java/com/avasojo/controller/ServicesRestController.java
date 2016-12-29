package com.avasojo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avasojo.interfaces.ServicesRespository;
import com.avasojo.entity.Services;

@RestController
public class ServicesRestController {
	
	@RequestMapping("/services")
	Collection<Services> services() {
		
		return this.servicesRespository.findAll();
	}
	@RequestMapping("/services/build")
	Collection<Services> buildSite() {
		
		return this.servicesRespository.findAll();
	}
	@RequestMapping("/services/destroy")
	Collection<Services> destroySite() {
		
		return this.servicesRespository.findAll();
	}

	@Autowired ServicesRespository servicesRespository ;

}
