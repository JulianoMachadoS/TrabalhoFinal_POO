Trabalho final de Poo

Alunos:
- Eduardo Godois Saldanha
- Francisco Schardosim Ferreira
- Juliano Machado da silva

# Gerenciamento de personagens RPG.

O projeto foi pensado para ser usado por pessoas que jogam RPG de mesa (Role-Playing Game ou jogo de interpretação de papéis). Ele tem como finalidade guardar e gerenciar fichas de personagens. Os campos em RPG de mesa são muito diversos, mas neste sistema foi adotada uma lógica mais simples, com menos campos do que no habitual.

O sistema conta com personagens de duas classes principais: Guerreiro e Mago. Essas classes herdam características gerais da classe Personagem, como nome, nível, vida e ataque. Cada uma delas também possui seus próprios atributos específicos. O Guerreiro possui arma, força e defesa. O Mago possui elemento mágico, mana e poder mágico.

A ideia do projeto não é substituir uma ficha tradicional completa de RPG, mas sim funcionar como uma ficha simplificada e digital. A finalidade principal é facilitar para o mestre da mesa, permitindo que ele tenha os personagens cadastrados e organizados em um só lugar, podendo consultar rapidamente suas informações principais.

No sistema, a vida e o ataque dos personagens são calculados automaticamente de acordo com o nível e a classe escolhida. Esses valores não são alterados manualmente, pois representam atributos base do personagem. Dessa forma, o sistema mantém uma regra fixa e evita que personagens de mesmo tipo e nível tenham valores muito desproporcionais.

O projeto permite cadastrar novos personagens, listar todos os personagens cadastrados, procurar por nome ou classe, editar dados, remover personagens e visualizar estatísticas gerais. Também possui uma tela de destaques, que mostra personagens com maior nível, maior ataque, guerreiro com maior defesa e mago com maior poder mágico.

Todos os dados ficam armazenados apenas em memória durante a execução. O sistema também já inicia com alguns personagens de exemplo.

**Autoavaliação: 9,5/10.**

Nossa nota para o trabalho é 9,5, pois ele atende a todos os requisitos solicitados, compila e roda sem erros. A nota não chegou a 10 porque, apesar de o sistema estar funcional, algumas melhorias de organização ainda poderiam ser feitas em uma versão futura. Por exemplo, a tela de listagem ainda concentra algumas ações da interface, como ordenar, abrir a edição, remover personagens e formatar os dados exibidos na lista. Mesmo assim, as buscas por nome e por classe foram colocadas no GerenciadorPersonagens, deixando a separação de responsabilidades mais clara.