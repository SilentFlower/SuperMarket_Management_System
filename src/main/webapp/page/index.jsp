<%--
  Created by IntelliJ IDEA.
  User: SiletFlower
  Date: 2020/11/13
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script>
    function getToken1(){
        var name = "token" + "=";
        var ca = document.cookie.split(';');
        for(var i=0; i<ca.length; i++)
        {
            var c = ca[i].trim();
            if (c.indexOf(name)==0) return c.substring(name.length,c.length);
        }
        return "";
    }
    var token = getToken1();
    if(token == '' || token == null){
        location.href = "${pageContext.request.contextPath}/utils/goLogin";
    }
</script>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
</head>

<style>
    html,body{
        width:100%;
        height:100%;
    }

    #right-bottom {
        background-image: url("${pageContext.request.contextPath}/fonts/chaoshi2.png");
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
                    <div class="jumbotron" id="jumbotron" style="background:none">
                        <h1 style="color: #1199E5">欢迎使用超市管理系统</h1>
                        <p style="color:#E0E2E3;">这是一个管理商品、供货、销售的多功能系统</p>
                        <p><a class="btn btn-primary btn-lg" role="button">
                            使用规则</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>

    </div>

</body>
</html>
