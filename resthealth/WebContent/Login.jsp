<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>��½ҳ��</title>
<script type="text/javascript">

function checkForm(form){ 
	
   if(form.username.value==""){
      window.alert("�������û���¼�ǳ�!");     
      return false;
   }  

   if(form.password.value==""){
      window.alert("�������û���¼���룡");
      return false;
   }

}
</script>
</head>
<body>
<center>
 <form action="CheckServlet" method="post" name="form1" onSubmit="return checkForm(form1)">
  <table align="center" border="1" width="%80">
    <tr align="center">
      <th colspan="2">��½ҳ��</th>
    </tr>
    <tr align="center">
      <td height="20" width="80">�û�����</td>
      <td ><input type="text" name="username" size="30"></td>  
    </tr>
    <tr align="center">
      <td>���룺</td>
      <td><input type="text" name="password" size="30"></td>
    </tr>
    <tr align="center">
      <td colspan="2"><input type="submit" value="��¼">
      &nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="ȡ��"></td>
    </tr>  
  </table>
 </form>
 </center>
 <div align="center">
 <font color="red">${requestScope.message}</font>
 </div>
</body>
</html>