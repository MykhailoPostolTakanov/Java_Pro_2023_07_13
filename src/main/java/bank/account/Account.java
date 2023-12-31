package bank.account;

import bank.card.Card;
import bank.entity.BaseEntity;
import bank.person.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
@EntityListeners(AuditingEntityListener.class)
@Builder
public class Account extends BaseEntity {
    private String uid;
    private String iban;
    private int balance;
    @ManyToOne
    private Person person;
    @OneToMany(mappedBy = "account")
    private List<Card> cards;
}
