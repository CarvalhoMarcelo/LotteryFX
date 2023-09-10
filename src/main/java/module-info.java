module com.marcelo.megasenafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.marcelo.lotteryfx to javafx.fxml;
    exports com.marcelo.lotteryfx;
    exports com.marcelo.lotteryfx.models;
    opens com.marcelo.lotteryfx.models to javafx.fxml;
    exports com.marcelo.lotteryfx.tasks;
    opens com.marcelo.lotteryfx.tasks to javafx.fxml;
    exports com.marcelo.lotteryfx.utils;
    opens com.marcelo.lotteryfx.utils to javafx.fxml;
}