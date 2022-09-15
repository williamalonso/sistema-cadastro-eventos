<h1 align="center">
    Sistema de Cadastro de Eventos
</h1>

<div align="center">
  <img src="https://github.com/williamalonso/sistema-cadastro-eventos/blob/master/img/home.png" alt"Home Page" title="Sistema de cadastro de Eventos" width="600" />
  

---

</div>



### 🤔 Sobre o Sistema?

É um pequeno sistema feito em SpringBoot onde o usuário pode cadastrar e deletar eventos, como um casamento por exemplo. O usuário também pode adicionar e deletar convidados para seu evento.

---

## 🚀 Tecnologias

Esse projeto foi desenvolvido com as seguintes tecnologias:

- [HTML](https://developer.mozilla.org/pt-BR/docs/Web/HTML)
- [CSS](https://developer.mozilla.org/pt-BR/docs/Web/CSS)
- [Java](https://www.oracle.com/java/)
- [MySQL](https://www.mysql.com/)

---

### ✨ Sobre a construção do projeto:

- A página inicial lista seus eventos;
- É possível cadastrar novos eventos;
- É possível deletar eventos;
- Ao clicar no nome do evento é exibida uma página com os convidados;
- É possível adicionar e deletar convidados;


---

## 🙅 Instalações e usos

O sistema foi desenvolvido usando o Eclipse IDE for Enterprise Java Developers versão `2020-03 (4.15.0)` e o Java versão `1.8.0_333`.

A versão do SpringBoot usada é a `2.6.10`.

A versão do Mysql usada é a `8.0.30`.

Caso queira, clone ou faça o downlod desse repositório:

```
# Clone o repositório
$ git clone git@github.com:williamalonso/sistema-cadastro-eventos.git
```

Para importar o projeto no Maven, basta ir em "file -> import -> maven -> existing maven project" e em "root directory" selecionar a pasta do projeto e clicar em "finish".

Nota: se vc clonar o repositório para a pasta `D:\workspace\Project_Name` então quando abrir o Eclipe selecione a pasta `D:\workspace` para evitar conflito no arquivo `pom.xml` quando importar o projeto no Maven.

Dentro do pacote `com.eventoapp.eventoapp` existe o arquivo "DataConfiguration.java". Nele você deve colocar suas credenciais do seu banco Mysql, como "username" e "password".

Para rodar a aplicação, clique com o botão direto em cima do nome do projeto, depois selecione "run as -> java application".

Se for solicitado para selecionar a aplicação java, procure por `EventoappApplication - com.eventoapp.eventoapp`.

<h3 align="center">William Alonso</h3>
