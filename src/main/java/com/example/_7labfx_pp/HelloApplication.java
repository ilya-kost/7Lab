package com.example._7labfx_pp;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) {

        Game game = new Game();

        Label lbl = new Label();
        Label lbl1 = new Label("min");
        Label lbl2 = new Label("max");
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        RadioButton rbtn = new RadioButton("1");
        RadioButton rbtn1 = new RadioButton("2");
        textField1.setPrefColumnCount(11);
        textField2.setPrefColumnCount(11);

        Button btn = new Button("Начать");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lbl.setText("min: " + textField1.getText() + "\nmax: " + textField2.getText());
                game.setMin(Integer.parseInt(textField1.getText()));
                game.setMax(Integer.parseInt(textField2.getText()));
            }
        });
        Button btn1 = new Button("Угадать");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int v = game.guessNumber();
                game.setNumber(v);
                lbl.setText(String.valueOf(game.getNumber()));
            }
        });

        Button btn2 = new Button("Больше");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (game.getNumber() == game.getMax()) {
                    lbl.setText("Вне диапазона");
                }
                game.setMin(game.getNumber());
            }
        });

        Button btn3 = new Button("Меньше");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (game.getNumber() == game.getMin()) {
                    lbl.setText("Вне диапазона");
                }
                game.setMax(game.getNumber());
            }
        });

        Button btn4 = new Button("Перезапуск");

        ToggleGroup group = new ToggleGroup();
        rbtn.setToggleGroup(group);
        rbtn1.setToggleGroup(group);

        TilePane root = new TilePane(Orientation.HORIZONTAL, 10, 10,
                lbl1, textField1, btn, lbl2, textField2, btn1, btn2, btn3, btn4, rbtn, rbtn1, lbl);
        Scene scene = new Scene(root, 650, 350);
        scene.getStylesheets().add("stylesheet2.css");

        rbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scene.getStylesheets().add("stylesheet.css");
            }
        });
        rbtn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scene.getStylesheets().add("stylesheet1.css");
            }
        });


        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textField1.clear();
                textField2.clear();
                scene.getStylesheets().clear();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Game");
        primaryStage.show();
    }
}
