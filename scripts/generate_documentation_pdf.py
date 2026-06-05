from __future__ import annotations

import os
import re
from datetime import datetime
from pathlib import Path

from reportlab.lib import colors
from reportlab.lib.enums import TA_CENTER, TA_LEFT
from reportlab.lib.pagesizes import A4, landscape
from reportlab.lib.styles import ParagraphStyle, getSampleStyleSheet
from reportlab.lib.units import cm
from reportlab.platypus import (
    BaseDocTemplate,
    Frame,
    Image,
    KeepTogether,
    NextPageTemplate,
    PageBreak,
    PageTemplate,
    Paragraph,
    Preformatted,
    Spacer,
    Table,
    TableStyle,
)
from reportlab.platypus.tableofcontents import TableOfContents


ROOT = Path(__file__).resolve().parents[1]
OUT_DIR = ROOT / "docs"
OUT_FILE = OUT_DIR / "Dokumentasi_InventoryApp.pdf"

SOURCE_EXTENSIONS = {
    ".java",
    ".form",
    ".sql",
    ".xml",
    ".properties",
    ".mf",
    ".pom",
}

IMPORTANT_FILES = {
    "src/config/koneksi.java": "Koneksi database utama. Semua fitur yang membaca atau menulis data memakai method getConnection() dari file ini.",
    "src/view/auth/login.java": "Form login. Input berasal dari username dan password, lalu dicek ke tabel users. Output sukses adalah membuka Dashboard, output gagal adalah pesan error.",
    "src/view/dashboard/Dashboard.java": "Frame utama aplikasi. Mengatur menu, card ringkasan, chart, dan panel konten dengan CardLayout.",
    "src/view/dashboard/BarangMasuk.java": "Panel daftar barang masuk. Membaca tabel barangmasuk, databarang, dan supplier, lalu menampilkan hasil ke JTable.",
    "src/component/Barmas.java": "Dialog tambah barang masuk. Input berasal dari tanggal, kode barang, supplier, qty, harga/keterangan; outputnya insert barangmasuk dan refresh tabel.",
    "src/component/Ebamas.java": "Dialog edit barang masuk. Dipakai untuk mengubah data transaksi masuk bila fitur edit disambungkan.",
    "src/view/dashboard/BarangKeluar.java": "Panel daftar barang keluar. Menampilkan transaksi barang keluar dan membuka dialog tambah barang keluar.",
    "src/component/Barker.java": "Dialog tambah barang keluar. Input berasal dari kode barang, qty, penerima, total harga, dan keterangan; outputnya insert transaksi barang keluar.",
    "src/view/dashboard/DataBarang.java": "Panel data master barang. Menampilkan data dari databarang dan membuka form tambah barang.",
    "src/component/TambahBarang.java": "Dialog tambah barang master. Input nama/kode/kategori/stok disimpan ke databarang.",
    "src/view/dashboard/kategori.java": "Panel master kategori. Memuat, mencari, menambah, mengedit, dan menghapus kategori barang.",
    "src/component/TambahKategori.java": "Dialog tambah kategori. Input user disimpan ke tabel KategoriBarang.",
    "src/view/dashboard/Supplier.java": "Panel master supplier. Memuat dan menghapus supplier, serta membuka dialog tambah supplier.",
    "src/component/Supler.java": "Dialog tambah supplier. Input user disimpan ke tabel Supplier.",
    "src/view/dashboard/UserManagement.java": "Panel kelola user. Memuat user, mencari, tambah, edit, dan hapus akun aplikasi.",
    "src/Laporan.java": "Halaman laporan. Mengambil data ringkasan, barang masuk, barang keluar, kartu stok, barang terlaris, stok terendah, dan ekspor PDF.",
    "src/chart/ChartBarang.java": "Membuat grafik perbandingan barang masuk dan barang keluar memakai JFreeChart.",
    "database/schema.sql": "Struktur database, relasi tabel, dan data contoh awal aplikasi.",
}

