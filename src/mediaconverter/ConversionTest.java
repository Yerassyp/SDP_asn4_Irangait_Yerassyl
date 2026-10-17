
package mediaconverter;

public class ConversionTest {

    public static void main(String[] args) {
        MediaConversionFacade facade = new MediaConversionFacade();

        String expectedMp3 = "File: song.mp3\n"
                + "Format: MP3\n"
                + "Settings: 128 kbps (simulated)\n"
                + "Samples: 20,50,90";

        checkResult("WAV to MP3", expectedMp3,
                facade.convert("song.wav", "mp3"));

        String expectedWav = "File: music.wav\n"
                + "Format: WAV\n"
                + "Settings: Uncompressed PCM (simulated)\n"
                + "Samples: 22,50,89";

        checkResult("MP3 to WAV", expectedWav,
                facade.convert("music.mp3", "wav"));

        String expectedNormalized = "File: track.mp3\n"
                + "Format: MP3\n"
                + "Settings: 128 kbps (simulated)\n"
                + "Samples: 20,50,90";

        checkResult("Uppercase and spaces", expectedNormalized,
                facade.convert("  track.WAV  ", "  MP3  "));

        checkError("Unsupported source format", facade, "song.txt", "mp3");
        checkError("Missing file extension", facade, "song", "mp3");
        checkError("Unsupported target format", facade, "song.wav", "ogg");
        checkError("Empty file name", facade, "  ", "mp3");
        checkError("Empty target format", facade, "song.wav", "  ");
        checkError("Null file name", facade, null, "mp3");
        checkError("Null target format", facade, "song.wav", null);

        System.out.println("All 10 tests passed.");
    }

    private static void checkResult(String testName, String expected,
                                    String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("FAIL: " + testName
                    + "\nExpected:\n" + expected
                    + "\nActual:\n" + actual);
        }

        System.out.println("PASS: " + testName);
    }

    private static void checkError(String testName, MediaConversionFacade facade,
                                   String fileName, String targetFormat) {
        try {
            facade.convert(fileName, targetFormat);
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: " + testName);
            return;
        }

        throw new AssertionError("FAIL: " + testName
                + " - expected IllegalArgumentException.");
    }
}