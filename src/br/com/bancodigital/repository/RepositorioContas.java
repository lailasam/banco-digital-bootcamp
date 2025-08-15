package br.com.bancodigital.repository;
import java.util.ArrayList;
import java.util.List;

//CRUD - CREATE, READ, UPDATE, DELETE
public class Repositorio <T> {
private List<T> lista;
public Repositorio() {
    this.lista = new ArrayList<>();
}
public void criar(T objeto) {
    this.lista.add(objeto);
}
public List<T> listar() {
    return this.lista;
}
public void atualizar(T objeto, int indice){
    this.lista.stream().filter(index->this.lista.indexOf(index) == indice)
            .forEach(index -> {
                this.lista.set(this.lista.indexOf(index), objeto);
    });
}
public void remover(T objeto) {
    this.lista.remove(objeto);
}
}
