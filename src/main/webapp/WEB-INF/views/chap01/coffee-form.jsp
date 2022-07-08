<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>

    <style>
        .con {
            width: 80%;
            margin: auto;
            border: 1px solid #000;
            text-align: center;
        }

        .con #coffee {
            width: 20%;
            height: 50px;
            font-size: 24px;
        }

    </style>
</head>

<body>
    <div class="con">
        <h1>커피 주문서</h1>
        <h2># 주문 목록</h2>
        <select name="coffee" id="coffee">
            <option value="americano">아메리카노</option>
            <option value="latte">카페라떼</option>
          </select>
        <h2># 가격: </h2>
    </div>
</body>

</html>