package mine.school2.dataobject;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer sex;

    @Column(name = "class_grade")
    private String classGrade;

    private Integer status = 0;
    private String number;
    private String description;

    public Student(String name, Integer sex, String classGrade) {
        this.name = name;
        this.sex = sex;
        this.classGrade = classGrade;
    }
}
