package models;

import models.clientes.Cliente;
import models.clientes.ClientePF;
import models.clientes.ClientePJ;
import models.seguros.Seguro;

import java.util.ArrayList;
import java.util.List;

public class Seguradora {
    private String cnpj;
    private String nome;
    private String telefone;
    private String email;
    private List<Cliente> listaClientes;
    private List<Seguro> listaSeguros;

    public Seguradora(String cnpj, String nome, String telefone, String email, List<Cliente> listaClientes, List<Seguro> listaSeguros) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.listaClientes = listaClientes;
        this.listaSeguros = listaSeguros;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Seguro> getListaSeguros() {
        return listaSeguros;
    }

    public void setListaSeguros(List<Seguro> listaSeguros) {
        this.listaSeguros = listaSeguros;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public boolean cadastrarCliente(Cliente cliente) {
        if (listaClientes.contains(cliente)) { return false; }

        listaClientes.add(cliente);
        return true;
    }

    public boolean removerCliente(Cliente cliente) {
        if (!listaClientes.contains(cliente)) { return false; }

        listaClientes.remove(cliente);
        return true;
    }

    public List<Cliente> listarClientes(String tipoCliente) {
        List<Cliente> clientes = new ArrayList<>();

        if (tipoCliente.equalsIgnoreCase("PF")) {
            for (Cliente cliente : getListaClientes()) {
                if (cliente instanceof ClientePF) { listaClientes.add(cliente); }
            }
        } else if (tipoCliente.equalsIgnoreCase("PJ")) {
            for (Cliente cliente : getListaClientes()) {
                if (cliente instanceof ClientePJ) { listaClientes.add(cliente); }
            }
        }

        return clientes;
    }
    public void visualizarSinistros(Cliente cliente) {
        System.out.println("Lista de sinistros do cliente: " + cliente.getNome());

        for (Sinistro sinistro : getSinistrosPorCliente(cliente)) {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(sinistro);
        }
    }

    public List<Sinistro> getSinistrosPorCliente(Cliente cliente) {
        List<Sinistro> sinistros = new ArrayList<>();

        for (Seguro seguro : getListaSeguros()) {
            if (seguro.getCliente() == cliente) {
                sinistros.addAll(seguro.getListaSinistros());
            }
        }

        return sinistros;
    }

    public List<Seguro> getSegurosPorCliente(Cliente cliente) {
        List<Seguro> seguros = new ArrayList<>();

        for (Seguro seguro : this.getListaSeguros()) {
            if (seguro.getCliente() == cliente) {
                seguros.add(seguro);
            }
        }

        return seguros;
    }

    public Double calcularPrecoSeguroCliente(Cliente cliente) {
        return cliente.calculaScore() * (1 + getSinistrosPorCliente(cliente).size());
    }

    public Double calcularReceita() {
        return listaClientes.stream()
                .map(cliente -> calcularPrecoSeguroCliente(cliente))
                .reduce(0.0, ((receitaTotal, receita) -> receitaTotal + receita ));
    }

    public boolean cancelarSeguro(Seguro seguro) {
        return listaSeguros.remove(seguro);
    }

    @Override
    public String toString() {
        return "Seguradora{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", listaSeguros=" + listaSeguros +
                ", listaClientes=" + listaClientes +
                '}';
    }
}