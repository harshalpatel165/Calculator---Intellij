import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;
class Values{
    public double firstVal = 0;
    public double secondVal = 0;
    public double result = 0;
    public double sign = 0;
    public TextField textField = new TextField();
}

public class Main extends Application {

    //menubar
    MenuItem menuItem1 = new MenuItem("Main Screen");
    MenuItem menuItem2 = new MenuItem("Change Theme");
    MenuItem menuItem3 = new MenuItem("Exit");

    MenuButton menuButton = new MenuButton("Menu", null, menuItem1, menuItem2, menuItem3);

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }

    public Scene calcScreen(){
        Values values = new Values();

        BorderPane borderPane = new BorderPane();
        VBox calcVbox = new VBox();
        VBox menuVbox = new VBox();

        Label store = new Label();
        values.textField.setMaxWidth(240);

        Button button0 = new Button("0");
        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4");
        Button button5 = new Button("5");
        Button button6 = new Button("6");
        Button button7 = new Button("7");
        Button button8 = new Button("8");
        Button button9 = new Button("9");
        Button buttonClear = new Button("Clr");
        Button buttonEqual = new Button("=");
        Button buttonAdd = new Button("+");
        Button buttonMultiply = new Button("x");
        Button buttonDivide = new Button("/");
        Button buttonSubtract = new Button("-");
        Button buttonUndo = new Button("<-");
        Button buttonDecimal = new Button(".");
        Button buttonNegative = new Button("-/+");
        Button buttonPar = new Button("( )");

        button0.setPrefSize(60,60);
        button1.setPrefSize(60,60);
        button2.setPrefSize(60,60);
        button3.setPrefSize(60,60);
        button4.setPrefSize(60,60);
        button5.setPrefSize(60,60);
        button6.setPrefSize(60,60);
        button7.setPrefSize(60,60);
        button8.setPrefSize(60,60);
        button9.setPrefSize(60,60);
        buttonClear.setPrefSize(60,60);
        buttonAdd.setPrefSize(60,60);
        buttonMultiply.setPrefSize(60,60);
        buttonSubtract.setPrefSize(60,60);
        buttonDivide.setPrefSize(60,60);
        buttonEqual.setPrefSize(60,60);
        buttonUndo.setPrefSize(60,60);
        buttonDecimal.setPrefSize(60,60);
        buttonNegative.setPrefSize(60,60);
        buttonPar.setPrefSize(60,60);


        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(buttonClear, 0, 0);
        gridPane.add(button0, 1, 0);
        gridPane.add(buttonEqual, 2, 0);
        gridPane.add(buttonDivide, 3, 0);
        gridPane.add(button7, 0, 1);
        gridPane.add(button8, 1, 1);
        gridPane.add(button9, 2, 1);
        gridPane.add(buttonMultiply, 3, 1);
        gridPane.add(button4, 0, 2);
        gridPane.add(button5, 1, 2);
        gridPane.add(button6, 2, 2);
        gridPane.add(buttonSubtract, 3, 2);
        gridPane.add(button1, 0, 3);
        gridPane.add(button2, 1, 3);
        gridPane.add(button3, 2, 3);
        gridPane.add(buttonAdd, 3, 3);
        gridPane.add(buttonDecimal, 0, 4);
        gridPane.add(buttonNegative, 1, 4);
        gridPane.add(buttonPar, 2, 4);
        gridPane.add(buttonUndo, 3, 4);

        button0.setOnAction(e->{
            values.textField.setText(values.textField.getText() + "0");
        });
        button1.setOnAction(e->{
            values.textField.setText(values.textField.getText() + "1");
        });
        button2.setOnAction(e->{
            values.textField.setText(values.textField.getText() + "2");
        });
        button3.setOnAction(e->{
            values.textField.setText(values.textField.getText() + "3");
        });
        button4.setOnAction(e->{
            values.textField.setText(values.textField.getText() + "4");
        });
        button5.setOnAction(e->{
            values.textField.setText(values.textField.getText() + "5");
        });
        button6.setOnAction(e->{
            values.textField.setText(values.textField.getText() + "6");
        });
        button7.setOnAction(e->{
            values.textField.setText(values.textField.getText() + "7");
        });
        button8.setOnAction(e->{
            values.textField.setText(values.textField.getText() + "8");
        });
        button9.setOnAction(e->{
            values.textField.setText(values.textField.getText() + "9");
        });
        buttonDecimal.setOnAction(e->{
            values.textField.setText(values.textField.getText() + ".");
        });
        buttonClear.setOnAction(e->{
            values.textField.clear();
        });
        buttonUndo.setOnAction(e->{
            values.textField.setText((values.textField.getText()).substring(0, values.textField.getText().length()-1));
        });
        buttonNegative.setOnAction(e->{
            values.textField.setText(values.textField.getText() + "-");
        });

        buttonAdd.setOnAction(e->handleAddButton(values));
        buttonSubtract.setOnAction(e->handleSubtractButton(values));
        buttonMultiply.setOnAction(e->handleMultiplyButton(values));
        buttonDivide.setOnAction(e->handleDivideButton(values));
        buttonEqual.setOnAction(e->handleEqualButton(values));

        calcVbox.getChildren().addAll(values.textField, gridPane);
        menuVbox.getChildren().addAll(menuButton);
        calcVbox.setAlignment(Pos.CENTER);

        borderPane.setCenter(calcVbox);
        borderPane.setTop(menuVbox);


        Scene scene = new Scene(borderPane, 500,500);
        return scene;
    }
    private void handleEqualButton(Values values) {
        System.out.println(values.firstVal);
        System.out.println(values.secondVal);
        System.out.println(values.sign);
        if(values.sign == 43.0){
            if(values.textField.getText().contains("+")) {
                values.secondVal = Double.parseDouble((values.textField.getText()).substring((values.textField.getText()).indexOf('+') + 1));
            } else {
                values.firstVal = Double.parseDouble(values.textField.getText());
            }
            values.result = values.firstVal + values.secondVal;
            values.textField.clear();
            if(String.valueOf(values.result).contains(".")) {
                values.textField.setText(String.valueOf(values.result));
            } else {
                values.textField.setText(String.valueOf((int)values.result));
            }

        }
        if(values.sign == 45){
            if(values.textField.getText().contains("-") && values.textField.getText().indexOf("-") != 0) {
                values.secondVal = Double.parseDouble((values.textField.getText()).substring((values.textField.getText()).indexOf('-') + 1));
            } else {
                values.firstVal = Double.parseDouble(values.textField.getText());
                System.out.println(values.firstVal);
                System.out.println(values.secondVal);
            }
            values.result = values.firstVal - values.secondVal;
            values.textField.clear();
            if(String.valueOf(values.result).contains(".")) {
                values.textField.setText(String.valueOf(values.result));
            } else {
                values.textField.setText(String.valueOf((int)values.result));
            }
        }
        if(values.sign == 120){
            if(values.textField.getText().contains("x")) {
                values.secondVal = Double.parseDouble((values.textField.getText()).substring((values.textField.getText()).indexOf('x') + 1));
            } else {
                values.firstVal = Double.parseDouble(values.textField.getText());
            }
            values.result = values.firstVal * values.secondVal;
            values.textField.clear();
            if(String.valueOf(values.result).contains(".")) {
                values.textField.setText(String.valueOf(values.result));
            } else {
                values.textField.setText(String.valueOf((int)values.result));
            }
        }
        if(values.sign == 47){
            if(values.textField.getText().contains("/")) {
                values.secondVal = Double.parseDouble((values.textField.getText()).substring((values.textField.getText()).indexOf('/') + 1));
            } else {
                values.firstVal = Double.parseDouble(values.textField.getText());
            }
            values.result = ((double)values.firstVal) / values.secondVal;
            values.textField.clear();
            if(values.firstVal % values.secondVal == 0) {
                values.textField.setText(String.valueOf((int)values.result));
            } else {
                values.textField.setText(String.valueOf(values.result));
            }
        }
    }
    private void handleAddButton(Values values) {
        TextField textField = values.textField;
//		if(isInteger(textField.getText().substring(textField.getText().length() - 1)))
        values.firstVal = Double.parseDouble(textField.getText());
        textField.setText(textField.getText() + "+");
        values.sign = 43;
    }

    public static boolean isInteger(String s) {
        boolean isValidInteger = false;
        try {
            Integer.parseInt(s);
            isValidInteger = true;
        }
        catch (NumberFormatException ex) {
            // s is not an integer
        }
        return isValidInteger;
    }


    private void handleSubtractButton(Values values) {
        TextField textField = values.textField;
        values.firstVal = Double.parseDouble(textField.getText());
        textField.setText(textField.getText() + "-");
        values.sign = 45;
    }
    private void handleMultiplyButton(Values values) {
        TextField textField = values.textField;
        values.firstVal = Double.parseDouble(textField.getText());
        textField.setText(textField.getText() + "x");
        values.sign = 120;
    }
    private void handleDivideButton(Values values) {
        TextField textField = values.textField;
        values.firstVal = Double.parseDouble(textField.getText());
        textField.setText(textField.getText() + "/");
        values.sign = 47;
    }

    public Scene tempScreen(){
        VBox menuVbox = new VBox();
        menuVbox.getChildren().addAll(menuButton);
        Scene scene = new Scene(menuVbox, 500,500);
        return scene;
    }

    //feel free to remove the starter code from this method
    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        primaryStage.setTitle("Welcome to JavaFX");

        //declaring
        VBox vbox = new VBox(80);
        VBox instructions = new VBox();
        Button startButton = new Button("Start");
        Text calcText = new Text("Calculator");
        Text menuInstr = new Text("Press Menu to get options.");
        Text startInstr = new Text("Press Start to go to Main Screen.");
        BorderPane borderPane = new BorderPane();

        //adding items to vbox.
        instructions.getChildren().addAll(menuInstr, startInstr);
        instructions.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(calcText, startButton, instructions);
        vbox.setAlignment(Pos.CENTER);
        borderPane.setTop(menuButton);
        borderPane.setCenter(vbox);

        startButton.setOnAction(e->{
            primaryStage.setScene(calcScreen());
            primaryStage.show();
        });

        menuItem1.setOnAction(e->{
            primaryStage.setScene(tempScreen());
            primaryStage.show();
        });

        menuItem3.setOnAction(e->{
            System.exit(0);
        });

        Scene scene = new Scene(borderPane, 500,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
