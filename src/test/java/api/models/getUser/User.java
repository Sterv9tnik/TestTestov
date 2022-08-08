
package api.models.getUser;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @JsonProperty()
    private Data data;
    @JsonProperty()
    private Support support;

    public Data getData() {
        return data;
    }
}
