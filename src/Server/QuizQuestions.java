package Server;

import java.util.ArrayList;
import java.util.List;

    public class QuizQuestions {
        private List<QuizQuestion> quizQuestions;

        public QuizQuestions() {
            this.quizQuestions = addQuizQuestions();
        }

        public List<QuizQuestion> getQuizQuestions() {
//            public List<QuizQuestion> getQuizQuestions(Catagory cat)agory {
//                return quizQuestions.stream().filter(quizQuestion -> quizQuestion.getCatagory == cat);
            return quizQuestions;
        }



        private List<QuizQuestion> addQuizQuestions() {
            List<QuizQuestion> quizQuestions = new ArrayList<>();

            String question = "What is the origin of the Olympic Games?";
            String[] answers1 = {"Scandinavia", "Greece", "China", "Egypt"};
            QuizQuestion quizQuestion = new QuizQuestion(question, 1, answers1);
            quizQuestions.add(quizQuestion);

            question = "what's the capital of maldives?";
            String[] answers2 = {"Malé", "Bali", "jakarta", "Abu Dhabi"};
            quizQuestion = new QuizQuestion(question, 0, answers2);
            quizQuestions.add(quizQuestion);

            // Add the remainder of the questions and answers here

            return quizQuestions;
        }
    }