# Text_Editor

# Text Editor Project

## Overview

This Text Editor project is a simple Java application that provides basic text editing capabilities. It offers features like creating new text files, opening existing files, saving files, editing text (cut, copy, paste, select all), changing the font and size of the text, and applying different themes (dark and light). The project is designed with a user-friendly graphical user interface (GUI) using Java Swing components.

## How It Works

### User Interface
- When you run the application, a window titled "Text Editor" will appear.
- The menu bar at the top contains various menus: "File," "Edit," "View," "Themes," and "Help."
- The "File" menu provides options for creating a new file, opening an existing file, saving the current file, and closing the application.
- The "Edit" menu offers standard text editing options like cut, copy, paste, and select all.
- The "View" menu allows you to change the font and size of the text in the editor.
- The "Themes" menu lets you choose between a dark and light theme for the text editor's background and text color.
- The "Help" menu provides options for accessing help documentation and watching a tutorial (these features are currently commented out in the code).

### Text Editing
- You can type or paste text into the main text area, which occupies the central part of the application.
- The "Cut," "Copy," "Paste," and "Select All" options in the "Edit" menu work as expected, allowing you to manipulate text within the editor.

### File Operations
- "New" creates a new instance of the text editor, effectively starting a new editing session.
- "Open" lets you select an existing text file to open. The content of the selected file will be displayed in the text editor.
- "Save" allows you to save the current text content to a file. You can specify the file name and location.
- "Close" exits the application.

### Font and Themes
- The "Change Font and Size" option in the "View" menu opens a font chooser dialog, enabling you to change the text's font and size.
- The "Dark Theme" and "Light Theme" options in the "Themes" menu toggle the background and text color to provide a different visual style for the editor.

## How to Run

1. Compile the Java source code.
2. Run the `TextEditor` class, which contains the `main` method.
3. The Text Editor window will appear, and you can start using the application.

