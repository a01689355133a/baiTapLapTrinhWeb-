<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous">
	
</script>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .login-register-container {
            width: 450px;
            background-color: white;
            padding: 18px;
            border-radius: 10px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
        }

        .myDivP {
        	font-family: uniset;
            text-align: center;
            color: #A5A3A3;
             font-size: 30px;
        }

        .form-group {
            margin-bottom: 15px;
        }
s
        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #333;
        }

        .form-group input {
            width: 95%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        .form-group button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 10px;
        }

        .form-group button:hover {
            background-color: #0056b3;
        }

        .toggle-link {
            text-align: center;
            margin-top: 20px;
            color: #007bff;
            cursor: pointer;
        }

        .toggle-link:hover {
            text-decoration: underline;
        }
        .myDivA {
		    color: #929191; 
		}
		
    </style>
<body>
		
	<div class="login-register-container">
		<%
			String baoLoi = request.getAttribute("baoloi") + "";
			baoLoi = (baoLoi.equals("null")) ? "" : baoLoi;
		%>
    	<form action = "longin" method ="post">
			<div class="row">
				<p class = "myDivP">Đăng Nhập Vào Hệ Thống</o>
				<p class = "red" id = "baoloi" align="center">
						 <span class = "red">*</span> <%= baoLoi %> 
				</p>
				<div class="form-group">
					<input type="text"
						id="username" name="username" class="form-control"
						placeholder="Tài khoản" required="required">
				</div>
				<div class="form-group">
					<input type="password"
						id="password" name="password" class="form-control"
						placeholder="Mật Khẩu" required="required">
				</div>
				<div class="row" style="display: flex; align-items: center;">
					<div class="col-lg-3">
						<div class="checkbox-inline">
							<input type="checkbox" id="remember" name="remember" /> <label
								for="remember1" >Nhớ tôi</label>
						</div>
					</div>
					<div class="col-lg-5" style="margin-left: auto;">
						<a href="quenMatKhau.jsp" class = "myDivA">Quên mật khẩu?</a>
					</div>
				</div>
				<div class="form-group">
					<button type="submit" class="btn login-register-container">
						Đăng Nhập</button>
				</div>
		</form>
		<div> 
			<p align="center"> Nếu bạn chưa có tài khoản trên hệ thống, thì hãy <a href = "signin.jsp" style="color : #6756FA"> Đăng ký </a></p>
		</div>
    </div>

</body>
</html>