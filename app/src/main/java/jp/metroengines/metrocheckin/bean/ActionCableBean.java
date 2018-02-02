package jp.metroengines.metrocheckin.bean;

/**
 * Created by mac on 2018/1/30.
 */

public class ActionCableBean {

    /**
     * event : call_indication_received
     * device_id : 38f38d10dccc7
     */

    private String event;
    private String device_id;
    private boolean guest_verified;

    public boolean getGuest_verified() {
        return guest_verified;
    }

    public void setGuest_verified(boolean guest_verified) {
        this.guest_verified = guest_verified;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }
}
