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
    <title>商品种类列表</title>

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


        #address-from,#address-from2{
            display: flex;
            align-items: center;
            justify-content: center;
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
                        <h4 style="color: #2aabd2">商品种类列表</h4>
                    </div>
                    <div id="url_name2">
                        <ul class="breadcrumb">
                            <li><a href="${pageContext.request.contextPath}/utils/goHome">首页</a></li>
                            <li class="active">商品管理</li>
                            <li class="active"><a href="${pageContext.request.contextPath}/goods/goodsType">商品种类列表</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div style="height: 92%;padding-top: 10px;">
                <div id="right-bottom" style="height: 100%;border-radius: 10px;">

                    <div id="choose_button">
                        <div id="forSearch">
                            <span class="btn btn-primary" id="searchGoodsType" data-toggle="modal" data-target="#searchModal">筛选</span>
                        </div>

                        <div id="foraddOrDelete">
                            <span class="btn btn-info" id="addGoodsType" data-toggle="modal" data-target="#addModal">新增</span>
                            <span class="btn btn-danger" id="deleteGoodsTypes" data-toggle="modal" data-target="#deleteModal">批量删除</span>
                        </div>
                    </div>

                    <div id="table">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th class="col-md-1"><input type="checkbox" id="allCheck"><span style="margin-left: 5px">选择</span></th>
                                    <th class="col-md-2">商品种类ID</th>
                                    <th class="col-md-2">商品类名</th>
                                    <th class="col-md-2">包含商品个数</th>
                                    <th class="col-md-2">相关操作</th>
                                </tr>
                            </thead>
                            <tbody id="goodsType">
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
                    <h4 class="modal-title" id="myModalLabel">添加新的商品种类</h4>
                </div>

                <div class="modal-body">
                    <form role="form" id="addNewGoodsType">

                        <div class="form-group">
                            <label for="goodsType_name" class="col-sm-2 control-label">商品种类名</label>
                            <div class="col-sm-10">
                                <input type="text" name="tg_name" class="form-control" id="goodsType_name"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="goodsType_count" class="col-sm-2 control-label">包含商品个数</label>
                            <div class="col-sm-10">
                                <input type="text" name="tg_count" class="form-control" id="goodsType_count"/>
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
                    <h4 class="modal-title">修改商品种类信息</h4>
                </div>

                <div class="modal-body">
                    <form role="form" id="editGoodsType">

                        <div class="form-group">
                            <label for="goodsType_edit_id" class="col-sm-2 control-label">商品种类ID</label>
                            <div class="col-sm-10">
                                <input type="text" name="tg_id" class="form-control" id="goodsType_edit_id" disabled/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="goodsType_edit_name" class="col-sm-2 control-label">商品种类名</label>
                            <div class="col-sm-10">
                                <input type="text" name="tg_name" class="form-control" id="goodsType_edit_name"/>
                            </div>
                        </div>

                        <div class="form-group" id="address-from">
                            <label for="goodsType_edit_count" class="col-sm-2 control-label">包含商品个数</label>
                            <div class="col-sm-10">
                                <input type="text" name="tg_count" class="form-control" id="goodsType_edit_count"/>
                            </div>
                        </div>

                    </form>

                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
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
                        Warning! 你正在删除供应商数据！
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default cancel" data-dismiss="modal">取消删除</button>
                    <button type="button" class="btn btn-danger" id="deleteGoodsType">提交删除</button>
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
                                    <option>商品种类ID</option>
                                    <option>商品种类名</option>
                                    <option>包含商品个数</option>
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
        <form action="${pageContext.request.contextPath}/goods/goodsType" method="post" id="submit" >
            <input type="text" value="" name="goodsType">
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
            getGoodsType();
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
            var keys = ${goodsTypeKeyword};
            var k = JSON.stringify(keys);
            $("#submit input").eq(0).prop("value",k);
            var key;
            var value;
            for(var name in keys){
                if(keys[name] != null){
                    if(name == "tg_id"){
                        key = "商品种类ID";
                    }else if(name == "tg_name"){
                        key = "商品种类名";
                    }else if(name == "tg_count"){
                        key = "包含商品个数";
                    }
                    cho.push(key);
                    value = keys[name];
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

        function getGoodsType(){
            var goodsType = ${goodsType};
            var w = $("#goodsType");
            w.empty();
            $(goodsType).each(function(i,item){
                w.append('<tr>\n' +
                    '            <td><input type="checkbox"><input type="hidden" value="'+item.tg_id+'"></td>\n' +
                    '            <td>'+item.tg_id+'</td>\n' +
                    '            <td>'+item.tg_name+'</td>\n' +
                    '            <td>'+item.tg_count+'</td>\n' +
                    '            <td>\n' +
                    '            <span class="btn btn-primary change" data-toggle="modal" data-target="#editModal" >修改</span>\n' +
                    '            <span class="btn btn-danger delete" data-toggle="modal" data-target="#deleteModal">删除</span>\n' +
                    '            </td>\n' +
                    '        </tr>');
            });
        }

        $("body").on('click','#Pagination ul > li a',function () {
            var toPage = $(this).parent().val();
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
            var tg_id = $(this).parent().parent().find("td").eq(1).text();

            $.ajax({
                url:"${pageContext.request.contextPath}/goods/getGoodsType",
                type: "POST",
                dataType:"json",
                data: 'tg_id='+tg_id,
                success:function (result) {
                   $("#goodsType_edit_id").prop("value",result.tg_id);
                   $("#goodsType_edit_name").prop("value",result.tg_name);
                   $("#goodsType_edit_count").prop("value",result.tg_count);
                }
            });

        });

        $("body").on('click','.delete',function () {
            var tg_id = $(this).parent().parent().find("td").eq(1).text();
            $("body").off('click','#deleteGoodsType').on('click','#deleteGoodsType',function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/goods/deleteGoodsType",
                    type: "POST",
                    dataType:"json",
                    data: 'tg_id='+tg_id,
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

        $("body").on('click','#deleteGoodsType',function () {
            var tg_ids = [];
            ($('.delete').parent().parent().find("td input")).each(function (i,item) {
                if($(this).prop("checked") == true){
                    tg_ids.push($(this).parent().parent().find("td").eq(1).text());
                }
            });

            if(tg_ids.length == 0){
                alert("未选择删除项");
                $('#deleteModal').modal('hide');
            }else {
                $.ajax({
                    url:"${pageContext.request.contextPath}/goods/deleteGoodsTypes",
                    type: "POST",
                    dataType:"json",
                    data: 'tg_ids='+tg_ids,
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
                url:"${pageContext.request.contextPath}/goods/addGoodsType",
                type:"POST",
                dateType:"json",
                data:$("#addNewGoodsType").serialize(),
                success:function (result) {
                    if(result == true){
                        alert("添加成功");
                        $('#addModal').modal('hide')
                        location.reload();
                    }else {
                        alert("供应商已经存在");
                    }
                }
            });
        });

        $("#edit_button").click(function () {
            $("#goodsType_edit_id").prop("disabled", false);
            $.ajax({
                url:"${pageContext.request.contextPath}/goods/editGoodsType",
                type:"POST",
                dateType:"json",
                data:$("#editGoodsType").serialize(),
                success:function (result) {
                    if(result == true){
                        alert("修改成功");
                        $('#editModal').modal('hide')
                        location.reload();
                    }else {
                        $("#goodsType_edit_id").prop("disabled", true);
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
            var goodsType = {};
            var key,value;
            var all = $("#group_add div");
            if(all.length < 1){
                alert("请输入相关检索字");
            }else {
                $(all).each(function (i, item) {
                    key = $(this).find("input").eq(0).val();
                    value = $(this).find("input").eq(2).val();
                    if (key == "商品种类ID") {
                        key = "tg_id";
                    } else if (key == "商品种类名") {
                        key = "tg_name";
                    } else if (key == "包含商品个数") {
                        key = "tg_count"
                    }
                    goodsType[key] = value;
                });
                var json = JSON.stringify(goodsType);
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
