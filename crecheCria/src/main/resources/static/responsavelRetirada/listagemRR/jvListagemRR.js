function obterDados() {
    fetch("http://localhost:8080/responsavelRetirada")
        .then(resposta => resposta.json())
        .then(retorno => {
            const corpoTB = document.querySelector("#tb-form tbody");
            corpoTB.innerHTML = ''; // Limpa a tabela antes de popular
            retorno.forEach(item => {
                corpoTB.innerHTML +=
                    `<tr>
                <td>${item.id}</td>
                <td>${item.nome}</td>
                <td>${item.cpf}</td>
                <td>${item.email}</td>
                <td>${item.endereco.cidade}</td>
                    <td>
                    <button class="btn-editar" onclick='abrirModalEdicao(${JSON.stringify(item)})'>Editar</button>
                    <button class="btn-deletar" onclick='deletarTurma(${item.id})'>Deletar</button>
                    </td>
            </tr>`;
            });
        })
        .catch(erro => console.log(erro));
}


function deletarTurma(id) {
    fetch(`http://localhost:8080/responsavelRetirada/${id}`, {
        method: 'DELETE'
    })
    .then(() => {
        document.location.reload(true); // Recarrega a página para atualizar a lista
    })
    .catch(erro => console.log(erro));
}

function abrirModalEdicao(item) {
    const modal = document.getElementById("editModal");
    modal.style.display = "block";

    // Preenche o formulário com os dados do item
    document.getElementById("edit-id").value = item.id;
    document.getElementById("edit-nome").value = item.nome;
    document.getElementById("edit-cpf").value = item.cpf;
    document.getElementById("edit-email").value = item.email;
    document.getElementById("edit-cidade").value = item.endereco.cidade;
    document.getElementById("edit-endereco").value = item.endereco.cep; // Supondo que o endereço tenha esse campo
    document.getElementById("edit-telefone").value = item.telefone; // Supondo que exista o campo telefone
}

function salvarEdicao() {
    const id = document.getElementById("edit-id").value;
    const nome = document.getElementById("edit-nome").value;
    const cpf = document.getElementById("edit-cpf").value;
    const email = document.getElementById("edit-email").value;
    const cidade = document.getElementById("edit-cidade").value;
    const logradouro = document.getElementById("edit-endereco").value;
    const telefone = document.getElementById("edit-telefone").value;

    fetch(`http://localhost:8080/responsavelRetirada/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            id,
            nome,
            cpf,
            email,
            endereco: { cidade, logradouro },
            telefone
        })
    })
    .then(() => {
        document.location.reload(true);
    })
    .catch(erro => console.log(erro));
}

window.onclick = function(event) {
    const modal = document.getElementById("editModal");
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
obterDados();
