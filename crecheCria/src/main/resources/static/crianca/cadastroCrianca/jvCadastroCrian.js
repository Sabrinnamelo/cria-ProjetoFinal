const form = document.querySelector("#cadastroCrianca");
let responsavel = {};

function enviarDados(event) {
  event.preventDefault();

  const formData = new FormData(form);

  const dadosCrianca = {
    nome: formData.get("nome"),
    genero: formData.get("genero"),
    cpf: formData.get("cpf"),
    sus: formData.get("sus"),
    certidaoNascimento: formData.get("certidaoNascimento"),
    nis: formData.get("nis"),
    dataNascimento: "23/02/2005",
    responsavel: responsavel,
    saudeCrianca: {
      alergia: formData.get("alergia"),
      laudo: formData.get("laudo"),
      observacao: formData.get("observacao"),
    },
  };
console.log(dadosCrianca)
  fetch("http://localhost:8080/crianca", {
    method: "POST",
    body: JSON.stringify(dadosCrianca),
    headers: { "Content-Type": "application/json" },
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("Erro ao cadastrar a criança");
      }
      return response.json();
    })
    .then((data) => {
      console.log("Cadastro realizado com sucesso:", data);
      alert("Cadastro realizado com sucesso!");
      form.reset();
    })
    .catch((error) => {
      console.error("Erro:", error);
      alert(
        "Erro ao realizar o cadastro. Verifique os dados e tente novamente."
      );
    });
}

async function fetchResPorID(idRes) {
	console.log(idRes)
  try {
    const response = await fetch(
      `http://localhost:8080/responsavel/${idRes}`
    );
    const data = await response.json();
    responsavel = { id: data.id, nome: data.nome };
  } catch (error) {
    console.error("Erro ao buscar dados:", error);
  }
}

async function fetchResponsaveis() {
  const selectRes = document.querySelector("#selectResponsavel");

  try {
    const response = await fetch("http://localhost:8080/responsavel");
    const data = await response.json();

    selectRes.innerHTML = '<option value="">Selecione...</option>';

    data.forEach((responsavel) => {
      const option = document.createElement("option");
      option.value = responsavel.id;
      option.textContent = responsavel.nome;
      selectRes.appendChild(option);
    });

    selectRes.addEventListener("change", async (event) => {
      const selectedId = event.target.value;
      if (selectedId) {
        await fetchResPorID(selectedId);
      }
    });
  } catch (error) {
    console.error("Erro ao buscar dados:", error);
  }
}

form.addEventListener("submit", enviarDados);
document.addEventListener("DOMContentLoaded", fetchResponsaveis);