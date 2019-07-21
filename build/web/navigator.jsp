<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
    <c:if test="${sessionScope.ROLE == 'admin'}" var="isAdmin">
        <li class="has-dropdown">
            <a href="adminAddTourDetails.jsp">Add Tour</a>
            <!--            <ul class="dropdown">
                            <li><a href="#">Destination</a></li>
                            <li><a href="#">Cruises</a></li>
                            <li><a href="#">Hotels</a></li>
                            <li><a href="#">Booking</a></li>
                        </ul>-->
        </li>
        <c:url var="ManageTour" value="MainController">
            <c:param name="submit" value="Manage Tour"/>
        </c:url>
        <li><a href="${ManageTour}">Manage Tour</a></li>
            <c:url var="ManageOrder" value="MainController">
                <c:param name="submit" value="Manage Order"/>
            </c:url>
        <li><a href="${ManageOrder}">Manage Order</a></li>
        </c:if>
        <c:if test="${!isAdmin}">
        <li><a href="index.jsp">Home</a></li>
        </c:if>
        <c:if test="${sessionScope.USERNAME != null}" var="loggedIn">
            <c:url var="PersonalInfoLink" value="MainController">
                <c:param name="submit" value="Personal Info"/>
            </c:url>
        <li class="has-dropdown active"><a href="${PersonalInfoLink}">My Page</a>
            <ul class="dropdown">
                <c:if test="${!isAdmin}">

                    <c:url var="CheckOrdersLink" value="MainController">
                        <c:param name="submit" value="Check Orders"/>
                    </c:url>
                    <li><a href="${CheckOrdersLink}">Check Orders</a></li>
                    </c:if>

                <c:url var="LogoutLink" value="MainController">
                    <c:param name="submit" value="Logout"/>
                </c:url>
                <li><a href="${LogoutLink}">Logout</a></li>
            </ul>
        </li>
    </c:if>
    <c:if test="${!loggedIn}">
        <li><a href="login.jsp">Login</a></li>
        </c:if>
        <c:if test="${!isAdmin}">
        <li><a href="ViewShoppingCartController"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a></li>
            </c:if>

</ul>