ACTION_PATTERNS = [
    ("Login", ["login", "username", "password", "users"]),
    ("Navigasi Dashboard", ["CardLayout", "show(", "pn_content"]),
    ("Tambah Barang Masuk", ["INSERT INTO barangmasuk", "jButton_simpanActionPerformed"]),
    ("Tampil Barang Masuk", ["FROM barangmasuk", "loadTable"]),
    ("Tambah Barang Keluar", ["INSERT INTO barangkeluar", "INSERT INTO barang_keluar"]),
    ("Tampil Barang Keluar", ["FROM barangkeluar", "table_barangkeluar"]),
    ("Kelola Barang", ["databarang", "TambahBarang"]),
    ("Kelola Kategori", ["KategoriBarang", "TambahKategori"]),
    ("Kelola Supplier", ["Supplier", "Supler"]),
    ("Kelola User", ["users", "UserManagement"]),
    ("Laporan", ["tblLaporanUtama", "tampilBarangMasuk", "tulisTabelKePdf"]),
]


class Doc(BaseDocTemplate):
    def __init__(self, filename: Path):
        super().__init__(
            str(filename),
            pagesize=A4,
            rightMargin=1.4 * cm,
            leftMargin=1.4 * cm,
            topMargin=1.5 * cm,
            bottomMargin=1.4 * cm,
            title="Dokumentasi InventoryApp",
            author="Codex",
        )
        frame = Frame(self.leftMargin, self.bottomMargin, self.width, self.height, id="normal")
        landscape_frame = Frame(
            self.bottomMargin,
            self.leftMargin,
            landscape(A4)[0] - 2.8 * cm,
            landscape(A4)[1] - 2.8 * cm,
            id="landscape",
        )
        self.addPageTemplates(
            [
                PageTemplate(id="portrait", frames=[frame], onPage=draw_page),
                PageTemplate(id="landscape", pagesize=landscape(A4), frames=[landscape_frame], onPage=draw_page),
            ]
        )

    def afterFlowable(self, flowable):
        if isinstance(flowable, Paragraph):
            text = flowable.getPlainText()
            style_name = flowable.style.name
            if style_name == "Heading1":
                self.notify("TOCEntry", (0, text, self.page))
            elif style_name == "Heading2":
                self.notify("TOCEntry", (1, text, self.page))


def draw_page(canvas, doc):
    canvas.saveState()
    canvas.setFont("Helvetica", 8)
    canvas.setFillColor(colors.HexColor("#555555"))
    canvas.drawString(doc.leftMargin, 0.7 * cm, "InventoryApp - Dokumentasi Teknis")
    canvas.drawRightString(doc.pagesize[0] - doc.rightMargin, 0.7 * cm, f"Halaman {doc.page}")
    canvas.restoreState()


def p(text: str) -> str:
    return (
        str(text)
        .replace("&", "&amp;")
        .replace("<", "&lt;")
        .replace(">", "&gt;")
        .replace("\n", "<br/>")
    )


def compact_cell(text: str, max_chars: int = 900) -> str:
    text = str(text)
    lines = [line.strip() for line in text.splitlines() if line.strip()]
    if len(lines) > 10:
        lines = lines[:10] + ["..."]
    compacted = "\n".join(lines) if lines else text.strip()
    if len(compacted) > max_chars:
        compacted = compacted[:max_chars].rstrip() + "..."
    return compacted


def read_text(path: Path) -> str:
    for encoding in ("utf-8", "cp1252", "latin-1"):
        try:
            return path.read_text(encoding=encoding)
        except UnicodeDecodeError:
            continue
    return ""


def rel(path: Path) -> str:
    return path.relative_to(ROOT).as_posix()


def list_project_files() -> list[Path]:
    ignored_parts = {".git", "build", "dist", "target", "docs"}
    files = []
    for path in ROOT.rglob("*"):
        if not path.is_file():
            continue
        if any(part in ignored_parts for part in path.relative_to(ROOT).parts):
            continue
        files.append(path)
    return sorted(files, key=lambda item: rel(item).lower())


