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
    <title>库存报警</title>

    <style>
        #right-bottom{
            display: flex;
            flex-direction: column;
        }

        #choose_button{
            display: flex;
            justify-content: flex-start;
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

        .date_search{
            display: flex;
            flex-direction: row;
            width: 50%;
        }

        .date_search > div{
            display: flex;
            flex-direction: row;
        }

        .date_search > div >div{
            width: 32px;
            display: flex;
            align-items: center;
        }

        .date_search > div >input{
            width: 100px;
        }

        .add{
            display: flex;
            justify-content: center;
        }

        #choose_button{
            display: flex;
            justify-content: space-between;
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
                        <h4 style="color: #2aabd2">库存报警</h4>
                    </div>
                    <div id="url_name2">
                        <ul class="breadcrumb">
                            <li><a href="${pageContext.request.contextPath}/utils/goHome">首页</a></li>
                            <li class="active">库存管理</li>
                            <li class="active"><a href="${pageContext.request.contextPath}/goods/get_goods_alarm">库存报警

                            </a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div style="height: 92%;padding-top: 10px;">
                <div id="right-bottom" style="height: 100%;border-radius: 10px;">

                    <div id="choose_button">
                        <div id="forSearch">

                        </div>

                        <div id="forpay">
                            <span class="btn btn-info" id="add_alarm" data-toggle="modal" data-target="#addModal">添加</span>
                            <span class="btn btn-danger" id="delete_alarms" data-toggle="modal" data-target="#deleteModal">批量删除</span>
                        </div>
                    </div>

                    <div id="table">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th class="col-md-1"><input type="checkbox" id="allCheck"><span style="margin-left: 5px">选择</span></th>
                                    <th class="col-md-2">商品名</th>
                                    <th class="col-md-2">种类</th>
                                    <th class="col-md-2">实际库存</th>
                                    <th class="col-md-2">库存上限</th>
                                    <th class="col-md-2">库存下限</th>
                                    <th class="col-md-2">相关操作</th>
                                </tr>
                            </thead>
                            <tbody id="goods_alarm">
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
                    <h4 class="modal-title">添加新的库存报警</h4>
                </div>

                <div class="modal-body">
                    <form role="form" id="add_alarm_form">

                        <div class="form-group" style="padding-bottom: 0px;">
                            <div class="form-group col-sm-6">
                                <label for="name_add" class="control-label">商品名</label>
                                <div class="col-sm-9">
                                    <input type="text" name="goods_name" autocomplete="off" class="form-control" id="name_add" list="goods_list_add" placeholder="商品名">
                                    <datalist id="goods_list_add">

                                    </datalist>
                                </div>
                            </div>

                            <div class="form-group col-sm-6">
                                <label for="type_add" class="control-label">种类名</label>
                                <div class="col-sm-9">
                                    <input type="text type" name="tg_name" autocomplete="off" class="form-control" id="type_add" disabled placeholder="种类名">
                                </div>
                            </div>
                        </div>


                        <div class="form-group" style="padding: 0">
                            <div class="form-group col-sm-6">
                                <label for="high" class="control-label">库存上限</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="high" autocomplete="off" id="high" placeholder="库存上限">
                                </div>
                            </div>

                            <div class="form-group col-sm-6">
                                <label for="low" class="control-label">库存下限</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="low" id="low" placeholder="库存下限">
                                </div>
                            </div>
                        </div>

                        <div class="form-group" style="padding: 0">
                            <div class="form-group col-sm-6">
                                <label for="high" class="control-label">实际库存</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="amount" autocomplete="off" id="actuall_amount_add" disabled>
                                </div>
                            </div>
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
                    <h4 class="modal-title">修改库存报警</h4>
                </div>

                <div class="modal-body">
                    <form role="form" id="edit_alarm_form">

                        <div class="form-group" style="padding-bottom: 0px;">
                            <div class="form-group col-sm-6">
                                <label for="name_edit" class="control-label">商品名</label>
                                <div class="col-sm-9">
                                    <input type="text" name="goods_name" autocomplete="off" class="form-control" id="name_edit" list="goods_list_edit" placeholder="商品名">
                                    <datalist id="goods_list_edit">

                                    </datalist>
                                </div>
                            </div>

                            <div class="form-group col-sm-6">
                                <label for="type_edit" class="control-label">种类名</label>
                                <div class="col-sm-9">
                                    <input type="text type" name="tg_name" autocomplete="off" class="form-control" id="type_edit" disabled placeholder="种类名">
                                </div>
                            </div>
                        </div>


                        <div class="form-group" style="padding: 0">
                            <div class="form-group col-sm-6">
                                <label for="high" class="control-label">库存上限</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="high" autocomplete="off" id="high_edit" placeholder="库存上限">
                                </div>
                            </div>

                            <div class="form-group col-sm-6">
                                <label for="low" class="control-label">库存下限</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="low" id="low_edit" placeholder="库存下限">
                                </div>
                            </div>
                        </div>

                        <div class="form-group" style="padding: 0">
                            <div class="form-group col-sm-6">
                                <label for="high" class="control-label">实际库存</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="amount" autocomplete="off" id="actuall_amount_edit" disabled>
                                </div>
                            </div>
                        </div>

                        <input type="hidden" id="before_g_id">


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
                        Warning! 你正在删除库存报警！
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default cancel" data-dismiss="modal">取消删除</button>
                    <button type="button" class="btn btn-danger" id="delete_alarm">提交删除</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <div style="display: none">
        <form action="${pageContext.request.contextPath}/goods/get_goods_alarm" method="post" id="submit" >
            <input type="text" value="" name="goods_amount">
            <input type="text" value="${page.pageSize}" name="pageSize">
            <input type="text" value="${page.currentPage}" name="currentPage">
        </form>
    </div>



