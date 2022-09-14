package com.example.projectsem2.controller.api;

import com.example.projectsem2.Service.FileStorageService;
import com.example.projectsem2.Service.ImgService;
import com.example.projectsem2.Service.SanPhamService;
import com.example.projectsem2.dto.UploadFileResponse;
import com.example.projectsem2.dto.responseObject;
import com.example.projectsem2.entity.tblImage;
import com.example.projectsem2.entity.tblSanpham;
import com.example.projectsem2.reponsitory.ImgReposetory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api/v1/file")
public class FileController {
    Logger logger = LoggerFactory.getLogger(FileController.class);
    @Autowired
    FileStorageService fileStorageService;
    @Autowired
    ImgService imgService;
    @Autowired
    SanPhamService SanPhamService;

    @PostMapping("/uploadavatar")
    public ResponseEntity<responseObject> uploadAvatar(@RequestParam("file") MultipartFile file,
                                                       @RequestParam("idSanphamCha") Long idSanphamCha,
                                                       @RequestParam("idDanhmuc") Long idDanhmuc,
                                                       @RequestParam("idNhacungcap") Long idNhacungcap,
                                                       @RequestParam("tenSanpham") String tenSanpham ,
                                                       @RequestParam("moTa") String moTa,
                                                       @RequestParam("thuongHieu") String thuongHieu,
                                                       @RequestParam("giaBan") Double giaBan,
                                                       @RequestParam("chatLieu") String chatLieu,
                                                       @RequestParam("phanLoai") String phanLoai,
                                                       @RequestParam("mauSac") String mauSac,
                                                       @RequestParam("kichCo") String kichCo,
                                                       @RequestParam("soLuong") Long soLuong) throws Exception{
        try{


        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/file/downloadFile/")
                .path(fileName)
                .toUriString();
        tblSanpham sanpham = new tblSanpham(idSanphamCha , idDanhmuc , tenSanpham,idNhacungcap , moTa , thuongHieu , giaBan , chatLieu , phanLoai , mauSac , kichCo , soLuong , fileDownloadUri);
        tblSanpham saveSanpham = SanPhamService.addSanpham(sanpham);
        return ResponseEntity.status(HttpStatus.OK).body(new responseObject("ok" , "update success" , saveSanpham));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new responseObject("false" , "đã xảy ra lỗi ",e.getLocalizedMessage()));
        }

        }

//    @PostMapping("/uploadFile")
//    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file
//                                        ) throws Exception{
//
//        String fileName = fileStorageService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/api/v1/file/downloadFile/")
//                .path(fileName)
//                .toUriString();
//        return new UploadFileResponse(fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }




    public UploadFileResponse uploadImage(MultipartFile file , Long id) throws Exception{

        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/file/downloadFile/")
                .path(fileName)
                .toUriString();
        tblImage image = new tblImage(fileDownloadUri , id);
        imgService.addImgBySanPham(image);

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }


    @PostMapping("/api/v1/uploadMultipleFiles")
    public List<Object> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files , @RequestParam Long id) throws Exception {

        return Arrays.asList(files)
                .stream()
                .map(file -> {
                    try {
                        return uploadImage(file , id);
                    } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new responseObject("false" , "upload ảnh đã sảy ra lỗi !", e.getLocalizedMessage()));
                    }
                })
                .collect(Collectors.toList());
    }


    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<?> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws Exception {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);

    }
}
