
package mediaconverter;

public class AudioMixer {

    public int[] mix(MediaData mediaData) {
        if (mediaData == null) {
            throw new IllegalArgumentException("Media data cannot be null.");
        }

        int[] leftChannel = mediaData.getLeftChannel();
        int[] rightChannel = mediaData.getRightChannel();

        if (leftChannel.length != rightChannel.length) {
            throw new IllegalArgumentException("Audio channels must have the same length.");
        }

        int[] mixedChannel = new int[leftChannel.length];

        for (int i = 0; i < leftChannel.length; i++) {
            mixedChannel[i] = (leftChannel[i] + rightChannel[i]) / 2;
        }

        return mixedChannel;
    }
}