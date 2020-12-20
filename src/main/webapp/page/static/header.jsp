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
<script src="${pageContext.request.contextPath}/js/bootstrapValidator.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-select.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrapValidator.min.css">
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

    #addNewPasswd .form-group{
        display: flex;
        align-items: center;
        padding-bottom: 10px;
    }


</style>



<nav id="headnav" class="navbar navbar-inverse" style="height: 10%;background-color: #333B54" >
    <div id="ma" style="color: #ffffff;z-index: 999">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header" style="margin-left: 52px">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="glyphicon glyphicon-home"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/utils/goHome"><span class="glyphicon glyphicon-shopping-cart"></span><span style="margin-left: 10px">超市管理系统</span></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right pull-right">
                <li><a href="javascript:void(0);" id="welcome" >欢迎使用</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle"  data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">系统相关<span class="caret"></span></a>
                    <ul class="dropdown-menu" id="xiala">
                        <li><a href="javascript:void(0);"  data-toggle="modal" data-target="#changePassword">修改密码
                            <span class="glyphicon glyphicon-cog"></span>
                        </a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/utils/logout">退出
                            <span class="glyphicon glyphicon-off"></span>
                        </a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="modal fade" id="changePassword" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改密码</h4>
            </div>

            <div class="modal-body" style="height: auto">
                <form role="form" id="addNewPasswd">

                    <div class="form-group">
                        <label for="pre_passwd" class="col-sm-2 control-label">当前密码</label>
                        <div class="col-sm-10">
                            <input type="password" name="pre_passwd" class="form-control" id="pre_passwd"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="new_passwd" class="col-sm-2 control-label">新密码</label>
                        <div class="col-sm-10">
                            <input type="password" name="new_passwd" class="form-control" id="new_passwd"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="new_passwd_agin" class="col-sm-2 control-label">重复新密码</label>
                        <div class="col-sm-10">
                            <input type="password" name="new_passwd_agin" class="form-control" id="new_passwd_agin"/>
                        </div>
                    </div>
                </form>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="changePaswd" disabled>提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script>

    $(function () {
        var user = getUserInfo();
        $("#welcome").html("<span class='glyphicon glyphicon-tags'></span>   "+user.employee_name+" 欢迎使用");
    });

    $("body").on('click','#changePaswd',function () {
        var pre_passwd = $("#pre_passwd").val();
        var now_passwd = $("#new_passwd").val();
        var user = getUserInfo();
        var date = {
            "pre_passwd":pre_passwd,
            "now_passwd":now_passwd,
            "u_id":user.u_id
        }
        $.ajax({
            url:"${pageContext.request.contextPath}/utils/changePasswd",
            type:"POST",
            dataType:"json",
            data:date,
            success:function (result) {
                console.log(result);
                if(result == true){
                    alert("密码修改成功,即将推出登陆");
                    location.reload();
                }else{
                    alert("密码修改失败，请检查原密码是否正确");
                }
            }
        })

    });

    function x10() {
        $("#changePassword").bootstrapValidator({
            submitButtons:'#changePaswd',
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                pre_passwd: {
                    message: '密码验证失败',
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        },
                        stringLength:{
                            min:5,
                            max:18,
                            message:'用户名长度必须为5到18位'
                        }
                    }
                },
                new_passwd:{
                    message: '密码验证失败',
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        },
                        stringLength:{
                            min:6,
                            max:18,
                            message:'用户名长度必须为6到18位'
                        }
                    }
                },
                new_passwd_agin:{
                    message: '密码验证失败',
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        },
                        stringLength:{
                            min:6,
                            max:18,
                            message:'用户名长度必须为6到18位'
                        },
                        identical:{
                            message: "密码不一致",
                            field:"new_passwd"
                        }
                    }
                }
            }
        });
    }

    function  getToken(){
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
        var user;
        $.ajax({
            url:"${pageContext.request.contextPath}/utils/getUserInfo",
            data:"token="+getToken(),
            type:"POST",
            async : false,
            dataType:"json",
            success:function (result) {
                user = result;
            }
        })
        return user;
    }
</script>
