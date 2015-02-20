<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>  
<%-- <%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>   --%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> --%>
<html>
    <head>
        <title><decorator:title default="Grails" /></title>
        <link rel="stylesheet" href="<c:url value="/css/main.css"/>"  />
        <link rel="shortcut icon" href="<c:url value="/images/favicon.ico"/>"  type="image/x-icon" />        
        <decorator:head  />
        <script type="text/javascript" src="<c:url value="/js/jquery-1.7.1.min.js"/>"></script>
    </head>
    <body>
        <div id="spinner" class="spinner" style="display:none;">
            <img src="<c:url value="/images/spinner.gif"/>" alt="Spinner" />
        </div>
	
        <div id="grailsLogo" class="logo">
		<a href="#"><img src="<c:url value="/images/grails_logo.png"/>" alt="Grails" border="0" /></a>
		<div class="menu">
		<li>
			<ui>
				<a href="<c:url value="/user/list"/>">User</a> |
				<a href="<c:url value="/role/list"/>">Role</a> |
			</ul>
		</li>
	</div>
	</div>
        <decorator:body  />
    </body>
</html>