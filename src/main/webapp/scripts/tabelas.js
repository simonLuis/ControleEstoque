$(document).ready(function () {
    carregarProdutos();

    carregarRelatorio();

});
function carregarProdutos() {
    // lista todos os participantes da base
    $.ajax({
        url: '/ControleEstoqueJavaWeb/ServletProduto/',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            const table = $("<table>");
            $.each(data, function (index, value) {
                var dados = "<tr>";
                dados += "<td>" + value.nomeProduto + "</td>";
                dados += "<td>" + value.medida + "</td>";
                dados += "<td>" + value.qtdProduto + "</td>";
                dados += "<td>" + value.preco + "</td>";
                dados += "<td>" + value.solicitar + "</td>";
                dados += "</tr>";
                table.append(dados);
            });
            $("#resposta").empty();
            $("container-produto").append(table);
            // função que contém os comandos para montar a tabela selecionável
            configurarTabela();

        },
        error: function () {
            $("#resposta").empty();
            $("#resposta").html("Erro ao executar a consulta!");
        }
    });

}

function configurarTabela() {
    // adiciona a biblioteca de formatação para tabela
    var table = $('#container-produto').DataTable();

    // aplica configuração de layout para os campos
    $("input[type=text], input[type=text], input[type=text], input[type=text], input[type=number]").addClass("form-control").css("margin-left", "0em");
    $("label").css("text-align", "left");
    $("select").addClass("custom-select").addClass("mr-sm-2");

    // adiciona click na linha no conteúdo da tabela
    $('#container-produto tbody').on('click', 'tr', function () {
        //realiza o efeito de selecionar a linha e retirar seleção
        $(this).toggleClass('selected');
    });


}

function formatData(data) {
    //formato yyyy-mm-dd
    var arrayData = data.split("-");
    return arrayData[2] + "/" + arrayData[1] + "/" + arrayData[0];

}

function formatDataRetorno(data) {
    //formato dd/mm/yyyy
    var arrayData = data.split("/");
    return arrayData[2] + "-" + arrayData[1] + "-" + arrayData[0];

}

function criarRelatorio(event) {
        var produto = new Array();
        var table = $('#container-produto').DataTable();
        // criar o array de participantes selecionados
        $.each(table.rows('.selected').data(), function (index, value) {
            var prod = {
                "idParticipante": value[0]
            };
            participantes.push(partci);
        });

        // monta o objeto json para envio no serviço
        projeto = {
            "descricao": $("#idDescricao").val(),
            "dataInicio": formatData($("#idInicio").val()),
            "dataFim": formatData($("#idFim").val()),
            "percentualConcluido": $("#idPercConcluido").val(),
            "situacao": $("#idsituacao").val(),
            "participantes": participantes.slice()
        };
        var idProjeto = $("#idProjeto").val();

        // dados para a criação de um novo
        var tipo = "POST";
        var url = "http://172.26.16.1:9192/projeto/projeto/";
        var msg = "Registro Cadastrado com sucesso";

        if ($.isNumeric(idProjeto)) {
            //se existir um ID, altera os dados da requisição para realizar uma chamada de alteração
            url += idProjeto;
            tipo = "PUT";
            msg = "Registro Alterado com sucesso";
        }

        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url: url,
            type: tipo,
            dataType: 'json',
            data: JSON.stringify(projeto),
            success: function (data) {
                bootbox.alert(msg, function () {
                    var loc = window.location;
                    location.href = loc.protocol + '//' + loc.host + "/projeto-projetistas-ajax/projetos.html";
                });
                $("#resposta").show();
                $("#resposta").html(msg);


            },
            beforeSend: function () {
                $("#resposta").show();
                $("#resposta").html("<img style='width: 100px; heigth: 100px' src='img/tenor.gif'</img>")

            },
            error: function () {
                $("#resposta").show();
                $("#resposta").html("Erro ao cadastrar o Projeto");
            }
        });
    }

}


function carregarProjeto() {
    //Verifica se existe uma informação válida no stoge do browser
    if ($.isNumeric(sessionStorage.getItem("idProjeto"))) {
        // realiza a consulta via serviço
        $.ajax({
            url: 'http://172.26.16.1:9192/projeto/proj/' + sessionStorage.getItem("idProjeto"),
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                // limpa a storege para um novo dado
                sessionStorage.setItem("idProjeto", "");
                $("#idProjeto").val(data.idProjeto);
                $("#idDescricao").val(data.descricao);
                $("#idInicio").val(formatDataRetorno(data.dataInicio));
                $("#idFim").val(formatDataRetorno(data.dataFim));
                $("#idPercConcluido").val(data.percentualConcluido);
                $("#idsituacao").val(data.situacao);
                // percorre o array com a lista de participantes do projeto
                $.each(data.participantes, function (index, value) {
                    // busca na tabela html o ID do participante se for igual ao do projeto seleciona a linha
                    $("#participantes > tbody").find("tr").each(function () {
                        if ($(this).find("td").eq(0).text() == value.idParticipante) {
                            $(this).toggleClass('selected');
                        }
                    });
                });


            },
            beforeSend: function () {
                $("#resposta").show();
                $("#resposta").html("<img style='width: 100px; heigth: 100px' src='img/tenor.gif'</img>")

            },
            error: function () {
                $("#resposta").show();
                $("#resposta").html("Erro ao cadastrar o Participante");
            }
        });
    }
}