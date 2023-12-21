package com.naumencourse.aquaworld.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "fish_wiki_requests")
public class FishWikiRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    // автор заявки на внесение изменений в рыбную Wiki
    private UUID authorId;

    // рыбка, для которой предлагается внести изменения
    private UUID fishId;

    // дата запроса на изменения
    private LocalDateTime requestDate;

    // подтверждено ли изменение администратором
    // true - подтверждено, false - не подтверждено
    private Boolean isConfirm;

    // дата подтверждения, т.е. внесения изменений
    private LocalDateTime confirmDate;

}
