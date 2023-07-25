<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>List Users</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<c:url var="url" value="/UserServlet"/>
	${message}
    <div class="container mt-4">
    	 <form action="${url}/index" method="post">
            <!-- Username -->
            <div class="form-group">
                <label for="username">Username:</label>
                <input value="${form.id}" type="text" class="form-control" id="username" name="id" required>
            </div>

            <!-- Password -->
            <div class="form-group">
                <label for="password">Password:</label>
                <input value="${form.password}" type="password" class="form-control" id="password" name="password" required>
            </div>

            <!-- Full Name -->
            <div class="form-group">
                <label for="fullName">Full Name:</label>
                <input value="${form.fullname}" type="text" class="form-control" id="fullName" name="fullname" required>
            </div>

            <!-- Email Address -->
            <div class="form-group">
                <label for="email">Email Address:</label>
                <input value="${form.email}" type="email" class="form-control" id="email" name="email" required>
            </div>

            <!-- Admin/User Radio Buttons -->
            <div class="form-group">
                <label>Role:</label>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="adminRadio" name="role" ${form.admin?'checked':''} value="true">
                    <label for="adminRadio" class="form-check-label">Admin</label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="userRadio" name="role"  ${form.admin?'':'checked'} value="false">
                    <label for="userRadio" class="form-check-label">User</label>
                </div>
            </div>

            <!-- Buttons -->
            <div class="form-group">
                <button formaction="${url}/create" type="submit" class="btn btn-primary" name="action" value="create">Create</button>
                <button formaction="${url}/update" type="submit" class="btn btn-success" name="action" value="update">Update</button>
                <button  formaction="${url}/delete"type="submit" class="btn btn-danger" name="action" value="delete">Delete</button>
                <button  formaction="${url}/reset" type="submit" class="btn btn-secondary">Reset</button>
            </div>
        </form>
    </div>
    
        <h2>List of Users</h2>
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                     <th>Password</th>
                    <th>Full Name</th>
                    <th>Email</th>
                    <th>Admin</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">
                <tr>                                     
				        <td>${user.id}</td>
				         <td>${user.password}</td>
				        <td>${user.fullname}</td>
				        <td>${user.email}</td>
				        <td>${user.isAdmin() ? "Admin" : "User"}</td>
				        <td><a href="${url}/edit?id=${user.id}">Edit</a></td>				      
                </tr>
                </c:forEach>    
            </tbody>
        </table>
    </div>

    <!-- Bootstrap JS (Make sure to include jQuery before this) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
