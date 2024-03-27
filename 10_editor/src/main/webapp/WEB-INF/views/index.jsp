<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" 
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" 
        crossorigin="anonymous"></script>
        
<!-- include libraries(jquery,jsp) -->        
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet"> 
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script> 
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 

<!-- include summernote css/js -->        
<link rel="stylesheet" href="${contextPath}/resources/summernote-0.8.18-dist/summernote.min.css" />
<script src="${contextPath}/resources/summernote-0.8.18-dist/summernote.min.js"> </script>
<script src="${contextPath}/resources/summernote-0.8.18-dist/lang/summernote-ko-kr.js"> </script>
</head>
<body>

  <form method="POST" action="">
    <div>
      <textarea id="contents" name="contents"></textarea>
    </div>
    <div>
    <button type="submit">전송</button>
    </div>
    
    <script type="text/javascript">
    </script>

  </form>
  
  <script>
  
  $('#contents').summernote();
  
  </script>

</body>
</html>