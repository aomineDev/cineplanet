module aomine {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires bcrypt;

    opens aomine to javafx.fxml;
    exports aomine;
    opens aomine.view to javafx.fxml;
    exports aomine.view;
}
