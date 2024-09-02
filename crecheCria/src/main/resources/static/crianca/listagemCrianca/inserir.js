var form = document.querySelector("#cadastroCrianca");

const formRR = document.querySelector("#cadastrar-RR");
formRR.addEventListener("submit", enviarDados);

const idCrianca = new URL(location.href).searchParams.get("id");

function enviarDados(event) {
    event.preventDefault();
  
    const dados = new FormData(event.target);
  
    let jsonDados = {};
    dados.forEach((valor, chave) => {
        jsonDados[chave] = valor;
    });

    const idResponsavelRetirada = formRR.querySelector("#responsavelRetirada").value;
    jsonDados['id'] = idResponsavelRetirada;

    fetch(`http://localhost:8080/crianca/responsavel/${idCrianca}`, {
      method: 'PUT',
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

function obterDados(){
    fetch(`http://localhost:8080/crianca/${idCrianca}`)
    .then(resposta => resposta.json())
    .then(crianca => {
        form.querySelector('#nome').value = crianca.nome;
        form.querySelector('#cpf').value = crianca.cpf;

        const corpoTB = document.querySelector("#tb-responsavelR ");
        
        crianca.responsavelRetirada.forEach(dadosResponsavelRetirada => {
            console.log(dadosResponsavelRetirada);
            corpoTB.innerHTML += 
            `<tr>
                <td>${dadosResponsavelRetirada.id}</td>
                <td>${dadosResponsavelRetirada.nome}</td> 
                <td>${dadosResponsavelRetirada.cpf}</td>
                <td>${dadosResponsavelRetirada.endereco.cidade}</td>

            </tr>`;
        });
    })
    .catch(erro => console.log(erro));
}

function preencherSelect(){
    fetch("http://localhost:8080/responsavelRetirada")
    .then(resposta => resposta.json())
    .then(responsaveisR => {
        console.log(responsaveisR);
        const select = formRR.querySelector("#responsavelRetirada");
        select.innerHTML = responsaveisR.map(responsavelRetirada => 
            `<option value='${responsavelRetirada.id}'>${responsavelRetirada.nome}</option>`
        ).join('');
    })
    .catch(erro => console.log(erro));
}

preencherSelect();
obterDados();
