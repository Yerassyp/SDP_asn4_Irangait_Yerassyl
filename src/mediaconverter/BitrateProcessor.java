
package mediaconverter;

public class BitrateProcessor {

    public int[] process(int[] samples, String targetFormat) {
        if (samples == null) {
            throw new IllegalArgumentException("Audio samples cannot be null.");
        }

        if (targetFormat == null || targetFormat.isBlank()) {
            throw new IllegalArgumentException("Target format cannot be empty.");
        }

        String format = targetFormat.trim().toLowerCase();

        if (!format.equals("mp3") && !format.equals("wav")) {
            throw new IllegalArgumentException("Unsupported target format: " + format);
        }

        int[] processedSamples = samples.clone();

        if (format.equals("mp3")) {
            for (int i = 0; i < processedSamples.length; i++) {
                processedSamples[i] = Math.round(processedSamples[i] / 10.0f) * 10;
            }
        }

        return processedSamples;
    }

    public String getBitrateInfo(String targetFormat) {
        if (targetFormat == null || targetFormat.isBlank()) {
            throw new IllegalArgumentException("Target format cannot be empty.");
        }

        String format = targetFormat.trim().toLowerCase();

        if (format.equals("mp3")) {
            return "128 kbps (simulated)";
        }

        if (format.equals("wav")) {
            return "Uncompressed PCM (simulated)";
        }

        throw new IllegalArgumentException("Unsupported target format: " + format);
    }
}