package component;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Navbar extends JPanel {
    private JPanel rightPanel;
    private JPanel adminPanel;
    private JPanel textPanel;
    private JLabel lbNotif;
    private JLabel lbBadge;
    private JLabel lbUser;
    private JLabel lbName;
    private JLabel lbRole;
    private JLabel popupName;
    private JLabel popupRole;
    private JLabel lbArrow;
    private JPopupMenu notifPopup;
    private JPopupMenu adminPopup;
    public Navbar() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(0, 60));
        setBorder(BorderFactory.createMatteBorder(
        0,
        0,
        1,
        0,
        new Color(230, 230, 230)
        ));
        rightPanel = new JPanel();
        rightPanel.setOpaque(false);
        rightPanel.setLayout(new FlowLayout(
        FlowLayout.RIGHT,
        20,
        15
        ));
        JPanel notifPanel = new JPanel(null);
        notifPanel.setOpaque(false);
        notifPanel.setPreferredSize(new Dimension(32, 32));
        lbNotif = new JLabel();
        lbNotif.setBounds(0, 0, 32, 32);
        lbNotif.setIcon(new ImageIcon(
        getClass().getResource(
        "/assets/notification.png"
        )
        ));
        lbNotif.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbBadge = new JLabel("5");
        lbBadge.setBounds(18, -2, 18, 18);
        lbBadge.setHorizontalAlignment(JLabel.CENTER);
        lbBadge.setForeground(Color.WHITE);
        lbBadge.setFont(new Font("Segoe UI", Font.BOLD, 10));
        lbBadge.setOpaque(true);
        lbBadge.setBackground(new Color(239, 68, 68));
        notifPanel.add(lbNotif);
        notifPanel.add(lbBadge);
        lbUser = new JLabel();
        lbUser.setIcon(new ImageIcon(
        getClass().getResource(
        "/assets/user.png"
        )
        ));
        lbUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminPanel = new JPanel();
        adminPanel.setOpaque(false);
        adminPanel.setLayout(new FlowLayout(
        FlowLayout.LEFT,
        5,
        0
        ));
        textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(new BoxLayout(
        textPanel,
        BoxLayout.Y_AXIS
        ));
        lbName = new JLabel("Admin");
        lbName.setFont(new Font(
        "Segoe UI",
        Font.BOLD,
        15
        ));
        lbName.setForeground(new Color(17, 24, 39));
        lbRole = new JLabel("Administrator");
        lbRole.setFont(new Font(
        "Segoe UI",
        Font.PLAIN,
        12
        ));
        lbRole.setForeground(new Color(107, 114, 128));
        lbArrow = new JLabel();
        lbArrow.setIcon(new ImageIcon(
        getClass().getResource(
        "/assets/down-arrow.png"
        )
        ));
        lbArrow.setCursor(new Cursor(Cursor.HAND_CURSOR));
        textPanel.add(lbName);
        textPanel.add(lbRole);
        adminPanel.add(textPanel);
        adminPanel.add(Box.createHorizontalStrut(10));
        adminPanel.add(lbArrow);
        rightPanel.add(notifPanel);
        rightPanel.add(lbUser);
        rightPanel.add(adminPanel);
        add(rightPanel, BorderLayout.EAST);
        createNotificationPopup();
        createAdminPopup();
        lbNotif.addMouseListener(
        new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(
            java.awt.event.MouseEvent evt
            ) {
                refreshNotifications();
                notifPopup.show(
                lbNotif,
                -260,
                40
                );
            }
        });
        lbUser.addMouseListener(
        new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(
            java.awt.event.MouseEvent evt
            ) {
                adminPopup.show(
                lbUser,
                -180,
                45
                );
            }
        });
        lbArrow.addMouseListener(
        new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(
            java.awt.event.MouseEvent evt
            ) {
                adminPopup.show(
                lbArrow,
                -180,
                45
                );
            }
        });
    }

    private void createNotificationPopup() {
        notifPopup = new JPopupMenu();
        notifPopup.setBorder(BorderFactory.createEmptyBorder());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(
        panel,
        BoxLayout.Y_AXIS
        ));
        panel.setBackground(Color.WHITE);
        panel.setBorder(new EmptyBorder(
        10,
        10,
        10,
        10
        ));
        panel.setPreferredSize(new Dimension(
        280,
        250
        ));
        JLabel title = new JLabel("Notification");
        title.setFont(new Font(
        "Segoe UI",
        Font.BOLD,
        16
        ));
        panel.add(title);
        panel.add(Box.createVerticalStrut(15));
        notifPopup.add(panel);
        refreshNotifications();
    }

    private void createAdminPopup() {
        adminPopup = new JPopupMenu();
        adminPopup.setBorder(BorderFactory.createEmptyBorder());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(
        panel,
        BoxLayout.Y_AXIS
        ));
        panel.setBackground(Color.WHITE);
        panel.setBorder(new EmptyBorder(
        10,
        10,
        10,
        10
        ));
        panel.setPreferredSize(new Dimension(
        220,
        230
        ));
        JPanel top = new JPanel(
        new FlowLayout(
        FlowLayout.LEFT
        )
        );
        top.setOpaque(false);
        JLabel icon = new JLabel();
        icon.setIcon(new ImageIcon(
        getClass().getResource(
        "/assets/user.png"
        )
        ));
        JPanel txt = new JPanel();
        txt.setOpaque(false);
        txt.setLayout(new BoxLayout(
        txt,
        BoxLayout.Y_AXIS
        ));
        popupName = new JLabel("Admin");
        popupName.setFont(new Font(
        "Segoe UI",
        Font.BOLD,
        14
        ));
        popupRole = new JLabel(
        "Administrator"
        );
        popupRole.setForeground(
        Color.GRAY
        );
        txt.add(popupName);
        txt.add(popupRole);
        top.add(icon);
        top.add(txt);
        JButton profile = createMenuButton(
        "Profile"
        );
        JButton setting = createMenuButton(
        "Pengaturan"
        );
        JButton password = createMenuButton(
        "Ubah Password"
        );
        JButton logout = createMenuButton(
        "Logout"
        );
        logout.setForeground(
        new Color(239, 68, 68)
        );
        logout.addActionListener(e -> {
            int confirm =
            JOptionPane.showConfirmDialog(
            null,
            "Yakin logout ?",
            "Logout",
            JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        panel.add(top);
        panel.add(Box.createVerticalStrut(15));
        panel.add(profile);
        panel.add(setting);
        panel.add(password);
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JSeparator());
        panel.add(Box.createVerticalStrut(10));
        panel.add(logout);
        adminPopup.add(panel);
    }

    private JPanel createNotifItem(String text) {
        return createNotifItem(text, "Baru saja");
    }

    private JPanel createNotifItem(String text, String timeText) {
        JPanel item = new JPanel(
        new BorderLayout()
        );
        item.setOpaque(false);
        item.setBorder(new EmptyBorder(
        15,
        0,
        15,
        0
        ));
        JLabel title = new JLabel(text);
        title.setFont(new Font(
        "Segoe UI",
        Font.PLAIN,
        13
        ));
        JLabel time = new JLabel(timeText);
        time.setForeground(Color.GRAY);
        time.setFont(new Font(
        "Segoe UI",
        Font.PLAIN,
        11
        ));
        JPanel txt = new JPanel();
        txt.setOpaque(false);
        txt.setLayout(new BoxLayout(
        txt,
        BoxLayout.Y_AXIS
        ));
        txt.add(title);
        txt.add(time);
        item.add(txt, BorderLayout.CENTER);
        return item;
    }

    public final void refreshNotifications() {
        if (notifPopup == null || notifPopup.getComponentCount() == 0) {
            return;
        }
        JPanel panel = (JPanel) notifPopup.getComponent(0);
        panel.removeAll();
        JLabel title = new JLabel("Notification");
        title.setFont(new Font("Segoe UI", Font.BOLD, 16));
        panel.add(title);
        panel.add(Box.createVerticalStrut(15));
        int count = 0;
        String sql = "SELECT isi, tanggal FROM pengumuman ORDER BY tanggal DESC LIMIT 6";
        try (Connection conn = config.koneksi.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                count++;
                panel.add(createNotifItem(
                rs.getString("isi"),
                rs.getString("tanggal")
                ));
            }
        } catch (Exception e) {
            panel.add(createNotifItem("Belum ada pengumuman", ""));
        }
        if (count == 0) {
            panel.add(createNotifItem("Belum ada pengumuman", ""));
        }
        panel.revalidate();
        panel.repaint();
    }

    private JButton createMenuButton(String text) {
        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setHorizontalAlignment(
        SwingConstants.LEFT
        );
        btn.setCursor(
        new Cursor(Cursor.HAND_CURSOR)
        );
        btn.setFont(new Font(
        "Segoe UI",
        Font.PLAIN,
        13
        ));
        btn.setMaximumSize(
        new Dimension(
        200,
        35
        )
        );
        return btn;
    }

    public void setBadgeCount(int count) {
        lbBadge.setText(String.valueOf(count));
        lbBadge.setVisible(count > 0);
        lbBadge.revalidate();
        lbBadge.repaint();
    }

    public void setUserInfo(String name, String role) {
        String displayName = name == null || name.trim().isEmpty() ? "User" : name.trim();
        String displayRole = formatRole(role);

        lbName.setText(displayName);
        lbRole.setText(displayRole);

        if (popupName != null) {
            popupName.setText(displayName);
        }
        if (popupRole != null) {
            popupRole.setText(displayRole);
        }

        revalidate();
        repaint();
    }

    private String formatRole(String role) {
        if (role == null || role.trim().isEmpty()) {
            return "User";
        }

        if ("superadmin".equalsIgnoreCase(role) || "masteradmin".equalsIgnoreCase(role)) {
            return "Superadmin";
        }

        if ("admin".equalsIgnoreCase(role)) {
            return "Admin";
        }

        String cleanRole = role.trim();
        return cleanRole.substring(0, 1).toUpperCase() + cleanRole.substring(1);
    }
}
