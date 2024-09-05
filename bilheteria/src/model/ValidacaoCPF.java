package model;

public class ValidacaoCPF {
    public boolean CPFIsValido(String cpf) {
        // Verifica se o CPF tem exatamente 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }
        
        // Verifica se todos os dígitos são iguais (caso de CPF inválido)
        int aux = 0;
        for (int i = 0; i < cpf.length() - 1; i++) {
            if (cpf.charAt(i) == cpf.charAt(i + 1)) {
                aux++;
            }
        }
        if (aux == 10) { // Se todos os dígitos forem iguais
            return false;
        }
        
        // Validação do primeiro dígito verificador
        int soma = 0;
        int peso = 10;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * peso--;
        }
        int digito1 = (soma * 10) % 11;
        if (digito1 == 10) {
            digito1 = 0;
        }
        if (digito1 != cpf.charAt(9) - '0') {
            return false;
        }
        
        // Validação do segundo dígito verificador
        soma = 0;
        peso = 11;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * peso--;
        }
        int digito2 = (soma * 10) % 11;
        if (digito2 == 10) {
            digito2 = 0;
        }
        return digito2 == cpf.charAt(10) - '0';
    }
}
