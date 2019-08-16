public class IsRotation {
    public static boolean isRotation(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        return (a + a).contains(b);
    }
}
