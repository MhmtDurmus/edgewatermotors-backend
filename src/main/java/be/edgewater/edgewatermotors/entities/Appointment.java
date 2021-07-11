package be.edgewater.edgewatermotors.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.LocalTime;
/**
 *
 * @author Mehmet Durmus
 * */
@Entity
@Table(name = "Appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(0)
    @Column(name = "Id")
    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future
    @Column(name = "Tijdstip")
    private LocalDateTime tijdstip;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "UurMarge")
    private LocalTime uurMarge;

    @NotNull
    @Column(name = "Klant_Email")
    private String costumer;

    public Appointment() {
    }

    public Appointment(@Future LocalDateTime tijdstip, LocalTime uurMarge, @NotNull String costumer) {
        setTijdstip(tijdstip);
        setUurMarge(uurMarge);
        setCostumer(costumer);
    }

    /// <------------- Getters --------------->
    public int getId() {
        return id;
    }

    public LocalDateTime getTijdstip() {
        return tijdstip;
    }

    public LocalTime getUurMarge() {
        return uurMarge;
    }

    public String getCostumer() {
        return costumer;
    }

    /// <------------- Setters --------------->
    public void setId(int id) {
        this.id = id;
    }

    public void setTijdstip(LocalDateTime tijdstip) {
        this.tijdstip = tijdstip;
    }

    public void setUurMarge(LocalTime uurMarge) {
        this.uurMarge = uurMarge;
    }

    public void setCostumer(String costumer) {
        this.costumer = costumer;
    }
}
