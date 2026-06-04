-- =============================================
-- DATABASE: inventory_db
-- =============================================
CREATE DATABASE IF NOT EXISTS inventory_db;
USE inventory_db;

-- =============================================
-- TABEL: KategoriBarang
-- =============================================
CREATE TABLE KategoriBarang (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    status ENUM('Aktif', 'Tidak Aktif') DEFAULT 'Aktif',
    keterangan TEXT
);

-- =============================================
-- TABEL: Supplier
-- =============================================
CREATE TABLE Supplier (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    nomor_telepon VARCHAR(20),
    email VARCHAR(100),
    alamat TEXT
);

-- =============================================
-- TABEL: databarang
-- =============================================
CREATE TABLE databarang (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    kategori_id VARCHAR(10),
    stok INT DEFAULT 0,
    FOREIGN KEY (kategori_id) REFERENCES KategoriBarang(id)
);

-- =============================================
-- TABEL: barangmasuk
-- =============================================
CREATE TABLE barangmasuk (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tanggal DATETIME DEFAULT CURRENT_TIMESTAMP,
    barang_id VARCHAR(10),
    kategori_id VARCHAR(10),
    supplier_id VARCHAR(10),
    jumlah INT NOT NULL,
    harga DOUBLE DEFAULT 0,
    keterangan TEXT,
    FOREIGN KEY (barang_id) REFERENCES databarang(id),
    FOREIGN KEY (kategori_id) REFERENCES KategoriBarang(id),
    FOREIGN KEY (supplier_id) REFERENCES Supplier(id)
);

-- =============================================
-- TABEL: barangkeluar
-- =============================================
CREATE TABLE barangkeluar (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tanggal DATETIME DEFAULT CURRENT_TIMESTAMP,
    barang_id VARCHAR(10),
    nama_barang VARCHAR(100),
    jumlah INT NOT NULL,
    keterangan TEXT,
    no_transaksi VARCHAR(20),
    penerima VARCHAR(100),
    qty INT,
    total_harga DOUBLE DEFAULT 0,
    kode_barang VARCHAR(10),
    FOREIGN KEY (barang_id) REFERENCES databarang(id)
);

-- =============================================
-- DATA CONTOH: KategoriBarang
-- =============================================
INSERT INTO KategoriBarang (id, name, status, keterangan) VALUES
('KAT001', 'Elektronik', 'Aktif', 'Barang elektronik'),
('KAT002', 'Alat Tulis', 'Aktif', 'Perlengkapan kantor'),
('KAT003', 'Furnitur', 'Aktif', 'Perabot kantor'),
('KAT004', 'Konsumsi', 'Tidak Aktif', 'Barang konsumsi');

-- DATA CONTOH: Supplier
INSERT INTO Supplier (id, name, nomor_telepon, email, alamat) VALUES
('SUP001', 'PT Maju Jaya', '021-1234567', 'majujaya@email.com', 'Jl. Sudirman No.1, Jakarta'),
('SUP002', 'CV Berkah Abadi', '022-7654321', 'berkah@email.com', 'Jl. Braga No.5, Bandung'),
('SUP003', 'UD Sumber Rezeki', '031-9876543', 'sumber@email.com', 'Jl. Tunjungan No.10, Surabaya');

-- DATA CONTOH: databarang
INSERT INTO databarang (id, name, kategori_id, stok) VALUES
('BRG001', 'Laptop Asus', 'KAT001', 10),
('BRG002', 'Monitor LG', 'KAT001', 5),
('BRG003', 'Pulpen Pilot', 'KAT002', 100),
('BRG004', 'Kertas A4', 'KAT002', 50),
('BRG005', 'Kursi Kantor', 'KAT003', 8);

-- DATA CONTOH: barangmasuk
INSERT INTO barangmasuk (tanggal, barang_id, kategori_id, supplier_id, jumlah, harga, keterangan) VALUES
('2025-01-10', 'BRG001', 'KAT001', 'SUP001', 5, 8000000, 'Pengadaan laptop baru'),
('2025-01-15', 'BRG002', 'KAT001', 'SUP001', 3, 2500000, 'Pengadaan monitor'),
('2025-02-01', 'BRG003', 'KAT002', 'SUP002', 50, 5000, 'Restok alat tulis'),
('2025-02-10', 'BRG004', 'KAT002', 'SUP002', 20, 50000, 'Restok kertas'),
('2025-03-01', 'BRG005', 'KAT003', 'SUP003', 4, 1500000, 'Pengadaan kursi');


-- DATA CONTOH: barangkeluar
INSERT INTO barangkeluar (tanggal, barang_id, nama_barang, jumlah, keterangan, no_transaksi, penerima, qty, total_harga, kode_barang) VALUES
('2025-01-20', 'BRG001', 'Laptop Asus', 2, 'Dipinjam divisi IT', 'TRX001', 'Divisi IT', 2, 16000000, 'BRG001'),
('2025-02-05', 'BRG003', 'Pulpen Pilot', 20, 'Distribusi ke staff', 'TRX002', 'Staff Umum', 20, 100000, 'BRG003'),
('2025-02-15', 'BRG004', 'Kertas A4', 10, 'Kebutuhan cetak', 'TRX003', 'Sekretariat', 10, 500000, 'BRG004'),
('2025-03-10', 'BRG005', 'Kursi Kantor', 2, 'Ruang rapat baru', 'TRX004', 'Divisi Umum', 2, 3000000, 'BRG005');

-- =============================================
-- TABEL: users
-- =============================================
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    nama_lengkap VARCHAR(100),
    role ENUM('superadmin', 'admin') DEFAULT 'admin',
    status ENUM('Aktif', 'Tidak Aktif') DEFAULT 'Aktif',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- =============================================
-- DATA CONTOH: users
-- =============================================
INSERT INTO users (username, password, nama_lengkap, role, status) VALUES
('superadmin', 'superadmin123', 'Super Administrator', 'superadmin', 'Aktif'),
('admin', 'admin123', 'Administrator', 'admin', 'Aktif');