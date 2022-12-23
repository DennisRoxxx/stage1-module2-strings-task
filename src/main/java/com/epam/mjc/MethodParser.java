package com.epam.mjc;

public class MethodParser {
    private static final String REG_EXP_DELIMITER = " *\\( *|\\)|( *,+ +)| +";
    private final List<String> accessModifiers = List.of("public", "private", "protected");

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
        String modifier;
        String type;
        String name;
        String[] signatureElements = signatureString.trim().split(REG_EXP_DELIMITER);
        modifier = isAccessModifier(signatureElements[0]) ? signatureElements[0] : null;
        type = modifier == null ? signatureElements[0] : signatureElements[1];
        name = modifier == null ? signatureElements[1] : signatureElements[2];
        int index = modifier == null ? 2 : 3;
        List<MethodSignature.Argument> arguments = new ArrayList<>();
        for (int i = index; i < signatureElements.length; i += 2) {
            arguments.add(new MethodSignature.Argument(signatureElements[i], signatureElements[i+1]));
        }
        MethodSignature methodSignature = new MethodSignature(name, arguments);
        methodSignature.setAccessModifier(modifier);
        methodSignature.setReturnType(type);
        return methodSignature;
    }
    private boolean isAccessModifier(String modifier){
        return accessModifiers.contains(modifier);
    }
}