</body>

    <script>

        function x() {
            $("#addModal").bootstrapValidator({
                submitButtons:'#addNew',
                message: '验证失败',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    goods_name: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    },
                    high: {
                        message: '验证失败',
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    }
                }
            });
        }

        function x2() {
            $("#addModal").bootstrapValidator({
                submitButtons:'#edit',
                message: '验证失败',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    goods_name: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    },
                    high: {
                        message: '验证失败',
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    }
                }
            });
        }

        $(function () {
            get_goods_alarm();
            page();
            get_alarm_info();
            x();
            x2();

        });

        function submit() {
            $("#submit").submit();
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

        function get_goods_alarm(){
            var goods_alarm = ${goods_alarm};
            var w = $("#goods_alarm");
            w.empty();
            for (var key in goods_alarm){
                var high = goods_alarm[key].high;
                var low = goods_alarm[key].low;
                if(goods_alarm[key].high == null){
                    high = "未设置";
                }
                if(goods_alarm[key].low == null){
                    low = "未设置";
                }
                w.append('<tr>\n' +
                    '            <td><input type="checkbox"></td>\n' +
                    '            <td>'+goods_alarm[key].goods.goods_name+'</td>\n' +
                    '            <td>'+goods_alarm[key].goods.goodsType.tg_name+'</td>\n' +
                    '            <td>'+goods_alarm[key].goods.goods_amount+'</td>\n' +
                    '            <td>'+high+'</td>\n' +
                    '            <td>'+low+'</td>\n' +
                    '            <td>\n' +
                    '            <span class="btn btn-primary change" data-toggle="modal" data-target="#editModal">修改</span>\n' +
                    '            <span class="btn btn-danger delete" data-toggle="modal" data-target="#deleteModal">删除</span>\n' +
                    '            <input type="hidden" value="'+goods_alarm[key].goods.g_id+'">\n' +
                    '            </td> \n' +
                    '   </tr>');
            }
        }

        function goods_list_add(names) {
            $("#goods_list_add").empty();
            $("#goods_list_add").html(names);
        }

        function goods_list_edit(names) {
            $("#goods_list_edit").empty();
            $("#goods_list_edit").html(names);
        }

        function get_alarm_info(){
            var names = "";
            var goods_names = ${allGoods};
            for(i in goods_names){
                names +='<option value="'+goods_names[i].goods_name+'">'+goods_names[i].goods_name+'</option>'
            }
            goods_list_add(names);
            goods_list_edit(names);
        }

        $("body").on('click','#addNew',function () {
            var goods_name = $("#name_add").val();
            var goods_names = ${allGoods};
            var low = $("#low").val();
            var high = $("#high").val();
            var goods_alarm = {};
            if(low > high){
                alert("请保证下限比上限低")
            }else{
                var goods = {};
                for(i in goods_names){
                    if(goods_names[i].goods_name == goods_name){
                        goods = goods_names[i];
                        break;
                    }
                }
                goods_alarm["low"] = low;
                goods_alarm["high"] = high;
                goods_alarm["goods"] = goods;
                $.ajax({
                    url:"${pageContext.request.contextPath}/goods/add_goods_alarm",
                    type: "POST",
                    dataType: "json",
                    data:JSON.stringify(goods_alarm),
                    contentType:'application/json',
                    success:function (result) {
                        if (result == true){
                            alert("添加成功");
                            location.reload();
                        }else {
                            alert("添加失败，请勿重复添加");
                        }
                    }
                })
            }
        });

        $("body").on('click','#edit',function () {
            var goods_name = $("#name_edit").val();
            var goods_names = ${allGoods};
            var low = $("#low_edit").val();
            var high = $("#high_edit").val();
            if(low > high){
                alert("请保证下限比上限低")
            }else{
                var before_g_id = $("#before_g_id").val();
                var goods_alarm = {};
                var goods = {};
                var data = {};
                for(i in goods_names){
                    if(goods_names[i].goods_name == goods_name){
                        goods = goods_names[i];
                        break;
                    }
                }
                goods_alarm["low"] = low;
                goods_alarm["high"] = high;
                goods_alarm["goods"] = goods;
                data["goods_alarm"] = goods_alarm;
                data["before_g_id"] = before_g_id;
                $.ajax({
                    url:"${pageContext.request.contextPath}/goods/edit_goods_alarm",
                    type: "POST",
                    dataType: "json",
                    contentType:'application/json',
                    data:JSON.stringify(data),
                    success:function (result) {
                        if (result == true){
                            alert("修改成功");
                            location.reload();
                        }else {
                            alert("修改失败");
                        }
                    }
                })
            }
        });

        $("body").on('click','.change',function () {
            var g_id = $(this).parent().find("input").val();
            var goods_alarm = ${goods_alarm};
            var choose ="";
            var i =0;
            for( i in goods_alarm){
                if(goods_alarm[i].goods.g_id == g_id){
                    choose = goods_alarm;
                    break;
                }
            }
            $("#name_edit").prop("value", choose[i].goods.goods_name);
            $("#type_edit").prop("value", choose[i].goods.goodsType.tg_name);
            $("#low_edit").prop("value", choose[i].low);
            $("#high_edit").prop("value", choose[i].high);
            $("#before_g_id").prop("value", choose[i].goods.g_id);
            $("#actuall_amount_edit").prop("value", choose[i].goods.goods_amount);
        });

        $("body").on('click','.delete',function () {
            var g_id = $(this).parent().find("input").val();
            console.log(g_id);
            $("body").off('click','#delete_alarm').on('click','#delete_alarm',function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/goods/delete_goods_alarm",
                    type: "POST",
                    dataType: "json",
                    data:"g_id="+g_id,
                    success:function (result) {
                        if (result == true){
                            alert("删除成功");
                            location.reload();
                        }else {
                            alert("删除失败");
                        }
                    }
                })
            });
        });

        $("body").on('click','#delete_alarm',function () {
            var g_ids = [];
            ($('.delete').parent().parent().find("td input")).each(function (i,item) {
                if($(this).prop("checked") == true){
                    g_ids.push($(this).parent().parent().find("td").eq(5).find("input").val());
                }
            });

            if(g_ids.length == 0){
                alert("未选择删除项");
                $('#deleteModal').modal('hide');
            }else{
                $.ajax({
                    url:"${pageContext.request.contextPath}/goods/delete_goods_alarms",
                    type: "POST",
                    dataType:"json",
                    data: 'g_ids='+g_ids ,
                    success:function (result) {
                        if(result == true){
                            alert("删除成功");
                            $('#deleteModal').modal('hide');
                            location.reload();
                        }else {
                            alert("操作失败,请反馈给客服");
                        }
                    }
                });
            }
        });

        $("body").on('click','#Pagination ul > li a',function () {
            var toPage = $(this).parent().val();
            $("#submit input").eq(2).prop('value',toPage);
            submit();
        });

        $("body").on('change','#name_add',function () {
            var goods_name = $("#name_add").val();
            var goods_names = ${allGoods};
            for(i in goods_names){
               if(goods_names[i].goods_name == goods_name){
                   $("#type_add").prop("value", goods_names[i].goodsType.tg_name);
                   $("#actuall_amount_add").prop("value",goods_names[i].goods_amount)
                   break;
               }
            }
        });

        $("body").on('change','#name_edit',function () {
            var goods_name = $("#name_edit").val();
            var goods_names = ${allGoods};
            for(i in goods_names){
                if(goods_names[i].goods_name == goods_name){
                    $("#type_edit").prop("value", goods_names[i].goodsType.tg_name);
                    $("#actuall_amount_edit").prop("value",goods_names[i].goods_amount)
                    break;
                }
            }
        });

        $("#aboutpageMax li > a").click(function () {
            var pageSize = $(this).parent().val();
            $("#submit input").eq(2).prop("value",1);
            $("#submit input").eq(1).prop("value",pageSize);
            submit();
        });

        $("body").on('click','#reset_button',function(){
            $("#submit input").eq(0).prop("value", null);
            submit();
        });

        $("body").on('click','#search_button',function () {
            var goods = {};
            var goods_type = {};
            var goods_name = $("#search_goods_name").prop("value");
            var goods_type_name = $("#search_goods_type").prop("value");
            var goods_amount = $("#search_goods_amount").prop("value");
            if(typeof goods_name != "undefined" && goods_name != null && goods_name != ""){
                goods["goods_name"] = goods_name;
            }
            if(typeof goods_type_name != "undefined" && goods_type_name != null && goods_type_name != ""){
                goods_type["tg_name"] = goods_type_name;
                goods["goodsType"] = goods_type;
            }
            if(typeof goods_amount != "undefined" && goods_amount != null && goods_amount != ""){
                goods["goods_amount"] = goods_amount;
            }
            var json = JSON.stringify(goods);
            $("#submit input").eq(0).prop("value", json);
            submit();
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

    </script>


</html>
