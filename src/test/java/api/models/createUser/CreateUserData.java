package api.models.createUser;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUserData {
    @JsonProperty()
    private String name;
    @JsonProperty()
    private String job;
    @JsonProperty()
    private String createdAt;
    @JsonProperty()
    private String id;

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public CreateUserData(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public CreateUserData() {}
}
