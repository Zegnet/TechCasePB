
# Case Técnico QA 2023 - Paraná Banco

O projeto apresentado tem como objetivo solucionar os itens propostos dentro do case técnico.


## Autores

- [@Zegnet](https://www.github.com/Zegnet)


## 1 - Cenário de Teste - Perguntas e Respostas

Imagina que você iniciou em uma equipe com um projeto do Zero. A proposta do projeto é a criação de uma solução para realizar compra de imóveis através de sistemas que facilitarão a comunicação de imobiliárias, clientes e bancos. A arquitetura está sendo desenhada a partir de solução de microsserviços e WebSites, está sendo mapeado integrações com sistemas externos, espera-se volume alto de operação uma vez que o sistema irá operar em todo o território Brasileiro, o cliente está bem próximo do projeto para levantamento de requisitos.

Usuários: Clientes e Bancos.
Arquitetura: Microsserviços e Sites.
Integrações: Sistemas Externos.
Utilização: Alto volume de acessos.

1. Dado esse cenário, como você iniciaria uma estratégia de teste?
    * Considerando que o levantamento de requisitos já foi realizado. Atuar na identificação das features a serem desenvolvidas e com base nestas elencar features de teste;
    * Definir práticas de teste, padrões e stack para desenvolvimento de automação de testes (alinhar junto a definição da stack desenvolvimento)
    * Atuar em conjunto ao time na etapa de backlog planning para pontuação das features e classificação de complexidades de teste, prioridade e entregas de valor;
    * Construir cenários de testes manuais classificando-os;
    * Definir stage de testes automatizados para integração contínua e entrega contínua;
    * Construir testes automatizados.
2. Quais abordagens de teste você consideraria?
    * Com objetivo de acompanhar as features e entregas de valor realizadas por desenvolvimento aplicaria como prática de testes os conceitos do shift-left testing;
    * Utilização de virtualização de serviços para um abordagens de desenvolvimento de testes automatizados continuos e até mesmo de agilizar o desenvolvimento do WebSite ainda com o back-end e construção (considerando a utilização de um serviço de virtualização a utilização de mocks nãos seria necessária);
    * Práticas de consumer-driven considerando a aplicação de testes de contrato;
    * Aplicação de práticas de TDD e BDD para desevolvimento de testes integrados e preparação para features automatizadas.
3. Como você trabalharia com diferentes tipos/níveis de teste?
    * Considerando as abordagens apresentados os níveis de teste seriam divididos e 3 (três) fases principais:
        * Integração;
        * Entrega;
        * Implatantação.

        Níveis em cada fase:
        
        * Integração
            * Testes Unitários;
            * Testes de Contrato;
            * Integração e Componente.
        * Entrega
            * Testes Ponta à Ponta (End-to-end);
            * Testes de Performance.
        * Implatantação
            * Testes de Fumaça (SmokeTest)
            * Testes Regressivos
4. Quais ferramentas você consideraria usar?
    * As ferramentas para aplicação dos testes iriam variar de acordo com a fase e com a stack de desenvolvimento (Considerando testes automatizados), porém poderiam ser:
        * Testes de Integração: SuperTest, JestFramework ou RestAssured;
        * Teste de Perfomance: LoadRunner;
        * Teste de Contrato: RestAssured, JestFramework ou Postman (Integrando o newman na pipeline de testes);
        * Testes Regressivos: Cypress ou Selenium.
5. Como você se imagina atuando nessa equipe?
    * Como Engenheiro de Qualidade, Automatizador ou até mesmo no papel de Líder Técnico geral de Automação.



## Cenários de Teste

Para o desenvolvimento de cenários de teste estarei seguindo o modelo de abordagens de teste demonstrada nas perguntas anteriores, dividos em 3 (três) etapas:
* Integração;
* Entrega;
* Implantação.

**Integração**

Cenário: Autenticação de usuários

Dado que desejo realizar autenticação da plataforma de busca de imóveis.
Quando preencho os campos do formulário de autenticação com os dados solicitados.
Então é apresentada página inicial.

Cenário: Validação de Score do cliente no Serasa

Dado que um cliente deseja comprar um imóvel na plataforma.
Quando preencho os campos do formulário de autenticação com os dados solicitados.
Então sistema busca informação de score no Serasa para validação de fatores de risco.

**Entrega**

Cenário: Finalização do processo de compra de um imóvel

Dado que desejo comprar o imóvel XPTO.
E adicionei o imóvel XPTO no carrinho de compras.
Quando quando preencho as informações de compra.
E clico no botão de finalização de compra
Então é apresentada tela de sucesso no processo de finalização de compra pela plataforma.


**Implantação**

(Cenários integrados e classificados em outras etapas também podem ser reaproveitados nesta etapa)

Cenário: Busca de imóveis utilizando filtros customizados

Dado que desejo comprar o imóvel XPTO.
Quando pesquiso o imóvel considerando características de cidade, valor, quantidade de comôdos.
Então é apresentado resultado de busca considerando os filtros informados.

## 2 - Automação de Testes


## Documentação

**  Bibliotecas e Linguagens**

    * Maven 3.9.4 [Download](https://maven.apache.org/download.cgi)
    * JDK 20 [Download](https://www.oracle.com/java/technologies/downloads/#jdk20-windows)
    * Selenium WebDriver 4.11.0
    * RestAssured 5.3.1
    * Java

** Patterns e Conceitos**

    * SOLID;
    * Singleton;
    * PageObject;
    * Factory.

** Configuração JDK**

    * Realizar o download da versão do JDK 20 (versão que o projeto foi construído, caso utilize versões anteriores o projeto pode não funcionar corretamente)
    * Acessar variáveis de ambiente da máquina;
    * Criar variável "JAVA_HOME" na seção "Variáveis de Sistema"
        * Nome da variável: "JAVA_HOME";
        * Valor da variável: C:\Program Files\Java\jdk-20 (O caminho pode variar caso o download da versão x86 tenha sido realizada. Necessário observar a arquitetura da CPU)
    * Após criação da variável "JAVA_HOME" acessar a variável "PATH" da seção "Variáveis de Sistema"
    * Acrescentar um novo valor seguindo o padrão ao lado: %JAVA_HOME%\bin (Apontamento necessário para identificação da JVM no sistema operacional)

**Configuração MAVEN**

    Para apresentar o passo à passo da configuração do maven, estou considerando a utilização da versão 3.9.4

    * Realizar o download da versão do MAVEN especifica (ou inferior);
        * Observação: Realizar o download do "Binary zip archive".
    * Extrair arquivo dentro do diretório raiz da máquina (C:);
    * Criar variável "MAVEN_HOME" na seção "Variáveis de Sistema"
        * Nome da variável: "MAVEN_HOME";
        * Valor da variável: C:\apache-maven-3.9.4 (O nome da pasta pode variar de acordo com a extração realizada e versão do maven que foi realizado download) 
    * Após criação da variável "MAVEN_HOME" acessar a variável "PATH" da seção "Variáveis de Sistema"
    * Acrescentar um novo valor seguindo o padrão ao lado: %MAVEN_HOME%\bin (Apontamento necessário para identificação dos arquivos binários do maven)
 
**Validação da instalação**

Para validar se a instalação/configuração foi realizada com sucesso, abrir o CMD como administrador e digitar os comandos abaixo:
    * Validação da JVM: java --version
        * Caso seja apresentado a versão do "Server VM" então a configuração foi realizada corretamente.
    * Validação do MAVEN: mvn --version
        * Caso seja apresentado a versão do "Apache Maven" então configuração foi realizada com sucesso.

