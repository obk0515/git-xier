package com.obk.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class cityBean {
    private String name;
    private int id;
    private String lat;
    private String lon;
}
