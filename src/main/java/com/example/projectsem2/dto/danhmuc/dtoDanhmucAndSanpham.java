package com.example.projectsem2.dto.danhmuc;

import com.example.projectsem2.entity.tblDanhmuc;
import com.example.projectsem2.entity.tblSanpham;
import java.util.List;
public class dtoDanhmucAndSanpham {
    tblDanhmuc danhmuc;
    List<tblSanpham> sanphams;

    public dtoDanhmucAndSanpham(tblDanhmuc danhmuc, List<tblSanpham> sanphams) {
        this.danhmuc = danhmuc;
        this.sanphams = sanphams;
    }

    public tblDanhmuc getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(tblDanhmuc danhmuc) {
        this.danhmuc = danhmuc;
    }

    public List<tblSanpham> getSanphams() {
        return sanphams;
    }

    public void setSanphams(List<tblSanpham> sanphams) {
        this.sanphams = sanphams;
    }
}
