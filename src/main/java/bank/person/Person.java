package bank.person;

import bank.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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

    public void setName(String name) {
        this.name = name;
    }
}
