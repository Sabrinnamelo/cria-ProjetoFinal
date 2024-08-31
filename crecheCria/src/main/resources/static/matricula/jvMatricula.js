// Seleciona o formulário de matrícula
var formMatricula = document.querySelector("#form-sobrep");

// Inicializa as entidades relacionadas
let crianca = {};
let professora = {};
let turma = {};
let creche = {};

// Função para enviar os dados do formulário
function enviarDados(event) {
  event.preventDefault();

  const dados = new FormData(event.target);

  let jsonMatricula = {
    anoLetivo: dados.get("anoLetivo"),
    status: dados.get("status"),
    crianca: crianca,
    professora: professora,
    turma: turma,
    creche: creche,
  };

  console.log(jsonMatricula);

  fetch("http://localhost:8080/matricula", {
    method: 'POST',
    body: JSON.stringify(jsonMatricula),
    headers: { 'Content-Type': 'application/json' },
  })
    .then(resposta => resposta.json())
    .then(matricula => {
      console.log("Matrícula cadastrada com sucesso:", matricula);
      document.location.reload(true);
    })
    .catch(erro => {
      console.error("Erro ao cadastrar matrícula:", erro);
      alert("Erro ao cadastrar matrícula. Verifique os dados e tente novamente.");
    });
}

// Função para obter e listar as matrículas
function obterDados() {
  fetch("http://localhost:8080/matricula")
    .then(resposta => resposta.json())
    .then(retorno => {
      const corpoTB = document.querySelector("#listarMatricula");
      corpoTB.innerHTML = ''; // Limpa as linhas existentes
      retorno.forEach(item => {
        corpoTB.innerHTML += `
          <tr>
            <td>${item.id}</td>
            <td>${item.anoLetivo}</td>
            <td>${item.status}</td>
            <td>${item.crianca.nome}</td>
            <td>${item.turma.sala}</td>
            <td>
              <button class="btn-editar">Editar</button>
              <button class="btn-deletar">Deletar</button>
            </td>
          </tr>`;
      });
    })
    .catch(erro => console.error("Erro ao obter dados:", erro));
}

// Função para abrir o modal
var modal = document.getElementById("myModal");
var btn = document.getElementById("openModal");
var span = document.getElementsByClassName("close")[0];

btn.onclick = function () {
  modal.style.display = "block";
};

// Função para fechar o modal ao clicar no "x"
span.onclick = function () {
  modal.style.display = "none";
};

// Função para fechar o modal ao clicar fora dele
window.onclick = function (event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

// Função para buscar os dados de uma criança pelo ID
async function fetchCriPorID(idCri) {
  try {
    const response = await fetch(`http://localhost:8080/crianca/${idCri}`);
    const data = await response.json();
    crianca = { id: data.id, nome: data.nome };
  } catch (error) {
    console.error("Erro ao buscar dados da criança:", error);
  }
}

// Função para buscar todas as crianças e preencher o select
async function fetchCrianca() {
  const selectRes = document.querySelector("#selectCrianca");

  try {
    const response = await fetch("http://localhost:8080/crianca");
    const data = await response.json();

    selectRes.innerHTML = '<option value="">Selecione...</option>';

    data.forEach(crianca => {
      const option = document.createElement("option");
      option.value = crianca.id;
      option.textContent = crianca.nome;
      selectRes.appendChild(option);
    });

    selectRes.addEventListener("change", async (event) => {
      const selectedId = event.target.value;
      if (selectedId) {
        await fetchCriPorID(selectedId);
      }
    });
  } catch (error) {
    console.error("Erro ao buscar dados das crianças:", error);
  }
}

// Função para buscar os dados de uma professora pelo ID
async function fetchProPorID(idProf) {
  try {
    const response = await fetch(`http://localhost:8080/professora/${idProf}`);
    const data = await response.json();
    professora = { id: data.id, nome: data.nome };
  } catch (error) {
    console.error("Erro ao buscar dados da professora:", error);
  }
}

// Função para buscar todas as professoras e preencher o select
async function fetchProfessora() {
  const selectRes = document.querySelector("#selectProfessora");

  try {
    const response = await fetch("http://localhost:8080/professora");
    const data = await response.json();

    selectRes.innerHTML = '<option value="">Selecione...</option>';

    data.forEach(professora => {
      const option = document.createElement("option");
      option.value = professora.id;
      option.textContent = professora.nome;
      selectRes.appendChild(option);
    });

    selectRes.addEventListener("change", async (event) => {
      const selectedId = event.target.value;
      if (selectedId) {
        await fetchProPorID(selectedId);
      }
    });
  } catch (error) {
    console.error("Erro ao buscar dados das professoras:", error);
  }
}

// Função para buscar os dados de uma turma pelo ID
async function fetchTurmaPorID(idTurma) {
  try {
    const response = await fetch(`http://localhost:8080/turma/${idTurma}`);
    const data = await response.json();
    turma = { id: data.id, sala: data.sala };
  } catch (error) {
    console.error("Erro ao buscar dados da turma:", error);
  }
}

// Função para buscar todas as turmas e preencher o select
async function fetchTurma() {
  const selectRes = document.querySelector("#selectTurma");

  try {
    const response = await fetch("http://localhost:8080/turma");
    const data = await response.json();

    selectRes.innerHTML = '<option value="">Selecione...</option>';

    data.forEach(turma => {
      const option = document.createElement("option");
      option.value = turma.id;
      option.textContent = turma.sala;
      selectRes.appendChild(option);
    });

    selectRes.addEventListener("change", async (event) => {
      const selectedId = event.target.value;
      if (selectedId) {
        await fetchTurmaPorID(selectedId);
      }
    });
  } catch (error) {
    console.error("Erro ao buscar dados das turmas:", error);
  }
}

// Função para buscar todos os creches e preencher o select
async function fetchCreche() {
  const selectRes = document.querySelector("#selectCreche");

  try {
    const response = await fetch("http://localhost:8080/creche");
    const data = await response.json();

    selectRes.innerHTML = '<option value="">Selecione...</option>';

    data.forEach(creche => {
      const option = document.createElement("option");
      option.value = creche.id;
      option.textContent = creche.nome;
      selectRes.appendChild(option);
    });

    selectRes.addEventListener("change", async (event) => {
      const selectedId = event.target.value;
      if (selectedId) {
        await fetchCrePorID(selectedId);
      }
    });
  } catch (error) {
    console.error("Erro ao buscar dados das creches:", error);
  }
}

// Função para buscar os dados de uma creche pelo ID
async function fetchCrePorID(idCreche) {
  try {
    const response = await fetch(`http://localhost:8080/creche/${idCreche}`);
    const data = await response.json();
    creche = { id: data.id, nome: data.nome };
  } catch (error) {
    console.error("Erro ao buscar dados da creche:", error);
  }
}

// Carrega dados ao carregar a página
document.addEventListener("DOMContentLoaded", () => { 
  fetchCrianca(); 
  fetchProfessora();
  fetchTurma();
  fetchCreche();
});

// Adiciona evento para enviar dados ao submeter o formulário
formMatricula.addEventListener("submit", enviarDados);

// Obtém e exibe os dados iniciais da tabela de matrículas
obterDados();
