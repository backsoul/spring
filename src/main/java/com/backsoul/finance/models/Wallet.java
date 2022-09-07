package com.backsoul.finance.models;

import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "wallets")
public class Wallet {
    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    private int salary;

    private int amountInitial;

    /**
     * 
     */
    public Wallet() {
        this.id = UUID.randomUUID().toString();
        this.amountInitial = 0;
        this.salary = 0;
    }

    public int getAmountInitial() {
        return amountInitial;
    }

    public void setAmountInitial(int amountInitial) {
        this.amountInitial = amountInitial;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

}
