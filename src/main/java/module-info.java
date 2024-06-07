module com.main.kegiatan6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.main.kegiatan6 to javafx.fxml;
    exports com.main.kegiatan6;
    exports com.main.kegiatan6.admin;
    exports com.main.kegiatan6.student;
    opens com.main.kegiatan6.student to java.base;
    opens com.main.kegiatan6.admin to java.base;
}