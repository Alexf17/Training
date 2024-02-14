package org.example._2024_02_06.Pojo;

import org.example._2024_02_06.StatusManager;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Manager implements Serializable {
    private long id;
    private String first_name;
    private String last_name;
    private StatusManager status;
    private LocalDate created_at;
    private LocalDate updated_at;

    public Manager(long id, String first_name, String last_name, StatusManager status, LocalDate created_at, LocalDate updated_at) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", status=" + status +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return id == manager.id &&
                Objects.equals(first_name, manager.first_name) &&
                Objects.equals(last_name, manager.last_name) &&
                status == manager.status &&
                Objects.equals(created_at, manager.created_at) &&
                Objects.equals(updated_at, manager.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, status, created_at, updated_at);
    }
}
