<jsp:useBean id="loginid" class="com.demo.LoginBean" scope="page">
<jsp:setProperty name="loginid" property="*"></jsp:setProperty>
</jsp:useBean>

Welcome <jsp:getProperty property="uname" name="loginid"/>
