package ResponseClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * CommitTrxnResponse
 */
@Validated
public class CommitTrxnResponse   {

    @JsonProperty("location")
    private String location = null;

    @JsonProperty("retry")
    private String retry = null;


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRetry() {
        return retry;
    }

    public void setRetry(String retry) {
        this.retry = retry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CommitTrxnResponse commitTrxnResponse   = (CommitTrxnResponse) o;
        return Objects.equals(this.location, commitTrxnResponse.location) &&
                Objects.equals(this.retry, commitTrxnResponse.retry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, retry);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CommitTrxnResponse {\n");

        sb.append("    Status: ").append(toIndentedString(location)).append("\n");
        sb.append("    message: ").append(toIndentedString(retry)).append("\n");
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