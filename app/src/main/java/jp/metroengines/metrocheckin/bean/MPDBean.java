package jp.metroengines.metrocheckin.bean;

/**
 * Created by mac on 2018/1/23.
 */

public class MPDBean {

    /**
     * message : string
     * status : 0
     */

    private String message;
    private int status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
