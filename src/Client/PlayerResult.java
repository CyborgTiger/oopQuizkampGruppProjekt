package Client;

public class PlayerResult {
    private final String name;
    private final boolean result;

    public PlayerResult(String name, boolean result){
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public boolean isResult() {
        return result;
    }
}
