
var formT = document.querySelector("#form-turma");

formT.addEventListener("submit", enviarDados);

function enviarDados(event) {
  event.preventDefault();

  const dados = new FormData(event.target);

  let jsonTurma = {};
  dados.forEach((valor, chave) => {
    jsonTurma[chave] = valor;
  });

  fetch(event.target.action, {
    method: 'POST',
    body: JSON.stringify(jsonTurma),
    headers: { 'Content-Type': 'application/json' }
  })

    .then(resposta => resposta.json())
    .then(turma => {
      console.log(turma)
      document.location.reload(true);
    })
    .catch(erro => console.log(erro))
}



function deletarTurma(id) {
  fetch(`http://localhost:8080/turma/${id}`, {
    method: 'DELETE',
  })
  .then(() => {
    document.location.reload(true);
  })
  .catch(erro => console.log(erro));
}


// Função para abrir o modal de edição
function abrirModalEdicao(turma) {
    var modal = document.getElementById("editModal");
    modal.style.display = "block";

    document.getElementById("edit-id").value = turma.id;
    document.getElementById("edit-sala").value = turma.sala;
    document.getElementById("edit-horario").value = turma.horario;
    document.getElementById("edit-turno").value = turma.turno;
}

// Fecha o modal de edição ao clicar no "x"
var spanEdit = document.getElementsByClassName("close-edit")[0];
spanEdit.onclick = function () {
    var modal = document.getElementById("editModal");
    modal.style.display = "none";
}


// Função para enviar os dados editados
document.querySelector("#form-editar-turma").addEventListener("submit", function(event) {
    event.preventDefault();

    const dadosEditados = new FormData(event.target);
    let turmaEditada = {};
    dadosEditados.forEach((valor, chave) => {
        turmaEditada[chave] = valor;
    });

    fetch(`http://localhost:8080/turma`, {
        method: 'PUT',
        body: JSON.stringify(turmaEditada),
        headers: { 'Content-Type': 'application/json' }
    })
    .then(resposta => resposta.json())
    .then(turma => {
        console.log("Turma atualizada:", turma);
        document.location.reload(true);
    })
    .catch(erro => console.log(erro));
});

//  os dados da turma
function obterDados() {
    fetch("http://localhost:8080/turma")
    .then(resposta => resposta.json())
    .then(retorno => {
        const corpoTB = document.querySelector("#turmas-table tbody");
        retorno.forEach(item => {
            corpoTB.innerHTML +=
            `<tr>
                <td>${item.id}</td>
                <td>${item.sala}</td>
                <td>${item.horario}</td>
                <td>${item.turno}</td>
                <td>
                    <button class="btn-editar" onclick='abrirModalEdicao(${JSON.stringify(item)})'>Editar</button>
                    <button class="btn-deletar" onclick='deletarTurma(${item.id})'>Deletar</button>
                </td>
            </tr>`;
        });
    })
    .catch(erro => console.log(erro));
}

obterDados();




// Abre o modal
var modal = document.getElementById("myModal");
var btn = document.getElementById("openModal");
var span = document.getElementsByClassName("close")[0];

btn.onclick = function () {
  modal.style.display = "block";
}

// Fecha o modal ao clicar no "x"
span.onclick = function () {
  modal.style.display = "none";
}

// Fecha o modal ao clicar fora dele
window.onclick = function (event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}