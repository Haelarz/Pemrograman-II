module Praktikum7 {
	// 1. Wajibkan library yang dibutuhkan
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;        // Untuk koneksi database (JDBC)

    // 2. Buka akses paket agar bisa dibaca oleh JavaFX (untuk FXML & Controller)
    opens application to javafx.graphics, javafx.fxml;
    opens controller to javafx.fxml;
    opens model to javafx.base; // Penting agar TableView bisa baca Getter/Setter di Model

    // 3. Ekspor paket utama
    exports application;
}
