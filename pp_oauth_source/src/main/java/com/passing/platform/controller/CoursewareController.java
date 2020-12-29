package com.passing.platform.controller;

import com.passing.platform.domain.Courseware;
import com.passing.platform.service.CoursewareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CoursewareController {
    @Autowired (required = false)
    private CoursewareService coursewareService;
    @RequestMapping(value = "/courseware",method = RequestMethod.GET)
    public Object GetCourseware(@RequestParam(value="start",defaultValue = "0")int start,
                                @RequestParam(value = "pagesize",defaultValue = "6")int pagesize,
                                @RequestParam(value = "id")int id){
        int total= coursewareService.selectAllCount();
        int _pagesize=pagesize;
        //若为最后一页则修改pagesize
        if(total-start*_pagesize<pagesize) pagesize=total%pagesize;
        List<Courseware> data=coursewareService.selectAllCourseWare(start*_pagesize,pagesize,id);
        Map<String,Object> res=new HashMap<String,Object>();
        res.put("total",total);
        res.put("data",data);
        return res;
    }

    @GetMapping("/courseware/{id}")
    public  Object GetCoursewareByid(@PathVariable int id){
        return coursewareService.getCoursewareById(id);
    }

    @GetMapping("/courseware/getdocument/{id}")

    public void getDoucument(@PathVariable int id, HttpServletResponse response){
        try {
            //  本地的pdf文件
            Courseware item= coursewareService.getCoursewareById(id);
            String path=item.getDocument();
            response.setContentType("application/pdf");
            FileInputStream in = new FileInputStream(new File(path));
            OutputStream out = response.getOutputStream();
            byte[] b = new byte[1024];
            while ((in.read(b))!=-1) {
                out.write(b);
            }
            out.flush();
            in.close();
            out.close();

        }catch (Exception e) {

            e.printStackTrace();

        }

    }
}
