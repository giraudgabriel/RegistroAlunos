package edu.fatec.sjc.lp2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Prova {
	private Double nota;
	private Double peso;
}
