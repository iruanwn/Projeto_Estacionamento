
package com.senac.Estacionamentoweb.Service;

import com.senac.Estacionamentoweb.Data.ClienteEntity;
import com.senac.Estacionamentoweb.Data.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class ClienteService {
@Autowired 
ClienteRepository clienterepository;

    public ClienteEntity criarCliente(ClienteEntity cliente) { 
    cliente.setId(null); 
   clienterepository.save(cliente); 
    return cliente; 
} 
    public ClienteEntity atualizarCliente(Integer clienteid, ClienteEntity clienteRequest) { 

    ClienteEntity cli= getclienteId(clienteid); 
    
    cli.setNome(clienteRequest.getNome());
    cli.setCpf(clienteRequest.getCpf());
    cli.setModelo(clienteRequest.getModelo());
    cli.setPlaca(clienteRequest.getPlaca());
    clienterepository.save(cli);
return cli; 
} 
        public ClienteEntity getclienteId(Integer clienteId) {
        return clienterepository.findById(clienteId).orElse(null); 
    }
        public List<ClienteEntity> listarTodosClientes() { 
    return clienterepository.findAll(); 
} 
        public void deletarCliente(Integer clienteId) { 
    ClienteEntity cliente = getclienteId(clienteId); 
clienterepository.deleteById(cliente.getId()); 
} 
}