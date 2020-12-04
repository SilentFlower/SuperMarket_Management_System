package Domain;

import Util.DateUtil;

import java.text.ParseException;
import java.util.Date;

/**
 * @author SiletFlower
 * @date 2020/11/30 21:31:38
 * @description
 */
public class Supplier_bill {
    private Supplier supplier;
    private Double sb_all_amount;
    private Double sb_paid_amount;
    private Double sb_unPaid_amount;
    private Date sb_start;
    private Date sb_end;
    private String sb_start_string;
    private String sb_end_string;

    @Override
    public String toString() {
        return "Supplier_bill{" +
                "supplier=" + supplier +
                ", sb_all_amount=" + sb_all_amount +
                ", sb_paid_amount=" + sb_paid_amount +
                ", sb_unPaid_amount=" + sb_unPaid_amount +
                ", sb_start=" + sb_start +
                ", sb_end=" + sb_end +
                ", sb_start_string='" + sb_start_string + '\'' +
                ", sb_end_string='" + sb_end_string + '\'' +
                '}';
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Double getSb_all_amount() {
        return sb_all_amount;
    }

    public void setSb_all_amount(Double sb_all_amount) {
        this.sb_all_amount = sb_all_amount;
    }

    public Double getSb_paid_amount() {
        return sb_paid_amount;
    }

    public void setSb_paid_amount(Double sb_paid_amount) {
        this.sb_paid_amount = sb_paid_amount;
    }

    public Double getSb_unPaid_amount() {
        return sb_unPaid_amount;
    }

    public void setSb_unPaid_amount(Double sb_unPaid_amount) {
        this.sb_unPaid_amount = sb_unPaid_amount;
    }

    public Date getSb_start() {
        return sb_start;
    }

    public void setSb_start(Date sb_start) {
        this.sb_start = sb_start;
        if(sb_start != null){
            String dateString = DateUtil.getDateString(sb_start);
            this.sb_start_string = dateString;
        }
    }

    public Date getSb_end() {
        return sb_end;
    }

    public void setSb_end(Date sb_end) {
        this.sb_end = sb_end;
        if(sb_end != null){
            String dateString = DateUtil.getDateString(sb_end);
            this.sb_end_string = dateString;
        }
    }

    public String getSb_start_string() {
        return sb_start_string;
    }

    public void setSb_start_string(String sb_start_string) throws ParseException {
        this.sb_start_string = sb_start_string;
        if(sb_start_string != null){
            Date date = DateUtil.getDate(sb_start_string);
            this.sb_start = date;
        }
    }

    public String getSb_end_string() {
        return sb_end_string;
    }

    public void setSb_end_string(String sb_end_string) throws ParseException {
        this.sb_end_string = sb_end_string;
        if(sb_end_string != null){
            Date date = DateUtil.getDate(sb_end_string);
            this.sb_end = date;
        }
    }
}
