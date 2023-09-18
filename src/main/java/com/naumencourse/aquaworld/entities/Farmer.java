package com.naumencourse.aquaworld.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Farmer {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String email;
    private String password;
    private Date dateOfRegistration = new Date();

//    List<Aquarium> aqCollection;
//    Map<Aquarium, List<Fish>> livestock;

    public String getOnlyDateOfRegistration() {
        if (this.dateOfRegistration != null) {
            DateFormat df = new SimpleDateFormat(" dd - MMMM - yyyy");
            return df.format(this.dateOfRegistration.getTime());
        } else {
            return "";
        }
    }

}
