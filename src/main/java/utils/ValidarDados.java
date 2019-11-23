package utils;

public class ValidarDados {

    public static boolean validaCpf(String str) {
        if(str==null || str.length() != 11)
            return false;
        int[] aux = new int[str.length()];
        int cont = 0;
        for (int i = 0; i < aux.length; i++) {
            String substring = Character.toString(str.charAt(i));
            try {
                aux[i] = Integer.parseInt(substring);
            } catch (NumberFormatException ex) { // exceção lançada caso os dados não sejam númericos
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            cont += (aux[i] * (10 - i));
        }
        int digito1 = 11 - (cont % 11);
        if (digito1 > 9) {
            digito1 = 0;
        }
        cont = 0;
        for (int i = 0; i < 10; i++) {
            cont += aux[i] * (11 - i);
        }
        int digito2 = 11 - (cont % 11);
        if (digito2 > 9) {
            digito2 = 0;
        }
        return digito1 == aux[9] && digito2 == aux[10];
    }

    public static boolean validaTamanho(String str, int min, int max) {
        if (str != null) {
            return str.length() <= max && str.length() > min;
        } else {
            return false;
        }
    }

}

