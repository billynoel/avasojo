//package com.ava;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.ava.dao.UserDataDAO;
//import com.ava.model.UserDataEntity;
//
//public class AvaSojoTest 
//{
//    public static void main(String[] args)
//    {
//    	//
//    	// Find these classes !!!!!!!!!!!!!!!!!!!!!!!!!!!
//    	//
//    	ApplicationContext context = 
//    		new ClassPathXmlApplicationContext("Spring-Module.xml");
//    	 
//        UserDataDAO userDAO = (UserDataDAO) context.getBean("UserDataDAO");
//        UserDataEntity user = new UserDataEntity(1, "Billy Noel", "123 main", "Anywhere", "TN", "98765");
//        userDAO.insert(user);
//    	
//        UserDataEntity user1 = userDAO.findByUserId(1);
//        System.out.println(user1);
//        
//    }
//}