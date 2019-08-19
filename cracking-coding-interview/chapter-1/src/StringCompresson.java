public class StringCompresson {
    public static String compress(String string) {
        StringBuilder result = new StringBuilder();
        char starting = string.charAt(string.length() - 1);
        int count = 0;

        for(int i = string.length() - 1; i >= 0; i--){
            char current = string.charAt(i);
            if(current != starting){
                result.append(count).append(starting);
                starting = current;
                count = 1;
            } else {
                count++;
            }
        }
        result.append(count).append(starting);

        if(string.length() < result.length()){
            return string;
        }

        return result.reverse().toString();
    }
}
