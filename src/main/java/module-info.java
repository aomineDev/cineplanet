module aomine {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;

    requires bcrypt;

    requires transitive kernel;
    requires transitive layout;
    requires transitive io;

    opens aomine to javafx.fxml;
    exports aomine;
    opens aomine.view to javafx.fxml;
    exports aomine.view;
}
