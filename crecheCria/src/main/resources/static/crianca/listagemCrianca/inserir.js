var form = document.querySelector("#cadastroCrianca");
var formRR = document.querySelector("#cadastrar-RR");



formRR.addEventListener("submit", enviarDados);




const idCrianca = new URL(location.href).searchParams.get("id");

function enviarDados(event) {
    event.preventDefault();
  
    const dados = new FormData(event.target);
  
    let jsonDados = {};
    dados.forEach((valor, chave) => {
        jsonDados[chave] = valor;
    });
  

    fetch(`http://localhost:8080/crianca/responsavel/${idCrianca}`, {
      method: 'PUT',
      body: JSON.stringify(jsonDados),
      headers: { 'Content-Type': 'application/json' }
    })
  
      .then(resposta => resposta.json())
      .then(retorno => {
        console.log(retorno)
        document.location.reload(true);
      })
      .catch(erro => console.log(erro))
  }



function obterDados(){
    fetch(`http://localhost:8080/crianca/${idCrianca}`)
    .then(resposta => resposta.json())
    .then(crianca => {


        form.querySelector('#nome').value = crianca.nome;
        form.querySelector('#cpf').value = crianca.cpf;



        const corpoTB = document.querySelector("#tb-responsavelR tbody");
        crianca.responsavelRetirada.forEach( responsavelR =>{
            corpoTB.innerHTML += 
            `<tr>
            
                <td>${responsavelR.id}</td>
                <td>${responsavelR.nome}</td>
                <td>${responsavelR.cpf}</td>

            </tr>`
        })
    })
    .catch(erro => console.log(erro))
}

obterDados();