def source_files() -> list[Path]:
    files = []
    for path in list_project_files():
        suffix = path.suffix.lower()
        if suffix in SOURCE_EXTENSIONS or path.name in {"pom.xml", "build.xml", "manifest.mf"}:
            files.append(path)
    return files


def extract_methods(text: str) -> list[str]:
    pattern = re.compile(
        r"(?m)^\s*(public|private|protected)\s+(?:static\s+)?(?:final\s+)?[\w<>\[\].?]+\s+(\w+)\s*\([^)]*\)\s*(?:throws\s+[^{]+)?\{"
    )
    return [match.group(2) for match in pattern.finditer(text)]


def extract_classes(text: str) -> list[str]:
    return re.findall(r"\b(?:public\s+)?class\s+(\w+)", text)


def extract_sql(text: str) -> list[str]:
    found = []
    for keyword in ("SELECT", "INSERT", "UPDATE", "DELETE", "CREATE TABLE"):
        if keyword in text.upper():
            snippets = re.findall(r'"([^"]*(?:' + keyword + r')[^"]*)"', text, flags=re.IGNORECASE)
            found.extend(snippets[:6])
    return [item.strip() for item in found if item.strip()]


def extract_inputs(text: str) -> list[str]:
    patterns = [
        r"(\w+)\.getText\(\)",
        r"(\w+)\.getSelectedItem\(\)",
        r"(\w+)\.getDate\(\)",
        r"(\w+)\.getValueAt\(",
    ]
    inputs = []
    for pattern in patterns:
        inputs.extend(re.findall(pattern, text))
    return sorted(set(inputs))


def extract_outputs(text: str) -> list[str]:
    outputs = []
    for message in re.findall(r"showMessageDialog\([^,]+,\s*\"([^\"]+)\"", text):
        outputs.append("Pesan: " + message)
    if ".setModel(" in text or ".addRow(" in text:
        outputs.append("Tampilan tabel diperbarui")
    if ".setText(" in text:
        outputs.append("Field/label UI diisi atau diubah")
    if "executeUpdate()" in text:
        outputs.append("Database berubah melalui INSERT/UPDATE/DELETE")
    if "executeQuery(" in text:
        outputs.append("Data dibaca dari database")
    return sorted(set(outputs))


def explain_file(path: Path, text: str) -> str:
    key = rel(path)
    if key in IMPORTANT_FILES:
        return IMPORTANT_FILES[key]
    if path.suffix == ".form":
        return "File layout NetBeans GUI Builder. Berisi definisi komponen visual, posisi, properti, dan event handler yang terhubung ke file .java pasangan."
    if path.suffix == ".java":
        classes = ", ".join(extract_classes(text)) or "kelas Java"
        return f"Source Java untuk {classes}. File ini berisi logika UI, event, atau helper sesuai nama paketnya."
    if path.suffix == ".sql":
        return "Script SQL untuk membuat tabel, relasi, dan data awal."
    if path.name in {"pom.xml", "build.xml", "project.xml", "project.properties"}:
        return "File konfigurasi build/proyek NetBeans, Ant, atau Maven."
    if path.suffix.lower() in {".png", ".jpg", ".jpeg"}:
        return "Asset gambar yang dipakai oleh tampilan aplikasi."
    return "File pendukung project."


def action_sources(files: list[Path]) -> list[list[str]]:
    rows = []
    text_cache = {rel(path): read_text(path) for path in files if path.suffix.lower() in {".java", ".form", ".sql"}}
    for name, tokens in ACTION_PATTERNS:
        matched = []
        for file_rel, text in text_cache.items():
            if any(token.lower() in text.lower() for token in tokens):
                matched.append(file_rel)
        rows.append([name, "\n".join(matched[:8]) or "-", "Database, field form, JTable, tombol, combo box, atau tanggal sesuai fitur.", action_output(name)])
    return rows


