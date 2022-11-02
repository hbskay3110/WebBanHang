<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
       	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link rel="stylesheet" href="./assets/css/main.css">
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/grid.css">
    <link rel="stylesheet" href="./assets/css/rebonsive.css">

    <link href="https://fonts.googleapis.com/css2?family=Open+Sans&family=Roboto:wght@300;400;500;700;900&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
        integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
        crossorigin="anonymous" />
    <link rel="icon" href="./assets/img/logo3.png"
        type="image/x-icon" />


    <title>Shop Brother</title>
</head>

<body>
    <div class="app">
        <div class="header">
            <div class="grid wide">
                <nav class="header__navbar hide-on-mobile-tablet">
                    <ul class="header__navbar-list">
                        <a class="header__navbar-item header__navbar-item--separate " href="./startbootstrap-sb-admin-2-master/login.html">Kênh người bán</a>
                        
                        <li class="header__navbar-item header__navbar-item--separate ">Trở thành người bán</li>
                        <li class="header__navbar-item header__navbar-item--qr header__navbar-item--separate  ">
                            Tải ứng dụng
                            <div class="header__qr">
                                <img src="./assets/img/qr.png" alt="QR code" class="header__qr-img">

                                <div class="header__qr-apps">
                                    <a href="" class="header__qr-link">
                                        <img src="./assets/img/downAppstore.png" alt="" class="header__qr-download-img">
                                    </a>
                                    <a href="" class="header__qr-link">
                                        <img src="./assets/img/downChplay.png" alt="" class="header__qr-download-img">
                                    </a>
                                </div>
                            </div>


                        </li>
                        <li class="header__navbar-item ">
                            <span class="header__navbar-title--nopointer">Kết nối</span>
                            <a href="" class="header__navbar-icon-link ">
                                <i class="header__navbar-icon fab fa-facebook"></i>
                            </a>
                            <a href="" class="header__navbar-icon-link">
                                <i class="header__navbar-icon fab fa-instagram"></i>
                            </a>
                        </li>

                    </ul>
                    <ul class="header__navbar-list">
                        <li class="header__navbar-item header__navbar-item-notify">
                            <a href="" class="header__navbar-item-link"><i
                                    class="header__navbar-icon far fa-bell"></i>Thông báo
                            </a>
                            <div class="header__notify">
                                <header class="header__notify-header">
                                    <h3>Thông báo mới nhận</h3>
                                </header>

                                <ul class="header__notify-list">
                                    <li class="header__notify-item header__notify-item--viewed">
                                        <a href="" class="header__notify-link">
                                            <img src="https://lavendermedia.vn/wp-content/uploads/2019/10/chup-hinh-my-pham-quang-quang-1.jpg"
                                                alt="" class="header__notify-img">
                                            <div class="hearder__notify-info">
                                                <span class="hearder__notify-name">Mỹ phẩm chính hảng</span>
                                                <span class="hearder__notify-decscriotion">Mô tả mĩ phẩm chính
                                                    hãng</span>
                                                <span></span>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="header__notify-item ">
                                        <a href="" class="header__notify-link ">
                                            <img src="https://lavendermedia.vn/wp-content/uploads/2019/10/chup-hinh-my-pham-quang-quang-1.jpg"
                                                alt="" class="header__notify-img">
                                            <div class="hearder__notify-info">
                                                <span class="hearder__notify-name">Mỹ phẩm chính hảng</span>
                                                <span class="hearder__notify-decscriotion">Mô tả mĩ phẩm chính
                                                    hãng</span>
                                                <span></span>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="header__notify-item">
                                        <a href="" class="header__notify-link">
                                            <img src="https://lavendermedia.vn/wp-content/uploads/2019/10/chup-hinh-my-pham-quang-quang-1.jpg"
                                                alt="" class="header__notify-img">
                                            <div class="hearder__notify-info">
                                                <span class="hearder__notify-name">Xác thực chính hãng nguồn gốc của các
                                                    sản phẩm chính hảng</span>
                                                <span class="hearder__notify-decscriotion">Mô tả mĩ phẩm chính
                                                    hãng</span>
                                                <span></span>
                                            </div>
                                        </a>
                                    </li>

                                </ul>
                                <footer class="header__notify-footer">
                                    <a href="" class="header__notify-footer-btn">Xem tất cả</a>
                                </footer>
                            </div>

                        </li>
                        <li class="header__navbar-item">
                            <a href="" class="header__navbar-item-link"><i
                                    class="header__navbar-icon far fa-question-circle"></i>Trợ giúp</a>
                        </li>
                        <li
                            class="header__navbar-item header__navbar-item--strong header__navbar-item--separate js-form-register">
                            Đăng kí</li>
                        <li class="header__navbar-item header__navbar-item--strong js-form-login">Đăng nhập</li>
                        <li class="header__navbar-item header__navbar-item-user">
                            <img src="https://metricleo.com/wp-content/uploads/2021/03/word-image-23.jpeg" alt=""
                                class="header__navbar-item header__navbar-user-img">
                            <span class="header__navbar-user-name">Nhóm 6</span>
                            <ul class="header__navbar-user-menu">
                                <li class="header__navbar-user-item"><a href="">Tài khoản của tôi</a></li>
                                <li class="header__navbar-user-item"><a href="">Địa chỉ của tôi</a></li>
                                <li class="header__navbar-user-item"><a href="">Đơn mua</a></li>
                                <li class="header__navbar-user-item header__navbar-user-item--separate"><a href="">Đăng
                                        xuất</a></li>

                            </ul>
                        </li>
                    </ul>


                </nav>
                <!--Header with sreach-->
                <div class="header-with-search ">
                    <label for="nav-mobile-input" class="header-mobie-tab-bar">
                        <i class="fas fa-bars header-mobie-tab-bar-icon"></i>
                    </label>
                    <label for="mobie_search-input" class="header-mobie-search">
                        <i class=" fas fa-search header-mobie-search-icon"></i>
                    </label>
                    <div class="header-logo hide-on-tablet">
                        <a href="/" class="header-logo-link">
                            <img class="header-logo-img" src="./assets/img/logo2.png" />

                        </a>

                    </div>
                    <input type="checkbox" hidden class="header-search-checkbox" id="mobie_search-input">
                    <div class="header__search ">
                        <div class="header__search-input-wrap">
                            <input type="text" class="header__search-input" placeholder="Nhập để tìm kiếm sản phẩm">

                            <!-- search hítory -->
                            <div class="header__search-history">
                                <h3 class="header__search-history-heading">Lịch sử tìm kiếm</h3>
                                <ul class="header__search-history-list">
                                    <li class="header__search-history-item">
                                        <a href="#">Phụ kiện điện thoại</a>
                                    </li>
                                    <li class="header__search-history-item">
                                        <a href="#">Giày nam</a>
                                    </li>
                                    <li class="header__search-history-item">
                                        <a href="#">Đồng phục</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="header_search-select">
                            <span class="header_search-select-label">Trong shop</span>
                            <i class="header_search-select-icon fas fa-chevron-down"></i>
                            <ul class="header__search-option">
                                <li class="header__search-option-item header__search-option-item--active">
                                    <span>Trong shop</span>
                                    <i class="fas fa-check"></i>
                                </li>
                                <li class="header__search-option-item">
                                    <span>Ngoài shop</span>
                                    <i class="fas fa-check"></i>
                                </li>
                            </ul>
                        </div>
                        <button class="header__search-btn">
                            <i class="header__search-btn-icon fas fa-search"></i>
                        </button>
                    </div>
                    <!-- cart layout  -->
                    <div class="header__cart">
                        <div class="header__cart-wrap ">
                            <i class="header__cart-icon fas fa-shopping-cart"></i>
                            <span class="header__cart-notice">0</span>
                            <!-- no cart :header__cart-list--nocart -->
                            <div class="header__cart-list header__cart-list--nocart ">
                                <img src="./assets/img/nocart.png" alt="" class="header__cart-list--nocart-img">
                                <span class="header__cart-list--nocart-msg">Chưa có sản phẩm</span>

                                <!-- <h3 class="header__cart-heading ">Các sản phẩm</h3> -->
                                <ul class="header__cart-list-item">
                                    <!-- Cart item -->
                                    <!-- <li class="header__cart-item">
                                        <img src="./assets/img/Sản phẩm/iphone13_pro max.jpg" alt=""
                                            class="header__cart-img">
                                        <div class="header__cart-item-info">
                                            <div class="header__cart-item-head">
                                                <h5 class="header__cart-item-name">Iphone 13 pro max </h5>
                                                <div class="header__cart-price-wrap">
                                                    <span class="header__cart-item-price">43.000.0000</span>
                                                    <span class="header__cart-item-multiply">x</span>
                                                    <span class="header__cart-item-qnt">2</span>
                                                </div>
                                            </div>
                                            <div class="header__cart-item-body">
                                                <span class="header__cart-item-description">Phân loại: Vàng</span>
                                                <span class="header__cart-item-remove">Xóa</span>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="header__cart-item">
                                        <img src="./assets/img/Sản phẩm/jd.jpeg" alt="" class="header__cart-img">
                                        <div class="header__cart-item-info">
                                            <div class="header__cart-item-head">
                                                <h5 class="header__cart-item-name">Giày Nike Air Jordan Giày Nike Air
                                                    Jordan Giày Nike Air Jordan Giày Nike Air Jordan</h5>
                                                <div class="header__cart-price-wrap">
                                                    <span class="header__cart-item-price">6.900.0000</span>
                                                    <span class="header__cart-item-multiply">x</span>
                                                    <span class="header__cart-item-qnt">1</span>
                                                </div>
                                            </div>
                                            <div class="header__cart-item-body">
                                                <span class="header__cart-item-description">Phân loại: Bạc</span>
                                                <span class="header__cart-item-remove">Xóa</span>
                                            </div>
                                        </div>
                                    </li> -->
                                </ul>
                                <a href="#"
                                    class="header__cart-view-carts btn btn-primary header__cart-view-carts">Thanh toán
                                </a>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
            <ul class="header__sort-bar">
                <li class="header__sort-item ">
                    <a href="" class="header__sort-link">Liên quan</a>
                </li>
                <li class="header__sort-item header__sort-item--active">
                    <a href="" class="header__sort-link">Mới nhất</a>
                </li>
                <li class="header__sort-item">
                    <a href="" class="header__sort-link">Bán chạy</a>
                </li>
                <li class="header__sort-item">
                    <a href="" class="header__sort-link">Giá</a>
                </li>
            </ul>


        </div>
        <div class="introduction">
            <div class="grid wide">

                <h2 class="row introduction__header">Giới thiệu</h2>
                <h3 class="row introduction__text">Brother là nền tảng thương mại điện tử </h3>
                <p class="introduction__main-text-header"> Nền tảng thương mại Brother được xây dựng nhằm cung cấp cho người dùng những trải nghiệm dễ dàng, an
                    toàn và nhanh chóng khi mua sắm trực tuyến thông qua hệ thống hỗ trợ thanh toán và vận hành vững
                    mạnh.</p>
                <p class="introduction__main-text-header">Chúng tôi có niềm tin mạnh mẽ rằng trải nghiệm mua sắm trực tuyến phải đơn giản, dễ dàng và mang đến
                    cảm xúc vui thích. Niềm tin này truyền cảm hứng và thúc đẩy chúng tôi mỗi ngày tại Brother.</p>
                <button class="introduction__btn">Tìm hiểu Brother</button>
                <div class="row introduction__main">
                    <div class="col l-4 m-6 c-6 introduction__info">
                        <h3 class="introduction__main-header">Mục tiêu của chúng tôi</h3>
                        <p class="introduction__main-text">Chúng tôi tin tưởng và
                            mong muốn góp phần làm cho thế giới trở nên tốt đẹp hơn bằng việc kết nối cộng đồng người
                            mua và người bán thông qua việc cung cấp một nền tảng thương mại điện tử.</p>


                        <img class="introduction__main-mimage" src="./assets/img/gangui.jpg"></img>
                        <h3 class="introduction__main-header">Gần Gũi</h3>
                        <p class="introduction__main-text">Chúng tôi có niềm tin vào tính gần gũi mà thanh liêm, nền
                            tảng vững chắc cho một cuộc sống trung thực, bình dân và thành thật với bản thân.</p>
                    </div>
                    <div class="col l-4 m-6 c-6 introduction__info">
                        <h3 class="introduction__main-header">Định vị của chúng tôi</h3>
                        <p class="introduction__main-text">Đối với người dùng trên toàn khu vực, Brother mang đến trải
                            nghiệm mua sắm trực tuyến tích hợp với vô số sản phẩm đa dạng chủng loại, cộng đồng người
                            dùng năng động và chuỗi dịch vụ liền mạch.</p>
                        <img class="introduction__main-mimage" src="./assets/img/vui.jpg"></img>
                        <h3 class="introduction__main-header">Vui vẻ</h3>
                        <p class="introduction__main-text">Chúng tôi dễ gần, đáng yêu và tràn đầy năng lượng, luôn mang
                            đến niềm vui cho những người xung quanh.</p>
                    </div>
                    <div class="col l-4 m-6 c-6 introduction__info">
                        <h3 class="introduction__main-header">Đặc điểm về con người của chúng tôi</h3>
                        <p class="introduction__main-text">Để định nghĩa chúng tôi là ai thông qua lời nói hay cách
                            ứng xử , chúng tôi Gần gũi, Vui vẻ và Đồng
                            lòng. Đây là những đặc tính chính và nổi bật trong từng bước đường phát triển của Brother.
                        </p>
                        <img class="introduction__main-mimage" src="./assets/img/donglong.jpg"></img>
                        <h3 class="introduction__main-header">Đồng Lòng</h3>
                        <p class="introduction__main-text">Chúng tôi thích tận hưởng thời gian bên nhau giống như tận
                            hưởng việc mua sắm trực tuyến với người thân và bạn bè - làm những việc yêu thích cùng nhau
                            như một đại gia đình lớn.
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="app_container">
            


        </div>
        		<jsp:include page="footer/footerlv1.jsp"></jsp:include>
    </div>
    <!-- header mobie tab bar orerlay -->
    <div class="header-mobie-tab-bar-overlay"></div>
    <div class="nav__mobile">
        <div class="nav__mobile-header">
            <h2 class="nav__mobile-text">Brother SHOP</h2>
            <div class="nav__mobile-close">
                <i class="fas fa-times"></i>
            </div>
        </div>
        <ul class="nav-mobile-list">
            <li class="nav__mobile-link nav__mobile-link-register"><a href="#">Đăng kí </a></li>
            <li class="nav__mobile-link nav__mobile-link-login"><a href="#">Đăng nhập</a></li>
            <li class="nav__mobile-link "><a href="">Hỗ Trợ</a></li>

            <!-- <li class="nav__mobile-link"><a href="">Tài khoản của tôi</a></li>
        <li class="nav__mobile-link"><a href="">Địa chỉ của tôi</a></li>
        <li class="nav__mobile-link"><a href="">Đơn mua</a></li>
        <li class="nav__mobile-link header__navbar-mobile-user-item--separate"><a href="">Đăng
                xuất</a></li> -->
        </ul>
    </div>
    <div id="toast"></div>
    <!-- modal layout -->
    <div class="modal js-modal">
        <div class="modal__overlay">
        </div>
        <div class="modal__body js-modal__body">
            <!--Register from-->
            <div class="auth-form auth-form-login-register">
                <div class="auth-form__container">
                    <form action="" class="form" id="form-1">
                        <div class="auth-form__header">
                            <h3 class="auth-form__heading">Đăng ký</h3>
                            <span class="auth-form__switch-btn js-form-login">Đăng nhập</span>
                        </div>

                        <div class="auth-form__form">
                            <div class="auth-form__group ">
                                <input type="text" name="emailorPhone" class="auth-form__input" id="email"
                                    placeholder="Nhập email hoặc số điện thoại">
                                <span class="auth-form__error-msg"></span>
                            </div>
                            <div class="auth-form__group">
                                <input type="password" name="pass" class="auth-form__input" id="pass"
                                    placeholder="Nhập mật khẩu">
                                <span class="auth-form__error-msg"></span>
                            </div>
                            <div class="auth-form__group">
                                <input type="password" name="checkpass" class="auth-form__input" id="checkpass"
                                    placeholder="Nhập lại mật khẩu">
                                <span class="auth-form__error-msg"></span>
                            </div>
                        </div>
                        <div class="auth-form__aside">
                            <p class="auth-form__policy-text">
                                Bằng việc đăng kí bạn đã đồng ý với chúng tôi về
                                <a class="auth-form__text-link">Điều khoản dịch vụ</a> &
                                <a class="auth-form__text-link">Chính sách bảo mật</a>
                            </p>
                        </div>
                        <div class="auth-form__controls">
                            <div class="btn btn--normal auth-form__controls--back js-auth-form__controls--back">TRỞ
                                LẠI</div>
                            <button class="btn btn-primary">ĐĂNG KÝ </button>


                        </div>
                    </form>
                </div>
                <div class="auth-form__socials">
                    <a href="https://www.facebook.com/?stype=lo&jlou=Aff9vdnyDCruPq8hUrvesIOZ3krl2oO57sdFXCI2-jxvLyxDr9TwxdnlMqC-xu_BMf_xCxfYtjOj4oudmqnZcVleGrlH67f4bfgE66vNgpKHtg&smuh=13617&lh=Ac8LmChl5c0TrY0qlbM"
                        class="auth-form__socials-facebook btn btn-size-s btn--withicon"><i
                            class="auth-form__socials-icon fab fa-facebook-square"></i>
                        <span class="auth-form__socials-title">Kết nối với FaceBook</span>
                    </a>
                    <a href="" class="auth-form__socials-google btn btn-size-s btn--withicon"><i
                            class="auth-form__socials-icon fab fa-google"></i>
                        <span class="auth-form__socials-title">Kết nối với Google</span>
                    </a>

                </div>


            </div> -->
            <!--Login from-->
            <div class="auth-form auth-form-login">
                <div class="auth-form__container">
                    <form action="" class="form" id="form-2">
                        <div class="auth-form__header">
                            <h3 class="auth-form__heading">Đăng nhập</h3>
                            <span class="auth-form__switch-btn js-form-register">Đăng Ký</span>
                        </div>
                        <div class="auth-form__form">
                            <div class="auth-form__group">
                                <input type="text" class="auth-form__input" id="email"
                                    placeholder="Nhập email hoặc số điện thoại">
                                <span class="auth-form__error-msg"></span>
                            </div>
                            <div class="auth-form__group">
                                <input type="password" class="auth-form__input" id="pass" placeholder="Nhập mật khẩu">
                                <span class="auth-form__error-msg"></span>
                            </div>

                        </div>
                        <div class="auth-form__aside">
                            <div class="auth-form__help">
                                <a href="" class="auth-form__help-link auth-form__help-forgot">Quên mật khẩu</a>
                                <span class="auth-form__help-separate"></span>
                                <a href="" class="auth-form__help-link">Cần trợ giúp?</a>

                            </div>
                        </div>
                        <div class="auth-form__controls">
                            <div class="btn btn--normal auth-form__controls--back js-auth-form__controls--back">TRỞ
                                LẠI</div>
                            <button class="btn btn-primary">ĐĂNG NHẬP </button>

                        </div>
                    </form>
                </div>
                <div class="auth-form__socials">
                    <a href="" class="auth-form__socials-facebook btn btn-size-s btn--withicon"><i
                            class="auth-form__socials-icon fab fa-facebook-square"></i>
                        <span class="auth-form__socials-title">Đăng nhập với FaceBook</span>
                    </a>
                    <a href="" class="auth-form__socials-google btn btn-size-s btn--withicon"><i
                            class="auth-form__socials-icon fab fa-google"></i>
                        <span class="auth-form__socials-title">Đăng nhập với Google</span>
                    </a>

                </div>


            </div>
        </div>
    </div>


