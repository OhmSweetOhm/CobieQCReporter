package com.prairiesky.cobie.qc.gui;

import com.corballis.converter.AttributeListConverter;
import com.corballis.converter.PickListConverter;
import com.prairiesky.cobie.qc.entity.QCReportJob;
import com.prairiesky.cobie.qc.exception.CobieQCAlert;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class CobieQCController implements Initializable {

    @FXML
    public ComboBox<String> phase;

    @FXML
    public AnchorPane anchorPane;

    @FXML
    public Pane reportPane;

    @FXML
    public Button submitButton;

    @FXML
    public Button outputFileButton;

    @FXML
    public Button picklistFileButton;

    @FXML
    public TextField outputFilePath;

    @FXML
    public TextField picklistFilePath;

    @FXML
    public TextField attributeFilePath;

    @FXML
    public Button cobieFileButton;

    @FXML
    public TextField cobieFilePath;

    @FXML
    public javafx.scene.control.Menu importMenu;

    private QCReportJob qcReportJob;
    private final FileChooser inputFileChooser = new FileChooser();
    private final FileChooser pickListRulesXMLFileChooser = new FileChooser();
    private final FileChooser pickListRulesXLSXFileChooser = new FileChooser();
    private final FileChooser attributeRulesXMLFileChooser = new FileChooser();
    private final FileChooser attributeRulesXLSXFileChooser = new FileChooser();
    private final FileChooser outputFileChooser = new FileChooser();
    private ConfigurationFileHandler configFileHandler;

    public CobieQCController() {
        qcReportJob = new QCReportJob();
        inputFileChooser.getExtensionFilters()
                        .add(new ExtensionFilter(COBieGUIStringTable.FILE_FILTER_XLSX_DESCRIPTION.toString(),
                                                 COBieGUIStringTable.FILE_FILTER_XLSX.toString()));

        outputFileChooser.getExtensionFilters()
                         .add(new ExtensionFilter(COBieGUIStringTable.FILE_FILTER_HTML_DESCRIPTION.toString(),
                                                  COBieGUIStringTable.FILE_FILTER_HTML.toString()));
        pickListRulesXMLFileChooser.getExtensionFilters()
                                   .add(new ExtensionFilter(COBieGUIStringTable.FILE_FILTER_XML_DESCRIPTION.toString(),
                                                            COBieGUIStringTable.FILE_FILTER_XML.toString()));

        pickListRulesXLSXFileChooser.getExtensionFilters()
                                    .add(new ExtensionFilter(COBieGUIStringTable.FILE_FILTER_XLSX_DESCRIPTION.toString(),
                                                             COBieGUIStringTable.FILE_FILTER_XLSX.toString()));

        attributeRulesXMLFileChooser.getExtensionFilters()
                                    .add(new ExtensionFilter(COBieGUIStringTable.FILE_FILTER_XML_DESCRIPTION.toString(),
                                                             COBieGUIStringTable.FILE_FILTER_XML.toString()));

        attributeRulesXLSXFileChooser.getExtensionFilters()
                                     .add(new ExtensionFilter(COBieGUIStringTable.FILE_FILTER_XLSX_DESCRIPTION.toString(),
                                                              COBieGUIStringTable.FILE_FILTER_XLSX.toString()));

        try {
            this.configFileHandler = ConfigurationFileHandler.Factory.newInstance(true);
        } catch (ConfigurationException | IOException e) {
            e.printStackTrace();
        }
        initReportDoneHandler();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.reportPane.disableProperty().set(true);
        this.phase.itemsProperty().bind(getQcReportJob().phasesProperty());
        this.phase.valueProperty().bindBidirectional(getQcReportJob().qcPhaseProperty());
        this.reportPane.disableProperty().bindBidirectional(getQcReportJob().cobieFileChosenProperty());
        this.submitButton.disableProperty().bindBidirectional(getQcReportJob().isValidProperty());
        this.outputFilePath.textProperty().bind(getQcReportJob().outputFilePathProperty());
        this.cobieFilePath.textProperty().bind(getQcReportJob().cobieFilePathProperty());
        this.picklistFilePath.textProperty().bind(getQcReportJob().picklistRulePathProperty());
        this.attributeFilePath.textProperty().bind(getQcReportJob().attributeRulePathProperty());
        this.importMenu.disableProperty().bindBidirectional(this.reportPane.disableProperty());
    }

    private void setValueOfPicklistFilePath(String value) {
        this.picklistFilePath.textProperty().unbind();
        this.picklistFilePath.setText(value);
        this.picklistFilePath.textProperty().bind(getQcReportJob().picklistRulePathProperty());
    }

    private void setValueOfAttributeFilePath(String value) {
        this.attributeFilePath.textProperty().unbind();
        this.attributeFilePath.setText(value);
        this.attributeFilePath.textProperty().bind(getQcReportJob().attributeRulePathProperty());
    }

    private void initReportDoneHandler() {
        getQcReportJob().reportDoneProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                try {
                    viewReport();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void handleImportPickListRules(ActionEvent actionEvent) {
        try {
            try {
                File lastFile = getConfigFileHandler().getLastFileOpened();
                boolean previouslySelectedFileStillExists = lastFile != null &&
                                                            lastFile.exists() &&
                                                            lastFile.getParentFile().exists();

                if (previouslySelectedFileStillExists) {
                    pickListRulesXLSXFileChooser.setInitialDirectory(lastFile.getParentFile());
                }
            } catch (Exception e) {
                // NOOP, because if it not exist, then the file picker will not pointed to that directory, and that's it
            }

            File fileSelection = pickListRulesXLSXFileChooser.showOpenDialog(anchorPane.getScene().getWindow());

            if (fileSelection != null) {
                PickListConverter converter = new PickListConverter(fileSelection);
                String xmlPickLisFileName = fileSelection.getAbsolutePath()
                                                         .replace(".xlsx", "_" + new Date().getTime() + ".xml");
                converter.render(xmlPickLisFileName);
                getQcReportJob().picklistRulePathProperty().set(xmlPickLisFileName);
                getQcReportJob().picklistFileProperty().set(new File(xmlPickLisFileName));
                // We set the previously converted XML to this picker
                pickListRulesXMLFileChooser.setInitialFileName(xmlPickLisFileName);
                configFileHandler.setLastFileOpened(fileSelection);
                setValueOfPicklistFilePath(xmlPickLisFileName);
            }
        } catch (Exception e) {
            CobieQCAlert alert = new CobieQCAlert(e);
            getQcReportJob().setPicklistRuleFile(null);
            alert.showAndWait();
        }
    }

    public void handleImportAttributeRules(ActionEvent actionEvent) {
        try {
            try {
                File lastFile = getConfigFileHandler().getLastFileOpened();
                boolean previouslySelectedFileStillExists = lastFile != null &&
                                                            lastFile.exists() &&
                                                            lastFile.getParentFile().exists();

                if (previouslySelectedFileStillExists) {
                    attributeRulesXLSXFileChooser.setInitialDirectory(lastFile.getParentFile());
                }
            } catch (Exception e) {
                // NOOP, because if it not exist, then the file picker will not pointed to that directory, and that's it
            }

            File fileSelection = attributeRulesXLSXFileChooser.showOpenDialog(anchorPane.getScene().getWindow());

            if (fileSelection != null) {
                AttributeListConverter converter = new AttributeListConverter(fileSelection);
                String xmlAttributeListFileName = fileSelection.getAbsolutePath()
                                                               .replace(".xlsx", "_" + new Date().getTime() + ".xml");
                converter.render(xmlAttributeListFileName);
                getQcReportJob().attributeRulePathProperty().set(xmlAttributeListFileName);
                getQcReportJob().attributeRuleFileProperty().set(new File(xmlAttributeListFileName));
                // We set the previously converted XML to this picker
                pickListRulesXMLFileChooser.setInitialFileName(xmlAttributeListFileName);
                configFileHandler.setLastFileOpened(fileSelection);
                setValueOfAttributeFilePath(xmlAttributeListFileName);
            }
        } catch (Exception e) {
            CobieQCAlert alert = new CobieQCAlert(e);
            getQcReportJob().setPicklistRuleFile(null);
            alert.showAndWait();
        }
    }

    public void handleOpenAction() {
        try {
            try {
                File lastFile = getConfigFileHandler().getLastFileOpened();
                if (lastFile != null && lastFile.exists() && lastFile.getParentFile().exists()) {
                    inputFileChooser.setInitialDirectory(lastFile.getParentFile());
                }
            } catch (Exception e) {

            }
            File fileSelection = inputFileChooser.showOpenDialog(anchorPane.getScene().getWindow());
            if (fileSelection != null) {
                getQcReportJob().setCobieFile(fileSelection);
                getConfigFileHandler().setLastFileOpened(fileSelection);
            }
        } catch (Exception e) {
            CobieQCAlert alert = new CobieQCAlert(e);
            getQcReportJob().setCobieFile(null);
            getQcReportJob().setCobieDocument(null);
            alert.showAndWait();
        }

    }

    public void handleSubmit() {
        try {
            getQcReportJob().runReport();
        } catch (Exception ex) {
            CobieQCAlert alert = new CobieQCAlert(ex);
            alert.showAndWait();
        }
    }

    public void handleSelectAttributeAction() {
        try {
            try {
                File lastFile = getConfigFileHandler().getLastFileOpened();
                if (lastFile != null && lastFile.exists() && lastFile.getParentFile().exists()) {
                    attributeRulesXMLFileChooser.setInitialDirectory(lastFile.getParentFile());
                }
            } catch (Exception e) {

            }
            File fileSelection = attributeRulesXMLFileChooser.showOpenDialog(anchorPane.getScene().getWindow());
            if (fileSelection != null) {
                getQcReportJob().attributeRuleFileProperty().set(fileSelection);
                configFileHandler.setLastFileOpened(fileSelection);
            }
        } catch (Exception e) {
            CobieQCAlert alert = new CobieQCAlert(e);
            getQcReportJob().setAttributeRuleFile(null);
            alert.showAndWait();
        }

    }

    public void handleSelectPicklistAction() {
        try {
            try {
                File lastFile = getConfigFileHandler().getLastFileOpened();
                if (lastFile != null && lastFile.exists() && lastFile.getParentFile().exists()) {
                    pickListRulesXMLFileChooser.setInitialDirectory(lastFile.getParentFile());
                }
            } catch (Exception e) {

            }
            File fileSelection = pickListRulesXMLFileChooser.showOpenDialog(anchorPane.getScene().getWindow());
            if (fileSelection != null) {
                getQcReportJob().setPicklistRuleFile(fileSelection);
                getConfigFileHandler().setLastFileOpened(fileSelection);
            }
        } catch (Exception e) {
            CobieQCAlert alert = new CobieQCAlert(e);
            getQcReportJob().setPicklistRuleFile(null);
            alert.showAndWait();
        }
    }

    public void handleSelectOutputAction() {
        try {
            if (getConfigFileHandler().getLastSaveDirectory() != null &&
                getConfigFileHandler().getLastSaveDirectory().exists()) {
                this.outputFileChooser.setInitialDirectory(getConfigFileHandler().getLastSaveDirectory());
            }
        } catch (Exception e) {

        }
        String cobieFileName = this.getQcReportJob().getCobieFile().getName();
        if (cobieFileName.contains(".")) {
            cobieFileName = cobieFileName.substring(0, cobieFileName.lastIndexOf("."));
        }
        //cobieFileName = cobieFileName.substring(0, cobieFileName.lastIndexOf("."));
        DateFormat df = new SimpleDateFormat(COBieGUIStringTable.REPORT_NAME_DATE_FORMAT.toString());
        String nowFormatted = df.format(new Date());
        cobieFileName = nowFormatted + "_" + cobieFileName + COBieGUIStringTable.FILE_EXTENSION_HTML;
        outputFileChooser.setInitialFileName(cobieFileName);
        //outputFileChooser.setInitialFileName(this.getQcReportJob().cobieFileProperty().get().getName().replaceAll(COBieGUIStringTable.FILE_FILTER_XLSX.toString(), 
        //	COBieGUIStringTable.FILE_NAME_OUTPUT_DEFAULT_SUFFIX.toString()));
        File fileSelection = outputFileChooser.showSaveDialog(anchorPane.getScene().getWindow());
        if (fileSelection != null) {
            getQcReportJob().setOutputFilePath(fileSelection);
            getConfigFileHandler().setLastSaveLocation(fileSelection.getParentFile());
        }
    }

    public void handleAbout() {
        Alert aboutAlert = new Alert(AlertType.INFORMATION);
        aboutAlert.setTitle(COBieGUIStringTable.ABOUT_WINDOW_TITLE.toString());
        aboutAlert.setHeaderText(null);
        aboutAlert.setContentText(COBieGUIStringTable.ABOUT_WINDOW_CONTENT.toString());
        aboutAlert.show();
    }

    public void handleGetHelp() {
        Alert helpAlert = new Alert(AlertType.INFORMATION);
        helpAlert.setTitle(COBieGUIStringTable.HELP_WINDOW_TITLE.toString());
        helpAlert.setHeaderText(null);
        helpAlert.setContentText(COBieGUIStringTable.HELP_WINDOW_CONTENT.toString());
        helpAlert.show();
    }

    public void handleQuit() {
        Platform.exit();
        System.exit(0);
    }

    public QCReportJob getQcReportJob() {
        return this.qcReportJob;
    }

    private void viewReport() throws IOException {
        Desktop.getDesktop().open(getQcReportJob().getOutputFilePath());
		  /*WebView wv = new WebView();
		    wv.getEngine().setCreatePopupHandler(new Callback<PopupFeatures, WebEngine>() {

		        @Override
		        public WebEngine call(PopupFeatures p) {
		            Stage stage = new Stage(StageStyle.UTILITY);
		            WebView wv2 = new WebView();
		            stage.setScene(new Scene(wv2));
		            stage.show();
		            return wv2.getEngine();
		        }
		    });


		    StackPane root = new StackPane();
		    root.getChildren().add(wv);

		    Scene scene = new Scene(root, 300, 250);
		    try
			{
				wv.getEngine().load(qcReportJob.outputFileProperty().get().toURI().toURL().toString());
			} catch (MalformedURLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    }

    private ConfigurationFileHandler getConfigFileHandler() {
        return this.configFileHandler;
    }

}
