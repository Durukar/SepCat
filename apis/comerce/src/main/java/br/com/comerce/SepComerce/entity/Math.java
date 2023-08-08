package br.com.comerce.SepComerce.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Math {

    private Double n1;
    private Double n2;

    public Math(){
    }

    public Math(Double n1, Double n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
}
