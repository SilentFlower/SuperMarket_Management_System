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
    <title>供货商账务</title>

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
                        <h4 style="color: #2aabd2">供货商账务</h4>
                    </div>
                    <div id="url_name2">
                        <ul class="breadcrumb">
                            <li><a href="${pageContext.request.contextPath}/utils/goHome">首页</a></li>
                            <li class="active">进货管理</li>
                            <li class="active"><a href="${pageContext.request.contextPath}/supplier/get_supplierBill">供货商账务

                            </a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div style="height: 92%;padding-top: 10px;">
                <div id="right-bottom" style="height: 100%;border-radius: 10px;">

                    <div id="choose_button">
                        <div id="forSearch">
                            <span class="btn btn-primary" id="search_supplierGoods" data-toggle="modal" data-target="#searchModal">筛选</span>
                        </div>

                        <div id="forpay">
                            <span class="btn btn-info" id="paid_supplierGoods" data-toggle="modal" data-target="#paidModal">批量支付</span>
                        </div>
                    </div>

                    <div id="table">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th class="col-md-1"><input type="checkbox" id="allCheck"><span style="margin-left: 5px">选择</span></th>
                                    <th class="col-md-2">供货商</th>
                                    <th class="col-md-2">账单金额总数</th>
                                    <th class="col-md-2">已支付金额</th>
                                    <th class="col-md-2">未支付金额</th>
                                    <th class="col-md-2">时间</th>
                                    <th class="col-md-2">相关操作</th>
                                </tr>
                            </thead>
                            <tbody id="supplier_bill">
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
                                    <option>供货商</option>
                                    <option>未支付金额</option>
                                    <option>支付金额</option>
                                    <option>总金额</option>
                                    <option>时间段</option>
                                </select>
                                <select class="form-control chose_2" id="haokan" style="width: 20%">
                                    <option>模糊</option>
                                </select>
                                <input type="text" style="width: 30%" autocomplete="off" class="form-control chose_33" placeholder="值" list="type_list_search">
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
                    <h4 class="modal-title" id="pay">订单生成</h4>
                </div>
                <div class="modal-body">

                    <div id="table2">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th class="col-md-1"><input type="checkbox" checked="true" id="allCheck2"><span style="margin-left: 5px"></span></th>
                                <th class="col-md-2">进货商品名</th>
                                <th class="col-md-2">商品种类</th>
                                <th class="col-md-2">供货商</th>
                                <th class="col-md-2">进货数量</th>
                                <th class="col-md-2">进货价格</th>
                                <th class="col-md-2">进货时间</th>
                                <th class="col-md-2">是否支付</th>
                            </tr>
                            </thead>
                            <tbody id="supplierGoods">
                            </tbody>
                        </table>
                    </div>

                    <style>

                        #table2{
                            height: auto;
                            padding: 20px 12px 0px 12px;
                            display: flex;
                            overflow: auto;
                            justify-content: center;
                            align-items: center;
                        }

                        #table2 table{
                            border: none;
                            padding: 0 0 0 0;
                            align-items: center;
                        }

                        #table2 th{
                            font-size: 12px;

                        }

                    </style>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default cancel" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-danger" id="Topay">支付订单</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <div style="display: none">
        <form action="${pageContext.request.contextPath}/supplier/get_supplierBill" method="post" id="submit" >
            <input type="text" value="" name="supplier_bill">
            <input type="text" value="${page.pageSize}" name="pageSize">
            <input type="text" value="${page.currentPage}" name="currentPage">
        </form>
    </div>



