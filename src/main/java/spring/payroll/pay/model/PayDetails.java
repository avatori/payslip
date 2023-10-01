package spring.payroll.pay.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PayDetails {
    // private Long id;
    // private Long companyId;
    private String name;

    // 0 - basic salary
    // 1 - taxable allowances
    // 2 - nontaxable allowances
    // 3 - deductions
    // 4 - bonuses
    private int type;

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return int return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

}
