import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import com.ozten.font.JFontChooser;

public class TextEditor implements ActionListener {
//    declaring properties of the text editor
    JFrame frame;
    JMenuBar menuBar;
    JMenu file, edit, view, themes, help;
    JTextArea textArea;
    JMenuItem newFile, openFile, saveFile, closeFile, cut, copy, paste, selectAll, font, darkTheme, lightTheme, helpDoc, watchTutorial;
    JPanel panel;

//    constructor
    public TextEditor() {
//        initiation of frame
        frame = new JFrame("Text Editor");
//        frame.setSize(800, 600);
        frame.setBounds(500,250,400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
//        initiation of menu bar
        menuBar = new JMenuBar();

//        initiation of menus
        file = new JMenu("File");
        edit = new JMenu("Edit");
        view = new JMenu("View");
        themes = new JMenu("Themes");
        help = new JMenu("Help");

//        add menus to the menu bar
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(view);
        menuBar.add(themes);
        menuBar.add(help);

//        initiation of sub-menus of file menu
        newFile = new JMenuItem("New");
        openFile = new JMenuItem("Open");
        saveFile = new JMenuItem("Save");
        closeFile = new JMenuItem("Close");
//        add menu items to action listener
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        closeFile.addActionListener(this);

//        add these sub-menus to file menu
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(closeFile);

//        initiation of sub-menus of edit menu
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select all");
//        add menu item to action listener
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
//        add these sub-menus to edit menu
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);

//        initiation of sub-menus of view menu
        font = new JMenuItem("Change Font and size");
//        add menu item to action listener
        font.addActionListener(this);
//        add these sub-menus to view menu
        view.add(font);

//        initiation of sub-menus of themes menu
        darkTheme = new JMenuItem("Dark theme");
        lightTheme = new JMenuItem("Light theme");
//        add menu item to action listener
        darkTheme.addActionListener(this);
        lightTheme.addActionListener(this);
//        add these sub-menus to themes menu
        themes.add(darkTheme);
        themes.add(lightTheme);

//        initiation of sub-menus of help menu
        helpDoc = new JMenuItem("Help Documentation");
        watchTutorial = new JMenuItem("Watch tutorial");
//        add menu item to action listener
        helpDoc.addActionListener(this);
        watchTutorial.addActionListener(this);
//        add these sub-menus to help menu
        help.add(helpDoc);
        help.add(watchTutorial);

//        set menu bar for the frame
        frame.setJMenuBar(menuBar);

//        initiation of text area
        textArea = new JTextArea();

//        make frame visible
        frame.setVisible(true);

//        create content pane
        panel = new JPanel();
//        set border
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
//        set layout
        panel.setLayout(new BorderLayout(0, 0));
//        add text area to panel
        panel.add(textArea, BorderLayout.CENTER);

//        create scroll pane
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

//        add scroll pane to panel
        panel.add(scrollPane);

//        add panel to frame
        frame.add(panel);

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
//        file menu functionalities
//        new file function
        if(actionEvent.getSource() == newFile) {
            new TextEditor();
        }

//        open file function
        if(actionEvent.getSource() == openFile) {
//            performing open file operation
//            initialize file chooser
            JFileChooser fileChooser = new JFileChooser("C:/Users/sigma/Desktop");
            int chooseOption = fileChooser.showOpenDialog(null);
//            if open option is clicked
            if(chooseOption == JFileChooser.APPROVE_OPTION) {
//                get selected file
                File file = fileChooser.getSelectedFile();
//                get path of selected file
                String filePath = file.getPath();
                try{
//                    initialize file reader
                    FileReader fileReader = new FileReader(filePath);
//                    initialize buffered reader
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String intermediate;
                    StringBuilder output = new StringBuilder();
//                    read contents of the file line by line
                    while((intermediate = bufferedReader.readLine()) != null) {
                        output.append(intermediate).append("\n");
                    }
//                    set output to text area
                    textArea.setText(output.toString());
                    bufferedWriter.close();
                } catch (IOException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        }

//        save file function
        if(actionEvent.getSource() == saveFile) {
//            initialize file chooser
            JFileChooser fileChooser = new JFileChooser("C:/Users/sigma/Desktop");
            int chooseOption = fileChooser.showSaveDialog(null);
//            check if save option is clicked
            if(chooseOption == JFileChooser.APPROVE_OPTION) {
//                create a new file with chosen directory and file name
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath() + ".txt");
                try{
//                    initialize file writer
                    FileWriter fileWriter = new FileWriter(file);
//                    initialize buffered writer
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//                    write contents to created file from text area
                    textArea.write(bufferedWriter);
                    bufferedWriter.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

//        close file function
        if(actionEvent.getSource() == closeFile) {
            System.exit(0);
        }

//        edit menu functionalities
//        cut function
        if(actionEvent.getSource() == cut) {
//            performing cut operation
            textArea.cut();
        }
//        copy function
        if(actionEvent.getSource() == copy) {
//            performing copy operation
            textArea.copy();
        }
//        paste function
        if(actionEvent.getSource() == paste) {
//            performing paste operation
            textArea.paste();
        }
//        select all function
        if(actionEvent.getSource() == selectAll) {
//            performing select all operation
            textArea.selectAll();
        }

//        view menu functionalities
//        change font function
        if(actionEvent.getSource()== font) {

            Font selectedFont = JFontChooser.showDialog(frame, "Choose font", String.valueOf(textArea.getFont()));
            if(selectedFont != null) {
                textArea.setFont(selectedFont);
            }
        }

//        themes menu functionalities
//        dark theme function
        if(actionEvent.getSource() == darkTheme) {
            textArea.setBackground(Color.black);
            textArea.setForeground(Color.white);
        }

//        light theme function
        if(actionEvent.getSource() == lightTheme) {
            textArea.setBackground(Color.white);
            textArea.setForeground(Color.black);
        }

//        help functionalities
//        help doc function
//        if(actionEvent.getSource() == helpDoc) {
//            try {
//                String url = "";
//                Desktop.getDesktop().browse(URI.create(url));
//            }catch (Exception a){
//                a.printStackTrace();
//            }
//        }

//        watch tutorial function
//        if(actionEvent.getSource() == watchTutorial) {
//            try {
//                String url = "";
//                Desktop.getDesktop().browse(URI.create(url));
//            }catch (Exception a){
//                a.printStackTrace();
//            }
//        }
    }

    public static void main(String[] args) {
        new TextEditor();
    }
}
