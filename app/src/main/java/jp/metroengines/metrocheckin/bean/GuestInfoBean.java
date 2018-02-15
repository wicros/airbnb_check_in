package jp.metroengines.metrocheckin.bean;

import java.util.List;

/**
 * Created by mac on 2018/2/15.
 */

public class GuestInfoBean {

    private List<InfoListBean> info_list;

    public List<InfoListBean> getInfo_list() {
        return info_list;
    }

    public void setInfo_list(List<InfoListBean> info_list) {
        this.info_list = info_list;
    }

    public static class InfoListBean {
        /**
         * address : Tokyo
         * name : fff
         * tel : 86-25887423
         * profession : っっっっっvr
         */

        private String address;
        private String name;
        private String tel;
        private String profession;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }
    }
}
