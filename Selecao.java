import java.util.Random;

class Selecao {
    private int[] array;
    
    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public Selecao() {
        array = new int[30];

        Random generator = new Random();
        for(int i = 0; i < 30; i++) {
            array[i] = generator.nextInt(200);

        }

    }

    public void sort() {
        for(int i = 0; i < this.getArray().length - 1; i++) {
            int menor = i;
            for(int j = i + 1; j < this.getArray().length; j++) {
                if(this.getArray()[menor] > this.getArray()[j]) {
                    menor = j;

                }

            }

            int tmp = this.getArray()[menor];
            this.getArray()[menor] = this.getArray()[i];
            this.getArray()[i] = tmp;

        }

    }

    public static void main(String[] args) {
        Selecao array = new Selecao();

        System.out.print("ARRAY PRÉ ORDENAÇÃO:\n[ ");
        for(int i = 0; i < array.getArray().length; i++) {
            System.out.print(array.getArray()[i] + " ");

        }
        System.out.println("]");

        array.sort();

        System.out.print("ARRAY PÓS ORDENAÇÃO:\n[ ");
        for(int i = 0; i < array.getArray().length; i++) {
            System.out.print(array.getArray()[i] + " ");

        }
        System.out.println("]");

    }

}