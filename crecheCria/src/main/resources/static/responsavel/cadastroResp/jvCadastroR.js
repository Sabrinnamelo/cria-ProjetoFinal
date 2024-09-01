var form = document.querySelector("#form");
form.addEventListener("submit", enviarDados);


function enviarDados(event) {
    event.preventDefault();

    const dados = new FormData(event.target);

    let jsonDados = {
        nome: dados.get("nome"),
        cpf: dados.get("cpf"),
        dataNascimento: dados.get("dataNascimento"),
        email: dados.get("email"),
        telefone: dados.get("telefone"),
        rg: dados.get("rg"),
      
        endereco: {
            cep: dados.get("cep"),
            estado: dados.get("estado"),
            cidade: dados.get("cidade"),
            rua: dados.get("rua"),
            bairro: dados.get("bairro"),
            numero: dados.get("numero")
        } ,
          profissao : dados.get("profissao"),
        estadoCivil : dados.get("estadoCivil"),
    };

    fetch("http://localhost:8080/responsavel", {
        method: 'POST',
        body: JSON.stringify(jsonDados),
        headers: { 'Content-Type': 'application/json' }
    })
    .then(resposta => resposta.json())
    .then(retorno => {
        console.log(retorno);
        document.location.reload(true);
    })
    .catch(erro => console.log(erro));
}
