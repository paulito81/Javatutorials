package no.phasfjo.guistuff;

public class TitleConverter {

    public TitleConverter(){
    }

    public static String createNewTitle(String input){
        StringBuilder builder = new StringBuilder();

        // split string on whitespace
        for(String word : input.split("\\s")) {
            if( word. length() < 4) {
                builder.append(word.toLowerCase());
            }
            else {
                builder.append(word.substring(0,1).toUpperCase());
                builder.append(word.substring(1).toLowerCase());
            }
            builder.append(" ");
        }
        return builder.toString();
    }
}
