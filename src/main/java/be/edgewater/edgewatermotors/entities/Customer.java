package be.edgewater.edgewatermotors.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Email;

import java.util.List;

import static be.edgewater.edgewatermotors.tools.StringTool.validEmail;

@Entity
@Table(name = "Customer")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Customer {

    @Id
    @NotNull
    @Email
    @Column(name = "Email")
    protected String email;

    @NotNull
    @Column(name = "Name")
    protected String name;

    @NotNull
    @Column(name = "LastName")
    protected String lastName;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "Password")
    protected String password;

    @NotNull
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "Customer_Email", referencedColumnName = "Email")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private List<Appointment> appointmentList;

    @NotNull
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "Customer_Email", referencedColumnName = "Email")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private List<ClaimForm> claimFormList;


    public Customer() {
    }

    public Customer(@Email String email, String name, String lastName, String password, List<Appointment> appointmentList, List<ClaimForm> claimFormList) {
        setEmail(email);
        setName(name);
        setLastName(lastName);
        setPassword(password);
        setAppointmentList(appointmentList);
        setClaimFormList(claimFormList);

    }



    // <------- Getters ------->

    public String getRole() {
        return "ROLE_COSTUMER";
    }
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public List<ClaimForm> getClaimFormList() {
        return claimFormList;
    }

    // <------- Setters ------->
    public void setEmail(String email) {
        if (email == null || !validEmail(email))
            throw new IllegalArgumentException("email can not null you need enter valid email!");
        this.email = email;
    }

    public void setName(String name) {
        if (name == null || name.isBlank() || name.length() > 25)
            throw new IllegalArgumentException("name can not null or longer than 25 characters");
        this.name = name;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isBlank() || lastName.length() > 25)
            throw new IllegalArgumentException("Last Name can not null or longer than 25 characters");
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        if (password == null || password.length() != 60)
            throw new IllegalArgumentException("password can not null or longer than 60 characters");
        this.password = password;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        if (appointmentList == null) throw new IllegalArgumentException("Appointment List can not null");
        this.appointmentList = appointmentList;
    }

    public void setClaimFormList(List<ClaimForm> claimFormList) {
        if (claimFormList == null) throw new IllegalArgumentException("Claim Form List can not null");
        this.claimFormList = claimFormList;
    }
}
