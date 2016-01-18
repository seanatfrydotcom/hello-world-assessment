<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <style>
	  input.uppercase {
	    text-transform: uppercase;
	  }
  </style>
  
</head>
<body>
<div class="container">
	<h1>User Registration Form</h1>
 
	<form:form method="post" name="myForm" modelAttribute="userEntity" onsubmit="return validateForm()" role="form" action="registerUser">
		<div class="form-group">
			<label for="firstName">First Name:</label>
			<form:input path="firstName" name="firstName" maxlength="50" class="form-control mytextbox" id="firstName" placeholder="Enter first name"></form:input><br/>
		</div>
		<div class="form-group">
			<label for="lastName">Last Name:</label>
		 	<form:input path="lastName" name="lastName" maxlength="50" class="form-control mytextbox" id="lastName" placeholder="Enter last name"></form:input><br/>
		</div>
		<div class="form-group">
			<label for="address1">Address1:</label>
		 	<form:input path="address1" name="address1" maxlength="100" class="form-control" id="address1" placeholder="Enter address1"></form:input><br/>
		</div>
		<div class="form-group">
			<label for="address2">Address2:</label>
		 	<form:input path="address2" maxlength="100" class="form-control" id="address2" placeholder="Enter address2"></form:input><br/>
		</div>
		<div class="form-group">
			<label for="city">City:</label>
		 	<form:input path="city" name="city" maxlength="100" class="form-control mytextbox" id="city" placeholder="Enter city"></form:input><br/>
		</div>
		<div class="form-group">
			<label for="state">State:</label>
		 	<form:input path="state" name="state" maxlength="2" class="form-control uppercase mytextbox" id="state" placeholder="Enter state"></form:input><br/>
		</div>
		<div class="form-group">
			<label for="postalCode">Postal Code:</label>
		 	<form:input path="postalCode" name="postalCode" maxlength="5" class="form-control allownumericwithoutdecimal" id="postalCode" placeholder="Enter postal code"></form:input><br/>
		</div>
		<div class="form-group">
			<label for="country">Country:</label>
		 	<form:select path="country" name="country" maxlength="2" class="form-control" id="country" placeholder="Select country">
		 	  <option value="US">United States</option>
		 	</form:select><br/>
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form:form>
</div>
</body>
</html>
<script type="text/javascript">
$(".allownumericwithoutdecimal").on("keypress keyup blur",function (event) {    
    $(this).val($(this).val().replace(/[^\d].+/, ""));
     if ((event.which < 48 || event.which > 57)) {
         event.preventDefault();
     }
 });
 
$(".mytextbox").on("keypress", function(event) {

    // Disallow anything not matching the regex pattern (A to Z uppercase, a to z lowercase and white space)
    // For more on JavaScript Regular Expressions, look here: https://developer.mozilla.org/en-US/docs/JavaScript/Guide/Regular_Expressions
    var englishAlphabetAndWhiteSpace = /[A-Za-z ]/g;
   
    // Retrieving the key from the char code passed in event.which
    // For more info on even.which, look here: http://stackoverflow.com/q/3050984/114029
    var key = String.fromCharCode(event.which);
    
    //alert(event.keyCode);
    
    // For the keyCodes, look here: http://stackoverflow.com/a/3781360/114029
    // keyCode == 8  is backspace
    // keyCode == 37 is left arrow
    // keyCode == 39 is right arrow
    // englishAlphabetAndWhiteSpace.test(key) does the matching, that is, test the key just typed against the regex pattern
    if (event.keyCode == 8 || event.keyCode == 37 || event.keyCode == 39 || englishAlphabetAndWhiteSpace.test(key)) {
        return true;
    }

    // If we got this far, just return false because a disallowed key was typed.
    return false;
});

$('#mytextbox').on("paste",function(e)
{
    e.preventDefault();
});

function validateForm() {
    var x = document.forms["myForm"]["firstName"].value;
    if (x == null || x == "") {
        alert("First name must be filled out");
        return false;
    }
    x= document.forms["myForm"]["lastName"].value;
    if (x == null || x == "") {
        alert("Last name must be filled out");
        return false;
    }
    x= document.forms["myForm"]["address1"].value;
    if (x == null || x == "") {
        alert("Address1 must be filled out");
        return false;
    }
    x= document.forms["myForm"]["city"].value;
    if (x == null || x == "") {
        alert("City must be filled out");
        return false;
    }
    x= document.forms["myForm"]["state"].value;
    if (x == null || x == "") {
        alert("State must be filled out");
        return false;
    }
    x= document.forms["myForm"]["postalCode"].value;
    if (x == null || x == "") {
        alert("Postal code must be filled out");
        return false;
    }
    x= document.forms["myForm"]["country"].value;
    if (x == null || x == "") {
        alert("Country must be selected");
        return false;
    }
}

</script>