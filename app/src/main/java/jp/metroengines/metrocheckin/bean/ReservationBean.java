package jp.metroengines.metrocheckin.bean;

import java.util.List;

public class ReservationBean {

    private int id;
    private String account_id;
    private String user_id;
    private String reservation_code;
    private ListingBean listing;
    private int guest_id;
    private Object guest_email;
    private Object guest_phone;
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
    private Object owner_last_name;
    private Object owner_phone;
    private Object owner_picture_url;
    private Object owner_thumbnail_url;
    private String start_date;
    private String end_date;
    private int check_in_time;
    private int check_out_time;
    private String listing_id;

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

    public Object getGuest_email() {
        return guest_email;
    }

    public void setGuest_email(Object guest_email) {
        this.guest_email = guest_email;
    }

    public Object getGuest_phone() {
        return guest_phone;
    }

    public void setGuest_phone(Object guest_phone) {
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

    public Object getOwner_last_name() {
        return owner_last_name;
    }

    public void setOwner_last_name(Object owner_last_name) {
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

    public int getCheck_in_time() {
        return check_in_time;
    }

    public void setCheck_in_time(int check_in_time) {
        this.check_in_time = check_in_time;
    }

    public int getCheck_out_time() {
        return check_out_time;
    }

    public void setCheck_out_time(int check_out_time) {
        this.check_out_time = check_out_time;
    }

    public String getListing_id() {
        return listing_id;
    }

    public void setListing_id(String listing_id) {
        this.listing_id = listing_id;
    }

    public static class ListingBean {
        /**
         * airbnb_listing_id : 5207774
         * host_id : 6808667
         * price_formatted : ¥ 7494
         * medium_url : https://a0.muscache.com/im/pictures/67108264/58823732_original.jpg?aki_policy=medium
         * actual : true
         * person_capacity : 2
         * manage_listing_id : null
         * city : Minato-ku
         * country : Japan
         * state : Tōkyō-to
         * street : 1 Chome-12-6 Higashiazabu
         * zipcode : 106-0044
         * latitude : 35.6572792559133
         * longitude : 139.744718825274
         * beds : 2
         * bedrooms : 1
         * bathrooms : 1
         * summary : **-Campaign Price!!-**
         *Free portable Wi-Fi
         *3min walk from Metro Station!
         *3min walk TOKYO TOWER(AS THE SYMBOL OF TOKYO)
         *TOKYO TOWER NIGHT VIEW
         *4 min by train to Roppongi
         * description : **-Campaign Price!!-**
         *Free portable Wi-Fi
         *3min walk from Metro Station!
         *3min walk TOKYO TOWER(AS THE SYMBOL OF TOKYO)
         *TOKYO TOWER NIGHT VIEW
         *4 min by train to Roppongi

         Hello!

         During your stay
         I'd be happy recommend some places to visit and we can go out for the occasional meal or drink!!

         I work at 7min to the apartment so I can provide support quickly.
         Guest can reach me by phone, e-mail, LINE,  (SENSITIVE CONTENTS HIDDEN)...anytime.

         **Location**
         Located in Central Minato-ku, Roppongi,Azabu Juban, 300m or 5 minute walk to Akabanebashi Metro Station. Roppongi is within walking distance to Tokyo Tower, Azabu-Juban and Nishi-Azabu. Literally steps away from a variety of restaurants, grocery stores (Japanese & International), Banks, Coffee Shops and Convenience stores (24 hours)

         **Sights in the area worth mentioning**
         -Tokyo Tower (3 minute walk from apartment)
         -Azabu Juban shopping street (9 minute walk from apartment)
         -Roppongi Hills Shopping Plaza (15 minute walk from apartment)


         **Easy Train Access To**
         - ROPPONGI ( 3min)
         - GINZA    (15min)
         - SHINJUKU (13min)
         - TOKYO    (16min)
         - TSUKIJI  (16min)
         - SHIBUYA  (15min)
         - ASAKUSA  (22min)


         **Easy Access to the Airports**
         - Easy access from Haneda airport using Keikyu line and Oedo-line.


         **IN-ROOM FACILITIES**
         ROOM SIZE: 26m2
         BED SIZE: 2 x (90 x 200)
         -individual air conditioning / heating
         -refrigerator
         -water heater
         -free wireless internet access
         -portable free wifi
         -table
         -full kitchen

         **BATHROOM & BENEFITS**
         -shower, toilette, sink and towels
         -automatic hair dryer
         -soap, body & hair shampoo

         If need anything else, feel free to ask me!
         * photos : [{"caption":"","large":"https://a0.muscache.com/im/pictures/67108264/58823732_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67108264/58823732_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67108264/58823732_original.jpg?aki_policy=small"},{"caption":"TOKYO TOWER (AS THE SYMBOL OF TOKYO)NIGHT VIEW","large":"https://a0.muscache.com/im/pictures/67110533/f7288f44_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67110533/f7288f44_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67110533/f7288f44_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67108070/48e3a18c_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67108070/48e3a18c_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67108070/48e3a18c_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67108326/c090362d_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67108326/c090362d_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67108326/c090362d_original.jpg?aki_policy=small"},{"caption":"Free Portable Wi-Fi","large":"https://a0.muscache.com/im/pictures/67109852/9b6605f6_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67109852/9b6605f6_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67109852/9b6605f6_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67108378/5093d229_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67108378/5093d229_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67108378/5093d229_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67107829/d500f59f_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67107829/d500f59f_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67107829/d500f59f_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67107849/ac7f20be_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67107849/ac7f20be_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67107849/ac7f20be_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/65380950/c6f68c66_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/65380950/c6f68c66_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/65380950/c6f68c66_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/65380890/1ebb75d1_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/65380890/1ebb75d1_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/65380890/1ebb75d1_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67107779/bbd5ab03_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67107779/bbd5ab03_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67107779/bbd5ab03_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/65326703/6325c9f9_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/65326703/6325c9f9_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/65326703/6325c9f9_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/65326594/bca6c9bd_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/65326594/bca6c9bd_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/65326594/bca6c9bd_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67107901/27c7c357_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67107901/27c7c357_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67107901/27c7c357_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67107806/c056b228_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67107806/c056b228_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67107806/c056b228_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/65326797/27cbdd53_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/65326797/27cbdd53_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/65326797/27cbdd53_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67107859/24017a2f_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67107859/24017a2f_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67107859/24017a2f_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/65380856/56f856ab_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/65380856/56f856ab_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/65380856/56f856ab_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67107749/ae61fcba_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67107749/ae61fcba_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67107749/ae61fcba_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67107755/47d87f58_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67107755/47d87f58_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67107755/47d87f58_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67107873/9b76dc8f_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67107873/9b76dc8f_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67107873/9b76dc8f_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67107922/0f179d84_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67107922/0f179d84_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67107922/0f179d84_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/65380875/b1abab35_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/65380875/b1abab35_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/65380875/b1abab35_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67107933/14e36469_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67107933/14e36469_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67107933/14e36469_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67107945/b6024e45_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67107945/b6024e45_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67107945/b6024e45_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67107960/ae67cd6d_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67107960/ae67cd6d_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67107960/ae67cd6d_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/65380822/582cffbc_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/65380822/582cffbc_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/65380822/582cffbc_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/65380929/39f948da_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/65380929/39f948da_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/65380929/39f948da_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67107975/e400c878_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67107975/e400c878_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67107975/e400c878_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67107996/48261b91_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67107996/48261b91_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67107996/48261b91_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67108346/2a3c4df3_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67108346/2a3c4df3_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67108346/2a3c4df3_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67108031/750f7298_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67108031/750f7298_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67108031/750f7298_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67108050/23fb6187_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67108050/23fb6187_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67108050/23fb6187_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67108095/dcfce1b5_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67108095/dcfce1b5_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67108095/dcfce1b5_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67108110/5e51fc5b_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67108110/5e51fc5b_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67108110/5e51fc5b_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67108147/449c4325_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67108147/449c4325_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67108147/449c4325_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67108163/8ecb9e70_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67108163/8ecb9e70_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67108163/8ecb9e70_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67108189/ff063bf3_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67108189/ff063bf3_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67108189/ff063bf3_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67108214/41c9df4f_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67108214/41c9df4f_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67108214/41c9df4f_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67108231/d4e4e64d_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67108231/d4e4e64d_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67108231/d4e4e64d_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67108361/65a7542b_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67108361/65a7542b_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67108361/65a7542b_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67110609/9b413aad_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67110609/9b413aad_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67110609/9b413aad_original.jpg?aki_policy=small"},{"caption":"Shibuya crossing (15min by train)  ","large":"https://a0.muscache.com/im/pictures/67411009/c2172075_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67411009/c2172075_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67411009/c2172075_original.jpg?aki_policy=small"},{"caption":"The Kill Bill restaurant, 'Gonpachi' is a notable tourist attraction. (10min by taxi)","large":"https://a0.muscache.com/im/pictures/67411206/eb88fe03_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67411206/eb88fe03_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67411206/eb88fe03_original.jpg?aki_policy=small"},{"caption":"Roppongi crossing(3min by train)","large":"https://a0.muscache.com/im/pictures/67411499/ca6bc298_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67411499/ca6bc298_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67411499/ca6bc298_original.jpg?aki_policy=small"},{"caption":"Tokyo tower (3min on foot)","large":"https://a0.muscache.com/im/pictures/67411649/1827f10a_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67411649/1827f10a_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67411649/1827f10a_original.jpg?aki_policy=small"},{"caption":"Asakusa (22min by train)","large":"https://a0.muscache.com/im/pictures/67411923/8a9dbc4e_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67411923/8a9dbc4e_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67411923/8a9dbc4e_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67415031/ef49f0c8_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67415031/ef49f0c8_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67415031/ef49f0c8_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67415053/bf966ed1_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67415053/bf966ed1_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67415053/bf966ed1_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67415069/a8802cf2_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67415069/a8802cf2_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67415069/a8802cf2_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67415090/9ad3c086_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67415090/9ad3c086_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67415090/9ad3c086_original.jpg?aki_policy=small"},{"caption":"","large":"https://a0.muscache.com/im/pictures/67415230/1a1af38d_original.jpg?aki_policy=x_large","picture":"https://a0.muscache.com/im/pictures/67415230/1a1af38d_original.jpg?aki_policy=large","thumbnail":"https://a0.muscache.com/im/pictures/67415230/1a1af38d_original.jpg?aki_policy=small"}]
         * notes :
         * neighborhood_overview :
         * interaction :
         * check_in_time : 15
         * check_out_time : 11
         * house_rules : • Check-in time is 3PM - 2AM (next day)
         • Not safe or suitable for children (0-12 years)
         • No parties or events
         • Not suitable for pets
         • No smoking

         土足厳禁
         * guest_controls : null
         * amenities : ["Internet","Wireless Internet","Air conditioning","Kitchen","Elevator","Buzzer/wireless intercom","Heating","Washer","Dryer","Essentials","Shampoo","24-hour check-in","Hangers","Hair dryer","Iron","Laptop friendly workspace","translation missing: en.hosting_amenity_49","translation missing: en.hosting_amenity_50","Room-darkening shades","Hot water","Bed linens","Pocket wifi","Microwave","Refrigerator","Dishes and silverware","Cooking basics","Stove","Long term stays allowed"]
         * space : Hello!

         During your stay
         I'd be happy recommend some places to visit and we can go out for the occasional meal or drink!!

         I work at 7min to the apartment so I can provide support quickly.
         Guest can reach me by phone, e-mail, LINE,  (SENSITIVE CONTENTS HIDDEN)...anytime.

         **Location**
         Located in Central Minato-ku, Roppongi,Azabu Juban, 300m or 5 minute walk to Akabanebashi Metro Station. Roppongi is within walking distance to Tokyo Tower, Azabu-Juban and Nishi-Azabu. Literally steps away from a variety of restaurants, grocery stores (Japanese & International), Banks, Coffee Shops and Convenience stores (24 hours)

         **Sights in the area worth mentioning**
         -Tokyo Tower (3 minute walk from apartment)
         -Azabu Juban shopping street (9 minute walk from apartment)
         -Roppongi Hills Shopping Plaza (15 minute walk from apartment)


         **Easy Train Access To**
         - ROPPONGI ( 3min)
         - GINZA    (15min)
         - SHINJUKU (13min)
         - TOKYO    (16min)
         - TSUKIJI  (16min)
         - SHIBUYA  (15min)
         - ASAKUSA  (22min)


         **Easy Access to the Airports**
         - Easy access from Haneda airport using Keikyu line and Oedo-line.


         **IN-ROOM FACILITIES**
         ROOM SIZE: 26m2
         BED SIZE: 2 x (90 x 200)
         -individual air conditioning / heating
         -refrigerator
         -water heater
         -free wireless internet access
         -portable free wifi
         -table
         -full kitchen

         **BATHROOM & BENEFITS**
         -shower, toilette, sink and towels
         -automatic hair dryer
         -soap, body & hair shampoo

         If need anything else, feel free to ask me!
         * wireless_info : {"wireless_password":"","wireless_ssid":"","wireless_type":"unknown"}
         * access :
         * transit :
         * id : 5mX7hb8MK1UkdU
         * name : 3min Sta. Night View LUX w/ FreeWi-Fi
         * account_id : dd717e68-d624-11e6-b6d9-06c00ec32331
         * full_address : Minato District, Minato-ku, Tōkyō-to 106-0044, Japan
         * guidebook : {"ja_address":"Minato District, Minato-ku, Tōkyō-to 106-0044, Japan","en_address":"Minato District, Minato-ku, Tōkyō-to 106-0044, Japan","ja_nearest_station":"","en_nearest_station":"test station","ja_directions_and_tips":"","en_directions_and_tips":"<ul>\r\n\t<li>From left<\/li>\r\n\t<li>To right<\/li>\r\n<\/ul>\r\n","ja_house_rules":"","en_house_rules":"<ol>\r\n\t<li>All allow<\/li>\r\n<\/ol>\r\n","check_in_time":7,"check_in_time_next_day":10,"check_out_time":12,"wifi_login":"testlogin","wifi_password":"testpassword","emergency_contact":"Sho","emergency_phone":"1234-567"}
         * import_status : null
         */

        private int airbnb_listing_id;
        private int host_id;
        private String price_formatted;
        private String medium_url;
        private boolean actual;
        private int person_capacity;
        private Object manage_listing_id;
        private String city;
        private String country;
        private String state;
        private String street;
        private String zipcode;
        private double latitude;
        private double longitude;
        private int beds;
        private int bedrooms;
        private int bathrooms;
        private String summary;
        private String description;
        private String notes;
        private String neighborhood_overview;
        private String interaction;
        private int check_in_time;
        private int check_out_time;
        private String house_rules;
        private Object guest_controls;
        private String space;
        private WirelessInfoBean wireless_info;
        private String access;
        private String transit;
        private String id;
        private String name;
        private String account_id;
        private String full_address;
        private GuidebookBean guidebook;
        private Object import_status;
        private List<PhotosBean> photos;
        private List<String> amenities;

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

        public int getPerson_capacity() {
            return person_capacity;
        }

        public void setPerson_capacity(int person_capacity) {
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

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
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

        public int getBeds() {
            return beds;
        }

        public void setBeds(int beds) {
            this.beds = beds;
        }

        public int getBedrooms() {
            return bedrooms;
        }

        public void setBedrooms(int bedrooms) {
            this.bedrooms = bedrooms;
        }

        public int getBathrooms() {
            return bathrooms;
        }

        public void setBathrooms(int bathrooms) {
            this.bathrooms = bathrooms;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public String getNeighborhood_overview() {
            return neighborhood_overview;
        }

        public void setNeighborhood_overview(String neighborhood_overview) {
            this.neighborhood_overview = neighborhood_overview;
        }

        public String getInteraction() {
            return interaction;
        }

        public void setInteraction(String interaction) {
            this.interaction = interaction;
        }

        public int getCheck_in_time() {
            return check_in_time;
        }

        public void setCheck_in_time(int check_in_time) {
            this.check_in_time = check_in_time;
        }

        public int getCheck_out_time() {
            return check_out_time;
        }

        public void setCheck_out_time(int check_out_time) {
            this.check_out_time = check_out_time;
        }

        public String getHouse_rules() {
            return house_rules;
        }

        public void setHouse_rules(String house_rules) {
            this.house_rules = house_rules;
        }

        public Object getGuest_controls() {
            return guest_controls;
        }

        public void setGuest_controls(Object guest_controls) {
            this.guest_controls = guest_controls;
        }

        public String getSpace() {
            return space;
        }

        public void setSpace(String space) {
            this.space = space;
        }

        public WirelessInfoBean getWireless_info() {
            return wireless_info;
        }

        public void setWireless_info(WirelessInfoBean wireless_info) {
            this.wireless_info = wireless_info;
        }

        public String getAccess() {
            return access;
        }

        public void setAccess(String access) {
            this.access = access;
        }

        public String getTransit() {
            return transit;
        }

        public void setTransit(String transit) {
            this.transit = transit;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
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

        public Object getImport_status() {
            return import_status;
        }

        public void setImport_status(Object import_status) {
            this.import_status = import_status;
        }

        public List<PhotosBean> getPhotos() {
            return photos;
        }

        public void setPhotos(List<PhotosBean> photos) {
            this.photos = photos;
        }

        public List<String> getAmenities() {
            return amenities;
        }

        public void setAmenities(List<String> amenities) {
            this.amenities = amenities;
        }

        public static class WirelessInfoBean {
            /**
             * wireless_password :
             * wireless_ssid :
             * wireless_type : unknown
             */

            private String wireless_password;
            private String wireless_ssid;
            private String wireless_type;

            public String getWireless_password() {
                return wireless_password;
            }

            public void setWireless_password(String wireless_password) {
                this.wireless_password = wireless_password;
            }

            public String getWireless_ssid() {
                return wireless_ssid;
            }

            public void setWireless_ssid(String wireless_ssid) {
                this.wireless_ssid = wireless_ssid;
            }

            public String getWireless_type() {
                return wireless_type;
            }

            public void setWireless_type(String wireless_type) {
                this.wireless_type = wireless_type;
            }
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

        public static class PhotosBean {
            /**
             * caption :
             * large : https://a0.muscache.com/im/pictures/67108264/58823732_original.jpg?aki_policy=x_large
             * picture : https://a0.muscache.com/im/pictures/67108264/58823732_original.jpg?aki_policy=large
             * thumbnail : https://a0.muscache.com/im/pictures/67108264/58823732_original.jpg?aki_policy=small
             */

            private String caption;
            private String large;
            private String picture;
            private String thumbnail;

            public String getCaption() {
                return caption;
            }

            public void setCaption(String caption) {
                this.caption = caption;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }
        }
    }
}
