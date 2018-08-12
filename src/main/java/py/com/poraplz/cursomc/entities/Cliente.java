package py.com.poraplz.cursomc.entities;

import py.com.poraplz.cursomc.entities.enums.TipoCliente;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
@Entity
public class Cliente implements Serializable{
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String cpfOuCnpj;
    private Integer type;
    @OneToMany(mappedBy = "client")
    private List<Direccion> adresses = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name="TELEFONO")
    private Set<String> phone = new HashSet<>();

    public Cliente() {
    }

    public Cliente(String name, String email, String cpfOuCnpj, TipoCliente tipo) {
        this.name = name;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.type = tipo.getCod();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public TipoCliente getTipo() {
        return TipoCliente.toEnum(this.type);
    }

    public void setTipo(TipoCliente tipo) {
        this.type = tipo.getCod();
    }

    public void setTipo(Integer tipo) {
        this.type = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpfOuCnpj='" + cpfOuCnpj + '\'' +
                ", type=" + type +
                ", adresses=" + adresses +
                ", phones=" + phone +
                '}';
    }
}