def action_output(name: str) -> str:
    outputs = {
        "Login": "Dashboard terbuka jika valid; pesan gagal jika akun tidak cocok.",
        "Navigasi Dashboard": "Panel konten berpindah tanpa membuka window baru.",
        "Tambah Barang Masuk": "Data masuk tersimpan, stok bertambah jika kode menjalankan update stok, tabel barang masuk direfresh.",
        "Tampil Barang Masuk": "JTable menampilkan tanggal, kode barang, supplier, qty, total harga, dan keterangan.",
        "Tambah Barang Keluar": "Transaksi keluar tersimpan, total harga dihitung, stok dapat berkurang sesuai implementasi.",
        "Tampil Barang Keluar": "JTable barang keluar menampilkan transaksi keluar.",
        "Kelola Barang": "Data master barang tampil/bertambah/berubah/terhapus sesuai aksi yang tersedia.",
        "Kelola Kategori": "Kategori tampil/bertambah/berubah/terhapus; pesan sukses/gagal muncul.",
        "Kelola Supplier": "Supplier tampil/bertambah/terhapus; pesan sukses/gagal muncul.",
        "Kelola User": "User tampil, dicari, ditambah, diedit, atau dihapus; tabel direfresh.",
        "Laporan": "Tabel laporan berubah sesuai filter; ekspor PDF dibuat oleh OpenPDF.",
    }
    return outputs.get(name, "-")


def make_styles():
    base = getSampleStyleSheet()
    return {
        "Title": ParagraphStyle(
            "Title",
            parent=base["Title"],
            fontName="Helvetica-Bold",
            fontSize=22,
            leading=28,
            alignment=TA_CENTER,
            textColor=colors.HexColor("#153E75"),
            spaceAfter=14,
        ),
        "Subtitle": ParagraphStyle(
            "Subtitle",
            parent=base["BodyText"],
            fontName="Helvetica",
            fontSize=10,
            leading=14,
            alignment=TA_CENTER,
            textColor=colors.HexColor("#333333"),
            spaceAfter=18,
        ),
        "Heading1": ParagraphStyle(
            "Heading1",
            parent=base["Heading1"],
            fontName="Helvetica-Bold",
            fontSize=16,
            leading=20,
            textColor=colors.HexColor("#153E75"),
            spaceBefore=12,
            spaceAfter=8,
        ),
        "Heading2": ParagraphStyle(
            "Heading2",
            parent=base["Heading2"],
            fontName="Helvetica-Bold",
            fontSize=12,
            leading=15,
            textColor=colors.HexColor("#1D4ED8"),
            spaceBefore=9,
            spaceAfter=5,
        ),
        "Body": ParagraphStyle(
            "Body",
            parent=base["BodyText"],
            fontName="Helvetica",
            fontSize=9,
            leading=12,
            textColor=colors.HexColor("#222222"),
            spaceAfter=5,
        ),
        "Small": ParagraphStyle(
            "Small",
            parent=base["BodyText"],
            fontName="Helvetica",
            fontSize=7,
            leading=9,
            textColor=colors.HexColor("#222222"),
        ),
        "Code": ParagraphStyle(
            "Code",
            parent=base["Code"],
            fontName="Courier",
            fontSize=7,
            leading=9,
            leftIndent=6,
            rightIndent=6,
            spaceBefore=3,
            spaceAfter=6,
        ),
    }


