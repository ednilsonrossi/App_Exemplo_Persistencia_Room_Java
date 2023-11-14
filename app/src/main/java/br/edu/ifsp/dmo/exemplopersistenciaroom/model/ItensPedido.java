package br.edu.ifsp.dmo.exemplopersistenciaroom.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = {"id_pedido", "id_item"})
public class ItensPedido {

    @ColumnInfo(name = "id_pedido")
    private int idPedido;

    @ColumnInfo(name = "id_item")
    private int idItem;

    //construtor, gets e sets
}
