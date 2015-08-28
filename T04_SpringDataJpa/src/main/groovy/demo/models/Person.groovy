package demo.models

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * Created by luis on 8/25/15.
 */
@Entity
public class Person {

    @Id
    @GeneratedValue
    int id;

    @Column(length = 30)
    @Size(min=2, max=30)
    String name

    @NotNull
    @Min(18L)
    Integer age

    String toString() {
        "Person(Name: " + name + ", Age: " + age + ")"
    }
}