def table(data, widths=None, font_size=7, header=True):
    converted = []
    small = STYLES["Small"]
    for row in data:
        converted.append([Paragraph(p(compact_cell(cell)), small) for cell in row])
    tbl = Table(converted, colWidths=widths, repeatRows=1 if header else 0, hAlign="LEFT")
    style = [
        ("FONTNAME", (0, 0), (-1, -1), "Helvetica"),
        ("FONTSIZE", (0, 0), (-1, -1), font_size),
        ("VALIGN", (0, 0), (-1, -1), "TOP"),
        ("LEFTPADDING", (0, 0), (-1, -1), 4),
        ("RIGHTPADDING", (0, 0), (-1, -1), 4),
        ("TOPPADDING", (0, 0), (-1, -1), 4),
        ("BOTTOMPADDING", (0, 0), (-1, -1), 4),
        ("GRID", (0, 0), (-1, -1), 0.25, colors.HexColor("#D0D7DE")),
    ]
    if header:
        style.extend(
            [
                ("BACKGROUND", (0, 0), (-1, 0), colors.HexColor("#E8F0FE")),
                ("TEXTCOLOR", (0, 0), (-1, 0), colors.HexColor("#153E75")),
                ("FONTNAME", (0, 0), (-1, 0), "Helvetica-Bold"),
            ]
        )
    tbl.setStyle(TableStyle(style))
    return tbl


def add_paragraph(story, text, style="Body"):
    story.append(Paragraph(p(text), STYLES[style]))


def add_heading(story, text, level=1):
    story.append(Paragraph(p(text), STYLES["Heading1" if level == 1 else "Heading2"]))


