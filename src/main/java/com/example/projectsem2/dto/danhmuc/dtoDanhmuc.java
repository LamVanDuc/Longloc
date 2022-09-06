package com.example.projectsem2.dto.danhmuc;

import com.example.projectsem2.entity.tblDanhmuc;
import java.util.List;


public class dtoDanhmuc {
    tblDanhmuc danhmuccha;
    List<tblDanhmuc> danhmuccon;

    public dtoDanhmuc(tblDanhmuc danhmuccha, List<tblDanhmuc> danhmuccon) {
        this.danhmuccha = danhmuccha;
        this.danhmuccon = danhmuccon;
    }


    public tblDanhmuc getDanhmuccha() {
        return danhmuccha;
    }

    public void setDanhmuccha(tblDanhmuc danhmuccha) {
        this.danhmuccha = danhmuccha;
    }

    public List<tblDanhmuc> getDanhmuccon() {
        return danhmuccon;
    }

    public void setDanhmuccon(List<tblDanhmuc> danhmuccon) {
        this.danhmuccon = danhmuccon;
    }
}
