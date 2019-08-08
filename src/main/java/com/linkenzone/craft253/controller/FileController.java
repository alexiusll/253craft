package com.linkenzone.craft253.controller;

import com.linkenzone.craft253.util.LinkenUtils;
import com.linkenzone.craft253.util.PathUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class FileController {
    @GetMapping("/download/{fileName}")
    public void download(HttpServletResponse response, @PathVariable("fileName") String fileName) {
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File("G:\\Server\\img\\" + fileName)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @ResponseBody
    @PostMapping("/upload")
    public Map upload(@RequestParam("editormd-image-file") MultipartFile file,
                      HttpServletRequest request) {

        Map result = new HashMap();

        if (file.isEmpty()) {
        }

        String fileName = file.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".")+1);
//        String filePath = "G:\\Server\\upload\\";
//        String filePath = PathUtils.getProjectPath();

        //返回当前时间
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");

        try {
            ApplicationHome h = new ApplicationHome(getClass());
            File jarF = h.getSource();
            File path = new File(jarF.getParentFile().toString()+ File.separator+"classes"+File.separator+"static"+File.separator+"img"+File.separator+"upload"+File.separator);
            if(!path.exists()){
                path.mkdir();
            }
            System.out.println(path.getAbsolutePath());

            File dest = new File(path.getAbsolutePath()+File.separator+ ft.format(dNow) + LinkenUtils.getUUID() +"."+ext);
            System.out.println(dest.getAbsolutePath());

            if(!dest.exists()){
                file.transferTo(dest);
                result.put("success", 1);
                result.put("message", "上传成功");
                result.put("url", "/253craft/img/upload/"+dest.getName());
                System.out.println(result.toString());
            }
        }
        catch (IOException e) {
        }
        return result;
    }
}
