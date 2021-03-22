package RequestClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * WalletCreditRequest
 */
@Validated

public class WalletCreditRequest   {

    @JsonProperty("agentId")
    private String agentId = null;

    @JsonProperty("amount")
    private String amount = null;

    @JsonProperty("sourceType")
    private String sourceType = null;

    @JsonProperty("transactionId")
    private String transactionId = null;

    @JsonProperty("walletId")
    private String walletId = null;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WalletCreditRequest walletCreditRequest  = (WalletCreditRequest) o;
        return Objects.equals(this.agentId, walletCreditRequest.agentId) &&
                Objects.equals(this.amount, walletCreditRequest.amount) &&
                Objects.equals(this.sourceType, walletCreditRequest.sourceType) &&
                Objects.equals(this.transactionId, walletCreditRequest.transactionId) &&
                Objects.equals(this.walletId, walletCreditRequest.walletId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agentId,  amount, sourceType, transactionId, walletId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WalletCreditRequest {\n");

        sb.append("    agentId: ").append(toIndentedString(agentId)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    sourceType: ").append(toIndentedString(sourceType)).append("\n");
        sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
        sb.append("    walletId: ").append(toIndentedString(walletId)).append("\n");
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