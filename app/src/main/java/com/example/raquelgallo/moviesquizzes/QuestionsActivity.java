package com.example.raquelgallo.moviesquizzes;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Raquel Gallo on 04/01/2018.
 */

public class QuestionsActivity extends AppCompatActivity {

    private List<Question> listQuestions = new ArrayList<>();
    private List<Integer> rightAnswer = new ArrayList<>();
    private Question question;
    private float score;
    private int totalOfQuestions;

    RadioButton radioBtnAnswer;

    @BindView(R.id.constraint_layout)
    public ConstraintLayout constraintLayout;

    @BindView(R.id.text_question)
    public TextView txtQuestion;

    @BindView(R.id.radio_group_answers)
    public RadioGroup answerRadioGroup;

    @BindView(R.id.radio_answer_1)
    public RadioButton radioBtnOne;

    @BindView(R.id.radio_answer_2)
    public RadioButton radioBtnTwo;

    @BindView(R.id.radio_answer_3)
    public RadioButton radioBtnThree;

    @BindView(R.id.radio_answer_4)
    public RadioButton radioBtnFour;

    @BindView(R.id.radio_answer_5)
    public RadioButton radioBtnFive;

    @BindView(R.id.check_answer_1)
    public CheckBox checkBoxOne;

    @BindView(R.id.check_answer_2)
    public CheckBox checkBoxTwo;

    @BindView(R.id.check_answer_3)
    public CheckBox checkBoxThree;

    @BindView(R.id.check_answer_4)
    public CheckBox checkBoxFour;

    @BindView(R.id.check_answer_5)
    public CheckBox checkBoxFive;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        ButterKnife.bind(this);

        if (savedInstanceState != null) {
            score = savedInstanceState.getFloat("score");
            totalOfQuestions = savedInstanceState.getInt("totalOfQuestions");
            listQuestions = (ArrayList<Question>) savedInstanceState.getSerializable("listQuestions");
            rightAnswer = savedInstanceState.getIntegerArrayList("rightAnswers");
        } else
            addQuestions();

