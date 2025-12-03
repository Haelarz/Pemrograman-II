package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pelanggan {
    private final IntegerProperty id;
    private final StringProperty nama;
    private final StringProperty email;
    private final StringProperty telepon;

    public Pelanggan(int id, String nama, String email, String telepon) {
        this.id = new SimpleIntegerProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.email = new SimpleStringProperty(email);
        this.telepon = new SimpleStringProperty(telepon);
    }

    public Pelanggan(String nama, String email, String telepon) {
        this(0, nama, email, telepon);
    }
    
    public IntegerProperty idProperty() { 
    	return id; 
    }
    public int getId() { 
    	return id.get(); 
    }
    public void setId(int id) { 
    	this.id.set(id); 
    }

    public StringProperty namaProperty() { 
    	return nama; 
    }
    public String getNama() { 
    	return nama.get(); 
    }
    public void setNama(String nama) { 
    	this.nama.set(nama); 
    }

    public StringProperty emailProperty() { 
    	return email; 
    }
    public String getEmail() { 
    	return email.get(); 
    }
    public void setEmail(String email) { 
    	this.email.set(email); 
    }

    public StringProperty teleponProperty() { 
    	return telepon; 
    }
    public String getTelepon() { 
    	return telepon.get(); 
    }
    public void setTelepon(String telepon) { 
    	this.telepon.set(telepon); 
    }
}