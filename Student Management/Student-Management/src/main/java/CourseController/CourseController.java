package CourseController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import entity.Course;
import service.CourseService;

@RestController
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping("/")
    public String viewCoursesPage(Model model) {
        List<Course> listCourses = service.listAll();
        model.addAttribute("listCourses", listCourses);
        return "courseee";
    }
    @GetMapping("/error")
    public String handleError() {
        return "custom-error"; // returns custom-error.html
    }

    @GetMapping("/addcourse")
    public String add(Model model) {
        model.addAttribute("course", new Course());
        return "addcourse";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("course") @Validated Course course, BindingResult result) {
        if (result.hasErrors()) {
            return "addcourse";
        }
        service.save(course);
        return "redirect:/courses";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditCoursePage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("addcourse");
        Course course = service.get(id);
        mav.addObject("course", course);
        return mav;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCoursePage(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/courses";
    }
    
    
}
