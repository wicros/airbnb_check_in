package jp.metroengines.metrocheckin.bean;

/**
 * Created by mac on 2018/1/23.
 */

public class ReservationBean {


    /**
     * id : 28819
     * account_id : dd717e68-d624-11e6-b6d9-06c00ec32331
     * user_id : c9498f1c-5ab3-11e6-a5d3-06810f5cef63
     * reservation_code : HM24ZFJ3SY
     * listing : {"airbnb_listing_id":5207774,"host_id":6808667,"price_formatted":"¥ 7450","medium_url":"https://a0.muscache.com/im/pictures/67108264/58823732_original.jpg?aki_policy=medium","actual":true,"person_capacity":null,"manage_listing_id":null,"city":"Minato-ku","country":"Japan","state":null,"street":null,"zipcode":null,"latitude":35.6572792559133,"longitude":139.744718825274,"beds":null,"bedrooms":null,"bathrooms":null,"summary":null,"description":null,"photos":null,"notes":null,"neighborhood_overview":null,"interaction":null,"check_in_time":null,"check_out_time":null,"house_rules":null,"guest_controls":null,"amenities":null,"space":null,"wireless_info":null,"access":null,"transit":null,"id":842,"name":"3min Sta. Night View LUX w/ FreeWi-Fi","account_id":"dd717e68-d624-11e6-b6d9-06c00ec32331","full_address":"Minato District, Minato-ku, Tōkyō-to 106-0044, Japan","guidebook":{"ja_address":"Minato District, Minato-ku, Tōkyō-to 106-0044, Japan","en_address":"Minato District, Minato-ku, Tōkyō-to 106-0044, Japan","ja_nearest_station":"","en_nearest_station":"test station","ja_directions_and_tips":"","en_directions_and_tips":"<ul>\r\n\t<li>From left<\/li>\r\n\t<li>To right<\/li>\r\n<\/ul>\r\n","ja_house_rules":"","en_house_rules":"<ol>\r\n\t<li>All allow<\/li>\r\n<\/ol>\r\n","check_in_time":7,"check_in_time_next_day":10,"check_out_time":12,"wifi_login":"testlogin","wifi_password":"testpassword","emergency_contact":"Sho","emergency_phone":"1234-567"}}
     * guest_id : 64590317
     * guest_email : milind-r06n8bw37ow299wx@guest.airbnb.com
     * guest_phone : +81-80-2003-0699
     * number_of_guests : 1
     * guest_thumbnail_url : https://a0.muscache.com/im/pictures/ecc174f4-20e9-4688-bcbc-15f8517d3d9c.jpg?aki_policy=profile_small
     * guest_picture_url : https://a0.muscache.com/im/pictures/ecc174f4-20e9-4688-bcbc-15f8517d3d9c.jpg?aki_policy=profile_x_medium
     * guest_verified : false
     * guest_first_name : Milind
     * guest_last_name : Karve
     * nights : 9
     * price_per_night : 4968
     * service_fee : 3033
     * subtotal_price : 47748
     * airbnb_fee : 1462
     * payout : 46286
     * owner_first_name : Ryo
     * owner_last_name : Ando
     * owner_phone : null
     * owner_picture_url : null
     * owner_thumbnail_url : null
     * start_date : 2018-01-17
     * end_date : 2018-01-26
     * check_in_time : null
     * check_out_time : null
     */

    private int id;
    private String account_id;
    private String user_id;
    private String reservation_code;
    private ListingBean listing;
    private int guest_id;
    private String guest_email;
    private String guest_phone;
    private int number_of_guests;
    private String guest_thumbnail_url;
    private String guest_picture_url;
    private boolean guest_verified;
    private String guest_first_name;
    private String guest_last_name;
    private int nights;
    private int price_per_night;
    private int service_fee;
    private int subtotal_price;
    private int airbnb_fee;
    private int payout;
    private String owner_first_name;
    private String owner_last_name;
    private Object owner_phone;
    private Object owner_picture_url;
    private Object owner_thumbnail_url;
    private String start_date;
    private String end_date;
    private Object check_in_time;
    private Object check_out_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getReservation_code() {
        return reservation_code;
    }

    public void setReservation_code(String reservation_code) {
        this.reservation_code = reservation_code;
    }

    public ListingBean getListing() {
        return listing;
    }

    public void setListing(ListingBean listing) {
        this.listing = listing;
    }

    public int getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(int guest_id) {
        this.guest_id = guest_id;
    }

    public String getGuest_email() {
        return guest_email;
    }

    public void setGuest_email(String guest_email) {
        this.guest_email = guest_email;
    }

    public String getGuest_phone() {
        return guest_phone;
    }

    public void setGuest_phone(String guest_phone) {
        this.guest_phone = guest_phone;
    }

