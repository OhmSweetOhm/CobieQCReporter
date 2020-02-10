package com.prairiesky.cobie.qc.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.prairiesky.cobie.qc.gui.COBieGUIStringTable;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class CobieQCAlert extends Alert
{
	//private String title,headerText,ContentText;
	
	public CobieQCAlert(Throwable e)
	{
		super(AlertType.ERROR);
		if(e instanceof CobieQCException)
		{
			this.setTitle(((CobieQCException)e).getErrorDetails().getTitle());
			this.setHeaderText(((CobieQCException)e).getErrorDetails().getHeader());
			this.setContentText(((CobieQCException)e).getErrorDetails().getMessage());
		}
		else
		{
			this.setTitle(e.getClass().getName());
			this.setHeaderText(e.getMessage());
			this.setContentText(e.getMessage());
		}
		init(e);
	}
	private void init(Throwable e)
	{
		// Create expandable Exception.
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String exceptionText = sw.toString();

		Label label = new Label(COBieGUIStringTable.EXCEPTION_LABEL.toString());

		TextArea textArea = new TextArea(exceptionText);
		textArea.setEditable(false);
		textArea.setWrapText(true);

		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);

		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(label, 0, 0);
		expContent.add(textArea, 0, 1);

		// Set expandable Exception into the dialog pane.
		this.getDialogPane().setExpandableContent(expContent);
	}
}
