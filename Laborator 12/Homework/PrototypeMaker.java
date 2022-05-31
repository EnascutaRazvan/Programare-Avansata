
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
public class PrototypeMaker {
    public List<String> make(List<String> classNames) throws ClassNotFoundException {

        List<String> prototypes = new ArrayList<>();
        StringBuilder prototype;

        for (int i = 0; i < classNames.size(); ++i) {
            String name = classNames.get(i);
            prototype = new StringBuilder("");

            int modf = Class.forName(name).getModifiers();
            try {
                String accessModifier = getAccessModifier(modf);
                String packageName = getPackage(name);
                String constructors = getConstructors(name);
                String fields = getFields(name);
                String methods = getMethods(name);

                prototype.append(accessModifier)
                        .append("class ")
                        .append(packageName)
                        .append(name + " {\n")
                        .append(constructors)
                        .append(fields)
                        .append(methods + "}");

                prototypes.add(String.valueOf(prototype));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return prototypes;
    }

    public String getPackage(String className) throws ClassNotFoundException {
        return Class.forName(className).getPackageName();
    }

    public String getMethods(String className) throws ClassNotFoundException {
        StringBuilder classSignature = new StringBuilder();
        for (Method method : Class.forName(className).getMethods()) {
            StringBuilder methodBuilder = new StringBuilder();
            int methodModifiers = method.getModifiers();
            methodBuilder.append('\t');
            methodBuilder.append(getAccessModifier(methodModifiers));
            methodBuilder.append(method.getReturnType().getSimpleName()).append(' ');
            methodBuilder.append(method.getName()).append('(');

            Parameter[] parameters = method.getParameters();
            if (parameters.length > 0) {
                for (int i = 0; i < parameters.length - 1; ++i) {
                    methodBuilder.append(parameters[i].getType().getSimpleName()).append(", ");
                }
                methodBuilder.append(parameters[parameters.length - 1].getType().getSimpleName());
            }
            methodBuilder.append(");\n");
            classSignature.append(methodBuilder);
        }
        return classSignature.toString();
    }

    private String getAccessModifier(int modifier) {
        StringBuilder accessModifierBuilder = new StringBuilder();
        if (Modifier.isStatic(modifier)) {
            accessModifierBuilder.append("static ");
        }
        if (Modifier.isFinal(modifier)) {
            accessModifierBuilder.append("final ");
        }
        if (Modifier.isSynchronized(modifier)) {
            accessModifierBuilder.append("synchronized ");
        }
        if (Modifier.isPublic(modifier)) {
            accessModifierBuilder.append("public ");
        } else if (Modifier.isProtected(modifier)) {
            accessModifierBuilder.append("protected ");
        } else if (Modifier.isPrivate(modifier)) {
            accessModifierBuilder.append("private ");
        }
        return accessModifierBuilder.toString();
    }

    private String getFields(String className) throws ClassNotFoundException {
        StringBuilder classSignature = new StringBuilder();
        for (Field field : Class.forName(className).getDeclaredFields()) {
            StringBuilder fieldBuilder = new StringBuilder();
            int fieldModifiers = field.getModifiers();
            fieldBuilder.append('\t');
            fieldBuilder.append(getAccessModifier(fieldModifiers));
            fieldBuilder.append(field.getType().getSimpleName()).append(' ');
            fieldBuilder.append(field.getName());
            fieldBuilder.append(";\n");
            classSignature.append(fieldBuilder);
        }
        return classSignature.toString();
    }

    private String getConstructors(String name) throws ClassNotFoundException {
        StringBuilder classSignature = new StringBuilder();
        for (Constructor<?> constructor : Class.forName(name).getConstructors()) {
            StringBuilder constructorBuilder = new StringBuilder();
            int constructorModifiers = constructor.getModifiers();
            constructorBuilder.append('\t');
            constructorBuilder.append(getAccessModifier(constructorModifiers));
            constructorBuilder.append(constructor.getName()).append('(');

            Parameter[] parameters = constructor.getParameters();
            if (parameters.length > 0) {
                for (int i = 0; i < parameters.length - 1; ++i) {
                    constructorBuilder.append(parameters[i].getType().getSimpleName()).append(", ");
                }
                constructorBuilder.append(parameters[parameters.length - 1].getType().getSimpleName());
            }
            constructorBuilder.append(");\n");
            classSignature.append(constructorBuilder);
        }
        return classSignature.toString();
    }
}



