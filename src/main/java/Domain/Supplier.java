package Domain;

/**
 * @author SiletFlower
 * @date 2020/11/22 14:30:41
 * @description
 */
public class Supplier {
    private Integer s_id;
    private String supplier_name;
    private String supplier_desc;
    private String supplier_addr;
    private String supplier_email;
    private String supplier_contact;
    private String supplier_bankcard;

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getSupplier_desc() {
        return supplier_desc;
    }

    public void setSupplier_desc(String supplier_desc) {
        this.supplier_desc = supplier_desc;
    }

    public String getSupplier_addr() {
        return supplier_addr;
    }

    public void setSupplier_addr(String supplier_addr) {
        this.supplier_addr = supplier_addr;
    }

    public String getSupplier_email() {
        return supplier_email;
    }

    public void setSupplier_email(String supplier_email) {
        this.supplier_email = supplier_email;
    }

    public String getSupplier_contact() {
        return supplier_contact;
    }

    public void setSupplier_contact(String supplier_contact) {
        this.supplier_contact = supplier_contact;
    }

    public String getSupplier_bankcard() {
        return supplier_bankcard;
    }

    public void setSupplier_bankcard(String supplier_bankcard) {
        this.supplier_bankcard = supplier_bankcard;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "s_id=" + s_id +
                ", supplier_name='" + supplier_name + '\'' +
                ", supplier_desc='" + supplier_desc + '\'' +
                ", supplier_addr='" + supplier_addr + '\'' +
                ", supplier_email='" + supplier_email + '\'' +
                ", supplier_contact='" + supplier_contact + '\'' +
                ", supplier_bankcard='" + supplier_bankcard + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Supplier supplier = (Supplier) o;

        if (s_id != null ? !s_id.equals(supplier.s_id) : supplier.s_id != null) return false;
        if (supplier_name != null ? !supplier_name.equals(supplier.supplier_name) : supplier.supplier_name != null)
            return false;
        if (supplier_desc != null ? !supplier_desc.equals(supplier.supplier_desc) : supplier.supplier_desc != null)
            return false;
        if (supplier_addr != null ? !supplier_addr.equals(supplier.supplier_addr) : supplier.supplier_addr != null)
            return false;
        if (supplier_email != null ? !supplier_email.equals(supplier.supplier_email) : supplier.supplier_email != null)
            return false;
        if (supplier_contact != null ? !supplier_contact.equals(supplier.supplier_contact) : supplier.supplier_contact != null)
            return false;
        return supplier_bankcard != null ? supplier_bankcard.equals(supplier.supplier_bankcard) : supplier.supplier_bankcard == null;
    }

    @Override
    public int hashCode() {
        int result = s_id != null ? s_id.hashCode() : 0;
        result = 31 * result + (supplier_name != null ? supplier_name.hashCode() : 0);
        result = 31 * result + (supplier_desc != null ? supplier_desc.hashCode() : 0);
        result = 31 * result + (supplier_addr != null ? supplier_addr.hashCode() : 0);
        result = 31 * result + (supplier_email != null ? supplier_email.hashCode() : 0);
        result = 31 * result + (supplier_contact != null ? supplier_contact.hashCode() : 0);
        result = 31 * result + (supplier_bankcard != null ? supplier_bankcard.hashCode() : 0);
        return result;
    }
}
