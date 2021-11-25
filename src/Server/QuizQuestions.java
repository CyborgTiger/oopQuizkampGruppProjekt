package Server;


import java.io.Serializable;
import java.util.List;

    public class QuizQuestions implements Serializable {
        private List<QuizQuestion> quizQuestions;

        public QuizQuestions(List<QuizQuestion> quizQuestion) {
            this.quizQuestions = quizQuestion;
        }

        public List<QuizQuestion> getQuizQuestions() {
            return quizQuestions;
        }


    }