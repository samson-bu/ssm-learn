package self.samson.ssm.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import self.samson.ssm.learn.mapper.ItemsMapper;
import self.samson.ssm.learn.po.Items;
import self.samson.ssm.learn.service.ItemsService;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping(method = RequestMethod.GET)public String printHello(ModelMap model) {
        Items items = itemsService.findItemsById(1);
        model.addAttribute("message1", "Hello Spring MVC Framework!");
        model.addAttribute("message2", items.toString());

        return "hello";
    }
}