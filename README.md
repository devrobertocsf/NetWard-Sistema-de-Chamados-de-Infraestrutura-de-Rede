# 🦅 NetWard - Sistema de Chamados de Infraestrutura de Rede (Versão 1.0)

O **NetWard** é um simulador backend de Service Desk focado no gerenciamento de incidentes de infraestrutura de redes (como falhas em roteadores, switches, quedas de links e gerência de VLANs), alinhado com os conceitos de gerenciamento de serviços da **ITIL**.

Esta **Versão 1.0 (MVP)** foca no estabelecimento da arquitetura base do software, garantindo o ciclo de vida dos chamados e o relacionamento correto entre os ativos afetados, os tickets e a equipe técnica.

## 🎯 Conceitos de POO Aplicados nesta Versão

* **Agregação entre Classes**: Demonstração prática de relacionamento onde a classe `Chamado` possui como atributo um objeto da classe `Tecnico`. O chamado nasce órfão e ganha a referência do técnico dinamicamente no decorrer do fluxo.
* **Segurança de Tipos (Enums)**: O controle de estados do ticket é gerenciado via `StatusChamado`, eliminando o uso de strings mágicas ou constantes numéricas soltas e garantindo que o ciclo respeite estritamente os estados de negócio.
* **Controle de Timeline Comercial**: Uso da API `java.time` (`LocalDateTime`) para registrar timestamps imutáveis de abertura e fechamento de incidentes, preparando o sistema para futuros cálculos de auditoria e métricas de SLA.

## 🔄 Ciclo de Vida do Chamado na V1.0

1. **Instanciação (`ABERTO`)**: O chamado é gerado informando o equipamento e a descrição do problema. O sistema injeta a data/hora atual e marca o status inicial.
2. **Atendimento (`EM_ATENDIMENTO`)**: O método `atribuirTecnico(Tecnico tecnico)` altera o estado do chamado e vincula o profissional responsável pelo incidente.
3. **Resolução (`RESOLVIDO`)**: O método `resolverChamado()` encerra o fluxo, alterando o status e registrando o timestamp de encerramento.

## 📂 Estrutura de Arquivos do Projeto

* `entidade.enums/StatusChamado.java`: Enum estrutural com os estados (`ABERTO`, `EM_ATENDIMENTO`, `RESOLVIDO`).
* `entidades/Tecnico.java`: Classe contendo os dados do analista de redes (ID, Nome, Especialidade).
* `entidades/Chamado.java`: Classe agregadora e detentora das regras de negócio e transição de status.
* `aplicacao/Program.java`: Classe de execução que simula a abertura do chamado de um roteador degradado até a sua resolução.

## 💻 Saída Registrada no Console

```text
Chamado ID: 1
Equipamento: Roteador
Defeito: Sinal vermelho no equipamento
Status: EM_ATENDIMENTO
Aberto em: 2026-05-28T17:28:52
Fechado em: Ainda aberto
Técnico Responsável: Rodrigo
-----------------------------------

```

## 📈 Roadmap / Próximas Implementações

* [ ] **Versão 2.0**: Adicionar matriz de prioridade (Baixa, Média, Alta, Crítica) e controle de SLA.
* [ ] **Versão 3.0**: Criar uma interface de notificações polimórfica (E-mail/SMS/Discord Webhook) para alertar a equipe de plantão em caso de falhas críticas.

## 📄 Licença

Este projeto está sob a licença MIT.

---

*Projeto autoral desenvolvido por Roberto como parte do portfólio acadêmico em Ciência da Computação.*

---

