package com.arrendamiento.proyect.mapper;

import com.arrendamiento.proyect.domain.Transaction;
import com.arrendamiento.proyect.dto.TransactionDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
* Mapper Build with MapStruct https://mapstruct.org
* MapStruct is a code generator that greatly simplifies the
* implementation of mappings between Java bean type
* based on a convention over configuration approach.
*/
@Mapper
public interface TransactionMapper {
    @Mapping(source = "cliente.idCliente", target = "idCliente_Cliente")
    @Mapping(source = "inmueble.idInmueble", target = "idInmueble_Inmueble")
    public TransactionDTO transactionToTransactionDTO(Transaction transaction);

    @Mapping(source = "idCliente_Cliente", target = "cliente.idCliente")
    @Mapping(source = "idInmueble_Inmueble", target = "inmueble.idInmueble")
    public Transaction transactionDTOToTransaction(
        TransactionDTO transactionDTO);

    public List<TransactionDTO> listTransactionToListTransactionDTO(
        List<Transaction> transactions);

    public List<Transaction> listTransactionDTOToListTransaction(
        List<TransactionDTO> transactionDTOs);
}
