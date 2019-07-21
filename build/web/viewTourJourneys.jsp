<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="colorlib-wrap">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-12">
                        <div class="wrap-division">
                            <div class="col-md-12 col-md-offset-0 heading2 animate-box">
                                <h2>${requestScope.tourDetailsDTO.tourTitle}</h2>
                            </div>
                            <c:if test="${not empty requestScope.Journeys}" var="existJourney">
                                <c:forEach var="journey" items="${requestScope.Journeys}" varStatus="counter">
                                    <div class="row">
                                        <div class="col-md-12 animate-box">
                                            <div class="room-wrap">
                                                <div class="row">
                                                    <div class="col-md-6 col-sm-6">
                                                        <div class="room-img" style="background-image: url(${journey.imageDirectory});"></div>
                                                    </div>
                                                    <div class="col-md-6 col-sm-6">
                                                        <div class="desc">
                                                            <span class="day-tour">${journey.timeStamp}</span>
                                                            <h2>${journey.title}</h2>
                                                            <p>${journey.description}</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>