package vod.med.api.medico;

import vod.med.api.endereco.Endereco;
import vod.med.api.enums.Especialidade;

public record DadosDetalhamentoMedicoDTO(Long id, String nome, String email, String crm, String telefone,Especialidade especialidade, Endereco endereco) {
    public DadosDetalhamentoMedicoDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
