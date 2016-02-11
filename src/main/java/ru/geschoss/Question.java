package ru.geschoss;

import java.util.ArrayList;
import java.util.Collections;


public class Question {
    private String question;
    private ArrayList<String> answerVersion = new ArrayList<String>();
    private int answer;

    public Question() {

    }

    public int getAnswer() {
        return answer;
    }

    public ArrayList<String> getAnswerVersion() {
        return answerVersion;
    }

    public String getQuestion() {
        return question;
    }


    public Question(String[] splitStr) {

        this.question = splitStr[0].trim();
        for (int i = 1; i < splitStr.length; i++) {
            answerVersion.add(splitStr[i].trim());

        }
        Collections.shuffle(answerVersion);
        this.answer = answerVersion.indexOf(splitStr[1].trim());
        this.answer++;
    }
}
