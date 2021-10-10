<%--
  Created by IntelliJ IDEA.
  User: 陆俊
  Date: 2021/10/6
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Ajax-局部刷新</title>

  <script type="text/javascript">
    /* 使用浏览器内存中的异步对象，代替浏览器发送请求；异步对象使用JS管理 */

    function doAjax() {
      /* 0、创建异步对象 */
      var xhr = new XMLHttpRequest();

      //绑定事件
      xhr.onreadystatechange = function () {
        //处理服务器返回的数据，更新当前页面

        //测试：
        //window.alert("readyState = " + xhr.readyState + ";status = " + xhr.status);

        /* 4、异步请求对象已经将数据【解析完毕】 */
        if (xhr.readyState === 4 && xhr.status === 200) {  //请求成功，且拿到了数据
          //输出从服务器返回来的数据
          //window.alert(xhr.responseText);

          //获取数据，更新DOM对象
          /* 3、异步对象【接收】从服务端返回的应答数据（原始数据）*/
          document.getElementById("data").value = xhr.responseText;
        }
      }

      //初始化请求数据
      //获取DOM对象的value属性值
      var name = document.getElementById("name").value;
      var weight = document.getElementById("weight").value;
      var high = document.getElementById("high").value;

      //凭借参数字符串
      var param = "&name=" + name + "&weight=" + weight + "&high=" + high;
      //window.alert("param" + param);

      /* 1、【初始化】异步请求对象 */
      xhr.open("get", "one?" + param, true);

      /* 2、向浏览器中指定的Servlet动态资源文件发起请求（异步对象【发送请求】） */
      xhr.send();
    }

    function main() {
      //为 id="calc" 的绑定单击事件
      var calc = document.getElementById("calc");
      calc.onclick = doAjax;
    }
  </script>
</head>

<body onload="main()">
<center>
  <font style="font-size: 35px; color: greenyellow; background-color: red">个人BMI指标计算器</font>
  <table border="2">
    <tr align="center">
      <td>姓名</td>
      <td><input id="name" type="text" name="name"></td>
    </tr>

    <tr align="center">
      <td>体重（单位：公斤）</td>
      <td><input id="weight" type="text" name="weight"></td>
    </tr>

    <tr align="center">
      <td>身高（单位：米）</td>
      <td><input id="high" type="text" name="high"></td>
    </tr>

    <tr align="center">
      <td><input id="calc" type="button" value="计算BMI"></td>
      <td><input id="data" type="text" value="loading……"></td>
    </tr>
  </table>
</center>
</body>
</html>
