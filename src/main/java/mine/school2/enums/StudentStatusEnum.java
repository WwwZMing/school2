package mine.school2.enums;

import lombok.Getter;

@Getter
public enum StudentStatusEnum {

    internal(0),/*在校*/
    graduate(1)/*毕业*/
    ;
    private Integer code;

    StudentStatusEnum(Integer code) {
        this.code = code;
    }
}
