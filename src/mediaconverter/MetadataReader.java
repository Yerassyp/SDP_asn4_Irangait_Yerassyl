
package mediaconverter;

public class MetadataReader {

    public MediaData read(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("File name cannot be empty.");
        }

        String name = fileName.trim();
        int dotIndex = name.lastIndexOf('.');

        if (dotIndex <= 0 || dotIndex == name.length() - 1) {
            throw new IllegalArgumentException("Invalid file name: " + name);
        }

        String format = name.substring(dotIndex + 1).toLowerCase();

        if (!format.equals("wav") && !format.equals("mp3")) {
            throw new IllegalArgumentException("Unsupported format: " + format);
        }

        int[] leftChannel = {17, 42, 83};
        int[] rightChannel = {27, 58, 95};

        return new MediaData(name, format, leftChannel, rightChannel);
    }
}