package com.example.charity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "category")
@Builder
public class Person {
    @Id
    @SequenceGenerator(
            name = "person_sequance",
            sequenceName = "person_sequance",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequance"
    )
    private Long personId;
    private String name;
    private Integer serialNumber;
    private boolean deleted;
    private LocalDate date;
    @ManyToOne(
            cascade =CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
   @JoinColumn(
           name ="category_id",
           referencedColumnName = "categoryId"
   )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @NonNull
    private Category category;
}
