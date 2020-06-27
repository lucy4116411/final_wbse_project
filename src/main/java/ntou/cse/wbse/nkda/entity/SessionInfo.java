package ntou.cse.wbse.nkda.entity;

public class SessionInfo {
    private String userName;
    private String auth;

    public String getAuth() {
        return auth;
    }

    public String getUserName() {
        return userName;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
