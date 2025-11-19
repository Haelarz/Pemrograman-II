package Controller;

import model.Mahasiswa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    @FXML
    private TableView<Mahasiswa> table;

    @FXML
    private TableColumn<Mahasiswa, String> colNim;

    @FXML
    private TableColumn<Mahasiswa, String> colNama;

    private ObservableList<Mahasiswa> data;

    @FXML
    public void initialize() {
        colNim.setCellValueFactory(new PropertyValueFactory<>("nim"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));

        data = FXCollections.observableArrayList(
                new Mahasiswa("020", "Hel"),
                new Mahasiswa("021", "Helga"),
                new Mahasiswa("023", "Lat"),
                new Mahasiswa("024", "Lathif"),
                new Mahasiswa("025", "Martiz"),
                new Mahasiswa("026", "Martiza"),
                new Mahasiswa("027", "Helg"),
                new Mahasiswa("028", "Egg"),
                new Mahasiswa("029", "HLM"),
                new Mahasiswa("030", "Ega")
        );

        table.setItems(data);
    }
}