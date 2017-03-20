package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

public class ImageReaderFactory {

    public static ImageReader getReader(ImageTypes type) {
        if (type == ImageTypes.BMP) return new BmpReader();
        if (type == ImageTypes.PNG) return new PngReader();
        if (type == ImageTypes.JPG) return new JpgReader();
        else throw new IllegalArgumentException();
    }

}
