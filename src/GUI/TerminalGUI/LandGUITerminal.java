package GUI.TerminalGUI;

import GUI.LandGUI;
import GUI.LandGUIContent;

public class LandGUITerminal implements LandGUI {
    protected final int verticalFields;
    protected final int horizontalFields;
    protected final String[][] table;

    public LandGUITerminal(int verticalFields, int horizontalFields) {
        this.verticalFields = verticalFields;
        this.horizontalFields = horizontalFields;
        this.table = new String[verticalFields][horizontalFields];
    }

    @Override
    public void showTable() {
        for (int i = 0; i < table.length; ++i) {
            for (int j = 0; j < table[i].length; ++i) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void changeFieldContent(int vertIndex, int horIndex, LandGUIContent content) {
        table[vertIndex][horIndex] = (String) content.getContent();
    }
}
