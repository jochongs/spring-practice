package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Spring");
        return "hello";
        // templates/hello.html로 데이터를 넘기게 되어있음
        // 경로는 다음과 같다.
        // resources/templates/${입력값}.html
    }

    @GetMapping("hello-mvc")
    public String helloMvc(
            @RequestParam("name") String name,
            Model model
    ) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-spring")
    @ResponseBody
    public String helloString(
        @RequestParam("name") String name
    ) {
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(
        @RequestParam("name") String name
    ) {
        Hello hello = new Hello();
        hello.setName(name);
        hello.setFirstName(name);
        return hello;
    }

    static class Hello {
        private String name;
        private String firstName;

        public String getName() {
            return name;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    }
}
