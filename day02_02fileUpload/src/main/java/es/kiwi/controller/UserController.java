package es.kiwi.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 文件上传
     * @return
     */
    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传....");

        //使用fileupload组件完成文件上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建该文件夹
            file.mkdirs();
        }

        //解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        //遍历
        for (FileItem item : items) {
            //进行判断，当前item对象是否是上传文件项
            if (item.isFormField()) {
                //普通表单项
            } else {
                //说明是上传文件项
                //获取上传文件的名称
                String fileName = item.getName();
                //把文件名称设置唯一值，uuid
                String uuid = UUID.randomUUID().toString().replace("-", "");
                fileName = uuid + "_" + fileName;
                //完成文件上传
                item.write(new File(path, fileName));
                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    /**
     * springmvc方式上传
     * @param request
     * @param upload 名称和<input type="file" name="upload"/> 中的name一致
     * @return
     */
    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("SpringMVC文件上传....");

        //使用fileupload组件完成文件上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建该文件夹
            file.mkdirs();
        }

        //说明是上传文件项
        //获取上传文件的名称
        String fileName = upload.getOriginalFilename();

        //把文件名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;

        //完成文件上传
        upload.transferTo(new File(path, fileName));

        return "success";
    }

    /**
     * 跨服务器文件上传
     * 使用Jersey跨服务器上传文件出现 “405 Method Not Allowed”
     * 真正的错误原因在于：Tomcat 中没有开启权限。Tomcat 中默认情况下是会拦截 HTTP 的 PUT 和 DELETE 指令的
     * 在 Tomcat 的安装目录下的 conf/web.xml 中配置 readonly = false
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileUpload3")
    public String fileUpload3(MultipartFile upload) throws Exception {
        System.out.println("跨服务器文件上传....");

        //定义上传文件服务器路径
        String path = "http://localhost:9090/fileUploadServer/uploads/";

        //说明是上传文件项
        //获取上传文件的名称
        String fileName = upload.getOriginalFilename();

        //把文件名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;

        //创建客户端对象
        Client client = Client.create();

        //和图片服务器进行连接
        WebResource webResource = client.resource(path + fileName);

        //上传文件
        webResource.put(upload.getBytes());

        return "success";
    }
}
