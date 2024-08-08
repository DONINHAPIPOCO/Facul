class AquecimentoIterativo {
    public static int contaMaiusculo(String palavra) throws Exception{
        if(!"".equals(palavra)) {
            int resp = 0;
            for(int i = 0; i < palavra.length(); i++) {
                if(palavra.charAt(i) >= 65 && palavra.charAt(i) <= 90) {
                    resp += 1;

                }

            }

            return resp;

        } else {
            throw new Exception("ERRO! Palavra Vazia!!!");

        }

    }

    public static void main(String[] args) {
        String[] entrada = new String[];

    }

}