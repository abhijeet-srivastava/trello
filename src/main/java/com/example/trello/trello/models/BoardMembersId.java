package com.example.trello.trello.models;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class BoardMembersId implements Serializable {

    @Column(name = "board_id")
    private Long boardId;

    @Column(name = "member_id")
    private Long memberId;
}
