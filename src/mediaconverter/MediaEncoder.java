
package mediaconverter;

public class MediaEncoder {

    public String encode(MediaData mediaData, int[] samples,
                         String targetFormat, String bitrateInfo) {
        if (mediaData == null) {
            throw new IllegalArgumentException("Media data cannot be null.");
        }

        if (samples == null || samples.length == 0) {
            throw new IllegalArgumentException("Audio samples cannot be empty.");
        }

        if (targetFormat == null || targetFormat.isBlank()) {
            throw new IllegalArgumentException("Target format cannot be empty.");
        }

        if (bitrateInfo == null || bitrateInfo.isBlank()) {
            throw new IllegalArgumentException("Bitrate information cannot be empty.");
        }

        String format = targetFormat.trim().toLowerCase();

        if (!format.equals("mp3") && !format.equals("wav")) {
            throw new IllegalArgumentException("Unsupported target format: " + format);
        }

        String fileName = mediaData.getFileName();

        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("File name cannot be empty.");
        }

        int dotIndex = fileName.lastIndexOf('.');

        if (dotIndex <= 0 || dotIndex == fileName.length() - 1) {
            throw new IllegalArgumentException("Invalid file name: " + fileName);
        }

        String outputFileName = fileName.substring(0, dotIndex) + "." + format;

        StringBuilder result = new StringBuilder();

        result.append("File: ").append(outputFileName).append("\n");
        result.append("Format: ").append(format.toUpperCase()).append("\n");
        result.append("Settings: ").append(bitrateInfo).append("\n");
        result.append("Samples: ");

        for (int i = 0; i < samples.length; i++) {
            if (i > 0) {
                result.append(",");
            }

            result.append(samples[i]);
        }

        return result.toString();
    }
}