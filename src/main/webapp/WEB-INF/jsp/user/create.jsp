<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Create User</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="<c:url value="/" />">Home</a></span>
            <span class="menuButton"><a class="list" href="<c:url value="/user/list"/>" >User List</a></span>
        </div>
        <div class="body">
        	 <form:form action="save"  method="post"  modelAttribute="person">
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
                                <td valign="top" class="name">
                                    <label for="name">Name</label>
                                </td>
                                <td valign="top" class="value">
                                    	<form:input path="name"  value="${person.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="realName">RealName</label>
                                </td>
                                <td valign="top" class="value ">
                                    <form:input path="realName"  value="${person.realName}" />
                                </td>
                            </tr>
                        	<tr class="prop">
                                <td valign="top" class="name">
                                    <label for="passwd">Password</label>
                                </td>
                                <td valign="top" class="value ">
                                    <form:password path="passwd"  value="${person.passwd}" />
                                </td>
                            </tr>
                            <tr class="prop">
                            	<td valign="top" class="name ">
                            		 <label for="roleList">ROLE LIST</label>
                            		 
                            	</td>
                            	 <td valign="top" class="value ">
                            		<c:forEach items="${roleList}" var="role" >
		                           		${role.name}<form:checkbox path="roles" value="${role}"/> <br/>
		                         	</c:forEach>
                            </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><input type="submit" name="create" class="save" value="Create" /></span>
                </div>
            </form:form>
        </div>
    </body>
</html>
