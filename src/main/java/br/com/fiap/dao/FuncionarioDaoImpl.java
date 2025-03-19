package br.com.fiap.dao;

import br.com.fiap.entity.Funcionario;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNaoEncontradoException;

import javax.persistence.EntityManager;

public class FuncionarioDaoImpl implements FuncionarioDAO{

    private EntityManager em;

    public FuncionarioDaoImpl(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Funcionario funcionario) {
        em.persist(funcionario);
    }

    public void atualizar(Funcionario funcionario) throws IdNaoEncontradoException {
        buscarPorId(funcionario.getId());
        em.merge(funcionario);

    }

    public void remover(int id) throws IdNaoEncontradoException {
        Funcionario funcionario = buscarPorId(id);
        em.remove(funcionario);
    }

    public Funcionario buscarPorId(int id) throws IdNaoEncontradoException {
        Funcionario funcionario = em.find(Funcionario.class, id);
        if (funcionario == null) {
            throw new IdNaoEncontradoException("Funcionário não encontrado!");
        }
        return funcionario;
    }

    public void commit() throws CommitException {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new CommitException();
        }
    }
}
