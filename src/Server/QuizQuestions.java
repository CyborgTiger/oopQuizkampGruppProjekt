package Server;


import java.util.List;

    public class QuizQuestions {
        private List<QuizQuestion> quizQuestions;

        public QuizQuestions(List<QuizQuestion> quizQuestion) {
            this.quizQuestions = quizQuestion;
        }

        public List<QuizQuestion> getQuizQuestions() {
            return quizQuestions;
        }


    }