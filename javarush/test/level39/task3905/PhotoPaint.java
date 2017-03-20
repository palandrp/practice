package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int r, int c, Color desiredColor) {
        if (c < 0 || r < 0 || c >= image.length || r >= image[c].length || image[c][r] == desiredColor) return false;
        else repaint(image, r, c, image[c][r], desiredColor);
        return true;
    }

    private void repaint(Color[][] image, int x, int y, Color canvasColor, Color desiredColor) {
        if (image[y][x] == desiredColor || image[y][x] != canvasColor) return;
        else {
            image[y][x] = desiredColor;
            if (x > 0) repaint(image, x-1, y, canvasColor, desiredColor);
            if (x < image.length - 1) repaint(image, x+1, y, canvasColor, desiredColor);
            if (y < image[x].length - 1) repaint(image, x, y+1, canvasColor, desiredColor);
            if (y > 0) repaint(image, x, y-1, canvasColor, desiredColor);
        }
    }

}
