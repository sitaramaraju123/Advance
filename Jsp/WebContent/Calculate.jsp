<%
String num1 = request.getParameter("one");
String cal = request.getParameter("cal");
String num2 = request.getParameter("two");
int n1 = Integer.parseInt(num1);
int n2 = Integer.parseInt(num2);
char c = cal.charAt(0);
switch(c){
case '+':out.print(n1+n2);
break;
case '-':out.print(n1-n2);
break;
case '*':out.print(n1*n2);
break;
case '/':out.print(n1/n2);
}

%>
<a href="DemoCal.jsp"><button>Back</button></a>