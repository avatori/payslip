package spring.payroll.pay.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Salary {

    private String companyId;
    private List<PayDetails> payDetails;

    /**
     * @return String return the companyId
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId the companyId to set
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * @return List<PayDetails> return the payDetails
     */
    public List<PayDetails> getPayDetails() {
        return payDetails;
    }

    /**
     * @param payDetails the payDetails to set
     */
    public void setPayDetails(List<PayDetails> payDetails) {
        this.payDetails = payDetails;
    }

}
