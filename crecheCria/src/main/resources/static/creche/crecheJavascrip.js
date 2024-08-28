
var form = document.querySelector("#cadastro-form");

form.addEventListener("submit", enviarDados);

function enviarDados(event) {
  event.preventDefault();

  const dados = new FormData(event.target);

  let jsonC = {};
  dados.forEach((valor, chave) => {
    jsonC[chave] = valor;
  });

   fetch("http://localhost:8080/creche", {
    method: 'POST', 
    body: JSON.stringify(jsonC), 
    headers: {'Content-Type': 'application/json'}
    })

   .then(resposta => resposta.json())
   .then(creche => {console.log(creche)
   document.location.reload(true);
   })
   .catch(erro => console.log(erro))
}





