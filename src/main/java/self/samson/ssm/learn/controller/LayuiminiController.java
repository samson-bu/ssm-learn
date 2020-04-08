package self.samson.ssm.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"/mini"})
public class LayuiminiController {

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}
