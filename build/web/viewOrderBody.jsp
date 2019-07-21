<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="colorlib-contact">
    <div class="container" style="width: 95%">
        <h2>Manage My Orders:</h2>
        <font color="green">${requestScope.SUCCESS}</font><br/>
        <font color="red">${requestScope.ERROR}</font><br/>
        <c:if test="${requestScope.orderDtoList != null && not empty requestScope.orderDtoList}" var="hasOrder">
            <c:forEach items="${requestScope.orderDtoList}"  var="order" varStatus="counter">
                <div class="row" style="border-bottom: 1px solid black;">
                    <div class="col-md-3">
                        <h3>Order number #${counter.count}</h3>
                        <div class="row">
                            <div class="col-md-12">
                                <label for="">Total Payment: ${order.totalIncome}</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <label for="">Status: ${order.status}</label>
                            </div>
                        </div>
                        <c:if test="${order.status == 'Pending'}">
                            <div class="row">
                                <div class="col-md-12">
                                    <form action="MainController" method="POST">
                                        <input type="hidden" name="orderID" value="${order.orderID}" />
                                        <input type="submit" name="submit" value="Cancel Order" class="btn btn-primary">
                                    </form>
                                </div>
                            </div>
                        </c:if>
                    </div>
                    <div class="col-md-8 animate-box">
                        <h3>Includes the following tours:</h3>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">Tour Details</th>
                                    <th scope="col">Adults Seats</th>
                                    <th scope="col">Children Seats</th>
                                    <th scope="col">Total Seats</th>
                                    <th scope="col">Total Children Price</th>
                                    <th scope="col">Total Adults Price</th>
                                    <th scope="col">Total Price</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.orderDetailsListLists.get(counter.count-1)}" var="orderDetails">
                                    <tr class="animate-box">
                                        <td>${orderDetails.tourDetailsID}</td>
                                        <td>${orderDetails.adultsSeats}</td>
                                        <td>${orderDetails.childrenSeats}</td>
                                        <td>${orderDetails.totalSeats}</td>
                                        <td>${orderDetails.totalChildrenPrice}</td>
                                        <td>${orderDetails.totalAdultsPrice}</td>
                                        <td>${orderDetails.totalPrice}</td>
                                    </tr>    
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:forEach>
        </c:if>
        <c:if test="${!hasOrder}">
            <h2>You have not booked anything yet</h2>
        </c:if>
    </div>
</div>