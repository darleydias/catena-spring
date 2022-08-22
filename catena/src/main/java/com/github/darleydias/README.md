### QueryMetods TA
-----------

### Intalação InteliJ

sudo wget https://download.jetbrains.com/idea/ideaIC-2019.3.3-jbr8.tar.gz

sudo ~/.config/autostart/jetbrains-toolbox.desktop

Abrir "{installation home}/bin"

Digitar: ./idea.sh
 
 
#### GIT
> git init 
##### Se ja exitir o remoto
> git remote add origin https://github.com/darleydias/aula-react.git
##### Se estiver baixando primeiro
> git clone https://github.com/darleydias/aula-react.git
> git config --global user.name "darleydias"
> git config --global user.email "darlley@gmail.com"
> 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
>
#### Pagina H2 - 

> http://localhost:8000/catena/h2-console/login.do?jsessionid=9070234c0261d8b20e326328262a651a


> sudo git checkout -b dev1
> sudo git add .
> sudo git commit -m "1.0.0"
> sudo git push --set-upstream origin dev1
> sudo git push --set-upstream dev1
> sudo git push
> sudo git push https://github.com/darleydias/aula-react.git

#### São expressoes que se aplicam a uma classe model e seus atributos, que se tranformam numa query.

##### Exemplo

> findByDescriLike

> findByNomeOrId

##### A ordem dos parametros é importante

> findByNomeOrIdOrderById(String,nome,id)


##### Só retorna um. Se tiver mais de um retorna exception 

> findOneByCPF(String cpf)

##### Verificando se existe um objeto pelo id

> boolean existsByNome(String nome)

#### Métodos usados na pagina inicial (catenaApplication.java)

#### Para mostrar os sql gerados temos que configurar o application.properties

spring.jpa.properties.hibernate.show_sql=true;
spring.jpa.properties.hibernate.format_sql=true;


#### INSERINDO UMA QUERY

> @Query(value = "select c from Comarca c where c.nome like :nome)

> List<Comarca> encontrarNome = (@Param("nome") String nome)

##### Poderia ser SQL Nativo:

> @Query(value = "select c from Comarca c where c.nome like :nome,nativeQuery = true)

> List<Comarca> encontrarNome = (@Param("nome") String nome)



@Bean
    public CommandLineRunner init(@Autowired Comarcas comarcas){
        return args -> {
            // ********* INSERIR
            comarcas.save(new Comarca("Montalvania Cassiterita","Especial"));
            comarcas.save(new Comarca("Lambarí Bagre","Odinaria"));
            List<Comarca> lista = comarcas.findAll();
            lista.forEach(System.out::println);

            // ******** ATUALIZAR
            lista=comarcas.findAll();
            lista.forEach(c->{
                c.setNome(c.getNome()+ " Atualizado");
                c.setTipo(c.getTipo()+ " Atualizado");
                comarcas.save(c);
            });
            lista = comarcas.findAll();
            lista.forEach(System.out::println);

            //********** BUSCAR
            lista = comarcas.findByNomeLike("mb");
            if(!lista.isEmpty()) {
                lista.forEach(c -> {
                    System.out.println(c.getNome());
                });
            }else{
                System.out.println("Lista vazia");
            }

            // ********** APAGAR TODOS

            System.out.println("Deletando ...");
            lista = comarcas.findAll();
            lista.forEach(c->{
                comarcas.delete(c);
            });
            lista = comarcas.findAll();
            if(lista.isEmpty()){
                System.out.println("Dados apagados");
            }else{
                System.out.println("Erro ao apagar");
            }

           //  ******** LISTAR
            lista = comarcas.findAll();
            lista.forEach(System.out::println);
        };
    }



