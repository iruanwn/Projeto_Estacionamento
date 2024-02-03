
package com.senac.Estacionamentoweb.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data 
@Entity 
@Table(name="cliente")
public class ClienteEntity {
@Id 
@GeneratedValue(strategy = GenerationType.AUTO) 
Integer id;
String nome ;
String cpf;
String modelo;
String placa ;

}
