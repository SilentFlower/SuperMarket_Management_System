<%--
  Created by IntelliJ IDEA.
  User: SiletFlower
  Date: 2020/11/14
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>员工列表</title>

    <style>
        #right-bottom{
            display: flex;
            flex-direction: column;
        }

        #choose_button{
            display: flex;
            justify-content: space-between;
            padding-top: 20px;
            padding-right: 20px;
        }

        #choose_button div:first-child{
            margin-left: 20px;
        }

        #choose_button div:last-child{
            margin-right: 20px;
        }

        #table{
            height: 100%;
            padding: 20px 12px 0px 12px;
            display: flex;
            overflow: auto;
            justify-content: center;
        }

        #aboutPage{
            display: flex;
            align-items: center;
            justify-content: center;
        }

        #pageMax{
            margin-right: 10px;
        }


        #right-bottom table{
            border: none;
            padding: 0 0 0 0;
            border: 1px solid #24263E;
            background-color: #333B54;
            color:#6B7D8D;
            align-items: center;
        }

        .table>tbody>tr>td{
            border: 1px solid #24263E !important;
        }

        .table>thead>tr>th{
            border: 2px solid #24263E !important;
        }

        td,th {
            text-align: center !important;
        }

        #addModal .form-group,#editModal .form-group{
            display: flex;
            align-items: center;
            padding-bottom: 10px;
        }

        #admin-from,#admin-from2{
            display: flex;
            align-items: center;
            justify-content: center;
        }

        #address-from,#address-from2{
            display: flex;
            align-items: center;
            justify-content: center;
        }

        #aboutSex,#aboutSex2{
            margin-left: 12px;
        }


        #isAdm,#isAdm2{
            margin-left: -8px;
        }

        table{
            table-layout:fixed;
        }

        .addr,.emi{
            width: 100px;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;

        }

        thead th{
            font-size: 16px;
        }

        #group_main{
            margin-top: 20px;
            display: flex;
            height: auto;
            align-items: center;
            justify-content: center;
            flex-direction: row;
        }

        #group_add{
            margin-top: 10px;
            display: flex;
            height: auto;
            align-items: center;
            justify-content: center;
            flex-direction: column;
        }

        #group_add > div{
            display: flex;
            flex-direction: row;
            margin-top: 10px;
        }

        #button_group{
            display: flex;
            flex-direction: row;
            justify-content: space-between;
        }

        #button_group:after,#button_group:before{
            content: none;
        }

    </style>

