<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--<aside id="colorlib-hero">
    <div class="flexslider">
        <ul class="slides">
            <li style="background-image: url(images/img_bg_3.jpg);">
                <div class="overlay"></div>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12 slider-text">
                            <div class="slider-text-inner text-center">
                                <h2>by colorlib.com</h2>
                                <h1>Find Tours</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</aside>-->

<div class="colorlib-wrap">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="row">
                    <div class="wrap-division">
                        <c:if test="${requestScope.INFO != null}" var="checkVar">
                            <c:if test="${not empty requestScope.INFO}" var="foundTour">
                                <c:forEach var="dto" items="${requestScope.INFO}" varStatus="counter">
                                    <div class="col-md-6 col-sm-6 animate-box">
                                        <div class="tour">
                                            <c:url var="ViewTour" value="MainController">
                                                <c:param name="submit" value="View Tour Details"/>
                                                <c:param name="tourDetailsID" value="${dto.tourDetailsID}"/>
                                            </c:url>
                                            <a href="${ViewTour}" class="tour-img" style="background-image: url(${requestScope.AVATAR.get(counter.count - 1)});">
                                                <p class="price"><span>${dto.priceAdults} USD</span> <small>/ ${dto.duration} Days</small></p>
                                            </a>
                                            <span class="desc">
                                                <p class="star"><span><i class="icon-star-full"></i><i class="icon-star-full"></i><i class="icon-star-full"></i><i class="icon-star-full"></i><i class="icon-star-full"></i></span>${dto.depatureDateTime} - ${dto.returnDateTime}</p>
                                                <h2><a href="${ViewTour}">${dto.tourTitle}</a></h2>
                                                <span class="city">${dto.depatureCity} - ${dto.destination}</span>
                                            </span>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>
                            <c:if test="${!foundTour}">
                                <h3>Couldn't find any tour matches your preferences!</h3>
                            </c:if>
                        </c:if> 
                        <c:if test="${!checkVar}">
                            <h3>Please enter valid information so we can get you going!!</h3>
                        </c:if>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 text-center">
                        <ul class="pagination">
                            <!--<li class="disabled"><a href="#">&laquo;</a></li>-->
                            <c:forEach begin="1" end="${requestScope.maximumNumberOfPages}" step="1" varStatus="counter">
                                <c:url var="PagingLink" value="MainController">
                                    <c:param name="requestedPage" value="${counter.count}"/>
                                    <c:param name="depatureCity" value="${requestScope.tourDetailsDTO.depatureCity}"/>
                                    <c:param name="destination" value="${requestScope.tourDetailsDTO.destination}"/>
                                    <c:param name="depatureDateTime" value="${requestScope.tourDetailsDTO.depatureDateTime}"/>
                                    <c:param name="returnDateTime" value="${requestScope.tourDetailsDTO.returnDateTime}"/>
                                    <c:param name="availableSeats" value="${requestScope.tourDetailsDTO.availableSeats}"/>
                                    <c:param name="submit" value="Request Page"/>
                                </c:url>
                                <li <c:if test="${requestScope.requestedPage == counter.count}">class="active"</c:if>><a href="${PagingLink}">${counter.count}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>

            <!-- SIDEBAR-->
            <div class="col-md-3">
                <div class="sidebar-wrap">
                    <div class="side search-wrap animate-box">
                        <h3 class="sidebar-heading">Find your tour</h3>
                        <form action="MainController" method="POST" class="colorlib-form">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="date">Where:</label>
                                        <div class="form-field">
                                            <input type="text" name="depatureCity" value="${requestScope.tourDetailsDTO.depatureCity}" id="location" class="form-control" placeholder="Search Location">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.depatureCityError}</h5>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="date">Destination</label>
                                        <div class="form-field">
                                            <input type="text" name="destination" value="${requestScope.tourDetailsDTO.destination}" id="location" class="form-control" placeholder="Search Destination">
                                        </div>    
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.destinationError}</h5>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="date">Check-in</label>
                                        <div class="form-field">
                                            <i class="icon icon-calendar2"></i>
                                            <input type="text" name="depatureDateTime" value="${requestScope.tourDetailsDTO.depatureDateTime}" id="date" class="form-control date" placeholder="Check-in date">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.depatureDateTimeError}</h5>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="date">Check-out</label>
                                        <div class="form-field">
                                            <i class="icon icon-calendar2"></i>
                                            <input type="text" name="returnDateTime" value="${requestScope.tourDetailsDTO.returnDateTime}" id="date" class="form-control date" placeholder="Check-out date">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.returnDateTimeError}</h5>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="guests">Guest</label>
                                        <div class="form-field">
                                            <input type="text" name="availableSeats" value="${requestScope.tourDetailsDTO.availableSeats}" id="date" class="form-control" placeholder="How many?">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.availableSeatsError}</h5>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <input type="submit" name="submit" id="submit" value="Search Tour" class="btn btn-primary btn-block">
                                </div>
                            </div>
                        </form>
                    </div>
                    <!--                    <div class="side animate-box">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <h3 class="sidebar-heading">Price Range</h3>
                                                    <form method="post" class="colorlib-form-2">
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <label for="guests">Price from:</label>
                                                                    <div class="form-field">
                                                                        <i class="icon icon-arrow-down3"></i>
                                                                        <select name="people" id="people" class="form-control">
                                                                            <option value="#">1</option>
                                                                            <option value="#">200</option>
                                                                            <option value="#">300</option>
                                                                            <option value="#">400</option>
                                                                            <option value="#">1000</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <label for="guests">Price to:</label>
                                                                    <div class="form-field">
                                                                        <i class="icon icon-arrow-down3"></i>
                                                                        <select name="people" id="people" class="form-control">
                                                                            <option value="#">2000</option>
                                                                            <option value="#">4000</option>
                                                                            <option value="#">6000</option>
                                                                            <option value="#">8000</option>
                                                                            <option value="#">10000</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="side animate-box">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <h3 class="sidebar-heading">Review Rating</h3>
                                                    <form method="post" class="colorlib-form-2">
                                                        <div class="form-check">
                                                            <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                                            <label class="form-check-label" for="exampleCheck1">
                                                                <p class="rate"><span><i class="icon-star-full"></i><i class="icon-star-full"></i><i class="icon-star-full"></i><i class="icon-star-full"></i><i class="icon-star-full"></i></span></p>
                                                            </label>
                                                        </div>
                                                        <div class="form-check">
                                                            <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                                            <label class="form-check-label" for="exampleCheck1">
                                                                <p class="rate"><span><i class="icon-star-full"></i><i class="icon-star-full"></i><i class="icon-star-full"></i><i class="icon-star-full"></i></span></p>
                                                            </label>
                                                        </div>
                                                        <div class="form-check">
                                                            <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                                            <label class="form-check-label" for="exampleCheck1">
                                                                <p class="rate"><span><i class="icon-star-full"></i><i class="icon-star-full"></i><i class="icon-star-full"></i></span></p>
                                                            </label>
                                                        </div>
                                                        <div class="form-check">
                                                            <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                                            <label class="form-check-label" for="exampleCheck1">
                                                                <p class="rate"><span><i class="icon-star-full"></i><i class="icon-star-full"></i></span></p>
                                                            </label>
                                                        </div>
                                                        <div class="form-check">
                                                            <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                                            <label class="form-check-label" for="exampleCheck1">
                                                                <p class="rate"><span><i class="icon-star-full"></i></span></p>
                                                            </label>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="side animate-box">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <h3 class="sidebar-heading">Location</h3>
                                                    <form method="post" class="colorlib-form-2">
                                                        <div class="form-check">
                                                            <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                                            <label class="form-check-label" for="exampleCheck1">
                                                                <h4 class="place">Greece</h4>
                                                            </label>
                                                        </div>
                                                        <div class="form-check">
                                                            <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                                            <label class="form-check-label" for="exampleCheck1">
                                                                <h4 class="place">Italy</h4>
                                                            </label>
                                                        </div>
                                                        <div class="form-check">
                                                            <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                                            <label class="form-check-label" for="exampleCheck1">
                                                                <h4 class="place">Spain</h4>
                                                            </label>
                                                        </div>
                                                        <div class="form-check">
                                                            <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                                            <label class="form-check-label" for="exampleCheck1">
                                                                <h4 class="place">Germany</h4>
                                                            </label>
                                                        </div>
                                                        <div class="form-check">
                                                            <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                                            <label class="form-check-label" for="exampleCheck1">
                                                                <h4 class="place">Japan</h4>
                                                            </label>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>-->
                </div>
            </div>
        </div>
    </div>
</div>
