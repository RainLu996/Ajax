使用Ajax的局部刷新：

    注意！注意！！注意！！！
        并不是浏览器向服务端发起请求，而是浏览器内存中的异步对象（XMLHttpRequest）向浏览器发送请求！

----------------前端工作------------------------------------------------------------------------------------------------
    1、新建jsp文件，使用XMLHttpRequest异步对象
        使用异步对象的四个步骤：
        -创建 异步对象
        -绑定 函数事件
        -初始化 异步对象
        -发送 请求


----------------后端工作-------------------------------------------------------------------------------------------------
    2、创建服务器的servlet动态资源文件，接收并处理数据，把数据输出给异步对象