package com.example.servizio_clienti.repository;

import com.example.servizio_clienti.model.Cliente;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

public class ClienteRepository {
    private Vector<Cliente> clienti;
    private static final String CSV_HEADER = "id,nome,cognome,data di nascita,codice fiscale,mail,indirizzo\n";
    private static final String PATH = "src/main/java/com/example/servizio_clienti/repository/clienti.csv";
    public ClienteRepository() {
        this.clienti = loadClientiFromCSV();
    }

    public Vector<Cliente> findAllClients(){
        return this.clienti;
    }

    private Vector<Cliente> loadClientiFromCSV(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        Vector<Cliente> ret = new Vector<>();

        try(BufferedReader bfr = new BufferedReader(new FileReader(PATH))){
            String riga = bfr.readLine();// non leggo la prima riga
            riga = bfr.readLine();
            while(riga != null) {

                String[] stringa = riga.split(",");
                ret.add(new Cliente(Integer.parseInt(stringa[0]), stringa[1], stringa[2], LocalDate.parse(stringa[3], format), stringa[4], stringa[5], stringa[6], stringa[7]));
                riga = bfr.readLine();
            }
        }catch (FileNotFoundException e){}catch (IOException e){}

        return ret;
    }

    private void saveClientiToCSV() {
        File f = new File(PATH);

        try{
            if(!f.exists())f.createNewFile();
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(CSV_HEADER + this.toString());
            bw.flush(); //lo manda dal buffer al file
            bw.close();
            fw.close();
        }catch (IOException e){
            System.out.println("errore nella scrittura del file!");
        }

    }

    public Cliente findClienteById(int id){
        Cliente ret = null;
        for(Cliente x : clienti){
            if(x.getId() == id)
                ret = x;
        }
        return ret;
    }

    public Cliente searchClienti(String nome, String cognome){
        for (Cliente x : clienti){
            if(x.getNome().equals(nome) && x.getCognome().equals(cognome))
                return x;
        }
        return null;
    }

    public boolean updateCliente(Cliente cliente, int id){
        boolean ret = false;
        Cliente client_to_modify = findClienteById(id);
        if(client_to_modify != null){
            clienti.set(clienti.indexOf(client_to_modify), cliente);
            ret = true;
        }
        saveClientiToCSV();
        return ret;
    }

    public boolean insertCliente(Cliente cliente){
        boolean ret = false;
        if(findClienteById(cliente.getId())==null){
            int lastId = clienti.get(clienti.size()-1).getId();
            cliente.setId(lastId+1);
            clienti.add(cliente);
            saveClientiToCSV();
            ret = true;
        }
        return ret;
    }

    public boolean deleteCliente(int id){
        boolean ret = true;
        Cliente client_to_delete = findClienteById(id);
        if(client_to_delete != null) {
            clienti.remove(client_to_delete);
            ret =  true;
        }
        return ret;
    }

    @Override
    public String toString() {
        String s = "";
        for(Cliente x : clienti){
            s += x.toString();
        }
        return s;
    }

}
