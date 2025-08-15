Conversor de Moedas 💱

Projeto Java simples que permite converter valores entre 6 pares de moedas diferentes, desenvolvido no IntelliJ IDEA utilizando Maven. Ideal para treinar conceitos básicos de Java, entrada de dados via console, uso de enums e operações com BigDecimal.

Funcionalidades

6 opções fixas de conversão de moedas:

BRL → USD

USD → BRL

BRL → EUR

EUR → BRL

BRL → ARS

ARS → BRL

Conversão precisa utilizando BigDecimal.

Menu interativo no console.

Tratamento de entradas inválidas.

Tecnologias utilizadas

Java 17

Maven

IntelliJ IDEA

Estrutura do projeto

conversor-moedas/
 ├─ pom.xml
 └─ src/
    └─ main/
       └─ java/
          └─ com/
             └─ exemplo/
                └─ conversor/
                   └─ Main.java

Como executar

Pelo IntelliJ

Abra o projeto.

Vá até a classe Main.java.

Clique em Run.

Pelo terminal

mvn clean package
java -jar target/conversor-moedas-1.0.0.jar

Como clonar e rodar

git clone https://github.com/SEU_USUARIO/conversor-moedas.git
cd conversor-moedas
mvn clean package
java -jar target/conversor-moedas-1.0.0.jar

.gitignore recomendado

# Maven
target/
# IntelliJ IDEA
.idea/
*.iml
# SO
.DS_Store
Thumbs.db
# Logs e compilação
*.log
*.class

Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.

Licença

Este projeto está licenciado sob a licença MIT - consulte o arquivo LICENSE para mais detalhes.