        loadQuestion();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        listQuestions.add(0, question);
        outState.putFloat("score", score);
        outState.putInt("totalOfQuestion", totalOfQuestions);
        outState.putParcelableArrayList("listQuestions", (ArrayList<? extends Parcelable>) listQuestions);
        outState.putIntegerArrayList("rightAnswers", (ArrayList<Integer>) rightAnswer);
    }

    private void addQuestions() {
        createFirstQuestion();
        createSecondQuestion();
        createThirdQuestion();
        createFourthQuestion();
        createFifthQuestion();
        createSixthQuestion();
        createSeventhQuestion();
        createEighthQuestion();

        totalOfQuestions = listQuestions.size();
    }

    private void createFirstQuestion() {
        List<Integer> firstQuestion = new ArrayList<>();
        firstQuestion.add(R.id.check_answer_1);
        firstQuestion.add(R.id.check_answer_3);
        firstQuestion.add(R.id.check_answer_5);

        listQuestions.add(new Question(getResources().getString(R.string.first_question),
                firstQuestion, getResources().getString(R.string.checkbox),
                getResources().getString(R.string.first_answer_question_1),
                getResources().getString(R.string.second_answer_question_1),
                getResources().getString(R.string.third_answer_question_1),
                getResources().getString(R.string.fourth_answer_question_1),
                getResources().getString(R.string.fifth_answer_question_1)));
    }

    private void createSecondQuestion() {
        List<Integer> secondQuestion = new ArrayList<>();
        secondQuestion.add(R.id.radio_answer_2);

        listQuestions.add(new Question(getResources().getString(R.string.second_question),
                secondQuestion, getResources().getString(R.string.radioButton),
                getResources().getString(R.string.first_answer_question_2),
                getResources().getString(R.string.second_answer_question_2),
                getResources().getString(R.string.third_answer_question_2),
                getResources().getString(R.string.fourth_answer_question_2),
                getResources().getString(R.string.fifth_answer_question_2)));
    }

    private void createThirdQuestion() {
        List<Integer> thirdQuestion = new ArrayList<>();
        thirdQuestion.add(R.id.radio_answer_2);
        listQuestions.add(new Question(getResources().getString(R.string.third_question),
                thirdQuestion, getResources().getString(R.string.radioButton),
                getResources().getString(R.string.first_answer_question_3),
                getResources().getString(R.string.second_answer_question_3),
                getResources().getString(R.string.third_answer_question_3),
                getResources().getString(R.string.fourth_answer_question_3),
                getResources().getString(R.string.fifth_answer_question_3)));

    }

    private void createFourthQuestion() {
        List<Integer> fourthQuestion = new ArrayList<>();
        fourthQuestion.add(R.id.radio_answer_1);
        listQuestions.add(new Question(getResources().getString(R.string.fourth_question),
                fourthQuestion, getResources().getString(R.string.radioButton),
                getResources().getString(R.string.first_answer_question_4),
                getResources().getString(R.string.second_answer_question_4),
                getResources().getString(R.string.third_answer_question_4),
                getResources().getString(R.string.fourth_answer_question_4),
                getResources().getString(R.string.fifth_answer_question_4)));
    }

    private void createFifthQuestion() {
        List<Integer> fifthQuestion = new ArrayList<>();
        fifthQuestion.add(R.id.radio_answer_5);
        listQuestions.add(new Question(getResources().getString(R.string.fifth_question),
                fifthQuestion, getResources().getString(R.string.radioButton),
                getResources().getString(R.string.first_answer_question_5),
                getResources().getString(R.string.second_answer_question_5),
                getResources().getString(R.string.third_answer_question_5),
                getResources().getString(R.string.fourth_answer_question_5),
                getResources().getString(R.string.fifth_answer_question_5)));

    }

    private void createSixthQuestion() {
        List<Integer> sixthQuestion = new ArrayList<>();
        sixthQuestion.add(R.id.check_answer_1);
        sixthQuestion.add(R.id.check_answer_2);
        sixthQuestion.add(R.id.check_answer_3);
        sixthQuestion.add(R.id.check_answer_4);
        sixthQuestion.add(R.id.check_answer_5);

        listQuestions.add(new Question(getResources().getString(R.string.sixth_question),
                sixthQuestion, getResources().getString(R.string.checkbox),
                getResources().getString(R.string.first_answer_question_6),
                getResources().getString(R.string.second_answer_question_6),
                getResources().getString(R.string.third_answer_question_6),
                getResources().getString(R.string.fourth_answer_question_6),
                getResources().getString(R.string.fifth_answer_question_6)));

    }

    private void createSeventhQuestion() {
        List<Integer> seventhQuestion = new ArrayList<>();
        seventhQuestion.add(R.id.radio_answer_3);
        listQuestions.add(new Question(getResources().getString(R.string.seventh_question),
                seventhQuestion, getResources().getString(R.string.radioButton),
                getResources().getString(R.string.first_answer_question_7),
                getResources().getString(R.string.second_answer_question_7),
                getResources().getString(R.string.third_answer_question_7),
                getResources().getString(R.string.fourth_answer_question_7),
                getResources().getString(R.string.fifth_answer_question_7)));
    }

    private void createEighthQuestion() {
        List<Integer> eighthQuestion = new ArrayList<>();
        eighthQuestion.add(R.id.radio_answer_3);
        listQuestions.add(new Question(getResources().getString(R.string.eighth_question),

                eighthQuestion, getResources().getString(R.string.radioButton),
                getResources().getString(R.string.first_answer_question_8),
                getResources().getString(R.string.second_answer_question_8),
                getResources().getString(R.string.third_answer_question_8),
                getResources().getString(R.string.fourth_answer_question_8),
                getResources().getString(R.string.fifth_answer_question_8)));
    }


    private void loadQuestion() {
        if (listQuestions.size() != 0) {
            question = listQuestions.remove(0);
            txtQuestion.setText(question.getQuestion());
            List<String> answer = question.getListAnswers();

            if (question.getQuestionType().equals(getResources().getString(R.string.checkbox))) {
                checkBoxOne.setText(answer.get(0));
                checkBoxTwo.setText(answer.get(1));
                checkBoxThree.setText(answer.get(2));
                checkBoxFour.setText(answer.get(3));
                checkBoxFive.setText(answer.get(4));

                answerRadioGroup.setVisibility(View.GONE);
                checkBoxOne.setVisibility(View.VISIBLE);
                checkBoxTwo.setVisibility(View.VISIBLE);
                checkBoxThree.setVisibility(View.VISIBLE);
                checkBoxFour.setVisibility(View.VISIBLE);
                checkBoxFive.setVisibility(View.VISIBLE);

            } else {
                radioBtnOne.setText(answer.get(0));
                radioBtnTwo.setText(answer.get(1));
                radioBtnThree.setText(answer.get(2));
                radioBtnFour.setText(answer.get(3));
                radioBtnFive.setText(answer.get(4));

                answerRadioGroup.setVisibility(View.VISIBLE);
                checkBoxOne.setVisibility(View.GONE);
                checkBoxTwo.setVisibility(View.GONE);
                checkBoxThree.setVisibility(View.GONE);
                checkBoxFour.setVisibility(View.GONE);
                checkBoxFive.setVisibility(View.GONE);

            }
            rightAnswer = question.getRightAnswers();

        } else {
            Intent intent = new Intent(this, ScoreActivity.class);
            intent.putExtra("score", score);
            intent.putExtra("totalOfQuestions", totalOfQuestions);
            startActivity(intent);
        }
    }

    @OnClick(R.id.answer_btn)
    public void onClickAnswerButton() {
        boolean isNotNull = verifyAnswer();
        if (isNotNull)
            loadQuestion();
        else {
            final Snackbar snackbar = Snackbar.make(constraintLayout, "Precisa escolher uma das opções acima!", Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction("CLOSE", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    snackbar.dismiss();
                }
            });
            snackbar.show();
        }
    }

    private boolean verifyAnswer() {
        boolean hasAnswer = false;
        String questionType = question.getQuestionType();
        radioBtnAnswer = findViewById(answerRadioGroup.getCheckedRadioButtonId());
        int checkedAnswer = answerRadioGroup.getCheckedRadioButtonId();

        if (questionType.equals(getResources().getString(R.string.radioButton))) {
            if (radioBtnAnswer != null) {
                hasAnswer = true;
                if (checkedAnswer == rightAnswer.get(0)) {
                    score += 1;
                    if (score == 1)
                        Toast.makeText(this, getResources().getString(R.string.right_answer) + " " +
                                score + " " + getResources().getString(R.string.point), Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(this, getResources().getString(R.string.right_answer) + " " +
                                score + " " + getResources().getString(R.string.points), Toast.LENGTH_LONG).show();


                } else {
                    score += 0;
                    if (score == 1)
                        Toast.makeText(this, getResources().getString(R.string.wrong_answer) + " " +
                                score + " " + getResources().getString(R.string.point), Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(this, getResources().getString(R.string.wrong_answer) + " " +
                                score + " " + getResources().getString(R.string.points), Toast.LENGTH_LONG).show();

                }
            }

        } else {
            final List<Boolean> chooseRightAnswers = new ArrayList<>();

            for (final int checkBox : rightAnswer) {

                if (checkBox == checkBoxOne.getId()) {
                    if (checkBoxOne.isChecked()) {
                        chooseRightAnswers.add(true);
                        hasAnswer = true;
                    }
                } else if (checkBox == checkBoxTwo.getId()) {
                    if (checkBoxTwo.isChecked()) {
                        chooseRightAnswers.add(true);
                        hasAnswer = true;
                    }
                } else if (checkBox == checkBoxThree.getId()) {
                    if (checkBoxThree.isChecked()) {
                        chooseRightAnswers.add(true);
                        hasAnswer = true;
                    }
                } else if (checkBox == checkBoxFour.getId()) {
                    if (checkBoxFour.isChecked()) {
                        chooseRightAnswers.add(true);
                        hasAnswer = true;
                    }
                } else if (checkBox == checkBoxFive.getId()) {
                    if (checkBoxFive.isChecked()) {
                        chooseRightAnswers.add(true);
                        hasAnswer = true;
                    }
                }
            }

            if (hasAnswer) {
                if (chooseRightAnswers.size() == rightAnswer.size()) {
                    score += 1;
                    Toast.makeText(this, getResources().getString(R.string.right_answer) + " " +
                            score + " " + getResources().getString(R.string.point), Toast.LENGTH_LONG).show();
                } else {
                    score += 0.5;
                    Toast.makeText(this, getResources().getString(R.string.almost_right_answer) + " " +
                            score + " " + getResources().getString(R.string.point), Toast.LENGTH_LONG).show();
                }
            }
        }
        deselectFields();

        return hasAnswer;
    }

    private void deselectFields() {
        checkBoxOne.setChecked(false);
        checkBoxTwo.setChecked(false);
        checkBoxThree.setChecked(false);
        checkBoxFour.setChecked(false);
        checkBoxFive.setChecked(false);
        if (radioBtnAnswer != null)
            radioBtnAnswer.setChecked(false);
        radioBtnOne.setChecked(false);
        radioBtnTwo.setChecked(false);
        radioBtnThree.setChecked(false);
        radioBtnFour.setChecked(false);
        radioBtnFive.setChecked(false);
    }
}