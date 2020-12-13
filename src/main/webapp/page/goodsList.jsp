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
    <title>商品列表</title>

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

        .addr,.emi,.bankcard{
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
                        <h4 style="color: #2aabd2">商品列表</h4>
                    </div>
                    <div id="url_name2">
                        <ul class="breadcrumb">
                            <li><a href="${pageContext.request.contextPath}/utils/goHome">首页</a></li>
                            <li class="active">商品管理</li>
                            <li class="active"><a href="${pageContext.request.contextPath}/goods/getGoods">商品列表</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div style="height: 92%;padding-top: 10px;">
                <div id="right-bottom" style="height: 100%;border-radius: 10px;">

                    <div id="choose_button">
                        <div id="forSearch">
                            <span class="btn btn-primary" id="searchGoods" data-toggle="modal" data-target="#searchModal">筛选</span>
                        </div>

                        <div id="foraddOrDelete">
                            <span class="btn btn-info" id="addGoods" data-toggle="modal" data-target="#addModal">新增</span>
                            <span class="btn btn-danger" id="deleteGoodss" data-toggle="modal" data-target="#deleteModal">批量删除</span>
                        </div>
                    </div>

                    <div id="table">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th class="col-md-1"><input type="checkbox" id="allCheck"><span style="margin-left: 5px">选择</span></th>
                                    <th class="col-md-2">商品名</th>
                                    <th class="col-md-2">种类名</th>
                                    <th class="col-md-2">库存</th>
                                    <th class="col-md-2">生产地址</th>
                                    <th class="col-md-2">描述</th>
                                    <th class="col-md-2">备注</th>
                                    <th class="col-md-2">相关操作</th>
                                </tr>
                            </thead>
                            <tbody id="goods">
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
                    <h4 class="modal-title">添加新的商品</h4>
                </div>

                <div class="modal-body">
                    <form role="form" id="addNewGoods">

                        <div class="form-group" style="padding-bottom: 0px;">
                            <div class="form-group col-sm-6">
                                <label for="name_add" class="control-label">商品名</label>
                                <div class="col-sm-9">
                                    <input type="text" name="goods_name" class="form-control" id="name_add" placeholder="商品名">
                                </div>
                            </div>

                            <div class="form-group col-sm-6">
                                <label for="type_add" class="control-label">种类名</label>
                                <div class="col-sm-9">
                                <input type="text type" name="tg_name" autocomplete="off" class="form-control" id="type_add" list="type_list_add" placeholder="种类名">
                                <datalist id="type_list_add">

                                </datalist>
                            </div>
                            </div>
                        </div>


                        <div class="form-group" style="padding: 0">
                            <div class="form-group col-sm-6">
                                <label for="amount_add" class="control-label">库存</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="goods_amount" id="amount_add" placeholder="商品库存">
                                </div>
                            </div>

                            <div class="form-group col-sm-6">
                                <label for="addr_add" class="control-label">生产地址</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="goods_addr" id="addr_add" placeholder="商品生产地址">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="remark_add" class="col-sm-offset-2 control-label">备注</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="goods_remarks" id="remark_add" placeholder="备注">
                            </div>
                        </div>

                        <div class="form-group" id="address-from">
                            <label for="desc_add">描述</label>
                            <textarea class="form-control" id="desc_add" name="goods_desc" rows="3"></textarea>
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
                    <h4 class="modal-title">修改商品种类信息</h4>
                </div>

                <div class="modal-body">
                    <form role="form" id="editGoods">

                        <div class="form-group" style="padding-bottom: 0px;">
                            <div class="form-group col-sm-6">
                                <label for="name_edit" class="control-label">商品名</label>
                                <div class="col-sm-9">
                                    <input type="text" name="goods_name" class="form-control" id="name_edit" placeholder="商品名">
                                </div>
                            </div>

                            <div class="form-group col-sm-6" >
                                <label for="type_edit" class="control-label">种类名</label>
                                <div class="col-sm-9">
                                    <input type="text" name="tg_name" autocomplete="off" class="form-control" id="type_edit" list="type_list_edit" placeholder="种类名">
                                    <datalist id="type_list_edit">

                                    </datalist>
                                </div>
                            </div>
                        </div>


                        <div class="form-group" style="padding: 0">
                            <div class="form-group col-sm-6">
                                <label for="amount_edit" class="control-label">库存</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="goods_amount" id="amount_edit" placeholder="商品库存">
                                </div>
                            </div>

                            <div class="form-group col-sm-6">
                                <label for="addr_edit" class="control-label">生产地址</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="goods_addr" id="addr_edit" placeholder="商品生产地址">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="remark_edit" class="col-sm-offset-2 control-label">备注</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="goods_remarks" id="remark_edit" placeholder="备注">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="desc_edit">描述</label>
                            <textarea class="form-control" id="desc_edit" name="goods_desc" rows="3"></textarea>
                        </div>

                        <input type="hidden" id="id_edit" name="g_id">

                    </form>

                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default cancel" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="edit_button">提交更改</button>
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
                        Warning! 你正在删除商品数据！
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default cancel" data-dismiss="modal">取消删除</button>
                    <button type="button" class="btn btn-danger" id="deleteGoods">提交删除</button>
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
                                    <option>商品名</option>
                                    <option>种类名</option>
                                    <option>库存</option>
                                    <option>生产地址</option>
                                    <option>备注</option>
                                    <option>描述</option>
                                </select>
                                <select class="form-control chose_2" id="haokan">
                                    <option>模糊</option>
                                </select>
                                <input type="text" id="search_val" class="form-control chose_3" autocomplete="off" placeholder="值" list="type_list_search">
                                <datalist id="type_list_search">

                                </datalist>
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
        <form action="${pageContext.request.contextPath}/goods/getGoods" method="post" id="submit" >
            <input type="text" value="" name="goods">
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
            getGoods();
        });

        function submit() {
            $("#submit").submit();
        }

        function addKey(key,value) {
            var newAdd = '<div>';
            var ccc = "模糊";
            if(key == "库存"){
                ccc = "小于等于";
            }
            newAdd += '<input class="form-control chose_1"  type="text" disabled value="'+key+'">';
            newAdd += '<input class="form-control chose_2"  type="text" disabled value="'+ccc+'">';
            newAdd += '<input class="form-control chose_3"  type="text" disabled value="'+value+'">';
            newAdd += '<button type="submit" class="btn btn-default chose_4" id="remove">\n' +
                '          <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>\n' +
                '      </button>';
            newAdd += '</div>';
            $("#group_add").append(newAdd);
        }

        function getKey() {
            var keys = ${goodsKeyword};
            var k = JSON.stringify(keys);
            $("#submit input").eq(0).prop("value",k);
            var key;
            var value;
            for(var name in keys){
                if(keys[name] != null){
                    if(name == "goods_name"){
                        key = "商品名";
                    }else if(name == "goodsType"){
                        key = "种类名";
                    }else if(name == "goods_amount"){
                        key = "库存";
                    }else if(name == "goods_addr"){
                        key = "生产地址";
                    }else if(name == "goods_remarks"){
                        key = "备注";
                    }else if(name == "goods_desc"){
                        key = "描述";
                    }


                    if(name == "goodsType"){
                        value = keys[name].tg_name;
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

        function getGoods(){
            var goods = ${goods};
            var w = $("#goods");
            w.empty();
            $(goods).each(function(i,item){
                w.append('<tr>\n' +
                    '            <td><input type="checkbox"></td>\n' +
                    '            <td>'+item.goods_name+'</td>\n' +
                    '            <td>'+item.goodsType.tg_name+'</td>\n' +
                    '            <td>'+item.goods_amount+'</td>\n' +
                    '            <td>'+item.goods_addr+'</td>\n' +
                    '            <td>'+item.goods_desc+'</td>\n' +
                    '            <td>'+item.goods_remarks+'</td>\n' +
                    '            <td>\n' +
                    '            <span class="btn btn-primary change" data-toggle="modal" data-target="#editModal" >修改</span>\n' +
                    '            <span class="btn btn-danger delete" data-toggle="modal" data-target="#deleteModal">删除</span>\n' +
                    '            <input type="hidden" value="'+item.g_id+'">\n' +
                    '            </td>\n' +
                    '        </tr>');
            });
        }

        function type_add(goodsTypes){
            $("#type_list_add").empty();
            $("#type_list_add").html(goodsTypes);
        }

        function type_edit(goodsTypes){
            $("#type_list_edit").empty();
            $("#type_list_edit").html(goodsTypes);
        }

        function type_search(goodsTypes){
            $("#type_list_search").empty();
            $("#type_list_search").html(goodsTypes);
        }

        function type_reset() {
            $("#type_list_search").empty();
        }

        function setGoodsType(type,data) {
            $.ajax({
                url:"${pageContext.request.contextPath}/goods/getAllGoodsTypeName",
                type: "POST",
                dataType:"json",
                success:function (result) {
                    var goodsTypes = "";
                    $(result).each(function (i,item) {
                        if(data == item){
                            $("#type_edit").prop("value", data);
                        }
                        goodsTypes += '<option value="'+item+'">'+item+'</option>';
                    });
                    if(type == "add"){
                        type_add(goodsTypes);
                    }else if(type == "edit"){
                        type_edit(goodsTypes);
                    }else{
                        type_search(goodsTypes);
                    }

                }
            });
        }

        $("body").on('change','#select',function () {
            if($(this).val() == "种类名"){
                setGoodsType("search",false);
            }else{
                type_reset();
            }
            if($(this).val() == "库存"){
                $("#haokan option").html("小于等于");
            }else{
                $("#haokan option").html("模糊");
            }
        });

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
            var g_id = $(this).parent().find("input").val();
            $.ajax({
                url:"${pageContext.request.contextPath}/goods/getEditGoods",
                type: "POST",
                dataType:"json",
                data: 'g_id='+g_id,
                success:function (result) {
                    setGoodsType("edit",result.goodsType.tg_name);
                    $("#name_edit").prop("value",result.goods_name);
                    $("#amount_edit").prop("value",result.goods_amount);
                    $("#addr_edit").prop("value",result.goods_addr);
                    $("#desc_edit").prop("value",result.goods_desc);
                    $("#remark_edit").prop("value",result.goods_remarks);
                    $("#id_edit").prop("value",result.g_id);
                }
            });

        });

        $("body").on('click','.delete',function () {
            var g_id = $(this).parent().find("input").val();
            $("body").off('click','#deleteGoods').on('click','#deleteGoods',function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/goods/deleteGoods",
                    type: "POST",
                    dataType:"json",
                    data: 'g_id='+g_id,
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

        $("body").on('click','#deleteGoods',function () {
            var g_ids = [];
            ($('.delete').parent().parent().find("td input")).each(function (i,item) {
                if ($(this).prop("checked") == true) {
                    g_ids.push($(this).parent().parent().find("td").eq(7).find("input").val());
                }
            });

            if(g_ids.length == 0){
                alert("未选择删除项");
                $('#deleteModal').modal('hide');
            }else{
                $.ajax({
                    url:"${pageContext.request.contextPath}/goods/deleteGoodss",
                    type: "POST",
                    dataType:"json",
                    data: 'g_ids='+g_ids ,
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

        $("#addGoods").click(function () {
            setGoodsType("add",false);
        });

        $("#addNew").click(function () {
            console.log($("#addNewGoods").serialize());
            $.ajax({
                url:"${pageContext.request.contextPath}/goods/addGoods",
                type:"POST",
                dateType:"json",
                data:$("#addNewGoods").serialize(),
                success:function (result) {
                    if(result == true){
                        alert("添加成功");
                        $('#addModal').modal('hide')
                        location.reload();
                    }else {
                        alert("商品已经存在，");
                    }
                }
            });
        });

        $("#edit_button").click(function () {

            $.ajax({
                url:"${pageContext.request.contextPath}/goods/edit_goods",
                type:"POST",
                dateType:"json",
                data:$("#editGoods").serialize(),
                success:function (result) {
                    if(result == true){
                        alert("修改成功");
                        $('#editModal').modal('hide')
                        location.reload();
                    }else {
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
            var goods = {};
            var goodsType = {};
            var key,value;
            var all = $("#group_add div");
            if(all.length < 1){
                alert("请输入相关检索字");
            }else {
                $(all).each(function (i, item) {
                    key = $(this).find("input").eq(0).val();
                    value = $(this).find("input").eq(2).val();
                    if (key == "种类名") {
                        key = "tg_name";
                    } else if (key == "商品名") {
                        key = "goods_name";
                    } else if (key == "库存") {
                        key = "goods_amount"
                    } else if (key == "生产地址") {
                        key = "goods_addr";
                    } else if (key == "备注") {
                        key = "goods_remarks";
                    } else if(key == "描述"){
                        key = "goods_desc";
                    }

                    if (key == "tg_name") {
                        goodsType[key] = value;
                        goods["goodsType"] = goodsType;
                    } else {
                        goods[key] = value;
                    }

                });
                var json = JSON.stringify(goods);
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
