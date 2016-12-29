package com.avasojo;
/**
 * @author Avasojo
 *
 */
import org.springframework.context.annotation.*;

@Configuration
public class AvasojoConfig {

   @Bean 
   public AvasojoError avasojoError(){
      return new AvasojoError();
   }
}