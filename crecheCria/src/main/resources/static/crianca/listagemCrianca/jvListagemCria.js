

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

                   <td>
                        <button class="btn-editar">Editar</button>
                        <button class="btn-deletar">Deletar</button>

                    </td>
                <td><a href ="inserirResRet.html?id=${item.id}" > responsaveis de retirada </td>

            </tr>`
        })
    })
    .catch(erro => console.log(erro))
}

obterDados();




