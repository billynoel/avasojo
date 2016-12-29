/**
 * 
 */
package com.avasojo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.avasojo.interfaces.ServicesRespository;
import com.avasojo.entity.Services;

/**
 * @author Avasojo
 *
 */
@Component
public class ServicesCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... arg0) throws Exception {
		
		for (Services b : this.servicesRespository.findAll()) {
			System.out.println("Services = " + b.toString());
		}
		
	}
	
	@Autowired ServicesRespository servicesRespository ;
	
}
