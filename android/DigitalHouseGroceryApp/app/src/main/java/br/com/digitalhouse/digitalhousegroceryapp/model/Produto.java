package br.com.digitalhouse.digitalhousegroceryapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = ListaCompras.class,
        parentColumns = "id",
        childColumns = "lista_compras_id"))
public class Produto {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo
    private String descricao;

    @ColumnInfo
    private float quantidade;

    @ColumnInfo
    private String unidade;

    @ColumnInfo
    private boolean comprado;

    @ColumnInfo(name = "lista_compras_id")
    public int listaComprasId;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getListaComprasId() {
        return listaComprasId;
    }

    public void setListaComprasId(int listaComprasId) {
        this.listaComprasId = listaComprasId;
    }
}
