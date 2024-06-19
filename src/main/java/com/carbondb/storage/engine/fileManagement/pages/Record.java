package com.carbondb.storage.engine.fileManagement.pages;

public class Record {
    /**
         Estrutura de um Registro

         ID: Identificador único (UUID, chave primária, etc.).
         Nome da Tabela: String que representa o nome da tabela.
         Carimbo de Tempo: Data e hora de criação ou modificação.
         Versão: Número da versão do registro.
         Campos de Dados:
         Campo 1: Valor do campo 1
         Campo 2: Valor do campo 2
         ...
         Campo N: Valor do campo N
         Referências de Índice: Posições ou ponteiros para entradas de índices.
         Ponteiros para Dados Adicionais: Ponteiros para outras páginas ou arquivos que contêm partes do registro (se necessário).

         Para um registro de um cliente, a estrutura poderia ser:

         ID: 123e4567-e89b-12d3-a456-426614174000
         Nome da Tabela: Clientes
         Carimbo de Tempo: 2024-06-18T15:23:01Z
         Versão: 1
         Campos de Dados:
         Nome: Alice
         Idade: 30
         Endereço: Rua XYZ, 123
         Referências de Índice: Índice de Clientes
         Ponteiros para Dados Adicionais: null (se não houver dados adicionais)
     */
}
