package com.intech.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int msisdn;

    @Column(columnDefinition = "VARCHAR(32)")
    @Enumerated(value = EnumType.STRING)
    private ActionType action;

    @Column(columnDefinition = "TIMESTAMPTZ")
    private Timestamp timestamp;

    public Purchase() {
    }

    public Purchase(int msisdn, ActionType action, Timestamp timestamp) {
        this.msisdn = msisdn;
        this.action = action;
        this.timestamp = timestamp;
    }

    public int getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(int msisdn) {
        this.msisdn = msisdn;
    }

    public ActionType getAction() {
        return action;
    }

    public void setAction(ActionType action) {
        this.action = action;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
