package com.quanlybanhang.qlbh.serviceImpl;

import com.quanlybanhang.qlbh.exception.ExceptionGobal;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UploadFileService {

    public static String UploadOneFile(MultipartFile file,String fileUpload){
        String fileName = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            throw new ExceptionGobal("File Upload Thất Bại");
        }
        return fileName;
    }
}
