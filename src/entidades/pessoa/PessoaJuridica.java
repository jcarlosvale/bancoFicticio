package entidades.pessoa;

import java.util.Objects;

public class PessoaJuridica extends Cliente {

    private String razaoSocial;
    private String cnpj;

    public PessoaJuridica(String razaoSocial, String cnpj) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaJuridica that = (PessoaJuridica) o;
        return Objects.equals(razaoSocial, that.razaoSocial) && Objects.equals(cnpj, that.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(razaoSocial, cnpj);
    }

    @Override
    public String toString() {
        return razaoSocial + " - CNPJ: " + cnpj;
    }
}
