package controllers;

import DAO.ClientDAO;
import DAO.ItemDAO;
import entities.Client;
import entities.Item;
import entities.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MainController {

    public TableView tableOrder;
    public TableColumn columnName;
    public TableColumn columnCat;
    public TableColumn columnQuant;
    public TableColumn columnPrice;

    public Label labelQuantity;
    public Accordion accordionMenu;
    public Label timeLabel;


    public  ListView listViewOrderSet;

    static  Integer idOrder=0;
    public TextField txtFieldTelNum;
    public TextField txtFieldFIO;
    public ListView listViewAllClients;

    ObservableList<Item> pizzaXL= FXCollections.observableArrayList();
    ObservableList<Item> pizzaL= FXCollections.observableArrayList();
    ObservableList<Item> pizzaM= FXCollections.observableArrayList();
    ObservableList<Item> beer05= FXCollections.observableArrayList();
    ObservableList<Item> beer03= FXCollections.observableArrayList();

    static ObservableList<Item> tempOrder =FXCollections.observableArrayList();
    static ObservableList<Order> orderSet =FXCollections.observableArrayList();
    static ObservableList<Client> clientSet =FXCollections.observableArrayList();

    public ListView listViewPizzaXL;
    public ListView listViewPizzaL;
    public ListView listViewPizzaM;
    public ListView listViewBeer05;
    public ListView listViewBeer03;


    public void fillAccordion() throws SQLException {

        ItemDAO itemDAO = new ItemDAO();
        List itemsPizzaXL = itemDAO.getItemsByCategory("PizzaXL");
        pizzaXL.addAll(itemsPizzaXL);
        listViewPizzaXL.setItems(pizzaXL);

        List itemsPizzaL = itemDAO.getItemsByCategory("PizzaL");
        pizzaL.addAll(itemsPizzaL);
        listViewPizzaL.setItems(pizzaL);

        List itemsPizzaM = itemDAO.getItemsByCategory("PizzaM");
        pizzaM.addAll(itemsPizzaM);
        listViewPizzaM.setItems(pizzaM);

        List itemsBeer05= itemDAO.getItemsByCategory("Beer05");
        beer05.addAll(itemsBeer05);
        listViewBeer05.setItems(beer05);

        List itemsBeer03= itemDAO.getItemsByCategory("Beer03");
        beer03.addAll(itemsBeer03);
        listViewBeer03.setItems(beer03);

    }

    @FXML
    private void initialize() throws SQLException {
        //select name,price... from Item,Category where Item.id_category=Category.id_category,
        // category.name="pizzaXL" (to fill collections pizzaXL etc.)

        fillAccordion();
        initTableOrder();


        refreshViewAllClients();

    }

    private void initTableOrder(){

        columnName.setCellValueFactory(new PropertyValueFactory<Item,String>("name"));
        columnCat.setCellValueFactory(new PropertyValueFactory<Item,String>("category"));
        columnQuant.setCellValueFactory(new PropertyValueFactory<Item,String>("quantity"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<Item,String>("price"));

    }

    public void onItemSelected(Event event) {


        //bidlokod


        Item selectedItem1= (Item) listViewPizzaXL.getFocusModel().getFocusedItem();
        if (selectedItem1!=null) tempOrder.add(new Item(selectedItem1));

        Item selectedItem2= (Item) listViewPizzaL.getFocusModel().getFocusedItem();
        if (selectedItem2!=null) tempOrder.add(new Item(selectedItem2));

        Item selectedItem3= (Item) listViewPizzaM.getFocusModel().getFocusedItem();
        if (selectedItem3!=null) tempOrder.add(new Item(selectedItem3));

        Item selectedItem4= (Item) listViewBeer05.getFocusModel().getFocusedItem();
        if (selectedItem4!=null) tempOrder.add(new Item(selectedItem4));

        Item selectedItem5= (Item) listViewBeer03.getFocusModel().getFocusedItem();
        if (selectedItem5!=null) tempOrder.add(new Item(selectedItem5));



        refreshTableOrder();

        listViewPizzaXL.getSelectionModel().clearSelection();
        listViewPizzaL.getSelectionModel().clearSelection();
        listViewPizzaM.getSelectionModel().clearSelection();
        listViewBeer05.getSelectionModel().clearSelection();
        listViewBeer03.getSelectionModel().clearSelection();


    }

    private void refreshTableOrder() {
        tableOrder.setItems(tempOrder);
    }

    public void incQuantity(ActionEvent actionEvent) {

    }
    public  void  decQuantity(ActionEvent actionEvent){

    }

    public void clearTempOrder(ActionEvent actionEvent) {
        tempOrder.clear();
        refreshTableOrder();
    }


    public static ObservableList<Item> getTempOrder() {
        return tempOrder;
    }

    public void showDialog(ActionEvent actionEvent) throws IOException {

        Parent rooty = FXMLLoader.load(getClass().getResource("../fxml/formalize.fxml"));
        Stage formalizeDialogStage = new Stage();
        formalizeDialogStage.setResizable(false);
        formalizeDialogStage.setTitle("Оформление");
        formalizeDialogStage.setScene(new Scene(rooty));
        formalizeDialogStage.initModality(Modality.WINDOW_MODAL);
        formalizeDialogStage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
        formalizeDialogStage.showAndWait(); // для ожидания закрытия окна

    }

    public static void saveOrder(Integer totalPrice) {

        Order order=new Order(++idOrder,new Client(1,"",""),totalPrice,"");
        orderSet.add(order);

    }

     @FXML
     void refreshViewOrderSet(){
        listViewOrderSet.setItems(orderSet);
    }


    public void onOrderSelected(Event event) throws IOException{

        Parent rooty = FXMLLoader.load(getClass().getResource("../fxml/closeOrder.fxml"));
        Stage formalizeDialogStage = new Stage();
        formalizeDialogStage.setResizable(false);
        formalizeDialogStage.setTitle("Оформление");
        formalizeDialogStage.setScene(new Scene(rooty));
        formalizeDialogStage.initModality(Modality.WINDOW_MODAL);
        formalizeDialogStage.initOwner(((Node)event.getSource()).getScene().getWindow());
        formalizeDialogStage.showAndWait(); // для ожидания закрытия окна


    }

    public void saveClient(ActionEvent actionEvent) throws SQLException {
        Client tempClient=new Client();
        tempClient.setName(txtFieldFIO.getText());
        tempClient.setNumber(txtFieldTelNum.getText());
        ClientDAO clientDAO=new ClientDAO();
        clientDAO.saveClient(tempClient);
        refreshViewAllClients();



    }

    public void refreshViewAllClients() throws SQLException{
        clientSet.clear();
        List temp=ClientDAO.getAllClients();
        clientSet.addAll(temp);
        listViewAllClients.setItems(clientSet);
    }
}
