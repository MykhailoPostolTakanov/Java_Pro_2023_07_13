package bank.person;

import bank.account.Account;
import bank.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
@EntityListeners(AuditingEntityListener.class)
@Builder
public class Person extends BaseEntity {
    private String uid;
    private String name;
    @OneToMany(mappedBy = "person")
    private List<Account> accounts;
}
