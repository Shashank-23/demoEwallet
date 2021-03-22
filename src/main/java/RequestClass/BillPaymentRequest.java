package RequestClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;


/**
 * BillPaymentRequest
 */
@Validated

public class BillPaymentRequest   {

    @JsonProperty("agentId")
    private String agentId = null;

    @JsonProperty("amount")
    private String amount = null;

    @JsonProperty("billId")
    private String billId = null;

    @JsonProperty("consumerAccountId")
    private String consumerAccountId = null;

    @JsonProperty("consumerName")
    private String consumerName = null;

    @JsonProperty("discom")
    private String discom = null;

    @JsonProperty("division")
    private String division = null;

    @JsonProperty("divisionCode")
    private String divisionCode = null;

    @JsonProperty("mobile")
    private String mobile = null;

    @JsonProperty("referenceTransactionId")
    private String referenceTransactionId = null;

    @JsonProperty("sourceType")
    private String sourceType = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("vanNo")
    private String vanNo = null;

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

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getConsumerAccountId() {
        return consumerAccountId;
    }

    public void setConsumerAccountId(String consumerAccountId) {
        this.consumerAccountId = consumerAccountId;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getDiscom() {
        return discom;
    }

    public void setDiscom(String discom) {
        this.discom = discom;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(String divisionCode) {
        this.divisionCode = divisionCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getReferenceTransactionId() {
        return referenceTransactionId;
    }

    public void setReferenceTransactionId(String referenceTransactionId) {
        this.referenceTransactionId = referenceTransactionId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVanNo() {
        return vanNo;
    }

    public void setVanNo(String vanNo) {
        this.vanNo = vanNo;
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
        BillPaymentRequest billPaymentRequest   = (BillPaymentRequest) o;
        return Objects.equals(this.agentId, billPaymentRequest.agentId) &&
                Objects.equals(this.amount, billPaymentRequest.amount) &&
                Objects.equals(this.billId, billPaymentRequest.billId) &&
                Objects.equals(this.consumerAccountId, billPaymentRequest.consumerAccountId) &&
                Objects.equals(this.consumerName, billPaymentRequest.consumerName)&&
                Objects.equals(this.discom, billPaymentRequest.discom)&&
                Objects.equals(this.division, billPaymentRequest.division)&&
                Objects.equals(this.divisionCode, billPaymentRequest.divisionCode)&&
                Objects.equals(this.mobile, billPaymentRequest.mobile)&&
                Objects.equals(this.referenceTransactionId, billPaymentRequest.referenceTransactionId)&&
                Objects.equals(this.sourceType, billPaymentRequest.sourceType)&&
                Objects.equals(this.type, billPaymentRequest.type)&&
                Objects.equals(this.vanNo, billPaymentRequest.vanNo)&&
                Objects.equals(this.walletId, billPaymentRequest.walletId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agentId,  amount, billId, consumerAccountId, consumerName, discom,division,
                divisionCode,mobile,referenceTransactionId,sourceType,type,vanNo,walletId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BillPaymentRequest {\n");

        sb.append("    agentId: ").append(toIndentedString(agentId)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    billId: ").append(toIndentedString(billId)).append("\n");
        sb.append("    consumerAccountId: ").append(toIndentedString(consumerAccountId)).append("\n");
        sb.append("    consumerName: ").append(toIndentedString(consumerName)).append("\n");
        sb.append("    discom: ").append(toIndentedString(discom)).append("\n");
        sb.append("    division: ").append(toIndentedString(division)).append("\n");
        sb.append("    divisionCode: ").append(toIndentedString(divisionCode)).append("\n");
        sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
        sb.append("    referenceTransactionId: ").append(toIndentedString(referenceTransactionId)).append("\n");
        sb.append("    sourceType: ").append(toIndentedString(sourceType)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    vanNo: ").append(toIndentedString(vanNo)).append("\n");
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