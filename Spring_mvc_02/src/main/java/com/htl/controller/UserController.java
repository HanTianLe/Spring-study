package com.htl.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 文件上传___传统方式
     */
    @RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传。。。");
        //使用fileupload组件完成文件上传
        //上传位置（位置是项目下的target/Spring_mvc_02-1.0-SNAPSHOT/upload/）
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        //判断，该路径是否存在
        File file = new File(path);
        if (!file.exists()){
            //创建该文件夹
            file.mkdir();
        }
        //解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item :items){
            if (item.isFormField()){
                //说明普通表单项
            }else {
                //说明上传文件项
                //获取上传文件的名称
                String filename = item.getName();
                //把文件的名称设置唯一值，uuid
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid+"_"+filename;
                //完成文件上传
                item.write(new File(path,filename));
                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    /**
     * 文件上传___SpringMVC方式
     */
    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("springmvc文件上传。。。");
        //使用fileupload组件完成文件上传
        //上传位置（位置是项目下的target/Spring_mvc_02-1.0-SNAPSHOT/upload/）
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        //判断，该路径是否存在
        File file = new File(path);
        if (!file.exists()){
            //创建该文件夹
            file.mkdir();
        }
        //说明上传文件项
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();
        //把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;
        //完成文件上传
        upload.transferTo(new File(path,filename));
        return "success";
    }

}
