/**
 * 
 */
package com.avasojo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.avasojo.interfaces.LoginRespository;
import com.avasojo.entity.Login;

/**
 * @author Avasojo
 *
 */
@Component
public class LoginCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... arg0) throws Exception {
		
		for (Login b : this.LoginRespository.findAll()) {
			System.out.println("Login = " + b.toString());
		}
		
	}
	
	@Autowired LoginRespository LoginRespository ;
	
}
