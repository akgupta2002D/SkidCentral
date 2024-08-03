package main.skidscreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URL;
import java.util.List;

/**
 * Class: EventDisplay
 * Project: SkidScreen - Digital Event Poster System
 * Author: Ankit Gupta
 * Supervisor: Professor David Read
 * Version: 1.0 <April 13th>
 * Purpose: Manages the GUI for displaying events. It rotates through a list of events, displaying each for a fixed
 *          time interval. This class utilizes Java Swing to create a user interface.
 * Usage: Instantiate with a list of Event objects to start the display cycle.
 * Dependencies: Requires the Event class for event data structures.
 */
public class EventDisplay extends JFrame {
    private List<Event> events; // List of events to display
    private int currentIndex = 0; // Current index in the events list
    private Timer timer; // Timer to handle the rotation of event display

    /**
     * Constructs the EventDisplay frame and starts the event rotation.
     * @param events List of Event objects to be displayed.
     */
    public EventDisplay(List<Event> events) {
        this.events = events;

        setTitle("Event Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentIndex = (currentIndex + 1) % events.size();
                displayEvent(events.get(currentIndex));
            }
        });
        timer.start();

        displayEvent(events.get(0)); // Initially display the first event
    }

    /**
     * Displays an event in the JFrame.
     * @param event The event to display.
     */
    private void displayEvent(Event event) {
        getContentPane().removeAll(); // Clear previous event components

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(245, 245, 245)); // Set background color to light grey

     // Organization information panel
        JPanel orgPanel = new JPanel();
        orgPanel.setLayout(new BoxLayout(orgPanel, BoxLayout.Y_AXIS)); // Changed to BoxLayout.Y_AXIS
        orgPanel.setBackground(new Color(245, 245, 245)); // Set background color to light grey

     // Skidmore Central header
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS)); // Ensures the label stretches across
        headerPanel.setBackground(new Color(0, 128, 0)); // Set background color to green
        
        JLabel headerLabel = new JLabel("Skidmore Central");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE); // Set text color to white
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.add(headerLabel);
        orgPanel.add(headerPanel); // Add header panel to orgPanel

        // Organization Name and Logo
        JLabel orgNameLabel = new JLabel(event.getOrganizationName());
        orgNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel orgLogoLabel = new JLabel(new ImageIcon(event.getOrganizationProfilePicture()));
        orgLogoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        orgPanel.add(orgNameLabel);
        orgPanel.add(orgLogoLabel);

        mainPanel.add(orgPanel);

        // Event name
        JLabel eventNameLabel = new JLabel(event.getName());
        eventNameLabel.setFont(new Font("Arial", Font.BOLD, 32));
        eventNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(eventNameLabel);

        // Event image handling
        try {
            ImageIcon imageIcon;
            if (event.getImagePath() == null || event.getImagePath().isEmpty()) {
                imageIcon = new ImageIcon(getClass().getResource("SkidScreen/images/DefaultSkid.png"));
            } else {
                URI imageUri = new URI("https://skidmore.campuslabs.com/engage/image/" + event.getImagePath());
                URL imageUrl = imageUri.toURL();
                imageIcon = new ImageIcon(imageUrl);
                Image image = imageIcon.getImage();
                Image resizedImage = image.getScaledInstance(600, 400, Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(resizedImage);
            }
            JLabel imageLabel = new JLabel(imageIcon);
            JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            imagePanel.setBackground(new Color(245, 245, 245)); // Set background color to light grey
            imagePanel.add(imageLabel);
            mainPanel.add(imagePanel);
        } catch (Exception e) {
            e.printStackTrace();
            mainPanel.add(new JLabel("Failed to load or resize image."));
        }

        // Event details
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(0, 1));
        detailsPanel.setBackground(new Color(245, 245, 245)); // Set background color to light grey
        detailsPanel.add(new JLabel("<html><div style='width:350px;'>" + "Description: " + event.getDescription() + "</div></html>"));
        detailsPanel.add(new JLabel("<html><div style='width:350px;'>" + "Location: " + event.getLocation() + "</div></html>"));
        detailsPanel.add(new JLabel("<html><div style='width:350px;'>" + "Starts On: " + event.getStartsOn() + "</div></html>"));
        detailsPanel.add(new JLabel("<html><div style='width:350px;'>" + "Ends On: " + event.getEndsOn() + "</div></html>"));
        mainPanel.add(detailsPanel);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
