class StringHasAllUnique {

    static boolean stringHasAllUnique(String string){
        String lower = string.toLowerCase();
        boolean[] seen = new boolean[Character.MAX_VALUE];
        for(int i = 0; i < lower.length(); i++){
            int index = lower.charAt(i);
            if(seen[index]){
                return false;
            }
            seen[index] = true;
        }
        return true;
    }
}
