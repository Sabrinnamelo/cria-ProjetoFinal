
var formT = document.querySelector("#form-sobrep");

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


function obterDados() {
  fetch("matricula")
    .then(resposta => resposta.json())
    .then(retorno => {
      const corpoTB = document.querySelector("#matricula-table tbody");
      retorno.forEach(item => {
        corpoTB.innerHTML +=
          `<tr>
            
                <td>${item.id}</td>
                <td>${item.anoLetivo}</td>
                <td>${item.status}</td>
                <td>${item.crianca.nome}</td>
                <td>${item.turma.sala}</td>
                   <td>
                        <button class="btn-editar">Editar</button>
                        <button class="btn-deletar">Deletar</button>

                    </td>
            </tr>`
      })
    })
    .catch(erro => console.log(erro))
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