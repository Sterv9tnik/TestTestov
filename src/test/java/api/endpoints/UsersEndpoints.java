package api.endpoints;

public enum UsersEndpoints {
    USER("/users/%s"),
    USERS("/users");

    private String url;

    UsersEndpoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
