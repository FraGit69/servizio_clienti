package com.example.servizio_clienti.controller;

import com.example.servizio_clienti.model.Cliente;
import com.example.servizio_clienti.service.ClienteService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.Vector;

@RestController
@RequestMapping("/api/servizioClienti")
public class ClienteController {
    private ClienteService clienteService;
    public ClienteController(){
        this.clienteService = new ClienteService();
    }

    @RequestMapping
    public Vector<Cliente> getAllStudents(){
        return clienteService.getAllClients();
    }

    @RequestMapping("/{Id}")
    public Cliente getClienteByID(@PathVariable int Id){
        return clienteService.getClienteByID(Id);
    }

    @RequestMapping("/{nome}/{cognome}")
    public Cliente searchClient(@PathVariable String nome,@PathVariable String cognome){
        return clienteService.searchClienti(nome, cognome);
    }
}
