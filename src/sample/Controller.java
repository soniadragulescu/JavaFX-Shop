package sample;

import domain.Category;
import domain.CategoryDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.FilterService;

public class Controller {
    private ObservableList<CategoryDTO> modelGrade= FXCollections.observableArrayList();
    private FilterService service;

    @FXML
    TableColumn<CategoryDTO,Category> columnCategory;

    @FXML
    TableColumn<CategoryDTO,Float> columnProcentaj;

    @FXML
    TableView<CategoryDTO> table;

    @FXML
    Button buton;

    @FXML
    DatePicker start;

    @FXML
    DatePicker end;

    @FXML
    public void initialize(){
        columnCategory.setCellValueFactory(new PropertyValueFactory<CategoryDTO,Category>("category"));
        columnProcentaj.setCellValueFactory(new PropertyValueFactory<CategoryDTO,Float>("procentaj"));
        table.setItems(modelGrade);

        buton.setOnAction(x->modelGrade.setAll(service.procentajeCategorii(start.getValue().atStartOfDay(),end.getValue().atStartOfDay())));
    }

    public void setService(FilterService service){
        this.service=service;
        //modelGrade.setAll(service.procentajeCategorii(start.getValue().atStartOfDay(),end.getValue().atStartOfDay()));
    }
}
