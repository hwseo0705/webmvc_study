<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>

    <!-- reset css -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">

    <!-- bootstrap css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        .container {
            width: 80%;
            margin: auto;
        }

        .container .showBoardGroup {
            width: 80%;
            margin: 0 auto;
        }


        .container .showBoard {
            width: 100%;
            margin-top: 20px;
        }

        .container .showBoard label {
            margin-bottom: 7px;
            display: block;
        }

        .container .showBoard input {
            padding: 10px;
            width: 100%;
            border-radius: 10px;
        }

        .container .showBoard #content {
            vertical-align: top;
            height: 400px;
            width: 100%;
            padding: 10px;
            border-radius: 10px;
        }

        .container .showBoardGroup .wrapBtn {
            width: 100%;
            margin-top: 50px;
            display: flex;
            justify-content: center;
        }
    </style>

</head>

<body>

    <form action="/board/postWrite" method="POST">

        <div class="container">
            <div class="showBoardGroup">

                <div class="showBoard">
                    <label>
                        작성자
                    </label>
                    <input type="text" name="writer" placeholder="이름을 입력하세요">
                </div>

                <div class="showBoard">

                    <label>
                        글제목
                    </label>
                    <input type="text" name="title" placeholder="글제목 입력하세요">
                </div>

                <div class="showBoard">
                    <label>
                        내용
                    </label>
                    <textarea id="content" name="content"></textarea>
                </div>

                <div class="wrapBtn">
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <button id="writeBtn" type="submit" class="btn btn-primary">글 작성하기</button>
                        <button id="listBtn" type="button" class="btn btn-primary">목록으로</button>
                    </div>
                </div>
            </div>

        </div>
    </form>

    <script>
        // const $write = document.querySelector('#writeBtn');

        // $write.addEventListener('click', e => {
        //     if (!e.target.matches('#writeBtn')) return;

        //     e.preventDefault();
        //     console.log('클릭이벤트 발동! ', e.target)

        //     location.href = '/board/write'
        // });

        const $list = document.querySelector('#listBtn');

        $list.addEventListener('click', e => {
            if (!e.target.matches('#listBtn')) return;

            e.preventDefault();
            console.log('클릭이벤트 발동! ', e.target)

            location.href = '/board/list'
        });
    </script>

</body>

</html>