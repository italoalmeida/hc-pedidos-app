# hc-pedidos-backend

Aplicação backend para pedidos de pratos via API RESTful

## Consultar cardápio

  Retorna a lista de pratos disponíveis.

### URL

  /cardapio

### Método:

  `GET`

### Sucesso:

##### Código: 200 OK

##### Conteúdo:

    [
      {
        "nome": "Frango à Parmegiana",
        "acompanhamentos": [
          "Spaghetti",
          "Arroz",
          "Feijão",
          "Purê de Batatas"
        ],
        "preco": 14.9
      }
    ]

### Falha:

##### Código: 404 NOT FOUND

##### Conteúdo: 
    { 
      mensagem: "No momento não existem pratos disponíveis.",
      codigo: 404
    }

## Fazer pedido

  Salva lista de pratos que compõem o pedido.

### URL

  /pedido

### Método:

  `POST`

### Sucesso:

##### Código: 200 OK

##### Conteúdo: Código que foi gerado para o pedido.

### Falha:

##### Código: 406 NOT ACCEPTABLE

##### Conteúdo: 
    { 
      mensagem: "Informe ao menos um prato para realizar seu pedido.",
      codigo: 406
    }

OU

##### Código: 400 BAD REQUEST

##### Conteúdo: 
    { 
      mensagem: "JSON inválido.",
      codigo: 400
    }

## Consultar pedido

  Retorna a lista de pratos registrados no pedido.

### URL

  /pedido/:cod

### Método:

  `GET`

### Sucesso:

##### Código: 200 OK

##### Conteúdo:

    [
      {
        "nome": "Frango à Parmegiana",
        "acompanhamentos": [
          "Spaghetti",
          "Arroz",
          "Feijão",
          "Purê de Batatas"
        ],
        "preco": 14.9
      }
    ]

### Falha:

##### Código: 404 NOT FOUND

##### Conteúdo: 
    { 
      mensagem: "Pedido não encontrado.",
      codigo: 404
    }