def build_pdf():
    OUT_DIR.mkdir(exist_ok=True)
    files = list_project_files()
    sources = source_files()

    story = []
    story.append(Paragraph("Dokumentasi Teknis InventoryApp", STYLES["Title"]))
    story.append(
        Paragraph(
            p(
                "Penjelasan per file, alur input, aksi, output, query database, dan fungsi penting. "
                f"Dibuat otomatis dari source project pada {datetime.now().strftime('%d-%m-%Y %H:%M')}."
            ),
            STYLES["Subtitle"],
        )
    )
    story.append(Spacer(1, 0.3 * cm))

    toc = TableOfContents()
    toc.levelStyles = [
        ParagraphStyle("TOC1", fontName="Helvetica-Bold", fontSize=9, leading=12, leftIndent=0),
        ParagraphStyle("TOC2", fontName="Helvetica", fontSize=8, leading=10, leftIndent=12),
    ]
    add_heading(story, "Daftar Isi", 1)
    story.append(toc)
    story.append(PageBreak())

    add_heading(story, "Ringkasan Project", 1)
    add_paragraph(
        story,
        "InventoryApp adalah aplikasi desktop Java Swing untuk pengelolaan inventaris. "
        "Project memakai NetBeans GUI Builder, Ant build, JDBC, database inventory_db, JFreeChart untuk grafik, "
        "JCalendar untuk input tanggal, dan OpenPDF untuk ekspor laporan.",
    )
    summary_rows = [
        ["Bagian", "Isi"],
        ["Total file project yang dibaca", str(len(files))],
        ["Total file source/konfigurasi yang dijelaskan", str(len(sources))],
        ["Database utama", "inventory_db"],
        ["Tabel utama", "KategoriBarang, Supplier, databarang, barangmasuk, barangkeluar, users"],
        ["Pola UI", "JFrame Dashboard + JPanel halaman + JDialog form tambah/edit"],
    ]
    story.append(table(summary_rows, [5 * cm, 11 * cm]))
    story.append(Spacer(1, 0.3 * cm))

    add_heading(story, "Alur Input, Aksi, dan Output", 1)
    add_paragraph(
        story,
        "Bagian ini menjawab dari mana input berasal, aksi apa yang dijalankan, dan output apa yang hadir di layar atau database.",
    )
    story.append(
        table(
            [["Aksi", "File yang terlibat", "Sumber input", "Output yang hadir"]] + action_sources(sources),
            [3.1 * cm, 5.1 * cm, 4.2 * cm, 4.3 * cm],
        )
    )
    story.append(PageBreak())

    add_heading(story, "Database dan Relasi", 1)
    schema = read_text(ROOT / "database" / "schema.sql")
    table_names = re.findall(r"CREATE TABLE\s+(\w+)", schema, flags=re.IGNORECASE)
    db_rows = [["Tabel", "Fungsi", "Input penting", "Output data"]]
    db_notes = {
        "KategoriBarang": ["Master kategori barang", "id, name, status, keterangan", "Dipakai oleh barang dan laporan stok"],
        "Supplier": ["Master pemasok", "id, name, nomor_telepon, email, alamat", "Dipakai transaksi barang masuk"],
        "databarang": ["Master barang dan stok", "id, name, kategori_id, stok", "Dipakai transaksi masuk/keluar dan dashboard"],
        "barangmasuk": ["Transaksi barang masuk", "tanggal, barang_id, supplier_id, jumlah, harga, keterangan", "Tampil di tabel masuk dan laporan"],
        "barangkeluar": ["Transaksi barang keluar", "tanggal, barang_id, jumlah, total_harga, penerima, keterangan", "Tampil di tabel keluar dan laporan"],
        "users": ["Akun aplikasi", "username, password, nama_lengkap, role, status", "Dipakai login dan user management"],
    }
    for name in table_names:
        note = db_notes.get(name, ["-", "-", "-"])
        db_rows.append([name, *note])
    story.append(table(db_rows, [3 * cm, 4.4 * cm, 4.8 * cm, 4.8 * cm]))

    add_heading(story, "Perubahan Terakhir yang Sudah Diperbaiki", 1)
    add_paragraph(
        story,
        "Pada BarangMasuk.java, urutan kolom data sudah disamakan dengan header tabel. "
        "Kolom Total Qty sekarang memakai renderer rata tengah. Auto resize tabel dimatikan dan lebar kolom ditetapkan agar horizontal scroll muncul untuk membaca Keterangan.",
    )
    story.append(PageBreak())

    add_heading(story, "Penjelasan Per File Source", 1)
    for path in sources:
        text = read_text(path)
        path_rel = rel(path)
        add_heading(story, path_rel, 2)
        add_paragraph(story, explain_file(path, text))
        rows = [["Item", "Hasil pembacaan kode"]]
        classes = extract_classes(text)
        methods = extract_methods(text)
        sqls = extract_sql(text)
        inputs = extract_inputs(text)
        outputs = extract_outputs(text)
        rows.append(["Class", ", ".join(classes) if classes else "-"])
        rows.append(["Method/event penting", ", ".join(methods[:24]) if methods else "-"])
        rows.append(["Sumber input", ", ".join(inputs[:30]) if inputs else "Tidak ada input langsung atau hanya konfigurasi/layout"])
        rows.append(["Output/efek", "\n".join(outputs[:12]) if outputs else "Tidak ada output runtime langsung atau hanya file pendukung"])
        if sqls:
            rows.append(["Query/SQL terdeteksi", "\n".join(sqls[:8])])
        story.append(table(rows, [4 * cm, 12.5 * cm], header=True))
        if path.suffix == ".java":
            preview_lines = []
            for line in text.splitlines():
                stripped = line.strip()
                if any(token in stripped for token in ("SELECT ", "INSERT ", "UPDATE ", "DELETE ", "showMessageDialog", "addActionListener", "setText(", "addRow(")):
                    preview_lines.append(stripped)
                if len(preview_lines) >= 10:
                    break
            if preview_lines:
                story.append(Preformatted("\n".join(preview_lines), STYLES["Code"]))
        story.append(Spacer(1, 0.2 * cm))

    story.append(PageBreak())
    add_heading(story, "Daftar Semua File Project", 1)
    rows = [["File", "Jenis", "Keterangan"]]
    for path in files:
        suffix = path.suffix.lower() or "(tanpa ekstensi)"
        rows.append([rel(path), suffix, explain_file(path, read_text(path) if path.suffix.lower() in SOURCE_EXTENSIONS else "")])
    story.append(NextPageTemplate("landscape"))
    story.append(PageBreak())
    story.append(table(rows, [9 * cm, 3 * cm, 14 * cm], font_size=6))
    story.append(NextPageTemplate("portrait"))

    doc = Doc(OUT_FILE)
    doc.multiBuild(story)


if __name__ == "__main__":
    STYLES = make_styles()
    build_pdf()
    print(OUT_FILE)
