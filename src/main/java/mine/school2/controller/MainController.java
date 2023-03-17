package mine.school2.controller;

import mine.school2.dataobject.Student;
import mine.school2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RestController//替代繁复的responsebody
@RequestMapping(path = "demo")
public class MainController {
    @Autowired
    private StudentService studentService;

    //    新增
    @PostMapping(path = "add")
    public String addNewStudent(@RequestBody Student student) {
        studentService.createOne(student);
        return "Saved";
    }

    //    删除
    @GetMapping(path = "del")
    public String delNewStudent(@RequestParam Integer id) {
        studentService.remove(id);
        return "Deleted";
    }

    //    更新
    @PostMapping(path = "/update")
    public String updateStudent(@RequestBody Student student) {
        studentService.updateOne(student);
        return "Update Success";
    }

    //    分页查询
    @GetMapping(path = "/all")
    public List<Student> getAllStudent(@RequestParam Integer a) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(a, 20, sort);
        return studentService.findAll(pageable).getContent();
    }

    //    按名字查询
    @GetMapping(path = "/find")
    public List<Student> findStudentByName(@RequestParam List<String> nameList) {
        return studentService.findByNameIn(nameList);
    }
}