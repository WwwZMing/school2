package mine.school2.controller;

import mine.school2.dataobject.Student;
import mine.school2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;


@Controller
@RequestMapping(path = "demo")
public class MainController {
    @Autowired
    private StudentService studentService;

//    新增
    @PostMapping(path = "add")
    public @ResponseBody String addNewStudent(@RequestParam String name, @RequestParam String classGrade, @RequestParam Integer sex) {
        Student s = studentService.createOne(name,classGrade,sex);
        studentService.save(s);
        return "Saved";
    }
//    删除
    @GetMapping(path = "del")
    public @ResponseBody String delNewStudent(@RequestParam Integer id) {
        studentService.deleteById(id);
        return "Deleted";
    }

//    更新
    @PostMapping(path = "/update")
    public @ResponseBody String updateStudent(@RequestParam Integer id, @RequestParam String name, @RequestParam String classGrade, @RequestParam Integer sex) {
        Student s = studentService.updateOne(id,name,classGrade,sex);
        studentService.save(s);
        System.out.println(s);
        return "Update Success";
    }

//    分页查询
    @GetMapping(path = "/all")
    public @ResponseBody List<Student> getAllStudent(@RequestParam Integer a) {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(a,20,sort);
        return studentService.findAll(pageable);
    }
//    按名字查询
    @GetMapping(path = "/find")
    public @ResponseBody List<Student> findStudentByName(@RequestParam List<String> nameList){
        return studentService.findByNameIn(nameList);
    }
}