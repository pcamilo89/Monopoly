/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Camilo
 */
public class Jugador {
    private User user;
    private int posicion;
    private int saldo;
    private int contCarcel;
    
    public Jugador(){
        this.user = null;
        this.posicion = 0;
        this.saldo = 0;
        this.contCarcel = 0;
    }
    
    public Jugador(User user, int saldo){
        this.user = user;
        this.posicion = 0;
        this.saldo = saldo;
        this.contCarcel = 0;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getContCarcel() {
        return contCarcel;
    }

    public void setContCarcel(int contCarcel) {
        this.contCarcel = contCarcel;
    }

    @Override
    public String toString() {
        return "Jugador{" + "user=" + user + ", posicion=" + posicion + ", saldo=" + saldo + ", contCarcel=" + contCarcel + '}';
    }
    
    
}
