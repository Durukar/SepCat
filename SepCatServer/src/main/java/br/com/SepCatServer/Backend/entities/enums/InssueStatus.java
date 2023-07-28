package br.com.SepCatServer.Backend.entities.enums;

public enum InssueStatus {

    ABERTO(1),
    FECHADO(2),
    RASCUNHO(3);

    private int code;

    private InssueStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static InssueStatus valueOf(int code) {
        for (InssueStatus value : InssueStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid InssueStatus code");
    }
}
