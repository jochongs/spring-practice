package hello.hellospring.controller;

import org.springframework.stereotype.Controller;

@Controller
public class MemberForm {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
