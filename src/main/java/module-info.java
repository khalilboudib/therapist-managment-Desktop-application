module gui_tp.tp_poo {
    requires javafx.controls;
    requires javafx.fxml;


    opens gui_tp.tp_poo to javafx.fxml;
    exports orthophoniste;
    opens orthophoniste to javafx.fxml;
    exports gui_tp.tp_poo;
}