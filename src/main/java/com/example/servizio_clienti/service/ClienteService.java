package com.example.servizio_clienti.service;

import com.example.servizio_clienti.model.Cliente;
import com.example.servizio_clienti.repository.ClienteRepository;

import java.util.Vector;

public class ClienteService {
    private ClienteRepository clienteRepository;
    public ClienteService(){
        this.clienteRepository = new ClienteRepository();
    }

    public Vector<Cliente> getAllClients(){
        return clienteRepository.findAllClients();
    }

    public Cliente getClienteByID(int id){
        return clienteRepository.findClienteById(id);
    }

    public Cliente searchClienti(String nome, String cognome){
        return  clienteRepository.searchClienti(nome, cognome);
    }
}
