--DROP DATABASE clothes

GO--
 CREATE DATABASE clothes
 Go--
 USE clothes



-- TABLE GROUP
GO--
CREATE TABLE [role](
    id_role BIGINT PRIMARY KEY IDENTITY(1,1),
	ten_role VARCHAR(50) UNIQUE,
    ngay_tao DATETIME DEFAULT(GETDATE()),
    ngay_chinh_sua DATETIME,)

--insert



-- TABLE NGUOI-DUNG
GO--
CREATE TABLE nguoidung
(
    id_nguoidung   BIGINT PRIMARY KEY IDENTITY(1,1),
    email          NVARCHAR(120) UNIQUE,
    dien_thoai     NVARCHAR(15),
    password       NVARCHAR(500),
    trang_thai     NVARCHAR(20),
    loai_tai_khoan NVARCHAR(20),
    ngay_tao       DATETIME DEFAULT (GETDATE()),
    ngay_chinh_sua DATETIME,
)

--TABLE GROUP_NGUOIDUNG

GO--
CREATE TABLE role_nguoidung
(
    id_role_nguoidung BIGINT PRIMARY KEY IDENTITY(1,1),
    id_nguoidung       BIGINT,
    id_role        BIGINT,
    ngay_tao           DATETIME DEFAULT (GETDATE()),
    ngay_chinh_sua     DATETIME,

    CONSTRAINT FK_NGUOIDUNG FOREIGN KEY (id_nguoidung) REFERENCES nguoidung(id_nguoidung),
    CONSTRAINT FK_ROLE FOREIGN KEY (id_role) REFERENCES [role](id_role)

)


--TABLE DIA-CHI-GIAO-HANG
    GO--
CREATE TABLE diachigiaohang
(
    id_diachigiaohang BIGINT PRIMARY KEY IDENTITY(1,1),
    id_nguoidung      BIGINT,
    ten_nguoi_nhan    NVARCHAR(50),
    dia_chi           NVARCHAR(10),
    dien_thoai        VARCHAR(15),
    ngay_tao          DATETIME DEFAULT (GETDATE()) ,
    ngay_chinh_sua    DATETIME,
	CONSTRAINT FK_NGUOIDUNG_DIACHIGIAOHANG FOREIGN KEY (id_nguoidung) REFERENCES nguoidung (id_nguoidung),
)

-- TABLE Voucher
    GO--
CREATE TABLE voucher
(
    id_voucher     BIGINT PRIMARY KEY IDENTITY(1,1),
    id_nguoidung   BIGINT,
    ngay_bat_dau   DATETIME,
    ngay_ket_thuc  DATETIME,
    dieu_kien      VARCHAR(255),
    tri_gia        FLOAT,
    noi_dung       NTEXT,
    ngay_tao       DATETIME DEFAULT (GETDATE()),
    ngay_chinh_sua DATETIME,
    CONSTRAINT FK_NGUOIDUNG_VOUCHER FOREIGN KEY (id_nguoidung) REFERENCES nguoidung (id_nguoidung),
)

--TABLE danh muc
GO--
CREATE TABLE danhmuc
(
    id_danhmuc     BIGINT PRIMARY KEY IDENTITY(1,1),
    id_danhmuc_cha BIGINT,
    ten_danh_muc   NVARCHAR(100)                 ,
    mo_ta          NTEXT,
    ngay_tao       DATETIME DEFAULT (GETDATE()),
    ngay_chinh_sua DATETIME,

    CONSTRAINT FK_DANHMUC_CHA FOREIGN KEY (id_danhmuc_cha) REFERENCES danhmuc (id_danhmuc),
)


-- TABLE NHA CUNG CAP
GO--
CREATE TABLE nhacungcap
(
    id_nhacungcap  BIGINT PRIMARY KEY IDENTITY(1,1),
    ten_nhacungcap NVARCHAR(255)                 ,
    dia_chi        NVARCHAR(120)                 ,
    dien_thoai     VARCHAR(15),
    ngay_tao       DATETIME DEFAULT (GETDATE()),
    ngay_chinh_sua DATETIME,
)


