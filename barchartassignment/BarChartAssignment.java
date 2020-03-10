/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barchartassignment;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

/**
 *
 * @author Chris Cullen
 */
public class BarChartAssignment extends Application {

/**
 *
 * @author Chris Cullen
 */
        private Button GBC = new Button("Generate bar chart");
        private Button GCSV = new Button("Generate from CSV");
        private Label titleL = new Label("Title: ");
        private Label xaxisL = new Label("X-axis Label: ");
        private Label yaxisL = new Label("Y-axis Label: ");
        private Label itemNameL = new Label("Item name: ");
        private Label valueL = new Label("Value: ");
        private Label enabledL = new Label("Enabled: ");
        private Label errorL = new Label();
        private TextField titleText = new TextField("");
        private TextField desOfItemText = new TextField("Description of Items");
        private TextField desOfItemValText = new TextField("Description of item value");
        
      
        
        private TextField[] column1 = new TextField[10];
        private TextField[] column2 = new TextField[10];
        private CheckBox[] column3 = new CheckBox[10];
        

        
        @Override
        public void start(Stage primaryStage){
            primaryStage.setTitle("Create Bar charts");
            FileChooser fileChooser = new FileChooser();
            
            HBox root = new HBox();
            VBox root2 = new VBox(10);
            HBox root3 = new HBox(10);
            HBox root4 = new HBox();
            VBox root5 = new VBox(35);
            VBox root6 = new VBox(25);
            VBox root7 = new VBox(10);
            VBox root8 = new VBox(10);
            VBox root9 = new VBox(17);
            
            
            
            root.getChildren().add(root2);
            root.getChildren().add(root3);
            root2.getChildren().add(root4);
            root4.getChildren().add(root5);
            root4.getChildren().add(root6);
            root3.getChildren().add(root7);
            root3.getChildren().add(root8);
            root3.getChildren().add(root9);
            
            root.setPrefSize(600, 400);
            root2.setPrefSize(300, 200);
            root3.setPrefSize(300, 200);
            root4.setPrefSize(300, 100);
            root5.setPrefSize(100, 100);
            root6.setPrefSize(125, 100);
            root7.setPrefSize(100, 200);
            root8.setPrefSize(100, 200);
            root9.setPrefSize(100, 200);
            
            root2.getChildren().add(GBC);
            root2.getChildren().add(GCSV);
            root2.getChildren().add(errorL);
            errorL.setVisible(false);
            root5.getChildren().add(titleL);
            root5.getChildren().add(xaxisL);
            root5.getChildren().add(yaxisL);
            root6.getChildren().add(titleText);
            root6.getChildren().add(desOfItemText);
            root6.getChildren().add(desOfItemValText);
            root7.getChildren().add(itemNameL);
            root8.getChildren().add(valueL);
            root9.getChildren().add(enabledL);
            
            for(int i=0 ; i<column1.length;i++){ 
                column1[i]=new TextField("");
                column1[i].setText("Item Name");
                column1[i].setDisable(true);
                root7.getChildren().add(column1[i]);
            }
            for(int i=0 ; i<column2.length;i++){ 
                column2[i]=new TextField("");
                column2[i].setText("e.g. 50");
                column2[i].setDisable(true);
                root8.getChildren().add(column2[i]);
            }
            for(int i=0 ; i<column3.length;i++){
                column3[i]=new CheckBox();
                column3[i].setSelected(false);
                final int index = i;
                column3[i].setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                    public void handle(MouseEvent me){   
                    if(me.getButton()==MouseButton.PRIMARY){
                    changeState(index);
                    }}
                });
                root9.getChildren().add(column3[i]);
            }
 
            GBC.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                Stage stage = new Stage();
                stage.setTitle(titleText.getText());
                BorderPane root = new BorderPane();
                root.setPrefSize(600,600);
                stage.setResizable(false);
                
                Label topLabel = new Label("");
                topLabel.setText(titleText.getText()); 
                root.setAlignment(topLabel, Pos.CENTER);
                topLabel.setFont(new Font("TimesNewRoman",40));
                root.setTop(topLabel);
                
                CategoryAxis Xaxis = new CategoryAxis();
                Xaxis.setLabel(desOfItemText.getText());
                
                NumberAxis Yaxis = new NumberAxis();
                Yaxis.setLabel(desOfItemValText.getText());
                
                BarChart BC = new BarChart (Xaxis,Yaxis);
                XYChart.Series data = new XYChart.Series();
                
                for(int i=0;i<column3.length;i++){
                    if(column3[i].isSelected()){
                        data.getData().add(new XYChart.Data(column1[i].getText(),Double.parseDouble(column2[i].getText())));}
                }
                
                BC.getData().add(data);
                root.setCenter(BC);   
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            
            });
            
            GCSV.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
            
            File file = chooseCSVFile(fileChooser);
                    if (file != null) {
                        getDataCSV(file);   
                    }    
                }
             });

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        
    }

        public void changeState(int i){
        if(column3[i].isSelected()){
            column2[i].setDisable(false);
            column1[i].setDisable(false);}
        else{
            column2[i].setDisable(true);
            column1[i].setDisable(true);}
        }
        
        public File chooseCSVFile(FileChooser fileChooser){
            Stage primaryStage = new Stage();
            File records = new File(System.getProperty("C:"), "src");

        fileChooser.setTitle("Pick a CSV file");
        fileChooser.setInitialDirectory(records);
        File file = fileChooser.showOpenDialog(primaryStage);
        return file;
        
        }
        
        public void getDataCSV(File file){
            Stage stage = new Stage();
            BorderPane root = new BorderPane();
            root.setPrefSize(600,600);
            stage.setResizable(false);
            Label topLabel = new Label("");
            CategoryAxis Xaxis = new CategoryAxis();
            NumberAxis Yaxis = new NumberAxis(); 
            XYChart.Series data = new XYChart.Series();
            String name = new String("");
            String value = new String("");
                
            try{
                Scanner scanner = new Scanner(file).useDelimiter(",|\n");
                
                    String item = scanner.next();
                    stage.setTitle(item);
                    Xaxis.setLabel(item);
                    
                    item = scanner.next();
                    Yaxis.setLabel(item);
                        
                    item = scanner.next();
                    topLabel.setText(item);
                    root.setAlignment(topLabel, Pos.CENTER);
                    topLabel.setFont(new Font("TimesNewRoman",40));
                    root.setTop(topLabel);
                    stage.setTitle(item);
                    
                    item=scanner.nextLine();
            
                 while(scanner.hasNext()){
                    item = scanner.nextLine();
                    System.out.println(item);
                    String[] csvData = item.split(",");
                    data.getData().add(new XYChart.Data(csvData[0],Double.parseDouble(csvData[1])));    
                    }
                 scanner.close();
            }
               catch(FileNotFoundException e){
                   errorL.setVisible(true);
                   errorL.setText("There were no CSV files found.");
                            
                            }
                catch(NoSuchElementException e){
                    errorL.setVisible(true);
                    errorL.setText("The file selected is the wrong file type.");
                            }
                catch(NumberFormatException e){
                    errorL.setVisible(true);
                    errorL.setText("The data in the file does not match the desired format.");
                
                            }
                BarChart BC = new BarChart (Xaxis,Yaxis);
                BC.getData().add(data);
                root.setCenter(BC);   
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show(); 
        }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
