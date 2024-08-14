<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import ="com.mycom.myapp.user.dto.UserDto" %>
<%
	response.setheader("Cache-Control", "no-cache,no-store,nust-revalidate");
%>
<%
	UserDto userDto = (UserDto) session.getAttribute("userDto");
	System.out.println(userDto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- http://localhost:8080/pages/board -->
<!--  http://localhost:8080/pages/login -->

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/alertify.min.js"></script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/alertify.min.css"/>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/themes/default.min.css"/>

<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container">
    <a class="navbar-brand" href="#"><img alt="" src="/assets/img/user/<%=userDto.getUserProfileImage()%>" style="width:24px; height: 24px; border-radius: 50%;"></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="/pages/board">게시판</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>         
      </ul>
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="/auth/logout">Logout</a>
        </li>        
      </ul>
    </div>
  </div>
</nav>

<div class="container mt-3">
  <h4 class="text-center">게시판</h4>       
  
    <div class="input-group mb-3">
      <input id="inputSearchWord" type="text" class="form-control" placeholder="Search">
      <button id="btnSearchWord" class="btn btn-success" type="button">Search</button>
    </div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>#</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일시</th>
                <th>조회수</th>
            </tr>
        </thead>
        <tbody id="boardTbody">
        </tbody>
    </table>
   
    <div id="paginationWrapper"></div>
    <button class="btn btn-sm btn-primary" id="btnInsertPage">글쓰기</button>
</div>
<script>
	
	let LIST_ROW_COUNT =10;
	let OFFSET=0;
	
	window.onload=fuction(){
		
		listBoard();
	}
	
	
	async function listBoard() {
	    let url = "/boards/list"
	    let urlParams="?limit="+ LIST_ROW_COUNT +"&offset" +OFFSET
	    let response = await fetch(url + urlParams);
	    let data = await response.json();
	    
	    if( data.result == "success" ){ // 게시판 페이지 이동
	        console.log(data)
	    }else if( data.result == "fail" ){
	        alert("이메일 또는 비밀번호가 올바르지 않습니다.");
	    }
	}
	
</script>


</body>
</html>