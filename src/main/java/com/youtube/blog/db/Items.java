package com.youtube.blog.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Items{
    private Long id;
    private String name;
    private int price;

}
