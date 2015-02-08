<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Hello World</title>
</head>
<body>
  <h3>Select Records:</h3>  
	<s:iterator  value="daoL">  
	<fieldset>  
		id:<s:property value="id"/><br/>  
		name:<s:property value="name"/><br/>  
		school:<s:property value="school"/><br/>  
		age<s:property value="age"/><br/>  
	</fieldset>  
</s:iterator>
</body>
</html>