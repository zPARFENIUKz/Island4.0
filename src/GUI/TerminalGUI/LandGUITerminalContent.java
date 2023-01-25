package GUI.TerminalGUI;

import GUI.LandGUIContent;

public class LandGUITerminalContent implements LandGUIContent {
    protected final String content;

    public LandGUITerminalContent(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
