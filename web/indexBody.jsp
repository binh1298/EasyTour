<div id="colorlib-reservation">
    <!-- <div class="container"> -->
    <div class="row">
        <div class="search-wrap">
            <div class="container">
                <ul class="nav nav-tabs">
                    <li class="active"><a data-toggle="tab" href="#flight"><i class="flaticon-plane"></i>  Find Tour</a></li>
                </ul>
            </div>
            <div class="tab-content">
                <div id="flight" class="tab-pane fade in active">
                    <form action="MainController" method="POST" class="colorlib-form">
                        <div class="row">
                            <div class="col-md-2">
                                <div class="form-group">
                                    <label for="date">From:</label>
                                    <div class="form-field">
                                        <input type="text" name="depatureCity" value="${requestScope.tourDetailsDTO.depatureCity}" id="location" class="form-control" placeholder="Search Location">
                                    </div>
                                    <h5 class="binhpd-error-message">${requestScope.errorObj.depatureCityError}</h5>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="form-group">
                                    <label for="date">Destination</label>
                                    <div class="form-field">
                                        <input type="text" name="destination" value="${requestScope.tourDetailsDTO.destination}" id="location" class="form-control" placeholder="Search Destination">
                                    </div>    
                                    <h5 class="binhpd-error-message">${requestScope.errorObj.destinationError}</h5>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="form-group">
                                    <label for="date">Check-in:</label>
                                    <div class="form-field">
                                        <i class="icon icon-calendar2"></i>
                                        <input type="text" name="depatureDateTime" value="${requestScope.tourDetailsDTO.depatureDateTime}" id="date" class="form-control date" placeholder="Check-in date">
                                    </div>
                                    <h5 class="binhpd-error-message">${requestScope.errorObj.depatureDateTimeError}</h5>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="form-group">
                                    <label for="date">Check-out:</label>
                                    <div class="form-field">
                                        <i class="icon icon-calendar2"></i>
                                        <input type="text" name="returnDateTime" value="${requestScope.tourDetailsDTO.returnDateTime}" id="date" class="form-control date" placeholder="Check-out date">
                                    </div>
                                    <h5 class="binhpd-error-message">${requestScope.errorObj.returnDateTimeError}</h5>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="form-group">
                                    <label for="guests">Guest</label>
                                    <div class="form-field">
                                        <i class="icon fa fa-user"></i>
                                        <input type="text" name="availableSeats" value="${requestScope.tourDetailsDTO.availableSeats}" id="" class="form-control " placeholder="How many?">
                                    </div>
                                    <h5 class="binhpd-error-message">${requestScope.errorObj.availableSeatsError}</h5>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <input type="submit" name="submit" id="submit" value="Search Tour" class="btn btn-primary btn-block">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<div id="colorlib-services">
    <div class="container">
        <div class="row no-gutters">
            <div class="col-md-3 animate-box text-center aside-stretch">
                <div class="services">
                    <span class="icon">
                        <i class="flaticon-around"></i>
                    </span>
                    <h3>Amazing Travel</h3>
                    <p>Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies</p>
                </div>
            </div>
            <div class="col-md-3 animate-box text-center">
                <div class="services">
                    <span class="icon">
                        <i class="flaticon-boat"></i>
                    </span>
                    <h3>Our Cruises</h3>
                    <p>Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies</p>
                </div>
            </div>
            <div class="col-md-3 animate-box text-center">
                <div class="services">
                    <span class="icon">
                        <i class="flaticon-car"></i>
                    </span>
                    <h3>Book Your Trip</h3>
                    <p>Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies</p>
                </div>
            </div>
            <div class="col-md-3 animate-box text-center">
                <div class="services">
                    <span class="icon">
                        <i class="flaticon-postcard"></i>
                    </span>
                    <h3>Nice Support</h3>
                    <p>Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies</p>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="colorlib-testimony" class="colorlib-light-grey">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3 text-center colorlib-heading animate-box">
                <h2>Our Satisfied Guests says</h2>
                <p>We love to tell our successful far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 col-md-offset-2 animate-box">						
                <div class="owl-carousel2">
                    <div class="item">
                        <div class="testimony text-center">
                            <span class="img-user" style="background-image: url(images/person1.jpg);"></span>
                            <span class="user">Alysha Myers</span>
                            <small>Miami Florida, USA</small>
                            <blockquote>
                                <p>" A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                            </blockquote>
                        </div>
                    </div>
                    <div class="item">
                        <div class="testimony text-center">
                            <span class="img-user" style="background-image: url(images/person2.jpg);"></span>
                            <span class="user">James Fisher</span>
                            <small>New York, USA</small>
                            <blockquote>
                                <p>One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.</p>
                            </blockquote>
                        </div>
                    </div>
                    <div class="item">
                        <div class="testimony text-center">
                            <span class="img-user" style="background-image: url(images/person3.jpg);"></span>
                            <span class="user">Jacob Webb</span>
                            <small>Athens, Greece</small>
                            <blockquote>
                                <p>Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then she continued her way.</p>
                            </blockquote>
                        </div>
                    </div>
                </div>
            </div>
        </div>	
    </div>
</div>