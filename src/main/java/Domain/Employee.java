package Domain;

/**
 * @author SiletFlower
 * @date 2020/11/15 09:26:26
 * @description
 */
public class Employee {
    private Integer e_id;
    private String employee_name;
    private String employee_sex;
    private String employee_addr;
    private String employee_tel;
    private String employee_email;
    private Integer u_id;
    private User user;

    public Integer getE_id() {
        return e_id;
    }

    public void setE_id(Integer e_id) {
        this.e_id = e_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_sex() {
        return employee_sex;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEmployee_sex(String employee_sex) {
        String sex = null;
        if("man".equals(employee_sex)){
            sex = "男";
        }else if("woman".equals(employee_sex)) {
            sex = "女";
        }else {
            sex = employee_sex;
        }
        this.employee_sex = sex;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "e_id=" + e_id +
                ", employee_name='" + employee_name + '\'' +
                ", employee_sex='" + employee_sex + '\'' +
                ", employee_addr='" + employee_addr + '\'' +
                ", employee_tel='" + employee_tel + '\'' +
                ", employee_email='" + employee_email + '\'' +
                ", u_id=" + u_id +
                ", user=" + user +
                '}';
    }

    public String getEmployee_addr() {
        return employee_addr;
    }

    public void setEmployee_addr(String employee_addr) {
        this.employee_addr = employee_addr;
    }

    public String getEmployee_tel() {
        return employee_tel;
    }

    public void setEmployee_tel(String employee_tel) {
        this.employee_tel = employee_tel;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (employee_name != null ? !employee_name.equals(employee.employee_name) : employee.employee_name != null)
            return false;
        if (employee_sex != null ? !employee_sex.equals(employee.employee_sex) : employee.employee_sex != null)
            return false;
        if (employee_addr != null ? !employee_addr.equals(employee.employee_addr) : employee.employee_addr != null)
            return false;
        if (employee_tel != null ? !employee_tel.equals(employee.employee_tel) : employee.employee_tel != null)
            return false;
        return employee_email != null ? employee_email.equals(employee.employee_email) : employee.employee_email == null;
    }

    @Override
    public int hashCode() {
        int result = employee_name != null ? employee_name.hashCode() : 0;
        result = 31 * result + (employee_sex != null ? employee_sex.hashCode() : 0);
        result = 31 * result + (employee_addr != null ? employee_addr.hashCode() : 0);
        result = 31 * result + (employee_tel != null ? employee_tel.hashCode() : 0);
        result = 31 * result + (employee_email != null ? employee_email.hashCode() : 0);
        return result;
    }
}
