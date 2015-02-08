<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hello World</title>
</head>
<body>
   <h1>Hello World From Struts2</h1>
   <form action="hello">
      <label for="name">Please enter your name and age</label><br/>
      <input type="text" name="name"/>
      <input type="text" name="age"/>
      <input type="submit" value="Say Hello"/>
   </form>
   </br>
   </br>
   
    <h1>Hello World From Struts2 Extend</h1>
   <form action="helloExtend">
      <label for="name">Please enter your name and age</label><br/>
      <input type="text" name="name"/>
      
      <input type="submit" value="Say helloExtend"/>
   </form>
   </br>
   </br>
   
   <h1>Hello World From Struts2 Map </h1>
   <form action="helloMap">
      <label for="name">Please enter your name </label><br/>
      <input type="text" name="name"/>
      
      <input type="submit" value="Say helloMap"/>
   </form>
   
   </br>
   </br>
   <h1>Insert people to testdb </h1>
   <form action="insert">
      <label for="name">Please enter your profile </label><br/>
      id:<input type="text" name="id"/>
      name:<input type="text" name="name"/>
      school:<input type="text" name="school"/>
      age:<input type="text" name="age"/>
      <input type="submit" value="Insert"/>
   </form>
   
    </br>
     <h1>Update people to testdb </h1>
   <form action="UpdateByName">
      <label for="name">Please enter your profile </label><br/>
   	  id:<input type="text" name="id"/>
      name:<input type="text" name="name"/>
      school:<input type="text" name="school"/>
      age:<input type="text" name="age"/>
      <input type="submit" value="UpdateByName"/>
   </form>
   
    </br>
   
    <h1>Query people by name </h1>
   <form action="QueryByName">
      <label for="name">Please enter name </label><br/>
      <input type="text" name="name"/>
      <input type="submit" value="QueryByName"/>
   </form>   
   
    <h1>Query people by school </h1>
   <form action="QueryBySchool">
      <label for="name">Please enter your school </label><br/>
      <input type="text" name="school"/>
      <input type="submit" value="QueryBySchool"/>
   </form>  
    
   <h1>Delete all people  </h1>
   <form action=DeleteAll>
      <label for="name">Please enter your school </label><br/>
      <input type="submit" value="Delete all people"/>
   </form>   
   
   <h1>Delete people by school </h1>
   <form action="DeleteBySchool">
      <label for="name">Please enter your school </label><br/>
      <input type="text" name="school"/>
      <input type="submit" value="DeleteBySchool"/>
   </form>  
    
</body>
</html>
