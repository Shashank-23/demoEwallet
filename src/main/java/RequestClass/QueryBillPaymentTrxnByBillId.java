package RequestClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * QueryBillPaymentTrxnByBillId
 */
@Validated

public class QueryBillPaymentTrxnByBillId   {

    @JsonProperty("billId")
    private String billId = null;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        QueryBillPaymentTrxnByBillId queryBillPaymentTrxnByBillId    = (QueryBillPaymentTrxnByBillId) o;
        return Objects.equals(this.billId, queryBillPaymentTrxnByBillId.billId) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(billId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class QueryBillPaymentTrxnByBillId {\n");

        sb.append("    billId: ").append(toIndentedString(billId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}