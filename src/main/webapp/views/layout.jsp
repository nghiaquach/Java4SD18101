<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FPT POLYTECHNIC</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <style>
        main {
            padding: 10px;
        }
        
        .card-footer {
            padding-left: 200px;
        }
        
        .formUpdate .row .btn {
            margin-right: 10px;
            margin-left: 15px;
            margin-top: 10px;
        }
        
        .form-check .form-check-label {
            margin-right: 30px;
        }
        
        footer {
            margin-top: 305px;
        }
        
        .page_card_footer {
            margin-left: 30%;
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
	<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>   
</head>
<body>
<header>
		<c:url var="home" value="/home"></c:url>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">FPT POLYTECHNIC CAN THO CITY</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="${home}/index">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${home}/about">About US</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${home}/contact">Contact US</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <main>
        <jsp:include page="${view}"></jsp:include>
    </main>
    <footer class="bg-dark text-center text-white">
        <div class="container p-4 pb-0">
            <section class="mb-4">
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"><i class="fab fa-facebook-f"></i
            ></a>
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"><i class="fab fa-twitter"></i
            ></a>
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"><i class="fab fa-google"></i
            ></a>
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"><i class="fab fa-instagram"></i
            ></a>
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"><i class="fab fa-linkedin-in"></i
            ></a>
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"><i class="fab fa-github"></i
            ></a>
            </section>
        </div>
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            © 2023 FPT Polytechnic Cần Thơ
        </div>
    </footer>
</body>
</html>