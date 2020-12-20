<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap-select.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrapValidator.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-select.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrapValidator.min.css">
    <title>登录</title>
    <style>
        @keyframes wrapper-gradient{
            0% {
                transform: translateY(-100%);
                opacity: 0;
            }

            100% {
                transform: translateY(0);
                opacity: 1.0;
            }
        }

        .gradient-wrapper {
            display: inline-block;
            overflow: hidden;
            animation: wrapper-gradient 2s linear;
        }

        body{
            display: flex;
            justify-content: center;
            align-items: center;
        }
        #main {
            width: 40%;
            background: #ffffff;
            border-radius: 10px;
            text-align: center;
            box-shadow: 0 30px 60px 0 rgba(0, 0, 0, .3);
            animation: wrapper-gradient 1s ease-in-out;
        }
    </style>
</head>
<body style="background-color: #56baed;height: 100%">
<div class="container" id="main" data-toggle="modal">
    <div>
        <div>
            <h2>超市管理后台系统</h2>
        </div>

        <div style="margin-top: 40px">
            <span class="glyphicon glyphicon-shopping-cart" style="font-size: 50px"></span>
        </div>

        <form id="form" class="form-horizontal" style="margin-top: 50px" method="post" action="javascript:void(0);">
            <div class="form-group">
                <label for="inputEmail3" class="col-md-offset-1 col-sm-2 control-label">用户名</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="user_name" id="inputEmail3" placeholder="username">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-md-offset-1  col-sm-2 control-label">密码</label>
                <div class="col-sm-8">
                    <input type="password" class="form-control" name="password" id="inputPassword3" placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <div>
                    <div class="checkbox">
                        <label>
                            <input name="remember" type="checkbox" checked onclick="javascript:document.getElementById('remember').value=this.checked;">记住密码
                            <input name="remember" type="hidden" value="false" id="public">
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class>
                    <button type="submit" class="btn btn-lg btn-primary" name="submit" id="submit">登录</button>
                </div>
            </div>
        </form>
    </div>


</div>

</body>

<script>

    function getToken(){
        var name = "token" + "=";
        var ca = document.cookie.split(';');
        for(var i=0; i<ca.length; i++)
        {
            var c = ca[i].trim();
            if (c.indexOf(name)==0) return c.substring(name.length,c.length);
        }
        return "";
    }

    function getUserInfo() {
        $.ajax({
            url:"${pageContext.request.contextPath}/utils/getUserInfo",
            data:"token="+getToken(),
            type:"POST",
            dataType:"json",
            success:function (result) {
                console.log(result);
            }
        })
    }


    $(function () {
        getUserInfo();
        $("form").bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                user_name: {
                    message: '用户名验证失败',
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        },
                        stringLength:{
                            min:5,
                            max:18,
                            message:'用户名长度必须为6到18位'
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        },
                        stringLength:{
                            min:6,
                            max:18,
                            message:'密码长度必须为6到18位'
                        }

                    }
                }
            }
        });
    });

    $("#submit").click(function () {

       $.ajax({
           url:"${pageContext.request.contextPath}/login/login",
           type:"POST",
           data:$("#form").serialize(),
           dataType:"json",
           success:function (result) {
               if(result == true){
                   location.href = "${pageContext.request.contextPath}/utils/goHome";
               }else {
                   alert("用户名或密码错误");
               }
           }
       });
   });


</script>
</html>