package bank.account;

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
    /*@Column(name = "person_id", nullable = false)
    private Long personId;*/
    @ManyToOne
    private Person person;
}
