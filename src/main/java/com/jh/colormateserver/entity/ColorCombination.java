package com.jh.colormateserver.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="color_combination")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColorCombination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String type;

    @Column
    private String season;

    @Column(nullable = false)
    private String topColor;

    @Column(nullable = false)
    private String bottomColor;

    @Column(nullable = false)
    private String shoesColor;
}
