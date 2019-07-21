<div id="colorlib-contact">
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1 animate-box">
                <h3>Login</h3>
                <font color="red">${requestScope.INVALID}</font>
                <font color="green">${requestScope.SUCCESS}</font>
                <form action="MainController" method="POST">
                    <div class="row form-group">
                        <div class="col-md-6">
                            <label for="username">Username</label>
                            <input type="text" name="username" id="username" class="form-control" placeholder="Enter Username">
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-6">
                            <label for="password">Password</label>
                            <input type="password" name="password" id="password" class="form-control" placeholder="Enter Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="submit" name="submit" value="Login" class="btn btn-primary">
                    </div>
                    <a href="signUp.jsp">Don't have an account yet?</a>
                </form>		
            </div>
        </div>
    </div>
</div>