package PROJECT;

public class keyconverter // helper method to convert character key array to numeric key array
{
public int[] converter(String key) 
{
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] convert = new int[key.length()];
        for(int k=0; k < key.length(); k++){
            int dex = alpha.indexOf(Character.toLowerCase(key.charAt(k)));
            if (dex != -1){
                convert[k]=dex;
            }
        }
        return convert;
    }
}

