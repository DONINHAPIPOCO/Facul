class ListaSequencial {
    private int[] lista;
    private int quantElementos;
    
    public int[] getLista() {
        return lista;
    }

    public void setLista(int[] lista) {
        this.lista = lista;
    }

    public int getQuantElementos() {
        return quantElementos;
    }

    public void setQuantElementos(int quantElementos) {
        this.quantElementos = quantElementos;
    }

    public ListaSequencial() {
        this(30);

    }

    public ListaSequencial(int tamanho) {
        this.lista = new int[tamanho];
        this.quantElementos = 0;

    }

    public void inserirInicio(int elemento) throws Exception {
        if(this.getQuantElementos() < this.getLista().length - 1) {
            for(int i = this.getQuantElementos(); i >= 0 ; i--) {
                this.getLista()[i + 1] = this.getLista()[i];

            }

            this.getLista()[0] = elemento;
            this.setQuantElementos(this.getQuantElementos() + 1);

        } else {
            throw new Exception("ERRO AO INSERIR NO INICIO!");

        }

    }

    public void inserir(int elemento, int posicao) throws Exception {
        if(posicao < this.getLista().length && this.getQuantElementos() < this.getLista().length) {
            for(int i = this.getQuantElementos(); i >= posicao; i--) {
                this.getLista()[i + 1] = this.getLista()[i];

            }

            this.getLista()[posicao] = elemento;
            this.setQuantElementos(this.getQuantElementos() + 1);

        } else {
            throw new Exception("ERRO AO INSERIR NA POSICAO: " + posicao + "!");

        }

    }

    public void inserirFim(int elemento) throws Exception {
        if(this.getQuantElementos() < this.getLista().length) {
            this.getLista()[this.getQuantElementos()] = elemento;
            this.setQuantElementos(this.getQuantElementos() + 1);

        } else {
            throw new Exception("ERRO AO INSERIR NO FIM!");

        }

    }

    public int removerInicio() throws Exception {
        if(this.getQuantElementos() > 0) {
            int resp = this.getLista()[0];

            for(int i = 0; i < this.getQuantElementos(); i++) {
                this.getLista()[i] = this.getLista()[i + 1];

            }

            this.setQuantElementos(this.getQuantElementos() - 1);

            return resp;

        } else {
            throw new Exception("ERRO AO REMOVER NO INICIO!");

        }

    }

    public int remover(int posicao) throws Exception {
        if(this.getQuantElementos() > 0 && posicao < this.getLista().length) {
            int resp = this.getLista()[posicao];

            for(int i = posicao; i < this.getQuantElementos(); i++) {
                this.getLista()[i] = this.getLista()[i + 1];

            }

            this.setQuantElementos(this.getQuantElementos() - 1);

            return resp;

        } else {
            throw new Exception("ERRO AO REMOVER NA POSICAO: " + posicao + "!");

        }

    }

    public int removerFim() throws Exception {
        if(this.getQuantElementos() > 0) {
            int resp = this.getLista()[this.getQuantElementos() - 1];

            this.setQuantElementos(this.getQuantElementos() - 1);

            return resp;

        } else {
            throw new Exception("ERRO AO REMOVER NO FIM!");

        }

    }

    public void mostrar() throws Exception {
        if(this.getQuantElementos() > 0) {
            System.out.print("[ ");
            for(int i = 0; i < this.getLista().length; i++) {
                System.out.print(this.getLista()[i] + " ");

            }
            System.out.print("]");

        } else {
            throw new Exception("ERRO AO MOSTRAR");

        }

    }

}