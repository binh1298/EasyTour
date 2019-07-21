<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="colorlib-tour">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3 text-center colorlib-heading animate-box">
                <h2>Your Cart</h2>
                <c:if test="${sessionScope.CART == null || empty sessionScope.CART.getCart().values()}" var="isEmptyCart">
                    <p>Your cart is empty!</p>
                </c:if>
            </div>
        </div>
        <c:if test="${!isEmptyCart}">
            <form action="CartController" method="POST" name="Cart Form">
                <c:forEach var="seat" items="${sessionScope.CART.getCart().values()}" varStatus="counter">
                    <div class="row form-group">
                        <div class="col-md-12">
                            <div class="f-tour">
                                <div class="row row-pb-md">
                                    <div class="col-md-6">
                                        <div class="row">
                                            <c:forEach var="image" items="${seat.imagesDir}" varStatus="counter2">
                                                <c:if test="${counter2.count <= 4}">
                                                    <div class="col-md-6 animate-box">
                                                        <div class="f-tour-img" style="box-shadow:none; background-image: url(${image});">
                                                        </div>
                                                    </div>  
                                                </c:if>
                                            </c:forEach>
                                        </div>
                                    </div>
                                    <div class="col-md-6 animate-box">
                                        <div class="desc">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <h3>${seat.dto.tourTitle}</h3>
                                                </div>
                                                <div class="col-md-12">
                                                    <input type="hidden" name="tourDetailsID${counter.count - 1}" value="${seat.dto.tourDetailsID}" />
                                                    <h4>Available Seats: ${seat.dto.availableSeats}</h4>
                                                    <div class="row form-group">
                                                        <div class="col-md-3">
                                                            <label for="adultsSeats${counter.count - 1}">Price Adults</label>
                                                        </div>
                                                        <div class="col-md-5">
                                                            <label for="adultsSeats${counter.count - 1}">How many adults are going?</label>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <label for="adultsSeats${counter.count - 1}">Total Price</label>
                                                        </div>
                                                    </div>
                                                    <div class="row form-group">
                                                        <div class="col-md-3">
                                                            <label for="adultsSeats${counter.count - 1}">${seat.dto.priceAdults} USD</label>
                                                        </div>
                                                        <div class="col-md-5">
                                                            <input type="text" name="adultsSeats${counter.count - 1}" value="${seat.adultsSeats}" id="username" class="form-control" onfocusout="updatePrices(this.form)"> 
                                                            <label for="adultsSeats${counter.count - 1}" class="binhpd-error-message">${requestScope.errorObjList.get(counter.count -1).adultsSeatsError}</label>
                                                            <c:if test="${requestScope.errorObjList.get(counter.count -1).adultsSeatsError != null && not empty requestScope.errorObjList.get(counter.count -1).adultsSeatsError}" var="invalidAdultsSeats"></c:if>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <input type="text" name="totalAdultsPrice${counter.count - 1}" value="${seat.totalAdultsPrice}" id="username" class="form-control" readonly="true"> 
                                                        </div>
                                                    </div>
                                                    <div class="row form-group">
                                                        <div class="col-md-3">
                                                            <label for="childrenSeats${counter.count - 1}">Price Children</label>
                                                        </div>
                                                        <div class="col-md-5">
                                                            <label for="childrenSeats${counter.count - 1}">How many children are going?</label>

                                                        </div>
                                                        <div class="col-md-4">
                                                            <label for="childrenSeats${counter.count - 1}">Total Price</label>
                                                        </div>
                                                    </div>
                                                    <div class="row form-group">
                                                        <div class="col-md-3">
                                                            <label for="childrenSeats${counter.count - 1}">${seat.dto.priceChildren} USD</label>
                                                        </div>
                                                        <div class="col-md-5">
                                                            <input type="text" name="childrenSeats${counter.count - 1}" value="${seat.childrenSeats}" id="username" class="form-control" onfocusout="updatePrices(this.form)">
                                                            <label for="childrenSeats${counter.count - 1}" class="binhpd-error-message">${requestScope.errorObjList.get(counter.count -1).childrenSeatsError}</label>
                                                            <c:if test="${requestScope.errorObjList.get(counter.count -1).childrenSeatsError != null && not empty requestScope.errorObjList.get(counter.count -1).childrenSeatsError}" var="invalidChildrenSeats"></c:if>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <input type="text" name="totalChildrenPrice${counter.count - 1}" value="${seat.totalChildrenPrice}" id="username" class="form-control" readonly="true"> 
                                                        </div>
                                                    </div>
                                                    <div class="row form-group">
                                                        <div class="col-md-8">
                                                            <label for="childrenSeats${counter.count - 1}">The amount you have to pay for this tour</label>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <input type="text" name="totalPrice${counter.count - 1}" value="${seat.totalPrice}" id="username" class="form-control" readonly="true"> 
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <c:url var="RemoveFromCartLink" value="CartController">
                                            <c:param name="tourDetailsID" value="${seat.dto.tourDetailsID}"/>
                                            <c:param name="action" value="Remove From Cart"/>
                                        </c:url> 
                                        <a href="${RemoveFromCartLink}" class="btn btn-primary">Remove From Cart</a>
                                        <c:if test="${seat.adultsSeats + seat.childrenSeats == 0}" var="invalidSeats"></c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <div class="row form-group">
                    <label> The amount of money you will have to pay for these tours in USD: <input type="text" name="totalIncome" value="${requestScope.totalPrice}" id="username" class="form-control" readonly="true"></label>
                </div> 
                <div class="form-group">
                    <input type="hidden" name="numberOfOrders" value="${sessionScope.CART.getCart().size()}">
                    <input type="hidden" name="action" id="action" value="Confirm Cart">
                    <input type="submit" value="Confirm Cart" class="btn btn-primary" <c:if test="${requestScope.INVALID_CART != null}">disabled="true"</c:if>>
                </div>
            </form>	
        </c:if>
    </div>
</div>