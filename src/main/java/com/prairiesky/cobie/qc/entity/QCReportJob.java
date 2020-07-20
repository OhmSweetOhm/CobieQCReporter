package com.prairiesky.cobie.qc.entity;

import com.prairiesky.cobie.qc.exception.CobieInputFileException;
import com.prairiesky.cobie.qc.exception.CobieQCReportException;
import com.prairiesky.cobie.qc.gui.COBieGUIStringTable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import org.bimserver.cobie.shared.deserialization.COBieDeserializer;
import org.bimserver.cobie.shared.reporting.COBieQCValidationPhase;
import org.bimserver.cobie.shared.reporting.COBieSchematronCheckerSettings;
import org.bimserver.cobie.shared.serialization.COBieCheckSerializer;
import org.bimserver.cobie.shared.utility.COBieStringHandler;
import org.bimserver.cobie.shared.utility.COBieStringHandlerSettings.EmptyStringMode;
import org.nibs.cobie.tab.COBIEDocument;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class QCReportJob {

    private final ObjectProperty<ObservableList<String>> phases = new SimpleObjectProperty<>(FXCollections.observableArrayList(
        COBieQCValidationPhase.Design.toString(),
        COBieQCValidationPhase.Construction.toString()));
    private final SimpleStringProperty cobieFilePath = new SimpleStringProperty();
    private final SimpleObjectProperty<File> cobieFile = new SimpleObjectProperty<>();
    private final SimpleBooleanProperty cobieFileNotChosen = new SimpleBooleanProperty();
    private final SimpleStringProperty qcPhase = new SimpleStringProperty();
    private final SimpleObjectProperty<File> outputFile = new SimpleObjectProperty<>();
    private final SimpleStringProperty outputFilePath = new SimpleStringProperty();
    private final SimpleBooleanProperty isInvalid = new SimpleBooleanProperty();
    private final SimpleObjectProperty<COBIEDocument> cobieDocument = new SimpleObjectProperty<>();
    private final SimpleBooleanProperty reportDone = new SimpleBooleanProperty();
    private final SimpleStringProperty picklistRulePath = new SimpleStringProperty();
    private final SimpleObjectProperty<File> picklistRuleFile = new SimpleObjectProperty<>();
    private final SimpleStringProperty attributeRulePath = new SimpleStringProperty();
    private final SimpleObjectProperty<File> attributeRuleFile = new SimpleObjectProperty<>();

    public QCReportJob() {
        this.isInvalid.set(true);
        this.cobieFileNotChosen.set(true);
        initCobieFileListeners();
    }

    private void evaluateModel() {
        cobieFileChosenProperty().set(!(cobieFileProperty().get() != null && cobieFileProperty().get().exists()));
        isValidProperty().set(!(cobieFileProperty().get() != null &&
                                cobieFileProperty().get().exists() &&
                                qcPhaseProperty().get() != null &&
                                outputFileProperty().get() != null &&
                                outputFileProperty().get().getParentFile().exists()));
    }

    private void initCobieFileListeners() {
        cobieFileProperty().addListener((observable, oldValue, newValue) -> {
            evaluateModel();
            if (newValue != null) {
                cobieFilePathProperty().set(newValue.getAbsolutePath());
            } else {
                cobieFilePathProperty().set("");
            }
        });

        qcPhaseProperty().addListener((observable, oldValue, newValue) -> evaluateModel());

        outputFileProperty().addListener((observable, oldValue, newValue) -> {
            evaluateModel();
            outputFilePathProperty().set(newValue.getAbsolutePath());
        });

        picklistFileProperty().addListener((observable, oldValue, newValue) -> picklistRulePathProperty().set(newValue.getAbsolutePath()));

        attributeRuleFileProperty().addListener((observable, oldValue, newValue) -> attributeRulePathProperty().set(
            newValue.getAbsolutePath()));
    }

    private void deserializeCobieFile() throws CobieInputFileException {
        COBieDeserializer deserializer = new COBieDeserializer(new File(COBieGUIStringTable.FILEPATH_BLANK_COBIE.toString()),
                                                               null);
        try {
            COBieStringHandler handler = new COBieStringHandler();
            handler.getSettings().setEmptyStringMode(EmptyStringMode.ALLOW);
            cobieDocumentProperty().set(deserializer.toCOBieSheetXMLData(cobieFileProperty().get(), handler));
        } catch (Exception e) {
            throw new CobieInputFileException(e);
        }
    }

    private void appendFileToCobie(File file) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbFactory.newDocumentBuilder();
        Document doc = builder.parse(file);
        Node firstElement = null;
        for (int i = 0; i < doc.getChildNodes().getLength(); i++) {
            Node testNode = doc.getChildNodes().item(i);
            if (testNode.getNodeType() == Node.ELEMENT_NODE) {
                firstElement = testNode;
                break;
            }
        }
        Node importedNode = ((Document) cobieDocument.get().getDomNode()).importNode(firstElement, true);
        cobieDocument.get().getCOBIE().getDomNode().appendChild(importedNode);
    }

    public void runReport() throws CobieQCReportException {
        /*
            IMPORTANT note
            Use generateReportInBackground in product version
            Use generateReportInForeground in debug mode
         */
        generateReportInBackground(); // for product version
//        generateReportInForeground(); // for debug
    }

    private void generateReportInBackground() {
        reportDone.set(false);
        Task<Void> reportTask = new Task<Void>() {
            @Override
            protected Void call() {
                generateReport();
                return null;
            }
        };
        reportTask.setOnSucceeded(event -> {
            reportDone.set(true);
            System.out.println("Report generated successfully");
        });
        Thread reportThread = new Thread(reportTask);
        reportThread.start();
    }

    public void generateReport() {
        try {
            System.out.println("Generating report...\nPlease wait");
            deserializeCobieFile();
            COBieQCValidationPhase validationPhase;
            switch (COBieQCValidationPhase.fromString(getQcPhase())) {
                case Construction:
                    validationPhase = COBieQCValidationPhase.Construction;
                    break;
                case Design:
                    validationPhase = COBieQCValidationPhase.Design;
                    break;
                default:
                    validationPhase = COBieQCValidationPhase.Design;
                    break;
            }

            COBieSchematronCheckerSettings settings = new COBieSchematronCheckerSettings(new File(
                COBieGUIStringTable.FILEPATH_SCHEMATRON_RULE.toString()),
                                                                                         new File(
                                                                                             COBieGUIStringTable.FILEPATH_SCHEMATRON_PREPROCESSOR
                                                                                                 .toString()),
                                                                                         new File(
                                                                                             COBieGUIStringTable.FILEPATH_SVRL_XSLT
                                                                                                 .toString()),
                                                                                         validationPhase);
            COBieCheckSerializer serializer = new COBieCheckSerializer(settings, null);
            if (getPicklistRuleFile() != null && getPicklistRuleFile().exists()) {
                appendFileToCobie(getPicklistRuleFile());
            }

            if (getAttributeRuleFile() != null && getAttributeRuleFile().exists()) {
                appendFileToCobie(getAttributeRuleFile());
            }
            serializer.transformCOBieSheetXMLData(cobieDocumentProperty().get(), outputFileProperty().get());
        } catch (Exception e) {
            System.out.println("Failed to generate report");
            CobieQCReportException ex = new CobieQCReportException(e);
            throw ex;
        }
    }

    private void generateReportInForeground() {
        reportDone.set(false);
        generateReport();
        reportDone.set(true);
        System.out.println("Report generated successfully");
    }

    public SimpleObjectProperty<File> cobieFileProperty() {
        return this.cobieFile;
    }

    public void setCobieFile(File cobieFile) {
        cobieFileProperty().set(cobieFile);
    }

    public File getCobieFile() {
        return cobieFileProperty().get();
    }

    public SimpleStringProperty qcPhaseProperty() {
        return qcPhase;
    }

    public void setQcPhase(String qcPhase) {
        qcPhaseProperty().set(qcPhase);
    }

    public String getQcPhase() {
        return qcPhaseProperty().get();
    }

    public SimpleObjectProperty<File> outputFileProperty() {
        return outputFile;
    }

    public SimpleStringProperty attributeRulePathProperty() {
        return this.attributeRulePath;
    }

    public String getAttributeFilePath() {
        return attributeRulePathProperty().get();
    }

    public void setAttributeFilePath(String filePath) {
        this.attributeRulePathProperty().set(filePath);
    }

    public SimpleObjectProperty<File> attributeRuleFileProperty() {
        return this.attributeRuleFile;
    }

    public File getAttributeRuleFile() {
        return this.attributeRuleFileProperty().get();
    }

    public void setAttributeRuleFile(File file) {
        this.attributeRuleFileProperty().set(file);
    }

    public SimpleStringProperty picklistRulePathProperty() {
        return this.picklistRulePath;
    }

    public String getPicklistFilePath() {
        return picklistRulePathProperty().get();
    }

    public void setPicklistFilePath(String path) {
        picklistRulePathProperty().set(path);
    }

    public File getOutputFilePath() {
        return outputFileProperty().get();
    }

    public void setOutputFilePath(File outputFile) {
        outputFileProperty().set(outputFile);
    }

    public SimpleObjectProperty<File> picklistFileProperty() {
        return this.picklistRuleFile;
    }

    public File getPicklistRuleFile() {
        return picklistFileProperty().get();
    }

    public void setPicklistRuleFile(File file) {
        picklistFileProperty().set(file);
    }

    public SimpleBooleanProperty isValidProperty() {
        return this.isInvalid;
    }

    public void setIsValid(boolean isValid) {
        isValidProperty().set(isValid);
    }

    public boolean getIsValid() {
        return isValidProperty().get();
    }

    public SimpleBooleanProperty cobieFileChosenProperty() {
        return this.cobieFileNotChosen;
    }

    public SimpleStringProperty cobieFilePathProperty() {
        return this.cobieFilePath;
    }

    public SimpleStringProperty outputFilePathProperty() {
        return this.outputFilePath;
    }

    public ObjectProperty<ObservableList<String>> phasesProperty() {
        return this.phases;
    }

    public ObjectProperty<COBIEDocument> cobieDocumentProperty() {
        return this.cobieDocument;
    }

    public SimpleBooleanProperty reportDoneProperty() {
        return this.reportDone;
    }

    public void setCobieDocument(COBIEDocument cobie) {
        this.cobieDocumentProperty().set(cobie);
    }

}