</head>
<body>

    <jsp:include page="static/header.jsp"/>

    <div class="container-fluid" id="mid">


        <jsp:include page="static/left.jsp"/>

        <div id="main" class="col-md-10" style="height: 100%;">

            <div id="right-top" style="height: 8%">
                <div id="mianbao">
                    <div id="url_name">
                        <h4 style="color: #2aabd2">员工列表</h4>
                    </div>
                    <div id="url_name2">
                        <ul class="breadcrumb">
                            <li><a href="${pageContext.request.contextPath}/utils/goHome">首页</a></li>
                            <li class="active">员工管理</li>
                            <li class="active"><a href="${pageContext.request.contextPath}/employee/getEmployee">员工列表</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div style="height: 92%;padding-top: 10px;">
                <div id="right-bottom" style="height: 100%;border-radius: 10px;">

                    <div id="choose_button">
                        <div id="forSearch">
                            <span class="btn btn-primary" id="searchEmployee" data-toggle="modal" data-target="#searchModal">筛选</span>
                        </div>

                        <div id="foraddOrDelete">
                            <span class="btn btn-info" id="addEployee" data-toggle="modal" data-target="#addModal">新增</span>
                            <span class="btn btn-danger" id="deleteEmployees" data-toggle="modal" data-target="#deleteModal">批量删除</span>
                        </div>
                    </div>

                    <div id="table">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th class="col-md-1"><input type="checkbox" id="allCheck"><span style="margin-left: 10px">选择</span></th>
                                    <th class="col-md-2">员工姓名</th>
                                    <th class="col-md-1">性别</th>
                                    <th class="col-md-3">住址</th>
                                    <th class="col-md-2">电话</th>
                                    <th class="col-md-3">邮件</th>
                                    <th class="col-md-2">相关操作</th>
                                </tr>
                            </thead>
                            <tbody id="emplo">
                            </tbody>
                        </table>
                    </div>

                    <div id="aboutPage">

                        <div id="pageMax">
                            <div class="dropup">
                                <button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">每页记录
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu pull-right" role="menu" id="aboutpageMax" aria-labelledby="dropdownMenu1">
                                    <li role="presentation" value="5">
                                        <a role="menuitem" tabindex="-1" href="javascript:void(0)">5条/页</a>
                                    </li>
                                    <li role="presentation" value="10">
                                        <a role="menuitem" tabindex="-1" href="javascript:void(0)">10条/页</a>
                                    </li>
                                    <li role="presentation" value="20">
                                        <a role="menuitem" tabindex="-1" href="javascript:void(0)">20条/页</a>
                                    </li>
                                </ul>
                            </div>
                        </div>

                        <div id="Pagination" >
                            <ul class="pagination">
                                <li><a href="#">&laquo;</a></li>
                                <li class="active"><a href="#">1</a></li>
                                <li><a href="#">&raquo;</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>
        </div>

    </div>


    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">添加新员工</h4>
                </div>

                <div class="modal-body">
                    <form role="form" id="addNewEmployee">
                        <div class="form-group">
                            <label for="account" class="col-sm-2 control-label">员工账号</label>
                            <div class="col-sm-10">
                                <input type="text" name="user_name" class="form-control" id="account" placeholder="账号">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="accountPwd" class="col-sm-2 control-label">账号密码</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" name="password" id="accountPwd" placeholder="密码">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="trueName" class="col-sm-2 control-label">员工姓名</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="employee_name" id="trueName" placeholder="姓名">
                            </div>


                            <div id="aboutSex">
                                <label for="optionsRadios3" class="control-label">员工性别</label>
                                <label class="radio-inline">
                                    <input type="radio" name="employee_sex" id="optionsRadios3" value="man" checked>男
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="employee_sex" id="optionsRadios4"  value="woman">女
                                </label>
                            </div>


                        </div>

                        <div class="form-group">
                            <label for="tel" class="col-sm-2 control-label">员工电话</label>
                            <div class="col-sm-4">
                                <input type="number" class="form-control" name="employee_tel" id="tel" placeholder="电话">
                            </div>

                            <label for="emi" class="col-sm-2 control-label">员工邮箱</label>
                            <div class="col-sm-4">
                                <input type="email" class="form-control" name="employee_email" id="emi" placeholder="邮箱">
                            </div>
                        </div>

                        <div class="form-group" id="admin-from">
                            <label for="isAdm" class="control-label">是否为管理员</label>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="isAdmin" id="isAdm" value="true">
                                </label>
                            </div>
                        </div>

                        <div class="form-group" id="address-from">
                            <label for="address">住址</label>
                            <textarea class="form-control" id="address" name="employee_addr" rows="3"></textarea>
                        </div>






                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="addNew">提交更改</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel2">修改员工信息</h4>
                </div>

                <div class="modal-body">
                    <form role="form" id="editEmployee">
                        <div class="form-group">
                            <label for="account2" class="col-sm-2 control-label">员工账号</label>
                            <div class="col-sm-10">
                                <input type="text" name="user_name" class="form-control" id="account2" disabled>
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="accountPwd" class="col-sm-2 control-label">账号密码</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" name="password" id="accountPwd2" placeholder="密码">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="trueName" class="col-sm-2 control-label">员工姓名</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="employee_name" id="trueName2" placeholder="姓名">
                            </div>


                            <div id="aboutSex2">
                                <label for="options3" class="control-label">员工性别</label>
                                <label class="radio-inline">
                                    <input type="radio" name="employee_sex" id="options3" value="man" checked>男
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="employee_sex" id="options4"  value="woman">女
                                </label>
                            </div>


                        </div>

                        <div class="form-group">
                            <label for="tel2" class="col-sm-2 control-label">员工电话</label>
                            <div class="col-sm-4">
                                <input type="number" class="form-control" name="employee_tel" id="tel2" placeholder="电话">
                            </div>

                            <label for="emi2" class="col-sm-2 control-label">员工邮箱</label>
                            <div class="col-sm-4">
                                <input type="email" class="form-control" name="employee_email" id="emi2" placeholder="邮箱">
                            </div>
                        </div>

                        <div class="form-group" id="admin-from2">
                            <label for="isAdm2" class="control-label">是否为管理员</label>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="isAdmin" id="isAdm2" value="true">
                                </label>
                            </div>
                        </div>

                        <div class="form-group" id="address-from2">
                            <label for="address2">住址</label>
                            <textarea class="form-control" id="address2" name="employee_addr" rows="3"></textarea>
                        </div>




                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="edit">提交更改</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="delete">删除确认</h4>
                </div>
                <div class="modal-body">
                    <div class="alert alert-danger" role="alert">
                        Warning! 你正在删除员工数据！
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消删除</button>
                    <button type="button" class="btn btn-danger" id="deleteEmployee">提交删除</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <div class="modal fade" id="searchModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">过滤器</h4>
                </div>

                <div class="modal-body">

                    <div style="height: auto;" id="serach">

                        <div id="group_key" style="margin-top: 20px;width: 100%;">

                            <div class="form-group" id="group_main">
                                <select class="form-control chose_1" id="select">
                                    <option>邮箱</option>
                                    <option>姓名</option>
                                    <option>用户名</option>
                                    <option>住址</option>
                                    <option>电话</option>
                                </select>
                                <select class="form-control chose_2" id="haokan">
                                    <option>模糊</option>
                                </select>
                                <input type="text" class="form-control chose_3" placeholder="值">
                                <button type="submit" class="btn btn-default chose_4" id="sub">
                                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                </button>
                            </div>

                            <div class="form-group" id="group_add">

                            </div>

                        </div>

                    </div>

                </div>

                <div class="modal-footer" id="button_group">
                    <div>
                        <button type="button" class="btn btn-danger" id="reset_button">重置</button>
                    </div>
                    <div>
                        <button type="button" class="btn btn-default cancel" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary" id="search_button">检索</button>
                    </div>

                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <div style="display: none">
        <form action="${pageContext.request.contextPath}/employee/getEmployee" method="post" id="submit" >
            <input type="text" value="" name="employee">
            <input type="text" value="${page.pageSize}" name="pageSize">
            <input type="text" value="${page.currentPage}" name="currentPage">
        </form>
    </div>


