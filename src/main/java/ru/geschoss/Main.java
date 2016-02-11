package ru.geschoss;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static ArrayList<Question> arrayQuestion = new ArrayList<Question>();

    public static void main(String[] args)  {
        readFileAndCreateQuestions();
        showQuestions();
    }


    private static void readFileAndCreateQuestions(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("").getAbsolutePath() + "/test_questions.txt"));
            while (reader.ready()){
                String[] splitStr = reader.readLine().split("\\|");
                if (splitStr.length < 2){
                    System.out.println("В файле test_questions.txt, присутствует вопрос без ответа!");
                    continue;
                }
                arrayQuestion.add(new Question(splitStr));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл test_questions.txt, не найдет!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.shuffle(arrayQuestion);
    }

    private static void showQuestions(){
        int rightAnswers = 0;
        int allQuestion = arrayQuestion.size();
        for (Question question: arrayQuestion){
            System.out.println(question.getQuestion());
            int answerNumber = 1;
            for (String answer: question.getAnswerVersion()){
                System.out.println((answerNumber++) + ". " + answer);
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int userAnswer = 0;
            try {
                System.out.println("Введите номер правильного ответа:");
                userAnswer =  Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (userAnswer == question.getAnswer()){
                rightAnswers++;
            }
        }
        System.out.println(String.format("Вы правильно ответили на %s вопроса из %s(%.1f%%)", rightAnswers, allQuestion, (rightAnswers == 0 ? 0: (float) rightAnswers*100/ (float)allQuestion)));
    }
}
