package controller;

import controller.Memento;

public interface command {
    public Memento execute();
}
