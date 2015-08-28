package demo.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * Created by luis on 8/25/15.
 */
public class Person {

    int id;

    @Size(min=2, max=30)
    String name

    @NotNull
    @Min(18L)
    Integer age

    String toString() {
        "Person(Name: " + name + ", Age: " + age + ")"
    }
}
