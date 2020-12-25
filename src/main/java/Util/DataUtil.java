package Util;

import Dao.SupplierDao;
import Domain.*;
import Service.EmployeeSaleService;
import Service.EmployeeService;
import Service.GoodsService;
import Service.SupplierService;
import lombok.SneakyThrows;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/** 数据随机生成
 * @author SiletFlower
 * @date 2020/12/24 17:57:39
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DataUtil {
    public static String base = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static String firstName="赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福百家姓续";
    private static String girl="秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
    public static String boy="伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
    private static String[] road="重庆大厦,黑龙江路,十梅庵街,遵义路,湘潭街,瑞金广场,仙山街,仙山东路,仙山西大厦,白沙河路,赵红广场,机场路,民航街,长城南路,流亭立交桥,虹桥广场,长城大厦,礼阳路,风岗街,中川路,白塔广场,兴阳路,文阳街,绣城路,河城大厦,锦城广场,崇阳街,华城路,康城街,正阳路,和阳广场,中城路,江城大厦,顺城路,安城街,山城广场,春城街,国城路,泰城街,德阳路,明阳大厦,春阳路,艳阳街,秋阳路,硕阳街,青威高速,瑞阳街,丰海路,双元大厦,惜福镇街道,夏庄街道,古庙工业园,中山街,太平路,广西街,潍县广场,博山大厦,湖南路,济宁街,芝罘路,易州广场,荷泽四路,荷泽二街,荷泽一路,荷泽三大厦,观海二广场,广西支街,观海一路,济宁支街,莒县路,平度广场,明水路,蒙阴大厦,青岛路,湖北街,江宁广场,郯城街,天津路,保定街,安徽路,河北大厦,黄岛路,北京街,莘县路,济南街,宁阳广场,日照街,德县路,新泰大厦,荷泽路,山西广场,沂水路,肥城街,兰山路,四方街,平原广场,泗水大厦,浙江路,曲阜街,寿康路,河南广场,泰安路,大沽街,红山峡支路,西陵峡一大厦,台西纬一广场,台西纬四街,台西纬二路,西陵峡二街,西陵峡三路,台西纬三广场,台西纬五路,明月峡大厦,青铜峡路,台西二街,观音峡广场,瞿塘峡街,团岛二路,团岛一街,台西三路,台西一大厦,郓城南路,团岛三街,刘家峡路,西藏二街,西藏一广场,台西四街,三门峡路,城武支大厦,红山峡路,郓城北广场,龙羊峡路,西陵峡街,台西五路,团岛四街,石村广场,巫峡大厦,四川路,寿张街,嘉祥路,南村广场,范县路,西康街,云南路,巨野大厦,西江广场,鱼台街,单县路,定陶街,滕县路,钜野广场,观城路,汶上大厦,朝城路,滋阳街,邹县广场,濮县街,磁山路,汶水街,西藏路,城武大厦,团岛路,南阳街,广州路,东平街,枣庄广场,贵州街,费县路,南海大厦,登州路,文登广场,信号山支路,延安一街,信号山路,兴安支街,福山支广场,红岛支大厦,莱芜二路,吴县一街,金口三路,金口一广场,伏龙山路,鱼山支街,观象二路,吴县二大厦,莱芜一广场,金口二街,海阳路,龙口街,恒山路,鱼山广场,掖县路,福山大厦,红岛路,常州街,大学广场,龙华街,齐河路,莱阳街,黄县路,张店大厦,祚山路,苏州街,华山路,伏龙街,江苏广场,龙江街,王村路,琴屿大厦,齐东路,京山广场,龙山路,牟平街,延安三路,延吉街,南京广场,东海东大厦,银川西路,海口街,山东路,绍兴广场,芝泉路,东海中街,宁夏路,香港西大厦,隆德广场,扬州街,郧阳路,太平角一街,宁国二支路,太平角二广场,天台东一路,太平角三大厦,漳州路一路,漳州街二街,宁国一支广场,太平角六街,太平角四路,天台东二街,太平角五路,宁国三大厦,澳门三路,江西支街,澳门二路,宁国四街,大尧一广场,咸阳支街,洪泽湖路,吴兴二大厦,澄海三路,天台一广场,新湛二路,三明北街,新湛支路,湛山五街,泰州三广场,湛山四大厦,闽江三路,澳门四街,南海支路,吴兴三广场,三明南路,湛山二街,二轻新村镇,江南大厦,吴兴一广场,珠海二街,嘉峪关路,高邮湖街,湛山三路,澳门六广场,泰州二路,东海一大厦,天台二路,微山湖街,洞庭湖广场,珠海支街,福州南路,澄海二街,泰州四路,香港中大厦,澳门五路,新湛三街,澳门一路,正阳关街,宁武关广场,闽江四街,新湛一路,宁国一大厦,王家麦岛,澳门七广场,泰州一路,泰州六街,大尧二路,青大一街,闽江二广场,闽江一大厦,屏东支路,湛山一街,东海西路,徐家麦岛函谷关广场,大尧三路,晓望支街,秀湛二路,逍遥三大厦,澳门九广场,泰州五街,澄海一路,澳门八街,福州北路,珠海一广场,宁国二路,临淮关大厦,燕儿岛路,紫荆关街,武胜关广场,逍遥一街,秀湛四路,居庸关街,山海关路,鄱阳湖大厦,新湛路,漳州街,仙游路,花莲街,乐清广场,巢湖街,台南路,吴兴大厦,新田路,福清广场,澄海路,莆田街,海游路,镇江街,石岛广场,宜兴大厦,三明路,仰口街,沛县路,漳浦广场,大麦岛,台湾街,天台路,金湖大厦,高雄广场,海江街,岳阳路,善化街,荣成路,澳门广场,武昌路,闽江大厦,台北路,龙岩街,咸阳广场,宁德街,龙泉路,丽水街,海川路,彰化大厦,金田路,泰州街,太湖路,江西街,泰兴广场,青大街,金门路,南通大厦,旌德路,汇泉广场,宁国路,泉州街,如东路,奉化街,鹊山广场,莲岛大厦,华严路,嘉义街,古田路,南平广场,秀湛路,长汀街,湛山路,徐州大厦,丰县广场,汕头街,新竹路,黄海街,安庆路,基隆广场,韶关路,云霄大厦,新安路,仙居街,屏东广场,晓望街,海门路,珠海街,上杭路,永嘉大厦,漳平路,盐城街,新浦路,新昌街,高田广场,市场三街,金乡东路,市场二大厦,上海支路,李村支广场,惠民南路,市场纬街,长安南路,陵县支街,冠县支广场,小港一大厦,市场一路,小港二街,清平路,广东广场,新疆路,博平街,港通路,小港沿,福建广场,高唐街,茌平路,港青街,高密路,阳谷广场,平阴路,夏津大厦,邱县路,渤海街,恩县广场,旅顺街,堂邑路,李村街,即墨路,港华大厦,港环路,馆陶街,普集路,朝阳街,甘肃广场,港夏街,港联路,陵县大厦,上海路,宝山广场,武定路,长清街,长安路,惠民街,武城广场,聊城大厦,海泊路,沧口街,宁波路,胶州广场,莱州路,招远街,冠县路,六码头,金乡广场,禹城街,临清路,东阿街,吴淞路,大港沿,辽宁路,棣纬二大厦,大港纬一路,贮水山支街,无棣纬一广场,大港纬三街,大港纬五路,大港纬四街,大港纬二路,无棣二大厦,吉林支路,大港四街,普集支路,无棣三街,黄台支广场,大港三街,无棣一路,贮水山大厦,泰山支路,大港一广场,无棣四路,大连支街,大港二路,锦州支街,德平广场,高苑大厦,长山路,乐陵街,临邑路,嫩江广场,合江路,大连街,博兴路,蒲台大厦,黄台广场,城阳街,临淄路,安邱街,临朐路,青城广场,商河路,热河大厦,济阳路,承德街,淄川广场,辽北街,阳信路,益都街,松江路,流亭大厦,吉林路,恒台街,包头路,无棣街,铁山广场,锦州街,桓台路,兴安大厦,邹平路,胶东广场,章丘路,丹东街,华阳路,青海街,泰山广场,周村大厦,四平路,台东西七街,台东东二路,台东东七广场,台东西二路,东五街,云门二路,芙蓉山村,延安二广场,云门一街,台东四路,台东一街,台东二路,杭州支广场,内蒙古路,台东七大厦,台东六路,广饶支街,台东八广场,台东三街,四平支路,郭口东街,青海支路,沈阳支大厦,菜市二路,菜市一街,北仲三路,瑞云街,滨县广场,庆祥街,万寿路,大成大厦,芙蓉路,历城广场,大名路,昌平街,平定路,长兴街,浦口广场,诸城大厦,和兴路,德盛街,宁海路,威海广场,东山路,清和街,姜沟路,雒口大厦,松山广场,长春街,昆明路,顺兴街,利津路,阳明广场,人和路,郭口大厦,营口路,昌邑街,孟庄广场,丰盛街,埕口路,丹阳街,汉口路,洮南大厦,桑梓路,沾化街,山口路,沈阳街,南口广场,振兴街,通化路,福寺大厦,峄县路,寿光广场,曹县路,昌乐街,道口路,南九水街,台湛广场,东光大厦,驼峰路,太平山,标山路,云溪广场,太清路".split(",");
    public static final String[] email_suffix="@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn".split(",");
    private static String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");


    public static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }
    private static Random random = new Random();
    @Autowired
    EmployeeService employeeService;
    @Autowired
    SupplierService supplierService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    EmployeeSaleService employeeSaleService;

    /**
     * 返回中文姓名
     */
    public static String name_sex = "";


    /***
     *
     * Project Name: recruit-helper-util
     * <p>随机生成Email
     *
     * @author youqiang.xiong
     * @date 2018年5月23日  下午2:13:06
     * @version v1.0
     * @since
     * @param lMin
     *         最小长度
     * @param lMax
     *         最大长度
     * @return
     */
    public static String getEmail(int lMin,int lMax) {
        int length=getNum(lMin,lMax);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = (int)(Math.random()*base.length());
            sb.append(base.charAt(number));
        }
        sb.append(email_suffix[(int)(Math.random()*email_suffix.length)]);
        return sb.toString();
    }

    /***
     *
     * Project Name: recruit-helper-util
     * <p>随机生成手机号码
     *
     * @author youqiang.xiong
     * @date 2018年5月23日  下午2:14:17
     * @version v1.0
     * @since
     * @return
     */
    public static String getTelephone() {
        int index=getNum(0,telFirst.length-1);
        String first=telFirst[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String thrid=String.valueOf(getNum(1,9100)+10000).substring(1);
        return first+second+thrid;
    }

    /***
     *
     * Project Name: recruit-helper-util
     * <p>返回中文姓名
     *
     * @author youqiang.xiong
     * @date 2018年5月23日  下午2:16:16
     * @version v1.0
     * @since
     * @return
     */
    public static Map<String,String> getChineseName() {
        Map<String, String> map = new HashMap();
        int index = getNum(0, firstName.length() - 1);
        String first = firstName.substring(index, index + 1);
        int sex = getNum(0, 1);
        String str = boy;
        int length = boy.length();
        if (sex == 0) {
            str = girl;
            length = girl.length();
            name_sex = "女";
        } else {
            name_sex = "男";
        }
        index = getNum(0, length - 1);
        String second = str.substring(index, index + 1);
        int hasThird = getNum(0, 1);
        String third = "";
        if (hasThird == 1) {
            index = getNum(0, length - 1);
            third = str.substring(index, index + 1);
        }
        map.put("name",first + second + third);
        map.put("sex", name_sex);
        return map;
    }

    /**
     * 返回地址
     * @return
     */
    private static String getRoad() {
        int index=getNum(0,road.length-1);
        String first=road[index];
        String second=String.valueOf(getNum(11,150))+"号";
        String third="-"+getNum(1,20)+"-"+getNum(1,10);
        return first+second+third;
    }

    /**
     * 随机生成用户名
     * @return
     */
    @SneakyThrows
    private static String user_name(String name){
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        int r = (int) (Math.random() * 1000);
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i<name.length();i++){
            builder.append(PinyinHelper.toHanyuPinyinStringArray(name.charAt(i),format)[0]);
        }
        builder.append(r);
        return builder.toString();
    }

    public static String getbank() {
        //保存生成的银行卡卡号
        StringBuilder dcNumber = new StringBuilder("62");
        int number = 0;
        for (int i = 0; i < 17; i++) {
            // 0的ASCII码是48，9的ASCII码是57
            number = random.nextInt(10) + 48;
            dcNumber.append((char) number);
        }
        return dcNumber.toString();
    }

    public static String getProCity(){


        String[] citypro = {"安康市","安庆市","安顺市","安阳市","鞍山市","巴彦淖尔市","巴中市","白城市","白山市","白银市","百色市","蚌埠市","包头市","宝鸡市","保定市","保山市","北海市","本溪市","滨州市","沧州市","昌都地区","长春市","长沙市","长治市","常德市","常州市","巢湖市","朝阳市","潮州市","郴州市","成都市","承德市","池州市","赤峰市","崇左市","滁州市","达州市","大连市","大庆市","大同市","丹东市","德阳市","德州市","定西市","东莞市","东营市","鄂尔多斯市","鄂州市","防城港市","佛山市","福州市","抚顺市","抚州市","阜新市","阜阳市","甘南州","赣州市","固原市","广安市","广元市","广州市","贵港市","贵阳市","桂林市","哈尔滨市","哈密地区","海北藏族自治州","海东地区","海口市","邯郸市","汉中市","杭州市","毫州市","合肥市","河池市","河源市","菏泽市","贺州市","鹤壁市","鹤岗市","黑河市","衡水市","衡阳市","呼和浩特市","呼伦贝尔市","湖州市","葫芦岛市","怀化市","淮安市","淮北市","淮南市","黄冈市","黄山市","黄石市","惠州市","鸡西市","吉安市","吉林市","济南市","济宁市","佳木斯市","嘉兴市","嘉峪关市","江门市","焦作市","揭阳市","金昌市","金华市","锦州市","晋城市","晋中市","荆门市","荆州市","景德镇市","九江市","酒泉市","开封市","克拉玛依市","昆明市","拉萨市","来宾市","莱芜市","兰州市","廊坊市","乐山市","丽江市","丽水市","连云港市","辽阳市","辽源市","聊城市","临沧市","临汾市","临沂市","柳州市","六安市","六盘水市","龙岩市","陇南市","娄底市","泸州市","吕梁市","洛阳市","漯河市","马鞍山市","茂名市","眉山市","梅州市","绵阳市",
                "牡丹江市","内江市","南昌市","南充市","南京市","南宁市","南平市","南通市","南阳市","宁波市","宁德市","攀枝花市","盘锦市","平顶山市","平凉市","萍乡市","莆田市","濮阳市","普洱市","七台河市","齐齐哈尔市","钦州市","秦皇岛市","青岛市","清远市","庆阳市","曲靖市","衢州市","泉州市","日照市","三门峡市","三明市","三亚市","汕头市","汕尾市","商洛市","商丘市","上饶市","韶关市","邵阳市","绍兴市","深圳市","沈阳市","十堰市","石家庄市","石嘴山市","双鸭山市","朔州市","四平市","松原市","苏州市","宿迁市","宿州市","绥化市","随州市","遂宁市","台州市","太原市","泰安市","泰州市","唐山市","天水市","铁岭市","通化市","通辽市","铜川市","铜陵市","铜仁市","吐鲁番地区","威海市","潍坊市","渭南市","温州市","乌海市","乌兰察布市","乌鲁木齐市","无锡市","吴忠市","芜湖市","梧州市","武汉市","武威市","西安市","西宁市","锡林郭勒盟","厦门市","咸宁市","咸阳市","湘潭市","襄樊市","孝感市","忻州市","新乡市","新余市","信阳市","兴安盟","邢台市","徐州市","许昌市","宣城市","雅安市","烟台市","延安市","盐城市","扬州市","阳江市","阳泉市","伊春市","伊犁哈萨克自治州","宜宾市","宜昌市","宜春市","益阳市","银川市","鹰潭市","营口市","永州市","榆林市","玉林市","玉溪市","岳阳市","云浮市","运城市","枣庄市","湛江市","张家界市","张家口市","张掖市","漳州市","昭通市","肇庆市","镇江市","郑州市","中山市","中卫市","舟山市","周口市","株洲市","珠海市","驻马店市","资阳市","淄博市","自贡市","遵义市","河北省","山西省","辽宁省","吉林省","黑龙江省","江苏省","浙江省","安徽省","福建省","江西省","山东省","河南省","湖北省","湖南省","广东省","海南省","四川省","贵州省","云南省","陕西省","甘肃省","青海省","台湾省"};
        String[] hangye = {"技术开发","技术转让","技术服务","计算机维修及维护服务","弱电工程设计安装","综合网络布线","系统集成","网页设计与安装","电脑平面设计","美术设计制作","电脑图文设计","制作","绘图","网络技术开发","技术转让","技术咨询","技术服务","电子科技","技术转让及咨询服务","安防技术","企业管理咨询","企业策划","商务咨询","商务服务","酒店管理咨询","翻译服务","航空服务","票务","房地产信息（投资）咨询","文化咨询","教育信息咨询","二手车鉴定评估","金融","保险","证券","投资","旅游","餐饮","娱乐","休闲","购物","造纸","纸品","印刷","包装","广告","会展","商务办公","咨询业","IT","通信电子","互联网","房地产","建筑业","交通","运输","物流","仓储","政府","非盈利机构","生产","加工","制造","医疗","护理","美容","保健","卫生","媒体","出版","影视","文化传播","电气","电力","水力","航空","航天研究与制造","家居","室内设计","装饰装潢","通信","电信","网路设备","电子技术","半导体","集成电路","基金","证券","期货","投资","检验","检测","认证","礼品","工艺美术","奢饰品","媒体","出版","影视","文化传播",};
        String[] name = {"春信","贵丰","东弘","同富","飞庆","万康","万鼎","隆高","久协","德高","公盈","春谦","皇贵","伟荣","旺利","辉圣","广安","合亨","吉如","华飞","元正","瑞丰","聚兴","长福","元优","多乾","巨久","德祥","隆安","鑫德","乾广","伟复","久多","耀顺","同福","东昌","洪亚","耀佳","昌益","欣丰","乾美","长隆","如福","圣耀","洪升","合寿","辉浩","裕顺","伟汇","发富","茂宏","盈信","宝佳","东恒","中久","欣茂","凯源","台盈","祥升","满昌","康泰","同富","高生","元晶","进长","复优","华成","耀发","贵义","茂乾","宝高","优泰","益瑞","谦源","长富","润恒","吉乾","仁义","益聚","泰贵","鑫协","协多","源耀","贵昌","禄协","圣本","庆兴","鑫协","正浩","仁益","高晶","泰公","多成","通发","同满","乾升","禄宏","伟裕","光贵","正飞","百亚","乾福","乾安","伟捷","春禄","美厚","富泰","顺义","益捷","泰润","凯佳","盈捷","厚荣","大福","耀协","润美","鑫广","如德","长公","进正","元康","荣协","久泰","升顺","鑫广","如德","进源","国豪","建辉","睿渊","韵文","旭尧","炎彬","云舟","俊材","冠霖","瑾瑜","伟泽","皓轩","鑫磊","浩宇","文昊","韵舟","靖琪","绍辉","志强","幽朋","风桦","智渊","苑博","菲凡","越泽","明杰","博超","长翔","俊驰","天佑","鑫鹏","泰宇","文博","晋鹏","彤彤","瑞纳","佩凤","营久","洲铭","华久","万先","莱仕","本铁","木欧","利太","创光","成百","圆长","扬广","恒宏","光典","清星","士玛","湖奇","豪西","玉日","领生","贸卓","迎方","悦艾","驰来","苏富","霸清","至达","丝元","巨营","振超","悦创","克贵","正迈","全拓","皇顺","汉理","圣特","发傲","速奇","诺妙","拓克","百磊","码用","佩爱","基同","阳彩","本创","雷利","富腾","辰生","耀顺","财正","来览","领鑫","子妙","博川","天扬","事纳",
                "洲赛","环霸","典利","缘韦","高理","运斯","新超","胜克","成创","辰洋","森精","长世","特西","顺越","诗具","凌京","大威","中浩","时方","达集","扬鑫","耀讯","仕嘉","赛莱","志宏","坚曼","特福","冠奇","迎跃","威振","士江","具远","世跃","驰浩","德金","太赛","运亿","能德","贸生","诚界","志裕","曼惠","智银","悦圣","正邦","盛开","欣铁","宜安","识川","信明","海卓","时思","江晖","迎金","拓明","太安","通飞","元名","豪欣","微频","良邦","振速","创辰","尚智","阳相","金集","丝川","白事","卓森","尔诚","发久","英坚","茂泰","微银","航坚","来巨","志日","卓启","啸理","川欧","子辉","纳全","腾庆","语博","辰东","腾聚","用苏","圣讯","玉大","展来","坚微","贵览","森航","春实","悦旭","湖原","久具","洁丝","冠语","方西","方凤","丰火","飞生","荣银","佩良","航微","盈集","皇健","凡茂","恒集","展丝","圆圆","立爱","展顺","纳子","思胜","京川","鸿特","联顿","典彩","雅嘉","贝汇","信顿","涛月","洁湖","成丰","识环","信博","达迪","泰铭","精来","泰亿","茂欧","尼电","好丝","时梦","航相","嘉复","汉优","双莱"};


        Random random = new Random();
        int cityproNum = random.nextInt(citypro.length);
        int hangYeNum = random.nextInt(hangye.length);
        int nameNum = random.nextInt(name.length);

        return citypro[cityproNum]+name[nameNum]+hangye[hangYeNum]+"有限公司";

    }

    public static String randomChinese(){
        String str="";

        for(int i=0;i<4;i++){
            char c=(char)(0x4e00+(int) (Math.random()*(0x9fa5-0x4e00+1)));

            str+=c; }

        return str;
    }

    public static String randomGoods(){
        String pre[] = "发夹,发圈,发网,头巾,头箍,假发,皮筋,耳环,丝巾扣,项链,胸针,腰带,手链,手镯,戒指,脚链,饰链,儿童饰品,手机饰品 笔类,薄,本,册,日用文具,办公设备,复印机,考勤机,办公家具,其他办公用品,仿真花,叶,藤,仿真树木,仿真水果,光纤花,干花,盆花,盆景,栽培系列,耳机,耳塞,电动剃须刀,电子计算器,电子记事本,字典,电筒,电池,打火,烟具,插头,插座,稳压器,充电器,照明,灯具,钟表仪器,仪表,游戏机,卡激光产品门钟,门铃,防盗器,点,验钞机,定时器,指南针,电子保健品,电子配件元器件,随身听,照相器材,收音机,其他电子产品,复读机,手套,毛巾,浴巾,帽子,文胸,内衣,内裤,泳装,围巾,头巾,床上用品,坐垫,靠垫,窗帘布,鞋垫,台布,茶巾,皮带,拉链,纽扣,衬料,时尚饰品,帽子,领带,围巾,头巾,手套,袜子,针织服装,梭织服装,品牌服装,男装,女装,内衣,睡衣,浴衣,衬衣,毛衣,西服,裤子,休闲服装,婚纱,礼服,工作服,制服,袜子,锁具,指甲钳,钥匙坯,刀,剑,剪刀,美工刀,五金工具,园艺五金,刮剃刀,刀片,滑板车,门窗五金,装饰水暖,保温杯,口子杯,不锈钢厨房用具,安全扣,头盔,金属匙扣,金属架,台,测量工具,胶水制品,头发护理,香水,花露水,护肤霜,乳,液,化妆笔,口红,粉饼,粉底霜,沐浴露,面膜,唇膏,专业美容美发用品,日用化学品,儿童化妆品,美容刀具,仪器,美容材料及用具,唇彩,甲油,日用化学品,眼影,睫毛膏,厨卫用品,用具,婴儿用品,日用塑料制品,日用玻璃制品,日用化学品,清洁用品,用具,日杂用品,宾馆酒店专用品,家用陶瓷,搪瓷制品,净水器,饮水机,榨汁机,咖啡机,豆浆机,电热壶,电热杯,电炒锅,电饭煲,湿度调节器,空气净化器,取暖电器,电吹风,吸尘器,电扇,排气扇,电熨斗,视听器材,耳机,遥控器,篮球,排球,足球球,乒乓球,羽毛球及球拍,网球,台球,枪杆,棋类,乐器,健身刀,剑,运动护具,麻将,扑克,博彩,渔具,金属丝网飞镖,游艺设施,溜冰鞋,滑雪器具,滑板,跳绳,哑铃等健身器材,旅游,户外用品,木制工艺品,植物编织工艺品,石料工艺品,宝石玉石工艺品,陶瓷工艺品,金属工艺品,玻璃工艺品,水晶工艺品,塑料工艺品,树脂工艺品,泥塑工艺品,纸制工艺品,天然工艺品,针钩及编结工艺品,雕刻工艺品,仿古工艺品,仿生工艺品,宗教工艺品,民间工艺品,雕塑,字画,古董和收藏品,珠宝首饰,金银器,时尚饰品,打火机,烟具,钟表,相框,画框,蜡烛及烛台,熏香及熏香炉,装饰盒,钥匙扣,链,盆景,玩具,工艺礼品,纪念品,广告礼品,节日用品,殡葬用品,工美礼品玩具设计加工,佛教用品,通讯产品配件部件,锂电池,镍氢电池,磁卡,IP卡,IC卡,拨号器,充电器,天线,电话机,可视电话,移动电话,手机及配件,传真机,网络通信产品,通讯,声讯系统,塑料玩具,填充玩具,绒毛玩具,电子玩具,电动玩具,玩具珠,球,礼品娃娃,玩具车,玩具枪,模型玩具,益智玩具,童车,卡通漫画海报,包装盒,包装袋,台历,挂历,贺卡,不干胶制品,手提袋,印刷出版物,印刷设备,茶叶,调味品,糖果,饼干,炒货,酒类,饮品,小食品".split(",");
        String suf[] = "Ⅰ型,Ⅱ型,Ⅲ型,Ⅳ型,Ⅴ型,Ⅵ型,Ⅶ型,Ⅷ型,Ⅸ型,Ⅹ型".split(",");
        int i = random.nextInt(pre.length);
        int i1 = random.nextInt(suf.length);
        return pre[i] + suf[i1];
    }

    //生成随机日期
    public static String randomdata()
    {
        Random r=new Random();
        String[] yearmp="01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19".split(",");
        String year="20"+yearmp[r.nextInt(19)]+"-";//生成随机年份
        String[] month="01,02,03,04,05,06,07,08,09,10,11,12".split(",");
        int day=r.nextInt(32);
        String data=year+month[r.nextInt(12)]+"-"+day;
        return data;
    }



    @Test
    public void test1(){
        String email = getEmail(6, 14);
        System.out.println(email);
    }

    @Test
    public void test2(){
        Map<String, String> map = getChineseName();
        System.out.println(map);
        String name = user_name(map.get("name"));
        System.out.println(name);
    }

    @Test
    public void test3(){
        String telephone = getTelephone();
        System.out.println(getTelephone());
    }

    @Test
    public void test4(){
        String road = getRoad();
        System.out.println(road);
    }

    @Test
    public void input(){
        int count = 1999;
        for (int i = 0;i<count;i++){
            try {
                String email = getEmail(6, 16);
                Map<String, String> map = getChineseName();
                String telephone = getTelephone();
                String sex = map.get("sex");
                String name = map.get("name");
                String user_namename = user_name(map.get("name"));
                String road = getRoad();
                Employee employee = new Employee();
                employee.setEmployee_addr(road);
                employee.setEmployee_email(email);
                employee.setEmployee_name(name);
                employee.setEmployee_sex(sex);
                employee.setEmployee_tel(telephone);
                User user = new User();
                user.setPassword("123456");
                user.setUser_name(user_namename);
                user.setAdmin(false);
                employee.setUser(user);
                employeeService.addNewEmployee(employee);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Test
    public void admin(){
            String sex = "男";
            String name = "超级管理员";
            String user_namename = "admin";
            Employee employee = new Employee();
            employee.setEmployee_email("huajiwuyan@gmail.com");
            employee.setEmployee_name(name);
            employee.setEmployee_sex(sex);
            User user = new User();
            user.setPassword("123456");
            user.setUser_name(user_namename);
            user.setAdmin(true);
            employee.setUser(user);
            employeeService.addNewEmployee(employee);

    }

    @Test
    public void input2(){
        int count = 1000;
        for (int i = 0;i<count;i++) {
            try {
                String road = getRoad();
                String email = getEmail(4, 12);
                String getbank = getbank();
                Map<String, String> chineseName = getChineseName();
                String name = chineseName.get("name");
                String gongsi = getProCity();
                String desc = randomChinese();
                Supplier supplier = new Supplier();
                supplier.setSupplier_addr(road);
                supplier.setSupplier_bankcard(getbank);
                supplier.setSupplier_contact(name);
                supplier.setSupplier_email(email);
                supplier.setSupplier_name(gongsi);
                supplier.setSupplier_desc(desc);
                supplierService.addSupplier(supplier);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test5(){
        String s = randomGoods();
        System.out.println(s);
    }

    @Test
    public void input3(){
        int count = 500;
        for (int i = 0;i<count;i++) {
            try {
                String road = getRoad();
                String good_name = randomGoods();
                String desc = randomChinese();
                int tg_id = 1 + random.nextInt(10);
                Goods goods = new Goods();
                goods.setTg_id(tg_id);
                goods.setGoods_addr(road);
                goods.setGoods_name(good_name);
                goods.setGoods_desc(desc);
                goodsService.addGoods(goods);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Test
    public void input4(){
        int count = 5000;
        for (int i = 0;i<count;i++) {
            try {
                int g_id = 1 + random.nextInt(458);
                int s_id = 1 + random.nextInt(1000);
                int sg_amount = 101 + random.nextInt(1000);
                double sg_price = random.nextDouble()*150;
                boolean sg_paid = random.nextBoolean();
                String date = randomdata();
                SupplierGoods supplierGoods = new SupplierGoods();
                supplierGoods.setG_id(g_id);
                supplierGoods.setS_id(s_id);
                supplierGoods.setSg_amount(sg_amount);
                supplierGoods.setSg_price(sg_price);
                supplierGoods.setSg_paid(sg_paid);
                supplierGoods.setSg_date_string(date);
                supplierService.add_supplierGoods(supplierGoods);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test6(){
        double sg_price = random.nextDouble()*150;
        String date = randomdata();
        System.out.println(date);
        System.out.println(sg_price);
    }

    @Test
    public void input5(){
        int count = 1500;
        for (int i = 0;i<count;i++) {
            try {
                int g_id = 1 + random.nextInt(458);
                int e_id = 1 + random.nextInt(1980);
                int sg_amount = 51 + random.nextInt(100);
                double sg_price = 20 + random.nextDouble()*200;
                String date = randomdata();
                SaleGoods saleGoods = new SaleGoods();
                saleGoods.setG_id(g_id);
                saleGoods.setE_id(e_id);
                saleGoods.setSale_amount(sg_amount);
                saleGoods.setSale_price(sg_price);
                saleGoods.setSale_date_string(date);
                employeeSaleService.add_employeeSale(saleGoods);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }




}
