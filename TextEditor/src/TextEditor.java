import com.ozten.font.JFontChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URI;

public class TextEditor implements ActionListener {
    //    DECLARING PROPERTIES OF TEXT EDITOR.
    JFrame frame;
    JMenuBar menuBar;
    JMenu file, edit, view, themes, help;
    JTextArea textArea;
    JMenuItem newFile, openFile, saveFile, closeFile, cut, copy, paste, selectAll, font, darkTheme, lightTheme, helpDoc, watchTutorial;
    JPanel panel;

    //    CONSTRUCTOR.
    public TextEditor() {
//        INITIATION OF FRAME
        frame = new JFrame("Text Editor");
        frame.setBounds(500,250,400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
//        INITIATION OF MENU-BAR.
        menuBar = new JMenuBar();

//        INITIATION OF MENUS IN MENU-BAR -> (file, edit, view, themes, help).
        file = new JMenu("File");
        edit = new JMenu("Edit");
        view = new JMenu("View");
        themes = new JMenu("Themes");
        help = new JMenu("Help");

//        ADD MENUS TO THE MENU-BAR.
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(view);
        menuBar.add(themes);
        menuBar.add(help);

//        INITIATION OF MENU-ITEMS OF file MENU.
        newFile = new JMenuItem("New");
        openFile = new JMenuItem("Open");
        saveFile = new JMenuItem("Save");
        closeFile = new JMenuItem("Close");
//        ADD MENU-ITEMS TO ActionListener.
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        closeFile.addActionListener(this);

//        ADD MENU-ITEMS TO file MENU.
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(closeFile);

//        INITIATION OF MENU-ITEMS OF edit MENU.
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select all");
//        ADD MENU-ITEMS TO ActionListener.
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
//        ADD MENU-ITEMS TO edit MENU.
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);

//        INITIATION OF MENU-ITEMS OF view MENU.
        font = new JMenuItem("Change Font and size");
//        ADD MENU-ITEMS TO ActionListener.
        font.addActionListener(this);
//        ADD MENU0ITEMS TO view MENU.
        view.add(font);

//        INITIATION OF MENU-ITEMS OF themes MENU.
        darkTheme = new JMenuItem("Dark theme");
        lightTheme = new JMenuItem("Light theme");
//        ADD MENU-ITEMS TO ActionListener.
        darkTheme.addActionListener(this);
        lightTheme.addActionListener(this);
//        ADD MENU-ITEMS TO themes MENU.
        themes.add(darkTheme);
        themes.add(lightTheme);

//        INITIATION OF MENU-ITEMS OF help MENU.
        helpDoc = new JMenuItem("Help Documentation");
        watchTutorial = new JMenuItem("Watch tutorial");
//        ADD MENU-ITEMS TO Actionlistener.
        helpDoc.addActionListener(this);
        watchTutorial.addActionListener(this);
//        ADD MENU-ITEMS TO help MENU.
        help.add(helpDoc);
        help.add(watchTutorial);

//        SET MENU-BAR TO THE FRAME.
        frame.setJMenuBar(menuBar);

//        INITIATION OF TEXT-AREA.
        textArea = new JTextArea();

//        SET FRAME VISIBLE TO TRUE.
        frame.setVisible(true);

//        INITIATION OF PANEL.
        panel = new JPanel();
//        SET BORDER FOR PANEL.
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
//        SET LAYOUT FOR PANEL.
        panel.setLayout(new BorderLayout(0, 0));
//        ADD TEXTAREA TO PANEL.
        panel.add(textArea, BorderLayout.CENTER);

//        CREATE JScrollPane -> scrollPane.
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

//        ADD SCROLL-PANE TO PANEL.
        panel.add(scrollPane);

//        ADD PANEL TO FRAME.
        frame.add(panel);

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
//        CREATE file MENU FUNCTIONALITIES.
//        SET NEW-FILE FUNCTION.
        if(actionEvent.getSource() == newFile) {
            new TextEditor();
        }

//        SET OPEN-FILE FUNCTION.
        if(actionEvent.getSource() == openFile) {
//            PERFORMING OPEN-FILE FUNCTION
//            INITIALIZE FILE-CHOOSER.
            JFileChooser fileChooser = new JFileChooser("C:/Users/sigma/Desktop");
            int chooseOption = fileChooser.showOpenDialog(null);
//            CHECK IF OPEN BUTTON IS CLICKED.
            if(chooseOption == JFileChooser.APPROVE_OPTION) {
//                GET SELECTED FILE.
                File file = fileChooser.getSelectedFile();
//                GET PATH OF SELECTED FILE.
                String filePath = file.getPath();
                try{
//                    INITIALIZE FILE-READER.
                    FileReader fileReader = new FileReader(filePath);
//                    INITIALIZE BUFFERED-READER.
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String intermediate;
                    StringBuilder output = new StringBuilder();
//                    READ CONTENTS OF THE FILE LINE BY LINE.
                    while((intermediate = bufferedReader.readLine()) != null) {
                        output.append(intermediate).append("\n");
                    }
//                    SET OUTPUT TO TEXT-AREA.
                    textArea.setText(output.toString());
                    bufferedReader.close();
                } catch (IOException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        }

//        SET SAVE-FILE FUNCTION.
        if(actionEvent.getSource() == saveFile) {
//            INITIALIZE FILE-CHOOSER.
            JFileChooser fileChooser = new JFileChooser("C:/Users/sigma/Desktop");
            int chooseOption = fileChooser.showSaveDialog(null);
//            CHECK IF SAVE BUTTON IS CLICKED.
            if(chooseOption == JFileChooser.APPROVE_OPTION) {
//                CREATE A NEW FILE WITH CHOSEN DIRECTORY AND FILE NAME.
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath() + ".txt");
                try{
//                    INITIALIZE FILE-WRITER.
                    FileWriter fileWriter = new FileWriter(file);
//                    INITIALIZE BUFFERED-WRITER.
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//                    WRITE CONTENTS FROM TEXT-AREA TO NEW FILE.
                    textArea.write(bufferedWriter);
                    bufferedWriter.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

//        SET CLOSE-FILE FUNCTION.
        if(actionEvent.getSource() == closeFile) {
            System.exit(0);
        }

//        CREATE edit MENU FUNCTIONALITIES.
//        SET CUT FUNCTION.
        if(actionEvent.getSource() == cut) {
            textArea.cut();
        }
//        SET COPY FUNCTION.
        if(actionEvent.getSource() == copy) {
            textArea.copy();
        }
//        SET PASTE FUNCTION.
        if(actionEvent.getSource() == paste) {
            textArea.paste();
        }
//        SET SELECT-ALL FUNCTION.
        if(actionEvent.getSource() == selectAll) {
            textArea.selectAll();
        }

//        CREATE view MENU FUNCTIONALITIES.
//        SET CHANGE FONT AND SIZE FUNCTION.
        if(actionEvent.getSource()== font) {
            Font selectedFont = JFontChooser.showDialog(frame, "Choose font", String.valueOf(textArea.getFont()));
            if(selectedFont != null) {
                textArea.setFont(selectedFont);
            }
        }

//        CREATE themes MENU FUNCTIONALITIES.
//        SET DARK-THEME FUNCTION.
        if(actionEvent.getSource() == darkTheme) {
            textArea.setBackground(Color.black);
            textArea.setForeground(Color.white);
        }

//        SET LIGHT-THEME FUNCTION.
        if(actionEvent.getSource() == lightTheme) {
            textArea.setBackground(Color.white);
            textArea.setForeground(Color.black);
        }

//        CREATE help MENU FUNCTIONALITIES.
//        SET HELP-DOC FUNCTION.
        if(actionEvent.getSource() == helpDoc) {
            try {
//                CREATING URL
                String url = "https://github.com/Mausam1815/Text_Editor/blob/main/HelpDoc.md";
//                ACCESS URL WHEN USER CLICKS ON HELP-DOC.
                Desktop.getDesktop().browse(URI.create(url));
            }catch (Exception a){
                a.printStackTrace();
            }
        }

//        SET WATCH-TUTORIAL FUNCTION.
        if(actionEvent.getSource() == watchTutorial) {
            try {
//                CREATING URL.
                String url = "https://vimeo.com/863473450?share=copy";
//                ACCESS THE URL WHEN USER CLICKS ON WATCH-TUTORIAL.
                Desktop.getDesktop().browse(URI.create(url));
            }catch (Exception a){
                a.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        CREATING NEW TEXTEDITOR OBJECT TO RUN PROGRAM.
        new TextEditor();
    }
}
