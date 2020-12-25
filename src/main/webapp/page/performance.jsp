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
    <title>个人销售业绩</title>

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
                    <h4 style="color: #2aabd2">个人销售业绩</h4>
                </div>
                <div id="url_name2">
                    <ul class="breadcrumb">
                        <li><a href="${pageContext.request.contextPath}/utils/goHome">首页</a></li>
                        <li class="active">销售管理</li>
                        <li class="active"><a href="${pageContext.request.contextPath}/performance/get_performance">个人销售业绩

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
                        <span>销售员：</span><input type="text" autocomplete="off" id="search_employee_name" list="list_employee_name">
                        <datalist id="list_employee_name">

                        </datalist>
                    </div>

                    <div id="start">
                        <span>开始时间</span>：<input type="date" id="search_goods_start">
                    </div>

                    <div id="end">
                        <span>结束时间</span>：<input type="date" id="search_goods_end">
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
                            <th class="col-md-2">销售员</th>
                            <th class="col-md-2">总销量</th>
                            <th class="col-md-2">总营业额</th>
                        </tr>
                        </thead>
                        <tbody id="performance">
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
    <form action="${pageContext.request.contextPath}/performance/get_performance" method="post" id="submit" >
        <input type="text" value="" name="performance">
        <input type="text" value="${page.pageSize}" name="pageSize">
        <input type="text" value="${page.currentPage}" name="currentPage">
    </form>
</div>
<input type="hidden" value="" name="e_id" id="e_id">



</body>

<script>
    var cho = [];//已经选择的字段
    var bool = false;

    $(function () {
        page();
        get_key();
        get_performance();
        get_employee();
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

    function get_performance(){
        var performance = ${performance};
        var w = $("#performance");
        w.empty();
        $(performance).each(function(i,item){
            w.append('<tr>\n' +
                '            <td>'+item.employee.employee_name+'</td>\n' +
                '            <td>'+item.amount+'</td>\n' +
                '            <td>'+item.performance+'</td>\n' +
                '   </tr>');
        });
    }

    function get_employee(){
        var names = "";
        var allEmployees = ${allEmployees};
        for(i in allEmployees){
            names +='<option value="'+allEmployees[i].e_id+'">'+allEmployees[i].employee_name+'</option>'
        }
        list_employee_name();
        $("#list_employee_name").html(names);
    }

    function list_employee_name(){
        $("#list_employee_name").empty();
    }

    function get_key(){
        var key = ${performanceKey};
        $("#submit input").eq("0").prop("value", JSON.stringify(key));
        if(key != null){
            if(key["e_id"] != null){
                allEmployees = ${allEmployees};
                for(i in allEmployees){
                    if(key["e_id"] == allEmployees[i].e_id){
                        $("#e_id").prop("value",key["e_id"]);
                        $("#search_employee_name").prop("value", allEmployees[i].employee_name);
                        break;
                    }
                }
            }
            if(key["startSearchTime"] != null){
                $("#search_goods_start").prop("value", key["startSearchTime"]);
            }
            if (key["endSearchTime"] != null) {
                $("#search_goods_end").prop("value", key["endSearchTime"]);
            }
        }
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

    $("body").on('click','#reset_button',function(){
        $("#search_goods_end").empty();
        $("#search_employee_name").empty();
        $("#e_id").empty();
        $("#search_goods_start").empty();
        $("#submit input").eq(0).prop("value", null);
        submit();
    });

    $("body").on('click','#search_button',function () {
        var performance = {};
        performance["e_id"] = $("#e_id").val();
        performance["startSearchTime"] = $("#search_goods_start").val();
        performance["endSearchTime"] = $("#search_goods_end").val();
        $("#submit input").eq(0).prop("value", JSON.stringify(performance));
        submit();
    });

    $("#search_employee_name").change(function () {
        var e_id = $(this).val();
        $("#e_id").prop("value", e_id);
        var allEmployees = ${allEmployees};`    `
        for(i in allEmployees){
            if(allEmployees[i].e_id == e_id){
                $(this).prop("value", allEmployees[i].employee_name);
                break;
            }
        }
    });



</script>


</html>