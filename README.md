# Task Manager - Backend

Este é o backend do projeto **Task Manager**, desenvolvido em Java com Spring Boot. Ele fornece a API REST que gerencia as tarefas do sistema.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- MySQL

## Endpoints da API

- `GET /task-manager/list`  
  Retorna todas as tarefas cadastradas.

- `GET /task-manager/status-count`  
  Retorna a quantidade de tarefas agrupadas por status.

- `POST /task-manager/create`  
  Cria uma nova tarefa.  
  Exemplo de corpo da requisição:
  ```json
  {
    "nome": "Estudar Angular",
    "descricao": "Focar nos componentes",
    "dataCriacao": "2025-04-06",
    "status": "Pendente"
  }
  ```

- `PUT /task-manager/update`  
  Atualiza uma tarefa existente (requer o `id` no corpo do objeto).

- `DELETE /task-manager/delete/{id}`  
  Deleta a tarefa com o ID fornecido.

## Retorno das Requisições

As respostas retornam diretamente o objeto `Task` em exceção a rota de DELETE com os seguintes campos:

```json
{
  "id": 1,
  "nome": "Estudar Angular",
  "descricao": "Focar nos componentes",
  "dataCriacao": "2025-04-06",
  "status": "Pendente"
}
```

Em caso de erro, é retornada uma `Exception` padrão do Spring Boot.

## Como executar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/JulioFernandes14/task-manager-api
   ```

2. Importe o projeto no **Spring Tool Suite** ou na **IDE de sua preferência**.

3. Certifique-se de ter o **MySQL** rodando localmente com a seguinte configuração:
   - Usuário: `root` *(ou o seu usuário MySQL)*
   - Senha: `root1` *(ou sua senha MySQL)*
   - Banco: `bancoclientes`

> ✅ O banco de dados e as tabelas serão criados automaticamente na primeira execução.

4. Rode a aplicação (classe com `@SpringBootApplication`).

## CORS

O CORS está configurado para permitir requisições vindas da porta `4200` (default do Angular).

## Porta da Aplicação

A aplicação roda na porta padrão `8080`.

---

Pronto! O backend estará acessível em `http://localhost:8080`.
