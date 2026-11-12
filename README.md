# Vinteum – Jogo de 21 (Blackjack) em JavaFX

Este repositório contém a implementação completa do **Jogo de 21** (Blackjack) usando JavaFX e boas práticas de Programação Orientada a Objetos.

## 📋 Pré‑requisitos
- **JDK 27** instalado (ex.: `C:\Users\kaiky\.jdks\openjdk-27.0.1.0.3`).
- **IntelliJ IDEA** (Community ou Ultimate) com suporte a Maven.
- **Maven** (ou usar o Maven Wrapper que já está incluído).
- Conexão à internet apenas para a primeira execução, quando as dependências Maven são baixadas.

## 🚀 Como iniciar o projeto no IntelliJ
1. **Abrir o projeto**
   - `File ► Open…` → selecione a pasta `d:\3.Semestre\DS.II\vinteum` → **Open**.
   - Escolha **Import project from external model → Maven** e finalize.
2. **Configurar o SDK**
   - `File ► Project Structure… ► Project` → defina **Project SDK** para **JDK 27** (`C:\Users\kaiky\.jdks\openjdk-27.0.1.0.3`).
3. **Baixar dependências**
   - Abra o painel **Maven** (lado direito) e clique no ícone de **Refresh**.
4. **Rodar a aplicação**
   - **Opção A (recomendado)**: No canto superior direito selecione a configuração automática `vinteum:javafx:run` e aperte **Shift + F10**.
   - **Opção B**: Crie uma *Run Configuration* → **Application** → `Main class: com.example.App` → **Run**.
   - **Ou via Maven Wrapper**: abra o terminal interno e execute `./mvnw javafx:run` (ou `mvnw.cmd javafx:run` no Windows).

## 🧪 Testes de unidade
- Os testes estão em `src/test/java/com/example/JogoTest.java`.
- No IDEA, clique com o botão direito no arquivo e escolha **Run 'JogoTest'**.
- Todos os testes devem passar (verde).

## 📂 Estrutura do projeto
```
vinteum/
├─ src/main/java/com/example/          # Código‑fonte
│   ├─ App.java
│   ├─ PrimaryController.java
│   ├─ Naipe.java
│   ├─ Carta.java
│   ├─ Monte.java
│   ├─ Jogador.java
│   ├─ Computador.java
│   └─ Jogo.java
├─ src/main/resources/com/example/      # Recursos UI
│   ├─ primary.fxml
│   └─ classic-cards/*.png               # 52 imagens de cartas
├─ src/test/java/com/example/           # Testes
│   └─ JogoTest.java
├─ pom.xml                               # Maven + plugin JavaFX
├─ run.bat                               # Script de conveniência (mvn clean javafx:run)
├─ README.md
├─ CONTRIBUTING.md
└─ CHANGELOG.md
```

## 📦 Contribuindo
Veja o arquivo [`CONTRIBUTING.md`](CONTRIBUTING.md) para detalhes sobre como criar *pull requests*, testar localmente e usar o Maven Wrapper.

## 📄 Changelog
Veja o arquivo [`CHANGELOG.md`](CHANGELOG.md) para o histórico de versões.

---

Qualquer dúvida, abra uma *issue* ou pergunte diretamente!