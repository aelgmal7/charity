package com.example.charity.model;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public
class PersonPass {
    private String name;
    private Integer serialNumber;
    private boolean deleted;
    private LocalDate date;
    private Long categoryId;
}
