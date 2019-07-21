<div class="colorlib-wrap">
    <div class="container">
        <div class="row">
            <!-- Add details form-->
            <div class="col-md-12">
                <div class="sidebar-wrap">
                    <div class="side search-wrap animate-box">
                        <h2 class="sidebar-heading">Enter Tour Details</h2>
                        <form action="MainController" method="POST" class="colorlib-form">
                            <br/>
                            <h3 class="sidebar-heading">Enter Identifications</h3>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="">Tour Title</label>
                                        <div class="form-field">
                                            <i class="icon fas fa-key"></i>
                                            <input type="text" name="tourTitle" value="${requestScope.tourDetailsDTO.tourTitle}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.tourTitleError}</h5>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="">Number of journeys</label>
                                        <div class="form-field">
                                            <i class="icon fas fa-key"></i>
                                            <input type="text" name="numberOfJourneys" readonly="true" value="${requestScope.tourDetailsDTO.numberOfJourneys}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.numberOfJourneysError}</h5>
                                    </div>
                                </div>
                            </div> 
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="">Tour Details ID</label>
                                        <div class="form-field">
                                            <i class="icon fas fa-key"></i>
                                            <input type="text" name="tourDetailsID" readonly="true" value="${requestScope.tourDetailsDTO.tourDetailsID}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.tourDetailsIDError}</h5>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="">Status</label>
                                        <div class="form-field">
                                            <i class="icon fas fa-key"></i>
                                            <input type="text" name="status" value="${requestScope.tourDetailsDTO.status}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.statusError}</h5>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="">Creator Username</label>
                                        <div class="form-field">
                                            <i class="icon fas fa-key"></i>
                                            <input type="text" name="creatorUsername" value="${requestScope.tourDetailsDTO.creatorUsername}" id="date" class="form-control" placeholder="" readonly="true">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.creatorUsernameError}</h5>
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
                                            <input type="text" name="depatureCity" value="${requestScope.tourDetailsDTO.depatureCity}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.depatureCityError}</h5>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="">Destination</label>
                                        <div class="form-field">
                                            <i class="icon icon-location"></i>
                                            <input type="text" name="destination" value="${requestScope.tourDetailsDTO.destination}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.destinationError}</h5>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="">Duration</label>
                                        <div class="form-field">
                                            <i class="icon icon-location"></i>
                                            <input type="text" name="duration" value="${requestScope.tourDetailsDTO.duration}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.durationError}</h5>
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
                                            <input type="text" name="depatureDateTime" value="${requestScope.tourDetailsDTO.depatureDateTime}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.depatureDateTimeError}</h5>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="">Arrival Time</label>
                                        <div class="form-field">
                                            <i class="icon icon-clock"></i>
                                            <input type="text" name="depatureArrivalDateTime" value="${requestScope.tourDetailsDTO.depatureArrivalDateTime}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.depatureArrivalDateTimeError}</h5>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="">Flight Name</label>
                                        <div class="form-field">
                                            <i class="icon icon-plane"></i>
                                            <input type="text" name="depatureFlightName" value="${requestScope.tourDetailsDTO.depatureFlightName}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.depatureFlightNameError}</h5>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="">Return Date</label>
                                        <div class="form-field">
                                            <i class="icon icon-calendar2"></i>
                                            <input type="text" name="returnDateTime" value="${requestScope.tourDetailsDTO.returnDateTime}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.returnDateTimeError}</h5>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="">Arrival Time</label>
                                        <div class="form-field">
                                            <i class="icon icon-clock"></i>
                                            <input type="text" name="returnArrivalDateTime" value="${requestScope.tourDetailsDTO.returnArrivalDateTime}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.returnArrivalDateTimeError}</h5>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="">Flight Name</label>
                                        <div class="form-field">
                                            <i class="icon icon-plane"></i>
                                            <input type="text" name="returnFlightName" value="${requestScope.tourDetailsDTO.returnFlightName}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.returnFlightNameError}</h5>
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
                                            <input type="text" name="hotelDescription" value="${requestScope.tourDetailsDTO.hotelDescription}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.hotelDescriptionError}</h5>
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
                                            <input type="text" name="guideName" value="${requestScope.tourDetailsDTO.guideName}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.guideNameError}</h5>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="">Address</label>
                                        <div class="form-field">
                                            <i class="icon icon-location"></i>
                                            <input type="text" name="guideAddress" value="${requestScope.tourDetailsDTO.guideAddress}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.guideAddressError}</h5>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="">Phone Number</label>
                                        <div class="form-field">
                                            <i class="icon icon-phone3"></i>
                                            <input type="text" name="guidePhoneNumber" value="${requestScope.tourDetailsDTO.guidePhoneNumber}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.guidePhoneNumberError}</h5>
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
                                            <input type="text" name="gatherDateTime" value="${requestScope.tourDetailsDTO.gatherDateTime}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.gatherDateTimeError}</h5>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="">Place of Gathering</label>
                                        <div class="form-field">
                                            <i class="icon icon-location"></i>
                                            <input type="text" name="gatherPlace" value="${requestScope.tourDetailsDTO.gatherPlace}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.gatherPlaceError}</h5>
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
                                            <input type="text" name="priceAdults" value="${requestScope.tourDetailsDTO.priceAdults}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.priceAdultsError}</h5>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="">Children (From 5 years old to under 12 years old)</label>
                                        <div class="form-field">
                                            <i class="icon fa fa-user"></i>
                                            <input type="text" name="priceChildren" value="${requestScope.tourDetailsDTO.priceChildren}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.priceChildrenError}</h5>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="">Total Available Seats</label>
                                        <div class="form-field">
                                            <i class="icon fa fa-user"></i>
                                            <input type="text" name="totalAvailableSeats" value="${requestScope.tourDetailsDTO.totalAvailableSeats}" id="date" class="form-control" placeholder="">
                                        </div>
                                        <h5 class="binhpd-error-message">${requestScope.errorObj.totalAvailableSeatsError}</h5>
                                    </div>
                                </div>
                            </div>  
                            <div class="row">
                                <<div class="col-md-12">
                                    <input type="submit" name="submit" id="submit" value="Update Details" class="btn btn-primary btn-block">
                                </div>
                            </div>  
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

