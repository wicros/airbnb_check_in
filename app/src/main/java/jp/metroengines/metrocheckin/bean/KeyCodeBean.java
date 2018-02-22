package jp.metroengines.metrocheckin.bean;

/**
 * Created by mac on 2018/2/1.
 */

public class KeyCodeBean {

    /**
     * room_key : {"id":14,"password":"1325","state":1}
     * key_box : {"name":"key_stations_for_app"}
     * key_station : {"name":"エコロパーク大久保第28","lat":"35.70094","lon":"139.696787","postal_code":"169-0073","address":"東京都新宿区百人町1-21"}
     */

    private RoomKeyBean room_key;
    private KeyBoxBean key_box;
    private KeyStationBean key_station;

    public RoomKeyBean getRoom_key() {
        return room_key;
    }

    public void setRoom_key(RoomKeyBean room_key) {
        this.room_key = room_key;
    }

    public KeyBoxBean getKey_box() {
        return key_box;
    }

    public void setKey_box(KeyBoxBean key_box) {
        this.key_box = key_box;
    }

    public KeyStationBean getKey_station() {
        return key_station;
    }

    public void setKey_station(KeyStationBean key_station) {
        this.key_station = key_station;
    }

    public static class RoomKeyBean {
        /**
         * id : 14
         * password : 1325
         * state : 1
         */

        private int id;
        private String password;
        private int state;
        private String slot_number;

        public String getSlot_number() {
            return slot_number;
        }

        public void setSlot_number(String slot_number) {
            this.slot_number = slot_number;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }
    }

    public static class KeyBoxBean {
        /**
         * name : key_stations_for_app
         */

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class KeyStationBean {
        /**
         * name : エコロパーク大久保第28
         * lat : 35.70094
         * lon : 139.696787
         * postal_code : 169-0073
         * address : 東京都新宿区百人町1-21
         */

        private String name;
        private String lat;
        private String lon;
        private String postal_code;
        private String address;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public String getPostal_code() {
            return postal_code;
        }

        public void setPostal_code(String postal_code) {
            this.postal_code = postal_code;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
