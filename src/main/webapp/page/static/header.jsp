<%--
  Created by IntelliJ IDEA.
  User: SiletFlower
  Date: 2020/11/14
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-select.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-select.min.css">
<style>
    #headnav{
        display: flex;
        align-items: center;
        border-radius: 0px!important;
        font-weight: bold;
        border: none;
        margin: 0;
    }

    #ma{
        display: flex;
        width: 100%;
        flex-direction: row;
        margin: 0;
        padding: 0;
        justify-content: space-between;
    }

    #bs-example-navbar-collapse-1{
        margin-right: 25px;
    }


    #xiala{
        float: none;
        z-index: 100;
        overflow:visible;
    }

    body{
        background-color:#1F2037;
    }

</style>

<nav id="headnav" class="navbar navbar-inverse" style="height: 10%;background-color: #333B54" >
    <div id="ma" style="color: #ffffff;z-index: 999">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header" style="margin-left: 52px">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="glyphicon glyphicon-home"></span>
            </button>
            <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-shopping-cart"></span><span style="margin-left: 10px">超市管理系统</span></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right pull-right">
                <li><a href="#">欢迎使用</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle"  data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">系统相关<span class="caret"></span></a>
                    <ul class="dropdown-menu" id="xiala">
                        <li><a href="#">个人信息</a></li>
                        <li><a href="#">修改密码</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/utils/logout">退出</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
