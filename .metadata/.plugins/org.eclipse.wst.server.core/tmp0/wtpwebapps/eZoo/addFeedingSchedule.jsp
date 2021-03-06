		<!-- Header -->
	<jsp:include page="header.jsp" />
	
	<!-- JSTL includes -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
<!-- 	Just some stuff you need -->
	<header>
	  <div class="container">
	  
	<c:choose>
	<c:when test="${not empty message }">
	  <p class="alert ${messageClass}">${message }</p>
	<%
	  session.setAttribute("message", null);
	  session.setAttribute("messageClass", null);
	%>
	</c:when>
	</c:choose>
	
		<h1>eZoo <small>Add Feeding Schedule</small></h1>
		<hr class="paw-primary">
		
		<form action="addFeedingSchedule" method="post" class="form-horizontal">
		
			  <div class="form-group">
			    <label for="id" class="col-sm-4 control-label">ID</label>
			    <div class="col-sm-4">
			      <input type="number" class="form-control" id="id" name="id" placeholder="ID" required="required"/>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="feedingTime" class="col-sm-4 control-label">Feeding Time</label>
			    <div class="col-sm-4">
			      <input type="text" class="form-control" id="feedingTime" name="feedingTime" placeholder="Feeding Time" required="required"/>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="healthStatus" class="col-sm-4 control-label">Recurrence</label>
			    <div class="col-sm-4">
						<select required="required" name="recurrence" class="form-control">
							<option value="Every Hour">
								Every Hour
							</option>
							<option value="Every 5 Hours">
								Every 5 Hours
							</option>
							<option value="Everyday">
								Everyday
							</option>
							<option value="Every 2 Day">
								Every 2 days
							</option>
							<option value="Every Week">
								Every Week
							</option>
						</select>
				</div>
			  </div>	
				
			  <div class="form-group">
			    <label for="food" class="col-sm-4 control-label">Food</label>
			    <div class="col-sm-4">
					<input type="text" class="form-control" id="food" name="food" placeholder="Food" required="required"/>	
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="note" class="col-sm-4 control-label">Note</label>
			    <div class="col-sm-4">
					<input type="text" class="form-control" id="note" name="note" placeholder="Note" required="required"/>	
			    </div>
			  </div>
		  	
		  	<div class="form-group">
		    	<div class="col-sm-offset-4 col-sm-1">
		      		<button type="submit" class="btn btn-primary">Add</button>
		    	</div>
		  	</div>
		</form>
	  </div>
	</header>


	<!-- Footer -->
	<jsp:include page="footer.jsp" />