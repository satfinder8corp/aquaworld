package com.naumencourse.aquaworld.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FishWikiRequestDTO {

    private Long id;
    private AquaristDTO author;
    private FishDTO fish;
    private Date requestDate;
    private Boolean isConfirm;
    private Date confirmDate;
}
