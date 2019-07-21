<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="colorlib-contact">
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1 animate-box">
                <form action="MainController" method="POST" enctype="multipart/form-data">
                    <div id="journey-parent">
                        <h3>Enter the journeys of this tour</h3>
                        <font color="red">${requestScope.INVALID}</font><br/>
                        <div class="row form-group">
                            <div class="col-md-12">
                                <label for="tourDetailsID">Tour Details ID</label>
                                <input type="text" name="tourDetailsID" value="${requestScope.tourDetailsID}" readonly="true" id="title" class="form-control" placeholder="">
                            </div>
                        </div>
                        <c:if test="${requestScope.journeys != null}">
                            <c:forEach var="journey" items="${requestScope.journeys}" varStatus="counter">
                                <div class="journey-container">
                                    <h3>Enter #${counter.count} Journey</h3>
                                    <div class="row form-group">
                                        <div class="col-md-6">
                                            <div class="row form-group">
                                                <div class="col-md-12 padding-bottom">
                                                    <label for="timeStamp">Time stamp <span class="binhpd-error-message">${requestScope.errorObjects.get(counter.count - 1).timeStampError}</span></label>
                                                    <input type="text" name="timeStamp" value="${journey.timeStamp}" id="timeStamp" class="form-control" placeholder="">
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col-md-12">
                                                    <label for="title">Title <span class="binhpd-error-message">${requestScope.errorObjects.get(counter.count - 1).titleError}</span></label>
                                                    <input type="text" name="title" value="${journey.title}" id="title" class="form-control" placeholder="">
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <label class="form-control btn btn-default btn-file" >
                                                    <span style="display: block; margin-top: 5px">Browse Image</span> <input type="file" name="fileInput" style="display: none;" accept="image/jpeg, image/png" onchange="updateImage(this, this.name)">
                                                </label>
                                            </div>

                                        </div>
                                        <div class="col-md-6">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12" >
                                                    <c:if test="${tempDir.get(counter.count-1) != null && not empty tempDir.get(counter.count-1)}" var="uploadedImg">
                                                        <div class="room-img" style="border: 1px solid rgba(0, 0, 0, 0.1); background-image: url('${tempDir.get(counter.count-1)}') ">
                                                            <span class="binhpd-error-message">${requestScope.errorObjects.get(counter.count - 1).descriptionError}</span>
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${!uploadedImg}">
                                                        <div class="room-img" style="border: 1px solid rgba(0, 0, 0, 0.1); background-image: url('${journey.imageDirectory}') ">
                                                            <span class="binhpd-error-message">${requestScope.errorObjects.get(counter.count - 1).descriptionError}</span>
                                                        </div>
                                                    </c:if>
                                                    <input type="hidden" name="temporaryImgDir" value="${tempDir.get(counter.count-1)}"/>
                                                    <input type="hidden" name="imageDirectory" value="${journey.imageDirectory}">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col-md-12">
                                            <label for="description">Description <span class="binhpd-error-message">${requestScope.errorObjects.get(counter.count - 1).descriptionError}</span></label>
                                            <textarea name="description" value="" id="description" cols="30" rows="10" class="form-control" placeholder="">${journey.description}</textarea>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>

                    </div>
                    <input type="hidden" name="numberOfJourneys" value="${requestScope.journeys.size()}">
                    <div class="form-group text-center">
                        <input type="submit" name="submit" value="Add Journeys" class="btn btn-primary">
                    </div>
                </form>	
                <script type="text/javascript">
                    putNameFieldsIndex();
                </script>
            </div>
            <div class="col-md-10 col-md-offset-1 animate-box">
                <h3>Contact Information</h3>
                <div class="row contact-info-wrap">
                    <div class="col-md-3">
                        <p><span><i class="icon-location"></i></span> 198 West 21th Street, <br> Suite 721 New York NY 10016</p>
                    </div>
                    <div class="col-md-3">
                        <p><span><i class="icon-phone3"></i></span> <a href="tel://1234567920">+ 1235 2355 98</a></p>
                    </div>
                    <div class="col-md-3">
                        <p><span><i class="icon-paperplane"></i></span> <a href="mailto:info@yoursite.com">info@yoursite.com</a></p>
                    </div>
                    <div class="col-md-3">
                        <p><span><i class="icon-globe"></i></span> <a href="#">yoursite.com</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>