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
    <title>商品销售</title>

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
                        <h4 style="color: #2aabd2">商品销售</h4>
                    </div>
                    <div id="url_name2">
                        <ul class="breadcrumb">
                            <li><a href="${pageContext.request.contextPath}/utils/goHome">首页</a></li>
                            <li class="active">销售管理</li>
                            <li class="active"><a href="${pageContext.request.contextPath}/sale/get_employeeSale">商品销售</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div style="height: 92%;padding-top: 10px;">
                <div id="right-bottom" style="height: 100%;border-radius: 10px;">

                    <div id="choose_button">
                        <div id="forSearch">
                            <span class="btn btn-primary" id="search_employee_sale" data-toggle="modal" data-target="#searchModal">筛选</span>
                        </div>

                        <div id="foraddOrDelete">
                            <span class="btn btn-info" id="add_employee_sale" data-toggle="modal" data-target="#addModal">新增</span>
                            <span class="btn btn-danger" id="delete_sale_goodss" data-toggle="modal" data-target="#deleteModal">批量删除</span>
                        </div>
                    </div>

                    <div id="table">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th class="col-md-1"><input type="checkbox" id="allCheck"><span style="margin-left: 5px">选择</span></th>
                                    <th class="col-md-2">商品名</th>
                                    <th class="col-md-2">商品种类</th>
                                    <th class="col-md-2">销售员</th>
                                    <th class="col-md-2">销售数量</th>
                                    <th class="col-md-2">销售时间</th>
                                    <th class="col-md-2">销售价格</th>
                                    <th class="col-md-2">相关操作</th>
                                </tr>
                            </thead>
                            <tbody id="employeeSales">
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
                    <h4 class="modal-title">添加新的销售记录</h4>
                </div>

                <div class="modal-body">
                    <form role="form" id="addNew_employee_sale">

                        <div class="form-group" style="padding-bottom: 0px;">
                            <div class="form-group col-sm-6">
                                <label for="name_add" class="control-label">商品名</label>
                                <div class="col-sm-9">
                                    <input type="text" name="goods_name" autocomplete="off" class="form-control" id="name_add" list="employee_sale_add" placeholder="商品名">
                                    <datalist id="employee_sale_add">

                                    </datalist>
                                </div>
                            </div>

                            <div class="form-group col-sm-6">
                                <label for="type_add" class="control-label">商品种类</label>
                                <div class="col-sm-9">
                                <input type="text type" name="tg_name" autocomplete="off" class="form-control"  id="type_add" disabled placeholder="商品种类">
                            </div>
                            </div>
                        </div>


                        <div class="form-group" style="padding: 0">
                            <div class="form-group col-sm-6">
                                <label for="employee_add" class="control-label">销售员</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="employee_name" autocomplete="off" id="employee_add" list="employee_list_add" placeholder="销售员">
                                    <datalist id="employee_list_add">

                                    </datalist>
                                </div>
                            </div>

                            <div class="form-group col-sm-6">
                                <label for="sale_amount_add" class="control-label">销售数量</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="sale_amount" id="sale_amount_add" placeholder="销售数量">
                                </div>
                            </div>
                        </div>

                        <div class="form-group" style="padding: 0">
                            <div class="form-group col-sm-6">
                                <label for="sale_date_add" class="control-label">销售时间</label>
                                <div class="col-sm-9">
                                    <input type="date" class="form-control" name="sale_date_string" id="sale_date_add" placeholder="销售时间">
                                </div>
                            </div>

                            <div class="form-group col-sm-6">
                                <label for="sale_price_add" class="control-label">销售价格</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="sale_price" id="sale_price_add" placeholder="销售价格">
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
                    <h4 class="modal-title">修改销售记录</h4>
                </div>

                <div class="modal-body">
                    <form role="form" id="edit_employee_sale">

                        <div class="form-group" style="padding-bottom: 0px;">
                            <div class="form-group col-sm-6">
                                <label for="name_edit" class="control-label">商品名</label>
                                <div class="col-sm-9">
                                    <input type="text" name="goods_name" autocomplete="off" class="form-control" id="name_edit" list="employee_sale_add" placeholder="商品名">
                                    <datalist id="employee_sale_edit">

                                    </datalist>
                                </div>
                            </div>

                            <div class="form-group col-sm-6">
                                <label for="type_edit" class="control-label">商品种类</label>
                                <div class="col-sm-9">
                                    <input type="text type" name="tg_name" autocomplete="off" class="form-control"  id="type_edit" disabled placeholder="商品种类">
                                </div>
                            </div>
                        </div>


                        <div class="form-group" style="padding: 0">
                            <div class="form-group col-sm-6">
                                <label for="employee_edit" class="control-label">销售员</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="employee_name" autocomplete="off" id="employee_edit" list="employee_list_edit" placeholder="销售员">
                                    <datalist id="employee_list_edit">

                                    </datalist>
                                </div>
                            </div>

                            <div class="form-group col-sm-6">
                                <label for="sale_amount_edit" class="control-label">销售数量</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="sale_amount" id="sale_amount_edit" placeholder="销售数量">
                                </div>
                            </div>
                        </div>

                        <div class="form-group" style="padding: 0">
                            <div class="form-group col-sm-6">
                                <label for="sale_date_edit" class="control-label">销售时间</label>
                                <div class="col-sm-9">
                                    <input type="date" class="form-control" name="sale_date_string" id="sale_date_edit" placeholder="销售时间">
                                </div>
                            </div>

                            <div class="form-group col-sm-6">
                                <label for="sale_price_edit" class="control-label">销售价格</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="sale_price" id="sale_price_edit" placeholder="销售价格">
                                </div>
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
                        Warning! 你正在删除进货数据！
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default cancel" data-dismiss="modal">取消删除</button>
                    <button type="button" class="btn btn-danger" id="delete_sale_goods">提交删除</button>
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
                                <select class="form-control chose_1" id="select" style="width: 30%">
                                    <option>商品名</option>
                                    <option>种类名</option>
                                    <option>销售员</option>
                                    <option>销售时间</option>
                                    <option>销售价格</option>
                                    <option>销售数量</option>
                                </select>
                                <select class="form-control chose_2" id="haokan" style="width: 20%">
                                    <option>模糊</option>
                                </select>
                                <input type="text" style="width: 30%" autocomplete="off" class="form-control chose_3" placeholder="值" list="type_list_search">
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
        <form enctype='application/json' action="${pageContext.request.contextPath}/sale/get_employeeSale" method="post" id="submit" >
            <input type="text" value="" name="saleGoods">
            <input type="text" value="${page.pageSize}" name="pageSize">
            <input type="text" value="${page.currentPage}" name="currentPage">
        </form>
    </div>



