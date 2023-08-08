# LIG4-Java

##O que é?
O LIG4 é um jogo de estratégia para dois jogadores, onde cada jogador escolhe uma cor (normalmente vermelho ou amarelo) e alterna entre colocar uma peça em uma coluna do tabuleiro. O objetivo é ser o primeiro a formar uma sequência de quatro peças da mesma cor consecutivas na vertical, horizontal ou diagonal.

##Como jogar?
1. Clone este repositório para o seu computador ou faça o download do ZIP.
2. Abra o projeto em uma IDE compatível com Java, de preferência o VSCode.
3. No arquivo **launch.json**, na pasta .vscode, adicione uma configuração nova "Java: Launch Program" e adicione "vmArgs: --module-path <caminho-da-lib-javafx-sdk-20.0.1> --add-modules javafx.controls,javafx.fxml".
4. Verifique se em **Referenced Libraries** ou a pasta **lib** apresenta arquivos .jar. Caso contrário, abra a pasta "javafx-sdk-20.0.1" que se encontra no projeto, vá em lib e insira-os na pasta lib ou em referenced libraries.
5. Execute a classe MainClass.java para iniciar o jogo.
6. Escolha o modo de jogo desejado na tela inicial.
7. Jogue alternando entre os jogadores, selecionando a coluna onde deseja colocar a peça.
8. Continue jogando até que um jogador vença ou o tabuleiro fique cheio, resultando em empate.

##Modos de Jogo
O jogo precisa, necessariamente, de dois jogadores. Sendo possível jogar em 3 modos:
- Clássico
- Turbo: Ao inserir uma peça, qualquer peça vizinha horizontalmente a ela muda para a cor da peça inserida.
- Turbo Maluco: Qualquer peça vizinha em qualquer direção a uma peça inserida poderá mudar para a cor da peça inserida de acordo com uma probabilidade definida pelo nível de maluquice. Os níveis são: Dor de cabeça, Tarja preta e Hospício.

##Requisitos
Certifique-se de que você tenha os seguintes requisitos instalados:
- Java (versão 20.0.2)
- JavaFX (versão 20.0.1)

##Créditos
Este jogo foi desenvolvido por Igor Balbino e Mayanne Gomes como parte da avaliação na disciplina de LPOO do 3º período do curso de Engenharia da Computação (UPE).
