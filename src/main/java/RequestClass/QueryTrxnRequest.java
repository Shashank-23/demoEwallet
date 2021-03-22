package RequestClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * QueryWalletCreditByTrxnIdRequest
 */
@Validated

public class QueryTrxnRequest {

    @JsonProperty("UID")
    private String UID = null;

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        QueryTrxnRequest queryWalletCreditByTrxnIdRequest   = (QueryTrxnRequest) o;
        return Objects.equals(this.UID, queryWalletCreditByTrxnIdRequest.UID) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(UID);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class QueryWalletCreditByTrxnIdRequest {\n");

        sb.append("    transactionId: ").append(toIndentedString(UID)).append("\n");
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