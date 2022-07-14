<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- reset css -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">

    <!-- bootstrap css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">


    <!-- bootstrap js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" defer></script>

    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <style>
        .wrap {
            width: 70%;
            margin: auto;
            margin-top: 100px;
        }

        .wrap table tr:hover td {
            background: orange;
        }

    </style>

</head>

<body>

    <div class="wrap">
        <table class="table table-dark table-hover">
            <tr>
                <th>번호</th>
                <th>작성자</th>
                <th>제목</th>
                <th>조회수</th>
                <th>작성시간</th>
            </tr>

            <c:forEach var="b" items="${boards}">
                <tr>
                    <td>${b.boardNo}</td>
                    <td>${b.writer}</td>
                    <td>${b.title}</td>
                    <td>${b.viewCnt}</td>
                    <td>${b.regDate}</td>
                </tr>
            </c:forEach>

        </table>

        <a class="btn btn-outline-primary" href="/board/write">글쓰기</a>
    </div>


     <script>
        const $board = document.querySelector('.table');

        $board.addEventListener('click', e => {
            if (!e.target.matches('.table td')) return;

            e.preventDefault();
            // console.log('클릭이벤트 발동! ', e.target)

            let bno = e.target.parentElement.firstElementChild.textContent;

            location.href='/board/content?boardNo='+ bno
        });
        
    </script>
</body>

</html>