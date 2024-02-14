package org.example._2024_02_06.Pojo;

import org.example._2024_02_06.StatusManager;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Client implements Serializable {
    private long id;
    private String first_name;
    private String last_name;
    private String address;
    private String tax_code;
    private String email;
    private String phone_number;
    private StatusManager status;
    private LocalDate created_at;
    private LocalDate updated_at;
    private Manager manager;

    public Client(long id, String first_name, String last_name, String address, String tax_code, String email, String phone_number, StatusManager status, LocalDate created_at, LocalDate updated_at, Manager manager) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.tax_code = tax_code;
        this.email = email;
        this.phone_number = phone_number;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", tax_code='" + tax_code + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", status=" + status +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", manager=" + manager +
                '}';


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != client.id) return false;
        if (!Objects.equals(first_name, client.first_name)) return false;
        if (!Objects.equals(last_name, client.last_name)) return false;
        if (!Objects.equals(address, client.address)) return false;
        if (!Objects.equals(tax_code, client.tax_code)) return false;
        if (!Objects.equals(email, client.email)) return false;
        if (!Objects.equals(phone_number, client.phone_number))
            return false;
        if (status != client.status) return false;
        if (!Objects.equals(created_at, client.created_at)) return false;
        if (!Objects.equals(updated_at, client.updated_at)) return false;
        return Objects.equals(manager, client.manager);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (tax_code != null ? tax_code.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone_number != null ? phone_number.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (created_at != null ? created_at.hashCode() : 0);
        result = 31 * result + (updated_at != null ? updated_at.hashCode() : 0);
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        return result;
    }
}
