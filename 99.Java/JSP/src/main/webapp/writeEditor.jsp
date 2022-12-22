<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <title>게시판 샘플 프로젝트</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/77ad8525ff.js" crossorigin="anonymous"></script>
    <style>
        * { font-family: 'Noto Sans KR', sans-serif; }
        a { text-decoration: none; }
        th, td { text-align: center; }
    </style>
    <script src="https://cdn.ckeditor.com/4.18.0/standard/ckeditor.js"></script>
</head>

<body>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
        <div class="container-fluid">
            <ul class="navbar-nav">
                <a class="navbar-brand ms-5 me-5" href="#">
                    <img src="../img/ckworld-logo.png" alt="Logo" style="height:36px;" class="rounded-3">
                </a>
                <li class="nav-item">
                    <a class="nav-link" href="#"><i class="fa-solid fa-house"></i> Home</a>
                </li>
                <li class="nav-item ms-3">
                    <a class="nav-link ${(menu eq 'board') ? "active" : ''}" href="/bbs/board/list?p=1&f=&q="><i class="far fa-list-alt"></i> 게시판</a>
                </li>
                <li class="nav-item ms-3">
                    <a class="nav-link ${(menu eq 'user') ? "active" : ''}" href="/bbs/user/list?page=1"><i class="fas fa-user-friends"></i> 사용자</a>
                </li>
                <li class="nav-item ms-3">
                    <a class="nav-link" href="/bbs/user/logout"><i class="fas fa-sign-out-alt"></i> 로그아웃</a>
                </li>
            </ul>
            <span class="navbar-text me-3">${uname}님 환영합니다.</span>
        </div>
    </nav>

    <div class="container" style="margin-top: 80px;">
        <div class="row">
            <div class="col-sm-3"></div>
            
            <!-- =================== main =================== -->
            <div class="col-sm-9">
            	<h3><strong>게시글 쓰기</strong></h3>
            	<hr>
                <div class="row">
			        <div class="col-1"></div>
			        <div class="col-10">
			            <form action="/bbs/board/fileupload" method="post" enctype="multipart/form-data">
			                <table class="table table-borderless">
			                    <tr>
			                        <td><label for="title">제목</label></td>
			                        <td><input class="form-control" type="text" name="title" id="title"></td>
			                    </tr>
			                    <tr>
			                        <td><label for="content">내용</label></td>
			                        <td>
			                        	<textarea class="form-control" name="content" id="content" rows="10"></textarea>
			                        </td>
			                    </tr>
			                    <tr>
			                        <td><label for="files">첨부파일</label></td>
			                        <td><input class="form-control" type="file" name="files" id="files" multiple></td>
			                    </tr>
			                    <tr>
			                        <td colspan="2" style="text-align: center;">
			                            <input class="btn btn-primary" type="submit" value="제출">
			                            <input class="btn btn-secondary" type="reset" value="취소">
			                        </td>
			                    </tr>
			                </table>
			            </form>
			        </div>
			        <div class="col-1"></div>
			    </div>
            </div>
            <!-- =================== main =================== -->
            
        </div>
    </div>

	<nav class="navbar navbar-expand-sm bg-light fixed-bottom">
        <div class="container-fluid justify-content-center">
            <span class="navbar-text">
                Copyright &copy; 2021-2022 CK World Corp. All rights reserved.
            </span>
        </div>
    </nav>
    <script>
        CKEDITOR.replace('content', {
            filebrowserImageUploadUrl: '/imageupload',
            filebrowserUploadMethod: 'form',
            height:400, width:800,
        });
    </script>
</body>
</html>