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
}
