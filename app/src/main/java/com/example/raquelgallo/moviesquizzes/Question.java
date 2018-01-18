package com.example.raquelgallo.moviesquizzes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raquel Gallo on 05/01/2018.
 */

public class Question implements Parcelable {

    private String question;
    private List<String> listAnswers = new ArrayList<>();
    private List<Integer> rightAnswers = new ArrayList<>();
    private String questionType;

    public Question(String question, List<Integer> rightAnswer, String questionType, String... listAnswers) {
        this.question = question;
        this.listAnswers.add(listAnswers[0]);
        this.listAnswers.add(listAnswers[1]);
        this.listAnswers.add(listAnswers[2]);
        this.listAnswers.add(listAnswers[3]);
        this.listAnswers.add(listAnswers[4]);
        this.rightAnswers = rightAnswer;
        this.questionType = questionType;
    }

    public Question(Parcel in) {

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getListAnswers() {
        return listAnswers;
    }

    public void setListAnswers(List<String> listAnswers) {
        this.listAnswers = listAnswers;
    }

    public List<Integer> getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(List<Integer> rightAnswers) {
        this.rightAnswers = rightAnswers;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public final Parcelable.Creator<Question> CREATOR = new Parcelable.Creator<Question>() {
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(question);
        parcel.writeArray(new List[]{listAnswers});
        parcel.writeArray(new List[]{rightAnswers});
        parcel.writeString(questionType);
    }
}
