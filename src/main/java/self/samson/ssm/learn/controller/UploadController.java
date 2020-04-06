package self.samson.ssm.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/layui")
public class UploadController {

    @RequestMapping(path = "/upload/single", method = RequestMethod.GET)
    public String upload() {
        return "upload";
    }

    @RequestMapping(path = "/upload/single", method = RequestMethod.POST)
    public Map<String, Object> result(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model)
            throws IllegalStateException, IOException {
        // 获取文件存储路径（绝对路径）
        String path = request.getServletContext().getRealPath("/WEB-INF/file");
        // 获取原文件名
        String fileName = file.getOriginalFilename();
        // 创建文件实例
        File filePath = new File(path, fileName);
        // 如果文件目录不存在，创建目录
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录" + filePath);
        }
        // 写入文件
        file.transferTo(filePath);

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", map2);
        map2.put("src", filePath.getPath());

        return map;
    }
}
