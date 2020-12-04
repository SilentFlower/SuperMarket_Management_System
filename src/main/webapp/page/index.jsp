<%--
  Created by IntelliJ IDEA.
  User: SiletFlower
  Date: 2020/11/13
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
</head>

<style>
    html,body{
        width:100%;
        height:100%;
    }
</style>


<body>

    <jsp:include page="static/header.jsp"/>


    <div class="container-fluid" id="mid" style="height: 90%">


        <jsp:include page="static/left.jsp"/>

        <div id="main" class="col-md-10" style="height: 100%">

            <div id="right-top" style="height: 8%">
                <div id="mianbao">
                    <div id="url_name">
                        <h4 style="color: #2aabd2">首页</h4>
                    </div>
                    <div id="url_name2">
                        <ul class="breadcrumb">
                            <li class="active"><a href="#">首页</a></li>
                        </ul>
                    </div>
                </div>
            </div>


            <div style="height: 92%;padding-top: 10px;">
                <div id="right-bottom" style="height: 100%;border-radius: 10px;">
                    <div>
                        <a href="">有内容</a>
                    </div>
                </div>

            </div>
        </div>

    </div>

</body>
</html>
