import static spark.Spark.get;

public class PingPongGame {
    public static void main(String[] args) {
        get("/ping", (req, res) -> "pong!");
    }
}