<%@include file="masterHeader.jsp" %>
<div id="colorlib-contact">
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1 animate-box">
                <h3>Change your password: </h3>
                <font color="red">${requestScope.INVALID}</font>
                <form action="MainController" method="POST">
                    <div class="row form-group">
                        <div class="col-md-6 padding-bottom">
                            <label for="password">Password</label>
                            <input type="password" name="password" id="password" class="form-control" placeholder="Enter Password">
                        </div>
                        <div class="col-md-6">
                            <label for="cfPassword">Confirm password</label>
                            <input type="password" name="cfPassword" id="cfPassword" class="form-control" placeholder="Enter Password Again">
                        </div>
                    </div>
                    <div class="form-group text-center">
                        <input type="submit" name="submit" value="Update Password" class="btn btn-primary">
                    </div>
                </form>		
            </div>
        </div>
    </div>
</div>
<%@include file="masterFooter.jsp" %>
