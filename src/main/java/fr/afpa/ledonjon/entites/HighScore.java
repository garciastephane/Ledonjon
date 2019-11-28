package fr.afpa.ledonjon.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HighScore {
	private String namePlayer;
	private int score;
}
