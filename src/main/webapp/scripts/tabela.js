function exibirParticipantes(data) {

    // limpa o conteúdo da tabela
    $("main > section > table > tbody").empty();
    // para cada resultado da consulta, execulta as instruções
    $.each(data, function (index, value) {

        // monta a linha com conteúdo, botão para alterar os dados (este com o componente tooltip e um botão para apagar os dados
        var dados = "<tr scope=\"row\"" +
            "" +
            ">";
        dados += "<td><div class='btn btn-primary w-100' data-toggle=\"tooltip\" data-placement=\"top\" title=\"Editar o projeto " + value.nome + "\" role=\"button\" data-participante='" + value.idParticipante + "'>" + value.idParticipante + "</div> </td>";
        dados += "<td>" + value.nome + "</td>";
        dados += "<td>" + value.cargo + "</td>";
        dados += "<td><div data-deletar='" + value.idParticipante + "' class='btn btn-danger'>Apagar</div></td>";
        dados += "</tr>";
        //adiciona as instruções no corpo da tabela
        $("main > section > table > tbody").append(dados);
    });
    // limpa o loading
    $("#loading").empty();


    //criado os atributos do tipo data para facilitar a leitura por jquery

    $("td > div[data-participante]").click(function () {
        var id = $(this).data("participante");
        // registra o id no storege do browser
        sessionStorage.setItem("idParticipante", id);
        var loc = window.location;
        location.href = loc.protocol + '//' + loc.host + "/projeto-projetistas-ajax/formParticipante.html";
    });
    // altera o ponteiro do mouse
    $("div[data-deletar]").mouseover(function () {
        // muda o ponteiro do mouse somente para a celula que está sendo posicionada
        $(this).css("cursor", "pointer");
    });

    // faz a chamada para deletar caso tenha sido clicada
    $("div[data-deletar]").click(function () {
        // passa por parâmetro o id que esta no atributo data-deletar
        var valor = $(this).data("deletar");
        bootbox.confirm({
            message: 'Confirma a exclusão do registro?',
            callback: function (confirmacao) {
                if (confirmacao) {
                    deletarDados(valor);

                } else {
                    bootbox.alert('Operação cancelada.');
                    $("#loading").empty();
                }

            },
            buttons: {
                cancel: {label: 'Cancelar', className: 'btn-default'},
                confirm: {label: 'EXCLUIR', className: 'btn-danger'}

            }
        });
    });

    // habilita o tooltip
    $('[data-toggle="tooltip"]').tooltip();
}
