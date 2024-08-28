function obterDados() {
    fetch("http://localhost:8080/professora")
        .then(resposta => resposta.json())
        .then(retorno => {
            const corpoTB = document.querySelector("#tb-form tbody");
            retorno.forEach(item => {
                corpoTB.innerHTML +=
                    `<tr>
                <td>${item.id}</td>
                <td>${item.nome}</td>
                <td>${item.cpf}</td>
                <td>${item.email}</td>
                <td>${item.endereco.cidade}</td>
                    <td>
                        <button class="btn-editar">Editar</button>
                    <button class="btn-deletar" onclick='deletar(${item.id})'>Deletar</button>

                    </td>
            </tr>`
            })
        })
        .catch(erro => console.log(erro))
}

function deletar(id) {
  fetch(`http://localhost:8080/professora/${id}`, {
    method: 'DELETE',
  })
  .then(() => {
    document.location.reload(true);
  })
  .catch(erro => console.log(erro));
}


obterDados();

