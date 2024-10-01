package integration.constants;

public enum RequestType {
    GET("get"),
    POST("post"),
    PUT("put"),
    DELETE("delete");

    private final String type;

    RequestType(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }
}
