package com.epam.mjc;

public class MethodParser {
    
    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        
        StringTokenizer stz = new StringTokenizer(signatureString, "()");
        
        ArrayList<MethodSignature.Argument> argList = new ArrayList<>();
        
        String tempArgs = stz.nextToken();
        
        String[] textArgs = tempArgs.split(" ");
        
        if (stz.hasMoreTokens()) {
            String arguments = stz.nextToken();
            String[] args = arguments.split(", ");
            
            for (String item : args) {
                String[] items = item.split(" ");
                argList.add(new MethodSignature.Argument(items[0], items[1]));
            }
        }

        MethodSignature signature = new MethodSignature(textArgs[textArgs.length - 1], argList);
        if (textArgs.length == 2) {
            signature.setReturnType(prefixes[0]);
        } else {
            signature.setAccessModifier(prefixes[0]);
            signature.setReturnType(prefixes[1]);
        }
        return signature;
    }
}
