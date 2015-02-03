package com.tutorialspoint.struts2;

import java.util.*; 

import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldActionMap extends ActionSupport{
   private String name;

   public String execute() throws Exception {
      ValueStack stack = ActionContext.getContext().getValueStack();
      Map<String, Object> context = new HashMap<String, Object>();

      context.put("key1", this.name); 
      context.put("key2", this.name);
      stack.push(context);

      System.out.println("Size of the valueStack: " + stack.size());
      return "success";
   }  

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}