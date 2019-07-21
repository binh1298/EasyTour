<div id="colorlib-contact">
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1 animate-box">
                <h3>Sign Up</h3>
                <font color="red">${requestScope.INVALID}</font>
                <form action="MainController" method="POST">
                    <div class="row form-group">
                        <div class="col-md-12">
                            <label for="username">Username</label>
                            <input type="text" name="username" id="username" class="form-control" value="${requestScope.dto.username}" placeholder="Enter Username">
                            <label for="username" class="binhpd-error-message">${requestScope.errorObj.usernameError}</label>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-6 padding-bottom">
                            <label for="password">Password</label>
                            <input type="password" name="password" id="password" class="form-control" placeholder="Enter Password">
                            <label for="username" class="binhpd-error-message">${requestScope.errorObj.passwordError}</label>
                        </div>
                        <div class="col-md-6">
                            <label for="cfPassword">Confirm password</label>
                            <input type="password" name="cfPassword" id="cfPassword" class="form-control" placeholder="Enter Password Again">
                            <label for="username" class="binhpd-error-message">${requestScope.errorObj.cfPasswordError}</label>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-12">
                            <label for="fullname">Fullname</label>
                            <input type="text" name="fullname" id="fullname" class="form-control" value="${requestScope.dto.fullname}" placeholder="Your Fullname">
                            <label for="username" class="binhpd-error-message">${requestScope.errorObj.fullnameError}</label>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-12">
                            <label for="email">Email</label>
                            <input type="text" name="email" id="email" class="form-control" value="${requestScope.dto.email}" placeholder="Your Email Address">
                            <label for="username" class="binhpd-error-message">${requestScope.errorObj.emailError}</label>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-12">
                            <label for="phone">Phone Number</label>
                            <input type="text" name="phone" id="phone" class="form-control" value="${requestScope.dto.phoneNumber}" placeholder="Your Phone Number">
                            <label for="username" class="binhpd-error-message">${requestScope.errorObj.phoneError}</label>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-12">
                            <label for="address">Address</label>
                            <input type="text" name="address" id="address" class="form-control" value="${requestScope.dto.address}" placeholder="Your Current Address">
                            <label for="username" class="binhpd-error-message">${requestScope.errorObj.addressError}</label>
                        </div>
                    </div>
                    <div class="form-group text-center">
                        <input type="submit" name="submit" value="Sign Up" class="btn btn-primary">
                    </div>

                </form>		
            </div>
            <div class="col-md-10 col-md-offset-1 animate-box">
                <h3>Contact Information</h3>
                <div class="row contact-info-wrap">
                    <div class="col-md-3">
                        <p><span><i class="icon-location"></i></span> 198 West 21th Street, <br> Suite 721 New York NY 10016</p>
                    </div>
                    <div class="col-md-3">
                        <p><span><i class="icon-phone3"></i></span> <a href="tel://1234567920">+ 1235 2355 98</a></p>
                    </div>
                    <div class="col-md-3">
                        <p><span><i class="icon-paperplane"></i></span> <a href="mailto:info@yoursite.com">info@yoursite.com</a></p>
                    </div>
                    <div class="col-md-3">
                        <p><span><i class="icon-globe"></i></span> <a href="#">yoursite.com</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>