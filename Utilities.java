public class Utilities {
    public static String capitalize(String inputString){
        if(inputString == null || inputString.isEmpty()){
            return inputString;
        }

        return inputString.substring(0, 1).toUpperCase() + inputString.substring(1).toLowerCase();
    }
}
