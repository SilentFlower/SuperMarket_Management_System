package Domain;

/**
 * @author SiletFlower
 * @date 2020/12/17 22:24:43
 * @description
 */
public class Performance {
    private Integer e_id;
    private Employee employee;
    private Double performance;
    private Integer amount;
    private String startSearchTime;
    private String endSearchTime;

    public String getStartSearchTime() {
        return startSearchTime;
    }

    public void setStartSearchTime(String startSearchTime) {
        this.startSearchTime = startSearchTime;
    }

    public String getEndSearchTime() {
        return endSearchTime;
    }

    public void setEndSearchTime(String endSearchTime) {
        this.endSearchTime = endSearchTime;
    }

    public Integer getE_id() {
        return e_id;
    }

    public void setE_id(Integer e_id) {
        this.e_id = e_id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Double getPerformance() {
        return performance;
    }

    public void setPerformance(Double performance) {
        this.performance = performance;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
