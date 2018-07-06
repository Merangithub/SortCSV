<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style type="text/css">
	.tag{
		text-align: right;
	}
</style>
<script type="text/javascript">
	/*当点击文本框时，背景颜色为白色*/
    function foucsObj(id){
        id.style.background = "#fff";
    }
    function blurUsername(username){
        		var username = document.getElementById("username").value;
        		var usernameDiv = document.getElementById("usernameDiv");
        		//非空判断
        		if (username == "") {
        			usernameDiv.innerHTML = "用户名不能为空！";
        			this.username.style.backgroundColor = "#ffff93";
					return false;
        		}
        		//判断名字中是否有空格
				for(var i = 0; i < username.length; i++) {
					if(username.substring(i, i + 1) == " ") {
						usernameDiv.innerHTML = "名字不能包含空格！";
						this.username.style.backgroundColor = "#ffff93";
						return false;
					}
				}
				//用户输入的内容合法时
				usernameDiv.innerHTML = "";
				username.style.backgroundColor = "#fff";
        		return true;
        	}
</script>
</head>
<body>
	${msg }
	<form action="/User/loginServlet" method="post">
		<table align="center">
			<tr>
				<td class="tag">用户名：</td>
				<td><input type="text" id="username" name="username" onfocus="foucsObj(this)" onblur="blurUsername(this)"/></td>
				<td id="usernameDiv"></td>
			</tr>
			<tr>
				<td class="tag">密码：</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="登录"/></td>
			</tr>
		</table>
	</form>
	
</body>
</html>