public class RoleArranger {

    public static void main(String[] args) {
        String[] roles = new String[4];
        String[] textLines = new String[5];
        
        printTextPerRole(roles, textLines);
        
    }

        private static String printTextPerRole(String[] roles, String[] textLines) {
            StringBuilder full = new StringBuilder("");
            for (String x : roles) {
                full.append(x + ":\n");
                for (int i = 0; i < textLines.length; i++) {
                    if (textLines[i].startsWith(x + ":")) full.append(textLines[i].replaceFirst(x +":", (i + 1) + ")") + '\n'); 
                }
                full.append('\n');
            }
            String result = full.toString();
            return result;
        }

}