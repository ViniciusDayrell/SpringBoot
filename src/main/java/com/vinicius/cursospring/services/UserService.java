package com.vinicius.cursospring.services;

import com.vinicius.cursospring.entities.User;
import com.vinicius.cursospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository; //Injeção de dependência por atributo

    //Melhoria: Usar injeção de dependência por construtor (Boa prática)

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        /* Optional: Classe que funcina como um recipiente (Pode conter um obj ou estar vazio)
        * Caso o usuário exista, contém o obj. Caso não, retorna Optional.empty()
        * Problema: Buscar usuário que não existe lançará uma exceção NoSuchElementException. Pode resultar um uma resposta HTTP 500 (erro no servidor)
        * */
        Optional<User> obj = repository.findById(id);
        return obj.get(); //Acessa o obj que está dentro do Optional

        //Melhoria: Trocar o Optional para uma Exception (orElseThrow). Adicionar validação
    }
}
