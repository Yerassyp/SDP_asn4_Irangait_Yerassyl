
package mediaconverter;

public class MediaConversionFacade {

    private final MetadataReader metadataReader;
    private final AudioMixer audioMixer;
    private final BitrateProcessor bitrateProcessor;
    private final MediaEncoder mediaEncoder;

    public MediaConversionFacade() {
        metadataReader = new MetadataReader();
        audioMixer = new AudioMixer();
        bitrateProcessor = new BitrateProcessor();
        mediaEncoder = new MediaEncoder();
    }

    public String convert(String fileName, String targetFormat) {
        MediaData mediaData = metadataReader.read(fileName);

        int[] mixedSamples = audioMixer.mix(mediaData);

        int[] processedSamples = bitrateProcessor.process(mixedSamples, targetFormat);

        String bitrateInfo = bitrateProcessor.getBitrateInfo(targetFormat);

        return mediaEncoder.encode(mediaData, processedSamples, targetFormat, bitrateInfo);
    }
}