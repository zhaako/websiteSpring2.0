package com.youtube.blog.db;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cars {
    private Long id;
    private String name;
    private double engineVolume;
    private int maxSpeed;

}
