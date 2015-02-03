package com.tutorialspoint.struts2;

public class HelloWorldAction{
   private String name;
   private String age;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String execute() throws Exception {
		System.out.println(name+age);
		return "success2";
	}

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}