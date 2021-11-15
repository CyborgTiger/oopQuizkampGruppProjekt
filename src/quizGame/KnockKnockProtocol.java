package quizGame;

public class KnockKnockProtocol {

        private static final int WAITING = 0;
        private static final int SENTGÅTA = 1;
        private static final int SENTCLUE = 2;
        private static final int ANOTHER = 3;

        private static final int NUMJOKES = 3;

        private int state = WAITING;
        private int currentgåta = 0;

        private String[] clues = { "Du slänger ut mig när du vill använda mig och tar tillbaka mig när du inte behöver mig. Vad är jag?",
                "Vad sa musen när han såg sin första fladdermus?", "Säg mitt namn så finns jag inte längre. Vem är jag?"};
        private String[] answers = { "Ankaret",
                "Åh, en ängel",
                "Tystnaden",
        };

        public String processInput(String theInput) {
            String theOutput = null;

            if (state == WAITING) {
                theOutput = "En gåta! En gåta!";
                state = SENTGÅTA;
            } else if (state == SENTGÅTA) {
                if (theInput.equalsIgnoreCase("Yes i can try")) {
                    theOutput = clues[currentgåta];
                    state = SENTCLUE;
                } else {
                    theOutput = "You're supposed to say \"Yes i can try\"! " +
                            "Try again. gåta! gåta!";
                }
            } else if (state == SENTCLUE) {
                if (theInput.equalsIgnoreCase(clues[currentgåta] + " what?")) {
                    theOutput = answers[currentgåta] + " Want another? (y/n)";
                    state = ANOTHER;
                } else {

                    theOutput = "The answer is right :\"" +
                            answers[currentgåta] +" En gåta! En gåta!";
                    currentgåta++;
                    state = SENTGÅTA;
                }
            } else if (state == ANOTHER) {
                if (theInput.equalsIgnoreCase("y")) {
                    theOutput = "gåta! gåta!";
                    if (currentgåta == (NUMJOKES - 1))
                        currentgåta = 0;
                    else
                        currentgåta++;
                    state = SENTGÅTA;
                } else {
                    theOutput = "Bye.";
                    state = WAITING;
                }
            }
            return theOutput;
        }
}
