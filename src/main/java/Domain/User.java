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
    private Boolean isAdmin = false;

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

    public Boolean getIsAdmin() {
        return isAdmin;
    }


    public void setIsAdmin(Boolean admin) {
        this.isAdmin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (user_name != null ? !user_name.equals(user.user_name) : user.user_name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return isAdmin != null ? isAdmin.equals(user.isAdmin) : user.isAdmin == null;
    }

    @Override
    public int hashCode() {
        int result = user_name != null ? user_name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (isAdmin != null ? isAdmin.hashCode() : 0);
        return result;
    }
}
