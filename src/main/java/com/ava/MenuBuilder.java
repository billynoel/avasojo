package com.ava;

import java.awt.Menu;

public void class MenuBuilder() { 
 
     public Menu buildMenu() { 
 
         Menu rootMenu = new Menu("rootMenu"); 
         rootMenu.add(createMenu("Home", "home.htm")); 
 
         Menu customerMenu = createMenu("Home", "home.htm"); 
         rootMenu.add(customerMenu); 
 
         customerMenu.add(createMenu("Search Customers", "search-customers.htm")); 
         customerMenu.add(createMenu("Edit Customer", "edit-customer.htm")); 
 
         ... 
 
         return rootMenu; 
     } 
 
     private Menu createMenu(String label, String path) { 
         Menu menu = new Menu(); 
         menu.setLabel(label); 
         menu.setPath(path); 
         menu.setTitle(label); 
         return menu; 
     } 
 }