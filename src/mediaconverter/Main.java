
package mediaconverter;

public class Main {

    public static void main(String[] args) {
        MediaConversionFacade facade = new MediaConversionFacade();

        String result = facade.convert("song.wav", "mp3");

        System.out.println(result);
    }
}