<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>test</title>
</head>
<body>
	<div class="nav">
		<span class="menuButton"><a class="home"
			href="<c:url value="/" />">Home</a></span> <span class="menuButton"><a
			class="list" href="<c:url value="/user/list"/>">User List</a></span>
	</div>
	<div class="body">
		<form:form action="test" method="post"  modelAttribute="test">
			<h1>Create User</h1>
			<c:if test="${flash.message}">
				<div class="message">${flash.message}</div>
			</c:if>
			<form:errors path="*" element="div">
			</form:errors>
			<div class="dialog">
				<table>
					<tbody>

						<tr class="prop">
							<td valign="top" class="name"><label for="name">Name1</label>
							</td>
							<td valign="top" class="value"><input type="text" name="userList0.name" /></td>
						</tr>

						<tr class="prop">
							<td valign="top" class="name"><label for="realName">Name2</label>
							</td>
							<td valign="top" class="value "><input type="text" name="userList1.name" /></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="buttons">
				<span class="button"><input type="submit" name="test"
					class="save" value="test" /></span>
			</div>
		</form:form>
	</div>
</body>
</body>
</html>