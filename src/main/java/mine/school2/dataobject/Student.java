package mine.school2.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Entity;
import java.math.BigInteger;

@Entity
@DynamicUpdate
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer sex;
    private String class_grade;

    private Integer status = 0;
    private String number;
    private  String description;

    public Student(String name, Integer sex, String class_grade) {
        this.name = name;
        this.sex = sex;
        this.class_grade = class_grade;
    }

    public Student() {

    }
}