</body>

    <script>
        var cho = [];//已经选择的字段

        $(function () {
            getKey();
            page();
            getEmployee();
        });

        function submit() {
            $("#submit").submit();
        }

        function addKey(key,value) {
            var newAdd = '<div>';
            newAdd += '<input class="form-control chose_1"  type="text" disabled value='+key+'>';
            newAdd += '<input class="form-control chose_2"  type="text" disabled value="模糊">';
            newAdd += '<input class="form-control chose_3"  type="text" disabled value="'+value+'">';
            newAdd += '<button type="submit" class="btn btn-default chose_4" id="remove">\n' +
                '          <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>\n' +
                '      </button>';
            newAdd += '</div>';
            $("#group_add").append(newAdd);
        }

        function getKey() {
            var keys = ${employeeKeyword};
            var k = JSON.stringify(keys);
            $("#submit input").eq(0).prop("value",k);
            var key;
            var value;
            for(var name in keys){
                if(keys[name] != null){
                    if(name == "employee_name"){
                        key = "姓名";
                    }else if(name == "employee_addr"){
                        key = "住址";
                    }else if(name == "employee_tel"){
                        key = "电话";
                    }else if(name == "employee_email"){
                        key = "邮箱";
                    }else if(name == "user"){
                        key = "用户名";
                    }else if(name == "supplier_bankcard"){
                        key = "银行卡号";
                    }
                    if(name == "user"){
                        value = keys[name].user_name;
                    }else{
                        value = keys[name];
                    }
                    cho.push(key);
                    addKey(key, value);
                }
            }
        }

        function page() {
            var pageCount = ${page.pageCount};
            var currentPage = ${page.currentPage};
            var min = 1;
            var max = pageCount;
            var pre = currentPage - 1;
            var next = currentPage + 1;
            if(pre < 1){
                pre = pageCount;
            }
            if(next > pageCount){
                next = 1;
            }

            if(currentPage > 6 && pageCount > 10){
                min = currentPage - 5;
                max = min+9;
                if(max > pageCount){
                    max = pageCount;
                    min = max - 9;
                }
            }else if(pageCount > 10){
                min = 1;
                max = 10;
            }

            var page = '<li value="'+pre+'"><a href="javascript:void(0)">&laquo;</a></li>';
            for (var i = min;i <= max;i++){
                if(i == currentPage){
                    page +='<li class="active" value="'+i+'"><a href="javascript:void(0)">'+i+'</a></li>'
                }else {
                    page +='<li value="'+i+'"><a href="javascript:void(0)">'+i+'</a></li>'
                }
            }
            page += '<li value="'+next+'"><a href="javascript:void(0)">&raquo;</a></li>';

            $("#Pagination ul").html(page);
        }

        function getEmployee(){
            var employees = ${employees};
            var w = $("#emplo");
            w.empty();
            $(employees).each(function(i,item){
                w.append('<tr>\n' +
                    '        <td><input type="checkbox"></td>\n' +
                    '            <td>'+item.employee_name+'</td>\n' +
                    '            <td>'+item.employee_sex+'</td>\n' +
                    '            <td class="addr">'+item.employee_addr+'</td>\n' +
                    '            <td>'+item.employee_tel+'</td>\n' +
                    '            <td class="emi">'+item.employee_email+'</td>\n' +
                    '            <td>\n' +
                    '            <span class="btn btn-primary change" data-toggle="modal" data-target="#editModal" >修改</span>\n' +
                    '            <span class="btn btn-danger delete" data-toggle="modal" data-target="#deleteModal">删除</span>\n' +
                    '            </td>\n' +
                    '        </tr>');
            });
        }

        $("body").on('click','#Pagination ul > li a',function () {
            var toPage = $(this).parent().val();
            console.log(toPage)
            $("#submit input").eq(2).prop('value',toPage);
            submit();
        });

        $("#aboutpageMax li > a").click(function () {
            var pageSize = $(this).parent().val();
            $("#submit input").eq(2).prop("value",1);
            $("#submit input").eq(1).prop("value",pageSize);
            submit();
        });

        $("body").on('click','.change',function () {
            var email = $(this).parent().parent().find("td").eq(5).text();
            console.log("触发");

            $.ajax({
                url:"${pageContext.request.contextPath}/employee/getOne",
                type: "POST",
                dataType:"json",
                data: 'email='+email,
                success:function (result) {
                    $("#account2").prop("value",result.user.user_name);
                    $("#accountPwd2").prop("value",result.user.password);
                    $("#trueName2").prop("value",result.employee_name);
                    if(result.employee_sex == "女"){
                        $("#options4").prop("checked", true);
                    }else {
                        $("#options3").prop("checked", true);
                    }
                    $("#tel2").prop("value",result.employee_tel);
                    $("#emi2").prop("value",result.employee_email);
                    if(result.user.isAdmin == true){
                        $("#isAdm2").prop("checked",true);
                    }else{
                        $("#isAdm2").prop("checked",false);
                    }
                    $("#address2").prop("value",result.employee_addr);
                }
            });

        });

        $("body").on('click','.delete',function () {
            var email = $(this).parent().parent().find("td").eq(5).text();
            $("body").off('click','#deleteEmployee').on('click','#deleteEmployee',function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/employee/deleteOne",
                    type: "POST",
                    dataType:"json",
                    data: 'email='+email,
                    success:function (result) {
                        if(result == true){
                            alert("删除成功");
                            $('#deleteModal').modal('hide')
                            location.reload();
                        }else {
                            alert("操作失败,请反馈给客服");
                        }
                    }
                });
            });

        });

        $("body").on('click','#deleteEmployee',function () {
            var emails = [];
            ($('.delete').parent().parent().find("td input")).each(function (i,item) {
                if($(this).prop("checked") == true){
                    emails.push($(this).parent().parent().find("td").eq(5).text());
                }
            });

            if(emails.length == 0){
                alert("未选择删除项");
                $('#deleteModal').modal('hide');
            }else{
                $.ajax({
                    url:"${pageContext.request.contextPath}/employee/deleteAll",
                    type: "POST",
                    dataType:"json",
                    data: 'emails='+emails,
                    success:function (result) {
                        if(result == true){
                            alert("删除成功");
                            $('#deleteModal').modal('hide')
                            location.reload();
                        }else {
                            alert("操作失败,请反馈给客服");
                        }
                    }
                });
            }
        });

        $("#addNew").click(function () {
            $.ajax({
                url:"${pageContext.request.contextPath}/employee/addNew",
                type:"POST",
                dateType:"json",
                data:$("#addNewEmployee").serialize(),
                success:function (result) {
                    if(result == true){
                        alert("添加成功");
                        $('#addModal').modal('hide')
                        location.reload();
                    }else {
                        alert("员工的用户名或者邮箱重复,请修改");
                    }
                }
            });
        });

        $("#edit").click(function () {
            $("#account2").prop("disabled", false);
            console.log($("#account2"));
            $.ajax({
                url:"${pageContext.request.contextPath}/employee/edit",
                type:"POST",
                dateType:"json",
                data:$("#editEmployee").serialize(),
                success:function (result) {
                    if(result == true){
                        alert("修改成功");
                        $('#editModal').modal('hide')
                        location.reload();
                    }else {
                        $("#account2").prop("disabled", false);
                        alert("未修改或提交数据错误");
                    }
                }
            });
        });

        $("#allCheck").click(function () {
            var bol = $("#allCheck").prop("checked");
            var all = $("tbody input[type=checkbox]");
            if(bol){
                $(all).each(function (i,item) {
                    $(this).prop("checked",true);
                });
            }else{
                $(all).each(function (i,item) {
                    $(this).prop("checked",false);
                });
            }
        });

        $("body").on('click','#sub',function () {
            var choose = $(this).parent().find("select").eq(0).find("option:selected").html();
            var value = $(this).parent().find("input").val();
            if(typeof value == "undefined" || value == null || value == ""){
                alert("请输入筛选值");
            }else{
                if(!cho.includes(choose)){
                    cho.push(choose);
                    addKey(choose, value);
                }else{
                    alert("单一字段请勿重复添加");
                }
            }
        });

        $("body").on('click','#reset_button',function(){
            cho.splice(0,cho.length);
            $("#group_add").empty();
            $("#submit input").eq(0).prop("value", null);
            submit();
        });

        $("body").on('click','#search_button',function () {
            var employee = {};
            var user = {};
            var key,value;
            var all = $("#group_add div");
            if(all.length < 1){
                alert("请输入相关检索字");
            }else {
                $(all).each(function (i, item) {
                    key = $(this).find("input").eq(0).val();
                    value = $(this).find("input").eq(2).val();
                    if (key == "邮箱") {
                        key = "employee_email";
                    } else if (key == "姓名") {
                        key = "employee_name";
                    } else if (key == "用户名") {
                        key = "user_name"
                    } else if (key == "住址") {
                        key = "employee_addr";
                    } else if (key == "电话") {
                        key = "employee_tel";
                    }

                    if (key == "user_name") {
                        user[key] = value;
                        employee["user"] = user;
                    } else {
                        employee[key] = value;
                    }

                });
                var json = JSON.stringify(employee);
                $("#submit input").eq(0).prop("value", json);
                submit();
            }
        });

        $("body").on('click','#remove',function () {
            var choose = $(this).parent().find("input").eq(0).val();
            cho.splice(cho.indexOf(choose), 1);
            $(this).parent().remove();
        });


    </script>


</html>
