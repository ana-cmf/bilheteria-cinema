package model;

import dto.TipoDeEntradaDTO;

public enum TipoDeEntrada {
    _MEIA,
    _INTEIRA;

    public TipoDeEntradaDTO toDTO() {
        TipoDeEntradaDTO dto = new TipoDeEntradaDTO();
        dto.setTipo(this.name());
        return dto;
    }
 public static TipoDeEntrada fromDTO(TipoDeEntradaDTO dto) {
    if (dto == null || dto.getTipo() == null) {
        return null;
    }
    return TipoDeEntrada.valueOf(dto.getTipo()); // Converte a string para o enum correspondente
}
        
}
