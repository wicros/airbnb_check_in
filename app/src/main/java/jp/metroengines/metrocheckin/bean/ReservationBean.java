package jp.metroengines.metrocheckin.bean;

/**
 * Created by mac on 2018/1/23.
 */

public class ReservationBean {

    /**
     * id : 0
     * start_date : 2018-01-23
     * end_date : 2018-01-23
     * check_in_time : 0
     * check_out_time : 0
     * guest_id : 0
     * guest_email : string
     * guest_phone : string
     * guest_first_name : string
     * guest_last_name : string
     * guest_thumbnail_url : string
     * guest_picture_url : string
     * number_of_guests : 0
     * nights : 0
     * price_per_night : 0
     * service_fee : 0
     * subtotal_price : 0
     * airbnb_fee : 0
     * payout : 0
     * reservation_code : string
     * owner_first_name : string
     * owner_last_name : string
     * owner_phone : string
     * owner_picture_url : string
     * owner_thumbnail_url : string
     * listing_id : string
     * guest_verified : true
     * listing : {"listing_name":"string","address":"string","city":"string","country":"string"}
     */

    private int id;
    private String start_date;
    private String end_date;
    private int check_in_time;
    private int check_out_time;
    private int guest_id;
    private String guest_email;
    private String guest_phone;
    private String guest_first_name;
    private String guest_last_name;
    private String guest_thumbnail_url;
    private String guest_picture_url;
    private int number_of_guests;
    private int nights;
    private int price_per_night;
    private int service_fee;
    private int subtotal_price;
    private int airbnb_fee;
    private int payout;
    private String reservation_code;
    private String owner_first_name;
    private String owner_last_name;
    private String owner_phone;
    private String owner_picture_url;
    private String owner_thumbnail_url;
    private String listing_id;
    private boolean guest_verified;
    private ListingBean listing;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNumber_of_guests() {
        return number_of_guests;
    }

    public void setNumber_of_guests(int number_of_guests) {
        this.number_of_guests = number_of_guests;
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

    public String getReservation_code() {
        return reservation_code;
    }

    public void setReservation_code(String reservation_code) {
        this.reservation_code = reservation_code;
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

    public String getOwner_phone() {
        return owner_phone;
    }

    public void setOwner_phone(String owner_phone) {
        this.owner_phone = owner_phone;
    }

    public String getOwner_picture_url() {
        return owner_picture_url;
    }

    public void setOwner_picture_url(String owner_picture_url) {
        this.owner_picture_url = owner_picture_url;
    }

    public String getOwner_thumbnail_url() {
        return owner_thumbnail_url;
    }

    public void setOwner_thumbnail_url(String owner_thumbnail_url) {
        this.owner_thumbnail_url = owner_thumbnail_url;
    }

    public String getListing_id() {
        return listing_id;
    }

    public void setListing_id(String listing_id) {
        this.listing_id = listing_id;
    }

    public boolean isGuest_verified() {
        return guest_verified;
    }

    public void setGuest_verified(boolean guest_verified) {
        this.guest_verified = guest_verified;
    }

    public ListingBean getListing() {
        return listing;
    }

    public void setListing(ListingBean listing) {
        this.listing = listing;
    }

    public static class ListingBean {
        /**
         * listing_name : string
         * address : string
         * city : string
         * country : string
         */

        private String listing_name;
        private String address;
        private String city;
        private String country;

        public String getListing_name() {
            return listing_name;
        }

        public void setListing_name(String listing_name) {
            this.listing_name = listing_name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
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
    }
}
