<%--
  Created by IntelliJ IDEA.
  User: 陆俊
  Date: 2021/10/7
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用JSON的Ajax案例：根据编号查询地区详细信息</title>

    <script type="text/javascript">
        function main() {
            document.getElementById("submit").onclick = search;
        }

        function search() {
            var xhr = new XMLHttpRequest();

            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    var data = xhr.responseText;

                    //eval函数作用：执行括号中的代码，把JSON字符串转换为JSON对象
                    var jsonObj = eval("(" + data +")");
                    updateDOM(jsonObj);
                }
            }

            var id = document.getElementById("id").value;
            var param = "id=" + id;
            xhr.open("get", "updateSearch?" + param, true);

            xhr.send();
        }

        //更新DOM对象
        function updateDOM(jsonObj) {
            document.getElementById("name").value = jsonObj.name;
            document.getElementById("simpleName").value = jsonObj.simpleName;
            document.getElementById("province").value = jsonObj.province;
        }
    </script>
</head>
<body onload="main()">
  <center>
      <table border="2">
          <tr align="center">
              <td>省份编号</td>
              <td><input id="id" type="text" name="id"></td>
          </tr>

          <tr align="center">
              <td>省份名称</td>
              <td><input id="name" type="text" name="name" value="loading……"></td>
          </tr>

          <tr align="center">
              <td>省份简称</td>
              <td><input id="simpleName" type="text" name="simpleName" value="loading……"></td>
          </tr>

          <tr align="center">
              <td>省会名称</td>
              <td><input id="province" type="text" name="province" value="loading……"></td>
          </tr>

          <tr align="center">
              <td colspan="2"><input id="submit" type="button" value="查询"></td>
          </tr>
      </table>
  </center>
</body>
</html>
