package RequestClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * QueryWalletTransferBySourceAgentId
 */
@Validated

public class QueryWalletTransferBySourceAgentId   {

    @JsonProperty("sourceAgentId")
    private String sourceAgentId = null;

    public String getSourceAgentId() {
        return sourceAgentId;
    }

    public void setSourceAgentId(String sourceAgentId) {
        this.sourceAgentId = sourceAgentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        QueryWalletTransferBySourceAgentId queryWalletTransferBySourceAgentId    = (QueryWalletTransferBySourceAgentId) o;
        return Objects.equals(this.sourceAgentId, queryWalletTransferBySourceAgentId.sourceAgentId) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceAgentId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class QueryWalletTransferBySourceAgentId {\n");

        sb.append("    transactionId: ").append(toIndentedString(sourceAgentId)).append("\n");
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