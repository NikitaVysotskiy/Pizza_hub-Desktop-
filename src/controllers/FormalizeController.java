package controllers;


import entities.Item;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class FormalizeController {
    public ListView listViewOrder;
    public Label labelSum;
    Integer totalPrice;
    @FXML
    private  void initialize(){
        ObservableList<Item> temp=MainController.getTempOrder();
        listViewOrder.setItems(temp);
        totalPrice=0;
        for(Item i : temp){
            totalPrice+=i.getPrice();
        }
        labelSum.setText("Сумма: "+totalPrice+" грн.");


    }



    public void onFormalizeClick(ActionEvent actionEvent) {

        MainController.saveOrder(totalPrice);

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
