package br.edu.fatecfranca.api.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Document(collection = "matriculas")
public class Matricula {

    @Id
    private String id;

    private String alunoId;
    private String turmaId;

    @NotBlank(message = "A data da matrícula é obrigatória.")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "A data deve estar no formato AAAA-MM-DD.")
    private String data;

    @NotBlank(message = "A situação da matrícula é obrigatória.")
    @Pattern(regexp = "ativa|concluída|cancelada", message = "A situação deve ser ativa, concluída ou cancelada.")
    private String situacao;

    @Valid
    private List<Nota> notas;

    public Matricula() {
    }

    public Matricula(
            String id,
            String alunoId,
            String turmaId,
            String data,
            String situacao,
            List<Nota> notas) {
        this.id = id;
        this.alunoId = alunoId;
        this.turmaId = turmaId;
        this.data = data;
        this.situacao = situacao;
        this.notas = notas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(String alunoId) {
        this.alunoId = alunoId;
    }

    public String getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(String turmaId) {
        this.turmaId = turmaId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
}