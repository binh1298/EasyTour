<div class="container">
    <div class="row">
        <!-- Add details form-->
        <div class="col-md-12">
            <div class="sidebar-wrap">
                <div class="side search-wrap animate-box">
                    <h2 class="sidebar-heading">Tour Details</h2>
                    <form action="CartController" method="POST" class="colorlib-form">
                        <br/>
                        <h3 class="sidebar-heading">Enter Identifications</h3>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="">Tour Title</label>
                                    <div class="form-field">
                                        <i class="icon fas fa-key"></i>
                                        <input type="text" name="tourTitle" value="${tourDetailsDTO.tourTitle}" id="date" class="form-control" placeholder="" readonly="true">
                                    </div>
                                </div>
                            </div>
                        </div> 
                        <br/>
                        <h3 class="sidebar-heading">Where: </h3>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="">Depature City</label>
                                    <div class="form-field">
                                        <i class="icon icon-location"></i>
                                        <input type="text" name="depatureCity" value="${tourDetailsDTO.depatureCity}" id="date" class="form-control" placeholder="" readonly="true">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="">Destination</label>
                                    <div class="form-field">
                                        <i class="icon icon-location"></i>
                                        <input type="text" name="destination" value="${tourDetailsDTO.destination}" id="date" class="form-control" placeholder="" readonly="true">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="">Duration</label>
                                    <div class="form-field">
                                        <i class="icon icon-location"></i>
                                        <input type="text" name="duration" value="${tourDetailsDTO.duration} Days" id="date" class="form-control" placeholder="" readonly="true">
                                    </div>
                                </div>
                            </div>
                        </div>  
                        <br/>
                        <h3 class="sidebar-heading">Flight Information</h3>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="">Departure Date</label>
                                    <div class="form-field">
                                        <i class="icon icon-calendar2"></i>
                                        <input type="text" name="depatureDateTime" value="${tourDetailsDTO.depatureDateTime}" id="date" class="form-control" placeholder="" readonly="true">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="">Arrival Time</label>
                                    <div class="form-field">
                                        <i class="icon icon-clock"></i>
                                        <input type="text" name="depatureArrivalDateTime" value="${tourDetailsDTO.depatureArrivalDateTime}" id="date" class="form-control" placeholder="" readonly="true">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="">Flight Name</label>
                                    <div class="form-field">
                                        <i class="icon icon-plane"></i>
                                        <input type="text" name="depatureFlightName" value="${tourDetailsDTO.depatureFlightName}" id="date" class="form-control" placeholder="" readonly="true">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="">Return Date</label>
                                    <div class="form-field">
                                        <i class="icon icon-calendar2"></i>
                                        <input type="text" name="returnDateTime" value="${tourDetailsDTO.returnDateTime}" id="date" class="form-control" placeholder="" readonly="true">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="">Arrival Time</label>
                                    <div class="form-field">
                                        <i class="icon icon-clock"></i>
                                        <input type="text" name="returnArrivalDateTime" value="${tourDetailsDTO.returnArrivalDateTime}" id="date" class="form-control" placeholder="" readonly="true">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="">Flight Name</label>
                                    <div class="form-field">
                                        <i class="icon icon-plane"></i>
                                        <input type="text" name="returnFlightName" value="${tourDetailsDTO.returnFlightName}" id="date" class="form-control" placeholder="" readonly="true">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br/>
                        <h3 class="sidebar-heading">Enter Hotel Information</h3>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <div class="form-field">
                                        <i class="icon icon-location"></i>
                                        <input type="text" name="hotelDescription" value="${tourDetailsDTO.hotelDescription}" id="date" class="form-control" placeholder="" readonly="true">
                                    </div>
                                </div>
                            </div>
                        </div>  
                        <br/>
                        <h3 class="sidebar-heading">Enter Guide Information</h3>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="">Guide Name</label>
                                    <div class="form-field">
                                        <i class="icon fa fa-user"></i>
                                        <input type="text" name="guideName" value="${tourDetailsDTO.guideName}" id="date" class="form-control" placeholder="" readonly="true">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="">Address</label>
                                    <div class="form-field">
                                        <i class="icon icon-location"></i>
                                        <input type="text" name="guideAddress" value="${tourDetailsDTO.guideAddress}" id="date" class="form-control" placeholder="" readonly="true">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="">Phone Number</label>
                                    <div class="form-field">
                                        <i class="icon icon-phone3"></i>
                                        <input type="text" name="guidePhoneNumber" value="${tourDetailsDTO.guidePhoneNumber}" id="date" class="form-control" placeholder="" readonly="true">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br/>
                        <h3 class="sidebar-heading">INFORMATION OF GATHERING</h3>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="">Date and Time of Gathering</label>
                                    <div class="form-field">
                                        <i class="icon icon-calendar2"></i>
                                        <input type="text" name="gatherDateTime" value="${tourDetailsDTO.gatherDateTime}" id="date" class="form-control" placeholder="" readonly="true">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="">Place of Gathering</label>
                                    <div class="form-field">
                                        <i class="icon icon-location"></i>
                                        <input type="text" name="gatherPlace" value="${tourDetailsDTO.gatherPlace}" id="date" class="form-control" placeholder="" readonly="true">
                                    </div>
                                </div>
                            </div>
                        </div>  
                        <br/>
                        <h3 class="sidebar-heading">Prices</h3>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="">Adult(From 12 years old and older)</label>
                                    <div class="form-field">
                                        <i class="icon fa fa-user"></i>
                                        <input type="text" name="priceAdults" value="${tourDetailsDTO.priceAdults}" id="date" class="form-control" placeholder="" readonly="true">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="">Children (From 5 years old to under 12 years old)</label>
                                    <div class="form-field">
                                        <i class="icon fa fa-user"></i>
                                        <input type="text" name="priceChildren" value="${tourDetailsDTO.priceChildren}" id="date" class="form-control" placeholder="" readonly="true">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="">Available Seats</label>
                                    <div class="form-field">
                                        <i class="icon fa fa-user"></i>
                                        <input type="text" name="availableSeats" value="${tourDetailsDTO.availableSeats}" id="date" class="form-control" placeholder="" readonly="true">
                                    </div>
                                </div>
                            </div>
                        </div>  
                        <input type="hidden" name="tourDetailsID" value="${tourDetailsDTO.tourDetailsID}" id="date" class="form-control" placeholder="" readonly="true">
                        <div class="row">
                            <<div class="col-md-12">
                                <input type="submit" name="action" id="submit" value="Add To Cart" class="btn btn-primary btn-block">
                            </div>
                        </div>  
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

