package com.example.charity.model;

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
@ToString
@Builder
public class Category {
    @Id
    @SequenceGenerator(
            name = "category_sequance",
            sequenceName = "category_sequance",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequance"
    )
    private Long categoryId;
    @NonNull
    private String name;
    private Integer cost;
    private Integer remain;

}
