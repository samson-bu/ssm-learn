package self.samson.ssm.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import self.samson.ssm.learn.po.Items;
import self.samson.ssm.learn.service.ItemsService;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    /**
     * 查询所有商品列表
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryItems")
    public ModelAndView queryItems() throws Exception {
        List<Items> itemsList = itemsService.findItemsList(null);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsList);
        // 设置视图名
        modelAndView.setViewName("itemsList");

        return modelAndView;
    }

    /**
     * 查询单个商品信息
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/editItems", method = RequestMethod.GET)
    public String editItems(Model model, Integer id) throws Exception {
        model.addAttribute("id", id);
        Items items = itemsService.findItemsById(id);
        model.addAttribute("items", items);
        return "editItems";
    }

    /**
     * 提交修改结果
     * @param model
     * @param id
     * @param items
     * @return
     * @throws Exception
     */
    public String editItemsSubmit(Model model, Integer id, @ModelAttribute(value = "items") Items items) throws Exception{
        model.addAttribute("id", id);
        itemsService.updateItems(id, items);
        return "editItems";
    }
}
