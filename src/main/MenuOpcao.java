package main;

/*
-> pode ter construtor
-> pode ter método
-> pode ter atributo
MAS: implicitamente o construtor é privado,
     implicitamente as enumeracoes sao "estáticas"
 */
public enum MenuOpcao {
    QUALQUER("nao representa operacao"),
    INVALIDA("operacao invalida"),
    CRIAR_CONTA_CORRENTE_PF("criar conta corrente"),
    CRIAR_CONTA_CORRENTE_PJ("criar conta PJ"),
    SAIR("sair");

    private final String descricao;

    MenuOpcao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
