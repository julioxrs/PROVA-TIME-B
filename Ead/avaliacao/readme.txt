Developed by: Thiago Augusto

Propósito: fazer com que o aluno possa avaliar os agendamentos com uma nota de 1 a 5

A pasta functions lista todas as classes 
	connection.php = Responsável pela conexão e métodos com o banco de dados utilizando PDO
	agendamento.php = Responsável pelos atributos e métodos de agendamento
	usuario.php = Responsável pelos atributos e métodos do usuário


How to connect:
Acesse o arquivo connection.php que está dentro da pasta functions e mude os atributos, responsáveis pela conexão
Utilize o sistema FrenteEad para acessar a parte de avaliação, pois o sistema utiliza sessões para acessar o sistema de avaliação
Dados pegos pelo sistema
Nome do usuário = $_SESSION['nome_usuario']
Tipo do usuário = $_SESSION['tipo_usuario']
Id do usuário = $_SESSION['id_usuario']

OBS: o usuário do tipo aluno somente avaliará os agendamentos que forem agendados pelo mesmo
     o usuário do tipo funcionário somente poderá ver a média de todos os agendamentos e outros dados gerais, ou escolher um usuário do tipo aluno através do e-mail e acessar os dados dos agendamentos gerais (média, etc) do mesmo, e pode saber se o mesmo é chato ou não.