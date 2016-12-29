package com.avasojo.controller;

import java.util.Date;

import com.avasojo.entity.Login;

public class ChatRoomController {
   public static void showMessage(Login user, String message){
      System.out.println(new Date().toString() + " [" + user.getLoginName() + "] : " + message);
   }
}