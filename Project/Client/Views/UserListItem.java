package Project.Client.Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 * UserListItem represents a user entry in the user list.
 */
public class UserListItem extends JPanel {
    private JEditorPane textContainer;
    private static final Color HIGHLIGHT_COLOR = new Color(230, 240, 255); // light blue
    private static final Color MUTED_COLOR = Color.LIGHT_GRAY;
    private static final Color DEFAULT_COLOR = Color.WHITE;
    private boolean isMuted = false;

    /**
     * Constructor to create a UserListItem.
     *
     * @param clientId   The ID of the client.
     * @param clientName The name of the client.
     * @param parent     The parent container to calculate available width.
     */
    public UserListItem(long clientId, String clientName, JPanel parent) {
        textContainer = new JEditorPane("text/html", clientName);
        textContainer.setName(Long.toString(clientId));
        textContainer.setEditable(false);
        textContainer.setBorder(new EmptyBorder(0, 0, 0, 0)); // Add padding

        // Account for the width of the vertical scrollbar
        JScrollPane parentScrollPane = (JScrollPane) SwingUtilities.getAncestorOfClass(JScrollPane.class, parent);
        int scrollBarWidth = parentScrollPane.getVerticalScrollBar().getPreferredSize().width;

        // Adjust the width of the text container
        int availableWidth = parent.getWidth() - scrollBarWidth - 10; // Subtract an additional padding
        textContainer.setSize(new Dimension(availableWidth, Integer.MAX_VALUE));
        Dimension d = textContainer.getPreferredSize();
        textContainer.setPreferredSize(new Dimension(availableWidth, d.height));

        // Clear background and border
        textContainer.setOpaque(false);
        textContainer.setBorder(BorderFactory.createEmptyBorder());
        textContainer.setBackground(new Color(0, 0, 0, 0));

        this.setLayout(new BorderLayout());
        this.add(textContainer, BorderLayout.CENTER);
        setBackground(DEFAULT_COLOR); // Set default background
    }

    public String getClientName() {
        return textContainer.getText();
    }

    public void setHighlighted(boolean highlighted) {
        setBackground(highlighted ? HIGHLIGHT_COLOR : DEFAULT_COLOR);
    }

    public void setMuted(boolean muted) {
        this.isMuted = muted;
        textContainer.setForeground(muted ? MUTED_COLOR : Color.BLACK);
        setBackground(muted ? MUTED_COLOR : DEFAULT_COLOR);
    }

    public boolean isMuted() {
        return isMuted;
    }
}