package RequestClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * WalletTransferRequest
 */
@Validated

public class WalletTransferRequest   {

    @JsonProperty("amount")
    private String amount = null;

    @JsonProperty("destinationAgentId")
    private String destinationAgentId = null;

    @JsonProperty("sourceAgentId")
    private String sourceAgentId = null;

    @JsonProperty("sourceType")
    private String sourceType = null;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDestinationAgentId() {
        return destinationAgentId;
    }

    public void setDestinationAgentId(String destinationAgentId) {
        this.destinationAgentId = destinationAgentId;
    }

    public String getSourceAgentId() {
        return sourceAgentId;
    }

    public void setSourceAgentId(String sourceAgentId) {
        this.sourceAgentId = sourceAgentId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WalletTransferRequest walletTransferRequest   = (WalletTransferRequest) o;
        return Objects.equals(this.amount, walletTransferRequest.amount) &&
                Objects.equals(this.destinationAgentId, walletTransferRequest.destinationAgentId) &&
                Objects.equals(this.sourceAgentId, walletTransferRequest.sourceAgentId) &&
                Objects.equals(this.sourceType, walletTransferRequest.sourceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash( amount,destinationAgentId,sourceAgentId, sourceType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WalletTransferRequest {\n");

        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    destinationAgentId: ").append(toIndentedString(destinationAgentId)).append("\n");
        sb.append("    sourceAgentId: ").append(toIndentedString(sourceAgentId)).append("\n");
        sb.append("    sourceType: ").append(toIndentedString(sourceType)).append("\n");

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