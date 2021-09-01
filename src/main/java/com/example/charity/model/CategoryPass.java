package com.example.charity.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CategoryPass {
    private String name;
    private Integer cost;
    private Integer remain;
}
