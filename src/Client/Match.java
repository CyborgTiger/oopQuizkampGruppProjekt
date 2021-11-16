package Client;

public class Match {
    private int p1Score;
    private int p2Score;
    private int round;
    //private Question question;

    public Match(int p1Score, int p2Score){
        this.p1Score = p1Score;
        this.p2Score = p2Score;
        this.round = 0;
    }

    public void endOfRound(int player){
        if (player == 1){
            p1Score++;
        }
        if (player == 2){
            p2Score++;
        }
        round++;
    }
}
