package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CloseOrderController {


    public Label labelTotalPrice;
    @FXML
    private static void initialize(){




    }

    public void onPayClick(ActionEvent actionEvent) {

        //MainController.orderSet.remove((Order)actionEvent.getTarget());

        closeDialog(actionEvent);

    }

    public void onCancelClick(ActionEvent actionEvent) {
        closeDialog(actionEvent);
    }
    private void closeDialog(ActionEvent actionEvent) {
        Node source=(Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }
}
