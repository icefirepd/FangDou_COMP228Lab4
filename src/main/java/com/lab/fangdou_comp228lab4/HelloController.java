package com.lab.fangdou_comp228lab4;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HelloController {
    @FXML private TextField txtName;
    @FXML private TextField txtAddress;
    @FXML private TextField txtProvince;
    @FXML private TextField txtCity;
    @FXML private TextField txtPostalCode;
    @FXML private TextField txtPhone;
    @FXML private TextField txtEmail;
    @FXML private RadioButton rbComputerScience;
    @FXML private RadioButton rbBusiness;
    @FXML private ComboBox<String> cmbCourses;
    @FXML private ListView<String> lstSelectedCourses;
    @FXML private CheckBox chkStudentCouncil;
    @FXML private CheckBox chkVolunteerWork;
    @FXML private TextArea txtDisplay;

    private final ObservableList<String> computerScienceCourses =
            FXCollections.observableArrayList("Java", "Python", "C#", "JavaScript");
    private final ObservableList<String> businessCourses =
            FXCollections.observableArrayList("Marketing", "Accounting", "Economic", "Financing");

    @FXML
    public void initialize() {
        ToggleGroup majorGroup = new ToggleGroup();
        rbComputerScience.setToggleGroup(majorGroup);
        rbBusiness.setToggleGroup(majorGroup);

        rbComputerScience.setOnAction(e -> updateCourseList());
        rbBusiness.setOnAction(e -> updateCourseList());

        lstSelectedCourses.setItems(FXCollections.observableArrayList());
    }

    private void updateCourseList() {
        if (rbComputerScience.isSelected()) {
            cmbCourses.setItems(computerScienceCourses);
        } else if (rbBusiness.isSelected()) {
            cmbCourses.setItems(businessCourses);
        }
        cmbCourses.getSelectionModel().clearSelection();
    }

    @FXML
    private void handleAddCourse() {
        String selectedCourse = cmbCourses.getSelectionModel().getSelectedItem();
        if (selectedCourse != null && !lstSelectedCourses.getItems().contains(selectedCourse)) {
            lstSelectedCourses.getItems().add(selectedCourse);
        }
    }

    @FXML
    private void handleDisplay() {
        StringBuilder display = new StringBuilder();
        display.append(txtName.getText()).append(", ").append(txtAddress.getText()).append(", ").append(txtProvince.getText()).append(", ").append(txtCity.getText()).append(", ").append(txtPostalCode.getText()).append(", ").append(txtPhone.getText()).append(", ").append(txtEmail.getText()).append("\n");
        display.append("Courses:\n");
        for (String course : lstSelectedCourses.getItems()) {
            display.append(course).append("\n");
        }
        if (chkStudentCouncil.isSelected()) {
            display.append("Student Council\n");
        }
        if (chkVolunteerWork.isSelected()) {
            display.append("Volunteer Work\n");
        }
        txtDisplay.setText(display.toString());
    }
}