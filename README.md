<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<div class="container-fluid" style="background-color: #4281A4;">
    <h1 style="text-align: center; padding-top: 25px; color: white;">Implementação da API para controle da vacinação
    </h1>

    <div class="d-flex justify-content-center mt-4">
        <div class="col-md-7 mb-4">
            <h2 style="color: white; font-size: 15pt;">Nesse artigo sera examinado objetivamente a utilização de tecnologias e ferramentas no ecossistema Spring e o seus recursos para o desenvolvimento do sistema solicitado no desafio.</h2>
        </div>
    </div>
</div>

<br><br>

<ul>

    <li>
        <h2>Mapeamento objeto-relacional: De classe a tabela</h2>
        <br>Tendo em vista a necessidade de armazenamento de informações no banco de dados, existe uma técnica que estabelece uma interface que promove uma compatiblidade entre o uma linguagem OO (o Java) e o um banco de dados relacional (nesse caso o
        MySQL); esse paradigma se chama o ORM, e o foco dessa seção será justamente contemplar o framework
        <strong>Hibernate</strong>. <br>
        <br> Para a comunicação direta com o banco de dados, foi empregado o auxílio do JPA (acrônimo de Java Persistence API) - é uma especificação que oferece um conjunto de regras e comportamentos esperados a serem seguidos, é um template que sugere
        formas do framework ser integrado. O Hibernate por sua vez, é reponsável por mapear as tabelas de um banco de dados para uma classe da linguagem, definindo um denominador comun nas entidades. O conceito que promove esse tipo de framework é a capacidade
        de persistir, consultar, atualizar, apagar, realizar todo o CRUD sem a necessidade de lidar diretamente com SQL.
        <br><br><br>
        <div class="col-md-6">
            <p style="font-size: 10pt;">
                Persistência: Característica de determinados dados permanecer na memória mesmo após o estado que o criou se ausentar. Sem essa capacidade o estado só existiria na RAM e seria perdido quando a RAM parasse.
            </p>
        </div>


        <div class="row">

            <div class="col-md-6">
                <img src="C:\Users\usuario\Desktop\developmentSpringREST\OrangeTalents\Approachs\Conecptions/persista.png" style="width: 500px;" alt="Persistência">
            </div>

            <div class="col-md-6 d-flex align-items-center">
                <p style="font-size: 20pt;">
                    <i>
                        Para melhorar a didática da interação entre JPA e Hibernate, veja o JPA como uma interface e o
                        Hibernate como a classe dessa implementação.
                    </i>

                </p>

            </div>

        </div>


        <br>

    </li>

    <br><br><br><br><br>

    <li>
        <h2>Inicializando o projeto</h2>
        <div class="row">

            <div class="col-md-5">
                <p style="font-size: 10pt;">Dependências selecionadas para o desenvolvimento da proposta</p>
                <ol>
                    <li>
                        Spring Boot DevTools
                        <br>Esse módulo tem o objetivo de otimizar o tempo do desenvolvimento; O Spring BootDevTools aplica as mudanças do código reiniciando a aplicação a cada save
                    </li> <br><br>

                    <li>
                        Validation
                        <br> É uma especificação que disponibliza um conjunto de restrições; A anotação @NotNull, por exemplo proibe campos nulos atendendo à obrigaridade exigida. (Veja a linha 26 do código abaixo)
                        <br><br>
                        <img src="C:/Users/usuario/Desktop/developmentSpringREST/OrangeTalents/Assets/@Notnull.png" alt="Trecho de códigos autorias">
                    </li>

                    <br><br>

                    <li>
                        Spring Data JPA
                        <br> Esse framework parte da grande família Spring, torna mais facil a implementação dos repository em JPA, além de que auxilia na comunicação com o banco de dados, traduzindo os comandos do Java para os comandos do mySQL.
                        <br><br><img src="C:/Users/usuario/Desktop/developmentSpringREST/OrangeTalents/Assets/repository.png" alt="">
                    </li>
                    <br><br><br>

                    <li>MySQL Driver
                        <br>Promove a conectividade o MySQL; utilizado para verificar a entrada dos dados.
                    </li>
                    <br><br><br>

                    <li>Spring Web
                        <br>Essa dependência foi incluído para deixar o sistema "na agulha" para futursas implementação na web
                    </li>
                </ol>
            </div>

            <div class="col-md-4">
                <img src="C:/Users/usuario/Desktop/developmentSpringREST/OrangeTalents/Assets/Dependecies.png" alt="Dependecies">
            </div>

        </div>

    </li>



    <br><br><br><br><br>




    <li>
        <h2>Padrão arquitetural das classes (em camadas)</h2>

        <br>

        <p style="font-size: 14;">
            Árvore dos pacotes com suas respectivas classes/interfaces e a classe primordial que executa a aplicação
        </p>

        <img src="C:/Users/usuario/Desktop/developmentSpringREST/OrangeTalents/Assets/classMain.png" alt="">
        <br><br><br><br>

        <div class="row d-flex justify-content-center">
            <h3>Camada dos Repositórios</h3>
        </div>

        <ol>
            <li> <i style="font-size: 16pt;"> Armazenamento para a tabela de vacinação </i>
                <br><br>
                <code style="font-size: 18pt;">
                    public interface VacRepository extends JpaRepository &ltVacModel, Long> { }
                </code>
                <br>O repositório foi definido dessa forma como uma interface, que herda JpaRepository, e é parametrizada como argumento a classe da entidade(VacModel) e o tipo de dado Long; uma classe fornecida pela dependência Spring Data JPA (explicada
                na seção acima) que proporciona uma interação direta com o banco de dados
            </li>

            <br><br><br>

            <li> <i style="font-size: 16pt;"> Armazenamento para a tabela dos usuários </i>
                <br><br>
                <code>
                    @Repository <br>
                    public interface UserRepository extends JpaRepository&ltUserModel, Long> { }
                </code>
                <br>Mesma lógica do repositório de vacinação, alterando somente a classe da entidade para UserModel
            </li>
        </ol>



        <br><br><br>

        <div class="row d-flex justify-content-center">
            <h3>Camada das Model</h3>
        </div>
        <p class="d-flex justify-content-center">Camada que repercute por todo o sistema, aqui é modelado o objeto e seu respectivo relacionamento que permeia as outras entidades do banco de dados</p>

        <br><br>

        <ol>
            <li> <i style="font-size: 16pt;"> Classe de usuários </i>
                <div class="col-md-6">
                    <br><br> No código abaixo começamos ver a importância do JPA + a bean Validation em uma abordagem mais prática: fornece propriedades desejaveis aos atributos, como @NotNull indicando obrigatoriedade e nas @Columns é possível exigir
                    somente valores únicos
                </div>

                <br><br>

                <p style="font-size: 10pt;">
                    Da linha 39 à linha 40 é estabelecida uma Foreign Key
                </p>

                <img src="C:/Users/usuario/Desktop/developmentSpringREST/OrangeTalents/Assets/UserModel.png" alt="">
            </li>

            <br><br><br>



            <li> <i style="font-size: 16pt;">Classe de vacinação </i>
                <div class="col-md-6">
                    <br><br> Nessa outra classe abaixo, é utilizado algumas novas anotações... @Temporal também é um propriedade do JPA, e nessa aplicação ele registra o exato momento em que o registro da entrada no banco de dados. (Obs: é utilizado dois
                    atributos para marcar a data, da linha 37 é ajustavel.)
                    <br><br> Da linha 41 à 43, o código atende o desafio bônus e passa a relacionar o id do usuário substituindo o email.
                </div>


                <p style="font-size: 10pt;">
                    Da linha 39 à linha 40 é estabelecida uma Foreign Key
                </p>

                <img src="C:/Users/usuario/Desktop/developmentSpringREST/OrangeTalents/Assets/Vacina.png" alt="">
            </li>


        </ol>



        <br><br><br>

        <div class="row d-flex justify-content-center">
            <h3>Camada dos Controller</h3>
        </div>
        <p class="d-flex justify-content-center">É nesse momento que os endpoints serão construídos</p>

        <br><br>


        <i style="font-size: 16pt;"> Cadastros</i>
        <div class="col-md-6">
            <br><br> Na imagem abaixo que exibe as linha do código, podemos ver a anotação @RestContoller logo no ínicio, a anotação que índica que a classe se tratar de um controlador dos endpoints.
            <br>@RequestMaping define a rota de acesso (na linha 18) e na próxima linha vemos a anotação @CrossOrigin que designa que a API pode ser acessada em qualquer plataforma

            <br><br> Há duas anotações do @Autowired (injeção de dependência) para cada repositório de registro. Esse recurso permite trabalhar com os respectivos repositório com um baixo nível de acomplamento, o que resulta em uma certa independência
            das classes, e previne o projeto de possíveis problemas.

            <br><br> A anotação @PostMapping vai tentar fazer a persistência dos dados, e vai conseguir se todas as regras for atendida, criando um novo registro no banco de dados.
            <br> A anotação @RequestBody espera os dados no corpo da requisição para que seja então desserializado na construção do objeto e então sendo persistido nos registros através da comunicação com o banco de dados.

        </div>

        <br><br>

        <p style="font-size: 10pt;">
            O try/catch faz uma especie de tratamento para que haja somente os status esperado (201 e 400 )
        </p>

        <img src="C:/Users/usuario/Desktop/developmentSpringREST/OrangeTalents/Assets/Cadastro.png" alt="">
    </li>

    <br><br><br>





    <br><br><br>






    <li>
        <p>
            <h2>Comprovando em tempo de execução</h2>
            Então configurando o <b>application.properties</b> conforme a ilustração, já é garantido o banco de dados.
        </p>

        <div class="row">
            <div class="col-md-6">

                <br>
                <img src="C:/Users/usuario/Desktop/developmentSpringREST/OrangeTalents/Assets/properties.png" alt="">
            </div>
        </div>

        <br><br><br> <b style="font-size: 24;">Com a aplicação rodando é efetuado o cadastro do primeiro usuário</b>
        <br><br>

        <img src="C:/Users/usuario/Desktop/developmentSpringREST/OrangeTalents/Assets/ps-user.png" alt="">

        <br><br><br> <b style="font-size: 24;">Passando para o registro da aplicação da vacína nessa usuário é efetuado o registro no banco de dados </b>
        <br><br>

        <img src="C:/Users/usuario/Desktop/developmentSpringREST/OrangeTalents/Assets/ps-vac.png" alt=""> br>

        <br><br> <b style="font-size: 24;">Porém se for indicado um id de usuário inexistente (o que pode ser facilmente impedido no front end) ele retorna o erro 400! </b>
        <br><br>

        <img src="C:/Users/usuario/Desktop/developmentSpringREST/OrangeTalents/Assets/br.png" alt="BadRequest"> br>

        <br><br> <b style="font-size: 24;">E a imagem do banco de dados abaixo exibe o registro da aplicação da vacina. </b>
        <br><br>

        <img src="C:/Users/usuario/Desktop/developmentSpringREST/OrangeTalents/Assets/database.png" alt="">

    </li>







    <br><br><br>







    <li>
        <h2>Como faria a implementação do sistema na Web</h2>
        <br>
        <div class="col-md-8">
            Provavelmente seria embasado no wireframe abaixo (desenvolvido no figma) com o emprego do framework Angular, criando uma single-page; os caminho no service dos component seria indicado para o devido endpoint, e então com o projeto finalizado executaria
            uma build e teria uma relação de arquivos para submeter no public do projeto do Backend para que possa hospedar a aplicação no Heroku, por exemplo, e ver o seu comportamento em tempo real.
        </div>

        <br>
        <img src="C:/Users/usuario/Desktop/developmentSpringREST/OrangeTalents/Assets/Wireframes.png" alt="">


        </div>
    </li>
</ul>
<br><br>

<footer class="d-flex justify-content-center" style="background-color: yellow;">
    <span class="my-2"> <b>© 2021 Copyright: João Pedro Sena da Silva. Todos os direitos reservados.</b> </span>
</footer>