</body>
<script src="./assets/scrip/renderSpPage2.js"></script>
<script src="./assets/scrip/vadilator.js"></script>


<script>
    // Mong muốn 
    Vadilator({
        modal: '.js-modal',
        form: '#form-1',
        formAlertRegister: '#form-1',
        formGroupSelector: '.auth-form__group',
        errorSelector: '.auth-form__error-msg',

        rules: [
            Vadilator.isRequired('#email'),
            Vadilator.isEmail('#email', 'Vui lòng nhập email hoặc số điện thoại hợp lệ'),
            Vadilator.ischekExist('#email', 'Email hoặc số điện thoại đã tồn tại'),
            Vadilator.isRequired('#pass'),
            Vadilator.minLength('#pass', 6),
            Vadilator.isRequired('#checkpass'),
            Vadilator.isCheckpass('#checkpass', function () {
                return document.querySelector('#form-1 #pass').value;
            }, 'Mật khẩu nhập lại không chính xác')

        ],
        onSubmit: function (data) {
            //Call API
            console.log(data)
        }
    });
    Vadilator({
        modal: '.js-modal',
        form: '#form-2',
        formAlertLogin: '#form-2',
        formGroupSelector: '.auth-form__group',
        errorSelector: '.auth-form__error-msg',
        register: '.js-form-register',
        login: '.js-form-login',
        rules: [
            Vadilator.isRequired('#email'),
            Vadilator.isEmail('#email', 'Email hoặc số điện thoại không hợp lệ'),
            Vadilator.isCheckEmail('#email', 'Email hoặc số điện thoại không tồn tại'),
            Vadilator.isRequired('#pass'),
            Vadilator.minLength('#pass', 6),
            Vadilator.isCheckTK('#pass', 'Sai mật khấu'),
        ],
        // onSubmit: function(data){
        //     //Call API
        //     console.log(data)
        // }
    });






</script>
<script src="./assets/scrip/main.js"></script>


</html>