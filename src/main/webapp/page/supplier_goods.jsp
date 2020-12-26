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
    <title>采购进货</title>

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
                        <h4 style="color: #2aabd2">采购进货</h4>
                    </div>
                    <div id="url_name2">
                        <ul class="breadcrumb">
                            <li><a href="${pageContext.request.contextPath}/utils/goHome">首页</a></li>
                            <li class="active">进货管理</li>
                            <li class="active"><a href="${pageContext.request.contextPath}/supplier/supplierGoods">采购进货</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div style="height: 92%;padding-top: 10px;">
                <div id="right-bottom" style="height: 100%;border-radius: 10px;">

                    <div id="choose_button">
                        <div id="forSearch">
                            <span class="btn btn-primary" id="search_supplierGoods" data-toggle="modal" data-target="#searchModal">筛选</span>
                            <span class="btn btn-info" id="paid_supplierGoods" data-toggle="modal" data-target="#paidModal">支付</span>
                        </div>

                        <div id="foraddOrDelete">
                            <span class="btn btn-info" id="add_supplierGoods" data-toggle="modal" data-target="#addModal">新增</span>
                            <span class="btn btn-danger" id="delete_supplierGoodss" data-toggle="modal" data-target="#deleteModal">批量删除</span>
                        </div>
                    </div>

                    <div id="table">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th class="col-md-1"><input type="checkbox" id="allCheck"><span style="margin-left: 5px">选择</span></th>
                                    <th class="col-md-2">进货商品名</th>
                                    <th class="col-md-2">商品种类</th>
                                    <th class="col-md-2">供货商</th>
                                    <th class="col-md-2">进货数量</th>
                                    <th class="col-md-2">进货价格</th>
                                    <th class="col-md-2">进货时间</th>
                                    <th class="col-md-1">是否支付</th>
                                    <th class="col-md-2">相关操作</th>
                                </tr>
                            </thead>
                            <tbody id="supplierGoods">
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
                    <h4 class="modal-title">添加新的进货记录</h4>
                </div>

                <div class="modal-body">
                    <form role="form" id="addNew_supplierGoods">

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
                                <label for="supplier_add" class="control-label">供货商</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="supplier_name" autocomplete="off" id="supplier_add" list="supplier_list_add" placeholder="进货商">
                                    <datalist id="supplier_list_add">

                                    </datalist>
                                </div>
                            </div>

                            <div class="form-group col-sm-6">
                                <label for="amount_add" class="control-label">供货数量</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="sg_amount" id="amount_add" placeholder="供货数量">
                                </div>
                            </div>
                        </div>

                        <div class="form-group" style="padding: 0">
                            <div class="form-group col-sm-6">
                                <label for="price_add" class="control-label">进货价格</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="sg_price" id="price_add" placeholder="进货价格">
                                </div>
                            </div>

                            <div class="form-group col-sm-6">
                                <label for="date_add" class="control-label">进货时间</label>
                                <div class="col-sm-9">
                                    <input type="date" class="form-control" name="sg_date_string" id="date_add" placeholder="供货数量">
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
                    <h4 class="modal-title">修改进货记录</h4>
                </div>

                <div class="modal-body">
                    <form role="form" id="edit_supplierGoods">

                        <div class="form-group" style="padding-bottom: 0px;">
                            <input type="hidden" name="sg_id" id="sg_id">
                            <div class="form-group col-sm-6">
                                <label for="name_edit" class="control-label">商品名</label>
                                <div class="col-sm-9">
                                    <input type="text" name="goods_name" autocomplete="off"  class="form-control" id="name_edit" list="goods_list_edit" placeholder="商品名">
                                    <datalist id="goods_list_edit">

                                    </datalist>
                                </div>
                            </div>

                            <div class="form-group col-sm-6">
                                <label for="type_edit" class="control-label">种类名</label>
                                <div class="col-sm-9">
                                    <input type="text type" name="tg_name" autocomplete="off" class="form-control" id="type_edit" list="type_list_edit" disabled placeholder="种类名">
                                    <datalist id="type_list_edit">

                                    </datalist>
                                </div>
                            </div>
                        </div>


                        <div class="form-group" style="padding: 0">
                            <div class="form-group col-sm-6">
                                <label for="supplier_edit" class="control-label">供货商</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" autocomplete="off"  name="supplier_name" id="supplier_edit" list="supplier_list_edit" placeholder="进货商">
                                    <datalist id="supplier_list_edit">

                                    </datalist>
                                </div>
                            </div>

                            <div class="form-group col-sm-6">
                                <label for="amount_edit" class="control-label">供货数量</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="sg_amount" id="amount_edit" placeholder="供货数量">
                                </div>
                            </div>
                        </div>

                        <div class="form-group" style="padding: 0">
                            <div class="form-group col-sm-6">
                                <label for="price_edit" class="control-label">进货价格</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="sg_price" id="price_edit" placeholder="进货价格">
                                </div>
                            </div>

                            <div class="form-group col-sm-6">
                                <label for="date_edit" class="control-label">进货时间</label>
                                <div class="col-sm-9">
                                    <input type="date" class="form-control" name="sg_date_string" id="date_edit" placeholder="供货时间">
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
                    <button type="button" class="btn btn-danger" id="delete_supplierGoods">提交删除</button>
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
                                    <option>供货商</option>
                                    <option>进货数量</option>
                                    <option>进货价格</option>
                                    <option>进货时间</option>
                                    <option>是否支付</option>
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

    <div class="modal fade" id="paidModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="pay">支付确认</h4>
                </div>
                <div class="modal-body">
                    <div class="alert alert-danger" role="alert">
                        正在生成订单
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default cancel" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-danger" id="Topay">提交请求</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <div style="display: none">
        <form action="${pageContext.request.contextPath}/supplier/supplierGoods" method="post" id="submit" >
            <input type="text" value="" name="supplierGoods">
            <input type="text" value="${page.pageSize}" name="pageSize">
            <input type="text" value="${page.currentPage}" name="currentPage">
            <input type="text" value="" name="endTime">
        </form>
    </div>



