package hibernate;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "hero")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class HibernateHero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;// ім'я
    String gender;// стать
    String eyeColor;// колір очей
    String race;// раса
    String hairColor;// колір волосся
    double height;// зріст
    String publisher; // видавець
    String skinColor;// колір шкіри
    String alignment;// добро / зло
    int weight;// вага
}
