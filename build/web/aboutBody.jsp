<%@include file="masterHeader.jsp" %>
<div id="colorlib-contact">
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1 animate-box">
                <h3>Your personal info: </h3>
                <font color="green">${requestScope.SUCCESS}</font>
                <font color="red">${requestScope.INVALID}</font>
                <form action="MainController" method="POST">
                    <div class="row form-group">
                        <div class="col-md-12">
                            <label for="fullname">Fullname</label>
                            <input type="text" name="fullname" value="${requestScope.INFO.getFullname()}" id="fullname" class="form-control" placeholder="Your Fullname">
                            <label for="username" class="binhpd-error-message">${requestScope.errorObj.fullnameError}</label>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-12">
                            <label for="email">Email</label>
                            <input type="text" name="email" value="${requestScope.INFO.getEmail()}" id="email" class="form-control" placeholder="Your Email Address">
                            <label for="username" class="binhpd-error-message">${requestScope.errorObj.emailError}</label>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-12">
                            <label for="phoneNumber">Phone Number</label>
                            <input type="text" name="phoneNumber" value="${requestScope.INFO.getPhoneNumber()}" id="phone" class="form-control" placeholder="Your Phone Number">
                            <label for="username" class="binhpd-error-message">${requestScope.errorObj.phoneError}</label>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-12">
                            <label for="address">Address</label>
                            <input type="text" name="address" value="${requestScope.INFO.getAddress()}" id="address" class="form-control" placeholder="Your Current Address">
                            <label for="username" class="binhpd-error-message">${requestScope.errorObj.addressError}</label>
                        </div>
                    </div>
                    <div class="form-group text-center">
                        <input type="submit" name="submit" value="Update Personal Info" class="btn btn-primary">
                    </div>
                </form>	
                <a href="aboutPassword.jsp">Change your password here!!</a>
            </div>
        </div>
    </div>
</div>
<%@include file="masterFooter.jsp" %>
