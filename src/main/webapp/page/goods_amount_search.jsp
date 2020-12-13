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
    <title>库存查询</title>

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
                        <h4 style="color: #2aabd2">库存查询</h4>
                    </div>
                    <div id="url_name2">
                        <ul class="breadcrumb">
                            <li><a href="${pageContext.request.contextPath}/utils/goHome">首页</a></li>
                            <li class="active">库存管理</li>
                            <li class="active"><a href="${pageContext.request.contextPath}/goods/get_goods_amount">库存查询

                            </a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div style="height: 92%;padding-top: 10px;">
                <div id="right-bottom" style="height: 100%;border-radius: 10px;">

                    <div id="choose_button">

                        <style>
                            #choose_button span{
                                font-size: 14px;
                                color:#6B7D8D;
                                margin-left: 20px;
                            }
                        </style>
                        <div id="forSearch">
                            <span>商品名：</span><input type="text" autocomplete="off" id="search_goods_name" list="list_goods_name">
                            <datalist id="list_goods_name">

                            </datalist>
                        </div>

                        <div id="type">
                            <span style="font-size: 14px;color:#6B7D8D">商品类型：</span><input type="text" autocomplete="off" id="search_goods_type" list="list_goods_type">
                            <datalist id="list_goods_type">

                            </datalist>
                        </div>

                        <div id="amount">
                            <span>库存<=</span>：<input type="number" id="search_goods_amount">
                        </div>

                        <div>
                            <div class="btn btn-info" id="search_button">查询</div>
                            <div class="btn btn-danger" id="reset_button">重置</div>
                        </div>
                    </div>

                    <div id="table">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th class="col-md-2">商品名</th>
                                    <th class="col-md-2">种类名</th>
                                    <th class="col-md-2">库存</th>
                                    <th class="col-md-2">生产地址</th>
                                    <th class="col-md-2">描述</th>
                                    <th class="col-md-2">备注</th>
                                </tr>
                            </thead>
                            <tbody id="goods_amount">
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

    <div style="display: none">
        <form action="${pageContext.request.contextPath}/goods/get_goods_amount" method="post" id="submit" >
            <input type="text" value="" name="goods_amount">
            <input type="text" value="${page.pageSize}" name="pageSize">
            <input type="text" value="${page.currentPage}" name="currentPage">
        </form>
    </div>



</body>

    <script>

        $(function () {
            page();
            get_goods_amount();
            get_goods_info();
            get_goods_amount_key();
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

        function get_goods_amount_key() {
            var keys = ${goods_amount_key};
            var k = JSON.stringify(keys);
            $("#submit input").eq(0).prop("value",k);
            var key;
            var value;
            for(var name in keys){
                if(keys[name] != null){
                    if(name == "goods_name"){
                        $("#search_goods_name").prop("value",keys[name]);
                    }else if(name == "goodsType"){
                        $("#search_goods_type").prop("value",keys[name].tg_name);
                    }else if(name == "goods_amount"){
                        $("#search_goods_amount").prop("value",keys[name]);
                    }
                }
            }
        }

        function get_goods_amount(){
            var goods_amount = ${goods};
            var w = $("#goods_amount");
            w.empty();
            $(goods_amount).each(function(i,item){
                w.append('<tr>\n' +
                    '            <td>'+item.goods_name+'</td>\n' +
                    '            <td>'+item.goodsType.tg_name+'</td>\n' +
                    '            <td>'+item.goods_amount+'</td>\n' +
                    '            <td>'+item.goods_addr+'</td>\n' +
                    '            <td>'+item.goods_desc+'</td>\n' +
                    '            <td>'+item.goods_remarks+'</td>\n' +
                    '   </tr>');
            });
        }

        function empty_list_goods_name(names){
            $("#list_goods_name").empty();
            $("#list_goods_name").html(names);
        }

        function empty_list_goods_type(names){
            $("#list_goods_type").empty();
            $("#list_goods_type").html(names);
        }

        function get_goods_info(){
            var names1 = "";
            var names2 = "";
            var goods_names = ${goods_names};
            var goods_type_names = ${goods_type_names}
            for(i in goods_names){
                names1 +='<option value="'+goods_names[i]+'">'+goods_names[i]+'</option>'
            }
            for(i in goods_type_names){
                names2 +='<option value="'+goods_type_names[i]+'">'+goods_type_names[i]+'</option>'
            }
            empty_list_goods_name(names1);
            empty_list_goods_type(names2);
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

    </script>


</html>
