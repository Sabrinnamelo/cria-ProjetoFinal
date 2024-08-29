var form = document.querySelector("#cadastroCrianca");

form.addEventListener("submit", enviarDados);

function enviarDados(event) {
    event.preventDefault();

    const dados = new FormData(event.target);

    let jsonDados = {};

    dados.forEach((valor, chave) => {
        if (chave === 'responsavel') {
            jsonDados[chave] = { id: valor };  
        } else {
            jsonDados[chave] = valor;  
        }
    });

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
        form.reset();  // Reseta o formulário após o sucesso
    })
    .catch(error => {
        console.error('Erro:', error);
        alert('Erro ao realizar o cadastro. Verifique os dados e tente novamente.');
    });
}