</body>

    <script>
        var cho = [];//已经选择的字段
        var bool = false;

        $(function () {
            page();
            getSupplier_bill();
            getSupplier();
            getKey();
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

        function getKey() {
            var keys = ${supplier_bill_key};
            var k = JSON.stringify(keys);
            $("#submit input").eq(0).prop("value",k);
            var key;
            var value;
            var start = "";
            var end = "";
            for(var name in keys){
                if(keys[name] != null && name != "sb_start" && name != "sb_end"){
                    if(name == "sb_all_amount"){
                        key = "总金额";
                    }else if(name == "sb_paid_amount"){
                        key = "支付金额";
                    }else if(name == "sb_unPaid_amount"){
                        key = "未支付金额";
                    }else if(name == "supplier"){
                        key = "供货商";
                    }
                    if(name == "sb_start_string"){
                        key = "时间段";
                        start = keys[name];
                        cho.push(key);
                        continue;
                    }
                    if(name == "sb_end_string"){
                        end = keys[name];
                        continue;
                    }

                    if(name == "supplier"){
                        value = keys[name].supplier_name;
                    }else{
                        value = keys[name];
                    }
                    cho.push(key);
                    addKey1(key, value);

                }
            }
            if(typeof start != "undefined" && start != null && start != ""){
                addKey2("时间段", start, end);
            }
        }

        function getSupplier_bill(){
            var supplier_bill = ${supplier_bill};
            var w = $("#supplier_bill");
            w.empty();
            $(supplier_bill).each(function(i,item){
                var value = "";
                if(item.sb_start_string != null && item.sb_end_string != null){
                    value = item.sb_start_string + ' - ' + item.sb_end_string;
                }else if(item.sb_start_string != null){
                    value = item.sb_start_string + ' - 至今';
                }else if(item.sb_end_string != null){
                    value = '从前 - ' + item.sb_end_string;
                }else{
                    value = "未设置筛选时间";
                }
                w.append('<tr>\n' +
                    '            <td><input type="checkbox"></td>\n' +
                    '            <td>'+item.supplier.supplier_name+'</td>\n' +
                    '            <td>'+item.sb_all_amount+'</td>\n' +
                    '            <td>'+item.sb_paid_amount+'</td>\n' +
                    '            <td>'+item.sb_unPaid_amount+'</td>\n' +
                    '            <td>'+value+'</td>\n' +
                    '            <td>\n' +
                    '            <span class="btn btn-primary pay" data-toggle="modal" data-target="#paidModal">支付</span>\n' +
                    '            <input type="hidden" value="'+item.supplier.s_id+'">\n' +
                    '            </td> \n' +
                    '   </tr>');
            });
        }

        function getSupplier(){
            var names = "";
            var supplier_names = ${supplier_names};
            for(i in supplier_names){
                names +='<option value="'+supplier_names[i]+'">'+supplier_names[i]+'</option>'
            }
            empty_list_search();
            $("#type_list_search").html(names);
        }

        function empty_list_search(){
            $("#type_list_search").empty();
        }

        function empty_haoka(){
            $("#haokan option").html("模糊");
        }

        function addKey1(key,value) {
            var type = "模糊";
            if(key == "未支付金额" || key == "支付金额" || key =="总金额"){
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
                '                                     <input type="text" disabled  class="form-control chose_3 end_time" value="'+value2+'" placeholder="结束时间">\n' +
                '                           </div>\n' +
                '      </div>';
            newAdd += '<button type="submit" class="btn btn-default chose_4" id="remove">\n' +
                '          <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>\n' +
                '      </button>';
            newAdd += '</div>';
            $("#group_add").append(newAdd);
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

        $("#allCheck2").click(function () {
            var bol = $("#allCheck2").prop("checked");
            var all = $("#supplierGoods input[type=checkbox]");
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
            if(choose == "时间段"){
                value = $(".start_time").val();
                value2 = $(".end_time").val();
            }
            if(typeof value == "undefined" || value == null || value == ""){
                alert("请输入筛选值");
            }else{
                if(!cho.includes(choose)){
                    cho.push(choose);
                    if(choose == "时间段"){
                        addKey2(choose,value,value2);
                    }else{
                        addKey1(choose,value);
                    }
                }else{
                    alert("单一字段请勿重复添加");
                }
            }
            endtime = $(this).find(".end_time").val();
        });

        $("body").on('click','#reset_button',function(){
            cho.splice(0,cho.length);
            $("#group_add").empty();
            $("#submit input").eq(0).prop("value", null);
            submit();
        });

        $("body").on('click','#search_button',function () {
            var supplier_bill = {};
            var supplier = {};
            var key,value;
            var endtime;
            var all = $("#group_add div");
            if(all.length < 1){
                alert("请输入相关检索字");
            }else {
                $(all).each(function (i, item) {
                    key = $(this).find("input").eq(0).val();
                    value = $(this).find("input").eq(2).val();
                    if (key == "供货商") {
                        key = "supplier_name";
                    } else if (key == "未支付金额") {
                        key = "sb_unPaid_amount";
                    } else if (key == "支付金额") {
                        key = "sb_paid_amount";
                    } else if (key == "总金额") {
                        key = "sb_all_amount"
                    } else if (key == "时间段") {
                        key = "sb_start_string";
                        value = $(this).find(".start_time").val();
                        endtime = $(this).find(".end_time").val();
                    }

                    if (key == "supplier_name") {
                        supplier[key] = value;
                        supplier_bill["supplier"] = supplier;
                    } else if (key == "sb_start_string") {
                        supplier_bill[key] = value;
                        if(typeof endtime != "undefined" && endtime != null && endtime != ""){
                            supplier_bill["sb_end_string"] = endtime;
                        }
                    } else {
                        supplier_bill[key] = value;
                    }

                    var json = JSON.stringify(supplier_bill);
                    $("#submit input").eq(0).prop("value", json);
                    submit();
                });
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
                alert("未选择支付或已经完成支付");
                $('#paidModal').modal('hide');
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

        $("body").on('change','#select',function () {
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

            if($(this).val() == "供货商"){
                getSupplier();
            }else{
                empty_list_search();
            }

            if($(this).val() == "时间段"){
                $(this).parent().find("input").remove();
                $(this).parent().find("#type_list_search").before(dateSelect);
                bool = true;
            }else if(bool == true){
                $(".ds").remove();
                $(this).parent().find("#type_list_search").before(before);
                bool = false;
            }

            if($(this).val() == "未支付金额" || $(this).val() == "支付金额" || $(this).val() == "总金额"){
                $("#haokan").find("option").html("小于等于");
                $(".chose_33").prop("type", "number");
            }else{
                $("#haokan").find("option").html("模糊");
                $(".chose_33").prop("type", "text");
            }

        });

        function new_orders(result){
            var w = $("#supplierGoods");
            $(result).each(function(i,item){
                w.append('<tr>\n' +
                    '            <td><input type="checkbox" checked="true"></td>\n' +
                    '            <td>'+item.goods.goods_name+'<input type="hidden" value="'+item.goods.g_id+'"></td>\n' +
                    '            <td>'+item.goods.goodsType.tg_name+'<input type="hidden" value="'+item.goods.goodsType.tg_id+'"></td>\n' +
                    '            <td>'+item.supplier.supplier_name+'<input type="hidden" value="'+item.supplier.s_id+'"></td>\n' +
                    '            <td>'+item.sg_amount+'</td>\n' +
                    '            <td>'+item.sg_price+'</td>\n' +
                    '            <td>'+item.sg_date_string+'</td>\n' +
                    '            <td class="pay">'+item.sg_paid+'</td>\n' +
                    '            <td>\n' +
                    '            <input type="hidden" value="'+item.sg_id+'">\n' +
                    '            </td>\n' +
                    '        </tr>');
            });
            if(result.length <= 0){
                alert("该供应商已无订单");
                $('#paidModal').modal('hide');
            }
        }

        function pay_orders(){
            var sg_ids = [];
            ($("#supplierGoods td input")).each(function (i,item) {
                if($(this).prop("checked") == true){
                    console.log($(this).parent().parent().find("td").eq(8).find("input").val());
                    sg_ids.push($(this).parent().parent().find("td").eq(8).find("input").val());
                }
            });
            if(sg_ids.length <= 0){
                alert("请选择需要支付的进货订单");
            }else{
                $.ajax({
                    url:"${pageContext.request.contextPath}/supplier/pay_supplierGoods",
                    type: "POST",
                    dataType:"json",
                    data: 'sg_ids='+sg_ids ,
                    success:function (result) {
                        if(result == true){
                            alert("支付成功");
                            $('#paidModal').modal('hide');
                            location.reload();
                        }else {
                            alert("操作失败,请反馈给客服");
                        }
                    }
                });
            }
        }

        $("#paid_supplierGoods").click(function () {
            var s_ids = [];
            ($("#supplier_bill td input")).each(function (i, item) {
                if ($(this).prop("checked") == true) {
                    s_ids.push($(this).parent().parent().find("td").eq(6).find("input").val());
                }
            });
            $.ajax({
                url:"${pageContext.request.contextPath}/supplier/get_paySupplierBills",
                type: "POST",
                dataType:"json",
                data: 's_ids='+s_ids,
                success:function (result) {
                    new_orders(result);
                }
            });
            $("body").off('click','#Topay').on('click','#Topay',function () {
                pay_orders();
            });
        });

        $("body").on('click','.pay',function () {
            var s_id = $(this).parent().find("input").val();
            $.ajax({
                url:"${pageContext.request.contextPath}/supplier/get_paySupplierBill",
                type: "POST",
                dataType:"json",
                data: 's_id='+s_id,
                success:function (result) {
                    new_orders(result);
                }
            });
            $("body").off('click','#Topay').on('click','#Topay',function () {
                pay_orders();
            });
        });

        $('#paidModal').on('hide.bs.modal', function () {
            $("#supplierGoods").empty();
        });


    </script>


</html>
