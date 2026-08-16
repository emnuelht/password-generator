# Gerador de Senhas

Uma API REST desenvolvida em **Java + Spring Boot** para geração de senhas aleatórias com diferentes tipos de caracteres.

> 📚 Projeto desenvolvido para fins de estudo, com o objetivo de praticar Java, Spring Boot, APIs REST, validação e padrões de projeto.

## 🚀 Funcionalidades

A API permite configurar a senha de acordo com as seguintes opções:

* Quantidade de caracteres
* Letras minúsculas
* Letras maiúsculas
* Caracteres especiais
* Números

A geração é feita de forma dinâmica de acordo com os parâmetros informados.

## 🛠️ Tecnologias

* Java
* Spring Boot
* Spring Web
* Spring Validation
* Springdoc OpenAPI / Swagger
* Gradle

## 🔐 Gerar senha

### GET `/api/generate`

Endpoint responsável pela geração da senha.

### Parâmetros

| Parâmetro            | Tipo      | Obrigatório | Descrição                                   |
| -------------------- | --------- | ----------: | ------------------------------------------- |
| `quantity`           | `integer` |         Sim | Quantidade de caracteres da senha           |
| `characterUpperCase` | `boolean` |         Sim | Define se a senha terá letras maiúsculas    |
| `characterSpecial`   | `boolean` |         Sim | Define se a senha terá caracteres especiais |
| `numbers`            | `boolean` |         Sim | Define se a senha terá números              |

### Exemplo

```http
GET /api/generate?quantity=26&characterUpperCase=true&characterSpecial=true&numbers=true
```

Ou utilizando `curl`:

```bash
curl -X GET \
  "http://localhost:8080/api/generate?quantity=26&characterUpperCase=true&characterSpecial=true&numbers=true" \
  -H "accept: */*"
```

### Resposta

```text
-qax4wN!eo[0yMH:v5tp82Irb
```

O tamanho da senha retornada corresponde ao valor informado em `quantity`.

## ⚙️ Exemplo de configuração

Para gerar uma senha de 12 caracteres contendo letras maiúsculas, caracteres especiais e números:

```text
GET /api/generate?quantity=12&characterUpperCase=true&characterSpecial=true&numbers=true
```

Exemplo de resposta:

```text
;\u1vk5BzLhc
```

> A senha retornada será diferente a cada requisição.

## 🏗️ Estrutura

O projeto utiliza diferentes implementações para os tipos de caracteres utilizados na geração:

```text
Generate
├── CharacterLowerCaseImpl
├── CharacterUpperCaseImpl
├── CharacterSpecialImpl
└── NumbersImpl
```

A geração dos caracteres é organizada de forma modular, permitindo adicionar novos tipos de caracteres ou novas estratégias de geração futuramente.

## 🧪 Validações

A requisição possui validações para garantir que os parâmetros estejam dentro dos valores permitidos.

Por exemplo, a quantidade de caracteres possui limite máximo de **26**:

```text
quantity >= 8 && quantity <= 26
```

Valores fora desse intervalo serão rejeitados pela validação.

## 📌 Exemplo de requisição

```text
quantity=16
characterUpperCase=true
characterSpecial=true
numbers=true
```

Resultado possível:

```text
_Tp0gZ6inq*l/aD1
```