</body>

    <script>
        var cho = [];//已经选择的字段
        var bool = false;
        var choose_goods = {};
        var choose_employee = {};
        var choose_g_id = "";
        var choose_e_id = "";
        var choose_sale_id=""

        $(function () {
            getKey();
            page();
            getEmployee_sale();
            get_allGoods_info();
            get_allEmployees_info();
        });

        function submit() {
            $("#submit").submit();
        }

        function addKey1(key,value) {
            var type = "模糊";
            if(key == "销售数量" || key == "销售价格"){
                type = "小于等于";
            }
            var newAdd = '<div class="add">';
            newAdd += '<input class="form-control chose_1"  type="text" style="width: 30%" disabled value="'+key+'">';
            newAdd += '<input class="form-control chose_2"  type="text" style="width: 20%" disabled value="'+type+'">';
            newAdd += '<input class="form-control chose_3"  type="text" style="width: 30%" disabled value="'+value+'">';
            newAdd += '<button type="submit" class="btn btn-default chose_4" id="remove">\n' +
                '          <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>\n' +
                '      </button>';
            newAdd += '</div>';
            $("#group_add").append(newAdd);
        }

        function addKey2(key,value,value2) {
            var newAdd = '<div class="add">';
            newAdd += '<input class="form-control chose_1"  type="text" style="width: 30%" disabled value='+key+'>';
            newAdd += '<input class="form-control chose_2"  type="text" style="width: 20%" disabled value="模糊">';
            newAdd += '<div class="date_search" ">\n' +
                '                            <div>\n' +
                '                                  <div>起始</div>\n' +
                '                                  <input type="text"  disabled class="form-control chose_3 start_time" value="'+value+'"placeholder="起始时间">\n' +
                '                            </div>\n' +
                '\n' +
                '                            <div>\n' +
            '                                     <div>结束</div>\n' +
            '                                     <input type="text"  disabled class="form-control chose_3 end_time" value="'+value2+'" placeholder="结束时间">\n' +
                '                           </div>\n' +
                '      </div>';
            newAdd += '<button type="submit" class="btn btn-default chose_4" id="remove">\n' +
                '          <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>\n' +
                '      </button>';
            newAdd += '</div>';
            $("#group_add").append(newAdd);
        }

        function getKey() {
            var keys = ${Searchkey};
            var k = JSON.stringify(keys);
            var endTime;
            $("#submit input").eq(0).prop("value",k);
            var key;
            var value;
            for(var name in keys){
                if(keys[name] != null && name != "endSearchTime"){
                    console.log(name);
                    if(name == "employee" && keys[name].employee_name == null ){
                        continue;
                    }

                    if(name == "goods" && keys[name].goodsType != null){
                        value = keys[name].goodsType.tg_name;
                        addKey1("种类名",value);
                        cho.push("种类名");
                    }

                    if(name == "goods" && keys[name].goods_name == null){
                        continue;
                    }

                    if(name == "sale_amount"){
                        key = "销售数量";
                    }else if(name == "sale_price"){
                        key = "销售价格";
                    }else if(name == "sg_price"){
                        key = "进货价格";
                    }else if(name == "startSearchTime"){
                        key = "销售时间";
                    }else if(name == "goods"){
                        key = "商品名";
                    }else if(name == "employee"){
                        key = "销售员";
                    }

                    if(name == "goods"){
                        value = keys[name].goods_name;
                    }else if(name == "employee"){
                        value = keys[name].employee_name;
                    }else if(name == "startSearchTime"){
                        value = keys[name];
                        endTime = keys["endSearchTime"];
                        addKey2(key, value,endTime);
                        $(".date_search > div >input").prop("disabled", true);
                        cho.push(key);
                        continue;
                    }else{
                        value = keys[name];
                    }
                    cho.push(key);
                    addKey1(key, value);

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

        function getEmployee_sale(){
            var getEmployee_sale = ${employeeSale};
            var w = $("#employeeSales");
            w.empty();
            $(getEmployee_sale).each(function(i,item){
                w.append('<tr>\n' +
                    '            <td><input type="checkbox"></td>\n' +
                    '            <td>'+item.goods.goods_name+'</td>\n' +
                    '            <td>'+item.goods.goodsType.tg_name+'</td>\n' +
                    '            <td>'+item.employee.employee_name+'</td>\n' +
                    '            <td>'+item.sale_amount+'</td>\n' +
                    '            <td>'+item.sale_date_string+'</td>\n' +
                    '            <td>'+item.sale_price+'</td>\n' +
                    '            <td>\n' +
                    '            <span class="btn btn-primary change" data-toggle="modal" data-target="#editModal" >修改</span>\n' +
                    '            <span class="btn btn-danger delete" data-toggle="modal" data-target="#deleteModal">删除</span>\n' +
                    '            <input type="hidden" value="'+item.sale_id+'">\n' +
                    '            </td>\n' +
                    '        </tr>');
            });
        }

        function employee_sale_add(names) {
            $("#employee_sale_add").empty();
            $("#employee_sale_add").html(names);
        }

        function employee_sale_edit(names) {
            $("#employee_sale_edit").empty();
            $("#employee_sale_edit").html(names);
        }

        function employee_list_add(names) {
            $("#employee_list_add").empty();
            $("#employee_list_add").html(names);
        }

        function employee_list_edit(names) {
            $("#employee_list_edit").empty();
            $("#employee_list_edit").html(names);
        }

        function get_allGoods_info(){
            var names = "";
            var goods_names = ${allGoods};
            for(i in goods_names){
                names +='<option value="'+goods_names[i].goods_name+'">'+goods_names[i].goods_name+'</option>'
            }
            employee_sale_add(names);
            employee_sale_edit(names);
        }

        function get_allEmployees_info(){
            var names = "";
            var employees = ${allEmployees};
            for(i in employees){
                names +='<option e_id="'+employees[i].e_id+'" value="'+employees[i].e_id+'">'+employees[i].employee_name+'</option>'
            }
            employee_list_add(names);
            employee_list_edit(names);
        }

        $("body").on('change','#name_add',function () {
            var goods_name = $("#name_add").val();
            var goods_names = ${allGoods};
            for(i in goods_names){
                if(goods_names[i].goods_name == goods_name){
                    $("#type_add").prop("value", goods_names[i].goodsType.tg_name);
                    choose_goods = goods_names[i];
                    break;
                }
            }
        });

        $("body").on('change','#employee_add',function () {
            var e_id = $("#employee_add").prop("value");
            var employees = ${allEmployees};
            for(i in employees){
                if(employees[i].e_id == e_id){
                    $("#employee_add").prop("value",employees[i].employee_name);
                    choose_employee = employees[i];
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
                    choose_g_id = goods_names[i].g_id;
                    break;
                }
            }
        });

        $("body").on('change','#employee_edit',function () {
            var e_id = $("#employee_edit").prop("value");
            var employees = ${allEmployees};
            for(i in employees){
                if(employees[i].e_id == e_id){
                    $("#employee_add").prop("value",employees[i].employee_name);
                    choose_e_id = employees[i].e_id;
                    break;
                }
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
            $("#name_edit").prop("value",$(this).parent().parent().find("td").eq(1).html());
            $("#type_edit").prop("value",$(this).parent().parent().find("td").eq(2).html());
            $("#employee_edit").prop("value",$(this).parent().parent().find("td").eq(3).html());
            $("#sale_amount_edit").prop("value",$(this).parent().parent().find("td").eq(4).html());
            $("#sale_date_edit").prop("value",$(this).parent().parent().find("td").eq(5).html());
            $("#sale_price_edit").prop("value",$(this).parent().parent().find("td").eq(6).html());
            choose_sale_id = $(this).parent().find("input").val();
        });

        $("body").on('click','.delete',function () {
            var sale_id= $(this).parent().find("input").val();
            $("body").off('click','#delete_sale_goods').on('click','#delete_sale_goods',function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/sale/delete_employeeSale",
                    type: "POST",
                    dataType:"json",
                    data: 'sale_id='+sale_id,
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

        $("body").on('click','#delete_sale_goods',function () {
            var sale_ids = [];
            ($('.delete').parent().parent().find("td input")).each(function (i,item) {
                if($(this).prop("checked") == true){
                    sale_ids.push($(this).parent().parent().find("td").eq(7).find("input").val());
                }
            });

            if(sale_ids.length == 0){
                alert("未选择删除项");
                $('#deleteModal').modal('hide');
            }else{
                $.ajax({
                    url:"${pageContext.request.contextPath}/sale/delete_employeeSales",
                    type: "POST",
                    dataType:"json",
                    data: 'sale_ids='+sale_ids,
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

        $("#add_supplierGoods").click(function () {
            setGoodsAndType("add");
        });

        $("#addNew").click(function () {
            var saleGoods = {};
            saleGoods["g_id"] = choose_goods.g_id;
            saleGoods["e_id"] = choose_employee.e_id;
            saleGoods["sale_amount"] = $("#sale_amount_add").val();
            saleGoods["sale_date_string"] = $("#sale_date_add").val();
            saleGoods["sale_price"] = $("#sale_price_add").val();
            saleGoods["goods"] = choose_employee;
            saleGoods["employee"] = choose_goods;
            $.ajax({
                url:"${pageContext.request.contextPath}/sale/add_employeeSale",
                type:"POST",
                dateType:"json",
                data:JSON.stringify(saleGoods),
                contentType:"application/json",
                success:function (result) {
                    if(result == true){
                        alert("添加成功");
                        $('#addModal').modal('hide')
                        location.reload();
                    }else {
                        alert("添加商品销售记录失败");
                    }
                }
            });
        });

        $("#edit_button").click(function () {
            var saleGoods = {};
            saleGoods["g_id"] = choose_g_id;
            saleGoods["e_id"] = choose_e_id;
            saleGoods["sale_amount"] = $("#sale_amount_edit").val();
            saleGoods["sale_date_string"] = $("#sale_date_edit").val();
            saleGoods["sale_price"] = $("#sale_price_edit").val();
            saleGoods["sale_id"] = choose_sale_id;
            $.ajax({
                url:"${pageContext.request.contextPath}/sale/edit_employeeSale",
                type:"POST",
                dateType:"json",
                contentType: "application/json",
                data: JSON.stringify(saleGoods),
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
            var value2 = "";
            if(choose == "销售时间"){
                value = $(".start_time").val();
                value2 = $(".end_time").val();
            }
            if(typeof value == "undefined" || value == null || value == ""){
                alert("请输入筛选值");
            }else{
                if(!cho.includes(choose)){
                    cho.push(choose);
                    if(choose == "销售时间"){
                        addKey2(choose,value,value2);
                    }else{
                        addKey1(choose,value);
                    }
                }else{
                    alert("单一字段请勿重复添加");
                }
            }
        });

        $("body").on('change','#select',function () {

            var trueOrFalse = '<option value="true">true</option>' +
                                '<option value="false">false</option>';
            var dateSelect = '<div  class="date_search ds" ">\n' +
                '                            <div>\n' +
                '                                  <div>起始</div>\n' +
                '                                  <input type="date" class="form-control chose_3 start_time" placeholder="起始时间">\n' +
                '                            </div>\n' +
                '\n' +
                '                            <div>\n' +
                '                                   <div>结束</div>\n' +
                '                                    <input type="date" class="form-control chose_3 end_time" placeholder="结束时间">\n' +
                '                           </div>\n' +
                '              </div>';
            var before = '<input type="text" style="width: 30%" class="form-control chose_3 chose_33" list="type_list_search" placeholder="值">\n';
            if($(this).val() == "销售时间"){
                $(this).parent().find("input").remove();
                $(this).parent().find("button").before(dateSelect);
                bool = true;
            }else if(bool == true){
                $(".ds").remove();
                $(this).parent().find("button").before(before);
                bool = false;
            }
            if($(this).val() == "销售价格" || $(this).val() == "销售数量"){
                $("#haokan").find("option").html("小于等于");
            }else{
                $("#haokan").find("option").html("模糊");
            }
        });

        $("body").on('click','#reset_button',function(){
            cho.splice(0,cho.length);
            $("#group_add").empty();
            $("#submit input").eq(0).prop("value", null);
            submit();
        });

        $("body").on('click','#search_button',function () {
            var salegoods = {};
            var goods = {};
            var employee = {};
            var goodsType = {};
            var key,value;
            var endSearchTime;
            var all = $("#group_add div");
            if(all.length < 1){
                alert("请输入相关检索字");
            }else {
                $(all).each(function (i, item) {
                    key = $(this).find("input").eq(0).val();
                    value = $(this).find("input").eq(2).val();
                    if (key == "商品名") {
                        key = "goods_name";
                    }else if (key == "种类名") {
                        key = "tg_name";
                    }else if (key == "销售员") {
                        key = "employee_name";
                    }else if (key == "销售价格") {
                        key = "sale_price"
                    }else if (key == "销售数量") {
                        key = "sale_amount"
                    }else if (key == "销售时间") {
                        key = "startSearchTime"
                        endSearchTime = $(this).find(".end_time").val();
                    }

                    if(key == "goods_name"){
                        goods[key] = value;
                    }else if(key == "tg_name"){
                        goodsType[key] = value;
                        goods["goodsType"] = goodsType;
                    }else if(key == "employee_name"){
                        employee[key] = value;
                    }else if(key == "startSearchTime"){
                        salegoods[key] = value;
                        salegoods["endSearchTime"] = endSearchTime;
                    }else{
                        salegoods[key] = value;
                    }
                });
                salegoods["goods"] = goods;
                salegoods["employee"] = employee;
                var json = JSON.stringify(salegoods);
                $("#submit input").eq(0).prop("value", json);
                submit();
            }
        });

        $("body").on('click','#remove',function () {
            var choose = $(this).parent().find("input").eq(0).val();
            console.log(choose);
            console.log(cho);
            cho.splice(cho.indexOf(choose), 1);
            console.log(cho);
            $(this).parent().remove();
        });


    </script>


</html>
