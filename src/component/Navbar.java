package component;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Navbar extends JPanel {

    // PANEL
    private JPanel rightPanel;
    private JPanel adminPanel;
    private JPanel textPanel;

    // LABEL
    private JLabel lbNotif;
    private JLabel lbBadge;
    private JLabel lbUser;
    private JLabel lbName;
    private JLabel lbRole;
    private JLabel lbArrow;

    // DROPDOWN
    private JPopupMenu notifPopup;
    private JPopupMenu adminPopup;

    public Navbar() {

        initComponents();

    }

    private void initComponents() {

        // =========================================
        // NAVBAR
        // =========================================

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

        // =========================================
        // RIGHT PANEL
        // =========================================

        rightPanel = new JPanel();

        rightPanel.setOpaque(false);

        rightPanel.setLayout(new FlowLayout(
                FlowLayout.RIGHT,
                20,
                15
        ));

        // =========================================
        // NOTIFICATION PANEL
        // =========================================

        JPanel notifPanel = new JPanel(null);

        notifPanel.setOpaque(false);

        notifPanel.setPreferredSize(new Dimension(32, 32));

        // =========================================
        // NOTIFICATION ICON
        // =========================================

        lbNotif = new JLabel();

        lbNotif.setBounds(0, 0, 32, 32);

        lbNotif.setIcon(new ImageIcon(
                getClass().getResource(
                        "/assets/notification.png"
                )
        ));

        lbNotif.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // =========================================
        // BADGE
        // =========================================

        lbBadge = new JLabel("5");

        lbBadge.setBounds(18, -2, 18, 18);

        lbBadge.setHorizontalAlignment(JLabel.CENTER);

        lbBadge.setForeground(Color.WHITE);

        lbBadge.setFont(new Font("Segoe UI", Font.BOLD, 10));

        lbBadge.setOpaque(true);

        lbBadge.setBackground(new Color(239, 68, 68));

        notifPanel.add(lbNotif);

        notifPanel.add(lbBadge);

        // =========================================
        // USER ICON
        // =========================================

        lbUser = new JLabel();

        lbUser.setIcon(new ImageIcon(
                getClass().getResource(
                        "/assets/user.png"
                )
        ));

        lbUser.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // =========================================
        // ADMIN PANEL
        // =========================================

        adminPanel = new JPanel();

        adminPanel.setOpaque(false);

        adminPanel.setLayout(new FlowLayout(
                FlowLayout.LEFT,
                5,
                0
        ));

        // =========================================
        // TEXT PANEL
        // =========================================

        textPanel = new JPanel();

        textPanel.setOpaque(false);

        textPanel.setLayout(new BoxLayout(
                textPanel,
                BoxLayout.Y_AXIS
        ));

        // =========================================
        // ADMIN NAME
        // =========================================

        lbName = new JLabel("Admin");

        lbName.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                15
        ));

        lbName.setForeground(new Color(17, 24, 39));

        // =========================================
        // ROLE
        // =========================================

        lbRole = new JLabel("Administrator");

        lbRole.setFont(new Font(
                "Segoe UI",
                Font.PLAIN,
                12
        ));

        lbRole.setForeground(new Color(107, 114, 128));

        // =========================================
        // ARROW
        // =========================================

        lbArrow = new JLabel();

        lbArrow.setIcon(new ImageIcon(
                getClass().getResource(
                        "/assets/down-arrow.png"
                )
        ));

        lbArrow.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // =========================================
        // ADD TEXT
        // =========================================

        textPanel.add(lbName);

        textPanel.add(lbRole);

        // =========================================
        // ADD ADMIN PANEL
        // =========================================

        adminPanel.add(textPanel);

        adminPanel.add(Box.createHorizontalStrut(10));

        adminPanel.add(lbArrow);

        // =========================================
        // RIGHT PANEL
        // =========================================

        rightPanel.add(notifPanel);

        rightPanel.add(lbUser);

        rightPanel.add(adminPanel);

        // =========================================
        // ADD NAVBAR
        // =========================================

        add(rightPanel, BorderLayout.EAST);

        // =========================================
        // CREATE DROPDOWN
        // =========================================

        createNotificationPopup();

        createAdminPopup();

        // =========================================
        // EVENT NOTIFICATION
        // =========================================

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

        // =========================================
        // EVENT USER
        // =========================================

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

        // =========================================
        // EVENT ARROW
        // =========================================

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

    // =========================================================
    // NOTIFICATION POPUP
    // =========================================================

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

    // =========================================================
    // ADMIN POPUP
    // =========================================================

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

        // =========================================
        // PROFILE TOP
        // =========================================

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

        JLabel name = new JLabel("Admin");

        name.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                14
        ));

        JLabel role = new JLabel(
                "Administrator"
        );

        role.setForeground(
                Color.GRAY
        );

        txt.add(name);

        txt.add(role);

        top.add(icon);

        top.add(txt);

        // =========================================
        // MENU BUTTON
        // =========================================

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

        // =========================================
        // LOGOUT EVENT
        // =========================================

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

        // =========================================
        // ADD
        // =========================================

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

    // =========================================================
    // NOTIFICATION ITEM
    // =========================================================

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

    // =========================================================
    // BUTTON MENU
    // =========================================================

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

}
