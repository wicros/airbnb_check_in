package jp.metroengines.metrocheckin.utils;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import jp.metroengines.metrocheckin.bean.PhoneCodeBean;

/**
 * Created by mac on 2018/2/15.
 */

public class PhoneCodeUtil {

    private List<PhoneCodeBean.ListBean> data_list;

    public PhoneCodeUtil(Gson gson){
        data_list = gson.fromJson(data, PhoneCodeBean.class).getList();
    }

    public List get_code_list(){
        List<Integer> list = new ArrayList<>();
        for (PhoneCodeBean.ListBean item : data_list) {
            list.add(item.getCode());
        }
        return list;
    }

    public List get_spinner_list(){
        List<String> list = new ArrayList<>();
        for (PhoneCodeBean.ListBean item : data_list) {
            list.add("+"+item.getCode()+" "+item.getEn());
        }
        return list;
    }

    private String data ="{list:[\n" +
            "  {\n" +
            "    \"en\": \"Japan\",\n" +
            "    \"zh\": \"日本\",\n" +
            "    \"locale\": \"JP\",\n" +
            "    \"code\": 81\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Angola\",\n" +
            "    \"zh\": \"安哥拉\",\n" +
            "    \"locale\": \"AO\",\n" +
            "    \"code\": 244\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Afghanistan\",\n" +
            "    \"zh\": \"阿富汗\",\n" +
            "    \"locale\": \"AF\",\n" +
            "    \"code\": 93\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Albania\",\n" +
            "    \"zh\": \"阿尔巴尼亚\",\n" +
            "    \"locale\": \"AL\",\n" +
            "    \"code\": 355\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Algeria\",\n" +
            "    \"zh\": \"阿尔及利亚\",\n" +
            "    \"locale\": \"DZ\",\n" +
            "    \"code\": 213\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Andorra\",\n" +
            "    \"zh\": \"安道尔共和国\",\n" +
            "    \"locale\": \"AD\",\n" +
            "    \"code\": 376\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Anguilla\",\n" +
            "    \"zh\": \"安圭拉岛\",\n" +
            "    \"locale\": \"AI\",\n" +
            "    \"code\": 1264\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Antigua and Barbuda\",\n" +
            "    \"zh\": \"安提瓜和巴布达\",\n" +
            "    \"locale\": \"AG\",\n" +
            "    \"code\": 1268\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Argentina\",\n" +
            "    \"zh\": \"阿根廷\",\n" +
            "    \"locale\": \"AR\",\n" +
            "    \"code\": 54\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Armenia\",\n" +
            "    \"zh\": \"亚美尼亚\",\n" +
            "    \"locale\": \"AM\",\n" +
            "    \"code\": 374\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Ascension\",\n" +
            "    \"zh\": \"阿森松\",\n" +
            "    \"locale\": \" \",\n" +
            "    \"code\": 247\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Australia\",\n" +
            "    \"zh\": \"澳大利亚\",\n" +
            "    \"locale\": \"AU\",\n" +
            "    \"code\": 61\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Austria\",\n" +
            "    \"zh\": \"奥地利\",\n" +
            "    \"locale\": \"AT\",\n" +
            "    \"code\": 43\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Azerbaijan\",\n" +
            "    \"zh\": \"阿塞拜疆\",\n" +
            "    \"locale\": \"AZ\",\n" +
            "    \"code\": 994\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Bahamas\",\n" +
            "    \"zh\": \"巴哈马\",\n" +
            "    \"locale\": \"BS\",\n" +
            "    \"code\": 1242\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Bahrain\",\n" +
            "    \"zh\": \"巴林\",\n" +
            "    \"locale\": \"BH\",\n" +
            "    \"code\": 973\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Bangladesh\",\n" +
            "    \"zh\": \"孟加拉国\",\n" +
            "    \"locale\": \"BD\",\n" +
            "    \"code\": 880\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Barbados\",\n" +
            "    \"zh\": \"巴巴多斯\",\n" +
            "    \"locale\": \"BB\",\n" +
            "    \"code\": 1246\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Belarus\",\n" +
            "    \"zh\": \"白俄罗斯\",\n" +
            "    \"locale\": \"BY\",\n" +
            "    \"code\": 375\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Belgium\",\n" +
            "    \"zh\": \"比利时\",\n" +
            "    \"locale\": \"BE\",\n" +
            "    \"code\": 32\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Belize\",\n" +
            "    \"zh\": \"伯利兹\",\n" +
            "    \"locale\": \"BZ\",\n" +
            "    \"code\": 501\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Benin\",\n" +
            "    \"zh\": \"贝宁\",\n" +
            "    \"locale\": \"BJ\",\n" +
            "    \"code\": 229\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Bermuda Is.\",\n" +
            "    \"zh\": \"百慕大群岛\",\n" +
            "    \"locale\": \"BM\",\n" +
            "    \"code\": 1441\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Bolivia\",\n" +
            "    \"zh\": \"玻利维亚\",\n" +
            "    \"locale\": \"BO\",\n" +
            "    \"code\": 591\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Botswana\",\n" +
            "    \"zh\": \"博茨瓦纳\",\n" +
            "    \"locale\": \"BW\",\n" +
            "    \"code\": 267\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Brazil\",\n" +
            "    \"zh\": \"巴西\",\n" +
            "    \"locale\": \"BR\",\n" +
            "    \"code\": 55\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Brunei\",\n" +
            "    \"zh\": \"文莱\",\n" +
            "    \"locale\": \"BN\",\n" +
            "    \"code\": 673\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Bulgaria\",\n" +
            "    \"zh\": \"保加利亚\",\n" +
            "    \"locale\": \"BG\",\n" +
            "    \"code\": 359\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Burkina-faso\",\n" +
            "    \"zh\": \"布基纳法索\",\n" +
            "    \"locale\": \"BF\",\n" +
            "    \"code\": 226\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Burma\",\n" +
            "    \"zh\": \"缅甸\",\n" +
            "    \"locale\": \"MM\",\n" +
            "    \"code\": 95\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Burundi\",\n" +
            "    \"zh\": \"布隆迪\",\n" +
            "    \"locale\": \"BI\",\n" +
            "    \"code\": 257\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Cameroon\",\n" +
            "    \"zh\": \"喀麦隆\",\n" +
            "    \"locale\": \"CM\",\n" +
            "    \"code\": 237\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Canada\",\n" +
            "    \"zh\": \"加拿大\",\n" +
            "    \"locale\": \"CA\",\n" +
            "    \"code\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Cayman Is.\",\n" +
            "    \"zh\": \"开曼群岛\",\n" +
            "    \"locale\": \" \",\n" +
            "    \"code\": 1345\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Central African Republic\",\n" +
            "    \"zh\": \"中非共和国\",\n" +
            "    \"locale\": \"CF\",\n" +
            "    \"code\": 236\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Chad\",\n" +
            "    \"zh\": \"乍得\",\n" +
            "    \"locale\": \"TD\",\n" +
            "    \"code\": 235\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Chile\",\n" +
            "    \"zh\": \"智利\",\n" +
            "    \"locale\": \"CL\",\n" +
            "    \"code\": 56\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"China\",\n" +
            "    \"zh\": \"中国\",\n" +
            "    \"locale\": \"CN\",\n" +
            "    \"code\": 86\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Colombia\",\n" +
            "    \"zh\": \"哥伦比亚\",\n" +
            "    \"locale\": \"CO\",\n" +
            "    \"code\": 57\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Congo\",\n" +
            "    \"zh\": \"刚果\",\n" +
            "    \"locale\": \"CG\",\n" +
            "    \"code\": 242\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Cook Is.\",\n" +
            "    \"zh\": \"库克群岛\",\n" +
            "    \"locale\": \"CK\",\n" +
            "    \"code\": 682\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Costa Rica\",\n" +
            "    \"zh\": \"哥斯达黎加\",\n" +
            "    \"locale\": \"CR\",\n" +
            "    \"code\": 506\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Cuba\",\n" +
            "    \"zh\": \"古巴\",\n" +
            "    \"locale\": \"CU\",\n" +
            "    \"code\": 53\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Cyprus\",\n" +
            "    \"zh\": \"塞浦路斯\",\n" +
            "    \"locale\": \"CY\",\n" +
            "    \"code\": 357\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Czech Republic\",\n" +
            "    \"zh\": \"捷克\",\n" +
            "    \"locale\": \"CZ\",\n" +
            "    \"code\": 420\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Denmark\",\n" +
            "    \"zh\": \"丹麦\",\n" +
            "    \"locale\": \"DK\",\n" +
            "    \"code\": 45\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Djibouti\",\n" +
            "    \"zh\": \"吉布提\",\n" +
            "    \"locale\": \"DJ\",\n" +
            "    \"code\": 253\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Dominica Rep.\",\n" +
            "    \"zh\": \"多米尼加共和国\",\n" +
            "    \"locale\": \"DO\",\n" +
            "    \"code\": 1890\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Ecuador\",\n" +
            "    \"zh\": \"厄瓜多尔\",\n" +
            "    \"locale\": \"EC\",\n" +
            "    \"code\": 593\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Egypt\",\n" +
            "    \"zh\": \"埃及\",\n" +
            "    \"locale\": \"EG\",\n" +
            "    \"code\": 20\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"EI Salvador\",\n" +
            "    \"zh\": \"萨尔瓦多\",\n" +
            "    \"locale\": \"SV\",\n" +
            "    \"code\": 503\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Estonia\",\n" +
            "    \"zh\": \"爱沙尼亚\",\n" +
            "    \"locale\": \"EE\",\n" +
            "    \"code\": 372\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Ethiopia\",\n" +
            "    \"zh\": \"埃塞俄比亚\",\n" +
            "    \"locale\": \"ET\",\n" +
            "    \"code\": 251\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Fiji\",\n" +
            "    \"zh\": \"斐济\",\n" +
            "    \"locale\": \"FJ\",\n" +
            "    \"code\": 679\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Finland\",\n" +
            "    \"zh\": \"芬兰\",\n" +
            "    \"locale\": \"FI\",\n" +
            "    \"code\": 358\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"France\",\n" +
            "    \"zh\": \"法国\",\n" +
            "    \"locale\": \"FR\",\n" +
            "    \"code\": 33\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"French Guiana\",\n" +
            "    \"zh\": \"法属圭亚那\",\n" +
            "    \"locale\": \"GF\",\n" +
            "    \"code\": 594\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Gabon\",\n" +
            "    \"zh\": \"加蓬\",\n" +
            "    \"locale\": \"GA\",\n" +
            "    \"code\": 241\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Gambia\",\n" +
            "    \"zh\": \"冈比亚\",\n" +
            "    \"locale\": \"GM\",\n" +
            "    \"code\": 220\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Georgia\",\n" +
            "    \"zh\": \"格鲁吉亚\",\n" +
            "    \"locale\": \"GE\",\n" +
            "    \"code\": 995\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Germany\",\n" +
            "    \"zh\": \"德国\",\n" +
            "    \"locale\": \"DE\",\n" +
            "    \"code\": 49\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Ghana\",\n" +
            "    \"zh\": \"加纳\",\n" +
            "    \"locale\": \"GH\",\n" +
            "    \"code\": 233\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Gibraltar\",\n" +
            "    \"zh\": \"直布罗陀\",\n" +
            "    \"locale\": \"GI\",\n" +
            "    \"code\": 350\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Greece\",\n" +
            "    \"zh\": \"希腊\",\n" +
            "    \"locale\": \"GR\",\n" +
            "    \"code\": 30\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Grenada\",\n" +
            "    \"zh\": \"格林纳达\",\n" +
            "    \"locale\": \"GD\",\n" +
            "    \"code\": 1809\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Guam\",\n" +
            "    \"zh\": \"关岛\",\n" +
            "    \"locale\": \"GU\",\n" +
            "    \"code\": 1671\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Guatemala\",\n" +
            "    \"zh\": \"危地马拉\",\n" +
            "    \"locale\": \"GT\",\n" +
            "    \"code\": 502\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Guinea\",\n" +
            "    \"zh\": \"几内亚\",\n" +
            "    \"locale\": \"GN\",\n" +
            "    \"code\": 224\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Guyana\",\n" +
            "    \"zh\": \"圭亚那\",\n" +
            "    \"locale\": \"GY\",\n" +
            "    \"code\": 592\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Haiti\",\n" +
            "    \"zh\": \"海地\",\n" +
            "    \"locale\": \"HT\",\n" +
            "    \"code\": 509\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Honduras\",\n" +
            "    \"zh\": \"洪都拉斯\",\n" +
            "    \"locale\": \"HN\",\n" +
            "    \"code\": 504\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Hongkong\",\n" +
            "    \"zh\": \"香港\",\n" +
            "    \"locale\": \"HK\",\n" +
            "    \"code\": 852\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Hungary\",\n" +
            "    \"zh\": \"匈牙利\",\n" +
            "    \"locale\": \"HU\",\n" +
            "    \"code\": 36\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Iceland\",\n" +
            "    \"zh\": \"冰岛\",\n" +
            "    \"locale\": \"IS\",\n" +
            "    \"code\": 354\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"India\",\n" +
            "    \"zh\": \"印度\",\n" +
            "    \"locale\": \"IN\",\n" +
            "    \"code\": 91\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Indonesia\",\n" +
            "    \"zh\": \"印度尼西亚\",\n" +
            "    \"locale\": \"ID\",\n" +
            "    \"code\": 62\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Iran\",\n" +
            "    \"zh\": \"伊朗\",\n" +
            "    \"locale\": \"IR\",\n" +
            "    \"code\": 98\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Iraq\",\n" +
            "    \"zh\": \"伊拉克\",\n" +
            "    \"locale\": \"IQ\",\n" +
            "    \"code\": 964\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Ireland\",\n" +
            "    \"zh\": \"爱尔兰\",\n" +
            "    \"locale\": \"IE\",\n" +
            "    \"code\": 353\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Israel\",\n" +
            "    \"zh\": \"以色列\",\n" +
            "    \"locale\": \"IL\",\n" +
            "    \"code\": 972\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Italy\",\n" +
            "    \"zh\": \"意大利\",\n" +
            "    \"locale\": \"IT\",\n" +
            "    \"code\": 39\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Ivory Coast\",\n" +
            "    \"zh\": \"科特迪瓦\",\n" +
            "    \"locale\": \" \",\n" +
            "    \"code\": 225\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Jamaica\",\n" +
            "    \"zh\": \"牙买加\",\n" +
            "    \"locale\": \"JM\",\n" +
            "    \"code\": 1876\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Jordan\",\n" +
            "    \"zh\": \"约旦\",\n" +
            "    \"locale\": \"JO\",\n" +
            "    \"code\": 962\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Kampuchea (Cambodia )\",\n" +
            "    \"zh\": \"柬埔寨\",\n" +
            "    \"locale\": \"KH\",\n" +
            "    \"code\": 855\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Kazakstan\",\n" +
            "    \"zh\": \"哈萨克斯坦\",\n" +
            "    \"locale\": \"KZ\",\n" +
            "    \"code\": 327\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Kenya\",\n" +
            "    \"zh\": \"肯尼亚\",\n" +
            "    \"locale\": \"KE\",\n" +
            "    \"code\": 254\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Korea\",\n" +
            "    \"zh\": \"韩国\",\n" +
            "    \"locale\": \"KR\",\n" +
            "    \"code\": 82\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Kuwait\",\n" +
            "    \"zh\": \"科威特\",\n" +
            "    \"locale\": \"KW\",\n" +
            "    \"code\": 965\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Kyrgyzstan\",\n" +
            "    \"zh\": \"吉尔吉斯坦\",\n" +
            "    \"locale\": \"KG\",\n" +
            "    \"code\": 331\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Laos\",\n" +
            "    \"zh\": \"老挝\",\n" +
            "    \"locale\": \"LA\",\n" +
            "    \"code\": 856\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Latvia\",\n" +
            "    \"zh\": \"拉脱维亚\",\n" +
            "    \"locale\": \"LV\",\n" +
            "    \"code\": 371\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Lebanon\",\n" +
            "    \"zh\": \"黎巴嫩\",\n" +
            "    \"locale\": \"LB\",\n" +
            "    \"code\": 961\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Lesotho\",\n" +
            "    \"zh\": \"莱索托\",\n" +
            "    \"locale\": \"LS\",\n" +
            "    \"code\": 266\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Liberia\",\n" +
            "    \"zh\": \"利比里亚\",\n" +
            "    \"locale\": \"LR\",\n" +
            "    \"code\": 231\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Libya\",\n" +
            "    \"zh\": \"利比亚\",\n" +
            "    \"locale\": \"LY\",\n" +
            "    \"code\": 218\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Liechtenstein\",\n" +
            "    \"zh\": \"列支敦士登\",\n" +
            "    \"locale\": \"LI\",\n" +
            "    \"code\": 423\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Lithuania\",\n" +
            "    \"zh\": \"立陶宛\",\n" +
            "    \"locale\": \"LT\",\n" +
            "    \"code\": 370\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Luxembourg\",\n" +
            "    \"zh\": \"卢森堡\",\n" +
            "    \"locale\": \"LU\",\n" +
            "    \"code\": 352\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Macao\",\n" +
            "    \"zh\": \"澳门\",\n" +
            "    \"locale\": \"MO\",\n" +
            "    \"code\": 853\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Madagascar\",\n" +
            "    \"zh\": \"马达加斯加\",\n" +
            "    \"locale\": \"MG\",\n" +
            "    \"code\": 261\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Malawi\",\n" +
            "    \"zh\": \"马拉维\",\n" +
            "    \"locale\": \"MW\",\n" +
            "    \"code\": 265\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Malaysia\",\n" +
            "    \"zh\": \"马来西亚\",\n" +
            "    \"locale\": \"MY\",\n" +
            "    \"code\": 60\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Maldives\",\n" +
            "    \"zh\": \"马尔代夫\",\n" +
            "    \"locale\": \"MV\",\n" +
            "    \"code\": 960\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Mali\",\n" +
            "    \"zh\": \"马里\",\n" +
            "    \"locale\": \"ML\",\n" +
            "    \"code\": 223\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Malta\",\n" +
            "    \"zh\": \"马耳他\",\n" +
            "    \"locale\": \"MT\",\n" +
            "    \"code\": 356\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Mariana Is\",\n" +
            "    \"zh\": \"马里亚那群岛\",\n" +
            "    \"locale\": \" \",\n" +
            "    \"code\": 1670\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Martinique\",\n" +
            "    \"zh\": \"马提尼克\",\n" +
            "    \"locale\": \" \",\n" +
            "    \"code\": 596\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Mauritius\",\n" +
            "    \"zh\": \"毛里求斯\",\n" +
            "    \"locale\": \"MU\",\n" +
            "    \"code\": 230\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Mexico\",\n" +
            "    \"zh\": \"墨西哥\",\n" +
            "    \"locale\": \"MX\",\n" +
            "    \"code\": 52\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Moldova, Republic of\",\n" +
            "    \"zh\": \"摩尔多瓦\",\n" +
            "    \"locale\": \"MD\",\n" +
            "    \"code\": 373\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Monaco\",\n" +
            "    \"zh\": \"摩纳哥\",\n" +
            "    \"locale\": \"MC\",\n" +
            "    \"code\": 377\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Mongolia\",\n" +
            "    \"zh\": \"蒙古\",\n" +
            "    \"locale\": \"MN\",\n" +
            "    \"code\": 976\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Montserrat Is\",\n" +
            "    \"zh\": \"蒙特塞拉特岛\",\n" +
            "    \"locale\": \"MS\",\n" +
            "    \"code\": 1664\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Morocco\",\n" +
            "    \"zh\": \"摩洛哥\",\n" +
            "    \"locale\": \"MA\",\n" +
            "    \"code\": 212\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Mozambique\",\n" +
            "    \"zh\": \"莫桑比克\",\n" +
            "    \"locale\": \"MZ\",\n" +
            "    \"code\": 258\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Namibia\",\n" +
            "    \"zh\": \"纳米比亚\",\n" +
            "    \"locale\": \"NA\",\n" +
            "    \"code\": 264\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Nauru\",\n" +
            "    \"zh\": \"瑙鲁\",\n" +
            "    \"locale\": \"NR\",\n" +
            "    \"code\": 674\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Nepal\",\n" +
            "    \"zh\": \"尼泊尔\",\n" +
            "    \"locale\": \"NP\",\n" +
            "    \"code\": 977\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Netheriands Antilles\",\n" +
            "    \"zh\": \"荷属安的列斯\",\n" +
            "    \"locale\": \" \",\n" +
            "    \"code\": 599\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Netherlands\",\n" +
            "    \"zh\": \"荷兰\",\n" +
            "    \"locale\": \"NL\",\n" +
            "    \"code\": 31\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"New Zealand\",\n" +
            "    \"zh\": \"新西兰\",\n" +
            "    \"locale\": \"NZ\",\n" +
            "    \"code\": 64\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Nicaragua\",\n" +
            "    \"zh\": \"尼加拉瓜\",\n" +
            "    \"locale\": \"NI\",\n" +
            "    \"code\": 505\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Niger\",\n" +
            "    \"zh\": \"尼日尔\",\n" +
            "    \"locale\": \"NE\",\n" +
            "    \"code\": 227\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Nigeria\",\n" +
            "    \"zh\": \"尼日利亚\",\n" +
            "    \"locale\": \"NG\",\n" +
            "    \"code\": 234\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"North Korea\",\n" +
            "    \"zh\": \"朝鲜\",\n" +
            "    \"locale\": \"KP\",\n" +
            "    \"code\": 850\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Norway\",\n" +
            "    \"zh\": \"挪威\",\n" +
            "    \"locale\": \"NO\",\n" +
            "    \"code\": 47\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Oman\",\n" +
            "    \"zh\": \"阿曼\",\n" +
            "    \"locale\": \"OM\",\n" +
            "    \"code\": 968\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Pakistan\",\n" +
            "    \"zh\": \"巴基斯坦\",\n" +
            "    \"locale\": \"PK\",\n" +
            "    \"code\": 92\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Panama\",\n" +
            "    \"zh\": \"巴拿马\",\n" +
            "    \"locale\": \"PA\",\n" +
            "    \"code\": 507\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Papua New Cuinea\",\n" +
            "    \"zh\": \"巴布亚新几内亚\",\n" +
            "    \"locale\": \"PG\",\n" +
            "    \"code\": 675\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Paraguay\",\n" +
            "    \"zh\": \"巴拉圭\",\n" +
            "    \"locale\": \"PY\",\n" +
            "    \"code\": 595\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Peru\",\n" +
            "    \"zh\": \"秘鲁\",\n" +
            "    \"locale\": \"PE\",\n" +
            "    \"code\": 51\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Philippines\",\n" +
            "    \"zh\": \"菲律宾\",\n" +
            "    \"locale\": \"PH\",\n" +
            "    \"code\": 63\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Poland\",\n" +
            "    \"zh\": \"波兰\",\n" +
            "    \"locale\": \"PL\",\n" +
            "    \"code\": 48\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"French Polynesia\",\n" +
            "    \"zh\": \"法属玻利尼西亚\",\n" +
            "    \"locale\": \"PF\",\n" +
            "    \"code\": 689\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Portugal\",\n" +
            "    \"zh\": \"葡萄牙\",\n" +
            "    \"locale\": \"PT\",\n" +
            "    \"code\": 351\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Puerto Rico\",\n" +
            "    \"zh\": \"波多黎各\",\n" +
            "    \"locale\": \"PR\",\n" +
            "    \"code\": 1787\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Qatar\",\n" +
            "    \"zh\": \"卡塔尔\",\n" +
            "    \"locale\": \"QA\",\n" +
            "    \"code\": 974\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Reunion\",\n" +
            "    \"zh\": \"留尼旺\",\n" +
            "    \"locale\": \" \",\n" +
            "    \"code\": 262\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Romania\",\n" +
            "    \"zh\": \"罗马尼亚\",\n" +
            "    \"locale\": \"RO\",\n" +
            "    \"code\": 40\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Russia\",\n" +
            "    \"zh\": \"俄罗斯\",\n" +
            "    \"locale\": \"RU\",\n" +
            "    \"code\": 7\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Saint Lueia\",\n" +
            "    \"zh\": \"圣卢西亚\",\n" +
            "    \"locale\": \"LC\",\n" +
            "    \"code\": 1758\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Saint Vincent\",\n" +
            "    \"zh\": \"圣文森特岛\",\n" +
            "    \"locale\": \"VC\",\n" +
            "    \"code\": 1784\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Samoa Eastern\",\n" +
            "    \"zh\": \"东萨摩亚(美)\",\n" +
            "    \"locale\": \" \",\n" +
            "    \"code\": 684\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Samoa Western\",\n" +
            "    \"zh\": \"西萨摩亚\",\n" +
            "    \"locale\": \" \",\n" +
            "    \"code\": 685\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"San Marino\",\n" +
            "    \"zh\": \"圣马力诺\",\n" +
            "    \"locale\": \"SM\",\n" +
            "    \"code\": 378\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Sao Tome and Principe\",\n" +
            "    \"zh\": \"圣多美和普林西比\",\n" +
            "    \"locale\": \"ST\",\n" +
            "    \"code\": 239\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Saudi Arabia\",\n" +
            "    \"zh\": \"沙特阿拉伯\",\n" +
            "    \"locale\": \"SA\",\n" +
            "    \"code\": 966\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Senegal\",\n" +
            "    \"zh\": \"塞内加尔\",\n" +
            "    \"locale\": \"SN\",\n" +
            "    \"code\": 221\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Seychelles\",\n" +
            "    \"zh\": \"塞舌尔\",\n" +
            "    \"locale\": \"SC\",\n" +
            "    \"code\": 248\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Sierra Leone\",\n" +
            "    \"zh\": \"塞拉利昂\",\n" +
            "    \"locale\": \"SL\",\n" +
            "    \"code\": 232\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Singapore\",\n" +
            "    \"zh\": \"新加坡\",\n" +
            "    \"locale\": \"SG\",\n" +
            "    \"code\": 65\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Slovakia\",\n" +
            "    \"zh\": \"斯洛伐克\",\n" +
            "    \"locale\": \"SK\",\n" +
            "    \"code\": 421\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Slovenia\",\n" +
            "    \"zh\": \"斯洛文尼亚\",\n" +
            "    \"locale\": \"SI\",\n" +
            "    \"code\": 386\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Solomon Is\",\n" +
            "    \"zh\": \"所罗门群岛\",\n" +
            "    \"locale\": \"SB\",\n" +
            "    \"code\": 677\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Somali\",\n" +
            "    \"zh\": \"索马里\",\n" +
            "    \"locale\": \"SO\",\n" +
            "    \"code\": 252\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"South Africa\",\n" +
            "    \"zh\": \"南非\",\n" +
            "    \"locale\": \"ZA\",\n" +
            "    \"code\": 27\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Spain\",\n" +
            "    \"zh\": \"西班牙\",\n" +
            "    \"locale\": \"ES\",\n" +
            "    \"code\": 34\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Sri Lanka\",\n" +
            "    \"zh\": \"斯里兰卡\",\n" +
            "    \"locale\": \"LK\",\n" +
            "    \"code\": 94\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"St.Lucia\",\n" +
            "    \"zh\": \"圣卢西亚\",\n" +
            "    \"locale\": \"LC\",\n" +
            "    \"code\": 1758\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"St.Vincent\",\n" +
            "    \"zh\": \"圣文森特\",\n" +
            "    \"locale\": \"VC\",\n" +
            "    \"code\": 1784\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Sudan\",\n" +
            "    \"zh\": \"苏丹\",\n" +
            "    \"locale\": \"SD\",\n" +
            "    \"code\": 249\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Suriname\",\n" +
            "    \"zh\": \"苏里南\",\n" +
            "    \"locale\": \"SR\",\n" +
            "    \"code\": 597\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Swaziland\",\n" +
            "    \"zh\": \"斯威士兰\",\n" +
            "    \"locale\": \"SZ\",\n" +
            "    \"code\": 268\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Sweden\",\n" +
            "    \"zh\": \"瑞典\",\n" +
            "    \"locale\": \"SE\",\n" +
            "    \"code\": 46\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Switzerland\",\n" +
            "    \"zh\": \"瑞士\",\n" +
            "    \"locale\": \"CH\",\n" +
            "    \"code\": 41\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Syria\",\n" +
            "    \"zh\": \"叙利亚\",\n" +
            "    \"locale\": \"SY\",\n" +
            "    \"code\": 963\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Taiwan\",\n" +
            "    \"zh\": \"台湾省\",\n" +
            "    \"locale\": \"TW\",\n" +
            "    \"code\": 886\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Tajikstan\",\n" +
            "    \"zh\": \"塔吉克斯坦\",\n" +
            "    \"locale\": \"TJ\",\n" +
            "    \"code\": 992\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Tanzania\",\n" +
            "    \"zh\": \"坦桑尼亚\",\n" +
            "    \"locale\": \"TZ\",\n" +
            "    \"code\": 255\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Thailand\",\n" +
            "    \"zh\": \"泰国\",\n" +
            "    \"locale\": \"TH\",\n" +
            "    \"code\": 66\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Togo\",\n" +
            "    \"zh\": \"多哥\",\n" +
            "    \"locale\": \"TG\",\n" +
            "    \"code\": 228\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Tonga\",\n" +
            "    \"zh\": \"汤加\",\n" +
            "    \"locale\": \"TO\",\n" +
            "    \"code\": 676\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Trinidad and Tobago\",\n" +
            "    \"zh\": \"特立尼达和多巴哥\",\n" +
            "    \"locale\": \"TT\",\n" +
            "    \"code\": 1809\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Tunisia\",\n" +
            "    \"zh\": \"突尼斯\",\n" +
            "    \"locale\": \"TN\",\n" +
            "    \"code\": 216\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Turkey\",\n" +
            "    \"zh\": \"土耳其\",\n" +
            "    \"locale\": \"TR\",\n" +
            "    \"code\": 90\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Turkmenistan\",\n" +
            "    \"zh\": \"土库曼斯坦\",\n" +
            "    \"locale\": \"TM\",\n" +
            "    \"code\": 993\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Uganda\",\n" +
            "    \"zh\": \"乌干达\",\n" +
            "    \"locale\": \"UG\",\n" +
            "    \"code\": 256\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Ukraine\",\n" +
            "    \"zh\": \"乌克兰\",\n" +
            "    \"locale\": \"UA\",\n" +
            "    \"code\": 380\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"United Arab Emirates\",\n" +
            "    \"zh\": \"阿拉伯联合酋长国\",\n" +
            "    \"locale\": \"AE\",\n" +
            "    \"code\": 971\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"United Kiongdom\",\n" +
            "    \"zh\": \"英国\",\n" +
            "    \"locale\": \"GB\",\n" +
            "    \"code\": 44\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"United States of America\",\n" +
            "    \"zh\": \"美国\",\n" +
            "    \"locale\": \"US\",\n" +
            "    \"code\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Uruguay\",\n" +
            "    \"zh\": \"乌拉圭\",\n" +
            "    \"locale\": \"UY\",\n" +
            "    \"code\": 598\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Uzbekistan\",\n" +
            "    \"zh\": \"乌兹别克斯坦\",\n" +
            "    \"locale\": \"UZ\",\n" +
            "    \"code\": 233\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Venezuela\",\n" +
            "    \"zh\": \"委内瑞拉\",\n" +
            "    \"locale\": \"VE\",\n" +
            "    \"code\": 58\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Vietnam\",\n" +
            "    \"zh\": \"越南\",\n" +
            "    \"locale\": \"VN\",\n" +
            "    \"code\": 84\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Yemen\",\n" +
            "    \"zh\": \"也门\",\n" +
            "    \"locale\": \"YE\",\n" +
            "    \"code\": 967\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Yugoslavia\",\n" +
            "    \"zh\": \"南斯拉夫\",\n" +
            "    \"locale\": \"YU\",\n" +
            "    \"code\": 381\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Zimbabwe\",\n" +
            "    \"zh\": \"津巴布韦\",\n" +
            "    \"locale\": \"ZW\",\n" +
            "    \"code\": 263\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Zaire\",\n" +
            "    \"zh\": \"扎伊尔\",\n" +
            "    \"locale\": \"ZR\",\n" +
            "    \"code\": 243\n" +
            "  },\n" +
            "  {\n" +
            "    \"en\": \"Zambia\",\n" +
            "    \"zh\": \"赞比亚\",\n" +
            "    \"locale\": \"ZM\",\n" +
            "    \"code\": 260\n" +
            "  }\n" +
            "]}";

}
