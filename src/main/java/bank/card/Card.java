package bank.card;

import bank.entity.BaseEntity;
import bank.account.Account;
import bank.person.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cards")
@EntityListeners(AuditingEntityListener.class)
@Builder
public class Card extends BaseEntity {
    private String uid;
    private String pan;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    private Instant expirationDate;
    private String pin;
    private String cvv;
    private String status;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
