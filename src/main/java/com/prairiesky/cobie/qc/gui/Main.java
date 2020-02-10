package com.prairiesky.cobie.qc.gui;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;


public class Main extends Application 
{
	private static String LOG_PANE_NAME = "logPane";
	private final TextArea loggingView = new TextArea();
	public Main()
	{
		TextAreaAppender.setTextArea(this.loggingView);
	}
	
	
	
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			/*Thread.currentThread().setUncaughtExceptionHandler(new UncaughtExceptionHandler()
			{
				
				@Override
				public void uncaughtException(Thread t, Throwable e)
				{
					CobieQCAlert alert = new CobieQCAlert(e);
					alert.showAndWait();
					
				}
			});*/
			VBox root = FXMLLoader.load(getClass().getResource("CobieQCReporter.fxml"));
			Scene scene = new Scene(root,425,425);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			setupLogginView();
			/*for(Node node : root.getChildren())
			{
				if(node != null && node.getId() != null && 
						node.getId().equalsIgnoreCase(LOG_PANE_NAME) && 
						node instanceof Pane)
				{
					((Pane)node).getChildren().add(loggingView);
				}
			}*/
			primaryStage.setScene(scene);
			primaryStage.setTitle(COBieGUIStringTable.APPLICATIONNAME.toString());
			primaryStage.show();
			root.getChildren().add(loggingView);
			OutputStream output = new OutputStream()
			{
				
				@Override
				public void write(int b) throws IOException
				{
					appendText(String.valueOf((char)b));
					
				}
			};
			System.setOut(new PrintStream(output));
			System.setErr(new PrintStream(output));
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	   public void appendText(String valueOf) 
	   {
	        Platform.runLater(() -> loggingView.appendText(valueOf));
	    }
	
	private void setupLogginView() 
	{
        loggingView.setLayoutX(17);
        loggingView.setLayoutY(64);
        loggingView.setPrefWidth(723);
        loggingView.setPrefHeight(170);
        loggingView.setWrapText(true);
        loggingView.appendText("Starting Application\n");
        loggingView.setEditable(false);
    }
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
