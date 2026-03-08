package com.oceanview.ocean_view_resort.api.dto;

/**
 * DTO for Guest Registration.
 * Captures personal details required by the Ocean View Resort scenario.
 */
public class GuestDTO {
    private String guestId;
    private String name;
    private String address;
    private String contact;
    private String email;

    public GuestDTO() {}

    public GuestDTO(String guestId, String name, String address, String contact, String email) {
        this.guestId = guestId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }

    // Encapsulation: Accessing private fields via public methods [cite: 2026-02-14]
    public String getGuestId() { return guestId; }
    public void setGuestId(String guestId) { this.guestId = guestId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}