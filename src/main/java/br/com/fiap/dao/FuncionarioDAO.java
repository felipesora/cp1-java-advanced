package br.com.fiap.dao;

public interface FuncionarioDAO {
    void cadastrar(Funcionario funcionario);

    void atualizar(Funcionario funcionario) throws IdNaoEncontradoException;

    void remover(int id) throws IdNaoEncontradoException;

    Funcionario buscarPorId(int id) throws IdNaoEncontradoException;

    void commit() throws CommitException;
}
