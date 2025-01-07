<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="sanket.niwate.model.*"%>
<%
    // Retrieve the User object from the session
    User auth = (User) request.getSession().getAttribute("auth");

    // Check if the user is not logged in (auth is null)
    if (auth != null) {
        // Redirect to the login page if the user is not authenticated
        response.sendRedirect("login.jsp");
    } else {
        // Set the user object as a request attribute
        request.setAttribute("auth", auth);
    }
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    List<Cart> cartProduct = null;
    if (cart_list != null) {
    	
    	request.setAttribute("cart_list", cart_list);
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="includes/header.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>
	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">User Login</div>
			<div class="card-body">
				<form action="user-login" method="post">
					<div class="form-group">
						<label>Email Address:</label> <input type="email"
							class="form-control" name="login-email"
							placeholder="Enter Your Email" required="required">
					</div>
					<div class="form-group mt-2">
						<label>Password:</label> <input type="password"
							class="form-control" name="login-password"
							placeholder="Enter Your Password" required="required">
					</div>

					<div class="text-center">
						<button type="submit" class="btn btn-primary mt-3">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@include file="includes/footer.jsp"%>
</body>
</html>