    public int getNumber_of_guests() {
        return number_of_guests;
    }

    public void setNumber_of_guests(int number_of_guests) {
        this.number_of_guests = number_of_guests;
    }

    public String getGuest_thumbnail_url() {
        return guest_thumbnail_url;
    }

    public void setGuest_thumbnail_url(String guest_thumbnail_url) {
        this.guest_thumbnail_url = guest_thumbnail_url;
    }

    public String getGuest_picture_url() {
        return guest_picture_url;
    }

    public void setGuest_picture_url(String guest_picture_url) {
        this.guest_picture_url = guest_picture_url;
    }

    public boolean isGuest_verified() {
        return guest_verified;
    }

    public void setGuest_verified(boolean guest_verified) {
        this.guest_verified = guest_verified;
    }

    public String getGuest_first_name() {
        return guest_first_name;
    }

    public void setGuest_first_name(String guest_first_name) {
        this.guest_first_name = guest_first_name;
    }

    public String getGuest_last_name() {
        return guest_last_name;
    }

    public void setGuest_last_name(String guest_last_name) {
        this.guest_last_name = guest_last_name;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public int getPrice_per_night() {
        return price_per_night;
    }

    public void setPrice_per_night(int price_per_night) {
        this.price_per_night = price_per_night;
    }

    public int getService_fee() {
        return service_fee;
    }

    public void setService_fee(int service_fee) {
        this.service_fee = service_fee;
    }

    public int getSubtotal_price() {
        return subtotal_price;
    }

    public void setSubtotal_price(int subtotal_price) {
        this.subtotal_price = subtotal_price;
    }

    public int getAirbnb_fee() {
        return airbnb_fee;
    }

    public void setAirbnb_fee(int airbnb_fee) {
        this.airbnb_fee = airbnb_fee;
    }

    public int getPayout() {
        return payout;
    }

    public void setPayout(int payout) {
        this.payout = payout;
    }

    public String getOwner_first_name() {
        return owner_first_name;
    }

    public void setOwner_first_name(String owner_first_name) {
        this.owner_first_name = owner_first_name;
    }

    public String getOwner_last_name() {
        return owner_last_name;
    }

    public void setOwner_last_name(String owner_last_name) {
        this.owner_last_name = owner_last_name;
    }

    public Object getOwner_phone() {
        return owner_phone;
    }

    public void setOwner_phone(Object owner_phone) {
        this.owner_phone = owner_phone;
    }

    public Object getOwner_picture_url() {
        return owner_picture_url;
    }

    public void setOwner_picture_url(Object owner_picture_url) {
        this.owner_picture_url = owner_picture_url;
    }

    public Object getOwner_thumbnail_url() {
        return owner_thumbnail_url;
    }

    public void setOwner_thumbnail_url(Object owner_thumbnail_url) {
        this.owner_thumbnail_url = owner_thumbnail_url;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public Object getCheck_in_time() {
        return check_in_time;
    }

    public void setCheck_in_time(Object check_in_time) {
        this.check_in_time = check_in_time;
    }

    public Object getCheck_out_time() {
        return check_out_time;
    }

    public void setCheck_out_time(Object check_out_time) {
        this.check_out_time = check_out_time;
    }

    public static class ListingBean {
        /**
         * airbnb_listing_id : 5207774
         * host_id : 6808667
         * price_formatted : ¥ 7450
         * medium_url : https://a0.muscache.com/im/pictures/67108264/58823732_original.jpg?aki_policy=medium
         * actual : true
         * person_capacity : null
         * manage_listing_id : null
         * city : Minato-ku
         * country : Japan
         * state : null
         * street : null
         * zipcode : null
         * latitude : 35.6572792559133
         * longitude : 139.744718825274
         * beds : null
         * bedrooms : null
         * bathrooms : null
         * summary : null
         * description : null
         * photos : null
         * notes : null
         * neighborhood_overview : null
         * interaction : null
         * check_in_time : null
         * check_out_time : null
         * house_rules : null
         * guest_controls : null
         * amenities : null
         * space : null
         * wireless_info : null
         * access : null
         * transit : null
         * id : 842
         * name : 3min Sta. Night View LUX w/ FreeWi-Fi
         * account_id : dd717e68-d624-11e6-b6d9-06c00ec32331
         * full_address : Minato District, Minato-ku, Tōkyō-to 106-0044, Japan
         * guidebook : {"ja_address":"Minato District, Minato-ku, Tōkyō-to 106-0044, Japan","en_address":"Minato District, Minato-ku, Tōkyō-to 106-0044, Japan","ja_nearest_station":"","en_nearest_station":"test station","ja_directions_and_tips":"","en_directions_and_tips":"<ul>\r\n\t<li>From left<\/li>\r\n\t<li>To right<\/li>\r\n<\/ul>\r\n","ja_house_rules":"","en_house_rules":"<ol>\r\n\t<li>All allow<\/li>\r\n<\/ol>\r\n","check_in_time":7,"check_in_time_next_day":10,"check_out_time":12,"wifi_login":"testlogin","wifi_password":"testpassword","emergency_contact":"Sho","emergency_phone":"1234-567"}
         */

        private int airbnb_listing_id;
        private int host_id;
        private String price_formatted;
        private String medium_url;
        private boolean actual;
        private Object person_capacity;
        private Object manage_listing_id;
        private String city;
        private String country;
        private Object state;
        private Object street;
        private Object zipcode;
        private double latitude;
        private double longitude;
        private Object beds;
        private Object bedrooms;
        private Object bathrooms;
        private Object summary;
        private Object description;
        private Object photos;
        private Object notes;
        private Object neighborhood_overview;
        private Object interaction;
        private Object check_in_time;
        private Object check_out_time;
        private Object house_rules;
        private Object guest_controls;
        private Object amenities;
        private Object space;
        private Object wireless_info;
        private Object access;
        private Object transit;
        private int id;
        private String name;
        private String account_id;
        private String full_address;
        private GuidebookBean guidebook;

        public int getAirbnb_listing_id() {
            return airbnb_listing_id;
        }

        public void setAirbnb_listing_id(int airbnb_listing_id) {
            this.airbnb_listing_id = airbnb_listing_id;
        }

        public int getHost_id() {
            return host_id;
        }

        public void setHost_id(int host_id) {
            this.host_id = host_id;
        }

        public String getPrice_formatted() {
            return price_formatted;
        }

        public void setPrice_formatted(String price_formatted) {
            this.price_formatted = price_formatted;
        }

        public String getMedium_url() {
            return medium_url;
        }

        public void setMedium_url(String medium_url) {
            this.medium_url = medium_url;
        }

        public boolean isActual() {
            return actual;
        }

        public void setActual(boolean actual) {
            this.actual = actual;
        }

        public Object getPerson_capacity() {
            return person_capacity;
        }

        public void setPerson_capacity(Object person_capacity) {
            this.person_capacity = person_capacity;
        }

        public Object getManage_listing_id() {
            return manage_listing_id;
        }

        public void setManage_listing_id(Object manage_listing_id) {
            this.manage_listing_id = manage_listing_id;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Object getState() {
            return state;
        }

        public void setState(Object state) {
            this.state = state;
        }

        public Object getStreet() {
            return street;
        }

        public void setStreet(Object street) {
            this.street = street;
        }

        public Object getZipcode() {
            return zipcode;
        }

        public void setZipcode(Object zipcode) {
            this.zipcode = zipcode;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public Object getBeds() {
            return beds;
        }

        public void setBeds(Object beds) {
            this.beds = beds;
        }

        public Object getBedrooms() {
            return bedrooms;
        }

        public void setBedrooms(Object bedrooms) {
            this.bedrooms = bedrooms;
        }

        public Object getBathrooms() {
            return bathrooms;
        }

        public void setBathrooms(Object bathrooms) {
            this.bathrooms = bathrooms;
        }

        public Object getSummary() {
            return summary;
        }

        public void setSummary(Object summary) {
            this.summary = summary;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public Object getPhotos() {
            return photos;
        }

        public void setPhotos(Object photos) {
            this.photos = photos;
        }

        public Object getNotes() {
            return notes;
        }

        public void setNotes(Object notes) {
            this.notes = notes;
        }

        public Object getNeighborhood_overview() {
            return neighborhood_overview;
        }

        public void setNeighborhood_overview(Object neighborhood_overview) {
            this.neighborhood_overview = neighborhood_overview;
        }

        public Object getInteraction() {
            return interaction;
        }

        public void setInteraction(Object interaction) {
            this.interaction = interaction;
        }

        public Object getCheck_in_time() {
            return check_in_time;
        }

        public void setCheck_in_time(Object check_in_time) {
            this.check_in_time = check_in_time;
        }

        public Object getCheck_out_time() {
            return check_out_time;
        }

        public void setCheck_out_time(Object check_out_time) {
            this.check_out_time = check_out_time;
        }

        public Object getHouse_rules() {
            return house_rules;
        }

        public void setHouse_rules(Object house_rules) {
            this.house_rules = house_rules;
        }

        public Object getGuest_controls() {
            return guest_controls;
        }

        public void setGuest_controls(Object guest_controls) {
            this.guest_controls = guest_controls;
        }

        public Object getAmenities() {
            return amenities;
        }

        public void setAmenities(Object amenities) {
            this.amenities = amenities;
        }

        public Object getSpace() {
            return space;
        }

        public void setSpace(Object space) {
            this.space = space;
        }

        public Object getWireless_info() {
            return wireless_info;
        }

        public void setWireless_info(Object wireless_info) {
            this.wireless_info = wireless_info;
        }

        public Object getAccess() {
            return access;
        }

        public void setAccess(Object access) {
            this.access = access;
        }

        public Object getTransit() {
            return transit;
        }

        public void setTransit(Object transit) {
            this.transit = transit;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAccount_id() {
            return account_id;
        }

        public void setAccount_id(String account_id) {
            this.account_id = account_id;
        }

        public String getFull_address() {
            return full_address;
        }

        public void setFull_address(String full_address) {
            this.full_address = full_address;
        }

        public GuidebookBean getGuidebook() {
            return guidebook;
        }

        public void setGuidebook(GuidebookBean guidebook) {
            this.guidebook = guidebook;
        }

        public static class GuidebookBean {
            /**
             * ja_address : Minato District, Minato-ku, Tōkyō-to 106-0044, Japan
             * en_address : Minato District, Minato-ku, Tōkyō-to 106-0044, Japan
             * ja_nearest_station :
             * en_nearest_station : test station
             * ja_directions_and_tips :
             * en_directions_and_tips : <ul>
             <li>From left</li>
             <li>To right</li>
             </ul>

             * ja_house_rules :
             * en_house_rules : <ol>
             <li>All allow</li>
             </ol>

             * check_in_time : 7
             * check_in_time_next_day : 10
             * check_out_time : 12
             * wifi_login : testlogin
             * wifi_password : testpassword
             * emergency_contact : Sho
             * emergency_phone : 1234-567
             */

            private String ja_address;
            private String en_address;
            private String ja_nearest_station;
            private String en_nearest_station;
            private String ja_directions_and_tips;
            private String en_directions_and_tips;
            private String ja_house_rules;
            private String en_house_rules;
            private int check_in_time;
            private int check_in_time_next_day;
            private int check_out_time;
            private String wifi_login;
            private String wifi_password;
            private String emergency_contact;
            private String emergency_phone;

            public String getJa_address() {
                return ja_address;
            }

            public void setJa_address(String ja_address) {
                this.ja_address = ja_address;
            }

            public String getEn_address() {
                return en_address;
            }

            public void setEn_address(String en_address) {
                this.en_address = en_address;
            }

            public String getJa_nearest_station() {
                return ja_nearest_station;
            }

            public void setJa_nearest_station(String ja_nearest_station) {
                this.ja_nearest_station = ja_nearest_station;
            }

            public String getEn_nearest_station() {
                return en_nearest_station;
            }

            public void setEn_nearest_station(String en_nearest_station) {
                this.en_nearest_station = en_nearest_station;
            }

            public String getJa_directions_and_tips() {
                return ja_directions_and_tips;
            }

            public void setJa_directions_and_tips(String ja_directions_and_tips) {
                this.ja_directions_and_tips = ja_directions_and_tips;
            }

            public String getEn_directions_and_tips() {
                return en_directions_and_tips;
            }

            public void setEn_directions_and_tips(String en_directions_and_tips) {
                this.en_directions_and_tips = en_directions_and_tips;
            }

            public String getJa_house_rules() {
                return ja_house_rules;
            }

            public void setJa_house_rules(String ja_house_rules) {
                this.ja_house_rules = ja_house_rules;
            }

            public String getEn_house_rules() {
                return en_house_rules;
            }

            public void setEn_house_rules(String en_house_rules) {
                this.en_house_rules = en_house_rules;
            }

            public int getCheck_in_time() {
                return check_in_time;
            }

            public void setCheck_in_time(int check_in_time) {
                this.check_in_time = check_in_time;
            }

            public int getCheck_in_time_next_day() {
                return check_in_time_next_day;
            }

            public void setCheck_in_time_next_day(int check_in_time_next_day) {
                this.check_in_time_next_day = check_in_time_next_day;
            }

            public int getCheck_out_time() {
                return check_out_time;
            }

            public void setCheck_out_time(int check_out_time) {
                this.check_out_time = check_out_time;
            }

            public String getWifi_login() {
                return wifi_login;
            }

            public void setWifi_login(String wifi_login) {
                this.wifi_login = wifi_login;
            }

            public String getWifi_password() {
                return wifi_password;
            }

            public void setWifi_password(String wifi_password) {
                this.wifi_password = wifi_password;
            }

            public String getEmergency_contact() {
                return emergency_contact;
            }

            public void setEmergency_contact(String emergency_contact) {
                this.emergency_contact = emergency_contact;
            }

            public String getEmergency_phone() {
                return emergency_phone;
            }

            public void setEmergency_phone(String emergency_phone) {
                this.emergency_phone = emergency_phone;
            }
        }
    }
}
