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
    @Column(name = "Time_Stamp")
    private LocalDateTime timeStamp;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "Hour")
    private LocalTime hour;

    @NotNull
    @Column(name = "Klant_Email")
    private String costumer;

    public Appointment() {
    }

    public Appointment(@Future LocalDateTime timeStamp, LocalTime hour, @NotNull String costumer) {
        setTimeStamp(timeStamp);
        setHour(hour);
        setCostumer(costumer);
    }

    /// <------------- Getters --------------->
    public int getId() {
        return id;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public LocalTime getHour() {
        return hour;
    }

    public String getCostumer() {
        return costumer;
    }

    /// <------------- Setters --------------->
    public void setId(int id) {
        this.id = id;
    }

    public void setTimeStamp(LocalDateTime tijdstip) {
        this.timeStamp = tijdstip;
    }

    public void setHour(LocalTime uurMarge) {
        this.hour = uurMarge;
    }

    public void setCostumer(String costumer) {
        this.costumer = costumer;
    }
}
