

function obterDados(){
    fetch("http://localhost:8080/crianca")
    .then(resposta => resposta.json())
    .then(retorno => {
		console.log(retorno)
        const corpoTB = document.querySelector("#tb-crianca tbody");
        			corpoTB.innerHTML ="";

        retorno.forEach( item =>{
            corpoTB.innerHTML += 
            
            `<tr>
            
                <td>${item.id}</td>
                <td>${item.nome}</td>
                <td>${item.saudeCrianca.laudo}</td>
                <td><a href ="inserirResRet.html?id=${item.id}" > Ver Lista </td>
                 <td>
                        <button class="btn-editar">Editar</button>
                    <button class="btn-deletar" onclick='deletar(${item.id})'>Deletar</button>

                    </td>

            </tr>`
        })
    })
    .catch(erro => console.log(erro))
}

obterDados();


function deletar(id) {
  fetch(`http://localhost:8080/crianca/${id}`, {
    method: 'DELETE',
  })
  .then(() => {
    document.location.reload(true);
  })
  .catch(erro => console.log(erro));
}


