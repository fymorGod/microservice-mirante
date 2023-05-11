package vod.med.api.medico;

import jakarta.validation.constraints.NotNull;
import vod.med.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {

}
