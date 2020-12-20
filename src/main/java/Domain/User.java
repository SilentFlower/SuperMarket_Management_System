package Domain;

/**
 * @author SiletFlower
 * @date 2020/11/15 21:26:41
 * @description
 */
public class User {
    private Integer u_id;
    private String user_name;
    private String password;
    private Boolean admin = false;
    private String token;
    private Boolean remember = false;

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                ", token='" + token + '\'' +
                ", remember=" + remember +
                '}';
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getRemember() {
        return remember;
    }

    public void setRemember(Boolean remember) {
        this.remember = remember;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (user_name != null ? !user_name.equals(user.user_name) : user.user_name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return admin != null ? admin.equals(user.admin) : user.admin == null;
    }

    @Override
    public int hashCode() {
        int result = user_name != null ? user_name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (admin != null ? admin.hashCode() : 0);
        return result;
    }
}
