<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://unpkg.com/dropzone@5/dist/min/dropzone.min.css" type="text/css" />
    <script src="https://unpkg.com/dropzone@5/dist/min/dropzone.min.js"></script>
    <title>파일 업로드</title>
</head>
<body style="margin:50px;">
    <h1>파일 업로드</h1>
    <hr>
    <form action="/upload2" method="post" enctype="multipart/form-data">
        파일1: <input type="file" name="file1"><br>
        파일2: <input type="file" name="file2"><br>
        param1: <input type="text" name="param1"><br>
        param2: <input type="text" name="param2"><br>
        <input type="submit" value="Upload">
    </form>
    <form action="/target" class="dropzone" id="my-great-dropzone"></form>

<script>
  Dropzone.options.myGreatDropzone = { // camelized version of the `id`
    paramName: "file", // The name that will be used to transfer the file
    maxFilesize: 2, // MB
    accept: function(file, done) {
      if (file.name == "justinbieber.jpg") {
        done("Naha, you don't.");
      }
      else { done(); }
    }
  };
</script>
</body>
</html>