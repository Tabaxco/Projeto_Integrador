package modelos;

import java.sql.Date;

public class Funcionario {
    private int ID_Funcionario;
    private String nome;
    private String cargo;
    private String telefone;
    private double salario;
    private String departamento;
    private String email;
    private String usuario;
    private String senha;
    private Date dataCadastro;

    public Funcionario() {}

    public Funcionario(int ID_Funcionario, String nome, String cargo, String telefone,
                       double salario, String departamento, String email,
                       String usuario, String senha, Date dataCadastro) {
        this.ID_Funcionario = ID_Funcionario;
        this.nome = nome;
        this.cargo = cargo;
        this.telefone = telefone;
        this.salario = salario;
        this.departamento = departamento;
        this.email = email;
        this.usuario = usuario;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
    }

    public int getID_Funcionario() { return ID_Funcionario; }
    public void setID_Funcionario(int ID_Funcionario) { this.ID_Funcionario = ID_Funcionario; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public Date getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(Date dataCadastro) { this.dataCadastro = dataCadastro; }
}