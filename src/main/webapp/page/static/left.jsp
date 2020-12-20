<%--
  Created by IntelliJ IDEA.
  User: SiletFlower
  Date: 2020/11/14
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>


    #left{
        border-radius: 10px;
        padding: 0;
        display: flex;
        justify-content:center;
        align-items: flex-start;
        background-color:#333B54;
    }

    #www{
        width: 100%;
        height: 100%;
        overflow: scroll;
        overflow-x: hidden;
    }

    #wtf{
        display: block;
        flex-flow: column;
        justify-content: center;
        padding: 0;
        text-align: center;
    }

    #wtf a{
        text-decoration: none;
        color: #E2E4E4;
        font-size: 16px;
    }

    #wtf  ul{
        padding: 0;
    }

    #wtf li{
        margin-top: 15px;
    }

    #left .panel{
        background-color:#333B54!important;
    }

    #url_name{
        margin-left: 20px;

    }

    #mianbao{
        display: flex;
        width: 100%;
        justify-content: space-between;
    }

    #url_name2{
        display: flex;
        justify-content: center;
    }

    #right-bottom{
        background-color:#333B54!important;
    }

    #right-top{
        border-radius: 10px;
        display: flex;
        align-items: center;
        background-color:#333B54!important;
    }

    #right-top ul{
        background-color:#333B54!important;
        margin-bottom: 0px;
    }

    #main{
        padding-right: 15px;
        padding-left: 15px;
    }

    #left ul li{
        list-style-type: none;
    }

    #allFeatures{
        margin-top: 20px;
        text-decoration: none!important;
        text-align: center;
        border-radius: 0!important;
        font-size: 18px;
        color:#E2E4E4;
    }

    #allFeatures:hover{
        text-decoration: none;
        background-color:#1F2037;
        color: #0E9CE6;
        cursor:pointer;
    }

    .hover{
        color: #0E9CE6 !important;
        background-color: transparent!important;
        cursor:pointer;
    }


    .click{
        color: #0E9CE6!important;
        border-left: 3px solid #03A9F5;
        background-color: #1F2037;
    }

    .need{
        display: block;
        width: 100%;
    }

    .need:hover{
        cursor:pointer;
    }

    .nn{
        padding-top: 8px;
        padding-bottom: 8px;
    }

    #mid{
        height: 90%;
        margin-top:12px;
        z-index: 100;
        padding-left: 0;
        padding-right: 0;
    }

    #www::-webkit-scrollbar { width: 0 !important }


</style>

<div id="left" class="col-md-2" style="height: 100%">
    <ul class="nav nav-pills nav-stacked" id="www">
        <li>
            <a id="allFeatures" i="1" class="need click">功能列表
                <span class="glyphicon glyphicon-align-justify"></span>
                <span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span>
                <span class="badge" id="all" style="background-color: #03A9F5;margin-left: 5px;">11</span>
            </a>
            <ul id="wtf">
                <li class="forAdmin">
                    <a class="need nn click">员工管理
                        <span class="glyphicon glyphicon-user"></span>
                        <span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span>
                        <span class="badge" style="background-color: #03A9F5;margin-left: 5px;">1</span>
                    </a>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/employee/getEmployee">员工列表</a></li>
                    </ul>
                </li>

                <li class="forAdmin">
                    <a class="need nn click">供应商管理
                        <span class="glyphicon glyphicon-briefcase"></span>
                        <span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span>
                        <span class="badge" style="background-color: #03A9F5;margin-left: 5px;">1</span>
                    </a>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/supplier/getSuppliers">供应商列表</a></li>
                    </ul>
                </li>

                <li>
                    <a class="need nn click">商品管理
                        <span class="glyphicon glyphicon-barcode"></span>
                        <span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span>
                        <span class="badge" style="background-color: #03A9F5;margin-left: 5px;">2</span>
                    </a>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/goods/goodsType">商品种类</a></li>
                        <li><a href="${pageContext.request.contextPath}/goods/getGoods">商品列表</a></li>
                    </ul>
                </li>

                <li class="forAdmin">
                    <a class="need nn click">进货管理
                        <span class="glyphicon glyphicon-send"></span>
                        <span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span>
                        <span class="badge" style="background-color: #03A9F5;margin-left: 5px;">2</span>
                    </a>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/supplier/supplierGoods">采购进货</a></li>
                        <li><a href="${pageContext.request.contextPath}/supplier/get_supplierBill">供货商账务</a></li>
                    </ul>
                </li>

                <li>
                    <a class="need nn click">库存管理
                        <span class="glyphicon glyphicon-stats"></span>
                        <span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span>
                        <span class="badge" id="kucun" style="background-color: #03A9F5;margin-left: 5px;">3</span>
                    </a>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/goods/get_goods_amount">库存查询</a></li>
                        <li class="forAdmin"><a href="${pageContext.request.contextPath}/goods/get_goods_alarm">库存报警</a></li>
                        <li class="forAdmin"><a href="${pageContext.request.contextPath}/turnover/get_Turnover">库存盘点</a></li>
                    </ul>
                </li>

                <li>
                    <a class="need nn click">销售管理
                        <span class="glyphicon glyphicon-yen"></span>
                        <span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span>
                        <span class="badge" style="background-color: #03A9F5;margin-left: 5px;">2</span>
                    </a>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/sale/get_employeeSale">商品销售</a></li>
                        <li><a href="${pageContext.request.contextPath}/performance/get_performance">个人销售业绩</a></li>
                    </ul>
                </li>


            </ul>
        </li>
        <br style='clear:both'/>
    </ul>
</div>
<script>

    $(function () {
        var user = getUserInfo();
        console.log(user);
        if(user.user.admin != true){
            $(".forAdmin").css("display", "none");
            $("#kucun").html("1");
            $("#all").html("5");
        }
        x10();
    });


    $(".need").click(function () {
        if($(this).prop("i") == 1){
            if($(this).hasClass("click")){
                $(".need").removeClass("click");
                $(".need").parent().find("ul").css("display", "none");
                $(".need").find("span").eq(1).removeClass("glyphicon-menu-down")
                $(".need").find("span").eq(1).addClass("glyphicon-menu-up")
            }else{
                $(".need").removeClass("click");
                $(".need").addClass("click");
                $(".need").parent().find("ul").css("display", "block");
                $(".need").find("span").eq(1).removeClass("glyphicon-menu-up")
                $(".need").find("span").eq(1).addClass("glyphicon-menu-down")
            }
        }else{
            if($(this).hasClass("click")){
                $(this).removeClass("click");
                $(this).parent().find("ul").css("display", "none");
                $(this).find("span").eq(1).removeClass("glyphicon-menu-down")
                $(this).find("span").eq(1).addClass("glyphicon-menu-up")
            }else{
                $(this).addClass("click");
                $(this).parent().find("ul").css("display", "block");
                $(this).find("span").eq(1).removeClass("glyphicon-menu-up")
                $(this).find("span").eq(1).addClass("glyphicon-menu-down")
            }
        }
    });

    $(".need").hover(function(){
        if($(this).hasClass("click")){

        }else{
            $(this).addClass("hover");
        }
    },function(){
        $(this).removeClass("hover");
    });

</script>