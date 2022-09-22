package com.example.projectsem2.controller.api;

import com.example.projectsem2.Service.FileStorageService;
import com.example.projectsem2.Service.ImgService;
import com.example.projectsem2.Service.SanPhamService;
import com.example.projectsem2.comman.GenaricClass;
import com.example.projectsem2.dto.UploadFileResponse;
import com.example.projectsem2.dto.responseObject;
import com.example.projectsem2.entity.tblImage;
import com.example.projectsem2.entity.tblSanpham;
import com.example.projectsem2.reponsitory.ImgReposetory;
import com.example.projectsem2.reponsitory.SanPhamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
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


@RestController
@RequestMapping("/api/v1/file")
public class FileController {
    Logger logger = LoggerFactory.getLogger(FileController.class);
    @Autowired
    FileStorageService fileStorageService;
    @Autowired
    ImgService imgService;
    @Autowired
    SanPhamRepository sanPhamRepository;


    @PostMapping("/uploadChitietsanpham")
    public ResponseEntity<responseObject> uploadChitietsanpham(@RequestParam("idSanphamCha") Long idSanphamCha,
                                                               @RequestParam("kichCo") String kichCo,
                                                               @RequestParam("mauSac") String mauSac,
                                                               @RequestParam("soLuong") Long soLuong){



        try{

           Optional<tblSanpham> sanphamOptional =  sanPhamRepository.findById(idSanphamCha);
            if (sanphamOptional.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new responseObject("false" , "Đã sảy ra lỗi !", "Sản phẩm không tồn tại"));
            }
            tblSanpham sanpham = new tblSanpham();
            sanpham.setChatLieu(sanphamOptional.get().getChatLieu());
            sanpham.setGiaBan(sanphamOptional.get().getGiaBan());
            sanpham.setImg(sanphamOptional.get().getImg());
            sanpham.setPhanLoai(sanphamOptional.get().getPhanLoai());
            sanpham.setIdSanphamCha(idSanphamCha);
            sanpham.setIdDanhmuc(sanphamOptional.get().getIdDanhmuc());
            sanpham.setTenSanPham(sanphamOptional.get().getTenSanPham());
            sanpham.setMoTa(sanphamOptional.get().getMoTa());
            sanpham.setThuongHieu(sanphamOptional.get().getThuongHieu());
            sanpham.setMauSac(mauSac.toUpperCase(Locale.ROOT));
            sanpham.setKichCo(kichCo.toUpperCase(Locale.ROOT));
            sanpham.setSoLuong(soLuong);
            sanpham.setNgayTao(GenaricClass.dateTimeNow());

            tblSanpham tblSanpham = sanPhamRepository.save(sanpham);

            return ResponseEntity.status(HttpStatus.OK).body(new responseObject("ok" , "Thêm sản phẩm thành công",tblSanpham));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new responseObject("false" , "upload ảnh đã sảy ra lỗi !", ex.getLocalizedMessage()));
        }
    }
    @PostMapping("/uploadavatar")
    public ResponseEntity<responseObject> uploadAvatar(@RequestParam("file")MultipartFile file,
                                                       @RequestParam("idDanhmuc") Long idDanhmuc,
                                                       @RequestParam("tenSanpham") String tenSanpham ,
                                                       @RequestParam("moTa") String moTa,
                                                       @RequestParam("thuongHieu") String thuongHieu,
                                                       @RequestParam("giaBan") String giaBan,
                                                       @RequestParam("chatLieu") String chatLieu,
                                                       @RequestParam("phanLoai") String phanLoai) {
        try{
            tblSanpham sanpham = new tblSanpham();
            sanpham.setIdDanhmuc(idDanhmuc);
            sanpham.setTenSanPham(tenSanpham);
            sanpham.setMoTa(moTa);
            sanpham.setThuongHieu(thuongHieu);
            sanpham.setGiaBan(Double.parseDouble(giaBan));
            sanpham.setChatLieu(chatLieu);
            sanpham.setPhanLoai(phanLoai);
            sanpham.setNgayTao(GenaricClass.dateTimeNow());

            String fileName = fileStorageService.storeFile(file);

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/v1/file/downloadFile/")
                    .path(fileName)
                    .toUriString();
            sanpham.setImg(fileDownloadUri);



            tblSanpham tblSanpham = sanPhamRepository.save(sanpham);

            System.out.println(" thành công");

            return ResponseEntity.status(HttpStatus.OK).body(new responseObject("ok" , "Thêm sản phẩm thành công",tblSanpham));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new responseObject("false" , "upload ảnh đã sảy ra lỗi !", ex.getLocalizedMessage()));
        }

        }




    @PostMapping("/uploadFile")
    public List<Object> uploadFile(@RequestParam("files") MultipartFile[] files ,
                                            @RequestParam("idSanphamCha") String idSanphamCha,
                                            @RequestParam("idDanhmuc") String idDanhmuc,
                                            @RequestParam("idNhacungcap") String idNhacungcap,
                                            @RequestParam("tenSanpham") String tenSanpham ,
                                            @RequestParam("moTa") String moTa,
                                            @RequestParam("thuongHieu") String thuongHieu,
                                            @RequestParam("giaBan") String giaBan,
                                            @RequestParam("chatLieu") String chatLieu,
                                            @RequestParam("phanLoai") String phanLoai,
                                            @RequestParam("soLuong") String soLuong
                                            ) throws Exception {
        tblSanpham sanpham = new tblSanpham();
        sanpham.setIdSanphamCha(Long.parseLong(idSanphamCha));
        sanpham.setIdDanhmuc(Long.parseLong(idDanhmuc));
        sanpham.setIdNhacungcap(Long.parseLong(idNhacungcap));
        sanpham.setTenSanPham(tenSanpham);
        sanpham.setMoTa(moTa);
        sanpham.setThuongHieu(thuongHieu);
        sanpham.setGiaBan(Double.parseDouble(giaBan));
        sanpham.setChatLieu(chatLieu);
        sanpham.setPhanLoai(phanLoai);
        sanpham.setSoLuong(Long.parseLong(soLuong));
        sanpham.setNgayTao(GenaricClass.dateTimeNow());
        return Arrays.asList(files)
                .stream()
                .map(file -> {
                    try {
                        return uploadProduct(file , sanpham);
                    } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new responseObject("false" , "upload ảnh đã sảy ra lỗi !", e.getLocalizedMessage()));
                    }
                })
                .collect(Collectors.toList());

    }

    public tblSanpham uploadProduct(MultipartFile file , tblSanpham NewSanPham) throws Exception{

        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/file/downloadFile/")
                .path(fileName)
                .toUriString();
        NewSanPham.setImg(fileDownloadUri);

        return null;
    }




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


    @PostMapping("/uploadMultipleFiles")
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
