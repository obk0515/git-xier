package com.obk.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class weatherBean {
    private int id;
    private String fxDate;
    private int tempMax;
    private int tempMin;
    private String textDay;
}
