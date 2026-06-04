package view.dashboard;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class UserManagement extends javax.swing.JPanel {
    public UserManagement() {
        initComponents();
        setupActions();
        loadTable();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        userManagement = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelCard7 = new swing.PanelCard();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableUser = new javax.swing.JTable();
        setLayout(new java.awt.CardLayout());
        userManagement.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("User Management");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("Dashboard");
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel3.setText(">");
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel4.setText("User Management");
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap(828, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        btnTambah.setBackground(new java.awt.Color(0, 51, 255));
        btnTambah.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("+ Tambah User");
        btnEdit.setBackground(new java.awt.Color(255, 153, 0));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnEdit.setText("Edit");
        btnHapus.setBackground(new java.awt.Color(255, 0, 0));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnHapus.setText("Hapus");
        btnCari.setText("Cari");
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCari)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtCari, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        tableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "No", "ID", "Username", "Nama Lengkap", "Role", "Status", "Dibuat"
            }
        ));
        jScrollPane7.setViewportView(tableUser);
        javax.swing.GroupLayout panelCard7Layout = new javax.swing.GroupLayout(panelCard7);
        panelCard7.setLayout(panelCard7Layout);
        panelCard7Layout.setHorizontalGroup(
            panelCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCard7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCard7Layout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addGap(12, 12, 12)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        panelCard7Layout.setVerticalGroup(
            panelCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCard7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTambah)
                        .addComponent(btnEdit)
                        .addComponent(btnHapus)))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(panelCard7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelCard7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        javax.swing.GroupLayout userManagementLayout = new javax.swing.GroupLayout(userManagement);
        userManagement.setLayout(userManagementLayout);
        userManagementLayout.setHorizontalGroup(
            userManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userManagementLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        userManagementLayout.setVerticalGroup(
            userManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        add(userManagement, "card2");
    }// </editor-fold>//GEN-END:initComponents
    private void setupActions() {
        txtCari.setText("");
        tableUser.setForeground(Color.BLACK);
        tableUser.setSelectionForeground(Color.WHITE);
        tableUser.setSelectionBackground(new Color(30, 99, 242));
        tableUser.setRowHeight(28);
        tableUser.setShowGrid(false);
        btnTambah.addActionListener(e -> showUserDialog(false));
        btnEdit.addActionListener(e -> showUserDialog(true));
        btnHapus.addActionListener(e -> deleteSelectedUser());
        btnCari.addActionListener(e -> loadTable(txtCari.getText().trim()));
        txtCari.addActionListener(e -> loadTable(txtCari.getText().trim()));
        tableUser.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    showUserDialog(true);
                }
            }
        });
    }
    public void loadTable() {
        loadTable("");
    }
    public void loadTable(String keyword) {
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"No", "ID", "Username", "Nama Lengkap", "Role", "Status", "Dibuat"},
                0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String sql = "SELECT id, username, nama_lengkap, role, status, created_at "
                + "FROM users "
                + "WHERE username LIKE ? OR nama_lengkap LIKE ? OR role LIKE ? OR status LIKE ? "
                + "ORDER BY id ASC";
        try (Connection conn = config.koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            String like = "%" + keyword + "%";
            ps.setString(1, like);
            ps.setString(2, like);
            ps.setString(3, like);
            ps.setString(4, like);
            try (ResultSet rs = ps.executeQuery()) {
                int no = 1;
                while (rs.next()) {
                    model.addRow(new Object[]{
                        no++,
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("nama_lengkap"),
                        rs.getString("role"),
                        rs.getString("status"),
                        rs.getString("created_at")
                    });
                }
            }
            tableUser.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data user: " + e.getMessage());
        }
    }
    private void showUserDialog(boolean editMode) {
        int selectedRow = tableUser.getSelectedRow();
        if (editMode && selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Pilih user yang mau diedit.");
            return;
        }
        JTextField username = new JTextField(20);
        JTextField password = new JTextField(20);
        JTextField namaLengkap = new JTextField(20);
        JComboBox<String> role = new JComboBox<>(new String[]{"admin", "superadmin"});
        JComboBox<String> status = new JComboBox<>(new String[]{"Aktif", "Tidak Aktif"});
        int userId = -1;
        if (editMode) {
            userId = Integer.parseInt(String.valueOf(tableUser.getValueAt(selectedRow, 1)));
            username.setText(String.valueOf(tableUser.getValueAt(selectedRow, 2)));
            namaLengkap.setText(String.valueOf(tableUser.getValueAt(selectedRow, 3)));
            role.setSelectedItem(String.valueOf(tableUser.getValueAt(selectedRow, 4)));
            status.setSelectedItem(String.valueOf(tableUser.getValueAt(selectedRow, 5)));
        }
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addFormRow(form, gbc, 0, "Username", username);
        addFormRow(form, gbc, 1, editMode ? "Password Baru" : "Password", password);
        addFormRow(form, gbc, 2, "Nama Lengkap", namaLengkap);
        addFormRow(form, gbc, 3, "Role", role);
        addFormRow(form, gbc, 4, "Status", status);
        int result = JOptionPane.showConfirmDialog(
                this,
                form,
                editMode ? "Edit User" : "Tambah User",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );
        if (result != JOptionPane.OK_OPTION) {
            return;
        }
        if (username.getText().trim().isEmpty() || namaLengkap.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username dan nama lengkap wajib diisi.");
            return;
        }
        if (!editMode && password.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password wajib diisi.");
            return;
        }
        if (editMode) {
            updateUser(userId, username, password, namaLengkap, role, status);
        } else {
            insertUser(username, password, namaLengkap, role, status);
        }
    }
    private void addFormRow(JPanel form, GridBagConstraints gbc, int row, String label, java.awt.Component input) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0;
        form.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        form.add(input, gbc);
    }
    private void insertUser(
            JTextField username,
            JTextField password,
            JTextField namaLengkap,
            JComboBox<String> role,
            JComboBox<String> status) {
        String sql = "INSERT INTO users (username, password, nama_lengkap, role, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = config.koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username.getText().trim());
            ps.setString(2, password.getText().trim());
            ps.setString(3, namaLengkap.getText().trim());
            ps.setString(4, String.valueOf(role.getSelectedItem()));
            ps.setString(5, String.valueOf(status.getSelectedItem()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "User berhasil ditambahkan.");
            loadTable(txtCari.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal tambah user: " + e.getMessage());
        }
    }
    private void updateUser(
            int userId,
            JTextField username,
            JTextField password,
            JTextField namaLengkap,
            JComboBox<String> role,
            JComboBox<String> status) {
        boolean updatePassword = !password.getText().trim().isEmpty();
        String sql = updatePassword
                ? "UPDATE users SET username = ?, password = ?, nama_lengkap = ?, role = ?, status = ? WHERE id = ?"
                : "UPDATE users SET username = ?, nama_lengkap = ?, role = ?, status = ? WHERE id = ?";
        try (Connection conn = config.koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username.getText().trim());
            if (updatePassword) {
                ps.setString(2, password.getText().trim());
                ps.setString(3, namaLengkap.getText().trim());
                ps.setString(4, String.valueOf(role.getSelectedItem()));
                ps.setString(5, String.valueOf(status.getSelectedItem()));
                ps.setInt(6, userId);
            } else {
                ps.setString(2, namaLengkap.getText().trim());
                ps.setString(3, String.valueOf(role.getSelectedItem()));
                ps.setString(4, String.valueOf(status.getSelectedItem()));
                ps.setInt(5, userId);
            }
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "User berhasil diedit.");
            loadTable(txtCari.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal edit user: " + e.getMessage());
        }
    }
    private void deleteSelectedUser() {
        int row = tableUser.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Pilih user yang mau dihapus.");
            return;
        }
        int userId = Integer.parseInt(String.valueOf(tableUser.getValueAt(row, 1)));
        String username = String.valueOf(tableUser.getValueAt(row, 2));
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Hapus user " + username + "?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION
        );
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        try (Connection conn = config.koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE id = ?")) {
            ps.setInt(1, userId);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "User berhasil dihapus.");
            loadTable(txtCari.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal hapus user: " + e.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane7;
    private swing.PanelCard panelCard7;
    private javax.swing.JTable tableUser;
    private javax.swing.JTextField txtCari;
    private javax.swing.JPanel userManagement;
    // End of variables declaration//GEN-END:variables
}