-- TABLE  SAN PHAM 
    GO--
CREATE TABLE sanpham
(
    id_sanpham     BIGINT IDENTITY(1,1) PRIMARY KEY,
    id_nhacungcap  BIGINT,
    id_danhmuc     BIGINT,
	img			varchar(500) ,
	ten_san_pham NVARCHAR(255),
	mo_ta NTEXT,
	thuong_hieu NVARCHAR(50),
    ngay_tao          DATETIME DEFAULT (GETDATE()),
    ngay_chinh_sua    DATETIME,

    CONSTRAINT FK_DANHMUC FOREIGN KEY (id_danhmuc) REFERENCES danhmuc (id_danhmuc),
    CONSTRAINT FK_NHACUNGCAP FOREIGN KEY (id_nhacungcap) REFERENCES nhacungcap (id_nhacungcap),
)

GO--
CREATE TABLE chitietsanpham(
id_chitietsanpham BIGINT PRIMARY KEY IDENTITY(1,1),
id_sanpham BIGINT,
phan_loai NVARCHAR(50),
mau_sac NVARCHAR(50),
kich_co VARCHAR(10),
chat_lieu NVARCHAR(100),
so_luong INT,
gia_ban DECIMAL(15),
ngay_tao DATETIME DEFAULT(GETDATE()),
ngay_chinh_sua DATETIME,
CONSTRAINT FK_SANPHAM_CHITIETSANPHAM FOREIGN KEY (id_sanpham) REFERENCES sanpham (id_sanpham),
)

-- TABLE IMAGE
GO--
CREATE TABLE [image]
(
    id_image          BIGINT PRIMARY KEY IDENTITY(1,1),
    id_chitietsanpham BIGINT ,
    ten_anh           VARCHAR(150),
    CONSTRAINT FK_CHITIETSANPAM_IMG FOREIGN KEY (id_chitietsanpham) REFERENCES chitietsanpham (id_chitietsanpham),
)

--TABLE GIO HANG 
    GO-- 
CREATE TABLE giohang
(
    id_giohang        BIGINT PRIMARY KEY IDENTITY(1,1),
    id_nguoidung      BIGINT,
    id_chitietsanpham BIGINT,
    so_luong          INT,
    gia               DECIMAL(15),
	chot				varchar(50),
    CONSTRAINT FK_NGUOIDUNG_GIOHANG FOREIGN KEY (id_nguoidung) REFERENCES nguoidung (id_nguoidung),
    CONSTRAINT FK_GIOHANG_NGUOIDUNG FOREIGN KEY (id_chitietsanpham) REFERENCES chitietsanpham (id_chitietsanpham),
)

--TABLE DON HANG
    GO--
CREATE TABLE donhang
(
    id_donhang             VARCHAR(50) PRIMARY KEY,
    id_nguoidung           BIGINT,
    id_diachigiaohang      BIGINT,
    ghi_chu                NTEXT,
    trang_thai             NVARCHAR(50),
    ngay_tao               DATETIME DEFAULT (GETDATE()),
    ngay_chinh_sua         DATETIME,
    ngay_du_kien_giao_hang DATE,
	CONSTRAINT FK_DONHANG_NGUOIDUNG FOREIGN KEY (id_nguoidung) REFERENCES nguoidung (id_nguoidung),
)


    GO--
CREATE TABLE chitietdonhang
(
    id_chitietdonhang BIGINT PRIMARY KEY IDENTITY(1,1),
	id_donhang        VARCHAR(50),
    id_chitietsanpham BIGINT,
    so_luong          INT,
    gia               DECIMAL(15),
    ngay_tao          DATETIME DEFAULT (GETDATE()),
    ngay_chinh_sua    DATETIME,
    CONSTRAINT FK_CHITIETSANPAM_CHITIETDONHANG FOREIGN KEY (id_chitietsanpham) REFERENCES chitietsanpham (id_chitietsanpham),
	CONSTRAINT FK_CHITIETSANPAM_DONHANG FOREIGN KEY (id_donhang) REFERENCES donhang (id_donhang),
)



