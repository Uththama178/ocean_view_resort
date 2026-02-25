package com.oceanview.ocean_view_resort.model;
import java.io.Serializable;

public class Guest implements Serializable {
    private String guestId;
    private String name;
    private String contact;
    private String email;
    private String nic;

    public Guest() {}
    public Guest(String guestId, String name, String contact, String email, String nic) {
        this.guestId = guestId;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.nic = nic;
    }

    // Getters
    public String getGuestId() { return guestId; }
    public String getName() { return name; }
    public String getContact() { return contact; }
    public String getEmail() { return email; }
    public String getNic() { return nic; }
}