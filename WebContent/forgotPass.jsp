<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<%-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">--%>
<link rel="stylesheet" href="./assets/css/base.css">
<link rel="stylesheet" href="./assets/css/grid.css">
<link rel="stylesheet" href="./assets/css/rebonsive.css">
<link rel="stylesheet" href="./assets/css/main.css">

<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans&family=Roboto:wght@300;400;500;700;900&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
	integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
	crossorigin="anonymous" />
<link rel="icon"
	href="https://searchlogovector.com/wp-content/uploads/2019/06/bio-shop-logo-vector.png"
	type="image/x-icon" />
<title>Insert title here</title>
</head>
<style>
.login_container {
	width: 500px;
	height: 100%;
	margin: auto;
	background-color: white;
	border-radius: 17px;
}
.auth-form__error-msg{
    display: block;
    font-size: 1.2rem;
    color: #f33a58;
    line-height: 1.6rem;
    padding: 6px 0 0;
}
.auth-form__form{
	padding: 0 12px;
}


.main{
	height: 640px;
	background-color: #53e736;
}
</style>
<body>

	<div class="main">
		<div class="login_container">
			<!--Login from-->
			<form action="/WebsBanHang/Login?action=forgot" class="form" id="form-2" method="post">
				<div class="auth-form__header">
					<h3 class="auth-form__heading">Quên mật khẩu</h3>
				
				</div>
				<div class="auth-form__form">
					<div class="auth-form__group">
						<input type="text" class="auth-form__input" id="email" name ="userName" value=""
							placeholder="Nhập tên tài khoản"> 
							<span class="auth-form__error-msg">${erorr.erorrUser}</span>
					</div>
					<div class="auth-form__group">
						<input type="password" class="auth-form__input" id="pass" name = "email" value=""
							placeholder="Nhập email hoặc số điện thoại"> 
						<span class="auth-form__error-msg">${erorr.erorrEmail}</span>
					</div>
 
				</div>
				<div class="auth-form__controls">
					<div
						class="btn btn--normal auth-form__controls--back js-auth-form__controls--back">TRỞ
						LẠI</div>
					<button type="submit" class="btn btn-primary">Gửi</button>

				</div>
			</form>

			<div class="auth-form__socials">
				<a href=""
					class="auth-form__socials-facebook btn btn-size-s btn--withicon"><i
					class="auth-form__socials-icon fab fa-facebook-square"></i> <span
					class="auth-form__socials-title">Đăng nhập với FaceBook</span> </a> <a
					href=""
					class="auth-form__socials-google btn btn-size-s btn--withicon"><i
					class="auth-form__socials-icon fab fa-google"></i> <span
					class="auth-form__socials-title">Đăng nhập với Google</span> </a>

			</div>
		</div>
	</div>
	
	
	<c:if test="${sessionScope.openDiaLog != null}">
		 <div class="dialog">
        <p class="dialong__title">Xác nhận</p>
        <div class="dialog__main">
            <p class="dialog__text">Bạn có chắc muốn thanh toán</p>
        
            <button class="dialog__btn ">Thoát</button>
            <button class="dialog__btn dialog__btn-ok">Đồng ý</button>
        </div>
    </div>
	</c:if>



</body>
</html>