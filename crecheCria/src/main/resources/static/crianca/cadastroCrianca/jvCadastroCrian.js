var form = document.querySelector("#cadastroCrianca");

form.addEventListener("submit", enviarDados);

function enviarDados(event) {
    event.preventDefault();

    const dados = new FormData(event.target);

    // Aqui, estou assumindo que você já tenha os IDs dos objetos responsavel e responsavelRetirada.
    // Eles podem ser coletados a partir de inputs escondidos ou de uma API que retorna os IDs corretos.
    let idResponsavel = dados.get("responsavel");
    let idsResponsavelRetirada = dados.get("responsavelRetirada").split(','); // Supondo que seja uma lista de IDs separada por vírgulas

    let jsonDados = {
        nome: dados.get("nome"),
        genero: dados.get("genero"),
        cpf: dados.get("cpf"),
        sus: dados.get("sus"),
        certidaoNascimento: dados.get("certidaoNascimento"),
        nis: dados.get("nis"),
        dataNascimento: dados.get("dataNascimento"),
        responsavel: {
            id: idResponsavel
        },
        responsavelRetirada: idsResponsavelRetirada.map(id => ({ id: id })),
        saudeCrianca: {
            alergia: dados.get("alergia"),
            laudo: dados.get("laudo"),
            observacao: dados.get("observacao")
        }
    };

    fetch("http://localhost:8080/crianca", {
        method: 'POST',
        body: JSON.stringify(jsonDados),
        headers: { 'Content-Type': 'application/json' }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao cadastrar a criança');
        }
        return response.json();
    })
    .then(data => {
        console.log('Cadastro realizado com sucesso:', data);
        alert('Cadastro realizado com sucesso!');
        form.reset();
    })
    .catch(error => {
        console.error('Erro:', error);
        alert('Erro ao realizar o cadastro. Verifique os dados e tente novamente.');
    });
}
