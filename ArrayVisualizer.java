import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A class for visualizing one-dimensional integer arrays.
 * It displays int arrays as bar charts.
 */
public class ArrayVisualizer extends JFrame {

    private static final long serialVersionUID = 1L;
    private ArrayPanel arrayPanel;
    private static final int BAR_WIDTH = 10; // Fixed bar width
    private static final int WINDOW_HEIGHT = 800; // Fixed window height

    public ArrayVisualizer() {
        arrayPanel = new ArrayPanel();
        add(arrayPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Array Sorting Lab - https://github.com/mathias-wilke/java-array-sorting-lab");
        // Sets an initial window width, which will be adjusted later
        setSize(400, WINDOW_HEIGHT);
    }

    /**
     * Draws an int array as a bar chart.
     * Each element in the array is represented by a bar of corresponding height.
     * 
     * @param array The int array to be visualized.
     */
    public void drawIntArray(int[] array) {
        if (array != null && array.length > 0) {
            arrayPanel.setArray(array);
            adjustWindowSize(array.length); // Adjusts the window size on the first drawing
        }
    }

    /**
     * Adds a single index to the highlighted indices.
     * 
     * @param index The index to be highlighted.
     */
    public void highlightIndex(int index) {
        arrayPanel.addHighlightedIndex(index);
    }

    private void adjustWindowSize(int arrayLength) {
        int totalWidth = arrayLength * (BAR_WIDTH + 1) + 15; // Calculates the total width
        setSize(new Dimension(totalWidth, WINDOW_HEIGHT));

        // Centers the window after adjusting the size
        setLocationRelativeTo(null);

        revalidate();
        //repaint();
    }

    /**
     * Inner class that extends JPanel. It is used for drawing the int array as a bar chart.
     */
    private class ArrayPanel extends JPanel {

    	private static final long serialVersionUID = 1L;
        private int[] array;
        private List<Integer> highlightedIndices = new ArrayList<>();

    	ArrayPanel() {
            setBackground(Color.BLACK);
        }

        private int findMax(int[] array) {
            if (array == null || array.length == 0) {
                return 0;
            }
            int max = array[0];
            for (int value : array) {
                if (value > max) {
                    max = value;
                }
            }
            return max;
        }

        /**
         * Sets the int array to be visualized and repaints the panel.
         * 
         * @param array The int array to be set.
         */
        void setArray(int[] array) {
            this.array = array;
            repaint();
        }

        void addHighlightedIndex(int index) {
            if (!highlightedIndices.contains(index)) {
                highlightedIndices.add(index);
            }
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (array != null) {
                drawIntArray(g);
            }
            highlightedIndices.clear();
        }

        private void drawIntArray(Graphics g) {
            int panelHeight = getHeight();
            int maxVal = findMax(array);

            for (int i = 0; i < array.length; i++) {
                // Scales the bar height relative to the maximum height
                int scaledHeight = (array[i] * panelHeight) / maxVal;
                g.setColor(highlightedIndices.contains(i) ? Color.RED : Color.WHITE);
                g.fillRect(i * (BAR_WIDTH + 1), panelHeight - scaledHeight, BAR_WIDTH, scaledHeight);
            }
        }
    }
}
