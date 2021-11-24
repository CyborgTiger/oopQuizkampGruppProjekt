package Client;

public class Match {
    private int p1Score;
    private int p2Score;
    private int round;

    public Match(){
        this.p1Score = 0;
        this.p2Score = 0;
        this.round = 0;
    }

    public void gainPoint(int player){
        if (player == 1){
            p1Score++;
        }
        if (player == 2){
            p2Score++;
        }
    }
    public void endRound(){
        round++;
    }

    public int getP1Score() {
        return p1Score;
    }

    public int getP2Score() {
        return p2Score;
    }

    public int getRound() {
        return round;
    }
}
