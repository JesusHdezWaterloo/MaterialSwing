package com.jhw.swing.util.interfaces;

/**
 * Interfaz a implementar por los paneles que van a trabajar con la creación y
 * edición de modelos, incluye metodos basicos para su trabajo.
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 * @param <T> Tipo de Modelo que va a trabajar.
 */
public interface ModelablePanel<T> {

    public T getNewModel();

    public T getOldModel();

    public void setOldModel(T model);

    public T onDeleteAction();

    public T onCreateAction();

    public boolean onCancelAction();

    public T onPostCreateAction(T obj);

    public T onPostDeleteAction(T obj);
}
