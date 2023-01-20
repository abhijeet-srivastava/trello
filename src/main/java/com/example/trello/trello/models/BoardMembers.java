package com.example.trello.trello.models;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "board_member",schema = "dbo")
public class BoardMembers {
    @EmbeddedId
    private BoardMembersId id;


    @ManyToOne
    @MapsId("boardId")
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name="last_visited")
    private Date lastVisitTimeStamp;

    public BoardMembers(Board board, Member member, Date lastVisitTimeStamp) {
        this.id = new BoardMembersId(board.getBoardId(), member.getUserId());
        this.board = board;
        this.member = member;
        this.lastVisitTimeStamp = lastVisitTimeStamp;
    }
}
