package pl.coderslab.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Equipment equipment;

    @ManyToOne
    private User user;

    @Column(name = "rental_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentalDate;

    public Rental() {
    }

    public Rental(Equipment equipment, LocalDate rentalDate, User user) {
        this.equipment = equipment;
        this.rentalDate = rentalDate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", equipment=" + equipment +
                ", user=" + user +
                ", rentalDate=" + rentalDate +
                '}';
    }
}
