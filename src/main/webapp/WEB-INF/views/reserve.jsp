<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="UI" uri="/WEB-INF/views/UITag.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>Car Rental</title>
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?key=AIzaSyDSIncL9vyNi3EcOfB3nl8pR8OW1gHkzkc&libraries=places"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="resources/js/reserve.js"></script>
<UI:UITag type="dependency"/>
</head>
<body style="font-family: Arial; font-size: 12px;">	
<div><a href="${pageContext.request.contextPath}/welcome">Home</a></div>
	<UI:UITag type="header"/>
	<div class="searcher">
	<div style="float: right;">${Iuser}</div>
		<div class="row">
			<div class="col searchterm input-field">
				<div class="row">
					<div class="input-field col s6">
						<input id="from-input" class="controls" type="text"
							value="Atlanta" placeholder="Enter location"> <label
							for="from-input">From Location</label>
					</div>
					<div class="input-field col s6">
						<input type="date" id="from-date" placeholder="from date"
							value="2013-01-08">
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6">
						<input id="to-input" class="controls" type="text" value="new york"
							placeholder="Enter location"> <label for="to-input">To
							Location</label>
					</div>
					<div class="input-field col s6">
						<input type="date" id="to-date" placeholder="from date"
							value="2013-01-08">
					</div>
				</div>
				<div class="row">
					<div class="col" >
						<div id="searchResults" style="width:470px"></div>
						<div id="error"></div>
					</div>
				</div>
				<div class="row" style="margin: auto">
					<div class="col">
						<a class="waves-effect waves-light btn" id="search">Search</a> <a
							class="waves-effect waves-light btn" id="reserve">Reserve</a>
					</div>
				</div>
			</div>
			<div class="col input-field">
				<div style="width: 500px;">
					<div id="map" style="width: 478px; height: 400px;"></div>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		var input1 = (document.getElementById('from-input'));
		var input2 = (document.getElementById('to-input'));
		 var options = {
				  types: ['(cities)'],
				  componentRestrictions: {country: "us"}
				 };
		var autocomplete = new google.maps.places.Autocomplete(input1,options);
		var autocomplete = new google.maps.places.Autocomplete(input2,options);

		var directionsService = new google.maps.DirectionsService();
		var directionsDisplay = new google.maps.DirectionsRenderer();

		var map = new google.maps.Map(document.getElementById('map'), {
			zoom : 7,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		});

		directionsDisplay.setMap(map);
		autocomplete.bindTo('bounds', map);
		var from = 0;
		var to = 0;
		function drawRoute() {
			console.log(from + "  " + to)
			if (from != 0 && to != 0) {
				var request = {
					origin : from,
					destination : to,
					travelMode : google.maps.DirectionsTravelMode.DRIVING
				};
				directionsService.route(request, function(response, status) {
					if (status == google.maps.DirectionsStatus.OK) {
						directionsDisplay.setDirections(response);
					}
				});
			}
		}

		$(document)
				.ready(
					function() {
						$('#from-input, #to-input').focus(function (e) 
								{
								    $('.pac-container').each( function() {
								        $(this).html( '' );
								    });
								});
						$("#from-input, #to-input")
								.keypress(
										function(e) {
											if (e.which == 13) {
												var firstResult = $(".pac-container .pac-item:first").text();
												var geocoder = new google.maps.Geocoder();
												geocoder.geocode({"address" : firstResult},
																function(results,status) {
																	if (status == google.maps.GeocoderStatus.OK) {
																		if(e.target.id=='from-input')
																			from = results[0].address_components[0].long_name;
																		else
																			to = results[0].address_components[0].long_name;
																		setTimeout(drawRoute,100)
																	}
																});
											} else {
												$(".pac-container").css("visibility","visible");
											}
										})
						});
		$(document)
				.ready(
						function() {
							function search() {
								var Error = "";
								if ($("#from-input").val() == "")
									Error = "destination address, ";
								if ($("#to-input").val() == "")
									Error += "departing address, ";
								if ($("#from-date").val() == "")
									Error += "from date, ";
								if ($("#to-date").val() == "")
									Error += "to date";
								if (!(Error.length == 0))
									$("#error").text("Please Enter " + Error)
								else
									$.ajax(
													"search",
													{
														"type" : "GET",
														"dataType" : "json",
														"data" : {
															"fromLocation" : $("#from-input").val(),
															"toLocation" : $("#to-input").val(),
															"fromDate" : $("#from-date").val(),
															"toDate" : $("#to-date").val()
														}
													})
											.done(
													function(data) {
														$("#searchResults").empty();
														$("#searchResults").addClass("searchContents")
														console.log("data is: "+ data)
														if (data.length == 0)
															$("#searchResults").append("<p>Sorry we can not find a car for you now</p>")
														else {
															function compareFrom(a, b) {
																if (a.distFromLocation < b.distFromLocation)
																	return -1;
																if (a.distFromLocation > b.distFromLocation)
																	return 1;
																return 0;
															}
															data.sort(compareFrom);
															for (var i = 0; i < data.length; i++) {
																var car = $("#searchResults").append("<div></div>");
																var distFromLocation = (data[i].distFromLocation + "").split(".");
																if(distFromLocation.length>0)
																	distFromLocation = distFromLocation[0];
																car.append( "<div><input type='radio' name='carId' value='"+data[i].id+"' id='"+data[i].id+"'><label for='"+data[i].id+"'></label>"
																		+"<span class='carData'><span class='carDataType'>Name</span><span class='carDataValue'>" + data[i].name + "</span></span>"
																		+"<span class='carData'><span class='carDataType'>Price</span><span class='carDataValue'>" + data[i].price + "</span></span>"
																		+"<span class='carData'><span class='carDataType'>Name</span><span class='carDataValue'>" + data[i].name + "</span></span>"																		
																		+"<span class='carData'><span class='carDataType'>Seats</span><span class='carDataValue'>" + data[i].seats + "</span></span>"
																		+"<span class='carData'><span class='carDataType'>City</span><span class='carDataValue'>" + data[i].branchCity+ "</span></span>"
																		+"<span class='carData'><span class='carDataType'>Distance</span><span class='carDataValue'>" + distFromLocation+ "</span></span>"
																		+ "</div><br>");
																car.append("<div style='margin:2px' class='car'><img src='resources/images/" + data[i].imageLink+"' width='100px'></img></div>")
															}
														}
													})
							}
							function reserve() {
								var Error = "";
								if ($("#from-input").val() == "")
									Error = "destination address, ";
								if ($("#to-input").val() == "")
									Error += "departing address, ";
								if ($("#from-date").val() == "")
									Error += "from date, ";
								if ($("#to-date").val() == "")
									Error += "to date";
								if (!(Error.length == 0))
									$("#error").text("Please Enter " + Error)
								else {
									$
											.ajax(
													"reserveRequest",
													{
														"type" : "GET",
														"data" : {
															"fromLocation" : $(
																	"#from-input")
																	.val(),
															"toLocation" : $(
																	"#to-input")
																	.val(),
															"fromDate" : $(
																	"#from-date")
																	.val(),
															"toDate" : $(
																	"#to-date")
																	.val(),
															"carId" : $(
																	"input[name='carId']:checked")
																	.val()
														}
													}).done(function(data) {
												console.log(data)
												$("#searchResults").empty();
												$("#searchResults").removeClass("searchContents")
											})
								}
							}
							$("#reserve").click(reserve);
							$("#search").click(search);
						});
	</script> 
</body>
</html>