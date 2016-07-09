<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	hello,<#if Session.name?exists>
		${Session.name}
	</#if>
	<#list map?keys as key>
		key:${key}
		value:${map[key]}
	</#list>


	<#if list?exists>
		<#list list as num>
			${num}
		</#list>
	</#if>
		
</body>
</html>