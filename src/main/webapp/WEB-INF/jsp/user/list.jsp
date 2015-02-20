<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />    
        <title>User List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="<c:url value="/"/>">Home</a></span>
            <span class="menuButton"><a class="create" href="<c:url value="/user/create"/>" >Create</a></span>
        </div>
        <div class="body">
            <h1>User List</h1>
            <c:if test="${param.message != null}">
            <div class="message">${param.message}</div>
            </c:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                            <td title="Id" >Id</td>
                            <td title="Name" >Name</td>
                            <td title="RealName" >realName</td>
                            <td title="CreateDate" >CreateDate</td>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${personList}"  varStatus="status" var="person" >
                        <tr class="${(status.index % 2) == 0 ? 'odd' : 'even'}">
                            <td><a href="<c:url value="/user/show/${person.id}"/>"  >${person.id}</a></td>
                            <td>${person.name}</td>
                            <td>${person.realName}</td>
                        	<td><fmt:formatDate value="${person.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                
            </div>
        </div>
    </body>
</html>
