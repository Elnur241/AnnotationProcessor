/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic;
  @SupportedAnnotationTypes("bean.WritingStyle")

    @SupportedSourceVersion( SourceVersion.RELEASE_8 )
public class SimpleAnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(final Set< ? extends TypeElement> annotations,
            final RoundEnvironment roundEnv) {
        System.out.println("processor is executed");
        for (final Element element : roundEnv.getElementsAnnotatedWith(WritingStyle.class)) {
           String varName=element.getSimpleName().toString();
            if (!varName.startsWith("teacher")) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,"variable must start be teacher"); 
           return false;
            }
//            if (element instanceof TypeElement) {
//                final TypeElement typeElement = (TypeElement) element;
//
//                for (final Element eclosedElement : typeElement.getEnclosedElements()) {
//                    if (eclosedElement instanceof VariableElement) {
//                        final VariableElement variableElement = (VariableElement) eclosedElement;
//
//                        if (variableElement.getConstantValue() == null) {
//                            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "");
//                            return false;
//                        }
//                    }
//                }
//            }
        }
        return true;
    }
}
