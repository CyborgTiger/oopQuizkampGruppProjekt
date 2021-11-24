package Server;

import java.util.ArrayList;

public class QuizCategories {
    private ArrayList<QuizQuestions> quizCategories;

    public QuizCategories(){
        this.quizCategories = addQuiz();
    }

    private ArrayList<QuizQuestions> addQuiz() {
        ArrayList<QuizQuestions> quizCategories = new ArrayList<>();

        QuizQuestion question1geo = new QuizQuestion("What is the country of origin of the Olympic Games?",1, "Scandinavia", "Greece", "China", "Egypt");
        QuizQuestion question2geo = new QuizQuestion("What is the capital of Maldives?",0, "Malé", "Bali", "Jakarta", "Abu Dhabi");
        ArrayList<QuizQuestion> geography = new ArrayList<>();
        geography.add(question1geo);
        geography.add(question2geo);
        quizCategories.add(new QuizQuestions(geography));

        QuizQuestion question1animals = new QuizQuestion("Where are tigers originally from?",2, "Africa", "South America", "Asia", "Europe");
        QuizQuestion question2animals = new QuizQuestion("Where can you find emperor penguins?",3, "Arctic", "Australia", "Greenland", "Antarctica");
        ArrayList<QuizQuestion> animals = new ArrayList<>();
        geography.add(question1animals);
        geography.add(question2animals);
        quizCategories.add(new QuizQuestions(animals));


        return quizCategories;
    }

    public ArrayList<QuizQuestions> getQuizCategories() {
        return quizCategories;
    }
}
