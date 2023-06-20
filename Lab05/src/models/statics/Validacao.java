package models.statics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacao {
    public static boolean validaCPF(String cpf) {
        return validCPFouCNPJ(cpf);
    }

    public static boolean validaCNPJ(String cnpj) {
        return validCPFouCNPJ(cnpj);
    }

    public static boolean validaNome(String nome) {
        return matchRegex(RegExpressions.name, nome);
    }

    private static boolean validCPFouCNPJ(String match) {
        return matchRegex(RegExpressions.document, match);
    }

    private static boolean matchRegex(String regex, String match) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(match);

        return matcher.find();
    }
}
