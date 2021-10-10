<%--
  Created by IntelliJ IDEA.
  User: 陆俊
  Date: 2021/10/7
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>根据编号查询地区</title>

    <script type="text/javascript">
      function main() {
        document.getElementById("select").onclick = search;
      }

      function search() {
        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function () {
          if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById("answer").value = xhr.responseText;
          }
        }

        var id = document.getElementById("id").value;
        var param = "id=" + id;
        xhr.open("get", "search?" + param, true);

        xhr.send();
      }
    </script>
  </head>
  <body onload="main()">
    <center>
      <font style="background-color: greenyellow; color: red; font-size: 35px">根据省份编号获取全称</font>
      <table border="2">
        <tr align="center">
          <td>省份编号</td>
          <td><input id="id" type="text" name="id"></td>
        </tr>

        <tr align="center">
          <td><input id="select" type="button" value="查询"></td>
          <td><input id="answer" type="text" value="loading……"></td>
        </tr>

      </table>
    </center>
  </body>
</html>
