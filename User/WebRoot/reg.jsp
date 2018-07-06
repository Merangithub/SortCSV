<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>注册</title>
         <script>
        	/*当点击文本框时，背景颜色为白色*/
        	function foucsObj(id){
        		id.style.background = "#fff";
        	}
        	
        	
        	/*当鼠标离开用户名文本框时，对用户输入的内容进行判断，并进行相应提示*/
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
        	
        	/*当鼠标离开密码文本框时，对用户输入的内容进行判断，并进行相应提示*/
			function blurPassword(password) {
				var password = document.getElementById("password").value;
				var passwordDiv = document.getElementById("passwordDiv");
				if(password.length < 6) {
					passwordDiv.innerHTML = "密码不能小于6位数！";
					this.password.style.backgroundColor = "#ffff93";
					return false;
				}
				passwordDiv.innerHTML = "";
				this.password.style.backgroundColor = "#fff";
				return true;
			}
			
			/*当鼠标离开确认密码文本框时，对用户输入的内容进行判断，并进行相应提示*/
			function blurRepassword(repassword) {
				var repassword = document.getElementById("repassword").value;
				var repasswordDiv = document.getElementById("repasswordDiv");
				if(repassword == "") {
					repasswordDiv.innerHTML = "不能为空！！";
					this.repassword.style.backgroundColor = "#ffff93";
					return false;
				}else if(repassword != document.getElementById("password").value) {
					repasswordDiv.innerHTML = "两次输入的密码不同！";
					this.repassword.style.backgroundColor = "#ffff93";
					return false;
				}
				repasswordDiv.innerHTML = "";
				this.repassword.style.backgroundColor = "#fff";
				return true;
			}
			
			/*当鼠标离开邮箱文本框时，对用户输入的内容进行判断，并进行相应提示*/
			function blurEmail(email) {
				var email = document.getElementById("email").value;
				var emailDiv = document.getElementById("emailDiv");
				//判断是不是为空
				if(email.length == "") {
					emailDiv.innerHTML = "邮箱不能为空";
					this.email.style.backgroundColor = "#ffff93";
					return false;
				}
				//判断是不是包含@符号
				if(email.indexOf("@") == -1) {
					emailDiv.innerHTML = "邮箱必须包含@";
					this.email.style.backgroundColor = "#ffff93";
					return false;
				}
				//判断是不是包含.符号
				if(email.indexOf(".") == -1) {
					emailDiv.innerHTML = "邮箱必须包含.";
					this.email.style.backgroundColor = "#ffff93";
					return false;
				}
				emailDiv.innerHTML = "";
				this.email.style.backgroundColor = "#fff";
				return true;
			}

			/*当鼠标离开生日文本框时，对用户输入的内容进行判断，并进行相应提示*/
			function blurBirthday(birthday) {
				var birthday = document.getElementById("birthday").value;
				var birthdayDiv = document.getElementById("birthdayDiv");
				var standard = /^(\d{4})-(\d{2})-(\d{2})$/;
				if(birthday == "") {
					birthdayDiv.innerHTML = "生日不能为空！";
					this.birthday.style.backgroundColor = "#ffff93";
					return false;
				}else if(!standard.test(birthday)){
					birthdayDiv.innerHTML = "生日格式不正确！请正确输入，例：2018-07-03";
					this.birthday.style.backgroundColor = "#ffff93";
					return false;
				}
				birthdayDiv.innerHTML = "";
				this.birthday.style.backgroundColor = "#fff";
				return true;
			}

			function check(){
				var usernameDiv = document.getElementById("usernameDiv").innerText;
				var passwordDiv = document.getElementById("passwordDiv").innerText;
				var repasswordDiv = document.getElementById("repasswordDiv").innerText;
				var emailDiv = document.getElementById("emailDiv").innerText;
				var birthdayDiv = document.getElementById("birthdayDiv").innerText;
				if (usernameDiv=="" && passwordDiv=="" && repasswordDiv=="" && emailDiv=="" && birthdayDiv==""){
					return true;
				}else{
					alert("您输入的注册信息有误！");
					return false;
				}
			}

        </script>
        <style>
        	.tag{
        		text-align: right;
        	}
        </style>
    </head>
    <body>
    	${msg }
    	<table align="center">
    	<form action="/User/RegServlet" method="post" onsubmit="return check();">
    		<tr>
    			<td class="tag">用户名：</td>
    			<td><input type="text" id="username" name="username" onfocus="foucsObj(this)" onblur="blurUsername(this)"/></td>
    			<td id="usernameDiv">例：helloword</td>
    		</tr>
			<tr>
				<td class="tag">密码：</td>
				<td><input type="password" id="password" name="password" onfocus="foucsObj(this)" onblur="blurPassword(this)"/></td>
				<td id="passwordDiv">例：123456</td>
			</tr>
			<tr>
				<td class="tag">确认密码：</td>
				<td><input type="password" id="repassword" name="repassword" onfocus="foucsObj(this)" onblur="blurRepassword(this)"/></td>
				<td id="repasswordDiv">确认密码必须与密码一致</td>
			</tr>
			<tr>
				<td class="tag">邮箱：</td>
				<td><input type="text" id="email" name="email" onfocus="foucsObj(this)" onblur="blurEmail(this)"/></td>
				<td id="emailDiv">例：myemail@qq.com</td>
			</tr>
			<tr>
				<td class="tag">生日：</td>
				<td><input type="text" id="birthday" name="birthday" onfocus="foucsObj(this)" onblur="blurBirthday(this)"/></td>
				<td id="birthdayDiv">例：2018-07-03</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" id="register" value="注册"/></td>
			</tr>
		</form>
    	</table>
 	</body>
</html>