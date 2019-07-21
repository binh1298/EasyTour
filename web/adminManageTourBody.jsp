<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="colorlib-contact">
    <div class="container" style="width: 95%">
        <h2>Manage Tour:</h2>
        <font color="green">${requestScope.SUCCESS}</font><br/>
        <font color="red">${requestScope.ERROR}</font><br/>
        <div class="row">
            <div class="col-md-16 animate-box">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Title</th>
                            <th scope="col">Departure City</th>
                            <th scope="col">Destination</th>
                            <th scope="col">Departure Date</th>
                            <th scope="col">Return Date</th>
                            <th scope="col">Price Adults</th>
                            <th scope="col">Price Children</th>
                            <th scope="col">Available Seats</th>
                            <th scope="col">Duration</th>
                            <th scope="col">Editor</th>
                            <th scope="col">Date Edited</th>
                            <th scope="col">Status</th>
                            <th scope="col">Edit</th>
                            <th scope="col">Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${requestScope.tourDetailsDTO != null}" var="checkVar">
                            <c:forEach var="dto" items="${tourDetailsDTO}" varStatus="counter">
                                <tr class="animate-box">
                                    <th scope="row">${dto.tourDetailsID}</th>
                                    <td>${dto.tourTitle}</td>
                                    <td>${dto.depatureCity}</td>
                                    <td>${dto.destination}</td>
                                    <td>${dto.depatureDateTime}</td>
                                    <td>${dto.returnDateTime}</td>
                                    <td>${dto.priceAdults}</td>
                                    <td>${dto.priceChildren}</td>
                                    <td>${dto.availableSeats}/${dto.totalAvailableSeats}</td>
                                    <td>${dto.duration} Days</td>
                                    <td>${dto.creatorUsername}</td>
                                    <td>${dto.dateTimeCreated}</td>
                                    <td>${dto.status}</td>
                                    <c:url var="EditTourLink" value="MainController">
                                        <c:param name="submit" value="Edit Tour"/>
                                        <c:param name="status" value="${dto.status}"/>
                                        <c:param name="tourDetailsID" value="${dto.tourDetailsID}"/>
                                    </c:url>
                                    <td><a href="${EditTourLink}">Edit</a></td>
                                    <c:url var="DeleteTourLink" value="MainController">
                                        <c:param name="submit" value="Delete Tour"/>
                                        <c:param name="tourDetailsID" value="${dto.tourDetailsID}"/>
                                    </c:url>
                                    <td><a href="${DeleteTourLink}">Delete</a></td>
                                </tr>    
                            </c:forEach>
                        </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>