/*
    David Novosardian
    2018
 */


package edu.project.Novosardian.David.Grade.Calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;


public class CalcUiController implements Initializable
{
    @FXML
    TextField txtParticipationActual;

    @FXML
    TextField txtParticipationTotal;

    @FXML
    TextField txtParticipationWeight;

    @FXML
    TextField txtQuizActual;

    @FXML
    TextField txtQuizTotal;

    @FXML
    TextField txtQuizWeight;

    @FXML
    TextField txtAssignmentsActual;

    @FXML
    TextField txtAssignmentsTotal;

    @FXML
    TextField txtAssignmentsWeight;

    @FXML
    TextField txtFinalActual;

    @FXML
    TextField txtFinalTotal;

    @FXML
    TextField txtFinalWeight;

    @FXML
    TextField txtPresentationActual;

    @FXML
    TextField txtPresentationTotal;

    @FXML
    TextField txtPresentationWeight;

    @FXML
    TextField txtTotalPoints;

    @FXML
    TextField txtLetterGrade;

    private int validateTextField (TextField temp)
    {
        int num = Integer.MAX_VALUE;
        try
        {
            num = Integer.parseInt(temp.getText());
        }
        catch (Exception ex)
        {
            Dialog dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setContentText("please enter only numeric values");
            //temp.requestFocus();

           // dlg.show();

        }

        return num;
    }



    @FXML
    private void btnClick (ActionEvent e)
    {
        Button calcButton = (Button)e.getSource();

        int partTotal = validateTextField(txtParticipationTotal);
        int partActual = validateTextField(txtParticipationActual);
        int partWeight = validateTextField(txtParticipationWeight);

        int quizTotal = validateTextField(txtQuizTotal);
        int quizActual = validateTextField(txtQuizActual);
        int quizWeight = validateTextField(txtQuizWeight);

        int progAssnTotal = validateTextField(txtAssignmentsTotal);
        int progAssnActual = validateTextField(txtAssignmentsActual);
        int progAssnWeight = validateTextField(txtAssignmentsWeight);

        int finalProjectTotal = validateTextField(txtFinalTotal);
        int finalProjectActual = validateTextField(txtFinalActual);
        int finalProjectWeight = validateTextField(txtFinalWeight);

        int finalPresTotal = validateTextField(txtFinalTotal);
        int finalPresActual = validateTextField(txtFinalActual);
        int finalPresWeight = validateTextField(txtFinalWeight);

        int otalPoints = partTotal + quizTotal + progAssnTotal
                          + finalProjectTotal +finalPresTotal;

        int totalActualPoints= partActual+ quizActual + progAssnActual
                                + finalProjectActual + finalPresActual;

        if( calcButton.getId().equals("btnCalcGrade"))
        {
            double totalScore = 0;

            totalScore += calculate(partActual, partTotal, partWeight);

            totalScore += calculate(quizActual, quizTotal, quizWeight);

            totalScore += calculate(progAssnActual, progAssnTotal, progAssnWeight);

            totalScore += calculate(finalProjectActual, finalProjectTotal, finalProjectWeight);

            totalScore += calculate(finalPresActual, finalPresTotal, finalPresWeight);
            // txtTotalPoints.setText(String.format("%s", participationTotal + quizTotal ))

            String finalGrade = "";

            if(totalScore >= 91 && totalScore <= 100)
            {
                finalGrade = "A";
            }
            else if (totalScore >= 81 && totalScore <= 90)
            {
                finalGrade = "B";
            }
            else if (totalScore >= 71 && totalScore <= 80)
            {
                finalGrade = "C";
            }
            else if (totalScore >= 61 && totalScore <= 70)
            {
                finalGrade = "D";
            }
            else if (totalScore < 60)
            {
                finalGrade = "F";
            }

            txtLetterGrade.setText(finalGrade);
            txtTotalPoints.setText(String.format("%s", totalActualPoints));
        }

    }

    private double calculate(double actual, double total, double weight)
    {
        double normalized = (actual / total ) * 100;
        double score = normalized * (weight / 100);

        return score;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

}
