package net.javaguides.springboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Expenses")
public class Expense {
    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transaction_id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "from")
    private long from_userId;

    @Column(name = "to")
    private long to_userId;

    //This can either be Y or N
    @Column(name = "settled")
    private String settled;

    @ManyToOne(targetEntity=Group.class, fetch = FetchType.LAZY)
    private Group group;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expense )) return false;
        return transaction_id != null && transaction_id.equals(((Expense) o).getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public Long getId(){
        return this.transaction_id;
    }
}
