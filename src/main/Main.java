package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/main.fxml"));
        primaryStage.setTitle("Pizza_Hub");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.setMinWidth(850);
        primaryStage.setMinHeight(550);
        primaryStage.show();
    }


    public static void main(String[] args) throws SQLException {
        launch(args);
        //  SessionFactory sessionFactory= HibernateUtil.getSessionFactory();

        /*ItemDAO itemDAO = new ItemDAO();
        Item item = itemDAO.getItemById(1);
        System.out.println("Item: "+item);

        List items = itemDAO.getItemsByCategory();

        System.out.println("-------------ITEMS-----------");
        System.out.println(items);*/





    }
}
