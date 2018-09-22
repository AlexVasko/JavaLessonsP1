package com.javalesson.nestedclasses;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    private static CellPhone phone;

    public static void main(String[] args) {

        phone = new CellPhone("Motorola", "XT1575", 400.0f);
        phone.turnOn();

        launch(args);
//       Display.Pixel pixel = phone.getDisplay().new Pixel(12345,234,"red");

//        Display.Pixel pixel = new Display.Pixel(123,456, "GREEN");
//        phone.call("1234567870");


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("CellPhone");
        Button btn = new Button();
        btn.setText("Call");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                phone.call("1234567890");
            }
        });

        StackPane rootPane = new StackPane();
        rootPane.getChildren().add(btn);
        primaryStage.setScene(new Scene(rootPane, 200, 400));
        primaryStage.show();
    }
}
