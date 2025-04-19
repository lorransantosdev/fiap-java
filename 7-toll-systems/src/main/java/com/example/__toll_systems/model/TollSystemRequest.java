package com.example.__toll_systems.model;

import com.example.__toll_systems.model.dto.Toll;

import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TollSystemRequest {

    private List<Toll> tollsInfo;
}
