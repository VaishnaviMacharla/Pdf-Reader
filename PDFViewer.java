
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PDFViewer {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PDFViewer::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("PDF Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create a text area to display the PDF content.
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Load and display the PDF content.
        String pdfFilePath = "\"C:\\Users\\Admin\\Documents\\Devops.pdf\""; // Replace with the path to your PDF file
        try {
            File pdfFile = new File(pdfFilePath);
            PDDocument document = PDDocument.load(pdfFile);
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);
            textArea.setText(text);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
            textArea.setText("An error occurred while reading the PDF file.");
        }

        // Display the window.
        frame.setVisible(true);
    }
}