</body>

    <script>
        var cho = [];//已经选择的字段
        var bool = false;
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
                        message: '验证失败',
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    },
                    supplier_name: {
                        message: '验证失败',
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    },
                    sg_amount: {
                        message: '验证失败',
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    },
                    sg_price: {
                        message: '验证失败',
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    },
                    sg_date_string: {
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
                submitButtons:'#edit_button',
                message: '验证失败',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    goods_name: {
                        message: '验证失败',
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    },
                    supplier_name: {
                        message: '验证失败',
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    },
                    sg_amount: {
                        message: '验证失败',
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    },
                    sg_price: {
                        message: '验证失败',
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    },
                    sg_date_string: {
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
            page();
            getSupplierGoods();
            getKey();
            x();
            x2();
        });

        function submit() {
            $("#submit").submit();
        }

        function addKey1(key,value) {
            var type = "模糊";
            if(key == "进货价格" || key == "进货数量"){
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
            var keys = ${supplierGoodsKeyword};
            var endTime = "${endTime}";
            var k = JSON.stringify(keys);
            $("#submit input").eq(0).prop("value",k);
            $("#submit input").eq(3).prop("value",endTime);
            var key;
            var value;
            for(var name in keys){
                if(keys[name] != null && name != "sg_date"){
                    if(name == "supplier" && keys[name].supplier_name == null ){
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

                    if(name == "sg_amount"){
                        key = "进货数量";
                    }else if(name == "sg_paid"){
                        key = "是否支付";
                    }else if(name == "sg_price"){
                        key = "进货价格";
                    }else if(name == "sg_date_string"){
                        key = "进货时间";
                    }else if(name == "supplier"){
                        key = "供货商";
                    }else if(name == "goods"){
                        key = "商品名"
                    }
                    if(name == "goods"){
                        value = keys[name].goods_name;
                    }else if(name == "supplier"){
                        value = keys[name].supplier_name;
                    }else if(name == "sg_date_string"){
                        value = keys[name];
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

        function getSupplierGoods(){
            var supplierGoods = ${supplierGoods};
            var w = $("#supplierGoods");
            w.empty();
            $(supplierGoods).each(function(i,item){
                w.append('<tr>\n' +
                    '            <td><input type="checkbox"></td>\n' +
                    '            <td>'+item.goods.goods_name+'<input type="hidden" value="'+item.goods.g_id+'"></td>\n' +
                    '            <td>'+item.goods.goodsType.tg_name+'<input type="hidden" value="'+item.goods.goodsType.tg_id+'"></td>\n' +
                    '            <td>'+item.supplier.supplier_name+'<input type="hidden" value="'+item.supplier.s_id+'"></td>\n' +
                    '            <td>'+item.sg_amount+'</td>\n' +
                    '            <td>'+item.sg_price+'</td>\n' +
                    '            <td>'+item.sg_date_string+'</td>\n' +
                    '            <td class="pay">'+item.sg_paid+'</td>\n' +
                    '            <td>\n' +
                    '            <span class="btn btn-primary change" data-toggle="modal" data-target="#editModal" >修改</span>\n' +
                    '            <span class="btn btn-danger delete" data-toggle="modal" data-target="#deleteModal">删除</span>\n' +
                    '            <input type="hidden" value="'+item.sg_id+'">\n' +
                    '            </td>\n' +
                    '        </tr>');
            });
        }

        function supplierGoods_add(goods,supplier) {
            $("#supplier_list_add").empty();
            $("#supplier_list_add").html(supplier);
            $("#goods_list_add").empty();
            $("#goods_list_add").html(goods);
        }

        function supplierGoods_edit(goods,supplier) {
            $("#supplier_list_edit").empty();
            $("#supplier_list_edit").html(supplier);
            $("#goods_list_edit").empty();
            $("#goods_list_edit").html(goods);
        }

        function setGoodsAndType(type){
            $.ajax({
                url:"${pageContext.request.contextPath}/supplier/get_goodsAndType",
                type: "POST",
                dataType:"json",
                success:function (result) {
                    var supplier = "";
                    var goods = "";
                    $(result.suppliers).each(function (i,item) {
                        supplier += '<option value="'+item+'">'+item+'</option>';
                    })

                    $(result.goods).each(function (i,item) {
                        goods += '<option value="'+item+'">'+item+'</option>';
                    })
                    if(type == "add"){
                        supplierGoods_add(goods, supplier);
                    }else{
                        supplierGoods_edit(goods, supplier);
                    }

                }
            });
        }

        $("body").on('change','#name_add',function () {
            var name = $("#name_add").val();
            $.ajax({
                url:"${pageContext.request.contextPath}/supplier/get_goodsType",
                type: "POST",
                dataType:"text",
                data:"goods_name="+name+"",
                success:function (result){
                    $("#type_add").val(result);
                },
            });
        });

        $("body").on('change','#name_edit',function () {
            var name = $("#name_edit").val();
            $.ajax({
                url:"${pageContext.request.contextPath}/supplier/get_goodsType",
                type: "POST",
                dataType:"text",
                data:"goods_name="+name+"",
                success:function (result){
                    $("#type_edit").val(result);
                },
            });
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
            var sg_id = $(this).parent().find("input").val();
            $.ajax({
                url:"${pageContext.request.contextPath}/supplier/get_editSupplierGoods",
                type: "POST",
                dataType:"json",
                data: 'sg_id='+sg_id,
                success:function (result) {
                    setGoodsAndType("edit");
                    $("#name_edit").prop("value",result.goods.goods_name);
                    $("#type_edit").prop("value",result.goods.goodsType.tg_name);
                    $("#supplier_edit").prop("value",result.supplier.supplier_name);
                    $("#amount_edit").prop("value",result.sg_amount);
                    $("#price_edit").prop("value",result.sg_price);
                    $("#date_edit").prop("value",result.sg_date_string);
                    $("#sg_id").prop("value", sg_id);
                }
            });

        });

        $("body").on('click','.delete',function () {
            var sg_id= $(this).parent().find("input").val();
            $("body").off('click','#delete_supplierGoods').on('click','#delete_supplierGoods',function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/supplier/delete_supplierGoods",
                    type: "POST",
                    dataType:"json",
                    data: 'sg_id='+sg_id,
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

        $("body").on('click','#delete_supplierGoods',function () {
            var sg_ids = [];
            ($('.delete').parent().parent().find("td input")).each(function (i,item) {
                if($(this).prop("checked") == true){
                    sg_ids.push($(this).parent().parent().find("td").eq(8).find("input").val());
                }
            });

            if(sg_ids.length == 0){
                alert("未选择删除项");
                $('#deleteModal').modal('hide');
            }else{
                $.ajax({
                    url:"${pageContext.request.contextPath}/supplier/delete_supplierGoodss",
                    type: "POST",
                    dataType:"json",
                    data: 'sg_ids='+sg_ids ,
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
            $.ajax({
                url:"${pageContext.request.contextPath}/supplier/add_supplierGoods",
                type:"POST",
                dateType:"json",
                data:$("#addNew_supplierGoods").serialize(),
                success:function (result) {
                    if(result == true){
                        alert("添加成功");
                        $('#addModal').modal('hide')
                        location.reload();
                    }else {
                        alert("添加进货记录失败");
                    }
                }
            });
        });

        $("#edit_button").click(function () {
            $("#goodsType_edit_id").prop("disabled", false);
            $.ajax({
                url:"${pageContext.request.contextPath}/supplier/edit_supplierGoods",
                type:"POST",
                dateType:"json",
                data:$("#edit_supplierGoods").serialize(),
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
            if(choose == "进货时间"){
                value = $(".start_time").val();
                value2 = $(".end_time").val();
            }
            if(typeof value == "undefined" || value == null || value == ""){
                alert("请输入筛选值");
            }else{
                if(!cho.includes(choose)){
                    cho.push(choose);
                    if(choose == "进货时间"){
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
            if($(this).val() == "进货时间"){
                $(this).parent().find("input").remove();
                $(this).parent().find("button").before(dateSelect);
                bool = true;
            }else if(bool == true){
                $(".ds").remove();
                $(this).parent().find("button").before(before);
                bool = false;
            }
            if($(this).val() == "进货数量" || $(this).val() == "进货价格"){
                $("#haokan").find("option").html("小于等于");
            }else{
                $("#haokan").find("option").html("模糊");
            }
            if($(this).val() == "是否支付"){
                $("#type_list_search").empty();
                $("#type_list_search").html(trueOrFalse);
            }else{
                $("#type_list_search").empty();
            }


        });

        $("body").on('click','#reset_button',function(){
            cho.splice(0,cho.length);
            $("#group_add").empty();
            $("#submit input").eq(0).prop("value", null);
            submit();
        });

        $("body").on('click','#search_button',function () {
            var supplierGoods = {};
            var goods = {};
            var supplier = {};
            var goodsType = {};
            var key,value;
            var endtime;
            var all = $("#group_add div");
            if(all.length < 1){
                alert("请输入相关检索字");
            }else {
                $(all).each(function (i, item) {
                    key = $(this).find("input").eq(0).val();
                    value = $(this).find("input").eq(2).val();
                    if (key == "商品名") {
                        key = "goods_name";
                    }else if (key == "是否支付") {
                        key = "sg_paid";
                    }else if (key == "种类名") {
                        key = "tg_name";
                    } else if (key == "供货商") {
                        key = "supplier_name"
                    }else if (key == "进货数量") {
                        key = "sg_amount"
                    }else if (key == "进货价格") {
                        key = "sg_price"
                    }else if (key == "进货时间") {
                        key = "sg_date_string"
                        endtime = $(this).find(".end_time").val();
                        console.log(endtime);
                    }
                    if(key == "goods_name"){
                        goods[key] = value;
                    }else if(key == "tg_name"){
                        goodsType[key] = value;
                        goods["goodsType"] = goodsType;
                    }else if(key == "supplier_name"){
                        supplier[key] = value;
                    }else{
                        supplierGoods[key] = value;
                    }
                });
                supplierGoods["goods"] = goods;
                supplierGoods["supplier"] = supplier;
                var json = JSON.stringify(supplierGoods);
                $("#submit input").eq(0).prop("value", json);
                $("#submit input").eq(3).prop("value", endtime);
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

        $("body").on('click','#Topay',function () {
            var sg_ids = [];
            ($('.pay').parent().find("td input")).each(function (i, item) {
                if ($(this).prop("checked") == true) {
                    if ($(this).parent().parent().find("td").eq(7).text() == "false") {
                        sg_ids.push($(this).parent().parent().find("td").eq(8).find("input").val());
                    }
                }
            });
            if(sg_ids.length == 0) {
                alert("请选择需要支付的进货订单");
            } else {
                $.ajax({
                    url: "${pageContext.request.contextPath}/supplier/pay_supplierGoods",
                    type: "POST",
                    dataType: "json",
                    data: 'sg_ids=' + sg_ids,
                    success: function (result) {
                        if (result == true) {
                            alert("支付成功");
                            $('#deleteModal').modal('hide');
                            location.reload();
                        } else {
                            alert("操作失败,请反馈给客服");
                        }
                    }
                });
            }
        });





    </script>


</html>
