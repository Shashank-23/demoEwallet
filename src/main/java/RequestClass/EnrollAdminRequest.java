package RequestClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * SignupUserRequest
 */
@Validated

public class EnrollAdminRequest   {
    @JsonProperty("username")
    private String username = null;

    @JsonProperty("password")
    private String password = null;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnrollAdminRequest enrollAdminRequest = (EnrollAdminRequest) o;
        return Objects.equals(this.username, enrollAdminRequest.username) &&
                Objects.equals(this.password, enrollAdminRequest.password) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username,  password);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnrollAdminRequest {\n");

        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
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