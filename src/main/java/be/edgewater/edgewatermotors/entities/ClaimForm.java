package be.edgewater.edgewatermotors.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 *
 * @author Mehmet Durmus
 * */
@Entity
@Table(name = "Claim_Form")
public class ClaimForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(0)
    @Column(name = "Id")
    private int id;


}
