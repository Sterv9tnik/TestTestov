
package api.models.getUser;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Support {
    @JsonProperty()
    public String url;
    @JsonProperty()
    public String text;
}
